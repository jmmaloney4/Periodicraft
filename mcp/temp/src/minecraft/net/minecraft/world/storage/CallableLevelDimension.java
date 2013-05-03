package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelDimension implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85115_a;


   CallableLevelDimension(WorldInfo p_i6825_1_) {
      this.field_85115_a = p_i6825_1_;
   }

   public String func_85114_a() {
      return String.valueOf(WorldInfo.func_85122_i(this.field_85115_a));
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85114_a();
   }
}
