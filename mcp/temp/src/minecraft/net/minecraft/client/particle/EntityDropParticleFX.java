package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityDropParticleFX extends EntityFX {

   private Material field_70563_a;
   private int field_70564_aq;


   public EntityDropParticleFX(World p_i3151_1_, double p_i3151_2_, double p_i3151_4_, double p_i3151_6_, Material p_i3151_8_) {
      super(p_i3151_1_, p_i3151_2_, p_i3151_4_, p_i3151_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
      if(p_i3151_8_ == Material.field_76244_g) {
         this.field_70552_h = 0.0F;
         this.field_70553_i = 0.0F;
         this.field_70551_j = 1.0F;
      } else {
         this.field_70552_h = 1.0F;
         this.field_70553_i = 0.0F;
         this.field_70551_j = 0.0F;
      }

      this.func_70536_a(113);
      this.func_70105_a(0.01F, 0.01F);
      this.field_70545_g = 0.06F;
      this.field_70563_a = p_i3151_8_;
      this.field_70564_aq = 40;
      this.field_70547_e = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D;
   }

   public int func_70070_b(float p_70070_1_) {
      return this.field_70563_a == Material.field_76244_g?super.func_70070_b(p_70070_1_):257;
   }

   public float func_70013_c(float p_70013_1_) {
      return this.field_70563_a == Material.field_76244_g?super.func_70013_c(p_70013_1_):1.0F;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70563_a == Material.field_76244_g) {
         this.field_70552_h = 0.2F;
         this.field_70553_i = 0.3F;
         this.field_70551_j = 1.0F;
      } else {
         this.field_70552_h = 1.0F;
         this.field_70553_i = 16.0F / (float)(40 - this.field_70564_aq + 16);
         this.field_70551_j = 4.0F / (float)(40 - this.field_70564_aq + 8);
      }

      this.field_70181_x -= (double)this.field_70545_g;
      if(this.field_70564_aq-- > 0) {
         this.field_70159_w *= 0.02D;
         this.field_70181_x *= 0.02D;
         this.field_70179_y *= 0.02D;
         this.func_70536_a(113);
      } else {
         this.func_70536_a(112);
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9800000190734863D;
      this.field_70181_x *= 0.9800000190734863D;
      this.field_70179_y *= 0.9800000190734863D;
      if(this.field_70547_e-- <= 0) {
         this.func_70106_y();
      }

      if(this.field_70122_E) {
         if(this.field_70563_a == Material.field_76244_g) {
            this.func_70106_y();
            this.field_70170_p.func_72869_a("splash", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
         } else {
            this.func_70536_a(114);
         }

         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

      Material var1 = this.field_70170_p.func_72803_f(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v));
      if(var1.func_76224_d() || var1.func_76220_a()) {
         double var2 = (double)((float)(MathHelper.func_76128_c(this.field_70163_u) + 1) - BlockFluid.func_72199_d(this.field_70170_p.func_72805_g(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))));
         if(this.field_70163_u < var2) {
            this.func_70106_y();
         }
      }

   }
}
