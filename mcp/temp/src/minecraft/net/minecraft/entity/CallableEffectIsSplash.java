package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;

class CallableEffectIsSplash implements Callable {

   // $FF: synthetic field
   final PotionEffect field_102043_a;
   // $FF: synthetic field
   final EntityLiving field_102042_b;


   CallableEffectIsSplash(EntityLiving p_i22007_1_, PotionEffect p_i22007_2_) {
      this.field_102042_b = p_i22007_1_;
      this.field_102043_a = p_i22007_2_;
   }

   public String func_102041_a() {
      return this.field_102043_a.func_102028_d() + "";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_102041_a();
   }
}
