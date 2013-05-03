package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

@SideOnly(Side.CLIENT)
class TimerTaskMcoServerListUpdate extends TimerTask
{
    McoClient field_98262_a;

    final McoServerList field_98261_b;

    private TimerTaskMcoServerListUpdate(McoServerList par1)
    {
        this.field_98261_b = par1;
        this.field_98262_a = new McoClient(McoServerList.func_100014_a(this.field_98261_b));
    }

    public void run()
    {
        if (!McoServerList.func_98249_b(this.field_98261_b))
        {
            this.func_98260_a();
        }
    }

    private void func_98260_a()
    {
        try
        {
            List list = this.field_98262_a.func_96382_a().field_96430_d;
            this.func_101018_a(list);
            McoServerList.func_98247_a(this.field_98261_b, list);
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            ;
        }
        catch (IOException ioexception)
        {
            System.err.println(ioexception);
        }
    }

    private void func_101018_a(List par1List)
    {
        Collections.sort(par1List, new TimerTaskMcoServerListUpdateComparator(this, McoServerList.func_100014_a(this.field_98261_b).username, (McoServerListINNER1)null));
    }

    TimerTaskMcoServerListUpdate(McoServerList par1, McoServerListINNER1 par2)
    {
        this(par1);
    }
}
