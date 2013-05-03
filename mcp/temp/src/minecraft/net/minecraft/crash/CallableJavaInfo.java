package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

class CallableJavaInfo implements Callable {

   // $FF: synthetic field
   final CrashReport field_71490_a;


   CallableJavaInfo(CrashReport p_i3246_1_) {
      this.field_71490_a = p_i3246_1_;
   }

   public String func_71489_a() {
      return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71489_a();
   }
}
