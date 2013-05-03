package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAuraFX extends EntityFX {

   public EntityAuraFX(World p_i3166_1_, double p_i3166_2_, double p_i3166_4_, double p_i3166_6_, double p_i3166_8_, double p_i3166_10_, double p_i3166_12_) {
      super(p_i3166_1_, p_i3166_2_, p_i3166_4_, p_i3166_6_, p_i3166_8_, p_i3166_10_, p_i3166_12_);
      float var14 = this.field_70146_Z.nextFloat() * 0.1F + 0.2F;
      this.field_70552_h = var14;
      this.field_70553_i = var14;
      this.field_70551_j = var14;
      this.func_70536_a(0);
      this.func_70105_a(0.02F, 0.02F);
      this.field_70544_f *= this.field_70146_Z.nextFloat() * 0.6F + 0.5F;
      this.field_70159_w *= 0.019999999552965164D;
      this.field_70181_x *= 0.019999999552965164D;
      this.field_70179_y *= 0.019999999552965164D;
      this.field_70547_e = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70145_X = true;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.99D;
      this.field_70181_x *= 0.99D;
      this.field_70179_y *= 0.99D;
      if(this.field_70547_e-- <= 0) {
         this.func_70106_y();
      }

   }
}
