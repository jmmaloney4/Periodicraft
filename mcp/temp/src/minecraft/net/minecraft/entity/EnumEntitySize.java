package net.minecraft.entity;

import net.minecraft.entity.EnumEntitySizeHelper;
import net.minecraft.util.MathHelper;

public enum EnumEntitySize {

   SIZE_1("SIZE_1", 0),
   SIZE_2("SIZE_2", 1),
   SIZE_3("SIZE_3", 2),
   SIZE_4("SIZE_4", 3),
   SIZE_5("SIZE_5", 4),
   SIZE_6("SIZE_6", 5);
   // $FF: synthetic field
   private static final EnumEntitySize[] $VALUES = new EnumEntitySize[]{SIZE_1, SIZE_2, SIZE_3, SIZE_4, SIZE_5, SIZE_6};


   private EnumEntitySize(String p_i3437_1_, int p_i3437_2_) {}

   public int func_75630_a(double p_75630_1_) {
      double var3 = p_75630_1_ - ((double)MathHelper.func_76128_c(p_75630_1_) + 0.5D);
      switch(EnumEntitySizeHelper.field_96565_a[this.ordinal()]) {
      case 1:
         if(var3 < 0.0D) {
            if(var3 < -0.3125D) {
               return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            }
         } else if(var3 < 0.3125D) {
            return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
         }

         return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
      case 2:
         if(var3 < 0.0D) {
            if(var3 < -0.3125D) {
               return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            }
         } else if(var3 < 0.3125D) {
            return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
         }

         return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
      case 3:
         if(var3 > 0.0D) {
            return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
         }

         return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
      case 4:
         if(var3 < 0.0D) {
            if(var3 < -0.1875D) {
               return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            }
         } else if(var3 < 0.1875D) {
            return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
         }

         return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
      case 5:
         if(var3 < 0.0D) {
            if(var3 < -0.1875D) {
               return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            }
         } else if(var3 < 0.1875D) {
            return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
         }

         return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
      case 6:
      default:
         if(var3 > 0.0D) {
            return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
         } else {
            return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
         }
      }
   }

}
