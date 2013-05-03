package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerAddress;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.util.StringTranslate;

@SideOnly(Side.CLIENT)
public class TaskOnlineConnect extends TaskLongRunning
{
    private NetClientHandler field_96586_a;
    private final McoServer field_96585_c;
    private final GuiScreen field_96584_d;

    public TaskOnlineConnect(GuiScreen par1GuiScreen, McoServer par2McoServer)
    {
        this.field_96584_d = par1GuiScreen;
        this.field_96585_c = par2McoServer;
    }

    public void run()
    {
        this.func_96576_b(StringTranslate.getInstance().translateKey("mco.connect.connecting"));
        McoClient mcoclient = new McoClient(this.func_96578_b().session);
        boolean flag = false;
        boolean flag1 = false;
        McoServerAddress mcoserveraddress = null;

        for (int i = 0; i < 10 && !this.func_96577_c(); ++i)
        {
            try
            {
                mcoserveraddress = mcoclient.func_96374_a(this.field_96585_c.field_96408_a);
                flag = true;
            }
            catch (ExceptionRetryCall exceptionretrycall)
            {
                ;
            }
            catch (ExceptionMcoService exceptionmcoservice)
            {
                flag1 = true;
                this.func_96575_a(exceptionmcoservice.getLocalizedMessage());
                break;
            }
            catch (IOException ioexception)
            {
                ;
            }
            catch (Exception exception)
            {
                flag1 = true;
                this.func_96575_a(exception.getLocalizedMessage());
            }

            if (flag)
            {
                break;
            }

            this.func_96581_e();
        }

        if (!this.func_96577_c() && !flag1)
        {
            if (flag)
            {
                ServerAddress serveraddress = ServerAddress.func_78860_a(mcoserveraddress.field_96417_a);
                this.func_96582_a(serveraddress.getIP(), serveraddress.getPort());
            }
            else
            {
                this.func_96578_b().displayGuiScreen(this.field_96584_d);
            }
        }
    }

    private void func_96581_e()
    {
        try
        {
            Thread.sleep(5000L);
        }
        catch (InterruptedException interruptedexception)
        {
            System.err.println(interruptedexception);
        }
    }

    private void func_96582_a(String par1Str, int par2)
    {
        (new ThreadOnlineConnect(this, par1Str, par2)).start();
    }

    public void func_96573_a()
    {
        if (this.field_96586_a != null)
        {
            this.field_96586_a.processReadPackets();
        }
    }

    static NetClientHandler func_96583_a(TaskOnlineConnect par0TaskOnlineConnect, NetClientHandler par1NetClientHandler)
    {
        return par0TaskOnlineConnect.field_96586_a = par1NetClientHandler;
    }

    static GuiScreen func_98172_a(TaskOnlineConnect par0TaskOnlineConnect)
    {
        return par0TaskOnlineConnect.field_96584_d;
    }

    static NetClientHandler func_96580_a(TaskOnlineConnect par0TaskOnlineConnect)
    {
        return par0TaskOnlineConnect.field_96586_a;
    }
}
