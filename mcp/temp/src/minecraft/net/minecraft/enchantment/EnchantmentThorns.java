package net.minecraft.enchantment;

import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class EnchantmentThorns extends Enchantment {

   public EnchantmentThorns(int p_i8015_1_, int p_i8015_2_) {
      super(p_i8015_1_, p_i8015_2_, EnumEnchantmentType.armor_torso);
      this.func_77322_b("thorns");
   }

   public int func_77321_a(int p_77321_1_) {
      return 10 + 20 * (p_77321_1_ - 1);
   }

   public int func_77317_b(int p_77317_1_) {
      return super.func_77321_a(p_77317_1_) + 50;
   }

   public int func_77325_b() {
      return 3;
   }

   public boolean func_92089_a(ItemStack p_92089_1_) {
      return p_92089_1_.func_77973_b() instanceof ItemArmor?true:super.func_92089_a(p_92089_1_);
   }

   public static boolean func_92094_a(int p_92094_0_, Random p_92094_1_) {
      return p_92094_0_ <= 0?false:p_92094_1_.nextFloat() < 0.15F * (float)p_92094_0_;
   }

   public static int func_92095_b(int p_92095_0_, Random p_92095_1_) {
      return p_92095_0_ > 10?p_92095_0_ - 10:1 + p_92095_1_.nextInt(4);
   }

   public static void func_92096_a(Entity p_92096_0_, EntityLiving p_92096_1_, Random p_92096_2_) {
      int var3 = EnchantmentHelper.func_92098_i(p_92096_1_);
      ItemStack var4 = EnchantmentHelper.func_92099_a(Enchantment.field_92091_k, p_92096_1_);
      if(func_92094_a(var3, p_92096_2_)) {
         p_92096_0_.func_70097_a(DamageSource.func_92087_a(p_92096_1_), func_92095_b(var3, p_92096_2_));
         p_92096_0_.func_85030_a("damage.thorns", 0.5F, 1.0F);
         if(var4 != null) {
            var4.func_77972_a(3, p_92096_1_);
         }
      } else if(var4 != null) {
         var4.func_77972_a(1, p_92096_1_);
      }

   }
}
