package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityTracker;

class CallableEntityTracker implements Callable {

   // $FF: synthetic field
   final int field_96570_a;
   // $FF: synthetic field
   final EntityTracker field_96569_b;


   CallableEntityTracker(EntityTracker p_i10045_1_, int p_i10045_2_) {
      this.field_96569_b = p_i10045_1_;
      this.field_96570_a = p_i10045_2_;
   }

   public String func_96568_a() {
      String var1 = "Once per " + this.field_96570_a + " ticks";
      if(this.field_96570_a == Integer.MAX_VALUE) {
         var1 = "Maximum (" + var1 + ")";
      }

      return var1;
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_96568_a();
   }
}
