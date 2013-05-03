package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ThreadShutdown extends Thread
{
    public void run()
    {
        Minecraft.stopIntegratedServer();
    }
}
