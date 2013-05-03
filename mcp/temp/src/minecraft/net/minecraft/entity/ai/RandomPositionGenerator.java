package net.minecraft.entity.ai;

import java.util.Random;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class RandomPositionGenerator {

   private static Vec3 field_75465_a = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);


   public static Vec3 func_75463_a(EntityCreature p_75463_0_, int p_75463_1_, int p_75463_2_) {
      return func_75462_c(p_75463_0_, p_75463_1_, p_75463_2_, (Vec3)null);
   }

   public static Vec3 func_75464_a(EntityCreature p_75464_0_, int p_75464_1_, int p_75464_2_, Vec3 p_75464_3_) {
      field_75465_a.field_72450_a = p_75464_3_.field_72450_a - p_75464_0_.field_70165_t;
      field_75465_a.field_72448_b = p_75464_3_.field_72448_b - p_75464_0_.field_70163_u;
      field_75465_a.field_72449_c = p_75464_3_.field_72449_c - p_75464_0_.field_70161_v;
      return func_75462_c(p_75464_0_, p_75464_1_, p_75464_2_, field_75465_a);
   }

   public static Vec3 func_75461_b(EntityCreature p_75461_0_, int p_75461_1_, int p_75461_2_, Vec3 p_75461_3_) {
      field_75465_a.field_72450_a = p_75461_0_.field_70165_t - p_75461_3_.field_72450_a;
      field_75465_a.field_72448_b = p_75461_0_.field_70163_u - p_75461_3_.field_72448_b;
      field_75465_a.field_72449_c = p_75461_0_.field_70161_v - p_75461_3_.field_72449_c;
      return func_75462_c(p_75461_0_, p_75461_1_, p_75461_2_, field_75465_a);
   }

   private static Vec3 func_75462_c(EntityCreature p_75462_0_, int p_75462_1_, int p_75462_2_, Vec3 p_75462_3_) {
      Random var4 = p_75462_0_.func_70681_au();
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      float var9 = -99999.0F;
      boolean var10;
      if(p_75462_0_.func_70622_aF()) {
         double var11 = (double)(p_75462_0_.func_70602_aC().func_71569_e(MathHelper.func_76128_c(p_75462_0_.field_70165_t), MathHelper.func_76128_c(p_75462_0_.field_70163_u), MathHelper.func_76128_c(p_75462_0_.field_70161_v)) + 4.0F);
         double var13 = (double)(p_75462_0_.func_70640_aD() + (float)p_75462_1_);
         var10 = var11 < var13 * var13;
      } else {
         var10 = false;
      }

      for(int var16 = 0; var16 < 10; ++var16) {
         int var12 = var4.nextInt(2 * p_75462_1_) - p_75462_1_;
         int var17 = var4.nextInt(2 * p_75462_2_) - p_75462_2_;
         int var14 = var4.nextInt(2 * p_75462_1_) - p_75462_1_;
         if(p_75462_3_ == null || (double)var12 * p_75462_3_.field_72450_a + (double)var14 * p_75462_3_.field_72449_c >= 0.0D) {
            var12 += MathHelper.func_76128_c(p_75462_0_.field_70165_t);
            var17 += MathHelper.func_76128_c(p_75462_0_.field_70163_u);
            var14 += MathHelper.func_76128_c(p_75462_0_.field_70161_v);
            if(!var10 || p_75462_0_.func_70649_d(var12, var17, var14)) {
               float var15 = p_75462_0_.func_70783_a(var12, var17, var14);
               if(var15 > var9) {
                  var9 = var15;
                  var6 = var12;
                  var7 = var17;
                  var8 = var14;
                  var5 = true;
               }
            }
         }
      }

      if(var5) {
         return p_75462_0_.field_70170_p.func_82732_R().func_72345_a((double)var6, (double)var7, (double)var8);
      } else {
         return null;
      }
   }

}
