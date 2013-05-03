package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SideOnly(Side.CLIENT)
public class ThreadDownloadResources extends Thread
{
    /** The folder to store the resources in. */
    public File resourcesFolder;

    /** A reference to the Minecraft object. */
    private Minecraft mc;

    /** Set to true when Minecraft is closing down. */
    private boolean closing = false;

    public ThreadDownloadResources(File par1File, Minecraft par2Minecraft)
    {
        this.mc = par2Minecraft;
        this.setName("Resource download thread");
        this.setDaemon(true);
        this.resourcesFolder = new File(par1File, "resources/");

        if (!this.resourcesFolder.exists() && !this.resourcesFolder.mkdirs())
        {
            throw new RuntimeException("The working directory could not be created: " + this.resourcesFolder);
        }
    }

    public void run()
    {
        try
        {
            URL url = new URL("http://s3.amazonaws.com/MinecraftResources/");
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            //Add a timeout of 60 seconds to getting the list, MC stalls without sound for some users.
            URLConnection con = url.openConnection();
            con.setConnectTimeout(60000);
            con.setReadTimeout(60000);
            Document document = documentbuilder.parse(con.getInputStream());
            NodeList nodelist = document.getElementsByTagName("Contents");

            for (int i = 0; i < 2; ++i)
            {
                for (int j = 0; j < nodelist.getLength(); ++j)
                {
                    Node node = nodelist.item(j);

                    if (node.getNodeType() == 1)
                    {
                        Element element = (Element)node;
                        String s = element.getElementsByTagName("Key").item(0).getChildNodes().item(0).getNodeValue();
                        long k = Long.parseLong(element.getElementsByTagName("Size").item(0).getChildNodes().item(0).getNodeValue());

                        if (k > 0L)
                        {
                            this.downloadAndInstallResource(url, s, k, i);

                            if (this.closing)
                            {
                                return;
                            }
                        }
                    }
                }
            }
        }
        catch (Exception exception)
        {
            this.loadResource(this.resourcesFolder, "");
            exception.printStackTrace();
        }
    }

    /**
     * Reloads the resource folder and passes the resources to Minecraft to install.
     */
    public void reloadResources()
    {
        this.loadResource(this.resourcesFolder, "");
    }

    /**
     * Loads a resource and passes it to Minecraft to install.
     */
    private void loadResource(File par1File, String par2Str)
    {
        File[] afile = par1File.listFiles();

        for (int i = 0; i < afile.length; ++i)
        {
            if (afile[i].isDirectory())
            {
                this.loadResource(afile[i], par2Str + afile[i].getName() + "/");
            }
            else
            {
                try
                {
                    this.mc.installResource(par2Str + afile[i].getName(), afile[i]);
                }
                catch (Exception exception)
                {
                    this.mc.getLogAgent().logWarning("Failed to add " + par2Str + afile[i].getName() + " in resources");
                }
            }
        }
    }

    /**
     * Downloads the resource and saves it to disk then installs it.
     */
    private void downloadAndInstallResource(URL par1URL, String par2Str, long par3, int par5)
    {
        try
        {
            int k = par2Str.indexOf("/");
            String s1 = par2Str.substring(0, k);

            if (s1.equalsIgnoreCase("sound3"))
            {
                if (par5 != 0)
                {
                    return;
                }
            }
            else if (par5 != 1)
            {
                return;
            }

            File file1 = new File(this.resourcesFolder, par2Str);

            if (!file1.exists() || file1.length() != par3)
            {
                file1.getParentFile().mkdirs();
                String s2 = par2Str.replaceAll(" ", "%20");
                this.downloadResource(new URL(par1URL, s2), file1, par3);

                if (this.closing)
                {
                    return;
                }
            }

            this.mc.installResource(par2Str, file1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Downloads the resource and saves it to disk.
     */
    private void downloadResource(URL par1URL, File par2File, long par3) throws IOException
    {
        byte[] abyte = new byte[4096];
        //Add a timeout of 60 seconds to getting the list, MC stalls without sound for some users.
        URLConnection con = par1URL.openConnection();
        con.setConnectTimeout(60000);
        con.setReadTimeout(60000);
        DataInputStream datainputstream = new DataInputStream(con.getInputStream());
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(par2File));
        boolean flag = false;

        do
        {
            int j;

            if ((j = datainputstream.read(abyte)) < 0)
            {
                datainputstream.close();
                dataoutputstream.close();
                return;
            }

            dataoutputstream.write(abyte, 0, j);
        }
        while (!this.closing);
    }

    /**
     * Called when Minecraft is closing down.
     */
    public void closeMinecraft()
    {
        this.closing = true;
    }
}
