package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;

class CallableEffectIsAmbient implements Callable {

   // $FF: synthetic field
   final PotionEffect field_102046_a;
   // $FF: synthetic field
   final EntityLiving field_102045_b;


   CallableEffectIsAmbient(EntityLiving p_i22008_1_, PotionEffect p_i22008_2_) {
      this.field_102045_b = p_i22008_1_;
      this.field_102046_a = p_i22008_2_;
   }

   public String func_102044_a() {
      return this.field_102046_a.func_82720_e() + "";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_102044_a();
   }
}
