package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
class ThreadTitleScreen extends Thread
{
    final StringTranslate field_98135_a;

    final int field_98133_b;

    final int field_98134_c;

    final GuiMainMenu field_98132_d;

    ThreadTitleScreen(GuiMainMenu par1GuiMainMenu, StringTranslate par2StringTranslate, int par3, int par4)
    {
        this.field_98132_d = par1GuiMainMenu;
        this.field_98135_a = par2StringTranslate;
        this.field_98133_b = par3;
        this.field_98134_c = par4;
    }

    public void run()
    {
        McoClient mcoclient = new McoClient(GuiMainMenu.func_98058_a(this.field_98132_d).session);
        boolean flag = false;

        for (int i = 0; i < 3; ++i)
        {
            try
            {
                Boolean obool = mcoclient.func_96375_b();

                if (obool.booleanValue())
                {
                    GuiMainMenu.func_98061_a(this.field_98132_d, this.field_98135_a, this.field_98133_b, this.field_98134_c);
                }

                GuiMainMenu.func_98059_a(obool.booleanValue());
            }
            catch (ExceptionRetryCall exceptionretrycall)
            {
                flag = true;
            }
            catch (ExceptionMcoService exceptionmcoservice)
            {
                ;
            }
            catch (IOException ioexception)
            {
                ;
            }

            if (!flag)
            {
                break;
            }

            try
            {
                Thread.sleep(10000L);
            }
            catch (InterruptedException interruptedexception)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
