package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

class CallableOSInfo implements Callable {

   // $FF: synthetic field
   final CrashReport field_71496_a;


   CallableOSInfo(CrashReport p_i3245_1_) {
      this.field_71496_a = p_i3245_1_;
   }

   public String func_71495_a() {
      return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71495_a();
   }
}
