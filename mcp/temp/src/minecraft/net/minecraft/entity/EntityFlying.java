package net.minecraft.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityFlying extends EntityLiving {

   public EntityFlying(World p_i3442_1_) {
      super(p_i3442_1_);
   }

   protected void func_70069_a(float p_70069_1_) {}

   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {}

   public void func_70612_e(float p_70612_1_, float p_70612_2_) {
      if(this.func_70090_H()) {
         this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.800000011920929D;
         this.field_70181_x *= 0.800000011920929D;
         this.field_70179_y *= 0.800000011920929D;
      } else if(this.func_70058_J()) {
         this.func_70060_a(p_70612_1_, p_70612_2_, 0.02F);
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.5D;
         this.field_70181_x *= 0.5D;
         this.field_70179_y *= 0.5D;
      } else {
         float var3 = 0.91F;
         if(this.field_70122_E) {
            var3 = 0.54600006F;
            int var4 = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
            if(var4 > 0) {
               var3 = Block.field_71973_m[var4].field_72016_cq * 0.91F;
            }
         }

         float var8 = 0.16277136F / (var3 * var3 * var3);
         this.func_70060_a(p_70612_1_, p_70612_2_, this.field_70122_E?0.1F * var8:0.02F);
         var3 = 0.91F;
         if(this.field_70122_E) {
            var3 = 0.54600006F;
            int var5 = this.field_70170_p.func_72798_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v));
            if(var5 > 0) {
               var3 = Block.field_71973_m[var5].field_72016_cq * 0.91F;
            }
         }

         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= (double)var3;
         this.field_70181_x *= (double)var3;
         this.field_70179_y *= (double)var3;
      }

      this.field_70722_aY = this.field_70721_aZ;
      double var10 = this.field_70165_t - this.field_70169_q;
      double var9 = this.field_70161_v - this.field_70166_s;
      float var7 = MathHelper.func_76133_a(var10 * var10 + var9 * var9) * 4.0F;
      if(var7 > 1.0F) {
         var7 = 1.0F;
      }

      this.field_70721_aZ += (var7 - this.field_70721_aZ) * 0.4F;
      this.field_70754_ba += this.field_70721_aZ;
   }

   public boolean func_70617_f_() {
      return false;
   }
}
