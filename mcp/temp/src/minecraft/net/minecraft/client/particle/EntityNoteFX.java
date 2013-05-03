package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityNoteFX extends EntityFX {

   float field_70585_a;


   public EntityNoteFX(World p_i3158_1_, double p_i3158_2_, double p_i3158_4_, double p_i3158_6_, double p_i3158_8_, double p_i3158_10_, double p_i3158_12_) {
      this(p_i3158_1_, p_i3158_2_, p_i3158_4_, p_i3158_6_, p_i3158_8_, p_i3158_10_, p_i3158_12_, 2.0F);
   }

   public EntityNoteFX(World p_i3159_1_, double p_i3159_2_, double p_i3159_4_, double p_i3159_6_, double p_i3159_8_, double p_i3159_10_, double p_i3159_12_, float p_i3159_14_) {
      super(p_i3159_1_, p_i3159_2_, p_i3159_4_, p_i3159_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w *= 0.009999999776482582D;
      this.field_70181_x *= 0.009999999776482582D;
      this.field_70179_y *= 0.009999999776482582D;
      this.field_70181_x += 0.2D;
      this.field_70552_h = MathHelper.func_76126_a(((float)p_i3159_8_ + 0.0F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
      this.field_70553_i = MathHelper.func_76126_a(((float)p_i3159_8_ + 0.33333334F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
      this.field_70551_j = MathHelper.func_76126_a(((float)p_i3159_8_ + 0.6666667F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
      this.field_70544_f *= 0.75F;
      this.field_70544_f *= p_i3159_14_;
      this.field_70585_a = this.field_70544_f;
      this.field_70547_e = 6;
      this.field_70145_X = false;
      this.func_70536_a(64);
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70546_d + p_70539_2_) / (float)this.field_70547_e * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_70544_f = this.field_70585_a * var8;
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

      this.field_70159_w *= 0.6600000262260437D;
      this.field_70181_x *= 0.6600000262260437D;
      this.field_70179_y *= 0.6600000262260437D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }
}
