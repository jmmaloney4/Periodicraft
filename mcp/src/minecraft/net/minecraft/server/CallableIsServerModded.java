package net.minecraft.server;

import java.util.concurrent.Callable;

public class CallableIsServerModded implements Callable
{
    /** Reference to the MinecraftServer object. */
    final MinecraftServer mcServer;

    public CallableIsServerModded(MinecraftServer par1)
    {
        this.mcServer = par1;
    }

    public String func_96558_a()
    {
        return this.mcServer.theProfiler.profilingEnabled ? this.mcServer.theProfiler.getNameOfLastSection() : "N/A (disabled)";
    }

    public Object call()
    {
        return this.func_96558_a();
    }
}
