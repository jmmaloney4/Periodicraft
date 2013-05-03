package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityFlameFX extends EntityFX {

   private float field_70562_a;


   public EntityFlameFX(World p_i3150_1_, double p_i3150_2_, double p_i3150_4_, double p_i3150_6_, double p_i3150_8_, double p_i3150_10_, double p_i3150_12_) {
      super(p_i3150_1_, p_i3150_2_, p_i3150_4_, p_i3150_6_, p_i3150_8_, p_i3150_10_, p_i3150_12_);
      this.field_70159_w = this.field_70159_w * 0.009999999776482582D + p_i3150_8_;
      this.field_70181_x = this.field_70181_x * 0.009999999776482582D + p_i3150_10_;
      this.field_70179_y = this.field_70179_y * 0.009999999776482582D + p_i3150_12_;
      double var10000 = p_i3150_2_ + (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
      var10000 = p_i3150_4_ + (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
      var10000 = p_i3150_6_ + (double)((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.05F);
      this.field_70562_a = this.field_70544_f;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F;
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
      this.field_70145_X = true;
      this.func_70536_a(48);
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70546_d + p_70539_2_) / (float)this.field_70547_e;
      this.field_70544_f = this.field_70562_a * (1.0F - var8 * var8 * 0.5F);
      super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
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
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if(var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public float func_70013_c(float p_70013_1_) {
      float var2 = ((float)this.field_70546_d + p_70013_1_) / (float)this.field_70547_e;
      if(var2 < 0.0F) {
         var2 = 0.0F;
      }

      if(var2 > 1.0F) {
         var2 = 1.0F;
      }

      float var3 = super.func_70013_c(p_70013_1_);
      return var3 * var2 + (1.0F - var2);
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

      this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      this.field_70159_w *= 0.9599999785423279D;
      this.field_70181_x *= 0.9599999785423279D;
      this.field_70179_y *= 0.9599999785423279D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }
}
