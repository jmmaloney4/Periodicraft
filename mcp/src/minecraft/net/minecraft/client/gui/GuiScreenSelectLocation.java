package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.mco.Location;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class GuiScreenSelectLocation extends GuiScreen
{
    protected GuiScreenCreateOnlineWorld field_96242_a;
    private int field_96238_b = -1;
    private SelectionListLocation field_96239_c;
    private GuiSmallButton field_96237_d;
    private Location field_96243_n;
    private List field_96244_o;
    private String field_96241_p;
    private String field_96240_q;

    public GuiScreenSelectLocation(GuiScreenCreateOnlineWorld par1, List par2, Location par3, String par4Str, String par5Str)
    {
        this.field_96242_a = par1;
        this.field_96244_o = par2;
        this.field_96243_n = par3;
        this.field_96241_p = par4Str;
        this.field_96240_q = par5Str;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        this.buttonList.add(this.field_96237_d = new GuiSmallButton(6, this.width / 2 - 75, this.height - 38, stringtranslate.translateKey("gui.done")));
        this.field_96239_c = new SelectionListLocation(this);
        this.field_96239_c.registerScrollButtons(this.buttonList, 7, 8);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            switch (par1GuiButton.id)
            {
                case 5:
                    break;
                case 6:
                    this.field_96242_a.func_96251_a(this.field_96243_n, this.field_96241_p, this.field_96240_q);
                    this.mc.displayGuiScreen(this.field_96242_a);
                    break;
                default:
                    this.field_96239_c.actionPerformed(par1GuiButton);
            }
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.field_96239_c.drawScreen(par1, par2, par3);

        if (this.field_96238_b <= 0)
        {
            this.mc.texturePackList.updateAvaliableTexturePacks();
            this.field_96238_b += 20;
        }

        StringTranslate stringtranslate = StringTranslate.getInstance();
        this.drawCenteredString(this.fontRenderer, stringtranslate.translateKey("mco.create.world.location.title"), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRenderer, "(" + stringtranslate.translateKey("mco.create.world.location.warning") + ")", this.width / 2, this.height - 56, 8421504);
        super.drawScreen(par1, par2, par3);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        --this.field_96238_b;
    }

    static Minecraft func_96232_a(GuiScreenSelectLocation par0GuiScreenSelectLocation)
    {
        return par0GuiScreenSelectLocation.mc;
    }

    static List func_96236_b(GuiScreenSelectLocation par0GuiScreenSelectLocation)
    {
        return par0GuiScreenSelectLocation.field_96244_o;
    }

    static Location func_96234_a(GuiScreenSelectLocation par0GuiScreenSelectLocation, Location par1Location)
    {
        return par0GuiScreenSelectLocation.field_96243_n = par1Location;
    }

    static GuiSmallButton func_96230_c(GuiScreenSelectLocation par0GuiScreenSelectLocation)
    {
        return par0GuiScreenSelectLocation.field_96237_d;
    }

    static Location func_96233_d(GuiScreenSelectLocation par0GuiScreenSelectLocation)
    {
        return par0GuiScreenSelectLocation.field_96243_n;
    }

    static FontRenderer func_96231_e(GuiScreenSelectLocation par0GuiScreenSelectLocation)
    {
        return par0GuiScreenSelectLocation.fontRenderer;
    }

    static FontRenderer func_96235_f(GuiScreenSelectLocation par0GuiScreenSelectLocation)
    {
        return par0GuiScreenSelectLocation.fontRenderer;
    }
}
