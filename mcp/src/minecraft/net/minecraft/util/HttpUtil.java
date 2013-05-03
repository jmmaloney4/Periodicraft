package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.logging.ILogAgent;

public class HttpUtil
{
    /**
     * Builds an encoded HTTP POST content string from a string map
     */
    public static String buildPostString(Map par0Map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = par0Map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('&');
            }

            try
            {
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
            }

            if (entry.getValue() != null)
            {
                stringbuilder.append('=');

                try
                {
                    stringbuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException unsupportedencodingexception1)
                {
                    unsupportedencodingexception1.printStackTrace();
                }
            }
        }

        return stringbuilder.toString();
    }

    /**
     * Sends a HTTP POST request to the given URL with data from a map
     */
    public static String sendPost(ILogAgent par0ILogAgent, URL par1URL, Map par2Map, boolean par3)
    {
        return sendPost(par0ILogAgent, par1URL, buildPostString(par2Map), par3);
    }

    /**
     * Sends a HTTP POST request to the given URL with data from a string
     */
    public static String sendPost(ILogAgent par0ILogAgent, URL par1URL, String par2Str, boolean par3)
    {
        try
        {
            HttpURLConnection httpurlconnection = (HttpURLConnection)par1URL.openConnection();
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Length", "" + par2Str.getBytes().length);
            httpurlconnection.setRequestProperty("Content-Language", "en-US");
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
            dataoutputstream.writeBytes(par2Str);
            dataoutputstream.flush();
            dataoutputstream.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
            StringBuffer stringbuffer = new StringBuffer();
            String s1;

            while ((s1 = bufferedreader.readLine()) != null)
            {
                stringbuffer.append(s1);
                stringbuffer.append('\r');
            }

            bufferedreader.close();
            return stringbuffer.toString();
        }
        catch (Exception exception)
        {
            if (!par3)
            {
                if (par0ILogAgent != null)
                {
                    par0ILogAgent.logSevereException("Could not post to " + par1URL, exception);
                }
                else
                {
                    Logger.getAnonymousLogger().log(Level.SEVERE, "Could not post to " + par1URL, exception);
                }
            }

            return "";
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * The downloader for texturepacks stored in the server.
     */
    public static void downloadTexturePack(File par0File, String par1Str, IDownloadSuccess par2IDownloadSuccess, Map par3Map, int par4, IProgressUpdate par5IProgressUpdate)
    {
        Thread thread = new Thread(new HttpUtilRunnable(par5IProgressUpdate, par1Str, par3Map, par0File, par2IDownloadSuccess, par4));
        thread.setDaemon(true);
        thread.start();
    }

    @SideOnly(Side.CLIENT)
    public static int func_76181_a() throws IOException
    {
        ServerSocket serversocket = null;
        boolean flag = true;
        int i;

        try
        {
            serversocket = new ServerSocket(0);
            i = serversocket.getLocalPort();
        }
        finally
        {
            try
            {
                if (serversocket != null)
                {
                    serversocket.close();
                }
            }
            catch (IOException ioexception)
            {
                ;
            }
        }

        return i;
    }

    @SideOnly(Side.CLIENT)
    public static String[] loginToMinecraft(ILogAgent par0ILogAgent, String par1Str, String par2Str)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("user", par1Str);
        hashmap.put("password", par2Str);
        hashmap.put("version", Integer.valueOf(13));
        String s2;

        try
        {
            s2 = sendPost(par0ILogAgent, new URL("http://login.minecraft.net/"), hashmap, false);
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return null;
        }

        if (s2 != null && s2.length() != 0)
        {
            if (!s2.contains(":"))
            {
                if (par0ILogAgent == null)
                {
                    System.out.println("Failed to authenticate: " + s2);
                }
                else
                {
                    par0ILogAgent.logWarning("Failed to authenticae: " + s2);
                }

                return null;
            }
            else
            {
                String[] astring = s2.split(":");
                return new String[] {astring[2], astring[3]};
            }
        }
        else
        {
            if (par0ILogAgent == null)
            {
                System.out.println("Failed to authenticate: Can\'t connect to minecraft.net");
            }
            else
            {
                par0ILogAgent.logWarning("Failed to authenticate: Can\'t connect to minecraft.net");
            }

            return null;
        }
    }
}
