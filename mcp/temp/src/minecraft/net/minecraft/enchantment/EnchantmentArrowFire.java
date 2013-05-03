package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentArrowFire extends Enchantment {

   public EnchantmentArrowFire(int p_i3703_1_, int p_i3703_2_) {
      super(p_i3703_1_, p_i3703_2_, EnumEnchantmentType.bow);
      this.func_77322_b("arrowFire");
   }

   public int func_77321_a(int p_77321_1_) {
      return 20;
   }

   public int func_77317_b(int p_77317_1_) {
      return 50;
   }

   public int func_77325_b() {
      return 1;
   }
}
