package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlowing extends BlockFluid {

   int field_72214_a = 0;
   boolean[] field_72212_b = new boolean[4];
   int[] field_72213_c = new int[4];


   protected BlockFlowing(int p_i3965_1_, Material p_i3965_2_) {
      super(p_i3965_1_, p_i3965_2_);
   }

   private void func_72205_l(World p_72205_1_, int p_72205_2_, int p_72205_3_, int p_72205_4_) {
      int var5 = p_72205_1_.func_72805_g(p_72205_2_, p_72205_3_, p_72205_4_);
      p_72205_1_.func_72832_d(p_72205_2_, p_72205_3_, p_72205_4_, this.field_71990_ca + 1, var5, 2);
   }

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return this.field_72018_cp != Material.field_76256_h;
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      int var6 = this.func_72198_f_(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
      byte var7 = 1;
      if(this.field_72018_cp == Material.field_76256_h && !p_71847_1_.field_73011_w.field_76575_d) {
         var7 = 2;
      }

      boolean var8 = true;
      int var10;
      if(var6 > 0) {
         byte var9 = -100;
         this.field_72214_a = 0;
         int var12 = this.func_72211_e(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_, var9);
         var12 = this.func_72211_e(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_, var12);
         var12 = this.func_72211_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1, var12);
         var12 = this.func_72211_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1, var12);
         var10 = var12 + var7;
         if(var10 >= 8 || var12 < 0) {
            var10 = -1;
         }

         if(this.func_72198_f_(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 0) {
            int var11 = this.func_72198_f_(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_);
            if(var11 >= 8) {
               var10 = var11;
            } else {
               var10 = var11 + 8;
            }
         }

         if(this.field_72214_a >= 2 && this.field_72018_cp == Material.field_76244_g) {
            if(p_71847_1_.func_72803_f(p_71847_2_, p_71847_3_ - 1, p_71847_4_).func_76220_a()) {
               var10 = 0;
            } else if(p_71847_1_.func_72803_f(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == this.field_72018_cp && p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == 0) {
               var10 = 0;
            }
         }

         if(this.field_72018_cp == Material.field_76256_h && var6 < 8 && var10 < 8 && var10 > var6 && p_71847_5_.nextInt(4) != 0) {
            var10 = var6;
            var8 = false;
         }

         if(var10 == var6) {
            if(var8) {
               this.func_72205_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            }
         } else {
            var6 = var10;
            if(var10 < 0) {
               p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
            } else {
               p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var10, 2);
               p_71847_1_.func_72836_a(p_71847_2_, p_71847_3_, p_71847_4_, this.field_71990_ca, this.func_71859_p_(p_71847_1_));
               p_71847_1_.func_72898_h(p_71847_2_, p_71847_3_, p_71847_4_, this.field_71990_ca);
            }
         }
      } else {
         this.func_72205_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
      }

      if(this.func_72207_p(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_)) {
         if(this.field_72018_cp == Material.field_76256_h && p_71847_1_.func_72803_f(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == Material.field_76244_g) {
            p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_ - 1, p_71847_4_, Block.field_71981_t.field_71990_ca);
            this.func_72201_j(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_);
            return;
         }

         if(var6 >= 8) {
            this.func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_, var6);
         } else {
            this.func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_, var6 + 8);
         }
      } else if(var6 >= 0 && (var6 == 0 || this.func_72208_o(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_))) {
         boolean[] var13 = this.func_72206_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
         var10 = var6 + var7;
         if(var6 >= 8) {
            var10 = 1;
         }

         if(var10 >= 8) {
            return;
         }

         if(var13[0]) {
            this.func_72210_i(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_, var10);
         }

         if(var13[1]) {
            this.func_72210_i(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_, var10);
         }

         if(var13[2]) {
            this.func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1, var10);
         }

         if(var13[3]) {
            this.func_72210_i(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1, var10);
         }
      }

   }

   private void func_72210_i(World p_72210_1_, int p_72210_2_, int p_72210_3_, int p_72210_4_, int p_72210_5_) {
      if(this.func_72207_p(p_72210_1_, p_72210_2_, p_72210_3_, p_72210_4_)) {
         int var6 = p_72210_1_.func_72798_a(p_72210_2_, p_72210_3_, p_72210_4_);
         if(var6 > 0) {
            if(this.field_72018_cp == Material.field_76256_h) {
               this.func_72201_j(p_72210_1_, p_72210_2_, p_72210_3_, p_72210_4_);
            } else {
               Block.field_71973_m[var6].func_71897_c(p_72210_1_, p_72210_2_, p_72210_3_, p_72210_4_, p_72210_1_.func_72805_g(p_72210_2_, p_72210_3_, p_72210_4_), 0);
            }
         }

         p_72210_1_.func_72832_d(p_72210_2_, p_72210_3_, p_72210_4_, this.field_71990_ca, p_72210_5_, 3);
      }

   }

   private int func_72209_d(World p_72209_1_, int p_72209_2_, int p_72209_3_, int p_72209_4_, int p_72209_5_, int p_72209_6_) {
      int var7 = 1000;

      for(int var8 = 0; var8 < 4; ++var8) {
         if((var8 != 0 || p_72209_6_ != 1) && (var8 != 1 || p_72209_6_ != 0) && (var8 != 2 || p_72209_6_ != 3) && (var8 != 3 || p_72209_6_ != 2)) {
            int var9 = p_72209_2_;
            int var11 = p_72209_4_;
            if(var8 == 0) {
               var9 = p_72209_2_ - 1;
            }

            if(var8 == 1) {
               ++var9;
            }

            if(var8 == 2) {
               var11 = p_72209_4_ - 1;
            }

            if(var8 == 3) {
               ++var11;
            }

            if(!this.func_72208_o(p_72209_1_, var9, p_72209_3_, var11) && (p_72209_1_.func_72803_f(var9, p_72209_3_, var11) != this.field_72018_cp || p_72209_1_.func_72805_g(var9, p_72209_3_, var11) != 0)) {
               if(!this.func_72208_o(p_72209_1_, var9, p_72209_3_ - 1, var11)) {
                  return p_72209_5_;
               }

               if(p_72209_5_ < 4) {
                  int var12 = this.func_72209_d(p_72209_1_, var9, p_72209_3_, var11, p_72209_5_ + 1, var8);
                  if(var12 < var7) {
                     var7 = var12;
                  }
               }
            }
         }
      }

      return var7;
   }

   private boolean[] func_72206_n(World p_72206_1_, int p_72206_2_, int p_72206_3_, int p_72206_4_) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 4; ++var5) {
         this.field_72213_c[var5] = 1000;
         var6 = p_72206_2_;
         int var8 = p_72206_4_;
         if(var5 == 0) {
            var6 = p_72206_2_ - 1;
         }

         if(var5 == 1) {
            ++var6;
         }

         if(var5 == 2) {
            var8 = p_72206_4_ - 1;
         }

         if(var5 == 3) {
            ++var8;
         }

         if(!this.func_72208_o(p_72206_1_, var6, p_72206_3_, var8) && (p_72206_1_.func_72803_f(var6, p_72206_3_, var8) != this.field_72018_cp || p_72206_1_.func_72805_g(var6, p_72206_3_, var8) != 0)) {
            if(this.func_72208_o(p_72206_1_, var6, p_72206_3_ - 1, var8)) {
               this.field_72213_c[var5] = this.func_72209_d(p_72206_1_, var6, p_72206_3_, var8, 1, var5);
            } else {
               this.field_72213_c[var5] = 0;
            }
         }
      }

      var5 = this.field_72213_c[0];

      for(var6 = 1; var6 < 4; ++var6) {
         if(this.field_72213_c[var6] < var5) {
            var5 = this.field_72213_c[var6];
         }
      }

      for(var6 = 0; var6 < 4; ++var6) {
         this.field_72212_b[var6] = this.field_72213_c[var6] == var5;
      }

      return this.field_72212_b;
   }

   private boolean func_72208_o(World p_72208_1_, int p_72208_2_, int p_72208_3_, int p_72208_4_) {
      int var5 = p_72208_1_.func_72798_a(p_72208_2_, p_72208_3_, p_72208_4_);
      if(var5 != Block.field_72054_aE.field_71990_ca && var5 != Block.field_72045_aL.field_71990_ca && var5 != Block.field_72053_aD.field_71990_ca && var5 != Block.field_72055_aF.field_71990_ca && var5 != Block.field_72040_aX.field_71990_ca) {
         if(var5 == 0) {
            return false;
         } else {
            Material var6 = Block.field_71973_m[var5].field_72018_cp;
            return var6 == Material.field_76237_B?true:var6.func_76230_c();
         }
      } else {
         return true;
      }
   }

   protected int func_72211_e(World p_72211_1_, int p_72211_2_, int p_72211_3_, int p_72211_4_, int p_72211_5_) {
      int var6 = this.func_72198_f_(p_72211_1_, p_72211_2_, p_72211_3_, p_72211_4_);
      if(var6 < 0) {
         return p_72211_5_;
      } else {
         if(var6 == 0) {
            ++this.field_72214_a;
         }

         if(var6 >= 8) {
            var6 = 0;
         }

         return p_72211_5_ >= 0 && var6 >= p_72211_5_?p_72211_5_:var6;
      }
   }

   private boolean func_72207_p(World p_72207_1_, int p_72207_2_, int p_72207_3_, int p_72207_4_) {
      Material var5 = p_72207_1_.func_72803_f(p_72207_2_, p_72207_3_, p_72207_4_);
      return var5 == this.field_72018_cp?false:(var5 == Material.field_76256_h?false:!this.func_72208_o(p_72207_1_, p_72207_2_, p_72207_3_, p_72207_4_));
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      if(p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_, p_71861_4_) == this.field_71990_ca) {
         p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, this.field_71990_ca, this.func_71859_p_(p_71861_1_));
      }

   }

   public boolean func_82506_l() {
      return false;
   }
}
