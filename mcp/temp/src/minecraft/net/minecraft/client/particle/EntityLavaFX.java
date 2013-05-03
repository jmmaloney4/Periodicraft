package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityLavaFX extends EntityFX {

   private float field_70586_a;


   public EntityLavaFX(World p_i3169_1_, double p_i3169_2_, double p_i3169_4_, double p_i3169_6_) {
      super(p_i3169_1_, p_i3169_2_, p_i3169_4_, p_i3169_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w *= 0.800000011920929D;
      this.field_70181_x *= 0.800000011920929D;
      this.field_70179_y *= 0.800000011920929D;
      this.field_70181_x = (double)(this.field_70146_Z.nextFloat() * 0.4F + 0.05F);
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70544_f *= this.field_70146_Z.nextFloat() * 2.0F + 0.2F;
      this.field_70586_a = this.field_70544_f;
      this.field_70547_e = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70145_X = false;
      this.func_70536_a(49);
   }

   public int func_70070_b(float p_70070_1_) {
      float var2 = ((float)this.field_70546_d + p_70070_1_) / (float)this.field_70547_e;
      if(var2 < 0.0F) {
         var2 = 0.0F;
      }

      if(var2 > 1.0F) {
         var2 = 1.0F;
      }

      int var3 = super.func_70070_b(p_70070_1_);
      short var4 = 240;
      int var5 = var3 >> 16 & 255;
      return var4 | var5 << 16;
   }

   public float func_70013_c(float p_70013_1_) {
      return 1.0F;
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70546_d + p_70539_2_) / (float)this.field_70547_e;
      this.field_70544_f = this.field_70586_a * (1.0F - var8 * var8);
      super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      float var1 = (float)this.field_70546_d / (float)this.field_70547_e;
      if(this.field_70146_Z.nextFloat() > var1) {
         this.field_70170_p.func_72869_a("smoke", this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y);
      }

      this.field_70181_x -= 0.03D;
      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9990000128746033D;
      this.field_70181_x *= 0.9990000128746033D;
      this.field_70179_y *= 0.9990000128746033D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }
}
