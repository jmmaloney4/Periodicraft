package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Canvas;
import java.awt.Dimension;

@SideOnly(Side.CLIENT)
class CanvasCrashReport extends Canvas {

   public CanvasCrashReport(int p_i3008_1_) {
      this.setPreferredSize(new Dimension(p_i3008_1_, p_i3008_1_));
      this.setMinimumSize(new Dimension(p_i3008_1_, p_i3008_1_));
   }
}
