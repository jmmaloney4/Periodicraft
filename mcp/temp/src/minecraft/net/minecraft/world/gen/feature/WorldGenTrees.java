package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTrees extends WorldGenerator {

   private final int field_76533_a;
   private final boolean field_76531_b;
   private final int field_76532_c;
   private final int field_76530_d;


   public WorldGenTrees(boolean p_i3802_1_) {
      this(p_i3802_1_, 4, 0, 0, false);
   }

   public WorldGenTrees(boolean p_i3803_1_, int p_i3803_2_, int p_i3803_3_, int p_i3803_4_, boolean p_i3803_5_) {
      super(p_i3803_1_);
      this.field_76533_a = p_i3803_2_;
      this.field_76532_c = p_i3803_3_;
      this.field_76530_d = p_i3803_4_;
      this.field_76531_b = p_i3803_5_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(3) + this.field_76533_a;
      boolean var7 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256) {
         int var8;
         byte var9;
         int var11;
         int var12;
         for(var8 = p_76484_4_; var8 <= p_76484_4_ + 1 + var6; ++var8) {
            var9 = 1;
            if(var8 == p_76484_4_) {
               var9 = 0;
            }

            if(var8 >= p_76484_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(int var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10) {
               for(var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     var12 = p_76484_1_.func_72798_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca && var12 != Block.field_71980_u.field_71990_ca && var12 != Block.field_71979_v.field_71990_ca && var12 != Block.field_71951_J.field_71990_ca) {
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
               this.func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
               var9 = 3;
               byte var19 = 0;

               int var13;
               int var14;
               int var15;
               for(var11 = p_76484_4_ - var9 + var6; var11 <= p_76484_4_ + var6; ++var11) {
                  var12 = var11 - (p_76484_4_ + var6);
                  var13 = var19 + 1 - var12 / 2;

                  for(var14 = p_76484_3_ - var13; var14 <= p_76484_3_ + var13; ++var14) {
                     var15 = var14 - p_76484_3_;

                     for(int var16 = p_76484_5_ - var13; var16 <= p_76484_5_ + var13; ++var16) {
                        int var17 = var16 - p_76484_5_;
                        if(Math.abs(var15) != var13 || Math.abs(var17) != var13 || p_76484_2_.nextInt(2) != 0 && var12 != 0) {
                           int var18 = p_76484_1_.func_72798_a(var14, var11, var16);
                           if(var18 == 0 || var18 == Block.field_71952_K.field_71990_ca) {
                              this.func_76485_a(p_76484_1_, var14, var11, var16, Block.field_71952_K.field_71990_ca, this.field_76530_d);
                           }
                        }
                     }
                  }
               }

               for(var11 = 0; var11 < var6; ++var11) {
                  var12 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var11, p_76484_5_);
                  if(var12 == 0 || var12 == Block.field_71952_K.field_71990_ca) {
                     this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var11, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76532_c);
                     if(this.field_76531_b && var11 > 0) {
                        if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + var11, p_76484_5_)) {
                           this.func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + var11, p_76484_5_, Block.field_71998_bu.field_71990_ca, 8);
                        }

                        if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + var11, p_76484_5_)) {
                           this.func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + var11, p_76484_5_, Block.field_71998_bu.field_71990_ca, 2);
                        }

                        if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + var11, p_76484_5_ - 1)) {
                           this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var11, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                        }

                        if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + var11, p_76484_5_ + 1)) {
                           this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var11, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 4);
                        }
                     }
                  }
               }

               if(this.field_76531_b) {
                  for(var11 = p_76484_4_ - 3 + var6; var11 <= p_76484_4_ + var6; ++var11) {
                     var12 = var11 - (p_76484_4_ + var6);
                     var13 = 2 - var12 / 2;

                     for(var14 = p_76484_3_ - var13; var14 <= p_76484_3_ + var13; ++var14) {
                        for(var15 = p_76484_5_ - var13; var15 <= p_76484_5_ + var13; ++var15) {
                           if(p_76484_1_.func_72798_a(var14, var11, var15) == Block.field_71952_K.field_71990_ca) {
                              if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var14 - 1, var11, var15) == 0) {
                                 this.func_76529_b(p_76484_1_, var14 - 1, var11, var15, 8);
                              }

                              if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var14 + 1, var11, var15) == 0) {
                                 this.func_76529_b(p_76484_1_, var14 + 1, var11, var15, 2);
                              }

                              if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var14, var11, var15 - 1) == 0) {
                                 this.func_76529_b(p_76484_1_, var14, var11, var15 - 1, 1);
                              }

                              if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(var14, var11, var15 + 1) == 0) {
                                 this.func_76529_b(p_76484_1_, var14, var11, var15 + 1, 4);
                              }
                           }
                        }
                     }
                  }

                  if(p_76484_2_.nextInt(5) == 0 && var6 > 5) {
                     for(var11 = 0; var11 < 2; ++var11) {
                        for(var12 = 0; var12 < 4; ++var12) {
                           if(p_76484_2_.nextInt(4 - var11) == 0) {
                              var13 = p_76484_2_.nextInt(3);
                              this.func_76485_a(p_76484_1_, p_76484_3_ + Direction.field_71583_a[Direction.field_71580_e[var12]], p_76484_4_ + var6 - 5 + var11, p_76484_5_ + Direction.field_71581_b[Direction.field_71580_e[var12]], Block.field_72086_bP.field_71990_ca, var13 << 2 | var12);
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

   private void func_76529_b(World p_76529_1_, int p_76529_2_, int p_76529_3_, int p_76529_4_, int p_76529_5_) {
      this.func_76485_a(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Block.field_71998_bu.field_71990_ca, p_76529_5_);
      int var6 = 4;

      while(true) {
         --p_76529_3_;
         if(p_76529_1_.func_72798_a(p_76529_2_, p_76529_3_, p_76529_4_) != 0 || var6 <= 0) {
            return;
         }

         this.func_76485_a(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Block.field_71998_bu.field_71990_ca, p_76529_5_);
         --var6;
      }
   }
}
