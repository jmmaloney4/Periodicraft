package net.minecraft.crash;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

class CallableJVMFlags implements Callable {

   // $FF: synthetic field
   final CrashReport field_71488_a;


   CallableJVMFlags(CrashReport p_i3249_1_) {
      this.field_71488_a = p_i3249_1_;
   }

   public String func_71487_a() {
      RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
      List var2 = var1.getInputArguments();
      int var3 = 0;
      StringBuilder var4 = new StringBuilder();
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         if(var6.startsWith("-X")) {
            if(var3++ > 0) {
               var4.append(" ");
            }

            var4.append(var6);
         }
      }

      return String.format("%d total; %s", new Object[]{Integer.valueOf(var3), var4.toString()});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71487_a();
   }
}
