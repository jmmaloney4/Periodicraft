package net.minecraft.enchantment;

import net.minecraft.enchantment.Empty3;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.IEnchantmentModifier;
import net.minecraft.util.DamageSource;

final class EnchantmentModifierDamage implements IEnchantmentModifier {

   public int field_77497_a;
   public DamageSource field_77496_b;


   private EnchantmentModifierDamage() {}

   public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_) {
      this.field_77497_a += p_77493_1_.func_77318_a(p_77493_2_, this.field_77496_b);
   }

   // $FF: synthetic method
   EnchantmentModifierDamage(Empty3 p_i3712_1_) {
      this();
   }
}
