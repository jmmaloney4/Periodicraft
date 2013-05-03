package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SideOnly(Side.CLIENT)
public final class GameWindowListener extends WindowAdapter
{
    public void windowClosing(WindowEvent par1WindowEvent)
    {
        System.err.println("Someone is closing me!");
        System.exit(1);
    }
}
