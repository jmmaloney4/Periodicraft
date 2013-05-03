package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityHeartFX extends EntityFX {

   float field_70575_a;


   public EntityHeartFX(World p_i3174_1_, double p_i3174_2_, double p_i3174_4_, double p_i3174_6_, double p_i3174_8_, double p_i3174_10_, double p_i3174_12_) {
      this(p_i3174_1_, p_i3174_2_, p_i3174_4_, p_i3174_6_, p_i3174_8_, p_i3174_10_, p_i3174_12_, 2.0F);
   }

   public EntityHeartFX(World p_i3175_1_, double p_i3175_2_, double p_i3175_4_, double p_i3175_6_, double p_i3175_8_, double p_i3175_10_, double p_i3175_12_, float p_i3175_14_) {
      super(p_i3175_1_, p_i3175_2_, p_i3175_4_, p_i3175_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w *= 0.009999999776482582D;
      this.field_70181_x *= 0.009999999776482582D;
      this.field_70179_y *= 0.009999999776482582D;
      this.field_70181_x += 0.1D;
      this.field_70544_f *= 0.75F;
      this.field_70544_f *= p_i3175_14_;
      this.field_70575_a = this.field_70544_f;
      this.field_70547_e = 16;
      this.field_70145_X = false;
      this.func_70536_a(80);
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70546_d + p_70539_2_) / (float)this.field_70547_e * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_70544_f = this.field_70575_a * var8;
      super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      if(this.field_70163_u == this.field_70167_r) {
         this.field_70159_w *= 1.1D;
         this.field_70179_y *= 1.1D;
      }

      this.field_70159_w *= 0.8600000143051147D;
      this.field_70181_x *= 0.8600000143051147D;
      this.field_70179_y *= 0.8600000143051147D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }
}
