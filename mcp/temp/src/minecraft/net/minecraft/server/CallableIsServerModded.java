package net.minecraft.server;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class CallableIsServerModded implements Callable {

   // $FF: synthetic field
   final MinecraftServer field_74274_a;


   public CallableIsServerModded(MinecraftServer p_i5006_1_) {
      this.field_74274_a = p_i5006_1_;
   }

   public String func_96558_a() {
      return this.field_74274_a.field_71304_b.field_76327_a?this.field_74274_a.field_71304_b.func_76322_c():"N/A (disabled)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_96558_a();
   }
}
