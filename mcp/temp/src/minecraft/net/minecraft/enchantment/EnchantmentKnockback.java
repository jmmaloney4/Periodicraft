package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentKnockback extends Enchantment {

   protected EnchantmentKnockback(int p_i3715_1_, int p_i3715_2_) {
      super(p_i3715_1_, p_i3715_2_, EnumEnchantmentType.weapon);
      this.func_77322_b("knockback");
   }

   public int func_77321_a(int p_77321_1_) {
      return 5 + 20 * (p_77321_1_ - 1);
   }

   public int func_77317_b(int p_77317_1_) {
      return super.func_77321_a(p_77317_1_) + 50;
   }

   public int func_77325_b() {
      return 2;
   }
}
