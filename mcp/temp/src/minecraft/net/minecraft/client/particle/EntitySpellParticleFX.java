package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntitySpellParticleFX extends EntityFX {

   private int field_70590_a = 128;


   public EntitySpellParticleFX(World p_i3156_1_, double p_i3156_2_, double p_i3156_4_, double p_i3156_6_, double p_i3156_8_, double p_i3156_10_, double p_i3156_12_) {
      super(p_i3156_1_, p_i3156_2_, p_i3156_4_, p_i3156_6_, p_i3156_8_, p_i3156_10_, p_i3156_12_);
      this.field_70181_x *= 0.20000000298023224D;
      if(p_i3156_8_ == 0.0D && p_i3156_12_ == 0.0D) {
         this.field_70159_w *= 0.10000000149011612D;
         this.field_70179_y *= 0.10000000149011612D;
      }

      this.field_70544_f *= 0.75F;
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70145_X = false;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70546_d + p_70539_2_) / (float)this.field_70547_e * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.func_70536_a(this.field_70590_a + (7 - this.field_70546_d * 8 / this.field_70547_e));
      this.field_70181_x += 0.0040D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      if(this.field_70163_u == this.field_70167_r) {
         this.field_70159_w *= 1.1D;
         this.field_70179_y *= 1.1D;
      }

      this.field_70159_w *= 0.9599999785423279D;
      this.field_70181_x *= 0.9599999785423279D;
      this.field_70179_y *= 0.9599999785423279D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }

   public void func_70589_b(int p_70589_1_) {
      this.field_70590_a = p_70589_1_;
   }
}
