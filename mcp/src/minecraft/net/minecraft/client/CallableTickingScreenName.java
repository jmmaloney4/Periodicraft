package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
public class CallableTickingScreenName implements Callable
{
    /** Reference to the Minecraft object. */
    final Minecraft mc;

    public CallableTickingScreenName(Minecraft par1Minecraft)
    {
        this.mc = par1Minecraft;
    }

    public String getLWJGLVersion()
    {
        return this.mc.currentScreen.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.getLWJGLVersion();
    }
}
