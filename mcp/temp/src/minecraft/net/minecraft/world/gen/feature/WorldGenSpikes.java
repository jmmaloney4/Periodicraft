package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpikes extends WorldGenerator {

   private int field_76538_a;


   public WorldGenSpikes(int p_i3798_1_) {
      this.field_76538_a = p_i3798_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      if(p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == this.field_76538_a) {
         int var6 = p_76484_2_.nextInt(32) + 6;
         int var7 = p_76484_2_.nextInt(4) + 1;

         int var8;
         int var9;
         int var10;
         int var11;
         for(var8 = p_76484_3_ - var7; var8 <= p_76484_3_ + var7; ++var8) {
            for(var9 = p_76484_5_ - var7; var9 <= p_76484_5_ + var7; ++var9) {
               var10 = var8 - p_76484_3_;
               var11 = var9 - p_76484_5_;
               if(var10 * var10 + var11 * var11 <= var7 * var7 + 1 && p_76484_1_.func_72798_a(var8, p_76484_4_ - 1, var9) != this.field_76538_a) {
                  return false;
               }
            }
         }

         for(var8 = p_76484_4_; var8 < p_76484_4_ + var6 && var8 < 128; ++var8) {
            for(var9 = p_76484_3_ - var7; var9 <= p_76484_3_ + var7; ++var9) {
               for(var10 = p_76484_5_ - var7; var10 <= p_76484_5_ + var7; ++var10) {
                  var11 = var9 - p_76484_3_;
                  int var12 = var10 - p_76484_5_;
                  if(var11 * var11 + var12 * var12 <= var7 * var7 + 1) {
                     p_76484_1_.func_72832_d(var9, var8, var10, Block.field_72089_ap.field_71990_ca, 0, 2);
                  }
               }
            }
         }

         EntityEnderCrystal var13 = new EntityEnderCrystal(p_76484_1_);
         var13.func_70012_b((double)((float)p_76484_3_ + 0.5F), (double)(p_76484_4_ + var6), (double)((float)p_76484_5_ + 0.5F), p_76484_2_.nextFloat() * 360.0F, 0.0F);
         p_76484_1_.func_72838_d(var13);
         p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_ + var6, p_76484_5_, Block.field_71986_z.field_71990_ca, 0, 2);
         return true;
      } else {
         return false;
      }
   }
}
