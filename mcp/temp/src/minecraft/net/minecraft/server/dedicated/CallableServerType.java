package net.minecraft.server.dedicated;

import java.util.concurrent.Callable;
import net.minecraft.server.dedicated.DedicatedServer;

class CallableServerType implements Callable {

   // $FF: synthetic field
   final DedicatedServer field_85171_a;


   CallableServerType(DedicatedServer p_i6810_1_) {
      this.field_85171_a = p_i6810_1_;
   }

   public String func_85170_a() {
      return "Dedicated Server (map_server.txt)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85170_a();
   }
}
