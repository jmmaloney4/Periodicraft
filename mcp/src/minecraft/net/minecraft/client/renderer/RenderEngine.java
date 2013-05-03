package net.minecraft.client.renderer;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.client.texturepacks.TexturePackList;
import net.minecraft.util.Icon;
import net.minecraft.util.IntHashMap;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraftforge.client.ForgeHooksClient;

@SideOnly(Side.CLIENT)
public class RenderEngine
{
    private HashMap textureMap = new HashMap();

    /** Texture contents map (key: texture name, value: int[] contents) */
    private HashMap textureContentsMap = new HashMap();

    /** A mapping from GL texture names (integers) to BufferedImage instances */
    private IntHashMap textureNameToImageMap = new IntHashMap();

    /** Stores the image data for the texture. */
    private IntBuffer imageData = GLAllocation.createDirectIntBuffer(4194304);

    /** A mapping from image URLs to ThreadDownloadImageData instances */
    private Map urlToImageDataMap = new HashMap();

    /** Reference to the GameSettings object */
    private GameSettings options;

    /** Texture pack */
    public TexturePackList texturePack;

    /** Missing texture image */
    private BufferedImage missingTextureImage = new BufferedImage(64, 64, 2);
    public final TextureMap textureMapBlocks;
    public final TextureMap textureMapItems;
    private int boundTexture;

    public static Logger log = FMLLog.getLogger();

    public RenderEngine(TexturePackList par1TexturePackList, GameSettings par2GameSettings)
    {
        this.texturePack = par1TexturePackList;
        this.options = par2GameSettings;
        Graphics graphics = this.missingTextureImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 64, 64);
        graphics.setColor(Color.BLACK);
        int i = 10;
        int j = 0;

        while (i < 64)
        {
            String s = j++ % 2 == 0 ? "missing" : "texture";
            graphics.drawString(s, 1, i);
            i += graphics.getFont().getSize();

            if (j % 2 == 0)
            {
                i += 5;
            }
        }

        graphics.dispose();
        this.textureMapBlocks = new TextureMap(0, "terrain", "textures/blocks/", this.missingTextureImage);
        this.textureMapItems = new TextureMap(1, "items", "textures/items/", this.missingTextureImage);
    }

    public int[] getTextureContents(String par1Str)
    {
        ITexturePack itexturepack = this.texturePack.getSelectedTexturePack();
        int[] aint = (int[])this.textureContentsMap.get(par1Str);

        if (aint != null)
        {
            return aint;
        }
        else
        {
            try
            {
                InputStream inputstream = itexturepack.getResourceAsStream(par1Str);
                int[] aint1;

                if (inputstream == null)
                {
                    aint1 = this.getImageContentsAndAllocate(this.missingTextureImage);
                }
                else
                {
                    BufferedImage bufferedimage = this.readTextureImage(inputstream);
                    TextureFXManager.instance().fixTransparency(bufferedimage, par1Str);
                    aint1 = this.getImageContentsAndAllocate(bufferedimage);
                }

                this.textureContentsMap.put(par1Str, aint1);
                return aint1;
            }
            catch (Exception ioexception)
            {
                log.log(Level.INFO, String.format("An error occured reading texture file %s (getTexture)", par1Str), ioexception);
                ioexception.printStackTrace();
                int[] aint2 = this.getImageContentsAndAllocate(this.missingTextureImage);
                this.textureContentsMap.put(par1Str, aint2);
                return aint2;
            }
        }
    }

    private int[] getImageContentsAndAllocate(BufferedImage par1BufferedImage)
    {
        return this.getImageContents(par1BufferedImage, new int[par1BufferedImage.getWidth() * par1BufferedImage.getHeight()]);
    }

    private int[] getImageContents(BufferedImage par1BufferedImage, int[] par2ArrayOfInteger)
    {
        int i = par1BufferedImage.getWidth();
        int j = par1BufferedImage.getHeight();
        par1BufferedImage.getRGB(0, 0, i, j, par2ArrayOfInteger, 0, i);
        return par2ArrayOfInteger;
    }

    public void bindTexture(String par1Str)
    {
        this.bindTexture(this.getTexture(par1Str));
    }

    private void bindTexture(int par1)
    {
        if (par1 != this.boundTexture)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, par1);
            this.boundTexture = par1;
        }
    }

    public void resetBoundTexture()
    {
        this.boundTexture = -1;
    }

    public int getTexture(String par1Str)
    {
        if (par1Str.equals("/terrain.png"))
        {
            this.textureMapBlocks.getTexture().bindTexture(0);
            return this.textureMapBlocks.getTexture().getGlTextureId();
        }
        else if (par1Str.equals("/gui/items.png"))
        {
            this.textureMapItems.getTexture().bindTexture(0);
            return this.textureMapItems.getTexture().getGlTextureId();
        }
        else
        {
            Integer integer = (Integer)this.textureMap.get(par1Str);

            if (integer != null)
            {
                return integer.intValue();
            }
            else
            {
                String s1 = par1Str;

                try
                {
                    ForgeHooksClient.onTextureLoadPre(par1Str);
                    int i = GLAllocation.generateTextureNames();
                    TextureFXManager.instance().bindTextureToName(par1Str, i);
                    boolean flag = par1Str.startsWith("%blur%");

                    if (flag)
                    {
                        par1Str = par1Str.substring(6);
                    }

                    boolean flag1 = par1Str.startsWith("%clamp%");

                    if (flag1)
                    {
                        par1Str = par1Str.substring(7);
                    }

                    InputStream inputstream = this.texturePack.getSelectedTexturePack().getResourceAsStream(par1Str);

                    if (inputstream == null)
                    {
                        this.setupTextureExt(this.missingTextureImage, i, flag, flag1);
                    }
                    else
                    {
                        BufferedImage bufferedimage = this.readTextureImage(inputstream);
                        TextureFXManager.instance().fixTransparency(bufferedimage, par1Str);
                        this.setupTextureExt(bufferedimage, i, flag, flag1);
                    }

                    this.textureMap.put(s1, Integer.valueOf(i));
                    ForgeHooksClient.onTextureLoad(par1Str, texturePack.getSelectedTexturePack());
                    return i;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    int j = GLAllocation.generateTextureNames();
                    this.setupTexture(this.missingTextureImage, j);
                    this.textureMap.put(par1Str, Integer.valueOf(j));
                    return j;
                }
            }
        }
    }

    /**
     * Copy the supplied image onto a newly-allocated OpenGL texture, returning the allocated texture name
     */
    public int allocateAndSetupTexture(BufferedImage par1BufferedImage)
    {
        int i = GLAllocation.generateTextureNames();
        this.setupTexture(par1BufferedImage, i);
        this.textureNameToImageMap.addKey(i, par1BufferedImage);
        return i;
    }

    /**
     * Copy the supplied image onto the specified OpenGL texture
     */
    public void setupTexture(BufferedImage par1BufferedImage, int par2)
    {
        this.setupTextureExt(par1BufferedImage, par2, false, false);
    }

    public void setupTextureExt(BufferedImage par1BufferedImage, int par2, boolean par3, boolean par4)
    {
        this.bindTexture(par2);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

        if (par3)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        }

        if (par4)
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        }
        else
        {
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
        }

        int j = par1BufferedImage.getWidth();
        int k = par1BufferedImage.getHeight();
        TextureFXManager.instance().setTextureDimensions(par2, j, k);
        int[] aint = new int[j * k];
        par1BufferedImage.getRGB(0, 0, j, k, aint, 0, j);

        if (this.options != null && this.options.anaglyph)
        {
            aint = this.colorToAnaglyph(aint);
        }

        this.imageData.clear();
        this.imageData.put(aint);
        this.imageData.position(0).limit(aint.length);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, j, k, 0, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, this.imageData);
    }

    private int[] colorToAnaglyph(int[] par1ArrayOfInteger)
    {
        int[] aint1 = new int[par1ArrayOfInteger.length];

        for (int i = 0; i < par1ArrayOfInteger.length; ++i)
        {
            int j = par1ArrayOfInteger[i] >> 24 & 255;
            int k = par1ArrayOfInteger[i] >> 16 & 255;
            int l = par1ArrayOfInteger[i] >> 8 & 255;
            int i1 = par1ArrayOfInteger[i] & 255;
            int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
            int k1 = (k * 30 + l * 70) / 100;
            int l1 = (k * 30 + i1 * 70) / 100;
            aint1[i] = j << 24 | j1 << 16 | k1 << 8 | l1;
        }

        return aint1;
    }

    public void createTextureFromBytes(int[] par1ArrayOfInteger, int par2, int par3, int par4)
    {
        this.bindTexture(par4);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);

        if (this.options != null && this.options.anaglyph)
        {
            par1ArrayOfInteger = this.colorToAnaglyph(par1ArrayOfInteger);
        }

        this.imageData.clear();
        this.imageData.put(par1ArrayOfInteger);
        this.imageData.position(0).limit(par1ArrayOfInteger.length);
        GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, par2, par3, GL12.GL_BGRA, GL12.GL_UNSIGNED_INT_8_8_8_8_REV, this.imageData);
    }

    /**
     * Deletes a single GL texture
     */
    public void deleteTexture(int par1)
    {
        this.textureNameToImageMap.removeObject(par1);
        GL11.glDeleteTextures(par1);
    }

    /**
     * Takes a URL of a downloadable image and the name of the local image to be used as a fallback.  If the image has
     * been downloaded, returns the GL texture of the downloaded image, otherwise returns the GL texture of the fallback
     * image.
     */
    public int getTextureForDownloadableImage(String par1Str, String par2Str)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)this.urlToImageDataMap.get(par1Str);

        if (threaddownloadimagedata != null && threaddownloadimagedata.image != null && !threaddownloadimagedata.textureSetupComplete)
        {
            if (threaddownloadimagedata.textureName < 0)
            {
                threaddownloadimagedata.textureName = this.allocateAndSetupTexture(threaddownloadimagedata.image);
            }
            else
            {
                this.setupTexture(threaddownloadimagedata.image, threaddownloadimagedata.textureName);
            }

            threaddownloadimagedata.textureSetupComplete = true;
        }

        return threaddownloadimagedata != null && threaddownloadimagedata.textureName >= 0 ? threaddownloadimagedata.textureName : (par2Str == null ? -1 : this.getTexture(par2Str));
    }

    /**
     * Checks if urlToImageDataMap has image data for the given key
     */
    public boolean hasImageData(String par1Str)
    {
        return this.urlToImageDataMap.containsKey(par1Str);
    }

    /**
     * Return a ThreadDownloadImageData instance for the given URL.  If it does not already exist, it is created and
     * uses the passed ImageBuffer.  If it does, its reference count is incremented.
     */
    public ThreadDownloadImageData obtainImageData(String par1Str, IImageBuffer par2IImageBuffer)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)this.urlToImageDataMap.get(par1Str);

        if (threaddownloadimagedata == null)
        {
            this.urlToImageDataMap.put(par1Str, new ThreadDownloadImageData(par1Str, par2IImageBuffer));
        }
        else
        {
            ++threaddownloadimagedata.referenceCount;
        }

        return threaddownloadimagedata;
    }

    /**
     * Decrements the reference count for a given URL, deleting the image data if the reference count hits 0
     */
    public void releaseImageData(String par1Str)
    {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)this.urlToImageDataMap.get(par1Str);

        if (threaddownloadimagedata != null)
        {
            --threaddownloadimagedata.referenceCount;

            if (threaddownloadimagedata.referenceCount == 0)
            {
                if (threaddownloadimagedata.textureName >= 0)
                {
                    this.deleteTexture(threaddownloadimagedata.textureName);
                }

                this.urlToImageDataMap.remove(par1Str);
            }
        }
    }

    public void updateDynamicTextures()
    {
        this.textureMapBlocks.updateAnimations();
        this.textureMapItems.updateAnimations();
    }

    /**
     * Call setupTexture on all currently-loaded textures again to account for changes in rendering options
     */
    public void refreshTextures()
    {
        ITexturePack itexturepack = this.texturePack.getSelectedTexturePack();
        this.refreshTextureMaps();
        Iterator iterator = this.textureNameToImageMap.getKeySet().iterator();
        BufferedImage bufferedimage;

        while (iterator.hasNext())
        {
            int i = ((Integer)iterator.next()).intValue();
            bufferedimage = (BufferedImage)this.textureNameToImageMap.lookup(i);
            this.setupTexture(bufferedimage, i);
        }

        ThreadDownloadImageData threaddownloadimagedata;

        for (iterator = this.urlToImageDataMap.values().iterator(); iterator.hasNext(); threaddownloadimagedata.textureSetupComplete = false)
        {
            threaddownloadimagedata = (ThreadDownloadImageData)iterator.next();
        }

        iterator = this.textureMap.keySet().iterator();
        String s;

        while (iterator.hasNext())
        {
            s = (String)iterator.next();

            try
            {
                int j = ((Integer)this.textureMap.get(s)).intValue();
                boolean flag = s.startsWith("%blur%");

                if (flag)
                {
                    s = s.substring(6);
                }

                boolean flag1 = s.startsWith("%clamp%");

                if (flag1)
                {
                    s = s.substring(7);
                }

                BufferedImage bufferedimage1 = this.readTextureImage(itexturepack.getResourceAsStream(s));
                TextureFXManager.instance().fixTransparency(bufferedimage1, s);
                this.setupTextureExt(bufferedimage1, j, flag, flag1);
            }
            catch (Exception ioexception)
            {
                log.log(Level.INFO,String.format("An error occured reading texture file %s (refreshTexture)", s), ioexception);
                ioexception.printStackTrace();
            }
        }

        iterator = this.textureContentsMap.keySet().iterator();

        while (iterator.hasNext())
        {
            s = (String)iterator.next();

            try
            {
                bufferedimage = this.readTextureImage(itexturepack.getResourceAsStream(s));
                TextureFXManager.instance().fixTransparency(bufferedimage, s);
                this.getImageContents(bufferedimage, (int[])this.textureContentsMap.get(s));
            }
            catch (Exception ioexception1)
            {
                log.log(Level.INFO,String.format("An error occured reading texture file data %s (refreshTexture)", s), ioexception1);
                ioexception1.printStackTrace();
            }
        }

        Minecraft.getMinecraft().fontRenderer.readFontData();
        Minecraft.getMinecraft().standardGalacticFontRenderer.readFontData();
    }

    /**
     * Returns a BufferedImage read off the provided input stream.  Args: inputStream
     */
    private BufferedImage readTextureImage(InputStream par1InputStream) throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(par1InputStream);
        par1InputStream.close();
        return bufferedimage;
    }

    public void refreshTextureMaps()
    {
        this.textureMapBlocks.refreshTextures();
        this.textureMapItems.refreshTextures();
    }

    public Icon getMissingIcon(int par1)
    {
        switch (par1)
        {
            case 0:
                return this.textureMapBlocks.getMissingIcon();
            case 1:
            default:
                return this.textureMapItems.getMissingIcon();
        }
    }
}
