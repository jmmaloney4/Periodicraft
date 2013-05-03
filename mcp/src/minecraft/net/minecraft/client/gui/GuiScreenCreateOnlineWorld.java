package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.mco.Location;
import net.minecraft.util.StringTranslate;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenCreateOnlineWorld extends GuiScreen
{
    private GuiScreen field_96260_a;
    private GuiTextField field_96255_b;
    private GuiTextField field_96257_c;
    private String field_98108_c;
    private String field_98109_n;
    private static int field_96253_d = 0;
    private static int field_96261_n = 1;
    private static int field_96262_o = 2;
    private volatile List field_96259_p;
    private volatile Location field_96258_q = null;
    private boolean field_96256_r = false;
    private String field_96254_s = "You must enter a name!";

    public GuiScreenCreateOnlineWorld(GuiScreen par1GuiScreen)
    {
        super.buttonList = Collections.synchronizedList(new ArrayList());
        this.field_96260_a = par1GuiScreen;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.field_96257_c.updateCursorCounter();
        this.field_96255_b.updateCursorCounter();
        this.field_98108_c = this.field_96257_c.getText();
        this.field_98109_n = this.field_96255_b.getText();
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(field_96253_d, this.width / 2 - 100, this.height / 4 + 120 + 17, 97, 20, stringtranslate.translateKey("mco.create.world")));
        this.buttonList.add(new GuiButton(field_96261_n, this.width / 2 + 5, this.height / 4 + 120 + 17, 95, 20, stringtranslate.translateKey("gui.cancel")));
        this.field_96257_c = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 55, 200, 20);
        this.field_96257_c.setFocused(true);

        if (this.field_98108_c != null)
        {
            this.field_96257_c.setText(this.field_98108_c);
        }

        this.field_96255_b = new GuiTextField(this.fontRenderer, this.width / 2 - 100, 95, 200, 20);
        this.field_96255_b.setMaxStringLength(128);

        if (this.field_98109_n != null)
        {
            this.field_96255_b.setText(this.field_98109_n);
        }

        this.func_96250_g();
    }

    private void func_96250_g()
    {
        if (this.field_96258_q == null)
        {
            (new ThreadCreateOnlineWorldScreen(this)).start();
        }
        else
        {
            this.buttonList.add(new GuiButton(field_96262_o, this.width / 2 - 100, 135, this.field_96258_q.field_96395_b));
        }
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
            if (par1GuiButton.id == field_96261_n)
            {
                this.mc.displayGuiScreen(this.field_96260_a);
            }
            else if (par1GuiButton.id == field_96253_d)
            {
                this.func_96252_h();
            }
            else if (par1GuiButton.id == field_96262_o)
            {
                GuiScreenSelectLocation guiscreenselectlocation = new GuiScreenSelectLocation(this, this.field_96259_p, this.field_96258_q, this.field_96257_c.getText(), this.field_96255_b.getText());
                this.mc.displayGuiScreen(guiscreenselectlocation);
            }
        }
    }

    private void func_96252_h()
    {
        if (this.func_96249_i())
        {
            String s = this.field_96255_b.getText() != null && !this.field_96255_b.getText().trim().equals("") ? this.field_96255_b.getText() : "Minecraft Realms Server";
            TaskWorldCreation taskworldcreation = new TaskWorldCreation(this, this.field_96257_c.getText(), s, this.field_96258_q == null ? "NO_LOCATION" : this.field_96258_q.field_96396_a);
            GuiScreenLongRunningTask guiscreenlongrunningtask = new GuiScreenLongRunningTask(this.mc, this.field_96260_a, taskworldcreation);
            guiscreenlongrunningtask.func_98117_g();
            this.mc.displayGuiScreen(guiscreenlongrunningtask);
        }
    }

    private boolean func_96249_i()
    {
        this.field_96256_r = this.field_96257_c.getText() == null || this.field_96257_c.getText().trim().equals("");
        return !this.field_96256_r;
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        this.field_96257_c.textboxKeyTyped(par1, par2);
        this.field_96255_b.textboxKeyTyped(par1, par2);

        if (par1 == 9)
        {
            if (this.field_96257_c.isFocused())
            {
                this.field_96257_c.setFocused(false);
                this.field_96255_b.setFocused(true);
            }
            else
            {
                this.field_96257_c.setFocused(true);
                this.field_96255_b.setFocused(false);
            }
        }

        if (par1 == 13)
        {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        super.mouseClicked(par1, par2, par3);
        this.field_96255_b.mouseClicked(par1, par2, par3);
        this.field_96257_c.mouseClicked(par1, par2, par3);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, stringtranslate.translateKey("mco.selectServer.create"), this.width / 2, 11, 16777215);
        this.drawString(this.fontRenderer, stringtranslate.translateKey("mco.configure.world.name"), this.width / 2 - 100, 42, 10526880);
        this.drawString(this.fontRenderer, stringtranslate.translateKey("mco.configure.world.description"), this.width / 2 - 100, 83, 10526880);

        if (this.field_96258_q != null)
        {
            this.drawString(this.fontRenderer, stringtranslate.translateKey("mco.configure.world.location"), this.width / 2 - 100, 124, 10526880);
        }

        if (this.field_96256_r)
        {
            this.drawCenteredString(this.fontRenderer, this.field_96254_s, this.width / 2, 167, 16711680);
        }

        this.field_96257_c.drawTextBox();
        this.field_96255_b.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }

    public void func_96251_a(Location par1Location, String par2Str, String par3Str)
    {
        this.field_96258_q = par1Location;
        this.field_96257_c.setText(par2Str);
        this.field_96255_b.setText(par3Str);
    }

    static Minecraft func_96248_a(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld)
    {
        return par0GuiScreenCreateOnlineWorld.mc;
    }

    static List func_98102_a(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld, List par1List)
    {
        return par0GuiScreenCreateOnlineWorld.field_96259_p = par1List;
    }

    static Location func_98100_a(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld, Location par1Location)
    {
        return par0GuiScreenCreateOnlineWorld.field_96258_q = par1Location;
    }

    static int func_98106_g()
    {
        return field_96262_o;
    }

    static Location func_98101_b(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld)
    {
        return par0GuiScreenCreateOnlineWorld.field_96258_q;
    }

    static List func_98103_c(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld)
    {
        return par0GuiScreenCreateOnlineWorld.buttonList;
    }

    static Minecraft func_98099_d(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld)
    {
        return par0GuiScreenCreateOnlineWorld.mc;
    }

    static GuiScreen func_96247_b(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld)
    {
        return par0GuiScreenCreateOnlineWorld.field_96260_a;
    }

    static Minecraft func_96246_c(GuiScreenCreateOnlineWorld par0GuiScreenCreateOnlineWorld)
    {
        return par0GuiScreenCreateOnlineWorld.mc;
    }
}
