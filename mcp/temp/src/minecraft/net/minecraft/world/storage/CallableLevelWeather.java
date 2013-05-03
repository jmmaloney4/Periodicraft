package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelWeather implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85111_a;


   CallableLevelWeather(WorldInfo p_i6827_1_) {
      this.field_85111_a = p_i6827_1_;
   }

   public String func_85110_a() {
      return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", new Object[]{Integer.valueOf(WorldInfo.func_85119_k(this.field_85111_a)), Boolean.valueOf(WorldInfo.func_85127_l(this.field_85111_a)), Integer.valueOf(WorldInfo.func_85133_m(this.field_85111_a)), Boolean.valueOf(WorldInfo.func_85116_n(this.field_85111_a))});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85110_a();
   }
}
