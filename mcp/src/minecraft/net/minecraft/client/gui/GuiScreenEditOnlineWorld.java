package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenEditOnlineWorld extends GuiScreen
{
    private GuiScreen field_96204_a;
    private GuiScreen field_96202_b;
    private GuiTextField field_96203_c;
    private GuiTextField field_96201_d;
    private McoServer field_96205_n;
    private GuiButton field_96206_o;

    public GuiScreenEditOnlineWorld(GuiScreen par1GuiScreen, GuiScreen par2GuiScreen, McoServer par3McoServer)
    {
        this.field_96204_a = par1GuiScreen;
        this.field_96202_b = par2GuiScreen;
        this.field_96205_n = par3McoServer;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.field_96201_d.updateCursorCounter();
        this.field_96203_c.updateCursorCounter();
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(this.field_96206_o = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, stringtranslate.translateKey("mco.configure.world.buttons.done")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, stringtranslate.translateKey("gui.cancel")));
        this.field_96201_d = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 66, 200, 20);
        this.field_96201_d.setFocused(true);
        this.field_96201_d.setMaxStringLength(32);
        this.field_96201_d.setText(this.field_96205_n.func_96398_b());
        this.field_96203_c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 106, 200, 20);
        this.field_96203_c.setMaxStringLength(32);
        this.field_96203_c.setText(this.field_96205_n.func_96397_a());
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id == 1)
            {
                this.mc.displayGuiScreen(this.field_96204_a);
            }
            else if (par1GuiButton.id == 0)
            {
                this.func_96200_g();
            }
        }
    }

    private void func_96200_g()
    {
        McoClient mcoclient = new McoClient(this.mc.session);

        try
        {
            String s = this.field_96203_c.getText() != null && !this.field_96203_c.getText().trim().equals("") ? this.field_96203_c.getText() : "";
            mcoclient.func_96384_a(this.field_96205_n.field_96408_a, this.field_96201_d.getText(), s);
            this.field_96205_n.func_96399_a(this.field_96201_d.getText());
            this.field_96205_n.func_96400_b(this.field_96203_c.getText());
            this.mc.displayGuiScreen(new GuiScreenConfigureWorld(this.field_96202_b, this.field_96205_n));
        }
        catch (Exception exception)
        {
            ;
        }
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        this.field_96201_d.textboxKeyTyped(par1, par2);
        this.field_96203_c.textboxKeyTyped(par1, par2);

        if (par1 == 9)
        {
            if (this.field_96201_d.isFocused())
            {
                this.field_96201_d.setFocused(false);
                this.field_96203_c.setFocused(true);
            }
            else
            {
                this.field_96201_d.setFocused(true);
                this.field_96203_c.setFocused(false);
            }
        }

        if (par1 == 13)
        {
            this.func_96200_g();
        }

        this.field_96206_o.enabled = this.field_96201_d.getText() != null && !this.field_96201_d.getText().trim().equals("");
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        this.field_96203_c.mouseClicked(par1, par2, par3);
        this.field_96201_d.mouseClicked(par1, par2, par3);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, stringtranslate.translateKey("mco.configure.world.edit.title"), this.width / 2, 17, 16777215);
        this.drawString(this.fontRenderer, stringtranslate.translateKey("mco.configure.world.name"), this.width / 2 - 100, 53, 10526880);
        this.drawString(this.fontRenderer, stringtranslate.translateKey("mco.configure.world.description"), this.width / 2 - 100, 94, 10526880);
        this.field_96201_d.drawTextBox();
        this.field_96203_c.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }
}
