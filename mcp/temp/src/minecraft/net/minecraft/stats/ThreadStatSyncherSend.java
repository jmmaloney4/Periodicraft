package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraft.stats.StatsSyncher;

@SideOnly(Side.CLIENT)
class ThreadStatSyncherSend extends Thread {

   // $FF: synthetic field
   final Map field_77483_a;
   // $FF: synthetic field
   final StatsSyncher field_77482_b;


   ThreadStatSyncherSend(StatsSyncher p_i3217_1_, Map p_i3217_2_) {
      this.field_77482_b = p_i3217_1_;
      this.field_77483_a = p_i3217_2_;
   }

   public void run() {
      try {
         StatsSyncher.func_77414_a(this.field_77482_b, this.field_77483_a, StatsSyncher.func_77409_e(this.field_77482_b), StatsSyncher.func_77415_f(this.field_77482_b), StatsSyncher.func_77424_g(this.field_77482_b));
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         StatsSyncher.func_77406_a(this.field_77482_b, false);
      }

   }
}
