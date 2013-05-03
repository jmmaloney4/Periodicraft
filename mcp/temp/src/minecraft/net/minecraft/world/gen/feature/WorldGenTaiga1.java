package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTaiga1 extends WorldGenerator {

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var6 = p_76484_2_.nextInt(5) + 7;
      int var7 = var6 - p_76484_2_.nextInt(2) - 3;
      int var8 = var6 - var7;
      int var9 = 1 + p_76484_2_.nextInt(var8 + 1);
      boolean var10 = true;
      if(p_76484_4_ >= 1 && p_76484_4_ + var6 + 1 <= 128) {
         int var11;
         int var13;
         int var14;
         int var15;
         int var18;
         for(var11 = p_76484_4_; var11 <= p_76484_4_ + 1 + var6 && var10; ++var11) {
            boolean var12 = true;
            if(var11 - p_76484_4_ < var7) {
               var18 = 0;
            } else {
               var18 = var9;
            }

            for(var13 = p_76484_3_ - var18; var13 <= p_76484_3_ + var18 && var10; ++var13) {
               for(var14 = p_76484_5_ - var18; var14 <= p_76484_5_ + var18 && var10; ++var14) {
                  if(var11 >= 0 && var11 < 128) {
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
            if((var11 == Block.field_71980_u.field_71990_ca || var11 == Block.field_71979_v.field_71990_ca) && p_76484_4_ < 128 - var6 - 1) {
               this.func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
               var18 = 0;

               for(var13 = p_76484_4_ + var6; var13 >= p_76484_4_ + var7; --var13) {
                  for(var14 = p_76484_3_ - var18; var14 <= p_76484_3_ + var18; ++var14) {
                     var15 = var14 - p_76484_3_;

                     for(int var16 = p_76484_5_ - var18; var16 <= p_76484_5_ + var18; ++var16) {
                        int var17 = var16 - p_76484_5_;
                        if((Math.abs(var15) != var18 || Math.abs(var17) != var18 || var18 <= 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(var14, var13, var16)]) {
                           this.func_76485_a(p_76484_1_, var14, var13, var16, Block.field_71952_K.field_71990_ca, 1);
                        }
                     }
                  }

                  if(var18 >= 1 && var13 == p_76484_4_ + var7 + 1) {
                     --var18;
                  } else if(var18 < var9) {
                     ++var18;
                  }
               }

               for(var13 = 0; var13 < var6 - 1; ++var13) {
                  var14 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + var13, p_76484_5_);
                  if(var14 == 0 || var14 == Block.field_71952_K.field_71990_ca) {
                     this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + var13, p_76484_5_, Block.field_71951_J.field_71990_ca, 1);
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
