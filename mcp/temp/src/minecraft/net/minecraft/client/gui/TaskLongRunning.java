package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenLongRunningTask;

@SideOnly(Side.CLIENT)
public abstract class TaskLongRunning implements Runnable {

   protected GuiScreenLongRunningTask field_96579_b;


   public void func_96574_a(GuiScreenLongRunningTask p_96574_1_) {
      this.field_96579_b = p_96574_1_;
   }

   public void func_96575_a(String p_96575_1_) {
      this.field_96579_b.func_96209_a(p_96575_1_);
   }

   public void func_96576_b(String p_96576_1_) {
      this.field_96579_b.func_96210_b(p_96576_1_);
   }

   public Minecraft func_96578_b() {
      return this.field_96579_b.func_96208_g();
   }

   public boolean func_96577_c() {
      return this.field_96579_b.func_96207_h();
   }

   public void func_96573_a() {}

   public void func_96572_a(GuiButton p_96572_1_) {}

   public void func_96571_d() {}
}
