package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelGeneratorOptions implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85141_a;


   CallableLevelGeneratorOptions(WorldInfo p_i6822_1_) {
      this.field_85141_a = p_i6822_1_;
   }

   public String func_85140_a() {
      return WorldInfo.func_85130_c(this.field_85141_a);
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85140_a();
   }
}
