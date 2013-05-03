package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTaiga2 extends WorldGenerator {

   public WorldGenTaiga2(boolean p_i3800_1_) {
      super(p_i3800_1_);
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(4) + 6;
      int var7 = 1 + p_76484_2_.nextInt(2);
      int var8 = var6 - var7;
      int var9 = 2 + p_76484_2_.nextInt(2);
      boolean var10 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 256) {
         int var11;
         int var13;
         int var15;
         int var21;
         for(var11 = p_76484_4_; var11 <= p_76484_4_ + 1 + var6 && var10; ++var11) {
            boolean var12 = true;
            if(var11 - p_76484_4_ < var7) {
               var21 = 0;
            } else {
               var21 = var9;
            }

            for(var13 = p_76484_3_ - var21; var13 <= p_76484_3_ + var21 && var10; ++var13) {
               for(int var14 = p_76484_5_ - var21; var14 <= p_76484_5_ + var21 && var10; ++var14) {
                  if(var11 >= 0 && var11 < 256) {
                     var15 = p_76484_1_.func_72798_a(var13, var11, var14);
                     if(var15 != 0 && var15 != Block.field_71952_K.field_71990_ca) {
                        var10 = false;
                     }
                  } else {
                     var10 = false;
                  }
               }
            }
         }

         if(!var10) {
            return false;
         } else {
            var11 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
            if((var11 == Block.field_71980_u.field_71990_ca || var11 == Block.field_71979_v.field_71990_ca) && p_76484_4_ < 256 - var6 - 1) {
               this.func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
               var21 = p_76484_2_.nextInt(2);
               var13 = 1;
               byte var22 = 0;

               int var17;
               int var16;
               for(var15 = 0; var15 <= var8; ++var15) {
                  var16 = p_76484_4_ + var6 - var15;

                  for(var17 = p_76484_3_ - var21; var17 <= p_76484_3_ + var21; ++var17) {
                     int var18 = var17 - p_76484_3_;

                     for(int var19 = p_76484_5_ - var21; var19 <= p_76484_5_ + var21; ++var19) {
                        int var20 = var19 - p_76484_5_;
                        if((Math.abs(var18) != var21 || Math.abs(var20) != var21 || var21 <= 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(var17, var16, var19)]) {
                           this.func_76485_a(p_76484_1_, var17, var16, var19, Block.field_71952_K.field_71990_ca, 1);
                        }
                     }
                  }

                  if(var21 >= var13) {
                     var21 = var22;
                     var22 = 1;
                     ++var13;
                     if(var13 > var9) {
                        var13 = var9;
                     }
                  } else {
                     ++var21;
                  }
               }

               var15 = p_76484_2_.nextInt(3);

               for(var16 = 0; var16 < var6 - var15; ++var16) {
                  var17 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var16, p_76484_5_);
                  if(var17 == 0 || var17 == Block.field_71952_K.field_71990_ca) {
                     this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var16, p_76484_5_, Block.field_71951_J.field_71990_ca, 1);
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
