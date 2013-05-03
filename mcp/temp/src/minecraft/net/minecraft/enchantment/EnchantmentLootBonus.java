package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentLootBonus extends Enchantment {

   protected EnchantmentLootBonus(int p_i3716_1_, int p_i3716_2_, EnumEnchantmentType p_i3716_3_) {
      super(p_i3716_1_, p_i3716_2_, p_i3716_3_);
      this.func_77322_b("lootBonus");
      if(p_i3716_3_ == EnumEnchantmentType.digger) {
         this.func_77322_b("lootBonusDigger");
      }

   }

   public int func_77321_a(int p_77321_1_) {
      return 15 + (p_77321_1_ - 1) * 9;
   }

   public int func_77317_b(int p_77317_1_) {
      return super.func_77321_a(p_77317_1_) + 50;
   }

   public int func_77325_b() {
      return 3;
   }

   public boolean func_77326_a(Enchantment p_77326_1_) {
      return super.func_77326_a(p_77326_1_) && p_77326_1_.field_77352_x != field_77348_q.field_77352_x;
   }
}
