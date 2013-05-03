package net.minecraft.entity.boss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityDragon extends EntityLiving implements IBossDisplayData, IEntityMultiPart {

   public double field_70980_b;
   public double field_70981_c;
   public double field_70978_d;
   public double[][] field_70979_e = new double[64][3];
   public int field_70976_f = -1;
   public EntityDragonPart[] field_70977_g;
   public EntityDragonPart field_70986_h;
   public EntityDragonPart field_70987_i;
   public EntityDragonPart field_70985_j;
   public EntityDragonPart field_70984_by;
   public EntityDragonPart field_70982_bz;
   public EntityDragonPart field_70983_bA;
   public EntityDragonPart field_70990_bB;
   public float field_70991_bC = 0.0F;
   public float field_70988_bD = 0.0F;
   public boolean field_70989_bE = false;
   public boolean field_70994_bF = false;
   private Entity field_70993_bI;
   public int field_70995_bG = 0;
   public EntityEnderCrystal field_70992_bH = null;


   public EntityDragon(World p_i3531_1_) {
      super(p_i3531_1_);
      this.field_70977_g = new EntityDragonPart[]{this.field_70986_h = new EntityDragonPart(this, "head", 6.0F, 6.0F), this.field_70987_i = new EntityDragonPart(this, "body", 8.0F, 8.0F), this.field_70985_j = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_70984_by = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_70982_bz = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_70983_bA = new EntityDragonPart(this, "wing", 4.0F, 4.0F), this.field_70990_bB = new EntityDragonPart(this, "wing", 4.0F, 4.0F)};
      this.func_70606_j(this.func_70667_aM());
      this.field_70750_az = "/mob/enderdragon/ender.png";
      this.func_70105_a(16.0F, 8.0F);
      this.field_70145_X = true;
      this.field_70178_ae = true;
      this.field_70981_c = 100.0D;
      this.field_70158_ak = true;
   }

   public int func_70667_aM() {
      return 200;
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(16, new Integer(this.func_70667_aM()));
   }

   public double[] func_70974_a(int p_70974_1_, float p_70974_2_) {
      if(this.field_70734_aK <= 0) {
         p_70974_2_ = 0.0F;
      }

      p_70974_2_ = 1.0F - p_70974_2_;
      int var3 = this.field_70976_f - p_70974_1_ * 1 & 63;
      int var4 = this.field_70976_f - p_70974_1_ * 1 - 1 & 63;
      double[] var5 = new double[3];
      double var6 = this.field_70979_e[var3][0];
      double var8 = MathHelper.func_76138_g(this.field_70979_e[var4][0] - var6);
      var5[0] = var6 + var8 * (double)p_70974_2_;
      var6 = this.field_70979_e[var3][1];
      var8 = this.field_70979_e[var4][1] - var6;
      var5[1] = var6 + var8 * (double)p_70974_2_;
      var5[2] = this.field_70979_e[var3][2] + (this.field_70979_e[var4][2] - this.field_70979_e[var3][2]) * (double)p_70974_2_;
      return var5;
   }

   public void func_70636_d() {
      float var1;
      float var2;
      if(!this.field_70170_p.field_72995_K) {
         this.field_70180_af.func_75692_b(16, Integer.valueOf(this.field_70734_aK));
      } else {
         var1 = MathHelper.func_76134_b(this.field_70988_bD * 3.1415927F * 2.0F);
         var2 = MathHelper.func_76134_b(this.field_70991_bC * 3.1415927F * 2.0F);
         if(var2 <= -0.3F && var1 >= -0.3F) {
            this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, "mob.enderdragon.wings", 5.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.3F, false);
         }
      }

      this.field_70991_bC = this.field_70988_bD;
      float var3;
      if(this.field_70734_aK <= 0) {
         var1 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
         var2 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
         var3 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
         this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + (double)var1, this.field_70163_u + 2.0D + (double)var2, this.field_70161_v + (double)var3, 0.0D, 0.0D, 0.0D);
      } else {
         this.func_70969_j();
         var1 = 0.2F / (MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 10.0F + 1.0F);
         var1 *= (float)Math.pow(2.0D, this.field_70181_x);
         if(this.field_70994_bF) {
            this.field_70988_bD += var1 * 0.5F;
         } else {
            this.field_70988_bD += var1;
         }

         this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
         if(this.field_70976_f < 0) {
            for(int var25 = 0; var25 < this.field_70979_e.length; ++var25) {
               this.field_70979_e[var25][0] = (double)this.field_70177_z;
               this.field_70979_e[var25][1] = this.field_70163_u;
            }
         }

         if(++this.field_70976_f == this.field_70979_e.length) {
            this.field_70976_f = 0;
         }

         this.field_70979_e[this.field_70976_f][0] = (double)this.field_70177_z;
         this.field_70979_e[this.field_70976_f][1] = this.field_70163_u;
         double var4;
         double var6;
         double var8;
         double var26;
         float var33;
         if(this.field_70170_p.field_72995_K) {
            if(this.field_70716_bi > 0) {
               var26 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / (double)this.field_70716_bi;
               var4 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / (double)this.field_70716_bi;
               var6 = this.field_70161_v + (this.field_70711_bl - this.field_70161_v) / (double)this.field_70716_bi;
               var8 = MathHelper.func_76138_g(this.field_70712_bm - (double)this.field_70177_z);
               this.field_70177_z = (float)((double)this.field_70177_z + var8 / (double)this.field_70716_bi);
               this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70705_bn - (double)this.field_70125_A) / (double)this.field_70716_bi);
               --this.field_70716_bi;
               this.func_70107_b(var26, var4, var6);
               this.func_70101_b(this.field_70177_z, this.field_70125_A);
            }
         } else {
            var26 = this.field_70980_b - this.field_70165_t;
            var4 = this.field_70981_c - this.field_70163_u;
            var6 = this.field_70978_d - this.field_70161_v;
            var8 = var26 * var26 + var4 * var4 + var6 * var6;
            if(this.field_70993_bI != null) {
               this.field_70980_b = this.field_70993_bI.field_70165_t;
               this.field_70978_d = this.field_70993_bI.field_70161_v;
               double var10 = this.field_70980_b - this.field_70165_t;
               double var12 = this.field_70978_d - this.field_70161_v;
               double var14 = Math.sqrt(var10 * var10 + var12 * var12);
               double var16 = 0.4000000059604645D + var14 / 80.0D - 1.0D;
               if(var16 > 10.0D) {
                  var16 = 10.0D;
               }

               this.field_70981_c = this.field_70993_bI.field_70121_D.field_72338_b + var16;
            } else {
               this.field_70980_b += this.field_70146_Z.nextGaussian() * 2.0D;
               this.field_70978_d += this.field_70146_Z.nextGaussian() * 2.0D;
            }

            if(this.field_70989_bE || var8 < 100.0D || var8 > 22500.0D || this.field_70123_F || this.field_70124_G) {
               this.func_70967_k();
            }

            var4 /= (double)MathHelper.func_76133_a(var26 * var26 + var6 * var6);
            var33 = 0.6F;
            if(var4 < (double)(-var33)) {
               var4 = (double)(-var33);
            }

            if(var4 > (double)var33) {
               var4 = (double)var33;
            }

            this.field_70181_x += var4 * 0.10000000149011612D;
            this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
            double var11 = 180.0D - Math.atan2(var26, var6) * 180.0D / 3.1415927410125732D;
            double var13 = MathHelper.func_76138_g(var11 - (double)this.field_70177_z);
            if(var13 > 50.0D) {
               var13 = 50.0D;
            }

            if(var13 < -50.0D) {
               var13 = -50.0D;
            }

            Vec3 var15 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70980_b - this.field_70165_t, this.field_70981_c - this.field_70163_u, this.field_70978_d - this.field_70161_v).func_72432_b();
            Vec3 var40 = this.field_70170_p.func_82732_R().func_72345_a((double)MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F), this.field_70181_x, (double)(-MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F))).func_72432_b();
            float var17 = (float)(var40.func_72430_b(var15) + 0.5D) / 1.5F;
            if(var17 < 0.0F) {
               var17 = 0.0F;
            }

            this.field_70704_bt *= 0.8F;
            float var18 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0F + 1.0F;
            double var19 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0D + 1.0D;
            if(var19 > 40.0D) {
               var19 = 40.0D;
            }

            this.field_70704_bt = (float)((double)this.field_70704_bt + var13 * (0.699999988079071D / var19 / (double)var18));
            this.field_70177_z += this.field_70704_bt * 0.1F;
            float var21 = (float)(2.0D / (var19 + 1.0D));
            float var22 = 0.06F;
            this.func_70060_a(0.0F, -1.0F, var22 * (var17 * var21 + (1.0F - var21)));
            if(this.field_70994_bF) {
               this.func_70091_d(this.field_70159_w * 0.800000011920929D, this.field_70181_x * 0.800000011920929D, this.field_70179_y * 0.800000011920929D);
            } else {
               this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }

            Vec3 var23 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72432_b();
            float var24 = (float)(var23.func_72430_b(var40) + 1.0D) / 2.0F;
            var24 = 0.8F + 0.15F * var24;
            this.field_70159_w *= (double)var24;
            this.field_70179_y *= (double)var24;
            this.field_70181_x *= 0.9100000262260437D;
         }

         this.field_70761_aq = this.field_70177_z;
         this.field_70986_h.field_70130_N = this.field_70986_h.field_70131_O = 3.0F;
         this.field_70985_j.field_70130_N = this.field_70985_j.field_70131_O = 2.0F;
         this.field_70984_by.field_70130_N = this.field_70984_by.field_70131_O = 2.0F;
         this.field_70982_bz.field_70130_N = this.field_70982_bz.field_70131_O = 2.0F;
         this.field_70987_i.field_70131_O = 3.0F;
         this.field_70987_i.field_70130_N = 5.0F;
         this.field_70983_bA.field_70131_O = 2.0F;
         this.field_70983_bA.field_70130_N = 4.0F;
         this.field_70990_bB.field_70131_O = 3.0F;
         this.field_70990_bB.field_70130_N = 4.0F;
         var2 = (float)(this.func_70974_a(5, 1.0F)[1] - this.func_70974_a(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
         var3 = MathHelper.func_76134_b(var2);
         float var28 = -MathHelper.func_76126_a(var2);
         float var5 = this.field_70177_z * 3.1415927F / 180.0F;
         float var27 = MathHelper.func_76126_a(var5);
         float var7 = MathHelper.func_76134_b(var5);
         this.field_70987_i.func_70071_h_();
         this.field_70987_i.func_70012_b(this.field_70165_t + (double)(var27 * 0.5F), this.field_70163_u, this.field_70161_v - (double)(var7 * 0.5F), 0.0F, 0.0F);
         this.field_70983_bA.func_70071_h_();
         this.field_70983_bA.func_70012_b(this.field_70165_t + (double)(var7 * 4.5F), this.field_70163_u + 2.0D, this.field_70161_v + (double)(var27 * 4.5F), 0.0F, 0.0F);
         this.field_70990_bB.func_70071_h_();
         this.field_70990_bB.func_70012_b(this.field_70165_t - (double)(var7 * 4.5F), this.field_70163_u + 2.0D, this.field_70161_v - (double)(var27 * 4.5F), 0.0F, 0.0F);
         if(!this.field_70170_p.field_72995_K && this.field_70737_aN == 0) {
            this.func_70970_a(this.field_70170_p.func_72839_b(this, this.field_70983_bA.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D).func_72317_d(0.0D, -2.0D, 0.0D)));
            this.func_70970_a(this.field_70170_p.func_72839_b(this, this.field_70990_bB.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D).func_72317_d(0.0D, -2.0D, 0.0D)));
            this.func_70971_b(this.field_70170_p.func_72839_b(this, this.field_70986_h.field_70121_D.func_72314_b(1.0D, 1.0D, 1.0D)));
         }

         double[] var29 = this.func_70974_a(5, 1.0F);
         double[] var9 = this.func_70974_a(0, 1.0F);
         var33 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F - this.field_70704_bt * 0.01F);
         float var32 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F - this.field_70704_bt * 0.01F);
         this.field_70986_h.func_70071_h_();
         this.field_70986_h.func_70012_b(this.field_70165_t + (double)(var33 * 5.5F * var3), this.field_70163_u + (var9[1] - var29[1]) * 1.0D + (double)(var28 * 5.5F), this.field_70161_v - (double)(var32 * 5.5F * var3), 0.0F, 0.0F);

         for(int var30 = 0; var30 < 3; ++var30) {
            EntityDragonPart var31 = null;
            if(var30 == 0) {
               var31 = this.field_70985_j;
            }

            if(var30 == 1) {
               var31 = this.field_70984_by;
            }

            if(var30 == 2) {
               var31 = this.field_70982_bz;
            }

            double[] var35 = this.func_70974_a(12 + var30 * 2, 1.0F);
            float var34 = this.field_70177_z * 3.1415927F / 180.0F + this.func_70973_b(var35[0] - var29[0]) * 3.1415927F / 180.0F * 1.0F;
            float var38 = MathHelper.func_76126_a(var34);
            float var37 = MathHelper.func_76134_b(var34);
            float var36 = 1.5F;
            float var39 = (float)(var30 + 1) * 2.0F;
            var31.func_70071_h_();
            var31.func_70012_b(this.field_70165_t - (double)((var27 * var36 + var38 * var39) * var3), this.field_70163_u + (var35[1] - var29[1]) * 1.0D - (double)((var39 + var36) * var28) + 1.5D, this.field_70161_v + (double)((var7 * var36 + var37 * var39) * var3), 0.0F, 0.0F);
         }

         if(!this.field_70170_p.field_72995_K) {
            this.field_70994_bF = this.func_70972_a(this.field_70986_h.field_70121_D) | this.func_70972_a(this.field_70987_i.field_70121_D);
         }

      }
   }

   private void func_70969_j() {
      if(this.field_70992_bH != null) {
         if(this.field_70992_bH.field_70128_L) {
            if(!this.field_70170_p.field_72995_K) {
               this.func_70965_a(this.field_70986_h, DamageSource.func_94539_a((Explosion)null), 10);
            }

            this.field_70992_bH = null;
         } else if(this.field_70173_aa % 10 == 0 && this.func_70630_aN() < this.func_70667_aM()) {
            this.func_70606_j(this.func_70630_aN() + 1);
         }
      }

      if(this.field_70146_Z.nextInt(10) == 0) {
         float var1 = 32.0F;
         List var2 = this.field_70170_p.func_72872_a(EntityEnderCrystal.class, this.field_70121_D.func_72314_b((double)var1, (double)var1, (double)var1));
         EntityEnderCrystal var3 = null;
         double var4 = Double.MAX_VALUE;
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            EntityEnderCrystal var7 = (EntityEnderCrystal)var6.next();
            double var8 = var7.func_70068_e(this);
            if(var8 < var4) {
               var4 = var8;
               var3 = var7;
            }
         }

         this.field_70992_bH = var3;
      }

   }

   private void func_70970_a(List p_70970_1_) {
      double var2 = (this.field_70987_i.field_70121_D.field_72340_a + this.field_70987_i.field_70121_D.field_72336_d) / 2.0D;
      double var4 = (this.field_70987_i.field_70121_D.field_72339_c + this.field_70987_i.field_70121_D.field_72334_f) / 2.0D;
      Iterator var6 = p_70970_1_.iterator();

      while(var6.hasNext()) {
         Entity var7 = (Entity)var6.next();
         if(var7 instanceof EntityLiving) {
            double var8 = var7.field_70165_t - var2;
            double var10 = var7.field_70161_v - var4;
            double var12 = var8 * var8 + var10 * var10;
            var7.func_70024_g(var8 / var12 * 4.0D, 0.20000000298023224D, var10 / var12 * 4.0D);
         }
      }

   }

   private void func_70971_b(List p_70971_1_) {
      for(int var2 = 0; var2 < p_70971_1_.size(); ++var2) {
         Entity var3 = (Entity)p_70971_1_.get(var2);
         if(var3 instanceof EntityLiving) {
            var3.func_70097_a(DamageSource.func_76358_a(this), 10);
         }
      }

   }

   private void func_70967_k() {
      this.field_70989_bE = false;
      if(this.field_70146_Z.nextInt(2) == 0 && !this.field_70170_p.field_73010_i.isEmpty()) {
         this.field_70993_bI = (Entity)this.field_70170_p.field_73010_i.get(this.field_70146_Z.nextInt(this.field_70170_p.field_73010_i.size()));
      } else {
         boolean var1 = false;

         do {
            this.field_70980_b = 0.0D;
            this.field_70981_c = (double)(70.0F + this.field_70146_Z.nextFloat() * 50.0F);
            this.field_70978_d = 0.0D;
            this.field_70980_b += (double)(this.field_70146_Z.nextFloat() * 120.0F - 60.0F);
            this.field_70978_d += (double)(this.field_70146_Z.nextFloat() * 120.0F - 60.0F);
            double var2 = this.field_70165_t - this.field_70980_b;
            double var4 = this.field_70163_u - this.field_70981_c;
            double var6 = this.field_70161_v - this.field_70978_d;
            var1 = var2 * var2 + var4 * var4 + var6 * var6 > 100.0D;
         } while(!var1);

         this.field_70993_bI = null;
      }

   }

   private float func_70973_b(double p_70973_1_) {
      return (float)MathHelper.func_76138_g(p_70973_1_);
   }

   private boolean func_70972_a(AxisAlignedBB p_70972_1_) {
      int var2 = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
      int var3 = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
      int var4 = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
      int var5 = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
      int var6 = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
      int var7 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var2; var10 <= var5; ++var10) {
         for(int var11 = var3; var11 <= var6; ++var11) {
            for(int var12 = var4; var12 <= var7; ++var12) {
               int var13 = this.field_70170_p.func_72798_a(var10, var11, var12);
               if(var13 != 0) {
                  if(var13 != Block.field_72089_ap.field_71990_ca && var13 != Block.field_72082_bJ.field_71990_ca && var13 != Block.field_71986_z.field_71990_ca && this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
                     var9 = this.field_70170_p.func_94571_i(var10, var11, var12) || var9;
                  } else {
                     var8 = true;
                  }
               }
            }
         }
      }

      if(var9) {
         double var16 = p_70972_1_.field_72340_a + (p_70972_1_.field_72336_d - p_70972_1_.field_72340_a) * (double)this.field_70146_Z.nextFloat();
         double var17 = p_70972_1_.field_72338_b + (p_70972_1_.field_72337_e - p_70972_1_.field_72338_b) * (double)this.field_70146_Z.nextFloat();
         double var14 = p_70972_1_.field_72339_c + (p_70972_1_.field_72334_f - p_70972_1_.field_72339_c) * (double)this.field_70146_Z.nextFloat();
         this.field_70170_p.func_72869_a("largeexplode", var16, var17, var14, 0.0D, 0.0D, 0.0D);
      }

      return var8;
   }

   public boolean func_70965_a(EntityDragonPart p_70965_1_, DamageSource p_70965_2_, int p_70965_3_) {
      if(p_70965_1_ != this.field_70986_h) {
         p_70965_3_ = p_70965_3_ / 4 + 1;
      }

      float var4 = this.field_70177_z * 3.1415927F / 180.0F;
      float var5 = MathHelper.func_76126_a(var4);
      float var6 = MathHelper.func_76134_b(var4);
      this.field_70980_b = this.field_70165_t + (double)(var5 * 5.0F) + (double)((this.field_70146_Z.nextFloat() - 0.5F) * 2.0F);
      this.field_70981_c = this.field_70163_u + (double)(this.field_70146_Z.nextFloat() * 3.0F) + 1.0D;
      this.field_70978_d = this.field_70161_v - (double)(var6 * 5.0F) + (double)((this.field_70146_Z.nextFloat() - 0.5F) * 2.0F);
      this.field_70993_bI = null;
      if(p_70965_2_.func_76346_g() instanceof EntityPlayer || p_70965_2_.func_94541_c()) {
         this.func_82195_e(p_70965_2_, p_70965_3_);
      }

      return true;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      return false;
   }

   protected boolean func_82195_e(DamageSource p_82195_1_, int p_82195_2_) {
      return super.func_70097_a(p_82195_1_, p_82195_2_);
   }

   protected void func_70609_aI() {
      ++this.field_70995_bG;
      if(this.field_70995_bG >= 180 && this.field_70995_bG <= 200) {
         float var1 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
         float var2 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
         float var3 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
         this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + (double)var1, this.field_70163_u + 2.0D + (double)var2, this.field_70161_v + (double)var3, 0.0D, 0.0D, 0.0D);
      }

      int var4;
      int var5;
      if(!this.field_70170_p.field_72995_K) {
         if(this.field_70995_bG > 150 && this.field_70995_bG % 5 == 0) {
            var4 = 1000;

            while(var4 > 0) {
               var5 = EntityXPOrb.func_70527_a(var4);
               var4 -= var5;
               this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, var5));
            }
         }

         if(this.field_70995_bG == 1) {
            this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
         }
      }

      this.func_70091_d(0.0D, 0.10000000149011612D, 0.0D);
      this.field_70761_aq = this.field_70177_z += 20.0F;
      if(this.field_70995_bG == 200 && !this.field_70170_p.field_72995_K) {
         var4 = 2000;

         while(var4 > 0) {
            var5 = EntityXPOrb.func_70527_a(var4);
            var4 -= var5;
            this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, var5));
         }

         this.func_70975_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
         this.func_70106_y();
      }

   }

   private void func_70975_a(int p_70975_1_, int p_70975_2_) {
      byte var3 = 64;
      BlockEndPortal.field_72275_a = true;
      byte var4 = 4;

      for(int var5 = var3 - 1; var5 <= var3 + 32; ++var5) {
         for(int var6 = p_70975_1_ - var4; var6 <= p_70975_1_ + var4; ++var6) {
            for(int var7 = p_70975_2_ - var4; var7 <= p_70975_2_ + var4; ++var7) {
               double var8 = (double)(var6 - p_70975_1_);
               double var10 = (double)(var7 - p_70975_2_);
               double var12 = var8 * var8 + var10 * var10;
               if(var12 <= ((double)var4 - 0.5D) * ((double)var4 - 0.5D)) {
                  if(var5 < var3) {
                     if(var12 <= ((double)(var4 - 1) - 0.5D) * ((double)(var4 - 1) - 0.5D)) {
                        this.field_70170_p.func_94575_c(var6, var5, var7, Block.field_71986_z.field_71990_ca);
                     }
                  } else if(var5 > var3) {
                     this.field_70170_p.func_94575_c(var6, var5, var7, 0);
                  } else if(var12 > ((double)(var4 - 1) - 0.5D) * ((double)(var4 - 1) - 0.5D)) {
                     this.field_70170_p.func_94575_c(var6, var5, var7, Block.field_71986_z.field_71990_ca);
                  } else {
                     this.field_70170_p.func_94575_c(var6, var5, var7, Block.field_72102_bH.field_71990_ca);
                  }
               }
            }
         }
      }

      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 0, p_70975_2_, Block.field_71986_z.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 1, p_70975_2_, Block.field_71986_z.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 2, p_70975_2_, Block.field_71986_z.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_ - 1, var3 + 2, p_70975_2_, Block.field_72069_aq.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_ + 1, var3 + 2, p_70975_2_, Block.field_72069_aq.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 2, p_70975_2_ - 1, Block.field_72069_aq.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 2, p_70975_2_ + 1, Block.field_72069_aq.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 3, p_70975_2_, Block.field_71986_z.field_71990_ca);
      this.field_70170_p.func_94575_c(p_70975_1_, var3 + 4, p_70975_2_, Block.field_72084_bK.field_71990_ca);
      BlockEndPortal.field_72275_a = false;
   }

   protected void func_70623_bb() {}

   public Entity[] func_70021_al() {
      return this.field_70977_g;
   }

   public boolean func_70067_L() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public int func_70968_i() {
      return this.field_70180_af.func_75679_c(16);
   }

   public World func_82194_d() {
      return this.field_70170_p;
   }

   protected String func_70639_aQ() {
      return "mob.enderdragon.growl";
   }

   protected String func_70621_aR() {
      return "mob.enderdragon.hit";
   }

   protected float func_70599_aP() {
      return 5.0F;
   }
}
