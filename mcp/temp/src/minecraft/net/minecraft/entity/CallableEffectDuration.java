package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;

class CallableEffectDuration implements Callable {

   // $FF: synthetic field
   final PotionEffect field_102037_a;
   // $FF: synthetic field
   final EntityLiving field_102036_b;


   CallableEffectDuration(EntityLiving p_i22005_1_, PotionEffect p_i22005_2_) {
      this.field_102036_b = p_i22005_1_;
      this.field_102037_a = p_i22005_2_;
   }

   public String func_102035_a() {
      return this.field_102037_a.func_76459_b() + "";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_102035_a();
   }
}
