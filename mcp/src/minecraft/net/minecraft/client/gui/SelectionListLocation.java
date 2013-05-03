package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.Location;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class SelectionListLocation extends GuiSlot
{
    final GuiScreenSelectLocation field_96295_a;

    public SelectionListLocation(GuiScreenSelectLocation par1)
    {
        super(GuiScreenSelectLocation.func_96232_a(par1), par1.width, par1.height, 32, par1.height - 65 + 4, 18);
        this.field_96295_a = par1;
    }

    /**
     * Gets the size of the current slot list.
     */
    protected int getSize()
    {
        return GuiScreenSelectLocation.func_96236_b(this.field_96295_a).size();
    }

    /**
     * the element in the slot that was clicked, boolean for wether it was double clicked or not
     */
    protected void elementClicked(int par1, boolean par2)
    {
        GuiScreenSelectLocation.func_96234_a(this.field_96295_a, (Location)GuiScreenSelectLocation.func_96236_b(this.field_96295_a).get(par1));
        GuiScreenSelectLocation.func_96230_c(this.field_96295_a).displayString = StringTranslate.getInstance().translateKey("gui.done");
    }

    /**
     * returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int par1)
    {
        return ((Location)GuiScreenSelectLocation.func_96236_b(this.field_96295_a).get(par1)).field_96395_b.equals(GuiScreenSelectLocation.func_96233_d(this.field_96295_a).field_96395_b);
    }

    /**
     * return the height of the content being scrolled
     */
    protected int getContentHeight()
    {
        return this.getSize() * 18;
    }

    protected void drawBackground()
    {
        this.field_96295_a.drawDefaultBackground();
    }

    protected void drawSlot(int par1, int par2, int par3, int par4, Tessellator par5Tessellator)
    {
        GuiScreenSelectLocation.func_96231_e(this.field_96295_a).setBidiFlag(true);
        this.field_96295_a.drawCenteredString(GuiScreenSelectLocation.func_96235_f(this.field_96295_a), ((Location)GuiScreenSelectLocation.func_96236_b(this.field_96295_a).get(par1)).field_96395_b, this.field_96295_a.width / 2, par3 + 1, 16777215);
    }
}
