package net.minecraft.profiler;

import java.util.HashMap;
import java.util.TimerTask;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.util.HttpUtil;

class PlayerUsageSnooperThread extends TimerTask {

   // $FF: synthetic field
   final PlayerUsageSnooper field_76344_a;


   PlayerUsageSnooperThread(PlayerUsageSnooper p_i3427_1_) {
      this.field_76344_a = p_i3427_1_;
   }

   public void run() {
      if(PlayerUsageSnooper.func_76473_a(this.field_76344_a).func_70002_Q()) {
         HashMap var1;
         synchronized(PlayerUsageSnooper.func_76474_b(this.field_76344_a)) {
            var1 = new HashMap(PlayerUsageSnooper.func_76469_c(this.field_76344_a));
            var1.put("snooper_count", Integer.valueOf(PlayerUsageSnooper.func_76466_d(this.field_76344_a)));
         }

         HttpUtil.func_76183_a(PlayerUsageSnooper.func_76473_a(this.field_76344_a).func_98033_al(), PlayerUsageSnooper.func_76475_e(this.field_76344_a), var1, true);
      }
   }
}
