package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class TaskWorldCreation extends TaskLongRunning
{
    private final String field_96589_c;
    private final String field_96587_d;
    private final String field_96588_e;

    final GuiScreenCreateOnlineWorld field_96590_a;

    public TaskWorldCreation(GuiScreenCreateOnlineWorld par1GuiScreenCreateOnlineWorld, String par2Str, String par3Str, String par4Str)
    {
        this.field_96590_a = par1GuiScreenCreateOnlineWorld;
        this.field_96589_c = par2Str;
        this.field_96587_d = par3Str;
        this.field_96588_e = par4Str;
    }

    public void run()
    {
        String s = StringTranslate.getInstance().translateKey("mco.create.world.wait");
        this.func_96576_b(s);
        McoClient mcoclient = new McoClient(GuiScreenCreateOnlineWorld.func_98099_d(this.field_96590_a).session);

        try
        {
            mcoclient.func_96386_a(this.field_96589_c, this.field_96587_d, this.field_96588_e);
            GuiScreenCreateOnlineWorld.func_96246_c(this.field_96590_a).displayGuiScreen(GuiScreenCreateOnlineWorld.func_96247_b(this.field_96590_a));
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            this.func_96575_a(exceptionmcoservice.field_96391_b);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            ;
        }
        catch (IOException ioexception)
        {
            ;
        }
        catch (Exception exception)
        {
            this.func_96575_a("Failed");
        }
    }
}
