package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerHills extends GenLayer {

   public GenLayerHills(long p_i3892_1_, GenLayer p_i3892_3_) {
      super(p_i3892_1_);
      this.field_75909_a = p_i3892_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
      int[] var6 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var7 = 0; var7 < p_75904_4_; ++var7) {
         for(int var8 = 0; var8 < p_75904_3_; ++var8) {
            this.func_75903_a((long)(var8 + p_75904_1_), (long)(var7 + p_75904_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
            if(this.func_75902_a(3) == 0) {
               int var10 = var9;
               if(var9 == BiomeGenBase.field_76769_d.field_76756_M) {
                  var10 = BiomeGenBase.field_76786_s.field_76756_M;
               } else if(var9 == BiomeGenBase.field_76767_f.field_76756_M) {
                  var10 = BiomeGenBase.field_76785_t.field_76756_M;
               } else if(var9 == BiomeGenBase.field_76768_g.field_76756_M) {
                  var10 = BiomeGenBase.field_76784_u.field_76756_M;
               } else if(var9 == BiomeGenBase.field_76772_c.field_76756_M) {
                  var10 = BiomeGenBase.field_76767_f.field_76756_M;
               } else if(var9 == BiomeGenBase.field_76774_n.field_76756_M) {
                  var10 = BiomeGenBase.field_76775_o.field_76756_M;
               } else if(var9 == BiomeGenBase.field_76782_w.field_76756_M) {
                  var10 = BiomeGenBase.field_76792_x.field_76756_M;
               }

               if(var10 == var9) {
                  var6[var8 + var7 * p_75904_3_] = var9;
               } else {
                  int var11 = var5[var8 + 1 + (var7 + 1 - 1) * (p_75904_3_ + 2)];
                  int var12 = var5[var8 + 1 + 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  int var13 = var5[var8 + 1 - 1 + (var7 + 1) * (p_75904_3_ + 2)];
                  int var14 = var5[var8 + 1 + (var7 + 1 + 1) * (p_75904_3_ + 2)];
                  if(var11 == var9 && var12 == var9 && var13 == var9 && var14 == var9) {
                     var6[var8 + var7 * p_75904_3_] = var10;
                  } else {
                     var6[var8 + var7 * p_75904_3_] = var9;
                  }
               }
            } else {
               var6[var8 + var7 * p_75904_3_] = var9;
            }
         }
      }

      return var6;
   }
}
