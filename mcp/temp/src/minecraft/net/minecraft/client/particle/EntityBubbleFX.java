package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityBubbleFX extends EntityFX {

   public EntityBubbleFX(World p_i3162_1_, double p_i3162_2_, double p_i3162_4_, double p_i3162_6_, double p_i3162_8_, double p_i3162_10_, double p_i3162_12_) {
      super(p_i3162_1_, p_i3162_2_, p_i3162_4_, p_i3162_6_, p_i3162_8_, p_i3162_10_, p_i3162_12_);
      this.field_70552_h = 1.0F;
      this.field_70553_i = 1.0F;
      this.field_70551_j = 1.0F;
      this.func_70536_a(32);
      this.func_70105_a(0.02F, 0.02F);
      this.field_70544_f *= this.field_70146_Z.nextFloat() * 0.6F + 0.2F;
      this.field_70159_w = p_i3162_8_ * 0.20000000298023224D + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
      this.field_70181_x = p_i3162_10_ * 0.20000000298023224D + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
      this.field_70179_y = p_i3162_12_ * 0.20000000298023224D + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      this.field_70181_x += 0.0020D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.8500000238418579D;
      this.field_70181_x *= 0.8500000238418579D;
      this.field_70179_y *= 0.8500000238418579D;
      if(this.field_70170_p.func_72803_f(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)) != Material.field_76244_g) {
         this.func_70106_y();
      }

      if(this.field_70547_e-- <= 0) {
         this.func_70106_y();
      }

   }
}
