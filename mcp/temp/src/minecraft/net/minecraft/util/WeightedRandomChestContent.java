package net.minecraft.util;

import java.util.Random;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomItem;

public class WeightedRandomChestContent extends WeightedRandomItem {

   public ItemStack field_76297_b = null;
   public int field_76295_d;
   public int field_76296_e;


   public WeightedRandomChestContent(int p_i3424_1_, int p_i3424_2_, int p_i3424_3_, int p_i3424_4_, int p_i3424_5_) {
      super(p_i3424_5_);
      this.field_76297_b = new ItemStack(p_i3424_1_, 1, p_i3424_2_);
      this.field_76295_d = p_i3424_3_;
      this.field_76296_e = p_i3424_4_;
   }

   public WeightedRandomChestContent(ItemStack p_i8006_1_, int p_i8006_2_, int p_i8006_3_, int p_i8006_4_) {
      super(p_i8006_4_);
      this.field_76297_b = p_i8006_1_;
      this.field_76295_d = p_i8006_2_;
      this.field_76296_e = p_i8006_3_;
   }

   public static void func_76293_a(Random p_76293_0_, WeightedRandomChestContent[] p_76293_1_, IInventory p_76293_2_, int p_76293_3_) {
      for(int var4 = 0; var4 < p_76293_3_; ++var4) {
         WeightedRandomChestContent var5 = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76293_0_, p_76293_1_);
         int var6 = var5.field_76295_d + p_76293_0_.nextInt(var5.field_76296_e - var5.field_76295_d + 1);
         if(var5.field_76297_b.func_77976_d() >= var6) {
            ItemStack var7 = var5.field_76297_b.func_77946_l();
            var7.field_77994_a = var6;
            p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), var7);
         } else {
            for(int var9 = 0; var9 < var6; ++var9) {
               ItemStack var8 = var5.field_76297_b.func_77946_l();
               var8.field_77994_a = 1;
               p_76293_2_.func_70299_a(p_76293_0_.nextInt(p_76293_2_.func_70302_i_()), var8);
            }
         }
      }

   }

   public static void func_76294_a(Random p_76294_0_, WeightedRandomChestContent[] p_76294_1_, TileEntityDispenser p_76294_2_, int p_76294_3_) {
      for(int var4 = 0; var4 < p_76294_3_; ++var4) {
         WeightedRandomChestContent var5 = (WeightedRandomChestContent)WeightedRandom.func_76274_a(p_76294_0_, p_76294_1_);
         int var6 = var5.field_76295_d + p_76294_0_.nextInt(var5.field_76296_e - var5.field_76295_d + 1);
         if(var5.field_76297_b.func_77976_d() >= var6) {
            ItemStack var7 = var5.field_76297_b.func_77946_l();
            var7.field_77994_a = var6;
            p_76294_2_.func_70299_a(p_76294_0_.nextInt(p_76294_2_.func_70302_i_()), var7);
         } else {
            for(int var9 = 0; var9 < var6; ++var9) {
               ItemStack var8 = var5.field_76297_b.func_77946_l();
               var8.field_77994_a = 1;
               p_76294_2_.func_70299_a(p_76294_0_.nextInt(p_76294_2_.func_70302_i_()), var8);
            }
         }
      }

   }

   public static WeightedRandomChestContent[] func_92080_a(WeightedRandomChestContent[] p_92080_0_, WeightedRandomChestContent ... p_92080_1_) {
      WeightedRandomChestContent[] var2 = new WeightedRandomChestContent[p_92080_0_.length + p_92080_1_.length];
      int var3 = 0;

      for(int var4 = 0; var4 < p_92080_0_.length; ++var4) {
         var2[var3++] = p_92080_0_[var4];
      }

      WeightedRandomChestContent[] var8 = p_92080_1_;
      int var5 = p_92080_1_.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         WeightedRandomChestContent var7 = var8[var6];
         var2[var3++] = var7;
      }

      return var2;
   }
}
