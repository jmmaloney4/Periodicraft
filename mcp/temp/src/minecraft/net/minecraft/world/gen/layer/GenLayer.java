package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerAddSnow;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerSwampRivers;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayer {

   private long field_75907_b;
   protected GenLayer field_75909_a;
   private long field_75908_c;
   private long field_75906_d;


   public static GenLayer[] func_75901_a(long p_75901_0_, WorldType p_75901_2_) {
      GenLayerIsland var3 = new GenLayerIsland(1L);
      GenLayerFuzzyZoom var9 = new GenLayerFuzzyZoom(2000L, var3);
      GenLayerAddIsland var10 = new GenLayerAddIsland(1L, var9);
      GenLayerZoom var11 = new GenLayerZoom(2001L, var10);
      var10 = new GenLayerAddIsland(2L, var11);
      GenLayerAddSnow var12 = new GenLayerAddSnow(2L, var10);
      var11 = new GenLayerZoom(2002L, var12);
      var10 = new GenLayerAddIsland(3L, var11);
      var11 = new GenLayerZoom(2003L, var10);
      var10 = new GenLayerAddIsland(4L, var11);
      GenLayerAddMushroomIsland var16 = new GenLayerAddMushroomIsland(5L, var10);
      byte var4 = 4;
      if(p_75901_2_ == WorldType.field_77135_d) {
         var4 = 6;
      }

      GenLayer var5 = GenLayerZoom.func_75915_a(1000L, var16, 0);
      GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var5);
      var5 = GenLayerZoom.func_75915_a(1000L, var13, var4 + 2);
      GenLayerRiver var14 = new GenLayerRiver(1L, var5);
      GenLayerSmooth var15 = new GenLayerSmooth(1000L, var14);
      GenLayer var6 = GenLayerZoom.func_75915_a(1000L, var16, 0);
      GenLayerBiome var17 = new GenLayerBiome(200L, var6, p_75901_2_);
      var6 = GenLayerZoom.func_75915_a(1000L, var17, 2);
      Object var18 = new GenLayerHills(1000L, var6);

      for(int var7 = 0; var7 < var4; ++var7) {
         var18 = new GenLayerZoom((long)(1000 + var7), (GenLayer)var18);
         if(var7 == 0) {
            var18 = new GenLayerAddIsland(3L, (GenLayer)var18);
         }

         if(var7 == 1) {
            var18 = new GenLayerShore(1000L, (GenLayer)var18);
         }

         if(var7 == 1) {
            var18 = new GenLayerSwampRivers(1000L, (GenLayer)var18);
         }
      }

      GenLayerSmooth var19 = new GenLayerSmooth(1000L, (GenLayer)var18);
      GenLayerRiverMix var20 = new GenLayerRiverMix(100L, var19, var15);
      GenLayerVoronoiZoom var8 = new GenLayerVoronoiZoom(10L, var20);
      var20.func_75905_a(p_75901_0_);
      var8.func_75905_a(p_75901_0_);
      return new GenLayer[]{var20, var8, var20};
   }

   public GenLayer(long p_i3891_1_) {
      this.field_75906_d = p_i3891_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i3891_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i3891_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i3891_1_;
   }

   public void func_75905_a(long p_75905_1_) {
      this.field_75907_b = p_75905_1_;
      if(this.field_75909_a != null) {
         this.field_75909_a.func_75905_a(p_75905_1_);
      }

      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
   }

   public void func_75903_a(long p_75903_1_, long p_75903_3_) {
      this.field_75908_c = this.field_75907_b;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
   }

   protected int func_75902_a(int p_75902_1_) {
      int var2 = (int)((this.field_75908_c >> 24) % (long)p_75902_1_);
      if(var2 < 0) {
         var2 += p_75902_1_;
      }

      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += this.field_75907_b;
      return var2;
   }

   public abstract int[] func_75904_a(int var1, int var2, int var3, int var4);
}
