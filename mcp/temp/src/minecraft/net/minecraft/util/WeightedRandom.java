package net.minecraft.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.util.WeightedRandomItem;

public class WeightedRandom {

   public static int func_76272_a(Collection p_76272_0_) {
      int var1 = 0;

      WeightedRandomItem var3;
      for(Iterator var2 = p_76272_0_.iterator(); var2.hasNext(); var1 += var3.field_76292_a) {
         var3 = (WeightedRandomItem)var2.next();
      }

      return var1;
   }

   public static WeightedRandomItem func_76273_a(Random p_76273_0_, Collection p_76273_1_, int p_76273_2_) {
      if(p_76273_2_ <= 0) {
         throw new IllegalArgumentException();
      } else {
         int var3 = p_76273_0_.nextInt(p_76273_2_);
         Iterator var4 = p_76273_1_.iterator();

         WeightedRandomItem var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = (WeightedRandomItem)var4.next();
            var3 -= var5.field_76292_a;
         } while(var3 >= 0);

         return var5;
      }
   }

   public static WeightedRandomItem func_76271_a(Random p_76271_0_, Collection p_76271_1_) {
      return func_76273_a(p_76271_0_, p_76271_1_, func_76272_a(p_76271_1_));
   }

   public static int func_76270_a(WeightedRandomItem[] p_76270_0_) {
      int var1 = 0;
      WeightedRandomItem[] var2 = p_76270_0_;
      int var3 = p_76270_0_.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         WeightedRandomItem var5 = var2[var4];
         var1 += var5.field_76292_a;
      }

      return var1;
   }

   public static WeightedRandomItem func_76269_a(Random p_76269_0_, WeightedRandomItem[] p_76269_1_, int p_76269_2_) {
      if(p_76269_2_ <= 0) {
         throw new IllegalArgumentException();
      } else {
         int var3 = p_76269_0_.nextInt(p_76269_2_);
         WeightedRandomItem[] var4 = p_76269_1_;
         int var5 = p_76269_1_.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            WeightedRandomItem var7 = var4[var6];
            var3 -= var7.field_76292_a;
            if(var3 < 0) {
               return var7;
            }
         }

         return null;
      }
   }

   public static WeightedRandomItem func_76274_a(Random p_76274_0_, WeightedRandomItem[] p_76274_1_) {
      return func_76269_a(p_76274_0_, p_76274_1_, func_76270_a(p_76274_1_));
   }
}
