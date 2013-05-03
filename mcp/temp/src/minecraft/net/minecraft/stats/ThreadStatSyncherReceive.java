package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.stats.StatsSyncher;

@SideOnly(Side.CLIENT)
class ThreadStatSyncherReceive extends Thread {

   // $FF: synthetic field
   final StatsSyncher field_77486_a;


   ThreadStatSyncherReceive(StatsSyncher p_i3219_1_) {
      this.field_77486_a = p_i3219_1_;
   }

   public void run() {
      try {
         if(StatsSyncher.func_77419_a(this.field_77486_a) != null) {
            StatsSyncher.func_77414_a(this.field_77486_a, StatsSyncher.func_77419_a(this.field_77486_a), StatsSyncher.func_77408_b(this.field_77486_a), StatsSyncher.func_77407_c(this.field_77486_a), StatsSyncher.func_77411_d(this.field_77486_a));
         } else if(StatsSyncher.func_77408_b(this.field_77486_a).exists()) {
            StatsSyncher.func_77416_a(this.field_77486_a, StatsSyncher.func_77410_a(this.field_77486_a, StatsSyncher.func_77408_b(this.field_77486_a), StatsSyncher.func_77407_c(this.field_77486_a), StatsSyncher.func_77411_d(this.field_77486_a)));
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         StatsSyncher.func_77406_a(this.field_77486_a, false);
      }

   }
}
