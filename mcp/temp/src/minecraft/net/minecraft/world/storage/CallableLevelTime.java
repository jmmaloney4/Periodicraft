package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelTime implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85137_a;


   CallableLevelTime(WorldInfo p_i6824_1_) {
      this.field_85137_a = p_i6824_1_;
   }

   public String func_85136_a() {
      return String.format("%d game time, %d day time", new Object[]{Long.valueOf(WorldInfo.func_85126_g(this.field_85137_a)), Long.valueOf(WorldInfo.func_85129_h(this.field_85137_a))});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85136_a();
   }
}
