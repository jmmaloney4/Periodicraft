package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntitySkullRenderer extends TileEntitySpecialRenderer
{
    public static TileEntitySkullRenderer skullRenderer;
    private ModelSkeletonHead field_82396_c = new ModelSkeletonHead(0, 0, 64, 32);
    private ModelSkeletonHead field_82395_d = new ModelSkeletonHead(0, 0, 64, 64);

    /**
     * Render a skull tile entity.
     */
    public void renderTileEntitySkullAt(TileEntitySkull par1TileEntitySkull, double par2, double par4, double par6, float par8)
    {
        this.func_82393_a((float)par2, (float)par4, (float)par6, par1TileEntitySkull.getBlockMetadata() & 7, (float)(par1TileEntitySkull.func_82119_b() * 360) / 16.0F, par1TileEntitySkull.getSkullType(), par1TileEntitySkull.getExtraType());
    }

    /**
     * Associate a TileEntityRenderer with this TileEntitySpecialRenderer
     */
    public void setTileEntityRenderer(TileEntityRenderer par1TileEntityRenderer)
    {
        super.setTileEntityRenderer(par1TileEntityRenderer);
        skullRenderer = this;
    }

    public void func_82393_a(float par1, float par2, float par3, int par4, float par5, int par6, String par7Str)
    {
        ModelSkeletonHead modelskeletonhead = this.field_82396_c;

        switch (par6)
        {
            case 0:
            default:
                this.bindTextureByName("/mob/skeleton.png");
                break;
            case 1:
                this.bindTextureByName("/mob/skeleton_wither.png");
                break;
            case 2:
                this.bindTextureByName("/mob/zombie.png");
                modelskeletonhead = this.field_82395_d;
                break;
            case 3:
                if (par7Str != null && par7Str.length() > 0)
                {
                    String s1 = "http://skins.minecraft.net/MinecraftSkins/" + StringUtils.stripControlCodes(par7Str) + ".png";

                    if (!skullRenderer.tileEntityRenderer.renderEngine.hasImageData(s1))
                    {
                        skullRenderer.tileEntityRenderer.renderEngine.obtainImageData(s1, new ImageBufferDownload());
                    }

                    this.bindTextureByURL(s1, "/mob/char.png");
                }
                else
                {
                    this.bindTextureByName("/mob/char.png");
                }

                break;
            case 4:
                this.bindTextureByName("/mob/creeper.png");
        }

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_CULL_FACE);

        if (par4 != 1)
        {
            switch (par4)
            {
                case 2:
                    GL11.glTranslatef(par1 + 0.5F, par2 + 0.25F, par3 + 0.74F);
                    break;
                case 3:
                    GL11.glTranslatef(par1 + 0.5F, par2 + 0.25F, par3 + 0.26F);
                    par5 = 180.0F;
                    break;
                case 4:
                    GL11.glTranslatef(par1 + 0.74F, par2 + 0.25F, par3 + 0.5F);
                    par5 = 270.0F;
                    break;
                case 5:
                default:
                    GL11.glTranslatef(par1 + 0.26F, par2 + 0.25F, par3 + 0.5F);
                    par5 = 90.0F;
            }
        }
        else
        {
            GL11.glTranslatef(par1 + 0.5F, par2, par3 + 0.5F);
        }

        float f4 = 0.0625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        modelskeletonhead.render((Entity)null, 0.0F, 0.0F, 0.0F, par5, 0.0F, f4);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntitySkullAt((TileEntitySkull)par1TileEntity, par2, par4, par6, par8);
    }
}
