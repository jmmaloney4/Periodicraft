package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public class MapGenCaves extends MapGenBase {

   protected void func_75041_a(long p_75041_1_, int p_75041_3_, int p_75041_4_, byte[] p_75041_5_, double p_75041_6_, double p_75041_8_, double p_75041_10_) {
      this.func_75042_a(p_75041_1_, p_75041_3_, p_75041_4_, p_75041_5_, p_75041_6_, p_75041_8_, p_75041_10_, 1.0F + this.field_75038_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void func_75042_a(long p_75042_1_, int p_75042_3_, int p_75042_4_, byte[] p_75042_5_, double p_75042_6_, double p_75042_8_, double p_75042_10_, float p_75042_12_, float p_75042_13_, float p_75042_14_, int p_75042_15_, int p_75042_16_, double p_75042_17_) {
      double var19 = (double)(p_75042_3_ * 16 + 8);
      double var21 = (double)(p_75042_4_ * 16 + 8);
      float var23 = 0.0F;
      float var24 = 0.0F;
      Random var25 = new Random(p_75042_1_);
      if(p_75042_16_ <= 0) {
         int var26 = this.field_75040_a * 16 - 16;
         p_75042_16_ = var26 - var25.nextInt(var26 / 4);
      }

      boolean var54 = false;
      if(p_75042_15_ == -1) {
         p_75042_15_ = p_75042_16_ / 2;
         var54 = true;
      }

      int var27 = var25.nextInt(p_75042_16_ / 2) + p_75042_16_ / 4;

      for(boolean var28 = var25.nextInt(6) == 0; p_75042_15_ < p_75042_16_; ++p_75042_15_) {
         double var29 = 1.5D + (double)(MathHelper.func_76126_a((float)p_75042_15_ * 3.1415927F / (float)p_75042_16_) * p_75042_12_ * 1.0F);
         double var31 = var29 * p_75042_17_;
         float var33 = MathHelper.func_76134_b(p_75042_14_);
         float var34 = MathHelper.func_76126_a(p_75042_14_);
         p_75042_6_ += (double)(MathHelper.func_76134_b(p_75042_13_) * var33);
         p_75042_8_ += (double)var34;
         p_75042_10_ += (double)(MathHelper.func_76126_a(p_75042_13_) * var33);
         if(var28) {
            p_75042_14_ *= 0.92F;
         } else {
            p_75042_14_ *= 0.7F;
         }

         p_75042_14_ += var24 * 0.1F;
         p_75042_13_ += var23 * 0.1F;
         var24 *= 0.9F;
         var23 *= 0.75F;
         var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
         var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
         if(!var54 && p_75042_15_ == var27 && p_75042_12_ > 1.0F && p_75042_16_ > 0) {
            this.func_75042_a(var25.nextLong(), p_75042_3_, p_75042_4_, p_75042_5_, p_75042_6_, p_75042_8_, p_75042_10_, var25.nextFloat() * 0.5F + 0.5F, p_75042_13_ - 1.5707964F, p_75042_14_ / 3.0F, p_75042_15_, p_75042_16_, 1.0D);
            this.func_75042_a(var25.nextLong(), p_75042_3_, p_75042_4_, p_75042_5_, p_75042_6_, p_75042_8_, p_75042_10_, var25.nextFloat() * 0.5F + 0.5F, p_75042_13_ + 1.5707964F, p_75042_14_ / 3.0F, p_75042_15_, p_75042_16_, 1.0D);
            return;
         }

         if(var54 || var25.nextInt(4) != 0) {
            double var35 = p_75042_6_ - var19;
            double var37 = p_75042_10_ - var21;
            double var39 = (double)(p_75042_16_ - p_75042_15_);
            double var41 = (double)(p_75042_12_ + 2.0F + 16.0F);
            if(var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
               return;
            }

            if(p_75042_6_ >= var19 - 16.0D - var29 * 2.0D && p_75042_10_ >= var21 - 16.0D - var29 * 2.0D && p_75042_6_ <= var19 + 16.0D + var29 * 2.0D && p_75042_10_ <= var21 + 16.0D + var29 * 2.0D) {
               int var55 = MathHelper.func_76128_c(p_75042_6_ - var29) - p_75042_3_ * 16 - 1;
               int var36 = MathHelper.func_76128_c(p_75042_6_ + var29) - p_75042_3_ * 16 + 1;
               int var57 = MathHelper.func_76128_c(p_75042_8_ - var31) - 1;
               int var38 = MathHelper.func_76128_c(p_75042_8_ + var31) + 1;
               int var56 = MathHelper.func_76128_c(p_75042_10_ - var29) - p_75042_4_ * 16 - 1;
               int var40 = MathHelper.func_76128_c(p_75042_10_ + var29) - p_75042_4_ * 16 + 1;
               if(var55 < 0) {
                  var55 = 0;
               }

               if(var36 > 16) {
                  var36 = 16;
               }

               if(var57 < 1) {
                  var57 = 1;
               }

               if(var38 > 120) {
                  var38 = 120;
               }

               if(var56 < 0) {
                  var56 = 0;
               }

               if(var40 > 16) {
                  var40 = 16;
               }

               boolean var58 = false;

               int var42;
               int var45;
               for(var42 = var55; !var58 && var42 < var36; ++var42) {
                  for(int var43 = var56; !var58 && var43 < var40; ++var43) {
                     for(int var44 = var38 + 1; !var58 && var44 >= var57 - 1; --var44) {
                        var45 = (var42 * 16 + var43) * 128 + var44;
                        if(var44 >= 0 && var44 < 128) {
                           if(p_75042_5_[var45] == Block.field_71942_A.field_71990_ca || p_75042_5_[var45] == Block.field_71943_B.field_71990_ca) {
                              var58 = true;
                           }

                           if(var44 != var57 - 1 && var42 != var55 && var42 != var36 - 1 && var43 != var56 && var43 != var40 - 1) {
                              var44 = var57;
                           }
                        }
                     }
                  }
               }

               if(!var58) {
                  for(var42 = var55; var42 < var36; ++var42) {
                     double var59 = ((double)(var42 + p_75042_3_ * 16) + 0.5D - p_75042_6_) / var29;

                     for(var45 = var56; var45 < var40; ++var45) {
                        double var46 = ((double)(var45 + p_75042_4_ * 16) + 0.5D - p_75042_10_) / var29;
                        int var48 = (var42 * 16 + var45) * 128 + var38;
                        boolean var49 = false;
                        if(var59 * var59 + var46 * var46 < 1.0D) {
                           for(int var50 = var38 - 1; var50 >= var57; --var50) {
                              double var51 = ((double)var50 + 0.5D - p_75042_8_) / var31;
                              if(var51 > -0.7D && var59 * var59 + var51 * var51 + var46 * var46 < 1.0D) {
                                 byte var53 = p_75042_5_[var48];
                                 if(var53 == Block.field_71980_u.field_71990_ca) {
                                    var49 = true;
                                 }

                                 if(var53 == Block.field_71981_t.field_71990_ca || var53 == Block.field_71979_v.field_71990_ca || var53 == Block.field_71980_u.field_71990_ca) {
                                    if(var50 < 10) {
                                       p_75042_5_[var48] = (byte)Block.field_71944_C.field_71990_ca;
                                    } else {
                                       p_75042_5_[var48] = 0;
                                       if(var49 && p_75042_5_[var48 - 1] == Block.field_71979_v.field_71990_ca) {
                                          p_75042_5_[var48 - 1] = this.field_75039_c.func_72807_a(var42 + p_75042_3_ * 16, var45 + p_75042_4_ * 16).field_76752_A;
                                       }
                                    }
                                 }
                              }

                              --var48;
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
      int var7 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 1) + 1);
      if(this.field_75038_b.nextInt(15) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(p_75037_2_ * 16 + this.field_75038_b.nextInt(16));
         double var11 = (double)this.field_75038_b.nextInt(this.field_75038_b.nextInt(120) + 8);
         double var13 = (double)(p_75037_3_ * 16 + this.field_75038_b.nextInt(16));
         int var15 = 1;
         if(this.field_75038_b.nextInt(4) == 0) {
            this.func_75041_a(this.field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, var9, var11, var13);
            var15 += this.field_75038_b.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
            float var18 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat();
            if(this.field_75038_b.nextInt(10) == 0) {
               var19 *= this.field_75038_b.nextFloat() * this.field_75038_b.nextFloat() * 3.0F + 1.0F;
            }

            this.func_75042_a(this.field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
         }
      }

   }
}
