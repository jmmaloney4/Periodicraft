package net.minecraft.entity.projectile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFishHook extends Entity {

   private int field_70202_d;
   private int field_70203_e;
   private int field_70200_f;
   private int field_70201_g;
   private boolean field_70214_h;
   public int field_70206_a;
   public EntityPlayer field_70204_b;
   private int field_70216_i;
   private int field_70211_j;
   private int field_70219_an;
   public Entity field_70205_c;
   private int field_70217_ao;
   private double field_70218_ap;
   private double field_70210_aq;
   private double field_70209_ar;
   private double field_70208_as;
   private double field_70207_at;
   @SideOnly(Side.CLIENT)
   private double field_70215_au;
   @SideOnly(Side.CLIENT)
   private double field_70213_av;
   @SideOnly(Side.CLIENT)
   private double field_70212_aw;


   public EntityFishHook(World p_i3574_1_) {
      super(p_i3574_1_);
      this.field_70202_d = -1;
      this.field_70203_e = -1;
      this.field_70200_f = -1;
      this.field_70201_g = 0;
      this.field_70214_h = false;
      this.field_70206_a = 0;
      this.field_70211_j = 0;
      this.field_70219_an = 0;
      this.field_70205_c = null;
      this.func_70105_a(0.25F, 0.25F);
      this.field_70158_ak = true;
   }

   @SideOnly(Side.CLIENT)
   public EntityFishHook(World p_i3575_1_, double p_i3575_2_, double p_i3575_4_, double p_i3575_6_, EntityPlayer p_i3575_8_) {
      this(p_i3575_1_);
      this.func_70107_b(p_i3575_2_, p_i3575_4_, p_i3575_6_);
      this.field_70158_ak = true;
      this.field_70204_b = p_i3575_8_;
      p_i3575_8_.field_71104_cf = this;
   }

   public EntityFishHook(World p_i3576_1_, EntityPlayer p_i3576_2_) {
      super(p_i3576_1_);
      this.field_70202_d = -1;
      this.field_70203_e = -1;
      this.field_70200_f = -1;
      this.field_70201_g = 0;
      this.field_70214_h = false;
      this.field_70206_a = 0;
      this.field_70211_j = 0;
      this.field_70219_an = 0;
      this.field_70205_c = null;
      this.field_70158_ak = true;
      this.field_70204_b = p_i3576_2_;
      this.field_70204_b.field_71104_cf = this;
      this.func_70105_a(0.25F, 0.25F);
      this.func_70012_b(p_i3576_2_.field_70165_t, p_i3576_2_.field_70163_u + 1.62D - (double)p_i3576_2_.field_70129_M, p_i3576_2_.field_70161_v, p_i3576_2_.field_70177_z, p_i3576_2_.field_70125_A);
      this.field_70165_t -= (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.field_70163_u -= 0.10000000149011612D;
      this.field_70161_v -= (double)(MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
      this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
      this.field_70129_M = 0.0F;
      float var3 = 0.4F;
      this.field_70159_w = (double)(-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70179_y = (double)(MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.field_70181_x = (double)(-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F) * var3);
      this.func_70199_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5F, 1.0F);
   }

   protected void func_70088_a() {}

   @SideOnly(Side.CLIENT)
   public boolean func_70112_a(double p_70112_1_) {
      double var3 = this.field_70121_D.func_72320_b() * 4.0D;
      var3 *= 64.0D;
      return p_70112_1_ < var3 * var3;
   }

   public void func_70199_c(double p_70199_1_, double p_70199_3_, double p_70199_5_, float p_70199_7_, float p_70199_8_) {
      float var9 = MathHelper.func_76133_a(p_70199_1_ * p_70199_1_ + p_70199_3_ * p_70199_3_ + p_70199_5_ * p_70199_5_);
      p_70199_1_ /= (double)var9;
      p_70199_3_ /= (double)var9;
      p_70199_5_ /= (double)var9;
      p_70199_1_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70199_8_;
      p_70199_3_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70199_8_;
      p_70199_5_ += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * (double)p_70199_8_;
      p_70199_1_ *= (double)p_70199_7_;
      p_70199_3_ *= (double)p_70199_7_;
      p_70199_5_ *= (double)p_70199_7_;
      this.field_70159_w = p_70199_1_;
      this.field_70181_x = p_70199_3_;
      this.field_70179_y = p_70199_5_;
      float var10 = MathHelper.func_76133_a(p_70199_1_ * p_70199_1_ + p_70199_5_ * p_70199_5_);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(p_70199_1_, p_70199_5_) * 180.0D / 3.1415927410125732D);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(p_70199_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_70216_i = 0;
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
      this.field_70218_ap = p_70056_1_;
      this.field_70210_aq = p_70056_3_;
      this.field_70209_ar = p_70056_5_;
      this.field_70208_as = (double)p_70056_7_;
      this.field_70207_at = (double)p_70056_8_;
      this.field_70217_ao = p_70056_9_;
      this.field_70159_w = this.field_70215_au;
      this.field_70181_x = this.field_70213_av;
      this.field_70179_y = this.field_70212_aw;
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70215_au = this.field_70159_w = p_70016_1_;
      this.field_70213_av = this.field_70181_x = p_70016_3_;
      this.field_70212_aw = this.field_70179_y = p_70016_5_;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.field_70217_ao > 0) {
         double var21 = this.field_70165_t + (this.field_70218_ap - this.field_70165_t) / (double)this.field_70217_ao;
         double var22 = this.field_70163_u + (this.field_70210_aq - this.field_70163_u) / (double)this.field_70217_ao;
         double var23 = this.field_70161_v + (this.field_70209_ar - this.field_70161_v) / (double)this.field_70217_ao;
         double var7 = MathHelper.func_76138_g(this.field_70208_as - (double)this.field_70177_z);
         this.field_70177_z = (float)((double)this.field_70177_z + var7 / (double)this.field_70217_ao);
         this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70207_at - (double)this.field_70125_A) / (double)this.field_70217_ao);
         --this.field_70217_ao;
         this.func_70107_b(var21, var22, var23);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
      } else {
         if(!this.field_70170_p.field_72995_K) {
            ItemStack var1 = this.field_70204_b.func_71045_bC();
            if(this.field_70204_b.field_70128_L || !this.field_70204_b.func_70089_S() || var1 == null || var1.func_77973_b() != Item.field_77749_aR || this.func_70068_e(this.field_70204_b) > 1024.0D) {
               this.func_70106_y();
               this.field_70204_b.field_71104_cf = null;
               return;
            }

            if(this.field_70205_c != null) {
               if(!this.field_70205_c.field_70128_L) {
                  this.field_70165_t = this.field_70205_c.field_70165_t;
                  this.field_70163_u = this.field_70205_c.field_70121_D.field_72338_b + (double)this.field_70205_c.field_70131_O * 0.8D;
                  this.field_70161_v = this.field_70205_c.field_70161_v;
                  return;
               }

               this.field_70205_c = null;
            }
         }

         if(this.field_70206_a > 0) {
            --this.field_70206_a;
         }

         if(this.field_70214_h) {
            int var19 = this.field_70170_p.func_72798_a(this.field_70202_d, this.field_70203_e, this.field_70200_f);
            if(var19 == this.field_70201_g) {
               ++this.field_70216_i;
               if(this.field_70216_i == 1200) {
                  this.func_70106_y();
               }

               return;
            }

            this.field_70214_h = false;
            this.field_70159_w *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70181_x *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70179_y *= (double)(this.field_70146_Z.nextFloat() * 0.2F);
            this.field_70216_i = 0;
            this.field_70211_j = 0;
         } else {
            ++this.field_70211_j;
         }

         Vec3 var20 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         Vec3 var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         MovingObjectPosition var3 = this.field_70170_p.func_72933_a(var20, var2);
         var20 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         var2 = this.field_70170_p.func_82732_R().func_72345_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
         if(var3 != null) {
            var2 = this.field_70170_p.func_82732_R().func_72345_a(var3.field_72307_f.field_72450_a, var3.field_72307_f.field_72448_b, var3.field_72307_f.field_72449_c);
         }

         Entity var4 = null;
         List var5 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         double var13;
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_70067_L() && (var9 != this.field_70204_b || this.field_70211_j >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_70121_D.func_72314_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_72327_a(var20, var2);
               if(var12 != null) {
                  var13 = var20.func_72438_d(var12.field_72307_f);
                  if(var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }

         if(var3 != null) {
            if(var3.field_72308_g != null) {
               if(var3.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.field_70204_b), 0)) {
                  this.field_70205_c = var3.field_72308_g;
               }
            } else {
               this.field_70214_h = true;
            }
         }

         if(!this.field_70214_h) {
            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            float var24 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
            this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);

            for(this.field_70125_A = (float)(Math.atan2(this.field_70181_x, (double)var24) * 180.0D / 3.1415927410125732D); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {
               ;
            }

            while(this.field_70125_A - this.field_70127_C >= 180.0F) {
               this.field_70127_C += 360.0F;
            }

            while(this.field_70177_z - this.field_70126_B < -180.0F) {
               this.field_70126_B -= 360.0F;
            }

            while(this.field_70177_z - this.field_70126_B >= 180.0F) {
               this.field_70126_B += 360.0F;
            }

            this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
            this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
            float var25 = 0.92F;
            if(this.field_70122_E || this.field_70123_F) {
               var25 = 0.5F;
            }

            byte var27 = 5;
            double var26 = 0.0D;

            for(int var29 = 0; var29 < var27; ++var29) {
               double var14 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(var29 + 0) / (double)var27 - 0.125D + 0.125D;
               double var16 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(var29 + 1) / (double)var27 - 0.125D + 0.125D;
               AxisAlignedBB var18 = AxisAlignedBB.func_72332_a().func_72299_a(this.field_70121_D.field_72340_a, var14, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, var16, this.field_70121_D.field_72334_f);
               if(this.field_70170_p.func_72830_b(var18, Material.field_76244_g)) {
                  var26 += 1.0D / (double)var27;
               }
            }

            if(var26 > 0.0D) {
               if(this.field_70219_an > 0) {
                  --this.field_70219_an;
               } else {
                  short var28 = 500;
                  if(this.field_70170_p.func_72951_B(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u) + 1, MathHelper.func_76128_c(this.field_70161_v))) {
                     var28 = 300;
                  }

                  if(this.field_70146_Z.nextInt(var28) == 0) {
                     this.field_70219_an = this.field_70146_Z.nextInt(30) + 10;
                     this.field_70181_x -= 0.20000000298023224D;
                     this.func_85030_a("random.splash", 0.25F, 1.0F + (this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.4F);
                     float var30 = (float)MathHelper.func_76128_c(this.field_70121_D.field_72338_b);

                     int var15;
                     float var17;
                     float var31;
                     for(var15 = 0; (float)var15 < 1.0F + this.field_70130_N * 20.0F; ++var15) {
                        var31 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
                        var17 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
                        this.field_70170_p.func_72869_a("bubble", this.field_70165_t + (double)var31, (double)(var30 + 1.0F), this.field_70161_v + (double)var17, this.field_70159_w, this.field_70181_x - (double)(this.field_70146_Z.nextFloat() * 0.2F), this.field_70179_y);
                     }

                     for(var15 = 0; (float)var15 < 1.0F + this.field_70130_N * 20.0F; ++var15) {
                        var31 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
                        var17 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F) * this.field_70130_N;
                        this.field_70170_p.func_72869_a("splash", this.field_70165_t + (double)var31, (double)(var30 + 1.0F), this.field_70161_v + (double)var17, this.field_70159_w, this.field_70181_x, this.field_70179_y);
                     }
                  }
               }
            }

            if(this.field_70219_an > 0) {
               this.field_70181_x -= (double)(this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat()) * 0.2D;
            }

            var13 = var26 * 2.0D - 1.0D;
            this.field_70181_x += 0.03999999910593033D * var13;
            if(var26 > 0.0D) {
               var25 = (float)((double)var25 * 0.9D);
               this.field_70181_x *= 0.8D;
            }

            this.field_70159_w *= (double)var25;
            this.field_70181_x *= (double)var25;
            this.field_70179_y *= (double)var25;
            this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
         }
      }
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74777_a("xTile", (short)this.field_70202_d);
      p_70014_1_.func_74777_a("yTile", (short)this.field_70203_e);
      p_70014_1_.func_74777_a("zTile", (short)this.field_70200_f);
      p_70014_1_.func_74774_a("inTile", (byte)this.field_70201_g);
      p_70014_1_.func_74774_a("shake", (byte)this.field_70206_a);
      p_70014_1_.func_74774_a("inGround", (byte)(this.field_70214_h?1:0));
   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      this.field_70202_d = p_70037_1_.func_74765_d("xTile");
      this.field_70203_e = p_70037_1_.func_74765_d("yTile");
      this.field_70200_f = p_70037_1_.func_74765_d("zTile");
      this.field_70201_g = p_70037_1_.func_74771_c("inTile") & 255;
      this.field_70206_a = p_70037_1_.func_74771_c("shake") & 255;
      this.field_70214_h = p_70037_1_.func_74771_c("inGround") == 1;
   }

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public int func_70198_d() {
      if(this.field_70170_p.field_72995_K) {
         return 0;
      } else {
         byte var1 = 0;
         if(this.field_70205_c != null) {
            double var2 = this.field_70204_b.field_70165_t - this.field_70165_t;
            double var4 = this.field_70204_b.field_70163_u - this.field_70163_u;
            double var6 = this.field_70204_b.field_70161_v - this.field_70161_v;
            double var8 = (double)MathHelper.func_76133_a(var2 * var2 + var4 * var4 + var6 * var6);
            double var10 = 0.1D;
            this.field_70205_c.field_70159_w += var2 * var10;
            this.field_70205_c.field_70181_x += var4 * var10 + (double)MathHelper.func_76133_a(var8) * 0.08D;
            this.field_70205_c.field_70179_y += var6 * var10;
            var1 = 3;
         } else if(this.field_70219_an > 0) {
            EntityItem var13 = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, new ItemStack(Item.field_77754_aU));
            double var3 = this.field_70204_b.field_70165_t - this.field_70165_t;
            double var5 = this.field_70204_b.field_70163_u - this.field_70163_u;
            double var7 = this.field_70204_b.field_70161_v - this.field_70161_v;
            double var9 = (double)MathHelper.func_76133_a(var3 * var3 + var5 * var5 + var7 * var7);
            double var11 = 0.1D;
            var13.field_70159_w = var3 * var11;
            var13.field_70181_x = var5 * var11 + (double)MathHelper.func_76133_a(var9) * 0.08D;
            var13.field_70179_y = var7 * var11;
            this.field_70170_p.func_72838_d(var13);
            this.field_70204_b.func_71064_a(StatList.field_75933_B, 1);
            this.field_70204_b.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70204_b.field_70170_p, this.field_70204_b.field_70165_t, this.field_70204_b.field_70163_u + 0.5D, this.field_70204_b.field_70161_v + 0.5D, this.field_70146_Z.nextInt(6) + 1));
            var1 = 1;
         }

         if(this.field_70214_h) {
            var1 = 2;
         }

         this.func_70106_y();
         this.field_70204_b.field_71104_cf = null;
         return var1;
      }
   }

   public void func_70106_y() {
      super.func_70106_y();
      if(this.field_70204_b != null) {
         this.field_70204_b.field_71104_cf = null;
      }

   }
}
