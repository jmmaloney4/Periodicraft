package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public abstract class EntityAITarget extends EntityAIBase {

   protected EntityLiving field_75299_d;
   protected float field_75300_e;
   protected boolean field_75297_f;
   private boolean field_75303_a;
   private int field_75301_b;
   private int field_75302_c;
   private int field_75298_g;


   public EntityAITarget(EntityLiving p_i3505_1_, float p_i3505_2_, boolean p_i3505_3_) {
      this(p_i3505_1_, p_i3505_2_, p_i3505_3_, false);
   }

   public EntityAITarget(EntityLiving p_i3506_1_, float p_i3506_2_, boolean p_i3506_3_, boolean p_i3506_4_) {
      this.field_75301_b = 0;
      this.field_75302_c = 0;
      this.field_75298_g = 0;
      this.field_75299_d = p_i3506_1_;
      this.field_75300_e = p_i3506_2_;
      this.field_75297_f = p_i3506_3_;
      this.field_75303_a = p_i3506_4_;
   }

   public boolean func_75253_b() {
      EntityLiving var1 = this.field_75299_d.func_70638_az();
      if(var1 == null) {
         return false;
      } else if(!var1.func_70089_S()) {
         return false;
      } else if(this.field_75299_d.func_70068_e(var1) > (double)(this.field_75300_e * this.field_75300_e)) {
         return false;
      } else {
         if(this.field_75297_f) {
            if(this.field_75299_d.func_70635_at().func_75522_a(var1)) {
               this.field_75298_g = 0;
            } else if(++this.field_75298_g > 60) {
               return false;
            }
         }

         return true;
      }
   }

   public void func_75249_e() {
      this.field_75301_b = 0;
      this.field_75302_c = 0;
      this.field_75298_g = 0;
   }

   public void func_75251_c() {
      this.field_75299_d.func_70624_b((EntityLiving)null);
   }

   protected boolean func_75296_a(EntityLiving p_75296_1_, boolean p_75296_2_) {
      if(p_75296_1_ == null) {
         return false;
      } else if(p_75296_1_ == this.field_75299_d) {
         return false;
      } else if(!p_75296_1_.func_70089_S()) {
         return false;
      } else if(!this.field_75299_d.func_70686_a(p_75296_1_.getClass())) {
         return false;
      } else {
         if(this.field_75299_d instanceof EntityTameable && ((EntityTameable)this.field_75299_d).func_70909_n()) {
            if(p_75296_1_ instanceof EntityTameable && ((EntityTameable)p_75296_1_).func_70909_n()) {
               return false;
            }

            if(p_75296_1_ == ((EntityTameable)this.field_75299_d).func_70902_q()) {
               return false;
            }
         } else if(p_75296_1_ instanceof EntityPlayer && !p_75296_2_ && ((EntityPlayer)p_75296_1_).field_71075_bZ.field_75102_a) {
            return false;
         }

         if(!this.field_75299_d.func_70649_d(MathHelper.func_76128_c(p_75296_1_.field_70165_t), MathHelper.func_76128_c(p_75296_1_.field_70163_u), MathHelper.func_76128_c(p_75296_1_.field_70161_v))) {
            return false;
         } else if(this.field_75297_f && !this.field_75299_d.func_70635_at().func_75522_a(p_75296_1_)) {
            return false;
         } else {
            if(this.field_75303_a) {
               if(--this.field_75302_c <= 0) {
                  this.field_75301_b = 0;
               }

               if(this.field_75301_b == 0) {
                  this.field_75301_b = this.func_75295_a(p_75296_1_)?1:2;
               }

               if(this.field_75301_b == 2) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   private boolean func_75295_a(EntityLiving p_75295_1_) {
      this.field_75302_c = 10 + this.field_75299_d.func_70681_au().nextInt(5);
      PathEntity var2 = this.field_75299_d.func_70661_as().func_75494_a(p_75295_1_);
      if(var2 == null) {
         return false;
      } else {
         PathPoint var3 = var2.func_75870_c();
         if(var3 == null) {
            return false;
         } else {
            int var4 = var3.field_75839_a - MathHelper.func_76128_c(p_75295_1_.field_70165_t);
            int var5 = var3.field_75838_c - MathHelper.func_76128_c(p_75295_1_.field_70161_v);
            return (double)(var4 * var4 + var5 * var5) <= 2.25D;
         }
      }
   }
}
