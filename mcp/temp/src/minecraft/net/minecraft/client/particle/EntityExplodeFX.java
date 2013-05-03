package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityExplodeFX extends EntityFX {

   public EntityExplodeFX(World p_i3180_1_, double p_i3180_2_, double p_i3180_4_, double p_i3180_6_, double p_i3180_8_, double p_i3180_10_, double p_i3180_12_) {
      super(p_i3180_1_, p_i3180_2_, p_i3180_4_, p_i3180_6_, p_i3180_8_, p_i3180_10_, p_i3180_12_);
      this.field_70159_w = p_i3180_8_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
      this.field_70181_x = p_i3180_10_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
      this.field_70179_y = p_i3180_12_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.05F);
      this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.3F + 0.7F;
      this.field_70544_f = this.field_70146_Z.nextFloat() * this.field_70146_Z.nextFloat() * 6.0F + 1.0F;
      this.field_70547_e = (int)(16.0D / ((double)this.field_70146_Z.nextFloat() * 0.8D + 0.2D)) + 2;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
      this.field_70181_x += 0.0040D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.8999999761581421D;
      this.field_70181_x *= 0.8999999761581421D;
      this.field_70179_y *= 0.8999999761581421D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }
}
