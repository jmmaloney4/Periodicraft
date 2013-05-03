package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelSpawnLocation implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85135_a;


   CallableLevelSpawnLocation(WorldInfo p_i6823_1_) {
      this.field_85135_a = p_i6823_1_;
   }

   public String func_85134_a() {
      return CrashReportCategory.func_85071_a(WorldInfo.func_85125_d(this.field_85135_a), WorldInfo.func_85124_e(this.field_85135_a), WorldInfo.func_85123_f(this.field_85135_a));
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85134_a();
   }
}
