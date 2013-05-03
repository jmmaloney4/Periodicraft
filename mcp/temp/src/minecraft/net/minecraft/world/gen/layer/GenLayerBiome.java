package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiome extends GenLayer {

   private BiomeGenBase[] field_75914_b;


   public GenLayerBiome(long p_i3888_1_, GenLayer p_i3888_3_, WorldType p_i3888_4_) {
      super(p_i3888_1_);
      this.field_75914_b = new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g, BiomeGenBase.field_76782_w};
      this.field_75909_a = p_i3888_3_;
      if(p_i3888_4_ == WorldType.field_77136_e) {
         this.field_75914_b = new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g};
      }

   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int[] var5 = this.field_75909_a.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
      int[] var6 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(int var7 = 0; var7 < p_75904_4_; ++var7) {
         for(int var8 = 0; var8 < p_75904_3_; ++var8) {
            this.func_75903_a((long)(var8 + p_75904_1_), (long)(var7 + p_75904_2_));
            int var9 = var5[var8 + var7 * p_75904_3_];
            if(var9 == 0) {
               var6[var8 + var7 * p_75904_3_] = 0;
            } else if(var9 == BiomeGenBase.field_76789_p.field_76756_M) {
               var6[var8 + var7 * p_75904_3_] = var9;
            } else if(var9 == 1) {
               var6[var8 + var7 * p_75904_3_] = this.field_75914_b[this.func_75902_a(this.field_75914_b.length)].field_76756_M;
            } else {
               int var10 = this.field_75914_b[this.func_75902_a(this.field_75914_b.length)].field_76756_M;
               if(var10 == BiomeGenBase.field_76768_g.field_76756_M) {
                  var6[var8 + var7 * p_75904_3_] = var10;
               } else {
                  var6[var8 + var7 * p_75904_3_] = BiomeGenBase.field_76774_n.field_76756_M;
               }
            }
         }
      }

      return var6;
   }
}
