package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenShrub extends WorldGenerator {

   private int field_76527_a;
   private int field_76526_b;


   public WorldGenShrub(int p_i3791_1_, int p_i3791_2_) {
      this.field_76526_b = p_i3791_1_;
      this.field_76527_a = p_i3791_2_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var15;
      for(boolean var6 = false; ((var15 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || var15 == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 0; --p_76484_4_) {
         ;
      }

      int var7 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_);
      if(var7 == Block.field_71979_v.field_71990_ca || var7 == Block.field_71980_u.field_71990_ca) {
         ++p_76484_4_;
         this.func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, Block.field_71951_J.field_71990_ca, this.field_76526_b);

         for(int var8 = p_76484_4_; var8 <= p_76484_4_ + 2; ++var8) {
            int var9 = var8 - p_76484_4_;
            int var10 = 2 - var9;

            for(int var11 = p_76484_3_ - var10; var11 <= p_76484_3_ + var10; ++var11) {
               int var12 = var11 - p_76484_3_;

               for(int var13 = p_76484_5_ - var10; var13 <= p_76484_5_ + var10; ++var13) {
                  int var14 = var13 - p_76484_5_;
                  if((Math.abs(var12) != var10 || Math.abs(var14) != var10 || p_76484_2_.nextInt(2) != 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(var11, var8, var13)]) {
                     this.func_76485_a(p_76484_1_, var11, var8, var13, Block.field_71952_K.field_71990_ca, this.field_76527_a);
                  }
               }
            }
         }
      }

      return true;
   }
}
