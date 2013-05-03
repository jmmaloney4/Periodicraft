package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelSeed implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85143_a;


   CallableLevelSeed(WorldInfo p_i6820_1_) {
      this.field_85143_a = p_i6820_1_;
   }

   public String func_85142_a() {
      return String.valueOf(this.field_85143_a.func_76063_b());
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85142_a();
   }
}
