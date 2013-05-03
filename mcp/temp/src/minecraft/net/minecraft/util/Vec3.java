package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3Pool;

public class Vec3 {

   public static final Vec3Pool field_82592_a = new Vec3Pool(-1, -1);
   public final Vec3Pool field_72447_d;
   public double field_72450_a;
   public double field_72448_b;
   public double field_72449_c;


   public static Vec3 func_72443_a(double p_72443_0_, double p_72443_2_, double p_72443_4_) {
      return new Vec3(field_82592_a, p_72443_0_, p_72443_2_, p_72443_4_);
   }

   protected Vec3(Vec3Pool p_i5109_1_, double p_i5109_2_, double p_i5109_4_, double p_i5109_6_) {
      if(p_i5109_2_ == -0.0D) {
         p_i5109_2_ = 0.0D;
      }

      if(p_i5109_4_ == -0.0D) {
         p_i5109_4_ = 0.0D;
      }

      if(p_i5109_6_ == -0.0D) {
         p_i5109_6_ = 0.0D;
      }

      this.field_72450_a = p_i5109_2_;
      this.field_72448_b = p_i5109_4_;
      this.field_72449_c = p_i5109_6_;
      this.field_72447_d = p_i5109_1_;
   }

   protected Vec3 func_72439_b(double p_72439_1_, double p_72439_3_, double p_72439_5_) {
      this.field_72450_a = p_72439_1_;
      this.field_72448_b = p_72439_3_;
      this.field_72449_c = p_72439_5_;
      return this;
   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_72444_a(Vec3 p_72444_1_) {
      return this.field_72447_d.func_72345_a(p_72444_1_.field_72450_a - this.field_72450_a, p_72444_1_.field_72448_b - this.field_72448_b, p_72444_1_.field_72449_c - this.field_72449_c);
   }

   public Vec3 func_72432_b() {
      double var1 = (double)MathHelper.func_76133_a(this.field_72450_a * this.field_72450_a + this.field_72448_b * this.field_72448_b + this.field_72449_c * this.field_72449_c);
      return var1 < 1.0E-4D?this.field_72447_d.func_72345_a(0.0D, 0.0D, 0.0D):this.field_72447_d.func_72345_a(this.field_72450_a / var1, this.field_72448_b / var1, this.field_72449_c / var1);
   }

   public double func_72430_b(Vec3 p_72430_1_) {
      return this.field_72450_a * p_72430_1_.field_72450_a + this.field_72448_b * p_72430_1_.field_72448_b + this.field_72449_c * p_72430_1_.field_72449_c;
   }

   @SideOnly(Side.CLIENT)
   public Vec3 func_72431_c(Vec3 p_72431_1_) {
      return this.field_72447_d.func_72345_a(this.field_72448_b * p_72431_1_.field_72449_c - this.field_72449_c * p_72431_1_.field_72448_b, this.field_72449_c * p_72431_1_.field_72450_a - this.field_72450_a * p_72431_1_.field_72449_c, this.field_72450_a * p_72431_1_.field_72448_b - this.field_72448_b * p_72431_1_.field_72450_a);
   }

   public Vec3 func_72441_c(double p_72441_1_, double p_72441_3_, double p_72441_5_) {
      return this.field_72447_d.func_72345_a(this.field_72450_a + p_72441_1_, this.field_72448_b + p_72441_3_, this.field_72449_c + p_72441_5_);
   }

   public double func_72438_d(Vec3 p_72438_1_) {
      double var2 = p_72438_1_.field_72450_a - this.field_72450_a;
      double var4 = p_72438_1_.field_72448_b - this.field_72448_b;
      double var6 = p_72438_1_.field_72449_c - this.field_72449_c;
      return (double)MathHelper.func_76133_a(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public double func_72436_e(Vec3 p_72436_1_) {
      double var2 = p_72436_1_.field_72450_a - this.field_72450_a;
      double var4 = p_72436_1_.field_72448_b - this.field_72448_b;
      double var6 = p_72436_1_.field_72449_c - this.field_72449_c;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public double func_72445_d(double p_72445_1_, double p_72445_3_, double p_72445_5_) {
      double var7 = p_72445_1_ - this.field_72450_a;
      double var9 = p_72445_3_ - this.field_72448_b;
      double var11 = p_72445_5_ - this.field_72449_c;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_72433_c() {
      return (double)MathHelper.func_76133_a(this.field_72450_a * this.field_72450_a + this.field_72448_b * this.field_72448_b + this.field_72449_c * this.field_72449_c);
   }

   public Vec3 func_72429_b(Vec3 p_72429_1_, double p_72429_2_) {
      double var4 = p_72429_1_.field_72450_a - this.field_72450_a;
      double var6 = p_72429_1_.field_72448_b - this.field_72448_b;
      double var8 = p_72429_1_.field_72449_c - this.field_72449_c;
      if(var4 * var4 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_72429_2_ - this.field_72450_a) / var4;
         return var10 >= 0.0D && var10 <= 1.0D?this.field_72447_d.func_72345_a(this.field_72450_a + var4 * var10, this.field_72448_b + var6 * var10, this.field_72449_c + var8 * var10):null;
      }
   }

   public Vec3 func_72435_c(Vec3 p_72435_1_, double p_72435_2_) {
      double var4 = p_72435_1_.field_72450_a - this.field_72450_a;
      double var6 = p_72435_1_.field_72448_b - this.field_72448_b;
      double var8 = p_72435_1_.field_72449_c - this.field_72449_c;
      if(var6 * var6 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_72435_2_ - this.field_72448_b) / var6;
         return var10 >= 0.0D && var10 <= 1.0D?this.field_72447_d.func_72345_a(this.field_72450_a + var4 * var10, this.field_72448_b + var6 * var10, this.field_72449_c + var8 * var10):null;
      }
   }

   public Vec3 func_72434_d(Vec3 p_72434_1_, double p_72434_2_) {
      double var4 = p_72434_1_.field_72450_a - this.field_72450_a;
      double var6 = p_72434_1_.field_72448_b - this.field_72448_b;
      double var8 = p_72434_1_.field_72449_c - this.field_72449_c;
      if(var8 * var8 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_72434_2_ - this.field_72449_c) / var8;
         return var10 >= 0.0D && var10 <= 1.0D?this.field_72447_d.func_72345_a(this.field_72450_a + var4 * var10, this.field_72448_b + var6 * var10, this.field_72449_c + var8 * var10):null;
      }
   }

   public String toString() {
      return "(" + this.field_72450_a + ", " + this.field_72448_b + ", " + this.field_72449_c + ")";
   }

   public void func_72440_a(float p_72440_1_) {
      float var2 = MathHelper.func_76134_b(p_72440_1_);
      float var3 = MathHelper.func_76126_a(p_72440_1_);
      double var4 = this.field_72450_a;
      double var6 = this.field_72448_b * (double)var2 + this.field_72449_c * (double)var3;
      double var8 = this.field_72449_c * (double)var2 - this.field_72448_b * (double)var3;
      this.field_72450_a = var4;
      this.field_72448_b = var6;
      this.field_72449_c = var8;
   }

   public void func_72442_b(float p_72442_1_) {
      float var2 = MathHelper.func_76134_b(p_72442_1_);
      float var3 = MathHelper.func_76126_a(p_72442_1_);
      double var4 = this.field_72450_a * (double)var2 + this.field_72449_c * (double)var3;
      double var6 = this.field_72448_b;
      double var8 = this.field_72449_c * (double)var2 - this.field_72450_a * (double)var3;
      this.field_72450_a = var4;
      this.field_72448_b = var6;
      this.field_72449_c = var8;
   }

   @SideOnly(Side.CLIENT)
   public void func_72446_c(float p_72446_1_) {
      float var2 = MathHelper.func_76134_b(p_72446_1_);
      float var3 = MathHelper.func_76126_a(p_72446_1_);
      double var4 = this.field_72450_a * (double)var2 + this.field_72448_b * (double)var3;
      double var6 = this.field_72448_b * (double)var2 - this.field_72450_a * (double)var3;
      double var8 = this.field_72449_c;
      this.field_72450_a = var4;
      this.field_72448_b = var6;
      this.field_72449_c = var8;
   }

}
