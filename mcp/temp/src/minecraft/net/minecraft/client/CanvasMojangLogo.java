package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.PanelCrashReport;

@SideOnly(Side.CLIENT)
class CanvasMojangLogo extends Canvas {

   private BufferedImage field_74537_a;


   public CanvasMojangLogo() {
      try {
         this.field_74537_a = ImageIO.read(PanelCrashReport.class.getResource("/gui/crash_logo.png"));
      } catch (IOException var2) {
         ;
      }

      byte var1 = 100;
      this.setPreferredSize(new Dimension(var1, var1));
      this.setMinimumSize(new Dimension(var1, var1));
   }

   public void paint(Graphics p_paint_1_) {
      super.paint(p_paint_1_);
      p_paint_1_.drawImage(this.field_74537_a, this.getWidth() / 2 - this.field_74537_a.getWidth() / 2, 32, (ImageObserver)null);
   }
}
