package net.minecraft.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class EnchantmentDamage extends Enchantment {

   private static final String[] field_77359_A = new String[]{"all", "undead", "arthropods"};
   private static final int[] field_77360_B = new int[]{1, 5, 5};
   private static final int[] field_77362_C = new int[]{11, 8, 8};
   private static final int[] field_77358_D = new int[]{20, 20, 20};
   public final int field_77361_a;


   public EnchantmentDamage(int p_i3706_1_, int p_i3706_2_, int p_i3706_3_) {
      super(p_i3706_1_, p_i3706_2_, EnumEnchantmentType.weapon);
      this.field_77361_a = p_i3706_3_;
   }

   public int func_77321_a(int p_77321_1_) {
      return field_77360_B[this.field_77361_a] + (p_77321_1_ - 1) * field_77362_C[this.field_77361_a];
   }

   public int func_77317_b(int p_77317_1_) {
      return this.func_77321_a(p_77317_1_) + field_77358_D[this.field_77361_a];
   }

   public int func_77325_b() {
      return 5;
   }

   public int func_77323_a(int p_77323_1_, EntityLiving p_77323_2_) {
      return this.field_77361_a == 0?MathHelper.func_76141_d((float)p_77323_1_ * 2.75F):(this.field_77361_a == 1 && p_77323_2_.func_70668_bt() == EnumCreatureAttribute.UNDEAD?MathHelper.func_76141_d((float)p_77323_1_ * 4.5F):(this.field_77361_a == 2 && p_77323_2_.func_70668_bt() == EnumCreatureAttribute.ARTHROPOD?MathHelper.func_76141_d((float)p_77323_1_ * 4.5F):0));
   }

   public String func_77320_a() {
      return "enchantment.damage." + field_77359_A[this.field_77361_a];
   }

   public boolean func_77326_a(Enchantment p_77326_1_) {
      return !(p_77326_1_ instanceof EnchantmentDamage);
   }

   public boolean func_92089_a(ItemStack p_92089_1_) {
      return p_92089_1_.func_77973_b() instanceof ItemAxe?true:super.func_92089_a(p_92089_1_);
   }

}
