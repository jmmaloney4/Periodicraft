package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSwamp extends WorldGenerator {

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6;
      for(var6 = p_76484_2_.nextInt(4) + 5; p_76484_1_.func_72803_f(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == Material.field_76244_g; --p_76484_4_) {
         ;
      }

      boolean var7 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 128) {
         int var8;
         int var10;
         int var11;
         int var12;
         for(var8 = p_76484_4_; var8 <= p_76484_4_ + 1 + var6; ++var8) {
            byte var9 = 1;
            if(var8 == p_76484_4_) {
               var9 = 0;
            }

            if(var8 >= p_76484_4_ + 1 + var6 - 2) {
               var9 = 3;
            }

            for(var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10) {
               for(var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 128) {
                     var12 = p_76484_1_.func_72798_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca) {
                        if(var12 != Block.field_71943_B.field_71990_ca && var12 != Block.field_71942_A.field_71990_ca) {
                           var7 = false;
                        } else if(var8 > p_76484_4_) {
                           var7 = false;
                        }
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
            if((var8 == Block.field_71980_u.field_71990_ca || var8 == Block.field_71979_v.field_71990_ca) && p_76484_4_ < 128 - var6 - 1) {
               this.func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);

               int var13;
               int var16;
               for(var16 = p_76484_4_ - 3 + var6; var16 <= p_76484_4_ + var6; ++var16) {
                  var10 = var16 - (p_76484_4_ + var6);
                  var11 = 2 - var10 / 2;

                  for(var12 = p_76484_3_ - var11; var12 <= p_76484_3_ + var11; ++var12) {
                     var13 = var12 - p_76484_3_;

                     for(int var14 = p_76484_5_ - var11; var14 <= p_76484_5_ + var11; ++var14) {
                        int var15 = var14 - p_76484_5_;
                        if((Math.abs(var13) != var11 || Math.abs(var15) != var11 || p_76484_2_.nextInt(2) != 0 && var10 != 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(var12, var16, var14)]) {
                           this.func_76486_a(p_76484_1_, var12, var16, var14, Block.field_71952_K.field_71990_ca);
                        }
                     }
                  }
               }

               for(var16 = 0; var16 < var6; ++var16) {
                  var10 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var16, p_76484_5_);
                  if(var10 == 0 || var10 == Block.field_71952_K.field_71990_ca || var10 == Block.field_71942_A.field_71990_ca || var10 == Block.field_71943_B.field_71990_ca) {
                     this.func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ + var16, p_76484_5_, Block.field_71951_J.field_71990_ca);
                  }
               }

               for(var16 = p_76484_4_ - 3 + var6; var16 <= p_76484_4_ + var6; ++var16) {
                  var10 = var16 - (p_76484_4_ + var6);
                  var11 = 2 - var10 / 2;

                  for(var12 = p_76484_3_ - var11; var12 <= p_76484_3_ + var11; ++var12) {
                     for(var13 = p_76484_5_ - var11; var13 <= p_76484_5_ + var11; ++var13) {
                        if(p_76484_1_.func_72798_a(var12, var16, var13) == Block.field_71952_K.field_71990_ca) {
                           if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var12 - 1, var16, var13) == 0) {
                              this.func_76536_b(p_76484_1_, var12 - 1, var16, var13, 8);
                           }

                           if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var12 + 1, var16, var13) == 0) {
                              this.func_76536_b(p_76484_1_, var12 + 1, var16, var13, 2);
                           }

                           if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var12, var16, var13 - 1) == 0) {
                              this.func_76536_b(p_76484_1_, var12, var16, var13 - 1, 1);
                           }

                           if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var12, var16, var13 + 1) == 0) {
                              this.func_76536_b(p_76484_1_, var12, var16, var13 + 1, 4);
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

   private void func_76536_b(World p_76536_1_, int p_76536_2_, int p_76536_3_, int p_76536_4_, int p_76536_5_) {
      this.func_76485_a(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Block.field_71998_bu.field_71990_ca, p_76536_5_);
      int var6 = 4;

      while(true) {
         --p_76536_3_;
         if(p_76536_1_.func_72798_a(p_76536_2_, p_76536_3_, p_76536_4_) != 0 || var6 <= 0) {
            return;
         }

         this.func_76485_a(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Block.field_71998_bu.field_71990_ca, p_76536_5_);
         --var6;
      }
   }
}
