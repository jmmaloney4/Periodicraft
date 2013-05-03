package net.minecraft.client.texturepacks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiTexturePackSlot extends GuiSlot
{
    final GuiTexturePacks parentTexturePackGui;

    public GuiTexturePackSlot(GuiTexturePacks par1GuiTexturePacks)
    {
        super(GuiTexturePacks.func_73950_a(par1GuiTexturePacks), par1GuiTexturePacks.width, par1GuiTexturePacks.height, 32, par1GuiTexturePacks.height - 55 + 4, 36);
        this.parentTexturePackGui = par1GuiTexturePacks;
    }

    /**
     * Gets the size of the current slot list.
     */
    protected int getSize()
    {
        return GuiTexturePacks.func_73955_b(this.parentTexturePackGui).texturePackList.availableTexturePacks().size();
    }

    /**
     * the element in the slot that was clicked, boolean for wether it was double clicked or not
     */
    protected void elementClicked(int par1, boolean par2)
    {
        List list = GuiTexturePacks.func_73958_c(this.parentTexturePackGui).texturePackList.availableTexturePacks();

        try
        {
            GuiTexturePacks.func_73951_d(this.parentTexturePackGui).texturePackList.setTexturePack((ITexturePack)list.get(par1));
            GuiTexturePacks.func_73952_e(this.parentTexturePackGui).renderEngine.refreshTextures();
            GuiTexturePacks.func_73962_f(this.parentTexturePackGui).renderGlobal.loadRenderers();
        }
        catch (Exception exception)
        {
            GuiTexturePacks.func_73959_g(this.parentTexturePackGui).texturePackList.setTexturePack((ITexturePack)list.get(0));
            GuiTexturePacks.func_73957_h(this.parentTexturePackGui).renderEngine.refreshTextures();
            GuiTexturePacks.func_73956_i(this.parentTexturePackGui).renderGlobal.loadRenderers();
        }
    }

    /**
     * returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int par1)
    {
        List list = GuiTexturePacks.func_73953_j(this.parentTexturePackGui).texturePackList.availableTexturePacks();
        return GuiTexturePacks.func_73961_k(this.parentTexturePackGui).texturePackList.getSelectedTexturePack() == list.get(par1);
    }

    /**
     * return the height of the content being scrolled
     */
    protected int getContentHeight()
    {
        return this.getSize() * 36;
    }

    protected void drawBackground()
    {
        this.parentTexturePackGui.drawDefaultBackground();
    }

    protected void drawSlot(int par1, int par2, int par3, int par4, Tessellator par5Tessellator)
    {
        ITexturePack itexturepack = (ITexturePack)GuiTexturePacks.func_96143_l(this.parentTexturePackGui).texturePackList.availableTexturePacks().get(par1);
        itexturepack.bindThumbnailTexture(GuiTexturePacks.func_96142_m(this.parentTexturePackGui).renderEngine);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        par5Tessellator.startDrawingQuads();
        par5Tessellator.setColorOpaque_I(16777215);
        par5Tessellator.addVertexWithUV((double)par2, (double)(par3 + par4), 0.0D, 0.0D, 1.0D);
        par5Tessellator.addVertexWithUV((double)(par2 + 32), (double)(par3 + par4), 0.0D, 1.0D, 1.0D);
        par5Tessellator.addVertexWithUV((double)(par2 + 32), (double)par3, 0.0D, 1.0D, 0.0D);
        par5Tessellator.addVertexWithUV((double)par2, (double)par3, 0.0D, 0.0D, 0.0D);
        par5Tessellator.draw();
        String s = itexturepack.getTexturePackFileName();

        if (!itexturepack.isCompatible())
        {
            s = EnumChatFormatting.DARK_RED + StatCollector.translateToLocal("texturePack.incompatible") + " - " + s;
        }

        if (s.length() > 32)
        {
            s = s.substring(0, 32).trim() + "...";
        }

        this.parentTexturePackGui.drawString(GuiTexturePacks.func_73954_n(this.parentTexturePackGui), s, par2 + 32 + 2, par3 + 1, 16777215);
        this.parentTexturePackGui.drawString(GuiTexturePacks.func_96145_o(this.parentTexturePackGui), itexturepack.getFirstDescriptionLine(), par2 + 32 + 2, par3 + 12, 8421504);
        this.parentTexturePackGui.drawString(GuiTexturePacks.func_96144_p(this.parentTexturePackGui), itexturepack.getSecondDescriptionLine(), par2 + 32 + 2, par3 + 12 + 10, 8421504);
    }
}
