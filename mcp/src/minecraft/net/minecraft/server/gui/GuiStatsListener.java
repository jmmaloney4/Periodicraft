package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SideOnly(Side.SERVER)
class GuiStatsListener implements ActionListener
{
    final GuiStatsComponent statsComponent;

    GuiStatsListener(GuiStatsComponent par1GuiStatsComponent)
    {
        this.statsComponent = par1GuiStatsComponent;
    }

    public void actionPerformed(ActionEvent par1ActionEvent)
    {
        GuiStatsComponent.update(this.statsComponent);
    }
}
