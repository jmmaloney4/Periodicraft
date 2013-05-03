package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBoat extends Entity {

   private boolean field_70279_a;
   private double field_70276_b;
   private int field_70277_c;
   private double field_70274_d;
   private double field_70275_e;
   private double field_70272_f;
   private double field_70273_g;
   private double field_70281_h;
   @SideOnly(Side.CLIENT)
   private double field_70282_i;
   @SideOnly(Side.CLIENT)
   private double field_70280_j;
   @SideOnly(Side.CLIENT)
   private double field_70278_an;


   public EntityBoat(World p_i3534_1_) {
      super(p_i3534_1_);
      this.field_70279_a = true;
      this.field_70276_b = 0.07D;
      this.field_70156_m = true;
      this.func_70105_a(1.5F, 0.6F);
      this.field_70129_M = this.field_70131_O / 2.0F;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
      this.field_70180_af.func_75682_a(17, new Integer(0));
      this.field_70180_af.func_75682_a(18, new Integer(1));
      this.field_70180_af.func_75682_a(19, new Integer(0));
   }

   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
      return p_70114_1_.field_70121_D;
   }

   public AxisAlignedBB func_70046_E() {
      return this.field_70121_D;
   }

   public boolean func_70104_M() {
      return true;
   }

   public EntityBoat(World p_i3535_1_, double p_i3535_2_, double p_i3535_4_, double p_i3535_6_) {
      this(p_i3535_1_);
      this.func_70107_b(p_i3535_2_, p_i3535_4_ + (double)this.field_70129_M, p_i3535_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i3535_2_;
      this.field_70167_r = p_i3535_4_;
      this.field_70166_s = p_i3535_6_;
   }

   public double func_70042_X() {
      return (double)this.field_70131_O * 0.0D - 0.30000001192092896D;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else if(!this.field_70170_p.field_72995_K && !this.field_70128_L) {
         this.func_70269_c(-this.func_70267_i());
         this.func_70265_b(10);
         this.func_70266_a(this.func_70271_g() + p_70097_2_ * 10);
         this.func_70018_K();
         boolean var3 = p_70097_1_.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d;
         if(var3 || this.func_70271_g() > 40) {
            if(this.field_70153_n != null) {
               this.field_70153_n.func_70078_a(this);
            }

            if(!var3) {
               this.func_70054_a(Item.field_77769_aE.field_77779_bT, 1, 0.0F);
            }

            this.func_70106_y();
         }

         return true;
      } else {
         return true;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_70057_ab() {
      this.func_70269_c(-this.func_70267_i());
      this.func_70265_b(10);
      this.func_70266_a(this.func_70271_g() * 11);
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   @SideOnly(Side.CLIENT)
   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
      if(this.field_70279_a) {
         this.field_70277_c = p_70056_9_ + 5;
      } else {
         double var10 = p_70056_1_ - this.field_70165_t;
         double var12 = p_70056_3_ - this.field_70163_u;
         double var14 = p_70056_5_ - this.field_70161_v;
         double var16 = var10 * var10 + var12 * var12 + var14 * var14;
         if(var16 <= 1.0D) {
            return;
         }

         this.field_70277_c = 3;
      }

      this.field_70274_d = p_70056_1_;
      this.field_70275_e = p_70056_3_;
      this.field_70272_f = p_70056_5_;
      this.field_70273_g = (double)p_70056_7_;
      this.field_70281_h = (double)p_70056_8_;
      this.field_70159_w = this.field_70282_i;
      this.field_70181_x = this.field_70280_j;
      this.field_70179_y = this.field_70278_an;
   }

   @SideOnly(Side.CLIENT)
   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
      this.field_70282_i = this.field_70159_w = p_70016_1_;
      this.field_70280_j = this.field_70181_x = p_70016_3_;
      this.field_70278_an = this.field_70179_y = p_70016_5_;
   }

   public void func_70071_h_() {
      super.func_70071_h_();
      if(this.func_70268_h() > 0) {
         this.func_70265_b(this.func_70268_h() - 1);
      }

      if(this.func_70271_g() > 0) {
         this.func_70266_a(this.func_70271_g() - 1);
      }

      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      byte var1 = 5;
      double var2 = 0.0D;

      for(int var4 = 0; var4 < var1; ++var4) {
         double var5 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(var4 + 0) / (double)var1 - 0.125D;
         double var7 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (double)(var4 + 1) / (double)var1 - 0.125D;
         AxisAlignedBB var9 = AxisAlignedBB.func_72332_a().func_72299_a(this.field_70121_D.field_72340_a, var5, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, var7, this.field_70121_D.field_72334_f);
         if(this.field_70170_p.func_72830_b(var9, Material.field_76244_g)) {
            var2 += 1.0D / (double)var1;
         }
      }

      double var23 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
      double var6;
      double var8;
      if(var23 > 0.26249999999999996D) {
         var6 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D);
         var8 = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D);

         for(int var10 = 0; (double)var10 < 1.0D + var23 * 60.0D; ++var10) {
            double var11 = (double)(this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
            double var13 = (double)(this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
            double var15;
            double var17;
            if(this.field_70146_Z.nextBoolean()) {
               var15 = this.field_70165_t - var6 * var11 * 0.8D + var8 * var13;
               var17 = this.field_70161_v - var8 * var11 * 0.8D - var6 * var13;
               this.field_70170_p.func_72869_a("splash", var15, this.field_70163_u - 0.125D, var17, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            } else {
               var15 = this.field_70165_t + var6 + var8 * var11 * 0.7D;
               var17 = this.field_70161_v + var8 - var6 * var11 * 0.7D;
               this.field_70170_p.func_72869_a("splash", var15, this.field_70163_u - 0.125D, var17, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            }
         }
      }

      double var12;
      double var25;
      if(this.field_70170_p.field_72995_K && this.field_70279_a) {
         if(this.field_70277_c > 0) {
            var6 = this.field_70165_t + (this.field_70274_d - this.field_70165_t) / (double)this.field_70277_c;
            var8 = this.field_70163_u + (this.field_70275_e - this.field_70163_u) / (double)this.field_70277_c;
            var25 = this.field_70161_v + (this.field_70272_f - this.field_70161_v) / (double)this.field_70277_c;
            var12 = MathHelper.func_76138_g(this.field_70273_g - (double)this.field_70177_z);
            this.field_70177_z = (float)((double)this.field_70177_z + var12 / (double)this.field_70277_c);
            this.field_70125_A = (float)((double)this.field_70125_A + (this.field_70281_h - (double)this.field_70125_A) / (double)this.field_70277_c);
            --this.field_70277_c;
            this.func_70107_b(var6, var8, var25);
            this.func_70101_b(this.field_70177_z, this.field_70125_A);
         } else {
            var6 = this.field_70165_t + this.field_70159_w;
            var8 = this.field_70163_u + this.field_70181_x;
            var25 = this.field_70161_v + this.field_70179_y;
            this.func_70107_b(var6, var8, var25);
            if(this.field_70122_E) {
               this.field_70159_w *= 0.5D;
               this.field_70181_x *= 0.5D;
               this.field_70179_y *= 0.5D;
            }

            this.field_70159_w *= 0.9900000095367432D;
            this.field_70181_x *= 0.949999988079071D;
            this.field_70179_y *= 0.9900000095367432D;
         }

      } else {
         if(var2 < 1.0D) {
            var6 = var2 * 2.0D - 1.0D;
            this.field_70181_x += 0.03999999910593033D * var6;
         } else {
            if(this.field_70181_x < 0.0D) {
               this.field_70181_x /= 2.0D;
            }

            this.field_70181_x += 0.007000000216066837D;
         }

         if(this.field_70153_n != null) {
            this.field_70159_w += this.field_70153_n.field_70159_w * this.field_70276_b;
            this.field_70179_y += this.field_70153_n.field_70179_y * this.field_70276_b;
         }

         var6 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
         if(var6 > 0.35D) {
            var8 = 0.35D / var6;
            this.field_70159_w *= var8;
            this.field_70179_y *= var8;
            var6 = 0.35D;
         }

         if(var6 > var23 && this.field_70276_b < 0.35D) {
            this.field_70276_b += (0.35D - this.field_70276_b) / 35.0D;
            if(this.field_70276_b > 0.35D) {
               this.field_70276_b = 0.35D;
            }
         } else {
            this.field_70276_b -= (this.field_70276_b - 0.07D) / 35.0D;
            if(this.field_70276_b < 0.07D) {
               this.field_70276_b = 0.07D;
            }
         }

         if(this.field_70122_E) {
            this.field_70159_w *= 0.5D;
            this.field_70181_x *= 0.5D;
            this.field_70179_y *= 0.5D;
         }

         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         if(this.field_70123_F && var23 > 0.2D) {
            if(!this.field_70170_p.field_72995_K) {
               this.func_70106_y();

               int var24;
               for(var24 = 0; var24 < 3; ++var24) {
                  this.func_70054_a(Block.field_71988_x.field_71990_ca, 1, 0.0F);
               }

               for(var24 = 0; var24 < 2; ++var24) {
                  this.func_70054_a(Item.field_77669_D.field_77779_bT, 1, 0.0F);
               }
            }
         } else {
            this.field_70159_w *= 0.9900000095367432D;
            this.field_70181_x *= 0.949999988079071D;
            this.field_70179_y *= 0.9900000095367432D;
         }

         this.field_70125_A = 0.0F;
         var8 = (double)this.field_70177_z;
         var25 = this.field_70169_q - this.field_70165_t;
         var12 = this.field_70166_s - this.field_70161_v;
         if(var25 * var25 + var12 * var12 > 0.0010D) {
            var8 = (double)((float)(Math.atan2(var12, var25) * 180.0D / 3.141592653589793D));
         }

         double var14 = MathHelper.func_76138_g(var8 - (double)this.field_70177_z);
         if(var14 > 20.0D) {
            var14 = 20.0D;
         }

         if(var14 < -20.0D) {
            var14 = -20.0D;
         }

         this.field_70177_z = (float)((double)this.field_70177_z + var14);
         this.func_70101_b(this.field_70177_z, this.field_70125_A);
         if(!this.field_70170_p.field_72995_K) {
            List var16 = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            int var26;
            if(var16 != null && !var16.isEmpty()) {
               for(var26 = 0; var26 < var16.size(); ++var26) {
                  Entity var18 = (Entity)var16.get(var26);
                  if(var18 != this.field_70153_n && var18.func_70104_M() && var18 instanceof EntityBoat) {
                     var18.func_70108_f(this);
                  }
               }
            }

            for(var26 = 0; var26 < 4; ++var26) {
               int var27 = MathHelper.func_76128_c(this.field_70165_t + ((double)(var26 % 2) - 0.5D) * 0.8D);
               int var19 = MathHelper.func_76128_c(this.field_70161_v + ((double)(var26 / 2) - 0.5D) * 0.8D);

               for(int var20 = 0; var20 < 2; ++var20) {
                  int var21 = MathHelper.func_76128_c(this.field_70163_u) + var20;
                  int var22 = this.field_70170_p.func_72798_a(var27, var21, var19);
                  if(var22 == Block.field_72037_aS.field_71990_ca) {
                     this.field_70170_p.func_94571_i(var27, var21, var19);
                  } else if(var22 == Block.field_71991_bz.field_71990_ca) {
                     this.field_70170_p.func_94578_a(var27, var21, var19, true);
                  }
               }
            }

            if(this.field_70153_n != null && this.field_70153_n.field_70128_L) {
               this.field_70153_n = null;
            }

         }
      }
   }

   public void func_70043_V() {
      if(this.field_70153_n != null) {
         double var1 = Math.cos((double)this.field_70177_z * 3.141592653589793D / 180.0D) * 0.4D;
         double var3 = Math.sin((double)this.field_70177_z * 3.141592653589793D / 180.0D) * 0.4D;
         this.field_70153_n.func_70107_b(this.field_70165_t + var1, this.field_70163_u + this.func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + var3);
      }
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {}

   protected void func_70037_a(NBTTagCompound p_70037_1_) {}

   @SideOnly(Side.CLIENT)
   public float func_70053_R() {
      return 0.0F;
   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      if(this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != p_70085_1_) {
         return true;
      } else {
         if(!this.field_70170_p.field_72995_K) {
            p_70085_1_.func_70078_a(this);
         }

         return true;
      }
   }

   public void func_70266_a(int p_70266_1_) {
      this.field_70180_af.func_75692_b(19, Integer.valueOf(p_70266_1_));
   }

   public int func_70271_g() {
      return this.field_70180_af.func_75679_c(19);
   }

   public void func_70265_b(int p_70265_1_) {
      this.field_70180_af.func_75692_b(17, Integer.valueOf(p_70265_1_));
   }

   public int func_70268_h() {
      return this.field_70180_af.func_75679_c(17);
   }

   public void func_70269_c(int p_70269_1_) {
      this.field_70180_af.func_75692_b(18, Integer.valueOf(p_70269_1_));
   }

   public int func_70267_i() {
      return this.field_70180_af.func_75679_c(18);
   }

   @SideOnly(Side.CLIENT)
   public void func_70270_d(boolean p_70270_1_) {
      this.field_70279_a = p_70270_1_;
   }
}
