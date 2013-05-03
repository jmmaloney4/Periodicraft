package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSand extends WorldGenerator {

   private int field_76540_a;
   private int field_76539_b;


   public WorldGenSand(int p_i3797_1_, int p_i3797_2_) {
      this.field_76540_a = p_i3797_2_;
      this.field_76539_b = p_i3797_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      if(p_76484_1_.func_72803_f(p_76484_3_, p_76484_4_, p_76484_5_) != Material.field_76244_g) {
         return false;
      } else {
         int var6 = p_76484_2_.nextInt(this.field_76539_b - 2) + 2;
         byte var7 = 2;

         for(int var8 = p_76484_3_ - var6; var8 <= p_76484_3_ + var6; ++var8) {
            for(int var9 = p_76484_5_ - var6; var9 <= p_76484_5_ + var6; ++var9) {
               int var10 = var8 - p_76484_3_;
               int var11 = var9 - p_76484_5_;
               if(var10 * var10 + var11 * var11 <= var6 * var6) {
                  for(int var12 = p_76484_4_ - var7; var12 <= p_76484_4_ + var7; ++var12) {
                     int var13 = p_76484_1_.func_72798_a(var8, var12, var9);
                     if(var13 == Block.field_71979_v.field_71990_ca || var13 == Block.field_71980_u.field_71990_ca) {
                        p_76484_1_.func_72832_d(var8, var12, var9, this.field_76540_a, 0, 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
