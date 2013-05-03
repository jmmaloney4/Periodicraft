package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBigMushroom extends WorldGenerator {

   private int field_76523_a = -1;


   public WorldGenBigMushroom(int p_i3793_1_) {
      super(true);
      this.field_76523_a = p_i3793_1_;
   }

   public WorldGenBigMushroom() {
      super(false);
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(2);
      if(this.field_76523_a >= 0) {
         var6 = this.field_76523_a;
      }

      int var7 = p_76484_2_.nextInt(3) + 4;
      boolean var8 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var7 + 1 < 256) {
         int var9;
         int var11;
         int var12;
         int var13;
         for(var9 = p_76484_4_; var9 <= p_76484_4_ + 1 + var7; ++var9) {
            byte var10 = 3;
            if(var9 <= p_76484_4_ + 3) {
               var10 = 0;
            }

            for(var11 = p_76484_3_ - var10; var11 <= p_76484_3_ + var10 && var8; ++var11) {
               for(var12 = p_76484_5_ - var10; var12 <= p_76484_5_ + var10 && var8; ++var12) {
                  if(var9 >= 0 && var9 < 256) {
                     var13 = p_76484_1_.func_72798_a(var11, var9, var12);
                     if(var13 != 0 && var13 != Block.field_71952_K.field_71990_ca) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if(!var8) {
            return false;
         } else {
            var9 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
            if(var9 != Block.field_71979_v.field_71990_ca && var9 != Block.field_71980_u.field_71990_ca && var9 != Block.field_71994_by.field_71990_ca) {
               return false;
            } else {
               int var16 = p_76484_4_ + var7;
               if(var6 == 1) {
                  var16 = p_76484_4_ + var7 - 3;
               }

               for(var11 = var16; var11 <= p_76484_4_ + var7; ++var11) {
                  var12 = 1;
                  if(var11 < p_76484_4_ + var7) {
                     ++var12;
                  }

                  if(var6 == 0) {
                     var12 = 3;
                  }

                  for(var13 = p_76484_3_ - var12; var13 <= p_76484_3_ + var12; ++var13) {
                     for(int var14 = p_76484_5_ - var12; var14 <= p_76484_5_ + var12; ++var14) {
                        int var15 = 5;
                        if(var13 == p_76484_3_ - var12) {
                           --var15;
                        }

                        if(var13 == p_76484_3_ + var12) {
                           ++var15;
                        }

                        if(var14 == p_76484_5_ - var12) {
                           var15 -= 3;
                        }

                        if(var14 == p_76484_5_ + var12) {
                           var15 += 3;
                        }

                        if(var6 == 0 || var11 < p_76484_4_ + var7) {
                           if((var13 == p_76484_3_ - var12 || var13 == p_76484_3_ + var12) && (var14 == p_76484_5_ - var12 || var14 == p_76484_5_ + var12)) {
                              continue;
                           }

                           if(var13 == p_76484_3_ - (var12 - 1) && var14 == p_76484_5_ - var12) {
                              var15 = 1;
                           }

                           if(var13 == p_76484_3_ - var12 && var14 == p_76484_5_ - (var12 - 1)) {
                              var15 = 1;
                           }

                           if(var13 == p_76484_3_ + (var12 - 1) && var14 == p_76484_5_ - var12) {
                              var15 = 3;
                           }

                           if(var13 == p_76484_3_ + var12 && var14 == p_76484_5_ - (var12 - 1)) {
                              var15 = 3;
                           }

                           if(var13 == p_76484_3_ - (var12 - 1) && var14 == p_76484_5_ + var12) {
                              var15 = 7;
                           }

                           if(var13 == p_76484_3_ - var12 && var14 == p_76484_5_ + (var12 - 1)) {
                              var15 = 7;
                           }

                           if(var13 == p_76484_3_ + (var12 - 1) && var14 == p_76484_5_ + var12) {
                              var15 = 9;
                           }

                           if(var13 == p_76484_3_ + var12 && var14 == p_76484_5_ + (var12 - 1)) {
                              var15 = 9;
                           }
                        }

                        if(var15 == 5 && var11 < p_76484_4_ + var7) {
                           var15 = 0;
                        }

                        if((var15 != 0 || p_76484_4_ >= p_76484_4_ + var7 - 1) && !Block.field_71970_n[p_76484_1_.func_72798_a(var13, var11, var14)]) {
                           this.func_76485_a(p_76484_1_, var13, var11, var14, Block.field_72000_bn.field_71990_ca + var6, var15);
                        }
                     }
                  }
               }

               for(var11 = 0; var11 < var7; ++var11) {
                  var12 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var11, p_76484_5_);
                  if(!Block.field_71970_n[var12]) {
                     this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var11, p_76484_5_, Block.field_72000_bn.field_71990_ca + var6, 10);
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }
}
