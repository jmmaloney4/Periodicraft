package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.world.World;

public class BlockSand extends Block {

   public static boolean field_72192_a = false;


   public BlockSand(int p_i9060_1_) {
      super(p_i9060_1_, Material.field_76251_o);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public BlockSand(int p_i9061_1_, Material p_i9061_2_) {
      super(p_i9061_1_, p_i9061_2_);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, this.field_71990_ca, this.func_71859_p_(p_71861_1_));
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, this.field_71990_ca, this.func_71859_p_(p_71863_1_));
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         this.func_72190_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
      }

   }

   private void func_72190_l(World p_72190_1_, int p_72190_2_, int p_72190_3_, int p_72190_4_) {
      if(func_72191_e_(p_72190_1_, p_72190_2_, p_72190_3_ - 1, p_72190_4_) && p_72190_3_ >= 0) {
         byte var8 = 32;
         if(!field_72192_a && p_72190_1_.func_72904_c(p_72190_2_ - var8, p_72190_3_ - var8, p_72190_4_ - var8, p_72190_2_ + var8, p_72190_3_ + var8, p_72190_4_ + var8)) {
            if(!p_72190_1_.field_72995_K) {
               EntityFallingSand var9 = new EntityFallingSand(p_72190_1_, (double)((float)p_72190_2_ + 0.5F), (double)((float)p_72190_3_ + 0.5F), (double)((float)p_72190_4_ + 0.5F), this.field_71990_ca, p_72190_1_.func_72805_g(p_72190_2_, p_72190_3_, p_72190_4_));
               this.func_82520_a(var9);
               p_72190_1_.func_72838_d(var9);
            }
         } else {
            p_72190_1_.func_94571_i(p_72190_2_, p_72190_3_, p_72190_4_);

            while(func_72191_e_(p_72190_1_, p_72190_2_, p_72190_3_ - 1, p_72190_4_) && p_72190_3_ > 0) {
               --p_72190_3_;
            }

            if(p_72190_3_ > 0) {
               p_72190_1_.func_94575_c(p_72190_2_, p_72190_3_, p_72190_4_, this.field_71990_ca);
            }
         }
      }

   }

   protected void func_82520_a(EntityFallingSand p_82520_1_) {}

   public int func_71859_p_(World p_71859_1_) {
      return 2;
   }

   public static boolean func_72191_e_(World p_72191_0_, int p_72191_1_, int p_72191_2_, int p_72191_3_) {
      int var4 = p_72191_0_.func_72798_a(p_72191_1_, p_72191_2_, p_72191_3_);
      if(var4 == 0) {
         return true;
      } else if(var4 == Block.field_72067_ar.field_71990_ca) {
         return true;
      } else {
         Material var5 = Block.field_71973_m[var4].field_72018_cp;
         return var5 == Material.field_76244_g?true:var5 == Material.field_76256_h;
      }
   }

   public void func_82519_a_(World p_82519_1_, int p_82519_2_, int p_82519_3_, int p_82519_4_, int p_82519_5_) {}

}
