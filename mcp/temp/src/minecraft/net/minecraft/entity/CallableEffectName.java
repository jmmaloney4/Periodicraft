package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

class CallableEffectName implements Callable {

   // $FF: synthetic field
   final PotionEffect field_102031_a;
   // $FF: synthetic field
   final EntityLiving field_102030_b;


   CallableEffectName(EntityLiving p_i22003_1_, PotionEffect p_i22003_2_) {
      this.field_102030_b = p_i22003_1_;
      this.field_102031_a = p_i22003_2_;
   }

   public String func_102029_a() {
      return Potion.field_76425_a[this.field_102031_a.func_76456_a()].func_76393_a();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_102029_a();
   }
}
