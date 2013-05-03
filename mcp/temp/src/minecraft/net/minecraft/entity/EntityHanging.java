package net.minecraft.entity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityHanging extends Entity {

   private int field_70520_f;
   public int field_82332_a;
   public int field_70523_b;
   public int field_70524_c;
   public int field_70521_d;


   public EntityHanging(World p_i5053_1_) {
      super(p_i5053_1_);
      this.field_70520_f = 0;
      this.field_82332_a = 0;
      this.field_70129_M = 0.0F;
      this.func_70105_a(0.5F, 0.5F);
   }

   public EntityHanging(World p_i5054_1_, int p_i5054_2_, int p_i5054_3_, int p_i5054_4_, int p_i5054_5_) {
      this(p_i5054_1_);
      this.field_70523_b = p_i5054_2_;
      this.field_70524_c = p_i5054_3_;
      this.field_70521_d = p_i5054_4_;
   }

   protected void func_70088_a() {}

   public void func_82328_a(int p_82328_1_) {
      this.field_82332_a = p_82328_1_;
      this.field_70126_B = this.field_70177_z = (float)(p_82328_1_ * 90);
      float var2 = (float)this.func_82329_d();
      float var3 = (float)this.func_82330_g();
      float var4 = (float)this.func_82329_d();
      if(p_82328_1_ != 2 && p_82328_1_ != 0) {
         var2 = 0.5F;
      } else {
         var4 = 0.5F;
         this.field_70177_z = this.field_70126_B = (float)(Direction.field_71580_e[p_82328_1_] * 90);
      }

      var2 /= 32.0F;
      var3 /= 32.0F;
      var4 /= 32.0F;
      float var5 = (float)this.field_70523_b + 0.5F;
      float var6 = (float)this.field_70524_c + 0.5F;
      float var7 = (float)this.field_70521_d + 0.5F;
      float var8 = 0.5625F;
      if(p_82328_1_ == 2) {
         var7 -= var8;
      }

      if(p_82328_1_ == 1) {
         var5 -= var8;
      }

      if(p_82328_1_ == 0) {
         var7 += var8;
      }

      if(p_82328_1_ == 3) {
         var5 += var8;
      }

      if(p_82328_1_ == 2) {
         var5 -= this.func_70517_b(this.func_82329_d());
      }

      if(p_82328_1_ == 1) {
         var7 += this.func_70517_b(this.func_82329_d());
      }

      if(p_82328_1_ == 0) {
         var5 += this.func_70517_b(this.func_82329_d());
      }

      if(p_82328_1_ == 3) {
         var7 -= this.func_70517_b(this.func_82329_d());
      }

      var6 += this.func_70517_b(this.func_82330_g());
      this.func_70107_b((double)var5, (double)var6, (double)var7);
      float var9 = -0.03125F;
      this.field_70121_D.func_72324_b((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
   }

   private float func_70517_b(int p_70517_1_) {
      return p_70517_1_ == 32?0.5F:(p_70517_1_ == 64?0.5F:0.0F);
   }

   public void func_70071_h_() {
      if(this.field_70520_f++ == 100 && !this.field_70170_p.field_72995_K) {
         this.field_70520_f = 0;
         if(!this.field_70128_L && !this.func_70518_d()) {
            this.func_70106_y();
            this.func_82331_h();
         }
      }

   }

   public boolean func_70518_d() {
      if(!this.field_70170_p.func_72945_a(this, this.field_70121_D).isEmpty()) {
         return false;
      } else {
         int var1 = Math.max(1, this.func_82329_d() / 16);
         int var2 = Math.max(1, this.func_82330_g() / 16);
         int var3 = this.field_70523_b;
         int var4 = this.field_70524_c;
         int var5 = this.field_70521_d;
         if(this.field_82332_a == 2) {
            var3 = MathHelper.func_76128_c(this.field_70165_t - (double)((float)this.func_82329_d() / 32.0F));
         }

         if(this.field_82332_a == 1) {
            var5 = MathHelper.func_76128_c(this.field_70161_v - (double)((float)this.func_82329_d() / 32.0F));
         }

         if(this.field_82332_a == 0) {
            var3 = MathHelper.func_76128_c(this.field_70165_t - (double)((float)this.func_82329_d() / 32.0F));
         }

         if(this.field_82332_a == 3) {
            var5 = MathHelper.func_76128_c(this.field_70161_v - (double)((float)this.func_82329_d() / 32.0F));
         }

         var4 = MathHelper.func_76128_c(this.field_70163_u - (double)((float)this.func_82330_g() / 32.0F));

         for(int var6 = 0; var6 < var1; ++var6) {
            for(int var7 = 0; var7 < var2; ++var7) {
               Material var8;
               if(this.field_82332_a != 2 && this.field_82332_a != 0) {
                  var8 = this.field_70170_p.func_72803_f(this.field_70523_b, var4 + var7, var5 + var6);
               } else {
                  var8 = this.field_70170_p.func_72803_f(var3 + var6, var4 + var7, this.field_70521_d);
               }

               if(!var8.func_76220_a()) {
                  return false;
               }
            }
         }

         List var9 = this.field_70170_p.func_72839_b(this, this.field_70121_D);
         Iterator var10 = var9.iterator();

         Entity var11;
         do {
            if(!var10.hasNext()) {
               return true;
            }

            var11 = (Entity)var10.next();
         } while(!(var11 instanceof EntityHanging));

         return false;
      }
   }

   public boolean func_70067_L() {
      return true;
   }

   public boolean func_85031_j(Entity p_85031_1_) {
      return p_85031_1_ instanceof EntityPlayer?this.func_70097_a(DamageSource.func_76365_a((EntityPlayer)p_85031_1_), 0):false;
   }

   public boolean func_70097_a(DamageSource p_70097_1_, int p_70097_2_) {
      if(this.func_85032_ar()) {
         return false;
      } else {
         if(!this.field_70128_L && !this.field_70170_p.field_72995_K) {
            this.func_70106_y();
            this.func_70018_K();
            EntityPlayer var3 = null;
            if(p_70097_1_.func_76346_g() instanceof EntityPlayer) {
               var3 = (EntityPlayer)p_70097_1_.func_76346_g();
            }

            if(var3 != null && var3.field_71075_bZ.field_75098_d) {
               return true;
            }

            this.func_82331_h();
         }

         return true;
      }
   }

   public void func_70091_d(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70091_1_ * p_70091_1_ + p_70091_3_ * p_70091_3_ + p_70091_5_ * p_70091_5_ > 0.0D) {
         this.func_70106_y();
         this.func_82331_h();
      }

   }

   public void func_70024_g(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
      if(!this.field_70170_p.field_72995_K && !this.field_70128_L && p_70024_1_ * p_70024_1_ + p_70024_3_ * p_70024_3_ + p_70024_5_ * p_70024_5_ > 0.0D) {
         this.func_70106_y();
         this.func_82331_h();
      }

   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      p_70014_1_.func_74774_a("Direction", (byte)this.field_82332_a);
      p_70014_1_.func_74768_a("TileX", this.field_70523_b);
      p_70014_1_.func_74768_a("TileY", this.field_70524_c);
      p_70014_1_.func_74768_a("TileZ", this.field_70521_d);
      switch(this.field_82332_a) {
      case 0:
         p_70014_1_.func_74774_a("Dir", (byte)2);
         break;
      case 1:
         p_70014_1_.func_74774_a("Dir", (byte)1);
         break;
      case 2:
         p_70014_1_.func_74774_a("Dir", (byte)0);
         break;
      case 3:
         p_70014_1_.func_74774_a("Dir", (byte)3);
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      if(p_70037_1_.func_74764_b("Direction")) {
         this.field_82332_a = p_70037_1_.func_74771_c("Direction");
      } else {
         switch(p_70037_1_.func_74771_c("Dir")) {
         case 0:
            this.field_82332_a = 2;
            break;
         case 1:
            this.field_82332_a = 1;
            break;
         case 2:
            this.field_82332_a = 0;
            break;
         case 3:
            this.field_82332_a = 3;
         }
      }

      this.field_70523_b = p_70037_1_.func_74762_e("TileX");
      this.field_70524_c = p_70037_1_.func_74762_e("TileY");
      this.field_70521_d = p_70037_1_.func_74762_e("TileZ");
      this.func_82328_a(this.field_82332_a);
   }

   public abstract int func_82329_d();

   public abstract int func_82330_g();

   public abstract void func_82331_h();
}
