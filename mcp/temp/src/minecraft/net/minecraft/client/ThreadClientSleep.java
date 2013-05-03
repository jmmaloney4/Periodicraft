package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class ThreadClientSleep extends Thread {

   // $FF: synthetic field
   final Minecraft field_74532_a;


   public ThreadClientSleep(Minecraft p_i3019_1_, String p_i3019_2_) {
      super(p_i3019_2_);
      this.field_74532_a = p_i3019_1_;
   }

   public void run() {
      while(this.field_74532_a.field_71425_J) {
         try {
            Thread.sleep(2147483647L);
         } catch (InterruptedException var2) {
            ;
         }
      }

   }
}
