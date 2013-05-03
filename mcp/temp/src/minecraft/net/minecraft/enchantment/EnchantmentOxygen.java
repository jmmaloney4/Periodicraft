package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentOxygen extends Enchantment {

   public EnchantmentOxygen(int p_i3717_1_, int p_i3717_2_) {
      super(p_i3717_1_, p_i3717_2_, EnumEnchantmentType.armor_head);
      this.func_77322_b("oxygen");
   }

   public int func_77321_a(int p_77321_1_) {
      return 10 * p_77321_1_;
   }

   public int func_77317_b(int p_77317_1_) {
      return this.func_77321_a(p_77317_1_) + 30;
   }

   public int func_77325_b() {
      return 3;
   }
}
