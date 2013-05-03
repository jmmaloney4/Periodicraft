package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class MapGenRavine extends MapGenBase {

   private float[] field_75046_d = new float[1024];


   protected void func_75045_a(long p_75045_1_, int p_75045_3_, int p_75045_4_, byte[] p_75045_5_, double p_75045_6_, double p_75045_8_, double p_75045_10_, float p_75045_12_, float p_75045_13_, float p_75045_14_, int p_75045_15_, int p_75045_16_, double p_75045_17_) {
      Random var19 = new Random(p_75045_1_);
      double var20 = (double)(p_75045_3_ * 16 + 8);
      double var22 = (double)(p_75045_4_ * 16 + 8);
      float var24 = 0.0F;
      float var25 = 0.0F;
      if(p_75045_16_ <= 0) {
         int var26 = this.field_75040_a * 16 - 16;
         p_75045_16_ = var26 - var19.nextInt(var26 / 4);
      }

      boolean var54 = false;
      if(p_75045_15_ == -1) {
         p_75045_15_ = p_75045_16_ / 2;
         var54 = true;
      }

      float var27 = 1.0F;

      for(int var28 = 0; var28 < 128; ++var28) {
         if(var28 == 0 || var19.nextInt(3) == 0) {
            var27 = 1.0F + var19.nextFloat() * var19.nextFloat() * 1.0F;
         }

         this.field_75046_d[var28] = var27 * var27;
      }

      for(; p_75045_15_ < p_75045_16_; ++p_75045_15_) {
         double var53 = 1.5D + (double)(MathHelper.func_76126_a((float)p_75045_15_ * 3.1415927F / (float)p_75045_16_) * p_75045_12_ * 1.0F);
         double var30 = var53 * p_75045_17_;
         var53 *= (double)var19.nextFloat() * 0.25D + 0.75D;
         var30 *= (double)var19.nextFloat() * 0.25D + 0.75D;
         float var32 = MathHelper.func_76134_b(p_75045_14_);
         float var33 = MathHelper.func_76126_a(p_75045_14_);
         p_75045_6_ += (double)(MathHelper.func_76134_b(p_75045_13_) * var32);
         p_75045_8_ += (double)var33;
         p_75045_10_ += (double)(MathHelper.func_76126_a(p_75045_13_) * var32);
         p_75045_14_ *= 0.7F;
         p_75045_14_ += var25 * 0.05F;
         p_75045_13_ += var24 * 0.05F;
         var25 *= 0.8F;
         var24 *= 0.5F;
         var25 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
         var24 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
         if(var54 || var19.nextInt(4) != 0) {
            double var34 = p_75045_6_ - var20;
            double var36 = p_75045_10_ - var22;
            double var38 = (double)(p_75045_16_ - p_75045_15_);
            double var40 = (double)(p_75045_12_ + 2.0F + 16.0F);
            if(var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
               return;
            }

            if(p_75045_6_ >= var20 - 16.0D - var53 * 2.0D && p_75045_10_ >= var22 - 16.0D - var53 * 2.0D && p_75045_6_ <= var20 + 16.0D + var53 * 2.0D && p_75045_10_ <= var22 + 16.0D + var53 * 2.0D) {
               int var56 = MathHelper.func_76128_c(p_75045_6_ - var53) - p_75045_3_ * 16 - 1;
               int var35 = MathHelper.func_76128_c(p_75045_6_ + var53) - p_75045_3_ * 16 + 1;
               int var55 = MathHelper.func_76128_c(p_75045_8_ - var30) - 1;
               int var37 = MathHelper.func_76128_c(p_75045_8_ + var30) + 1;
               int var57 = MathHelper.func_76128_c(p_75045_10_ - var53) - p_75045_4_ * 16 - 1;
               int var39 = MathHelper.func_76128_c(p_75045_10_ + var53) - p_75045_4_ * 16 + 1;
               if(var56 < 0) {
                  var56 = 0;
               }

               if(var35 > 16) {
                  var35 = 16;
               }

               if(var55 < 1) {
                  var55 = 1;
               }

               if(var37 > 120) {
                  var37 = 120;
               }

               if(var57 < 0) {
                  var57 = 0;
               }

               if(var39 > 16) {
                  var39 = 16;
               }

               boolean var58 = false;

               int var41;
               int var44;
               for(var41 = var56; !var58 && var41 < var35; ++var41) {
                  for(int var42 = var57; !var58 && var42 < var39; ++var42) {
                     for(int var43 = var37 + 1; !var58 && var43 >= var55 - 1; --var43) {
                        var44 = (var41 * 16 + var42) * 128 + var43;
                        if(var43 >= 0 && var43 < 128) {
                           if(p_75045_5_[var44] == Block.field_71942_A.field_71990_ca || p_75045_5_[var44] == Block.field_71943_B.field_71990_ca) {
                              var58 = true;
                           }

                           if(var43 != var55 - 1 && var41 != var56 && var41 != var35 - 1 && var42 != var57 && var42 != var39 - 1) {
                              var43 = var55;
                           }
                        }
                     }
                  }
               }

               if(!var58) {
                  for(var41 = var56; var41 < var35; ++var41) {
                     double var59 = ((double)(var41 + p_75045_3_ * 16) + 0.5D - p_75045_6_) / var53;

                     for(var44 = var57; var44 < var39; ++var44) {
                        double var45 = ((double)(var44 + p_75045_4_ * 16) + 0.5D - p_75045_10_) / var53;
                        int var47 = (var41 * 16 + var44) * 128 + var37;
                        boolean var48 = false;
                        if(var59 * var59 + var45 * var45 < 1.0D) {
                           for(int var49 = var37 - 1; var49 >= var55; --var49) {
                              double var50 = ((double)var49 + 0.5D - p_75045_8_) / var30;
                              if((var59 * var59 + var45 * var45) * (double)this.field_75046_d[var49] + var50 * var50 / 6.0D < 1.0D) {
                                 byte var52 = p_75045_5_[var47];
                                 if(var52 == Block.field_71980_u.field_71990_ca) {
                                    var48 = true;
                                 }

                                 if(var52 == Block.field_71981_t.field_71990_ca || var52 == Block.field_71979_v.field_71990_ca || var52 == Block.field_71980_u.field_71990_ca) {
                                    if(var49 < 10) {
                                       p_75045_5_[var47] = (byte)Block.field_71944_C.field_71990_ca;
                                    } else {
                                       p_75045_5_[var47] = 0;
                                       if(var48 && p_75045_5_[var47 - 1] == Block.field_71979_v.field_71990_ca) {
                                          p_75045_5_[var47 - 1] = this.field_75039_c.func_72807_a(var41 + p_75045_3_ * 16, var44 + p_75045_4_ * 16).field_76752_A;
                                       }
                                    }
                                 }
                              }

                              --var47;
                           }
                        }
                     }
                  }

                  if(var54) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte[] p_75037_6_) {
      if(this.field_75038_b.nextInt(50) == 0) {
         double var7 = (double)(p_75037_2_ * 16 + this.field_75038_b.nextInt(16));
         double var9 = (double)(this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 8) + 20);
         double var11 = (double)(p_75037_3_ * 16 + this.field_75038_b.nextInt(16));
         byte var13 = 1;

         for(int var14 = 0; var14 < var13; ++var14) {
            float var15 = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
            float var16 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var17 = (this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat()) * 2.0F;
            this.func_75045_a(this.field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, var7, var9, var11, var17, var15, var16, 0, 0, 3.0D);
         }

      }
   }
}
