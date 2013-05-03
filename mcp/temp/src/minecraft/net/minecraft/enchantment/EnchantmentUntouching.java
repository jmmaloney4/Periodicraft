package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentUntouching extends Enchantment {

   protected EnchantmentUntouching(int p_i3719_1_, int p_i3719_2_) {
      super(p_i3719_1_, p_i3719_2_, EnumEnchantmentType.digger);
      this.func_77322_b("untouching");
   }

   public int func_77321_a(int p_77321_1_) {
      return 15;
   }

   public int func_77317_b(int p_77317_1_) {
      return super.func_77321_a(p_77317_1_) + 50;
   }

   public int func_77325_b() {
      return 1;
   }

   public boolean func_77326_a(Enchantment p_77326_1_) {
      return super.func_77326_a(p_77326_1_) && p_77326_1_.field_77352_x != field_77346_s.field_77352_x;
   }

   public boolean func_92089_a(ItemStack p_92089_1_) {
      return p_92089_1_.func_77973_b().field_77779_bT == Item.field_77745_be.field_77779_bT?true:super.func_92089_a(p_92089_1_);
   }
}
