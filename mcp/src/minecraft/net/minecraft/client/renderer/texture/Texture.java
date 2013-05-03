package net.minecraft.client.renderer.texture;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.src.FMLRenderAccessLibrary;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class Texture
{
    private int glTextureId;
    private int textureId;
    private int textureType;

    /** Width of this texture in pixels. */
    private final int width;

    /** Height of this texture in pixels. */
    private final int height;
    private final int textureDepth;
    private final int textureFormat;
    private final int textureTarget;
    private final int textureMinFilter;
    private final int textureMagFilter;
    private final int textureWrap;
    private final boolean mipmapActive;
    private final String textureName;
    private Rect2i textureRect;
    private boolean transferred;

    /**
     * Uninitialized boolean. If true, the texture is re-uploaded every time it's modified. If false, every tick after
     * it's been modified at least once in that tick.
     */
    private boolean autoCreate;

    /**
     * False if the texture has been modified since it was last uploaded to the GPU.
     */
    private boolean textureNotModified;
    private ByteBuffer textureData;

    private Texture(String par1Str, int par2, int par3, int par4, int par5, int par6, int par7, int par8, int par9)
    {
        this.textureName = par1Str;
        this.textureType = par2;
        this.width = par3;
        this.height = par4;
        this.textureDepth = par5;
        this.textureFormat = par7;
        this.textureMinFilter = par8;
        this.textureMagFilter = par9;
        this.textureWrap = par6;
        this.textureRect = new Rect2i(0, 0, par3, par4);

        if (par4 == 1 && par5 == 1)
        {
            this.textureTarget = 3552;
        }
        else if (par5 == 1)
        {
            this.textureTarget = 3553;
        }
        else
        {
            this.textureTarget = 32879;
        }

        this.mipmapActive = par8 != 9728 && par8 != 9729 || par9 != 9728 && par9 != 9729;

        if (par2 != 2)
        {
            this.glTextureId = GL11.glGenTextures();
            GL11.glBindTexture(this.textureTarget, this.glTextureId);
            GL11.glTexParameteri(this.textureTarget, GL11.GL_TEXTURE_MIN_FILTER, par8);
            GL11.glTexParameteri(this.textureTarget, GL11.GL_TEXTURE_MAG_FILTER, par9);
            GL11.glTexParameteri(this.textureTarget, GL11.GL_TEXTURE_WRAP_S, par6);
            GL11.glTexParameteri(this.textureTarget, GL11.GL_TEXTURE_WRAP_T, par6);
        }
        else
        {
            this.glTextureId = -1;
        }

        this.textureId = TextureManager.instance().getNextTextureId();
    }

    public Texture(String par1Str, int par2, int par3, int par4, int par5, int par6, int par7, int par8, BufferedImage par9BufferedImage)
    {
        this(par1Str, par2, par3, par4, 1, par5, par6, par7, par8, par9BufferedImage);
    }

    public Texture(String par1Str, int par2, int par3, int par4, int par5, int par6, int par7, int par8, int par9, BufferedImage par10BufferedImage)
    {
        this(par1Str, par2, par3, par4, par5, par6, par7, par8, par9);

        if (par10BufferedImage == null)
        {
            if (par3 != -1 && par4 != -1)
            {
                byte[] abyte = new byte[par3 * par4 * par5 * 4];

                for (int i2 = 0; i2 < abyte.length; ++i2)
                {
                    abyte[i2] = 0;
                }

                this.textureData = ByteBuffer.allocateDirect(abyte.length);
                this.textureData.clear();
                this.textureData.put(abyte);
                this.textureData.position(0).limit(abyte.length);

                if (this.autoCreate)
                {
                    this.uploadTexture();
                }
                else
                {
                    this.textureNotModified = false;
                }
            }
            else
            {
                this.transferred = false;
            }
        }
        else
        {
            this.transferred = true;
            this.transferFromImage(par10BufferedImage);

            if (par2 != 2)
            {
                this.uploadTexture();
                this.autoCreate = false;
            }
        }
    }

    public final Rect2i getTextureRect()
    {
        return this.textureRect;
    }

    public void fillRect(Rect2i par1Rect2i, int par2)
    {
        if (this.textureTarget != 32879)
        {
            Rect2i rect2i1 = new Rect2i(0, 0, this.width, this.height);
            rect2i1.intersection(par1Rect2i);
            this.textureData.position(0);

            for (int j = rect2i1.getRectY(); j < rect2i1.getRectY() + rect2i1.getRectHeight(); ++j)
            {
                int k = j * this.width * 4;

                for (int l = rect2i1.getRectX(); l < rect2i1.getRectX() + rect2i1.getRectWidth(); ++l)
                {
                    this.textureData.put(k + l * 4 + 0, (byte)(par2 >> 24 & 255));
                    this.textureData.put(k + l * 4 + 1, (byte)(par2 >> 16 & 255));
                    this.textureData.put(k + l * 4 + 2, (byte)(par2 >> 8 & 255));
                    this.textureData.put(k + l * 4 + 3, (byte)(par2 >> 0 & 255));
                }
            }

            if (this.autoCreate)
            {
                this.uploadTexture();
            }
            else
            {
                this.textureNotModified = false;
            }
        }
    }

    public void writeImage(String par1Str)
    {
        BufferedImage bufferedimage = new BufferedImage(this.width, this.height, 2);
        ByteBuffer bytebuffer = this.getTextureData();
        byte[] abyte = new byte[this.width * this.height * 4];
        bytebuffer.position(0);
        bytebuffer.get(abyte);

        for (int i = 0; i < this.width; ++i)
        {
            for (int j = 0; j < this.height; ++j)
            {
                int k = j * this.width * 4 + i * 4;
                byte b0 = 0;
                int l = b0 | (abyte[k + 2] & 255) << 0;
                l |= (abyte[k + 1] & 255) << 8;
                l |= (abyte[k + 0] & 255) << 16;
                l |= (abyte[k + 3] & 255) << 24;
                bufferedimage.setRGB(i, j, l);
            }
        }

        this.textureData.position(this.width * this.height * 4);

        try
        {
            ImageIO.write(bufferedimage, "png", new File(Minecraft.getMinecraftDir(), par1Str));
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void copyFrom(int par1, int par2, Texture par3Texture, boolean par4)
    {
        if (this.textureTarget != 32879)
        {
            if (textureNotModified && !par4)
            {
                FMLRenderAccessLibrary.doTextureCopy(this, par3Texture, par1, par2);
                return;
            }

            ByteBuffer bytebuffer = par3Texture.getTextureData();
            this.textureData.position(0);
            bytebuffer.position(0);

            for (int k = 0; k < par3Texture.getHeight(); ++k)
            {
                int l = par2 + k;
                int i1 = k * par3Texture.getWidth() * 4;
                int j1 = l * this.width * 4;

                if (par4)
                {
                    l = par1 + (par3Texture.getHeight() - k - 1); //BUGFIX: targetY -> targetX and -1
                }

                for (int k1 = 0; k1 < par3Texture.getWidth(); ++k1)
                {
                    int l1 = j1 + (k1 + par1) * 4;
                    int i2 = i1 + k1 * 4;

                    if (par4)
                    {
                        l1 = (par2 + k1) * this.width * 4 + l * 4; //BUGFIX: targetX -> targetY and parens
                    }

                    this.textureData.put(l1 + 0, bytebuffer.get(i2 + 0));
                    this.textureData.put(l1 + 1, bytebuffer.get(i2 + 1));
                    this.textureData.put(l1 + 2, bytebuffer.get(i2 + 2));
                    this.textureData.put(l1 + 3, bytebuffer.get(i2 + 3));
                }
            }

            this.textureData.position(this.width * this.height * 4);

            if (this.autoCreate)
            {
                this.uploadTexture();
            }
            else
            {
                this.textureNotModified = false;
            }
        }
    }

    public void transferFromImage(BufferedImage par1BufferedImage)
    {
        if (this.textureTarget != 32879)
        {
            int i = par1BufferedImage.getWidth();
            int j = par1BufferedImage.getHeight();

            if (i <= this.width && j <= this.height)
            {
                int[] aint = new int[] {3, 0, 1, 2};
                int[] aint1 = new int[] {3, 2, 1, 0};
                int[] aint2 = this.textureFormat == 32993 ? aint1 : aint;
                int[] aint3 = new int[this.width * this.height];
                int k = par1BufferedImage.getTransparency();
                par1BufferedImage.getRGB(0, 0, this.width, this.height, aint3, 0, i);
                byte[] abyte = new byte[this.width * this.height * 4];

                for (int l = 0; l < this.height; ++l)
                {
                    for (int i1 = 0; i1 < this.width; ++i1)
                    {
                        int j1 = l * this.width + i1;
                        int k1 = j1 * 4;
                        abyte[k1 + aint2[0]] = (byte)(aint3[j1] >> 24 & 255);
                        abyte[k1 + aint2[1]] = (byte)(aint3[j1] >> 16 & 255);
                        abyte[k1 + aint2[2]] = (byte)(aint3[j1] >> 8 & 255);
                        abyte[k1 + aint2[3]] = (byte)(aint3[j1] >> 0 & 255);
                    }
                }

                this.textureData = ByteBuffer.allocateDirect(abyte.length);
                this.textureData.clear();
                this.textureData.put(abyte);
                this.textureData.limit(abyte.length);

                if (this.autoCreate)
                {
                    this.uploadTexture();
                }
                else
                {
                    this.textureNotModified = false;
                }
            }
            else
            {
                Minecraft.getMinecraft().getLogAgent().logWarning("transferFromImage called with a BufferedImage with dimensions (" + i + ", " + j + ") larger than the Texture dimensions (" + this.width + ", " + this.height + "). Ignoring.");
            }
        }
    }

    public int getTextureId()
    {
        return this.textureId;
    }

    public int getGlTextureId()
    {
        return this.glTextureId;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public String getTextureName()
    {
        return this.textureName;
    }

    public void bindTexture(int par1)
    {
        if (this.textureDepth == 1)
        {
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
        else
        {
            GL11.glEnable(GL12.GL_TEXTURE_3D);
        }

        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit + par1);
        GL11.glBindTexture(this.textureTarget, this.glTextureId);

        if (!this.textureNotModified)
        {
            this.uploadTexture();
        }
    }

    public void uploadTexture()
    {
        this.textureData.flip();

        if (this.height != 1 && this.textureDepth != 1)
        {
            GL12.glTexImage3D(this.textureTarget, 0, this.textureFormat, this.width, this.height, this.textureDepth, 0, this.textureFormat, GL11.GL_UNSIGNED_BYTE, this.textureData);
        }
        else if (this.height != 1)
        {
            GL11.glTexImage2D(this.textureTarget, 0, this.textureFormat, this.width, this.height, 0, this.textureFormat, GL11.GL_UNSIGNED_BYTE, this.textureData);
        }
        else
        {
            GL11.glTexImage1D(this.textureTarget, 0, this.textureFormat, this.width, 0, this.textureFormat, GL11.GL_UNSIGNED_BYTE, this.textureData);
        }

        this.textureNotModified = true;
    }

    public ByteBuffer getTextureData()
    {
        return this.textureData;
    }

    public void createAndUploadTexture()
    {
        this.glTextureId = GL11.glGenTextures();
        GL11.glBindTexture(this.textureTarget, this.glTextureId);
        System.out.printf("Buffer %s %x %d is %s\n",textureName, textureTarget, glTextureId, textureData);
        textureData.position(textureData.limit());
        uploadTexture();
    }
}
