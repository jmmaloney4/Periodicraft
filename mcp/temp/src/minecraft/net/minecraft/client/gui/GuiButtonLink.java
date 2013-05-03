package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URI;
import net.minecraft.client.gui.GuiButton;

@SideOnly(Side.CLIENT)
public class GuiButtonLink extends GuiButton {

   public GuiButtonLink(int p_i10001_1_, int p_i10001_2_, int p_i10001_3_, int p_i10001_4_, int p_i10001_5_, String p_i10001_6_) {
      super(p_i10001_1_, p_i10001_2_, p_i10001_3_, p_i10001_4_, p_i10001_5_, p_i10001_6_);
   }

   public void func_96135_a(String p_96135_1_) {
      try {
         URI var2 = new URI(p_96135_1_);
         Class var3 = Class.forName("java.awt.Desktop");
         Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
         var3.getMethod("browse", new Class[]{URI.class}).invoke(var4, new Object[]{var2});
      } catch (Throwable var5) {
         var5.printStackTrace();
      }

   }
}
