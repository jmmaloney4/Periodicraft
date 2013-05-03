package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.AxisAlignedBB;

class CallableCrashMemoryReport implements Callable {

   // $FF: synthetic field
   final CrashReport field_83004_a;


   CallableCrashMemoryReport(CrashReport p_i6000_1_) {
      this.field_83004_a = p_i6000_1_;
   }

   public String func_83003_a() {
      int var1 = AxisAlignedBB.func_72332_a().func_83013_c();
      int var2 = 56 * var1;
      int var3 = var2 / 1024 / 1024;
      int var4 = AxisAlignedBB.func_72332_a().func_83012_d();
      int var5 = 56 * var4;
      int var6 = var5 / 1024 / 1024;
      return var1 + " (" + var2 + " bytes; " + var3 + " MB) allocated, " + var4 + " (" + var5 + " bytes; " + var6 + " MB) used";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_83003_a();
   }
}
