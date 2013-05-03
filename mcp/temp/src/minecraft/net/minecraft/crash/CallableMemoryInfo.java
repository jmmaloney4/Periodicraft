package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

class CallableMemoryInfo implements Callable {

   // $FF: synthetic field
   final CrashReport field_71486_a;


   CallableMemoryInfo(CrashReport p_i3248_1_) {
      this.field_71486_a = p_i3248_1_;
   }

   public String func_71485_a() {
      Runtime var1 = Runtime.getRuntime();
      long var2 = var1.maxMemory();
      long var4 = var1.totalMemory();
      long var6 = var1.freeMemory();
      long var8 = var2 / 1024L / 1024L;
      long var10 = var4 / 1024L / 1024L;
      long var12 = var6 / 1024L / 1024L;
      return var6 + " bytes (" + var12 + " MB) / " + var4 + " bytes (" + var10 + " MB) up to " + var2 + " bytes (" + var8 + " MB)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71485_a();
   }
}
