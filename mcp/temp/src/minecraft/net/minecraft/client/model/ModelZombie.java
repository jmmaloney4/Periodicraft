package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelZombie extends ModelBiped {

   public ModelZombie() {
      this(0.0F, false);
   }

   protected ModelZombie(float p_i5017_1_, float p_i5017_2_, int p_i5017_3_, int p_i5017_4_) {
      super(p_i5017_1_, p_i5017_2_, p_i5017_3_, p_i5017_4_);
   }

   public ModelZombie(float p_i5018_1_, boolean p_i5018_2_) {
      super(p_i5018_1_, 0.0F, 64, p_i5018_2_?32:64);
   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
      float var8 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F);
      float var9 = MathHelper.func_76126_a((1.0F - (1.0F - this.field_78095_p) * (1.0F - this.field_78095_p)) * 3.1415927F);
      this.field_78112_f.field_78808_h = 0.0F;
      this.field_78113_g.field_78808_h = 0.0F;
      this.field_78112_f.field_78796_g = -(0.1F - var8 * 0.6F);
      this.field_78113_g.field_78796_g = 0.1F - var8 * 0.6F;
      this.field_78112_f.field_78795_f = -1.5707964F;
      this.field_78113_g.field_78795_f = -1.5707964F;
      this.field_78112_f.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
      this.field_78113_g.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
      this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
      this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
   }
}
