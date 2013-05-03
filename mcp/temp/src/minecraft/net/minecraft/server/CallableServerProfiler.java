package net.minecraft.server;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class CallableServerProfiler implements Callable {

   // $FF: synthetic field
   final MinecraftServer field_74272_a;


   public CallableServerProfiler(MinecraftServer p_i5008_1_) {
      this.field_74272_a = p_i5008_1_;
   }

   public String func_96557_a() {
      int var1 = this.field_74272_a.field_71305_c[0].func_82732_R().func_82591_c();
      int var2 = 56 * var1;
      int var3 = var2 / 1024 / 1024;
      int var4 = this.field_74272_a.field_71305_c[0].func_82732_R().func_82590_d();
      int var5 = 56 * var4;
      int var6 = var5 / 1024 / 1024;
      return var1 + " (" + var2 + " bytes; " + var3 + " MB) allocated, " + var4 + " (" + var5 + " bytes; " + var6 + " MB) used";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_96557_a();
   }
}
