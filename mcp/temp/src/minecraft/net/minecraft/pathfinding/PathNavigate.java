package net.minecraft.pathfinding;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class PathNavigate {

   private EntityLiving field_75515_a;
   private World field_75513_b;
   private PathEntity field_75514_c;
   private float field_75511_d;
   private float field_75512_e;
   private boolean field_75509_f = false;
   private int field_75510_g;
   private int field_75520_h;
   private Vec3 field_75521_i = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
   private boolean field_75518_j = true;
   private boolean field_75519_k = false;
   private boolean field_75516_l = false;
   private boolean field_75517_m = false;


   public PathNavigate(EntityLiving p_i3507_1_, World p_i3507_2_, float p_i3507_3_) {
      this.field_75515_a = p_i3507_1_;
      this.field_75513_b = p_i3507_2_;
      this.field_75512_e = p_i3507_3_;
   }

   public void func_75491_a(boolean p_75491_1_) {
      this.field_75516_l = p_75491_1_;
   }

   public boolean func_75486_a() {
      return this.field_75516_l;
   }

   public void func_75498_b(boolean p_75498_1_) {
      this.field_75519_k = p_75498_1_;
   }

   public void func_75490_c(boolean p_75490_1_) {
      this.field_75518_j = p_75490_1_;
   }

   public boolean func_75507_c() {
      return this.field_75519_k;
   }

   public void func_75504_d(boolean p_75504_1_) {
      this.field_75509_f = p_75504_1_;
   }

   public void func_75489_a(float p_75489_1_) {
      this.field_75511_d = p_75489_1_;
   }

   public void func_75495_e(boolean p_75495_1_) {
      this.field_75517_m = p_75495_1_;
   }

   public PathEntity func_75488_a(double p_75488_1_, double p_75488_3_, double p_75488_5_) {
      return !this.func_75485_k()?null:this.field_75513_b.func_72844_a(this.field_75515_a, MathHelper.func_76128_c(p_75488_1_), (int)p_75488_3_, MathHelper.func_76128_c(p_75488_5_), this.field_75512_e, this.field_75518_j, this.field_75519_k, this.field_75516_l, this.field_75517_m);
   }

   public boolean func_75492_a(double p_75492_1_, double p_75492_3_, double p_75492_5_, float p_75492_7_) {
      PathEntity var8 = this.func_75488_a((double)MathHelper.func_76128_c(p_75492_1_), (double)((int)p_75492_3_), (double)MathHelper.func_76128_c(p_75492_5_));
      return this.func_75484_a(var8, p_75492_7_);
   }

   public PathEntity func_75494_a(EntityLiving p_75494_1_) {
      return !this.func_75485_k()?null:this.field_75513_b.func_72865_a(this.field_75515_a, p_75494_1_, this.field_75512_e, this.field_75518_j, this.field_75519_k, this.field_75516_l, this.field_75517_m);
   }

   public boolean func_75497_a(EntityLiving p_75497_1_, float p_75497_2_) {
      PathEntity var3 = this.func_75494_a(p_75497_1_);
      return var3 != null?this.func_75484_a(var3, p_75497_2_):false;
   }

   public boolean func_75484_a(PathEntity p_75484_1_, float p_75484_2_) {
      if(p_75484_1_ == null) {
         this.field_75514_c = null;
         return false;
      } else {
         if(!p_75484_1_.func_75876_a(this.field_75514_c)) {
            this.field_75514_c = p_75484_1_;
         }

         if(this.field_75509_f) {
            this.func_75487_m();
         }

         if(this.field_75514_c.func_75874_d() == 0) {
            return false;
         } else {
            this.field_75511_d = p_75484_2_;
            Vec3 var3 = this.func_75502_i();
            this.field_75520_h = this.field_75510_g;
            this.field_75521_i.field_72450_a = var3.field_72450_a;
            this.field_75521_i.field_72448_b = var3.field_72448_b;
            this.field_75521_i.field_72449_c = var3.field_72449_c;
            return true;
         }
      }
   }

   public PathEntity func_75505_d() {
      return this.field_75514_c;
   }

   public void func_75501_e() {
      ++this.field_75510_g;
      if(!this.func_75500_f()) {
         if(this.func_75485_k()) {
            this.func_75508_h();
         }

         if(!this.func_75500_f()) {
            Vec3 var1 = this.field_75514_c.func_75878_a(this.field_75515_a);
            if(var1 != null) {
               this.field_75515_a.func_70605_aq().func_75642_a(var1.field_72450_a, var1.field_72448_b, var1.field_72449_c, this.field_75511_d);
            }
         }
      }
   }

   private void func_75508_h() {
      Vec3 var1 = this.func_75502_i();
      int var2 = this.field_75514_c.func_75874_d();

      for(int var3 = this.field_75514_c.func_75873_e(); var3 < this.field_75514_c.func_75874_d(); ++var3) {
         if(this.field_75514_c.func_75877_a(var3).field_75837_b != (int)var1.field_72448_b) {
            var2 = var3;
            break;
         }
      }

      float var8 = this.field_75515_a.field_70130_N * this.field_75515_a.field_70130_N;

      int var4;
      for(var4 = this.field_75514_c.func_75873_e(); var4 < var2; ++var4) {
         if(var1.func_72436_e(this.field_75514_c.func_75881_a(this.field_75515_a, var4)) < (double)var8) {
            this.field_75514_c.func_75872_c(var4 + 1);
         }
      }

      var4 = MathHelper.func_76123_f(this.field_75515_a.field_70130_N);
      int var5 = (int)this.field_75515_a.field_70131_O + 1;
      int var6 = var4;

      for(int var7 = var2 - 1; var7 >= this.field_75514_c.func_75873_e(); --var7) {
         if(this.func_75493_a(var1, this.field_75514_c.func_75881_a(this.field_75515_a, var7), var4, var5, var6)) {
            this.field_75514_c.func_75872_c(var7);
            break;
         }
      }

      if(this.field_75510_g - this.field_75520_h > 100) {
         if(var1.func_72436_e(this.field_75521_i) < 2.25D) {
            this.func_75499_g();
         }

         this.field_75520_h = this.field_75510_g;
         this.field_75521_i.field_72450_a = var1.field_72450_a;
         this.field_75521_i.field_72448_b = var1.field_72448_b;
         this.field_75521_i.field_72449_c = var1.field_72449_c;
      }

   }

   public boolean func_75500_f() {
      return this.field_75514_c == null || this.field_75514_c.func_75879_b();
   }

   public void func_75499_g() {
      this.field_75514_c = null;
   }

   private Vec3 func_75502_i() {
      return this.field_75513_b.func_82732_R().func_72345_a(this.field_75515_a.field_70165_t, (double)this.func_75503_j(), this.field_75515_a.field_70161_v);
   }

   private int func_75503_j() {
      if(this.field_75515_a.func_70090_H() && this.field_75517_m) {
         int var1 = (int)this.field_75515_a.field_70121_D.field_72338_b;
         int var2 = this.field_75513_b.func_72798_a(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), var1, MathHelper.func_76128_c(this.field_75515_a.field_70161_v));
         int var3 = 0;

         do {
            if(var2 != Block.field_71942_A.field_71990_ca && var2 != Block.field_71943_B.field_71990_ca) {
               return var1;
            }

            ++var1;
            var2 = this.field_75513_b.func_72798_a(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), var1, MathHelper.func_76128_c(this.field_75515_a.field_70161_v));
            ++var3;
         } while(var3 <= 16);

         return (int)this.field_75515_a.field_70121_D.field_72338_b;
      } else {
         return (int)(this.field_75515_a.field_70121_D.field_72338_b + 0.5D);
      }
   }

   private boolean func_75485_k() {
      return this.field_75515_a.field_70122_E || this.field_75517_m && this.func_75506_l();
   }

   private boolean func_75506_l() {
      return this.field_75515_a.func_70090_H() || this.field_75515_a.func_70058_J();
   }

   private void func_75487_m() {
      if(!this.field_75513_b.func_72937_j(MathHelper.func_76128_c(this.field_75515_a.field_70165_t), (int)(this.field_75515_a.field_70121_D.field_72338_b + 0.5D), MathHelper.func_76128_c(this.field_75515_a.field_70161_v))) {
         for(int var1 = 0; var1 < this.field_75514_c.func_75874_d(); ++var1) {
            PathPoint var2 = this.field_75514_c.func_75877_a(var1);
            if(this.field_75513_b.func_72937_j(var2.field_75839_a, var2.field_75837_b, var2.field_75838_c)) {
               this.field_75514_c.func_75871_b(var1 - 1);
               return;
            }
         }

      }
   }

   private boolean func_75493_a(Vec3 p_75493_1_, Vec3 p_75493_2_, int p_75493_3_, int p_75493_4_, int p_75493_5_) {
      int var6 = MathHelper.func_76128_c(p_75493_1_.field_72450_a);
      int var7 = MathHelper.func_76128_c(p_75493_1_.field_72449_c);
      double var8 = p_75493_2_.field_72450_a - p_75493_1_.field_72450_a;
      double var10 = p_75493_2_.field_72449_c - p_75493_1_.field_72449_c;
      double var12 = var8 * var8 + var10 * var10;
      if(var12 < 1.0E-8D) {
         return false;
      } else {
         double var14 = 1.0D / Math.sqrt(var12);
         var8 *= var14;
         var10 *= var14;
         p_75493_3_ += 2;
         p_75493_5_ += 2;
         if(!this.func_75483_a(var6, (int)p_75493_1_.field_72448_b, var7, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, var8, var10)) {
            return false;
         } else {
            p_75493_3_ -= 2;
            p_75493_5_ -= 2;
            double var16 = 1.0D / Math.abs(var8);
            double var18 = 1.0D / Math.abs(var10);
            double var20 = (double)(var6 * 1) - p_75493_1_.field_72450_a;
            double var22 = (double)(var7 * 1) - p_75493_1_.field_72449_c;
            if(var8 >= 0.0D) {
               ++var20;
            }

            if(var10 >= 0.0D) {
               ++var22;
            }

            var20 /= var8;
            var22 /= var10;
            int var24 = var8 < 0.0D?-1:1;
            int var25 = var10 < 0.0D?-1:1;
            int var26 = MathHelper.func_76128_c(p_75493_2_.field_72450_a);
            int var27 = MathHelper.func_76128_c(p_75493_2_.field_72449_c);
            int var28 = var26 - var6;
            int var29 = var27 - var7;

            do {
               if(var28 * var24 <= 0 && var29 * var25 <= 0) {
                  return true;
               }

               if(var20 < var22) {
                  var20 += var16;
                  var6 += var24;
                  var28 = var26 - var6;
               } else {
                  var22 += var18;
                  var7 += var25;
                  var29 = var27 - var7;
               }
            } while(this.func_75483_a(var6, (int)p_75493_1_.field_72448_b, var7, p_75493_3_, p_75493_4_, p_75493_5_, p_75493_1_, var8, var10));

            return false;
         }
      }
   }

   private boolean func_75483_a(int p_75483_1_, int p_75483_2_, int p_75483_3_, int p_75483_4_, int p_75483_5_, int p_75483_6_, Vec3 p_75483_7_, double p_75483_8_, double p_75483_10_) {
      int var12 = p_75483_1_ - p_75483_4_ / 2;
      int var13 = p_75483_3_ - p_75483_6_ / 2;
      if(!this.func_75496_b(var12, p_75483_2_, var13, p_75483_4_, p_75483_5_, p_75483_6_, p_75483_7_, p_75483_8_, p_75483_10_)) {
         return false;
      } else {
         for(int var14 = var12; var14 < var12 + p_75483_4_; ++var14) {
            for(int var15 = var13; var15 < var13 + p_75483_6_; ++var15) {
               double var16 = (double)var14 + 0.5D - p_75483_7_.field_72450_a;
               double var18 = (double)var15 + 0.5D - p_75483_7_.field_72449_c;
               if(var16 * p_75483_8_ + var18 * p_75483_10_ >= 0.0D) {
                  int var20 = this.field_75513_b.func_72798_a(var14, p_75483_2_ - 1, var15);
                  if(var20 <= 0) {
                     return false;
                  }

                  Material var21 = Block.field_71973_m[var20].field_72018_cp;
                  if(var21 == Material.field_76244_g && !this.field_75515_a.func_70090_H()) {
                     return false;
                  }

                  if(var21 == Material.field_76256_h) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean func_75496_b(int p_75496_1_, int p_75496_2_, int p_75496_3_, int p_75496_4_, int p_75496_5_, int p_75496_6_, Vec3 p_75496_7_, double p_75496_8_, double p_75496_10_) {
      for(int var12 = p_75496_1_; var12 < p_75496_1_ + p_75496_4_; ++var12) {
         for(int var13 = p_75496_2_; var13 < p_75496_2_ + p_75496_5_; ++var13) {
            for(int var14 = p_75496_3_; var14 < p_75496_3_ + p_75496_6_; ++var14) {
               double var15 = (double)var12 + 0.5D - p_75496_7_.field_72450_a;
               double var17 = (double)var14 + 0.5D - p_75496_7_.field_72449_c;
               if(var15 * p_75496_8_ + var17 * p_75496_10_ >= 0.0D) {
                  int var19 = this.field_75513_b.func_72798_a(var12, var13, var14);
                  if(var19 > 0 && !Block.field_71973_m[var19].func_71918_c(this.field_75513_b, var12, var13, var14)) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }
}
