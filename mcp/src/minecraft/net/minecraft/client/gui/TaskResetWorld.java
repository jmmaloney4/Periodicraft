package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class TaskResetWorld extends TaskLongRunning
{
    private final long field_96591_c;

    final GuiScreenResetWorld field_96592_a;

    public TaskResetWorld(GuiScreenResetWorld par1GuiScreenResetWorld, long par2)
    {
        this.field_96592_a = par1GuiScreenResetWorld;
        this.field_96591_c = par2;
    }

    public void run()
    {
        McoClient mcoclient = new McoClient(this.func_96578_b().session);
        String s = StringTranslate.getInstance().translateKey("mco.reset.world.resetting.screen.title");
        this.func_96576_b(s);

        try
        {
            mcoclient.func_96376_d(this.field_96591_c);
            GuiScreenResetWorld.func_96147_b(this.field_96592_a).displayGuiScreen(GuiScreenResetWorld.func_96148_a(this.field_96592_a));
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            this.func_96575_a(exceptionmcoservice.field_96391_b);
        }
        catch (IOException ioexception)
        {
            ;
        }
    }
}
