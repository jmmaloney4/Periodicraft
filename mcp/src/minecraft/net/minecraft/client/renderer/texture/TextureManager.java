package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.texturepacks.ITexturePack;

@SideOnly(Side.CLIENT)
public class TextureManager
{
    private static TextureManager instance;
    private int nextTextureID = 0;
    private final HashMap texturesMap = new HashMap();
    private final HashMap mapNameToId = new HashMap();

    public static void init()
    {
        instance = new TextureManager();
    }

    public static TextureManager instance()
    {
        return instance;
    }

    public int getNextTextureId()
    {
        return this.nextTextureID++;
    }

    public void registerTexture(String par1Str, Texture par2Texture)
    {
        this.mapNameToId.put(par1Str, Integer.valueOf(par2Texture.getTextureId()));

        if (!this.texturesMap.containsKey(Integer.valueOf(par2Texture.getTextureId())))
        {
            this.texturesMap.put(Integer.valueOf(par2Texture.getTextureId()), par2Texture);
        }
    }

    public void registerTexture(Texture par1Texture)
    {
        if (this.texturesMap.containsValue(par1Texture))
        {
            Minecraft.getMinecraft().getLogAgent().logWarning("TextureManager.registerTexture called, but this texture has already been registered. ignoring.");
        }
        else
        {
            this.texturesMap.put(Integer.valueOf(par1Texture.getTextureId()), par1Texture);
        }
    }

    public Stitcher createStitcher(String par1Str)
    {
        int i = Minecraft.getGLMaximumTextureSize();
        return new Stitcher(par1Str, i, i, true);
    }

    public List createTexture(String par1Str)
    {
        return createNewTexture(par1Str, par1Str, null);
    }

    public List createNewTexture(String textureName, String textureFile, TextureStitched stitched)
    {
        String par1Str = textureFile;
        ArrayList arraylist = new ArrayList();
        ITexturePack itexturepack = Minecraft.getMinecraft().texturePackList.getSelectedTexturePack();

        try
        {
            BufferedImage bufferedimage = null;
            int i = 0;
            int j = 0;
            FileNotFoundException fnfe = null;
            try
            {
                bufferedimage = ImageIO.read(itexturepack.getResourceAsStream("/" + textureFile));
                i = bufferedimage.getHeight();
                j = bufferedimage.getWidth();
            }
            catch (FileNotFoundException e)
            {
                fnfe = e;
            }
            String s1 = textureName;

            if (stitched != null && stitched.loadTexture(this, itexturepack, textureName, textureFile, bufferedimage, arraylist))
            {
                ;
            }
            else if (fnfe != null)
            {
                throw fnfe;
            }
            else if (this.hasAnimationTxt(par1Str, itexturepack))
            {
                int k = j;
                int l = j;
                int i1 = i / j;

                for (int j1 = 0; j1 < i1; ++j1)
                {
                    Texture texture = this.makeTexture(s1, 2, k, l, 10496, 6408, 9728, 9728, false, bufferedimage.getSubimage(0, l * j1, k, l));
                    arraylist.add(texture);
                }
            }
            else if (j == i)
            {
                arraylist.add(this.makeTexture(s1, 2, j, i, 10496, 6408, 9728, 9728, false, bufferedimage));
            }
            else
            {
                Minecraft.getMinecraft().getLogAgent().logWarning("TextureManager.createTexture: Skipping " + par1Str + " because of broken aspect ratio and not animation");
            }

            return arraylist;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Minecraft.getMinecraft().getLogAgent().logWarning("TextureManager.createTexture called for file " + par1Str + ", but that file does not exist. Ignoring.");
        }
        catch (IOException ioexception)
        {
            Minecraft.getMinecraft().getLogAgent().logWarning("TextureManager.createTexture encountered an IOException when trying to read file " + par1Str + ". Ignoring.");
        }

        return arraylist;
    }

    /**
     * Strips directory and file extension from the specified path, returning only the filename
     */
    private String getBasename(String par1Str)
    {
        File file1 = new File(par1Str);
        return file1.getName().substring(0, file1.getName().lastIndexOf(46));
    }

    /**
     * Returns true if specified texture pack contains animation data for the specified texture file
     */
    private boolean hasAnimationTxt(String par1Str, ITexturePack par2ITexturePack)
    {
        String s1 = "/" + par1Str.substring(0, par1Str.lastIndexOf(46)) + ".txt";
        boolean flag = par2ITexturePack.func_98138_b("/" + par1Str, false);
        return Minecraft.getMinecraft().texturePackList.getSelectedTexturePack().func_98138_b(s1, !flag);
    }

    public Texture makeTexture(String par1Str, int par2, int par3, int par4, int par5, int par6, int par7, int par8, boolean par9, BufferedImage par10BufferedImage)
    {
        Texture texture = new Texture(par1Str, par2, par3, par4, par5, par6, par7, par8, par10BufferedImage);
        this.registerTexture(texture);
        return texture;
    }

    public Texture createEmptyTexture(String par1Str, int par2, int par3, int par4, int par5)
    {
        return this.makeTexture(par1Str, par2, par3, par4, 10496, par5, 9728, 9728, false, (BufferedImage)null);
    }
}
