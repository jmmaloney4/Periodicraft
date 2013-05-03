package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityEnchantmentTableParticleFX extends EntityFX {

   private float field_70565_a;
   private double field_70568_aq;
   private double field_70567_ar;
   private double field_70566_as;


   public EntityEnchantmentTableParticleFX(World p_i3155_1_, double p_i3155_2_, double p_i3155_4_, double p_i3155_6_, double p_i3155_8_, double p_i3155_10_, double p_i3155_12_) {
      super(p_i3155_1_, p_i3155_2_, p_i3155_4_, p_i3155_6_, p_i3155_8_, p_i3155_10_, p_i3155_12_);
      this.field_70159_w = p_i3155_8_;
      this.field_70181_x = p_i3155_10_;
      this.field_70179_y = p_i3155_12_;
      this.field_70568_aq = this.field_70165_t = p_i3155_2_;
      this.field_70567_ar = this.field_70163_u = p_i3155_4_;
      this.field_70566_as = this.field_70161_v = p_i3155_6_;
      float var14 = this.field_70146_Z.nextFloat() * 0.6F + 0.4F;
      this.field_70565_a = this.field_70544_f = this.field_70146_Z.nextFloat() * 0.5F + 0.2F;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = 1.0F * var14;
      this.field_70553_i *= 0.9F;
      this.field_70552_h *= 0.9F;
      this.field_70547_e = (int)(Math.random() * 10.0D) + 30;
      this.field_70145_X = true;
      this.func_70536_a((int)(Math.random() * 26.0D + 1.0D + 224.0D));
   }

   public int func_70070_b(float p_70070_1_) {
      int var2 = super.func_70070_b(p_70070_1_);
      float var3 = (float)this.field_70546_d / (float)this.field_70547_e;
      var3 *= var3;
      var3 *= var3;
      int var4 = var2 & 255;
      int var5 = var2 >> 16 & 255;
      var5 += (int)(var3 * 15.0F * 16.0F);
      if(var5 > 240) {
         var5 = 240;
      }

      return var4 | var5 << 16;
   }

   public float func_70013_c(float p_70013_1_) {
      float var2 = super.func_70013_c(p_70013_1_);
      float var3 = (float)this.field_70546_d / (float)this.field_70547_e;
      var3 *= var3;
      var3 *= var3;
      return var2 * (1.0F - var3) + var3;
   }

   public void func_70071_h_() {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      float var1 = (float)this.field_70546_d / (float)this.field_70547_e;
      var1 = 1.0F - var1;
      float var2 = 1.0F - var1;
      var2 *= var2;
      var2 *= var2;
      this.field_70165_t = this.field_70568_aq + this.field_70159_w * (double)var1;
      this.field_70163_u = this.field_70567_ar + this.field_70181_x * (double)var1 - (double)(var2 * 1.2F);
      this.field_70161_v = this.field_70566_as + this.field_70179_y * (double)var1;
      if(this.field_70546_d++ >= this.field_70547_e) {
         this.func_70106_y();
      }

   }
}
