package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class CallableParticleScreenName implements Callable
{
    final Minecraft theMinecraft;

    public CallableParticleScreenName(Minecraft par1Minecraft)
    {
        this.theMinecraft = par1Minecraft;
    }

    public String callParticleScreenName()
    {
        return this.theMinecraft.currentScreen.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.callParticleScreenName();
    }
}
