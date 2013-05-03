package net.minecraft.server.dedicated;

import java.util.concurrent.Callable;
import net.minecraft.server.dedicated.DedicatedServer;

class CallableType implements Callable {

   // $FF: synthetic field
   final DedicatedServer field_71743_a;


   CallableType(DedicatedServer p_i3381_1_) {
      this.field_71743_a = p_i3381_1_;
   }

   public String func_71742_a() {
      String var1 = this.field_71743_a.getServerModName();
      return !var1.equals("vanilla")?"Definitely; Server brand changed to \'" + var1 + "\'":"Unknown (can\'t tell)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_71742_a();
   }
}
