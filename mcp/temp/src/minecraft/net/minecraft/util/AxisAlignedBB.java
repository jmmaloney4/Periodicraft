package net.minecraft.util;

import net.minecraft.util.AABBLocalPool;
import net.minecraft.util.AABBPool;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class AxisAlignedBB {

   private static final ThreadLocal field_72335_g = new AABBLocalPool();
   public double field_72340_a;
   public double field_72338_b;
   public double field_72339_c;
   public double field_72336_d;
   public double field_72337_e;
   public double field_72334_f;


   public static AxisAlignedBB func_72330_a(double p_72330_0_, double p_72330_2_, double p_72330_4_, double p_72330_6_, double p_72330_8_, double p_72330_10_) {
      return new AxisAlignedBB(p_72330_0_, p_72330_2_, p_72330_4_, p_72330_6_, p_72330_8_, p_72330_10_);
   }

   public static AABBPool func_72332_a() {
      return (AABBPool)field_72335_g.get();
   }

   protected AxisAlignedBB(double p_i4029_1_, double p_i4029_3_, double p_i4029_5_, double p_i4029_7_, double p_i4029_9_, double p_i4029_11_) {
      this.field_72340_a = p_i4029_1_;
      this.field_72338_b = p_i4029_3_;
      this.field_72339_c = p_i4029_5_;
      this.field_72336_d = p_i4029_7_;
      this.field_72337_e = p_i4029_9_;
      this.field_72334_f = p_i4029_11_;
   }

   public AxisAlignedBB func_72324_b(double p_72324_1_, double p_72324_3_, double p_72324_5_, double p_72324_7_, double p_72324_9_, double p_72324_11_) {
      this.field_72340_a = p_72324_1_;
      this.field_72338_b = p_72324_3_;
      this.field_72339_c = p_72324_5_;
      this.field_72336_d = p_72324_7_;
      this.field_72337_e = p_72324_9_;
      this.field_72334_f = p_72324_11_;
      return this;
   }

   public AxisAlignedBB func_72321_a(double p_72321_1_, double p_72321_3_, double p_72321_5_) {
      double var7 = this.field_72340_a;
      double var9 = this.field_72338_b;
      double var11 = this.field_72339_c;
      double var13 = this.field_72336_d;
      double var15 = this.field_72337_e;
      double var17 = this.field_72334_f;
      if(p_72321_1_ < 0.0D) {
         var7 += p_72321_1_;
      }

      if(p_72321_1_ > 0.0D) {
         var13 += p_72321_1_;
      }

      if(p_72321_3_ < 0.0D) {
         var9 += p_72321_3_;
      }

      if(p_72321_3_ > 0.0D) {
         var15 += p_72321_3_;
      }

      if(p_72321_5_ < 0.0D) {
         var11 += p_72321_5_;
      }

      if(p_72321_5_ > 0.0D) {
         var17 += p_72321_5_;
      }

      return func_72332_a().func_72299_a(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_72314_b(double p_72314_1_, double p_72314_3_, double p_72314_5_) {
      double var7 = this.field_72340_a - p_72314_1_;
      double var9 = this.field_72338_b - p_72314_3_;
      double var11 = this.field_72339_c - p_72314_5_;
      double var13 = this.field_72336_d + p_72314_1_;
      double var15 = this.field_72337_e + p_72314_3_;
      double var17 = this.field_72334_f + p_72314_5_;
      return func_72332_a().func_72299_a(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_72325_c(double p_72325_1_, double p_72325_3_, double p_72325_5_) {
      return func_72332_a().func_72299_a(this.field_72340_a + p_72325_1_, this.field_72338_b + p_72325_3_, this.field_72339_c + p_72325_5_, this.field_72336_d + p_72325_1_, this.field_72337_e + p_72325_3_, this.field_72334_f + p_72325_5_);
   }

   public double func_72316_a(AxisAlignedBB p_72316_1_, double p_72316_2_) {
      if(p_72316_1_.field_72337_e > this.field_72338_b && p_72316_1_.field_72338_b < this.field_72337_e) {
         if(p_72316_1_.field_72334_f > this.field_72339_c && p_72316_1_.field_72339_c < this.field_72334_f) {
            double var4;
            if(p_72316_2_ > 0.0D && p_72316_1_.field_72336_d <= this.field_72340_a) {
               var4 = this.field_72340_a - p_72316_1_.field_72336_d;
               if(var4 < p_72316_2_) {
                  p_72316_2_ = var4;
               }
            }

            if(p_72316_2_ < 0.0D && p_72316_1_.field_72340_a >= this.field_72336_d) {
               var4 = this.field_72336_d - p_72316_1_.field_72340_a;
               if(var4 > p_72316_2_) {
                  p_72316_2_ = var4;
               }
            }

            return p_72316_2_;
         } else {
            return p_72316_2_;
         }
      } else {
         return p_72316_2_;
      }
   }

   public double func_72323_b(AxisAlignedBB p_72323_1_, double p_72323_2_) {
      if(p_72323_1_.field_72336_d > this.field_72340_a && p_72323_1_.field_72340_a < this.field_72336_d) {
         if(p_72323_1_.field_72334_f > this.field_72339_c && p_72323_1_.field_72339_c < this.field_72334_f) {
            double var4;
            if(p_72323_2_ > 0.0D && p_72323_1_.field_72337_e <= this.field_72338_b) {
               var4 = this.field_72338_b - p_72323_1_.field_72337_e;
               if(var4 < p_72323_2_) {
                  p_72323_2_ = var4;
               }
            }

            if(p_72323_2_ < 0.0D && p_72323_1_.field_72338_b >= this.field_72337_e) {
               var4 = this.field_72337_e - p_72323_1_.field_72338_b;
               if(var4 > p_72323_2_) {
                  p_72323_2_ = var4;
               }
            }

            return p_72323_2_;
         } else {
            return p_72323_2_;
         }
      } else {
         return p_72323_2_;
      }
   }

   public double func_72322_c(AxisAlignedBB p_72322_1_, double p_72322_2_) {
      if(p_72322_1_.field_72336_d > this.field_72340_a && p_72322_1_.field_72340_a < this.field_72336_d) {
         if(p_72322_1_.field_72337_e > this.field_72338_b && p_72322_1_.field_72338_b < this.field_72337_e) {
            double var4;
            if(p_72322_2_ > 0.0D && p_72322_1_.field_72334_f <= this.field_72339_c) {
               var4 = this.field_72339_c - p_72322_1_.field_72334_f;
               if(var4 < p_72322_2_) {
                  p_72322_2_ = var4;
               }
            }

            if(p_72322_2_ < 0.0D && p_72322_1_.field_72339_c >= this.field_72334_f) {
               var4 = this.field_72334_f - p_72322_1_.field_72339_c;
               if(var4 > p_72322_2_) {
                  p_72322_2_ = var4;
               }
            }

            return p_72322_2_;
         } else {
            return p_72322_2_;
         }
      } else {
         return p_72322_2_;
      }
   }

   public boolean func_72326_a(AxisAlignedBB p_72326_1_) {
      return p_72326_1_.field_72336_d > this.field_72340_a && p_72326_1_.field_72340_a < this.field_72336_d?(p_72326_1_.field_72337_e > this.field_72338_b && p_72326_1_.field_72338_b < this.field_72337_e?p_72326_1_.field_72334_f > this.field_72339_c && p_72326_1_.field_72339_c < this.field_72334_f:false):false;
   }

   public AxisAlignedBB func_72317_d(double p_72317_1_, double p_72317_3_, double p_72317_5_) {
      this.field_72340_a += p_72317_1_;
      this.field_72338_b += p_72317_3_;
      this.field_72339_c += p_72317_5_;
      this.field_72336_d += p_72317_1_;
      this.field_72337_e += p_72317_3_;
      this.field_72334_f += p_72317_5_;
      return this;
   }

   public boolean func_72318_a(Vec3 p_72318_1_) {
      return p_72318_1_.field_72450_a > this.field_72340_a && p_72318_1_.field_72450_a < this.field_72336_d?(p_72318_1_.field_72448_b > this.field_72338_b && p_72318_1_.field_72448_b < this.field_72337_e?p_72318_1_.field_72449_c > this.field_72339_c && p_72318_1_.field_72449_c < this.field_72334_f:false):false;
   }

   public double func_72320_b() {
      double var1 = this.field_72336_d - this.field_72340_a;
      double var3 = this.field_72337_e - this.field_72338_b;
      double var5 = this.field_72334_f - this.field_72339_c;
      return (var1 + var3 + var5) / 3.0D;
   }

   public AxisAlignedBB func_72331_e(double p_72331_1_, double p_72331_3_, double p_72331_5_) {
      double var7 = this.field_72340_a + p_72331_1_;
      double var9 = this.field_72338_b + p_72331_3_;
      double var11 = this.field_72339_c + p_72331_5_;
      double var13 = this.field_72336_d - p_72331_1_;
      double var15 = this.field_72337_e - p_72331_3_;
      double var17 = this.field_72334_f - p_72331_5_;
      return func_72332_a().func_72299_a(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_72329_c() {
      return func_72332_a().func_72299_a(this.field_72340_a, this.field_72338_b, this.field_72339_c, this.field_72336_d, this.field_72337_e, this.field_72334_f);
   }

   public MovingObjectPosition func_72327_a(Vec3 p_72327_1_, Vec3 p_72327_2_) {
      Vec3 var3 = p_72327_1_.func_72429_b(p_72327_2_, this.field_72340_a);
      Vec3 var4 = p_72327_1_.func_72429_b(p_72327_2_, this.field_72336_d);
      Vec3 var5 = p_72327_1_.func_72435_c(p_72327_2_, this.field_72338_b);
      Vec3 var6 = p_72327_1_.func_72435_c(p_72327_2_, this.field_72337_e);
      Vec3 var7 = p_72327_1_.func_72434_d(p_72327_2_, this.field_72339_c);
      Vec3 var8 = p_72327_1_.func_72434_d(p_72327_2_, this.field_72334_f);
      if(!this.func_72333_b(var3)) {
         var3 = null;
      }

      if(!this.func_72333_b(var4)) {
         var4 = null;
      }

      if(!this.func_72315_c(var5)) {
         var5 = null;
      }

      if(!this.func_72315_c(var6)) {
         var6 = null;
      }

      if(!this.func_72319_d(var7)) {
         var7 = null;
      }

      if(!this.func_72319_d(var8)) {
         var8 = null;
      }

      Vec3 var9 = null;
      if(var3 != null && (var9 == null || p_72327_1_.func_72436_e(var3) < p_72327_1_.func_72436_e(var9))) {
         var9 = var3;
      }

      if(var4 != null && (var9 == null || p_72327_1_.func_72436_e(var4) < p_72327_1_.func_72436_e(var9))) {
         var9 = var4;
      }

      if(var5 != null && (var9 == null || p_72327_1_.func_72436_e(var5) < p_72327_1_.func_72436_e(var9))) {
         var9 = var5;
      }

      if(var6 != null && (var9 == null || p_72327_1_.func_72436_e(var6) < p_72327_1_.func_72436_e(var9))) {
         var9 = var6;
      }

      if(var7 != null && (var9 == null || p_72327_1_.func_72436_e(var7) < p_72327_1_.func_72436_e(var9))) {
         var9 = var7;
      }

      if(var8 != null && (var9 == null || p_72327_1_.func_72436_e(var8) < p_72327_1_.func_72436_e(var9))) {
         var9 = var8;
      }

      if(var9 == null) {
         return null;
      } else {
         byte var10 = -1;
         if(var9 == var3) {
            var10 = 4;
         }

         if(var9 == var4) {
            var10 = 5;
         }

         if(var9 == var5) {
            var10 = 0;
         }

         if(var9 == var6) {
            var10 = 1;
         }

         if(var9 == var7) {
            var10 = 2;
         }

         if(var9 == var8) {
            var10 = 3;
         }

         return new MovingObjectPosition(0, 0, 0, var10, var9);
      }
   }

   private boolean func_72333_b(Vec3 p_72333_1_) {
      return p_72333_1_ == null?false:p_72333_1_.field_72448_b >= this.field_72338_b && p_72333_1_.field_72448_b <= this.field_72337_e && p_72333_1_.field_72449_c >= this.field_72339_c && p_72333_1_.field_72449_c <= this.field_72334_f;
   }

   private boolean func_72315_c(Vec3 p_72315_1_) {
      return p_72315_1_ == null?false:p_72315_1_.field_72450_a >= this.field_72340_a && p_72315_1_.field_72450_a <= this.field_72336_d && p_72315_1_.field_72449_c >= this.field_72339_c && p_72315_1_.field_72449_c <= this.field_72334_f;
   }

   private boolean func_72319_d(Vec3 p_72319_1_) {
      return p_72319_1_ == null?false:p_72319_1_.field_72450_a >= this.field_72340_a && p_72319_1_.field_72450_a <= this.field_72336_d && p_72319_1_.field_72448_b >= this.field_72338_b && p_72319_1_.field_72448_b <= this.field_72337_e;
   }

   public void func_72328_c(AxisAlignedBB p_72328_1_) {
      this.field_72340_a = p_72328_1_.field_72340_a;
      this.field_72338_b = p_72328_1_.field_72338_b;
      this.field_72339_c = p_72328_1_.field_72339_c;
      this.field_72336_d = p_72328_1_.field_72336_d;
      this.field_72337_e = p_72328_1_.field_72337_e;
      this.field_72334_f = p_72328_1_.field_72334_f;
   }

   public String toString() {
      return "box[" + this.field_72340_a + ", " + this.field_72338_b + ", " + this.field_72339_c + " -> " + this.field_72336_d + ", " + this.field_72337_e + ", " + this.field_72334_f + "]";
   }

}
