package net.minecraft.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityCritFX extends EntityFX {

   float field_70561_a;


   public EntityCritFX(World p_i3182_1_, double p_i3182_2_, double p_i3182_4_, double p_i3182_6_, double p_i3182_8_, double p_i3182_10_, double p_i3182_12_) {
      this(p_i3182_1_, p_i3182_2_, p_i3182_4_, p_i3182_6_, p_i3182_8_, p_i3182_10_, p_i3182_12_, 1.0F);
   }

   public EntityCritFX(World p_i3183_1_, double p_i3183_2_, double p_i3183_4_, double p_i3183_6_, double p_i3183_8_, double p_i3183_10_, double p_i3183_12_, float p_i3183_14_) {
      super(p_i3183_1_, p_i3183_2_, p_i3183_4_, p_i3183_6_, 0.0D, 0.0D, 0.0D);
      this.field_70159_w *= 0.10000000149011612D;
      this.field_70181_x *= 0.10000000149011612D;
      this.field_70179_y *= 0.10000000149011612D;
      this.field_70159_w += p_i3183_8_ * 0.4D;
      this.field_70181_x += p_i3183_10_ * 0.4D;
      this.field_70179_y += p_i3183_12_ * 0.4D;
      this.field_70552_h = this.field_70553_i = this.field_70551_j = (float)(Math.random() * 0.30000001192092896D + 0.6000000238418579D);
      this.field_70544_f *= 0.75F;
      this.field_70544_f *= p_i3183_14_;
      this.field_70561_a = this.field_70544_f;
      this.field_70547_e = (int)(6.0D / (Math.random() * 0.8D + 0.6D));
      this.field_70547_e = (int)((float)this.field_70547_e * p_i3183_14_);
      this.field_70145_X = false;
      this.func_70536_a(65);
      this.func_70071_h_();
   }

   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
      float var8 = ((float)this.field_70546_d + p_70539_2_) / (float)this.field_70547_e * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_70544_f = this.field_70561_a * var8;
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
      this.field_70553_i = (float)((double)this.field_70553_i * 0.96D);
      this.field_70551_j = (float)((double)this.field_70551_j * 0.9D);
      this.field_70159_w *= 0.699999988079071D;
      this.field_70181_x *= 0.699999988079071D;
      this.field_70179_y *= 0.699999988079071D;
      this.field_70181_x -= 0.019999999552965164D;
      if(this.field_70122_E) {
         this.field_70159_w *= 0.699999988079071D;
         this.field_70179_y *= 0.699999988079071D;
      }

   }
}
