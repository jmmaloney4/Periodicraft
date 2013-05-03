package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.server.dedicated.DedicatedServer;

@SideOnly(Side.SERVER)
final class ServerWindowAdapter extends WindowAdapter
{
    /** The Minecraft instance. */
    final DedicatedServer mc;

    ServerWindowAdapter(DedicatedServer par1DedicatedServer)
    {
        this.mc = par1DedicatedServer;
    }

    public void windowClosing(WindowEvent par1WindowEvent)
    {
        this.mc.initiateShutdown();

        while (!this.mc.isServerStopped())
        {
            try
            {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }

        System.exit(0);
    }
}
