package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAddSnow extends GenLayer {

   public GenLayerAddSnow(long p_i3887_1_, GenLayer p_i3887_3_) {
      super(p_i3887_1_);
      this.field_75909_a = p_i3887_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int var5 = p_75904_1_ - 1;
      int var6 = p_75904_2_ - 1;
      int var7 = p_75904_3_ + 2;
      int var8 = p_75904_4_ + 2;
      int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
      int[] var10 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var11 = 0; var11 < p_75904_4_; ++var11) {
         for(int var12 = 0; var12 < p_75904_3_; ++var12) {
            int var13 = var9[var12 + 1 + (var11 + 1) * var7];
            this.func_75903_a((long)(var12 + p_75904_1_), (long)(var11 + p_75904_2_));
            if(var13 == 0) {
               var10[var12 + var11 * p_75904_3_] = 0;
            } else {
               int var14 = this.func_75902_a(5);
               if(var14 == 0) {
                  var14 = BiomeGenBase.field_76774_n.field_76756_M;
               } else {
                  var14 = 1;
               }

               var10[var12 + var11 * p_75904_3_] = var14;
            }
         }
      }

      return var10;
   }
}
