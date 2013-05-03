package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.McoClient;

@SideOnly(Side.CLIENT)
class ThreadOnlineScreen extends Thread
{
    final GuiScreenOnlineServers field_98173_a;

    ThreadOnlineScreen(GuiScreenOnlineServers par1GuiScreenOnlineServers)
    {
        this.field_98173_a = par1GuiScreenOnlineServers;
    }

    public void run()
    {
        McoClient mcoclient = new McoClient(GuiScreenOnlineServers.func_96177_a(this.field_98173_a).session);

        try
        {
            GuiScreenOnlineServers.func_98081_a(this.field_98173_a, mcoclient.func_96379_c());
        }
        catch (Exception exception)
        {
            GuiScreenOnlineServers.func_98081_a(this.field_98173_a, 0);
        }
    }
}
