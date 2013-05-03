package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelZombieVillager extends ModelBiped {

   public ModelZombieVillager() {
      this(0.0F, 0.0F, false);
   }

   public ModelZombieVillager(float p_i5020_1_, float p_i5020_2_, boolean p_i5020_3_) {
      super(p_i5020_1_, 0.0F, 64, p_i5020_3_?32:64);
      if(p_i5020_3_) {
         this.field_78116_c = new ModelRenderer(this, 0, 0);
         this.field_78116_c.func_78790_a(-4.0F, -10.0F, -4.0F, 8, 6, 8, p_i5020_1_);
         this.field_78116_c.func_78793_a(0.0F, 0.0F + p_i5020_2_, 0.0F);
      } else {
         this.field_78116_c = new ModelRenderer(this);
         this.field_78116_c.func_78793_a(0.0F, 0.0F + p_i5020_2_, 0.0F);
         this.field_78116_c.func_78784_a(0, 32).func_78790_a(-4.0F, -10.0F, -4.0F, 8, 10, 8, p_i5020_1_);
         this.field_78116_c.func_78784_a(24, 32).func_78790_a(-1.0F, -3.0F, -6.0F, 2, 4, 2, p_i5020_1_);
      }

   }

   public int func_82897_a() {
      return 10;
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
