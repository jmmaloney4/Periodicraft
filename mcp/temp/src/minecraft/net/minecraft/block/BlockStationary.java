package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStationary extends BlockFluid {

   protected BlockStationary(int p_i3966_1_, Material p_i3966_2_) {
      super(p_i3966_1_, p_i3966_2_);
      this.func_71907_b(false);
      if(p_i3966_2_ == Material.field_76256_h) {
         this.func_71907_b(true);
      }

   }

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return this.field_72018_cp != Material.field_76256_h;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      if(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_) == this.field_71990_ca) {
         this.func_72215_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   private void func_72215_l(World p_72215_1_, int p_72215_2_, int p_72215_3_, int p_72215_4_) {
      int var5 = p_72215_1_.func_72805_g(p_72215_2_, p_72215_3_, p_72215_4_);
      p_72215_1_.func_72832_d(p_72215_2_, p_72215_3_, p_72215_4_, this.field_71990_ca - 1, var5, 2);
      p_72215_1_.func_72836_a(p_72215_2_, p_72215_3_, p_72215_4_, this.field_71990_ca - 1, this.func_71859_p_(p_72215_1_));
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(this.field_72018_cp == Material.field_76256_h) {
         int var6 = p_71847_5_.nextInt(3);

         int var7;
         int var8;
         for(var7 = 0; var7 < var6; ++var7) {
            p_71847_2_ += p_71847_5_.nextInt(3) - 1;
            ++p_71847_3_;
            p_71847_4_ += p_71847_5_.nextInt(3) - 1;
            var8 = p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_);
            if(var8 == 0) {
               if(this.func_72216_n(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_) || this.func_72216_n(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_) || this.func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1) || this.func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1) || this.func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_) || this.func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_)) {
                  p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72067_ar.field_71990_ca);
                  return;
               }
            } else if(Block.field_71973_m[var8].field_72018_cp.func_76230_c()) {
               return;
            }
         }

         if(var6 == 0) {
            var7 = p_71847_2_;
            var8 = p_71847_4_;

            for(int var9 = 0; var9 < 3; ++var9) {
               p_71847_2_ = var7 + p_71847_5_.nextInt(3) - 1;
               p_71847_4_ = var8 + p_71847_5_.nextInt(3) - 1;
               if(p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_) && this.func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_)) {
                  p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_, Block.field_72067_ar.field_71990_ca);
               }
            }
         }
      }

   }

   private boolean func_72216_n(World p_72216_1_, int p_72216_2_, int p_72216_3_, int p_72216_4_) {
      return p_72216_1_.func_72803_f(p_72216_2_, p_72216_3_, p_72216_4_).func_76217_h();
   }
}
