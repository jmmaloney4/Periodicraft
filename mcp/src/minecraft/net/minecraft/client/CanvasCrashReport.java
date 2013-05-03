package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Canvas;
import java.awt.Dimension;

@SideOnly(Side.CLIENT)
class CanvasCrashReport extends Canvas
{
    public CanvasCrashReport(int par1)
    {
        this.setPreferredSize(new Dimension(par1, par1));
        this.setMinimumSize(new Dimension(par1, par1));
    }
}
