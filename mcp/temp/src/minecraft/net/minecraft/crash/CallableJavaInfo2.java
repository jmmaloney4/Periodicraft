package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

class CallableJavaInfo2 implements Callable {

   // $FF: synthetic field
   final CrashReport field_71492_a;


   CallableJavaInfo2(CrashReport p_i3247_1_) {
      this.field_71492_a = p_i3247_1_;
   }

   public String func_71491_a() {
      return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71491_a();
   }
}
