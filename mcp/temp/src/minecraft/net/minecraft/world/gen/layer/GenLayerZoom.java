package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerZoom extends GenLayer {

   public GenLayerZoom(long p_i3900_1_, GenLayer p_i3900_3_) {
      super(p_i3900_1_);
      super.field_75909_a = p_i3900_3_;
   }

   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
      int var5 = p_75904_1_ >> 1;
      int var6 = p_75904_2_ >> 1;
      int var7 = (p_75904_3_ >> 1) + 3;
      int var8 = (p_75904_4_ >> 1) + 3;
      int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
      int[] var10 = IntCache.func_76445_a(var7 * 2 * var8 * 2);
      int var11 = var7 << 1;

      int var13;
      for(int var12 = 0; var12 < var8 - 1; ++var12) {
         var13 = var12 << 1;
         int var14 = var13 * var11;
         int var15 = var9[0 + (var12 + 0) * var7];
         int var16 = var9[0 + (var12 + 1) * var7];

         for(int var17 = 0; var17 < var7 - 1; ++var17) {
            this.func_75903_a((long)(var17 + var5 << 1), (long)(var12 + var6 << 1));
            int var18 = var9[var17 + 1 + (var12 + 0) * var7];
            int var19 = var9[var17 + 1 + (var12 + 1) * var7];
            var10[var14] = var15;
            var10[var14++ + var11] = this.func_75917_a(var15, var16);
            var10[var14] = this.func_75917_a(var15, var18);
            var10[var14++ + var11] = this.func_75916_b(var15, var18, var16, var19);
            var15 = var18;
            var16 = var19;
         }
      }

      int[] var20 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);

      for(var13 = 0; var13 < p_75904_4_; ++var13) {
         System.arraycopy(var10, (var13 + (p_75904_2_ & 1)) * (var7 << 1) + (p_75904_1_ & 1), var20, var13 * p_75904_3_, p_75904_3_);
      }

      return var20;
   }

   protected int func_75917_a(int p_75917_1_, int p_75917_2_) {
      return this.func_75902_a(2) == 0?p_75917_1_:p_75917_2_;
   }

   protected int func_75916_b(int p_75916_1_, int p_75916_2_, int p_75916_3_, int p_75916_4_) {
      if(p_75916_2_ == p_75916_3_ && p_75916_3_ == p_75916_4_) {
         return p_75916_2_;
      } else if(p_75916_1_ == p_75916_2_ && p_75916_1_ == p_75916_3_) {
         return p_75916_1_;
      } else if(p_75916_1_ == p_75916_2_ && p_75916_1_ == p_75916_4_) {
         return p_75916_1_;
      } else if(p_75916_1_ == p_75916_3_ && p_75916_1_ == p_75916_4_) {
         return p_75916_1_;
      } else if(p_75916_1_ == p_75916_2_ && p_75916_3_ != p_75916_4_) {
         return p_75916_1_;
      } else if(p_75916_1_ == p_75916_3_ && p_75916_2_ != p_75916_4_) {
         return p_75916_1_;
      } else if(p_75916_1_ == p_75916_4_ && p_75916_2_ != p_75916_3_) {
         return p_75916_1_;
      } else if(p_75916_2_ == p_75916_1_ && p_75916_3_ != p_75916_4_) {
         return p_75916_2_;
      } else if(p_75916_2_ == p_75916_3_ && p_75916_1_ != p_75916_4_) {
         return p_75916_2_;
      } else if(p_75916_2_ == p_75916_4_ && p_75916_1_ != p_75916_3_) {
         return p_75916_2_;
      } else if(p_75916_3_ == p_75916_1_ && p_75916_2_ != p_75916_4_) {
         return p_75916_3_;
      } else if(p_75916_3_ == p_75916_2_ && p_75916_1_ != p_75916_4_) {
         return p_75916_3_;
      } else if(p_75916_3_ == p_75916_4_ && p_75916_1_ != p_75916_2_) {
         return p_75916_3_;
      } else if(p_75916_4_ == p_75916_1_ && p_75916_2_ != p_75916_3_) {
         return p_75916_3_;
      } else if(p_75916_4_ == p_75916_2_ && p_75916_1_ != p_75916_3_) {
         return p_75916_3_;
      } else if(p_75916_4_ == p_75916_3_ && p_75916_1_ != p_75916_2_) {
         return p_75916_3_;
      } else {
         int var5 = this.func_75902_a(4);
         return var5 == 0?p_75916_1_:(var5 == 1?p_75916_2_:(var5 == 2?p_75916_3_:p_75916_4_));
      }
   }

   public static GenLayer func_75915_a(long p_75915_0_, GenLayer p_75915_2_, int p_75915_3_) {
      Object var4 = p_75915_2_;

      for(int var5 = 0; var5 < p_75915_3_; ++var5) {
         var4 = new GenLayerZoom(p_75915_0_ + (long)var5, (GenLayer)var4);
      }

      return (GenLayer)var4;
   }
}
