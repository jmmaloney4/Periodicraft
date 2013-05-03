package net.minecraft.client.renderer.texture;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.texturepacks.ITexturePack;
import net.minecraft.util.Icon;
import net.minecraft.util.Tuple;

@SideOnly(Side.CLIENT)
public class TextureStitched implements Icon
{
    private final String textureName;

    /** texture sheet containing this texture */
    protected Texture textureSheet;
    protected List textureList;
    private List listAnimationTuples;
    protected boolean rotated;

    /** x position of this icon on the texture sheet in pixels */
    protected int originX;

    /** y position of this icon on the texture sheet in pixels */
    protected int originY;

    /** width of this icon in pixels */
    private int width;

    /** height of this icon in pixels */
    private int height;
    private float minU;
    private float maxU;
    private float minV;
    private float maxV;
    private float widthNorm;
    private float heightNorm;
    protected int frameCounter = 0;
    protected int tickCounter = 0;

    public static TextureStitched makeTextureStitched(String par0Str)
    {
        return (TextureStitched)("clock".equals(par0Str) ? new TextureClock() : ("compass".equals(par0Str) ? new TextureCompass() : new TextureStitched(par0Str)));
    }

    protected TextureStitched(String par1)
    {
        this.textureName = par1;
    }

    public void init(Texture par1Texture, List par2List, int par3, int par4, int par5, int par6, boolean par7)
    {
        this.textureSheet = par1Texture;
        this.textureList = par2List;
        this.originX = par3;
        this.originY = par4;
        this.width = par5;
        this.height = par6;
        this.rotated = par7;
        float f = 0.01F / (float)par1Texture.getWidth();
        float f1 = 0.01F / (float)par1Texture.getHeight();
        this.minU = (float)par3 / (float)par1Texture.getWidth() + f;
        this.maxU = (float)(par3 + par5) / (float)par1Texture.getWidth() - f;
        this.minV = (float)par4 / (float)par1Texture.getHeight() + f1;
        this.maxV = (float)(par4 + par6) / (float)par1Texture.getHeight() - f1;
        this.widthNorm = (float)par5 / 16.0F;
        this.heightNorm = (float)par6 / 16.0F;
        TextureFXManager.instance().getHelper().doTextureUpload(this);
        if (this.rotated)
        {
            TextureFXManager.instance().getHelper().rotateTexture(this.textureSheet, this.textureSheet.getTextureData());
        }
    }

    public void copyFrom(TextureStitched par1TextureStitched)
    {
        this.init(par1TextureStitched.textureSheet, par1TextureStitched.textureList, par1TextureStitched.originX, par1TextureStitched.originY, par1TextureStitched.width, par1TextureStitched.height, par1TextureStitched.rotated);
    }

    /**
     * Returns the X position of this icon on its texture sheet, in pixels.
     */
    public int getOriginX()
    {
        return this.originX;
    }

    /**
     * Returns the Y position of this icon on its texture sheet, in pixels.
     */
    public int getOriginY()
    {
        return this.originY;
    }

    /**
     * Returns the minimum U coordinate to use when rendering with this icon.
     */
    public float getMinU()
    {
        return this.minU;
    }

    /**
     * Returns the maximum U coordinate to use when rendering with this icon.
     */
    public float getMaxU()
    {
        return this.maxU;
    }

    /**
     * Gets a U coordinate on the icon. 0 returns uMin and 16 returns uMax. Other arguments return in-between values.
     */
    public float getInterpolatedU(double par1)
    {
        float f = this.maxU - this.minU;
        return this.minU + f * ((float)par1 / 16.0F);
    }

    /**
     * Returns the minimum V coordinate to use when rendering with this icon.
     */
    public float getMinV()
    {
        return this.minV;
    }

    /**
     * Returns the maximum V coordinate to use when rendering with this icon.
     */
    public float getMaxV()
    {
        return this.maxV;
    }

    /**
     * Gets a V coordinate on the icon. 0 returns vMin and 16 returns vMax. Other arguments return in-between values.
     */
    public float getInterpolatedV(double par1)
    {
        float f = this.maxV - this.minV;
        return this.minV + f * ((float)par1 / 16.0F);
    }

    public String getIconName()
    {
        return this.textureName;
    }

    /**
     * Returns the width of the texture sheet this icon is on, in pixels.
     */
    public int getSheetWidth()
    {
        return this.textureSheet.getWidth();
    }

    /**
     * Returns the height of the texture sheet this icon is on, in pixels.
     */
    public int getSheetHeight()
    {
        return this.textureSheet.getHeight();
    }

    public void updateAnimation()
    {
        if (this.listAnimationTuples != null)
        {
            Tuple tuple = (Tuple)this.listAnimationTuples.get(this.frameCounter);
            ++this.tickCounter;

            if (this.tickCounter >= ((Integer)tuple.getSecond()).intValue())
            {
                int i = ((Integer)tuple.getFirst()).intValue();
                this.frameCounter = (this.frameCounter + 1) % this.listAnimationTuples.size();
                this.tickCounter = 0;
                tuple = (Tuple)this.listAnimationTuples.get(this.frameCounter);
                int j = ((Integer)tuple.getFirst()).intValue();

                if (i != j && j >= 0 && j < this.textureList.size())
                {
                    this.textureSheet.copyFrom(this.originX, this.originY, (Texture)this.textureList.get(j), false); //FML: We rotate the textures in init.
                }
            }
        }
        else
        {
            int k = this.frameCounter;
            this.frameCounter = (this.frameCounter + 1) % this.textureList.size();

            if (k != this.frameCounter)
            {
                this.textureSheet.copyFrom(this.originX, this.originY, (Texture)this.textureList.get(this.frameCounter), false); //FML: We rotate the textures in init.
            }
        }
    }

    public void readAnimationInfo(BufferedReader par1BufferedReader)
    {
        ArrayList arraylist = new ArrayList();

        try
        {
            for (String s = par1BufferedReader.readLine(); s != null; s = par1BufferedReader.readLine())
            {
                s = s.trim();

                if (s.length() > 0)
                {
                    String[] astring = s.split(",");
                    String[] astring1 = astring;
                    int i = astring.length;

                    for (int j = 0; j < i; ++j)
                    {
                        String s1 = astring1[j];
                        int k = s1.indexOf(42);

                        if (k > 0)
                        {
                            Integer integer = new Integer(s1.substring(0, k));
                            Integer integer1 = new Integer(s1.substring(k + 1));
                            arraylist.add(new Tuple(integer, integer1));
                        }
                        else
                        {
                            arraylist.add(new Tuple(new Integer(s1), Integer.valueOf(1)));
                        }
                    }
                }
            }
        }
        catch (Exception exception)
        {
            System.err.println("Failed to read animation info for " + this.textureName + ": " + exception.getMessage());
        }

        if (!arraylist.isEmpty() && arraylist.size() < 600)
        {
            this.listAnimationTuples = arraylist;
        }
    }

    public void createAndUploadTextures()
    {
        for (Texture t : ((List<Texture>)textureList))
        {
            t.createAndUploadTexture();
        }
    }

    //===================================================================================================
    //                                           Forge Start
    //===================================================================================================
    /**
     * Called when texture packs are refreshed, from TextureManager.createNewTexture,
     * allows for finer control over loading the animation lists and verification of the image.
     * If the return value from this is true, no further loading will be done by vanilla code.
     * 
     * You need to add all Texture's to the textures argument. At the end of this function at least one
     * entry should be in that argument, or a error should of been thrown.
     * 
     * @param manager The invoking manager
     * @param texturepack Current texture pack
     * @param name The name of the texture
     * @param fileName Resource path for this texture
     * @param image Buffered image of the loaded resource
     * @param textures ArrayList of element type Texture, split textures should be added to this list for the stitcher to handle.  
     * @return Return true to skip further vanilla texture loading for this texture
     */
    public boolean loadTexture(TextureManager manager, ITexturePack texturepack, String name, String fileName, BufferedImage image, ArrayList textures)
    {
        return false;
    }
}
