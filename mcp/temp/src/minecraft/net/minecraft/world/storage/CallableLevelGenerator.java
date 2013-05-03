package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelGenerator implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85139_a;


   CallableLevelGenerator(WorldInfo p_i6821_1_) {
      this.field_85139_a = p_i6821_1_;
   }

   public String func_85138_a() {
      return String.format("ID %02d - %s, ver %d. Features enabled: %b", new Object[]{Integer.valueOf(WorldInfo.func_85132_a(this.field_85139_a).func_82747_f()), WorldInfo.func_85132_a(this.field_85139_a).func_77127_a(), Integer.valueOf(WorldInfo.func_85132_a(this.field_85139_a).func_77131_c()), Boolean.valueOf(WorldInfo.func_85128_b(this.field_85139_a))});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85138_a();
   }
}
