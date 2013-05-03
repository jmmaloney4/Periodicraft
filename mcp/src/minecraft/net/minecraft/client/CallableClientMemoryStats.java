package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
public class CallableClientMemoryStats implements Callable
{
    final Minecraft theMinecraft;

    public CallableClientMemoryStats(Minecraft par1)
    {
        this.theMinecraft = par1;
    }

    public String callClientMemoryStats()
    {
        int i = this.theMinecraft.theWorld.getWorldVec3Pool().getPoolSize();
        int j = 56 * i;
        int k = j / 1024 / 1024;
        int l = this.theMinecraft.theWorld.getWorldVec3Pool().func_82590_d();
        int i1 = 56 * l;
        int j1 = i1 / 1024 / 1024;
        return i + " (" + j + " bytes; " + k + " MB) allocated, " + l + " (" + i1 + " bytes; " + j1 + " MB) used";
    }

    public Object call()
    {
        return this.callClientMemoryStats();
    }
}
