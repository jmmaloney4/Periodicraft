package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;

class CallableEffectID implements Callable {

   // $FF: synthetic field
   final PotionEffect field_102034_a;
   // $FF: synthetic field
   final EntityLiving field_102033_b;


   CallableEffectID(EntityLiving p_i22004_1_, PotionEffect p_i22004_2_) {
      this.field_102033_b = p_i22004_1_;
      this.field_102034_a = p_i22004_2_;
   }

   public String func_102032_a() {
      return this.field_102034_a.func_76456_a() + "";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_102032_a();
   }
}
