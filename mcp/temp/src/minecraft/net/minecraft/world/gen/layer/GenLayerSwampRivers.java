package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSwampRivers extends GenLayer {

   public GenLayerSwampRivers(long p_i3898_1_, GenLayer p_i3898_3_) {
      super(p_i3898_1_);
      this.field_75909_a = p_i3898_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
      int[] var6 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var7 = 0; var7 < p_75904_4_; ++var7) {
         for(int var8 = 0; var8 < p_75904_3_; ++var8) {
            this.func_75903_a((long)(var8 + p_75904_1_), (long)(var7 + p_75904_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
            if((var9 != BiomeGenBase.field_76780_h.field_76756_M || this.func_75902_a(6) != 0) && (var9 != BiomeGenBase.field_76782_w.field_76756_M && var9 != BiomeGenBase.field_76792_x.field_76756_M || this.func_75902_a(8) != 0)) {
               var6[var8 + var7 * p_75904_3_] = var9;
            } else {
               var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76781_i.field_76756_M;
            }
         }
      }

      return var6;
   }
}
