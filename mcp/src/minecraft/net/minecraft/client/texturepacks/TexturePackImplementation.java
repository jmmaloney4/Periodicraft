package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import net.minecraft.client.renderer.RenderEngine;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class TexturePackImplementation implements ITexturePack
{
    /**
     * Texture pack ID as returnd by generateTexturePackID(). Used only internally and not visible to the user.
     */
    private final String texturePackID;

    /**
     * The name of the texture pack's zip file/directory or "Default" for the builtin texture pack. Shown in the GUI.
     */
    private final String texturePackFileName;

    /**
     * File object for the texture pack's zip file in TexturePackCustom or the directory in TexturePackFolder.
     */
    protected final File texturePackFile;

    /**
     * First line of texture pack description (from /pack.txt) displayed in the GUI
     */
    protected String firstDescriptionLine;

    /**
     * Second line of texture pack description (from /pack.txt) displayed in the GUI
     */
    protected String secondDescriptionLine;
    private final ITexturePack field_98141_g;

    /** The texture pack's thumbnail image loaded from the /pack.png file. */
    protected BufferedImage thumbnailImage;

    /** The texture id for this pcak's thumbnail image. */
    private int thumbnailTextureName = -1;

    protected TexturePackImplementation(String par1, File par2File, String par3Str, ITexturePack par4ITexturePack)
    {
        this.texturePackID = par1;
        this.texturePackFileName = par3Str;
        this.texturePackFile = par2File;
        this.field_98141_g = par4ITexturePack;
        this.loadThumbnailImage();
        this.loadDescription();
    }

    /**
     * Truncate strings to at most 34 characters. Truncates description lines
     */
    private static String trimStringToGUIWidth(String par0Str)
    {
        if (par0Str != null && par0Str.length() > 34)
        {
            par0Str = par0Str.substring(0, 34);
        }

        return par0Str;
    }

    /**
     * Load and initialize thumbnailImage from the the /pack.png file.
     */
    private void loadThumbnailImage()
    {
        InputStream inputstream = null;

        try
        {
            inputstream = this.func_98137_a("/pack.png", false);
            this.thumbnailImage = ImageIO.read(inputstream);
        }
        catch (IOException ioexception)
        {
            ;
        }
        finally
        {
            try
            {
                if (inputstream != null)
                {
                    inputstream.close();
                }
            }
            catch (IOException ioexception1)
            {
                ;
            }
        }
    }

    /**
     * Load texture pack description from /pack.txt file in the texture pack
     */
    protected void loadDescription()
    {
        InputStream inputstream = null;
        BufferedReader bufferedreader = null;

        try
        {
            inputstream = this.func_98139_b("/pack.txt");
            bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            this.firstDescriptionLine = trimStringToGUIWidth(bufferedreader.readLine());
            this.secondDescriptionLine = trimStringToGUIWidth(bufferedreader.readLine());
        }
        catch (IOException ioexception)
        {
            ;
        }
        finally
        {
            try
            {
                if (bufferedreader != null)
                {
                    bufferedreader.close();
                }

                if (inputstream != null)
                {
                    inputstream.close();
                }
            }
            catch (IOException ioexception1)
            {
                ;
            }
        }
    }

    public InputStream func_98137_a(String par1Str, boolean par2) throws IOException
    {
        try
        {
            return this.func_98139_b(par1Str);
        }
        catch (IOException ioexception)
        {
            if (this.field_98141_g != null && par2)
            {
                return this.field_98141_g.func_98137_a(par1Str, true);
            }
            else
            {
                throw ioexception;
            }
        }
    }

    /**
     * Gives a texture resource as InputStream.
     */
    public InputStream getResourceAsStream(String par1Str) throws IOException
    {
        return this.func_98137_a(par1Str, true);
    }

    protected abstract InputStream func_98139_b(String s) throws IOException;

    /**
     * Delete the OpenGL texture id of the pack's thumbnail image, and close the zip file in case of TexturePackCustom.
     */
    public void deleteTexturePack(RenderEngine par1RenderEngine)
    {
        if (this.thumbnailImage != null && this.thumbnailTextureName != -1)
        {
            par1RenderEngine.deleteTexture(this.thumbnailTextureName);
        }
    }

    /**
     * Bind the texture id of the pack's thumbnail image, loading it if necessary.
     */
    public void bindThumbnailTexture(RenderEngine par1RenderEngine)
    {
        if (this.thumbnailImage != null)
        {
            if (this.thumbnailTextureName == -1)
            {
                this.thumbnailTextureName = par1RenderEngine.allocateAndSetupTexture(this.thumbnailImage);
            }

            GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.thumbnailTextureName);
            par1RenderEngine.resetBoundTexture();
        }
        else
        {
            par1RenderEngine.bindTexture("/gui/unknown_pack.png");
        }
    }

    public boolean func_98138_b(String par1Str, boolean par2)
    {
        boolean flag1 = this.func_98140_c(par1Str);
        return !flag1 && par2 && this.field_98141_g != null ? this.field_98141_g.func_98138_b(par1Str, par2) : flag1;
    }

    public abstract boolean func_98140_c(String s);

    /**
     * Get the texture pack ID
     */
    public String getTexturePackID()
    {
        return this.texturePackID;
    }

    /**
     * Get the file name of the texture pack, or Default if not from a custom texture pack
     */
    public String getTexturePackFileName()
    {
        return this.texturePackFileName;
    }

    /**
     * Get the first line of the texture pack description (read from the pack.txt file)
     */
    public String getFirstDescriptionLine()
    {
        return this.firstDescriptionLine;
    }

    /**
     * Get the second line of the texture pack description (read from the pack.txt file)
     */
    public String getSecondDescriptionLine()
    {
        return this.secondDescriptionLine;
    }
}
