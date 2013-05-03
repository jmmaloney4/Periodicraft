package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.PotionEffect;

class CallableEffectAmplifier implements Callable {

   // $FF: synthetic field
   final PotionEffect field_102040_a;
   // $FF: synthetic field
   final EntityLiving field_102039_b;


   CallableEffectAmplifier(EntityLiving p_i22006_1_, PotionEffect p_i22006_2_) {
      this.field_102039_b = p_i22006_1_;
      this.field_102040_a = p_i22006_2_;
   }

   public String func_102038_a() {
      return this.field_102040_a.func_76458_c() + "";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_102038_a();
   }
}
