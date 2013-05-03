package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenForest extends WorldGenerator {

   public WorldGenForest(boolean p_i3785_1_) {
      super(p_i3785_1_);
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(3) + 5;
      boolean var7 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256) {
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
               var9 = 2;
            }

            for(var10 = p_76484_3_ - var9; var10 <= p_76484_3_ + var9 && var7; ++var10) {
               for(var11 = p_76484_5_ - var9; var11 <= p_76484_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     var12 = p_76484_1_.func_72798_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca) {
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

               int var17;
               for(var17 = p_76484_4_ - 3 + var6; var17 <= p_76484_4_ + var6; ++var17) {
                  var10 = var17 - (p_76484_4_ + var6);
                  var11 = 1 - var10 / 2;

                  for(var12 = p_76484_3_ - var11; var12 <= p_76484_3_ + var11; ++var12) {
                     int var13 = var12 - p_76484_3_;

                     for(int var14 = p_76484_5_ - var11; var14 <= p_76484_5_ + var11; ++var14) {
                        int var15 = var14 - p_76484_5_;
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || p_76484_2_.nextInt(2) != 0 && var10 != 0) {
                           int var16 = p_76484_1_.func_72798_a(var12, var17, var14);
                           if(var16 == 0 || var16 == Block.field_71952_K.field_71990_ca) {
                              this.func_76485_a(p_76484_1_, var12, var17, var14, Block.field_71952_K.field_71990_ca, 2);
                           }
                        }
                     }
                  }
               }

               for(var17 = 0; var17 < var6; ++var17) {
                  var10 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var17, p_76484_5_);
                  if(var10 == 0 || var10 == Block.field_71952_K.field_71990_ca) {
                     this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var17, p_76484_5_, Block.field_71951_J.field_71990_ca, 2);
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
}
