package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.Entity;

class CallableEntityName implements Callable {

   // $FF: synthetic field
   final Entity field_96564_a;


   CallableEntityName(Entity p_i10048_1_) {
      this.field_96564_a = p_i10048_1_;
   }

   public String func_96563_a() {
      return this.field_96564_a.func_70023_ak();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_96563_a();
   }
}
