package net.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityCreature extends EntityLiving {

   private PathEntity field_70786_d;
   protected Entity field_70789_a;
   protected boolean field_70787_b = false;
   protected int field_70788_c = 0;


   public EntityCreature(World p_i3450_1_) {
      super(p_i3450_1_);
   }

   protected boolean func_70780_i() {
      return false;
   }

   protected void func_70626_be() {
      this.field_70170_p.field_72984_F.func_76320_a("ai");
      if(this.field_70788_c > 0) {
         --this.field_70788_c;
      }

      this.field_70787_b = this.func_70780_i();
      float var1 = 16.0F;
      if(this.field_70789_a == null) {
         this.field_70789_a = this.func_70782_k();
         if(this.field_70789_a != null) {
            this.field_70786_d = this.field_70170_p.func_72865_a(this, this.field_70789_a, var1, true, false, false, true);
         }
      } else if(this.field_70789_a.func_70089_S()) {
         float var2 = this.field_70789_a.func_70032_d(this);
         if(this.func_70685_l(this.field_70789_a)) {
            this.func_70785_a(this.field_70789_a, var2);
         }
      } else {
         this.field_70789_a = null;
      }

      this.field_70170_p.field_72984_F.func_76319_b();
      if(!this.field_70787_b && this.field_70789_a != null && (this.field_70786_d == null || this.field_70146_Z.nextInt(20) == 0)) {
         this.field_70786_d = this.field_70170_p.func_72865_a(this, this.field_70789_a, var1, true, false, false, true);
      } else if(!this.field_70787_b && (this.field_70786_d == null && this.field_70146_Z.nextInt(180) == 0 || this.field_70146_Z.nextInt(120) == 0 || this.field_70788_c > 0) && this.field_70708_bq < 100) {
         this.func_70779_j();
      }

      int var21 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b + 0.5D);
      boolean var3 = this.func_70090_H();
      boolean var4 = this.func_70058_J();
      this.field_70125_A = 0.0F;
      if(this.field_70786_d != null && this.field_70146_Z.nextInt(100) != 0) {
         this.field_70170_p.field_72984_F.func_76320_a("followpath");
         Vec3 var5 = this.field_70786_d.func_75878_a(this);
         double var6 = (double)(this.field_70130_N * 2.0F);

         while(var5 != null && var5.func_72445_d(this.field_70165_t, var5.field_72448_b, this.field_70161_v) < var6 * var6) {
            this.field_70786_d.func_75875_a();
            if(this.field_70786_d.func_75879_b()) {
               var5 = null;
               this.field_70786_d = null;
            } else {
               var5 = this.field_70786_d.func_75878_a(this);
            }
         }

         this.field_70703_bu = false;
         if(var5 != null) {
            double var8 = var5.field_72450_a - this.field_70165_t;
            double var10 = var5.field_72449_c - this.field_70161_v;
            double var12 = var5.field_72448_b - (double)var21;
            float var14 = (float)(Math.atan2(var10, var8) * 180.0D / 3.1415927410125732D) - 90.0F;
            float var15 = MathHelper.func_76142_g(var14 - this.field_70177_z);
            this.field_70701_bs = this.field_70697_bw;
            if(var15 > 30.0F) {
               var15 = 30.0F;
            }

            if(var15 < -30.0F) {
               var15 = -30.0F;
            }

            this.field_70177_z += var15;
            if(this.field_70787_b && this.field_70789_a != null) {
               double var16 = this.field_70789_a.field_70165_t - this.field_70165_t;
               double var18 = this.field_70789_a.field_70161_v - this.field_70161_v;
               float var20 = this.field_70177_z;
               this.field_70177_z = (float)(Math.atan2(var18, var16) * 180.0D / 3.1415927410125732D) - 90.0F;
               var15 = (var20 - this.field_70177_z + 90.0F) * 3.1415927F / 180.0F;
               this.field_70702_br = -MathHelper.func_76126_a(var15) * this.field_70701_bs * 1.0F;
               this.field_70701_bs = MathHelper.func_76134_b(var15) * this.field_70701_bs * 1.0F;
            }

            if(var12 > 0.0D) {
               this.field_70703_bu = true;
            }
         }

         if(this.field_70789_a != null) {
            this.func_70625_a(this.field_70789_a, 30.0F, 30.0F);
         }

         if(this.field_70123_F && !this.func_70781_l()) {
            this.field_70703_bu = true;
         }

         if(this.field_70146_Z.nextFloat() < 0.8F && (var3 || var4)) {
            this.field_70703_bu = true;
         }

         this.field_70170_p.field_72984_F.func_76319_b();
      } else {
         super.func_70626_be();
         this.field_70786_d = null;
      }
   }

   protected void func_70779_j() {
      this.field_70170_p.field_72984_F.func_76320_a("stroll");
      boolean var1 = false;
      int var2 = -1;
      int var3 = -1;
      int var4 = -1;
      float var5 = -99999.0F;

      for(int var6 = 0; var6 < 10; ++var6) {
         int var7 = MathHelper.func_76128_c(this.field_70165_t + (double)this.field_70146_Z.nextInt(13) - 6.0D);
         int var8 = MathHelper.func_76128_c(this.field_70163_u + (double)this.field_70146_Z.nextInt(7) - 3.0D);
         int var9 = MathHelper.func_76128_c(this.field_70161_v + (double)this.field_70146_Z.nextInt(13) - 6.0D);
         float var10 = this.func_70783_a(var7, var8, var9);
         if(var10 > var5) {
            var5 = var10;
            var2 = var7;
            var3 = var8;
            var4 = var9;
            var1 = true;
         }
      }

      if(var1) {
         this.field_70786_d = this.field_70170_p.func_72844_a(this, var2, var3, var4, 10.0F, true, false, false, true);
      }

      this.field_70170_p.field_72984_F.func_76319_b();
   }

   protected void func_70785_a(Entity p_70785_1_, float p_70785_2_) {}

   public float func_70783_a(int p_70783_1_, int p_70783_2_, int p_70783_3_) {
      return 0.0F;
   }

   protected Entity func_70782_k() {
      return null;
   }

   public boolean func_70601_bi() {
      int var1 = MathHelper.func_76128_c(this.field_70165_t);
      int var2 = MathHelper.func_76128_c(this.field_70121_D.field_72338_b);
      int var3 = MathHelper.func_76128_c(this.field_70161_v);
      return super.func_70601_bi() && this.func_70783_a(var1, var2, var3) >= 0.0F;
   }

   public boolean func_70781_l() {
      return this.field_70786_d != null;
   }

   public void func_70778_a(PathEntity p_70778_1_) {
      this.field_70786_d = p_70778_1_;
   }

   public Entity func_70777_m() {
      return this.field_70789_a;
   }

   public void func_70784_b(Entity p_70784_1_) {
      this.field_70789_a = p_70784_1_;
   }

   public float func_70616_bs() {
      float var1 = super.func_70616_bs();
      if(this.field_70788_c > 0 && !this.func_70650_aV()) {
         var1 *= 2.0F;
      }

      return var1;
   }
}
