package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBigTree extends WorldGenerator {

   static final byte[] field_76507_a = new byte[]{(byte)2, (byte)0, (byte)0, (byte)1, (byte)2, (byte)1};
   Random field_76505_b = new Random();
   World field_76506_c;
   int[] field_76503_d = new int[]{0, 0, 0};
   int field_76504_e = 0;
   int field_76501_f;
   double field_76502_g = 0.618D;
   double field_76514_h = 1.0D;
   double field_76515_i = 0.381D;
   double field_76512_j = 1.0D;
   double field_76513_k = 1.0D;
   int field_76510_l = 1;
   int field_76511_m = 12;
   int field_76508_n = 4;
   int[][] field_76509_o;


   public WorldGenBigTree(boolean p_i3784_1_) {
      super(p_i3784_1_);
   }

   void func_76489_a() {
      this.field_76501_f = (int)((double)this.field_76504_e * this.field_76502_g);
      if(this.field_76501_f >= this.field_76504_e) {
         this.field_76501_f = this.field_76504_e - 1;
      }

      int var1 = (int)(1.382D + Math.pow(this.field_76513_k * (double)this.field_76504_e / 13.0D, 2.0D));
      if(var1 < 1) {
         var1 = 1;
      }

      int[][] var2 = new int[var1 * this.field_76504_e][4];
      int var3 = this.field_76503_d[1] + this.field_76504_e - this.field_76508_n;
      int var4 = 1;
      int var5 = this.field_76503_d[1] + this.field_76501_f;
      int var6 = var3 - this.field_76503_d[1];
      var2[0][0] = this.field_76503_d[0];
      var2[0][1] = var3;
      var2[0][2] = this.field_76503_d[2];
      var2[0][3] = var5;
      --var3;

      while(var6 >= 0) {
         int var7 = 0;
         float var8 = this.func_76490_a(var6);
         if(var8 < 0.0F) {
            --var3;
            --var6;
         } else {
            for(double var9 = 0.5D; var7 < var1; ++var7) {
               double var11 = this.field_76512_j * (double)var8 * ((double)this.field_76505_b.nextFloat() + 0.328D);
               double var13 = (double)this.field_76505_b.nextFloat() * 2.0D * 3.14159D;
               int var15 = MathHelper.func_76128_c(var11 * Math.sin(var13) + (double)this.field_76503_d[0] + var9);
               int var16 = MathHelper.func_76128_c(var11 * Math.cos(var13) + (double)this.field_76503_d[2] + var9);
               int[] var17 = new int[]{var15, var3, var16};
               int[] var18 = new int[]{var15, var3 + this.field_76508_n, var16};
               if(this.func_76496_a(var17, var18) == -1) {
                  int[] var19 = new int[]{this.field_76503_d[0], this.field_76503_d[1], this.field_76503_d[2]};
                  double var20 = Math.sqrt(Math.pow((double)Math.abs(this.field_76503_d[0] - var17[0]), 2.0D) + Math.pow((double)Math.abs(this.field_76503_d[2] - var17[2]), 2.0D));
                  double var22 = var20 * this.field_76515_i;
                  if((double)var17[1] - var22 > (double)var5) {
                     var19[1] = var5;
                  } else {
                     var19[1] = (int)((double)var17[1] - var22);
                  }

                  if(this.func_76496_a(var19, var17) == -1) {
                     var2[var4][0] = var15;
                     var2[var4][1] = var3;
                     var2[var4][2] = var16;
                     var2[var4][3] = var19[1];
                     ++var4;
                  }
               }
            }

            --var3;
            --var6;
         }
      }

      this.field_76509_o = new int[var4][4];
      System.arraycopy(var2, 0, this.field_76509_o, 0, var4);
   }

   void func_76492_a(int p_76492_1_, int p_76492_2_, int p_76492_3_, float p_76492_4_, byte p_76492_5_, int p_76492_6_) {
      int var7 = (int)((double)p_76492_4_ + 0.618D);
      byte var8 = field_76507_a[p_76492_5_];
      byte var9 = field_76507_a[p_76492_5_ + 3];
      int[] var10 = new int[]{p_76492_1_, p_76492_2_, p_76492_3_};
      int[] var11 = new int[]{0, 0, 0};
      int var12 = -var7;
      int var13 = -var7;

      for(var11[p_76492_5_] = var10[p_76492_5_]; var12 <= var7; ++var12) {
         var11[var8] = var10[var8] + var12;
         var13 = -var7;

         while(var13 <= var7) {
            double var15 = Math.pow((double)Math.abs(var12) + 0.5D, 2.0D) + Math.pow((double)Math.abs(var13) + 0.5D, 2.0D);
            if(var15 > (double)(p_76492_4_ * p_76492_4_)) {
               ++var13;
            } else {
               var11[var9] = var10[var9] + var13;
               int var14 = this.field_76506_c.func_72798_a(var11[0], var11[1], var11[2]);
               if(var14 != 0 && var14 != Block.field_71952_K.field_71990_ca) {
                  ++var13;
               } else {
                  this.func_76485_a(this.field_76506_c, var11[0], var11[1], var11[2], p_76492_6_, 0);
                  ++var13;
               }
            }
         }
      }

   }

   float func_76490_a(int p_76490_1_) {
      if((double)p_76490_1_ < (double)((float)this.field_76504_e) * 0.3D) {
         return -1.618F;
      } else {
         float var2 = (float)this.field_76504_e / 2.0F;
         float var3 = (float)this.field_76504_e / 2.0F - (float)p_76490_1_;
         float var4;
         if(var3 == 0.0F) {
            var4 = var2;
         } else if(Math.abs(var3) >= var2) {
            var4 = 0.0F;
         } else {
            var4 = (float)Math.sqrt(Math.pow((double)Math.abs(var2), 2.0D) - Math.pow((double)Math.abs(var3), 2.0D));
         }

         var4 *= 0.5F;
         return var4;
      }
   }

   float func_76495_b(int p_76495_1_) {
      return p_76495_1_ >= 0 && p_76495_1_ < this.field_76508_n?(p_76495_1_ != 0 && p_76495_1_ != this.field_76508_n - 1?3.0F:2.0F):-1.0F;
   }

   void func_76491_a(int p_76491_1_, int p_76491_2_, int p_76491_3_) {
      int var4 = p_76491_2_;

      for(int var5 = p_76491_2_ + this.field_76508_n; var4 < var5; ++var4) {
         float var6 = this.func_76495_b(var4 - p_76491_2_);
         this.func_76492_a(p_76491_1_, var4, p_76491_3_, var6, (byte)1, Block.field_71952_K.field_71990_ca);
      }

   }

   void func_76500_a(int[] p_76500_1_, int[] p_76500_2_, int p_76500_3_) {
      int[] var4 = new int[]{0, 0, 0};
      byte var5 = 0;

      byte var6;
      for(var6 = 0; var5 < 3; ++var5) {
         var4[var5] = p_76500_2_[var5] - p_76500_1_[var5];
         if(Math.abs(var4[var5]) > Math.abs(var4[var6])) {
            var6 = var5;
         }
      }

      if(var4[var6] != 0) {
         byte var7 = field_76507_a[var6];
         byte var8 = field_76507_a[var6 + 3];
         byte var9;
         if(var4[var6] > 0) {
            var9 = 1;
         } else {
            var9 = -1;
         }

         double var10 = (double)var4[var7] / (double)var4[var6];
         double var12 = (double)var4[var8] / (double)var4[var6];
         int[] var14 = new int[]{0, 0, 0};
         int var15 = 0;

         for(int var16 = var4[var6] + var9; var15 != var16; var15 += var9) {
            var14[var6] = MathHelper.func_76128_c((double)(p_76500_1_[var6] + var15) + 0.5D);
            var14[var7] = MathHelper.func_76128_c((double)p_76500_1_[var7] + (double)var15 * var10 + 0.5D);
            var14[var8] = MathHelper.func_76128_c((double)p_76500_1_[var8] + (double)var15 * var12 + 0.5D);
            byte var17 = 0;
            int var18 = Math.abs(var14[0] - p_76500_1_[0]);
            int var19 = Math.abs(var14[2] - p_76500_1_[2]);
            int var20 = Math.max(var18, var19);
            if(var20 > 0) {
               if(var18 == var20) {
                  var17 = 4;
               } else if(var19 == var20) {
                  var17 = 8;
               }
            }

            this.func_76485_a(this.field_76506_c, var14[0], var14[1], var14[2], p_76500_3_, var17);
         }

      }
   }

   void func_76498_b() {
      int var1 = 0;

      for(int var2 = this.field_76509_o.length; var1 < var2; ++var1) {
         int var3 = this.field_76509_o[var1][0];
         int var4 = this.field_76509_o[var1][1];
         int var5 = this.field_76509_o[var1][2];
         this.func_76491_a(var3, var4, var5);
      }

   }

   boolean func_76493_c(int p_76493_1_) {
      return (double)p_76493_1_ >= (double)this.field_76504_e * 0.2D;
   }

   void func_76499_c() {
      int var1 = this.field_76503_d[0];
      int var2 = this.field_76503_d[1];
      int var3 = this.field_76503_d[1] + this.field_76501_f;
      int var4 = this.field_76503_d[2];
      int[] var5 = new int[]{var1, var2, var4};
      int[] var6 = new int[]{var1, var3, var4};
      this.func_76500_a(var5, var6, Block.field_71951_J.field_71990_ca);
      if(this.field_76510_l == 2) {
         ++var5[0];
         ++var6[0];
         this.func_76500_a(var5, var6, Block.field_71951_J.field_71990_ca);
         ++var5[2];
         ++var6[2];
         this.func_76500_a(var5, var6, Block.field_71951_J.field_71990_ca);
         var5[0] += -1;
         var6[0] += -1;
         this.func_76500_a(var5, var6, Block.field_71951_J.field_71990_ca);
      }

   }

   void func_76494_d() {
      int var1 = 0;
      int var2 = this.field_76509_o.length;

      for(int[] var3 = new int[]{this.field_76503_d[0], this.field_76503_d[1], this.field_76503_d[2]}; var1 < var2; ++var1) {
         int[] var4 = this.field_76509_o[var1];
         int[] var5 = new int[]{var4[0], var4[1], var4[2]};
         var3[1] = var4[3];
         int var6 = var3[1] - this.field_76503_d[1];
         if(this.func_76493_c(var6)) {
            this.func_76500_a(var3, var5, (byte)Block.field_71951_J.field_71990_ca);
         }
      }

   }

   int func_76496_a(int[] p_76496_1_, int[] p_76496_2_) {
      int[] var3 = new int[]{0, 0, 0};
      byte var4 = 0;

      byte var5;
      for(var5 = 0; var4 < 3; ++var4) {
         var3[var4] = p_76496_2_[var4] - p_76496_1_[var4];
         if(Math.abs(var3[var4]) > Math.abs(var3[var5])) {
            var5 = var4;
         }
      }

      if(var3[var5] == 0) {
         return -1;
      } else {
         byte var6 = field_76507_a[var5];
         byte var7 = field_76507_a[var5 + 3];
         byte var8;
         if(var3[var5] > 0) {
            var8 = 1;
         } else {
            var8 = -1;
         }

         double var9 = (double)var3[var6] / (double)var3[var5];
         double var11 = (double)var3[var7] / (double)var3[var5];
         int[] var13 = new int[]{0, 0, 0};
         int var14 = 0;

         int var15;
         for(var15 = var3[var5] + var8; var14 != var15; var14 += var8) {
            var13[var5] = p_76496_1_[var5] + var14;
            var13[var6] = MathHelper.func_76128_c((double)p_76496_1_[var6] + (double)var14 * var9);
            var13[var7] = MathHelper.func_76128_c((double)p_76496_1_[var7] + (double)var14 * var11);
            int var16 = this.field_76506_c.func_72798_a(var13[0], var13[1], var13[2]);
            if(var16 != 0 && var16 != Block.field_71952_K.field_71990_ca) {
               break;
            }
         }

         return var14 == var15?-1:Math.abs(var14);
      }
   }

   boolean func_76497_e() {
      int[] var1 = new int[]{this.field_76503_d[0], this.field_76503_d[1], this.field_76503_d[2]};
      int[] var2 = new int[]{this.field_76503_d[0], this.field_76503_d[1] + this.field_76504_e - 1, this.field_76503_d[2]};
      int var3 = this.field_76506_c.func_72798_a(this.field_76503_d[0], this.field_76503_d[1] - 1, this.field_76503_d[2]);
      if(var3 != 2 && var3 != 3) {
         return false;
      } else {
         int var4 = this.func_76496_a(var1, var2);
         if(var4 == -1) {
            return true;
         } else if(var4 < 6) {
            return false;
         } else {
            this.field_76504_e = var4;
            return true;
         }
      }
   }

   public void func_76487_a(double p_76487_1_, double p_76487_3_, double p_76487_5_) {
      this.field_76511_m = (int)(p_76487_1_ * 12.0D);
      if(p_76487_1_ > 0.5D) {
         this.field_76508_n = 5;
      }

      this.field_76512_j = p_76487_3_;
      this.field_76513_k = p_76487_5_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      this.field_76506_c = p_76484_1_;
      long var6 = p_76484_2_.nextLong();
      this.field_76505_b.setSeed(var6);
      this.field_76503_d[0] = p_76484_3_;
      this.field_76503_d[1] = p_76484_4_;
      this.field_76503_d[2] = p_76484_5_;
      if(this.field_76504_e == 0) {
         this.field_76504_e = 5 + this.field_76505_b.nextInt(this.field_76511_m);
      }

      if(!this.func_76497_e()) {
         return false;
      } else {
         this.func_76489_a();
         this.func_76498_b();
         this.func_76499_c();
         this.func_76494_d();
         return true;
      }
   }

}
