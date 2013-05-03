package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentArrowDamage extends Enchantment {

   public EnchantmentArrowDamage(int p_i3702_1_, int p_i3702_2_) {
      super(p_i3702_1_, p_i3702_2_, EnumEnchantmentType.bow);
      this.func_77322_b("arrowDamage");
   }

   public int func_77321_a(int p_77321_1_) {
      return 1 + (p_77321_1_ - 1) * 10;
   }

   public int func_77317_b(int p_77317_1_) {
      return this.func_77321_a(p_77317_1_) + 15;
   }

   public int func_77325_b() {
      return 5;
   }
}
