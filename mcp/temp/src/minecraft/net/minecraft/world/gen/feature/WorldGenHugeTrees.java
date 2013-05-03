package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHugeTrees extends WorldGenerator {

   private final int field_76522_a;
   private final int field_76520_b;
   private final int field_76521_c;


   public WorldGenHugeTrees(boolean p_i3795_1_, int p_i3795_2_, int p_i3795_3_, int p_i3795_4_) {
      super(p_i3795_1_);
      this.field_76522_a = p_i3795_2_;
      this.field_76520_b = p_i3795_3_;
      this.field_76521_c = p_i3795_4_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(3) + this.field_76522_a;
      boolean var7 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256) {
         int var8;
         int var10;
         int var11;
         int var12;
         for(var8 = p_76484_4_; var8 <= p_76484_4_ + 1 + var6; ++var8) {
            byte var9 = 2;
            if(var8 == p_76484_4_) {
               var9 = 1;
            }

            if(var8 >= p_76484_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10) {
               for(var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     var12 = p_76484_1_.func_72798_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca && var12 != Block.field_71980_u.field_71990_ca && var12 != Block.field_71979_v.field_71990_ca && var12 != Block.field_71951_J.field_71990_ca && var12 != Block.field_71987_y.field_71990_ca) {
                        var7 = false;
                     }
                  } else {
                     var7 = false;
                  }
               }
            }
         }

         if(!var7) {
            return false;
         } else {
            var8 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
            if((var8 == Block.field_71980_u.field_71990_ca || var8 == Block.field_71979_v.field_71990_ca) && p_76484_4_ < 256 - var6 - 1) {
               p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca, 0, 2);
               p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca, 0, 2);
               p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ - 1, p_76484_5_ + 1, Block.field_71979_v.field_71990_ca, 0, 2);
               p_76484_1_.func_72832_d(p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_ + 1, Block.field_71979_v.field_71990_ca, 0, 2);
               this.func_76519_a(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + var6, 2, p_76484_2_);

               for(int var14 = p_76484_4_ + var6 - 2 - p_76484_2_.nextInt(4); var14 > p_76484_4_ + var6 / 2; var14 -= 2 + p_76484_2_.nextInt(4)) {
                  float var15 = p_76484_2_.nextFloat() * 3.1415927F * 2.0F;
                  var11 = p_76484_3_ + (int)(0.5F + MathHelper.func_76134_b(var15) * 4.0F);
                  var12 = p_76484_5_ + (int)(0.5F + MathHelper.func_76126_a(var15) * 4.0F);
                  this.func_76519_a(p_76484_1_, var11, var12, var14, 0, p_76484_2_);

                  for(int var13 = 0; var13 < 5; ++var13) {
                     var11 = p_76484_3_ + (int)(1.5F + MathHelper.func_76134_b(var15) * (float)var13);
                     var12 = p_76484_5_ + (int)(1.5F + MathHelper.func_76126_a(var15) * (float)var13);
                     this.func_76485_a(p_76484_1_, var11, var14 - 3 + var13 / 2, var12, Block.field_71951_J.field_71990_ca, this.field_76520_b);
                  }
               }

               for(var10 = 0; var10 < var6; ++var10) {
                  var11 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var10, p_76484_5_);
                  if(var11 == 0 || var11 == Block.field_71952_K.field_71990_ca) {
                     this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var10, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76520_b);
                     if(var10 > 0) {
                        if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + var10, p_76484_5_)) {
                           this.func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + var10, p_76484_5_, Block.field_71998_bu.field_71990_ca, 8);
                        }

                        if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + var10, p_76484_5_ - 1)) {
                           this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var10, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                        }
                     }
                  }

                  if(var10 < var6 - 1) {
                     var11 = p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_);
                     if(var11 == 0 || var11 == Block.field_71952_K.field_71990_ca) {
                        this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76520_b);
                        if(var10 > 0) {
                           if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 2, p_76484_4_ + var10, p_76484_5_)) {
                              this.func_76485_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + var10, p_76484_5_, Block.field_71998_bu.field_71990_ca, 2);
                           }

                           if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_ - 1)) {
                              this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                           }
                        }
                     }

                     var11 = p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_ + 1);
                     if(var11 == 0 || var11 == Block.field_71952_K.field_71990_ca) {
                        this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_ + 1, Block.field_71951_J.field_71990_ca, this.field_76520_b);
                        if(var10 > 0) {
                           if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 2, p_76484_4_ + var10, p_76484_5_ + 1)) {
                              this.func_76485_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + var10, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 2);
                           }

                           if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_ + 2)) {
                              this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + var10, p_76484_5_ + 2, Block.field_71998_bu.field_71990_ca, 4);
                           }
                        }
                     }

                     var11 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var10, p_76484_5_ + 1);
                     if(var11 == 0 || var11 == Block.field_71952_K.field_71990_ca) {
                        this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var10, p_76484_5_ + 1, Block.field_71951_J.field_71990_ca, this.field_76520_b);
                        if(var10 > 0) {
                           if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + var10, p_76484_5_ + 1)) {
                              this.func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + var10, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 8);
                           }

                           if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + var10, p_76484_5_ + 2)) {
                              this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var10, p_76484_5_ + 2, Block.field_71998_bu.field_71990_ca, 4);
                           }
                        }
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void func_76519_a(World p_76519_1_, int p_76519_2_, int p_76519_3_, int p_76519_4_, int p_76519_5_, Random p_76519_6_) {
      byte var7 = 2;

      for(int var8 = p_76519_4_ - var7; var8 <= p_76519_4_; ++var8) {
         int var9 = var8 - p_76519_4_;
         int var10 = p_76519_5_ + 1 - var9;

         for(int var11 = p_76519_2_ - var10; var11 <= p_76519_2_ + var10 + 1; ++var11) {
            int var12 = var11 - p_76519_2_;

            for(int var13 = p_76519_3_ - var10; var13 <= p_76519_3_ + var10 + 1; ++var13) {
               int var14 = var13 - p_76519_3_;
               if((var12 >= 0 || var14 >= 0 || var12 * var12 + var14 * var14 <= var10 * var10) && (var12 <= 0 && var14 <= 0 || var12 * var12 + var14 * var14 <= (var10 + 1) * (var10 + 1)) && (p_76519_6_.nextInt(4) != 0 || var12 * var12 + var14 * var14 <= (var10 - 1) * (var10 - 1))) {
                  int var15 = p_76519_1_.func_72798_a(var11, var8, var13);
                  if(var15 == 0 || var15 == Block.field_71952_K.field_71990_ca) {
                     this.func_76485_a(p_76519_1_, var11, var8, var13, Block.field_71952_K.field_71990_ca, this.field_76521_c);
                  }
               }
            }
         }
      }

   }
}
