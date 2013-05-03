package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerShore extends GenLayer {

   public GenLayerShore(long p_i3896_1_, GenLayer p_i3896_3_) {
      super(p_i3896_1_);
      this.field_75909_a = p_i3896_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
      int[] var6 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var7 = 0; var7 < p_75904_4_; ++var7) {
         for(int var8 = 0; var8 < p_75904_3_; ++var8) {
            this.func_75903_a((long)(var8 + p_75904_1_), (long)(var7 + p_75904_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
            int var10;
            int var11;
            int var12;
            int var13;
            if(var9 == BiomeGenBase.field_76789_p.field_76756_M) {
               var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
               var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
               if(var10 != BiomeGenBase.field_76771_b.field_76756_M && var11 != BiomeGenBase.field_76771_b.field_76756_M && var12 != BiomeGenBase.field_76771_b.field_76756_M && var13 != BiomeGenBase.field_76771_b.field_76756_M) {
                  var6[var8 + var7 * p_75904_3_] = var9;
               } else {
                  var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76788_q.field_76756_M;
               }
            } else if(var9 != BiomeGenBase.field_76771_b.field_76756_M && var9 != BiomeGenBase.field_76781_i.field_76756_M && var9 != BiomeGenBase.field_76780_h.field_76756_M && var9 != BiomeGenBase.field_76770_e.field_76756_M) {
               var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
               var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
               if(var10 != BiomeGenBase.field_76771_b.field_76756_M && var11 != BiomeGenBase.field_76771_b.field_76756_M && var12 != BiomeGenBase.field_76771_b.field_76756_M && var13 != BiomeGenBase.field_76771_b.field_76756_M) {
                  var6[var8 + var7 * p_75904_3_] = var9;
               } else {
                  var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
               }
            } else if(var9 == BiomeGenBase.field_76770_e.field_76756_M) {
               var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
               var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
               var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
               if(var10 == BiomeGenBase.field_76770_e.field_76756_M && var11 == BiomeGenBase.field_76770_e.field_76756_M && var12 == BiomeGenBase.field_76770_e.field_76756_M && var13 == BiomeGenBase.field_76770_e.field_76756_M) {
                  var6[var8 + var7 * p_75904_3_] = var9;
               } else {
                  var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76783_v.field_76756_M;
               }
            } else {
               var6[var8 + var7 * p_75904_3_] = var9;
            }
         }
      }

      return var6;
   }
}
