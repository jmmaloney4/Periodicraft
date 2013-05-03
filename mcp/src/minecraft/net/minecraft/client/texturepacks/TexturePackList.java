package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiProgress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.HttpUtil;

@SideOnly(Side.CLIENT)
public class TexturePackList
{
    /**
     * An instance of TexturePackDefault for the always available builtin texture pack.
     */
    private static final ITexturePack defaultTexturePack = new TexturePackDefault();

    /** The Minecraft instance. */
    private final Minecraft mc;

    /** The directory the texture packs will be loaded from. */
    private final File texturePackDir;

    /** Folder for the multi-player texturepacks. Returns File. */
    private final File mpTexturePackFolder;

    /** The list of the available texture packs. */
    private List availableTexturePacks = new ArrayList();

    /**
     * A mapping of texture IDs to TexturePackBase objects used by updateAvaliableTexturePacks() to avoid reloading
     * texture packs that haven't changed on disk.
     */
    private Map texturePackCache = new HashMap();

    /** The TexturePack that will be used. */
    private ITexturePack selectedTexturePack;

    /** True if a texture pack is downloading in the background. */
    private boolean isDownloading;

    public TexturePackList(File par1File, Minecraft par2Minecraft)
    {
        this.mc = par2Minecraft;
        this.texturePackDir = new File(par1File, "texturepacks");
        this.mpTexturePackFolder = new File(par1File, "texturepacks-mp-cache");
        this.createTexturePackDirs();
        this.updateAvaliableTexturePacks();
    }

    /**
     * Create the "texturepacks" and "texturepacks-mp-cache" directories if they don't already exist.
     */
    private void createTexturePackDirs()
    {
        if (!this.texturePackDir.isDirectory())
        {
            this.texturePackDir.delete();
            this.texturePackDir.mkdirs();
        }

        if (!this.mpTexturePackFolder.isDirectory())
        {
            this.mpTexturePackFolder.delete();
            this.mpTexturePackFolder.mkdirs();
        }
    }

    /**
     * Sets the new TexturePack to be used, returning true if it has actually changed, false if nothing changed.
     */
    public boolean setTexturePack(ITexturePack par1ITexturePack)
    {
        if (par1ITexturePack == this.selectedTexturePack)
        {
            return false;
        }
        else
        {
            this.isDownloading = false;
            this.selectedTexturePack = par1ITexturePack;
            this.mc.gameSettings.skin = par1ITexturePack.getTexturePackFileName();
            this.mc.gameSettings.saveOptions();
            return true;
        }
    }

    /**
     * filename must end in .zip
     */
    public void requestDownloadOfTexture(String par1Str)
    {
        String s1 = par1Str.substring(par1Str.lastIndexOf("/") + 1);

        if (s1.contains("?"))
        {
            s1 = s1.substring(0, s1.indexOf("?"));
        }

        if (s1.endsWith(".zip"))
        {
            File file1 = new File(this.mpTexturePackFolder, s1);
            this.downloadTexture(par1Str, file1);
        }
    }

    private void downloadTexture(String par1Str, File par2File)
    {
        HashMap hashmap = new HashMap();
        GuiProgress guiprogress = new GuiProgress();
        hashmap.put("X-Minecraft-Username", this.mc.session.username);
        hashmap.put("X-Minecraft-Version", "1.5.1");
        hashmap.put("X-Minecraft-Supported-Resolutions", "16");
        this.isDownloading = true;
        this.mc.displayGuiScreen(guiprogress);
        HttpUtil.downloadTexturePack(par2File, par1Str, new TexturePackDownloadSuccess(this), hashmap, 10000000, guiprogress);
    }

    /**
     * Return true if a texture pack is downloading in the background.
     */
    public boolean getIsDownloading()
    {
        return this.isDownloading;
    }

    /**
     * Called from Minecraft.loadWorld() if getIsDownloading() returned true to prepare the downloaded texture for
     * usage.
     */
    public void onDownloadFinished()
    {
        this.isDownloading = false;
        this.updateAvaliableTexturePacks();
        this.mc.scheduleTexturePackRefresh();
    }

    /**
     * check the texture packs the client has installed
     */
    public void updateAvaliableTexturePacks()
    {
        ArrayList arraylist = new ArrayList();
        this.selectedTexturePack = defaultTexturePack;
        arraylist.add(defaultTexturePack);
        Iterator iterator = this.getTexturePackDirContents().iterator();

        while (iterator.hasNext())
        {
            File file1 = (File)iterator.next();
            String s = this.generateTexturePackID(file1);

            if (s != null)
            {
                Object object = (ITexturePack)this.texturePackCache.get(s);

                if (object == null)
                {
                    object = file1.isDirectory() ? new TexturePackFolder(s, file1, defaultTexturePack) : new TexturePackCustom(s, file1, defaultTexturePack);
                    this.texturePackCache.put(s, object);
                }

                if (((ITexturePack)object).getTexturePackFileName().equals(this.mc.gameSettings.skin))
                {
                    this.selectedTexturePack = (ITexturePack)object;
                }

                arraylist.add(object);
            }
        }

        this.availableTexturePacks.removeAll(arraylist);
        iterator = this.availableTexturePacks.iterator();

        while (iterator.hasNext())
        {
            ITexturePack itexturepack = (ITexturePack)iterator.next();
            itexturepack.deleteTexturePack(this.mc.renderEngine);
            this.texturePackCache.remove(itexturepack.getTexturePackID());
        }

        this.availableTexturePacks = arraylist;
    }

    /**
     * Generate an internal texture pack ID from the file/directory name, last modification time, and file size. Returns
     * null if the file/directory is not a texture pack.
     */
    private String generateTexturePackID(File par1File)
    {
        return par1File.isFile() && par1File.getName().toLowerCase().endsWith(".zip") ? par1File.getName() + ":" + par1File.length() + ":" + par1File.lastModified() : (par1File.isDirectory() && (new File(par1File, "pack.txt")).exists() ? par1File.getName() + ":folder:" + par1File.lastModified() : null);
    }

    /**
     * Return a List<File> of file/directories in the texture pack directory.
     */
    private List getTexturePackDirContents()
    {
        return this.texturePackDir.exists() && this.texturePackDir.isDirectory() ? Arrays.asList(this.texturePackDir.listFiles()) : Collections.emptyList();
    }

    /**
     * Returns a list of the available texture packs.
     */
    public List availableTexturePacks()
    {
        return Collections.unmodifiableList(this.availableTexturePacks);
    }

    public ITexturePack getSelectedTexturePack()
    {
        return this.selectedTexturePack;
    }

    public boolean func_77300_f()
    {
        if (!this.mc.gameSettings.serverTextures)
        {
            return false;
        }
        else
        {
            ServerData serverdata = this.mc.getServerData();
            return serverdata == null ? true : serverdata.func_78840_c();
        }
    }

    public boolean getAcceptsTextures()
    {
        if (!this.mc.gameSettings.serverTextures)
        {
            return false;
        }
        else
        {
            ServerData serverdata = this.mc.getServerData();
            return serverdata == null ? false : serverdata.getAcceptsTextures();
        }
    }

    static boolean isDownloading(TexturePackList par0TexturePackList)
    {
        return par0TexturePackList.isDownloading;
    }

    /**
     * Set the selectedTexturePack field (Inner class static accessor method).
     */
    static ITexturePack setSelectedTexturePack(TexturePackList par0TexturePackList, ITexturePack par1ITexturePack)
    {
        return par0TexturePackList.selectedTexturePack = par1ITexturePack;
    }

    /**
     * Generate an internal texture pack ID from the file/directory name, last modification time, and file size. Returns
     * null if the file/directory is not a texture pack. (Inner class static accessor method).
     */
    static String generateTexturePackID(TexturePackList par0TexturePackList, File par1File)
    {
        return par0TexturePackList.generateTexturePackID(par1File);
    }

    static ITexturePack func_98143_h()
    {
        return defaultTexturePack;
    }

    static Minecraft getMinecraft(TexturePackList par0TexturePackList)
    {
        return par0TexturePackList.mc;
    }
}
