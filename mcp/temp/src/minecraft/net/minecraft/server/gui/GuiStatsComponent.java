package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.Timer;
import net.minecraft.network.TcpConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.gui.GuiStatsListener;

@SideOnly(Side.SERVER)
public class GuiStatsComponent extends JComponent {

   private static final DecimalFormat field_79020_a = new DecimalFormat("########0.000");
   private int[] field_79018_b = new int[256];
   private int field_79019_c = 0;
   private String[] field_79016_d = new String[11];
   private final MinecraftServer field_79017_e;


   public GuiStatsComponent(MinecraftServer p_i4103_1_) {
      this.field_79017_e = p_i4103_1_;
      this.setPreferredSize(new Dimension(456, 246));
      this.setMinimumSize(new Dimension(456, 246));
      this.setMaximumSize(new Dimension(456, 246));
      (new Timer(500, new GuiStatsListener(this))).start();
      this.setBackground(Color.BLACK);
   }

   private void func_79014_a() {
      long var1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      System.gc();
      this.field_79016_d[0] = "Memory use: " + var1 / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
      this.field_79016_d[1] = "Threads: " + TcpConnection.field_74471_a.get() + " + " + TcpConnection.field_74469_b.get();
      this.field_79016_d[2] = "Avg tick: " + field_79020_a.format(this.func_79015_a(this.field_79017_e.field_71311_j) * 1.0E-6D) + " ms";
      this.field_79016_d[3] = "Avg sent: " + (int)this.func_79015_a(this.field_79017_e.field_71300_f) + ", Avg size: " + (int)this.func_79015_a(this.field_79017_e.field_71301_g);
      this.field_79016_d[4] = "Avg rec: " + (int)this.func_79015_a(this.field_79017_e.field_71313_h) + ", Avg size: " + (int)this.func_79015_a(this.field_79017_e.field_71314_i);
      if(this.field_79017_e.field_71305_c != null) {
         for(int var3 = 0; var3 < this.field_79017_e.field_71305_c.length; ++var3) {
            this.field_79016_d[5 + var3] = "Lvl " + var3 + " tick: " + field_79020_a.format(this.func_79015_a(this.field_79017_e.field_71312_k[var3]) * 1.0E-6D) + " ms";
            if(this.field_79017_e.field_71305_c[var3] != null && this.field_79017_e.field_71305_c[var3].field_73059_b != null) {
               this.field_79016_d[5 + var3] = this.field_79016_d[5 + var3] + ", " + this.field_79017_e.field_71305_c[var3].field_73059_b.func_73148_d();
               this.field_79016_d[5 + var3] = this.field_79016_d[5 + var3] + ", Vec3: " + this.field_79017_e.field_71305_c[var3].func_82732_R().func_82590_d() + " / " + this.field_79017_e.field_71305_c[var3].func_82732_R().func_82591_c();
            }
         }
      }

      this.field_79018_b[this.field_79019_c++ & 255] = (int)(this.func_79015_a(this.field_79017_e.field_71301_g) * 100.0D / 12500.0D);
      this.repaint();
   }

   private double func_79015_a(long[] p_79015_1_) {
      long var2 = 0L;

      for(int var4 = 0; var4 < p_79015_1_.length; ++var4) {
         var2 += p_79015_1_[var4];
      }

      return (double)var2 / (double)p_79015_1_.length;
   }

   public void paint(Graphics p_paint_1_) {
      p_paint_1_.setColor(new Color(16777215));
      p_paint_1_.fillRect(0, 0, 456, 246);

      int var2;
      for(var2 = 0; var2 < 256; ++var2) {
         int var3 = this.field_79018_b[var2 + this.field_79019_c & 255];
         p_paint_1_.setColor(new Color(var3 + 28 << 16));
         p_paint_1_.fillRect(var2, 100 - var3, 1, var3);
      }

      p_paint_1_.setColor(Color.BLACK);

      for(var2 = 0; var2 < this.field_79016_d.length; ++var2) {
         String var4 = this.field_79016_d[var2];
         if(var4 != null) {
            p_paint_1_.drawString(var4, 32, 116 + var2 * 16);
         }
      }

   }

   // $FF: synthetic method
   static void func_79013_a(GuiStatsComponent p_79013_0_) {
      p_79013_0_.func_79014_a();
   }

}
