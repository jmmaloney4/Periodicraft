package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;

@SideOnly(Side.CLIENT)
public class ModelSkeleton extends ModelZombie {

   public ModelSkeleton() {
      this(0.0F);
   }

   public ModelSkeleton(float p_i5016_1_) {
      super(p_i5016_1_, 0.0F, 64, 32);
      this.field_78112_f = new ModelRenderer(this, 40, 16);
      this.field_78112_f.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i5016_1_);
      this.field_78112_f.func_78793_a(-5.0F, 2.0F, 0.0F);
      this.field_78113_g = new ModelRenderer(this, 40, 16);
      this.field_78113_g.field_78809_i = true;
      this.field_78113_g.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, p_i5016_1_);
      this.field_78113_g.func_78793_a(5.0F, 2.0F, 0.0F);
      this.field_78123_h = new ModelRenderer(this, 0, 16);
      this.field_78123_h.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i5016_1_);
      this.field_78123_h.func_78793_a(-2.0F, 12.0F, 0.0F);
      this.field_78124_i = new ModelRenderer(this, 0, 16);
      this.field_78124_i.field_78809_i = true;
      this.field_78124_i.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, p_i5016_1_);
      this.field_78124_i.func_78793_a(2.0F, 12.0F, 0.0F);
   }

   public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
      this.field_78118_o = ((EntitySkeleton)p_78086_1_).func_82202_m() == 1;
      super.func_78086_a(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
   }
}
