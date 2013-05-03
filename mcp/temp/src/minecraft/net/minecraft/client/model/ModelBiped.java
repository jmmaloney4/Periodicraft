package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelBiped extends ModelBase {

   public ModelRenderer field_78116_c;
   public ModelRenderer field_78114_d;
   public ModelRenderer field_78115_e;
   public ModelRenderer field_78112_f;
   public ModelRenderer field_78113_g;
   public ModelRenderer field_78123_h;
   public ModelRenderer field_78124_i;
   public ModelRenderer field_78121_j;
   public ModelRenderer field_78122_k;
   public int field_78119_l;
   public int field_78120_m;
   public boolean field_78117_n;
   public boolean field_78118_o;


   public ModelBiped() {
      this(0.0F);
   }

   public ModelBiped(float p_i3134_1_) {
      this(p_i3134_1_, 0.0F, 64, 32);
   }

   public ModelBiped(float p_i5021_1_, float p_i5021_2_, int p_i5021_3_, int p_i5021_4_) {
      this.field_78119_l = 0;
      this.field_78120_m = 0;
      this.field_78117_n = false;
      this.field_78118_o = false;
      this.field_78090_t = p_i5021_3_;
      this.field_78089_u = p_i5021_4_;
      this.field_78122_k = new ModelRenderer(this, 0, 0);
      this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, p_i5021_1_);
      this.field_78121_j = new ModelRenderer(this, 24, 0);
      this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, p_i5021_1_);
      this.field_78116_c = new ModelRenderer(this, 0, 0);
      this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i5021_1_);
      this.field_78116_c.func_78793_a(0.0F, 0.0F + p_i5021_2_, 0.0F);
      this.field_78114_d = new ModelRenderer(this, 32, 0);
      this.field_78114_d.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i5021_1_ + 0.5F);
      this.field_78114_d.func_78793_a(0.0F, 0.0F + p_i5021_2_, 0.0F);
      this.field_78115_e = new ModelRenderer(this, 16, 16);
      this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, p_i5021_1_);
      this.field_78115_e.func_78793_a(0.0F, 0.0F + p_i5021_2_, 0.0F);
      this.field_78112_f = new ModelRenderer(this, 40, 16);
      this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, p_i5021_1_);
      this.field_78112_f.func_78793_a(-5.0F, 2.0F + p_i5021_2_, 0.0F);
      this.field_78113_g = new ModelRenderer(this, 40, 16);
      this.field_78113_g.field_78809_i = true;
      this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, p_i5021_1_);
      this.field_78113_g.func_78793_a(5.0F, 2.0F + p_i5021_2_, 0.0F);
      this.field_78123_h = new ModelRenderer(this, 0, 16);
      this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i5021_1_);
      this.field_78123_h.func_78793_a(-1.9F, 12.0F + p_i5021_2_, 0.0F);
      this.field_78124_i = new ModelRenderer(this, 0, 16);
      this.field_78124_i.field_78809_i = true;
      this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i5021_1_);
      this.field_78124_i.func_78793_a(1.9F, 12.0F + p_i5021_2_, 0.0F);
   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
      if(this.field_78091_s) {
         float var8 = 2.0F;
         GL11.glPushMatrix();
         GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
         GL11.glTranslatef(0.0F, 16.0F * p_78088_7_, 0.0F);
         this.field_78116_c.func_78785_a(p_78088_7_);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
         this.field_78115_e.func_78785_a(p_78088_7_);
         this.field_78112_f.func_78785_a(p_78088_7_);
         this.field_78113_g.func_78785_a(p_78088_7_);
         this.field_78123_h.func_78785_a(p_78088_7_);
         this.field_78124_i.func_78785_a(p_78088_7_);
         this.field_78114_d.func_78785_a(p_78088_7_);
         GL11.glPopMatrix();
      } else {
         this.field_78116_c.func_78785_a(p_78088_7_);
         this.field_78115_e.func_78785_a(p_78088_7_);
         this.field_78112_f.func_78785_a(p_78088_7_);
         this.field_78113_g.func_78785_a(p_78088_7_);
         this.field_78123_h.func_78785_a(p_78088_7_);
         this.field_78124_i.func_78785_a(p_78088_7_);
         this.field_78114_d.func_78785_a(p_78088_7_);
      }

   }

   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
      this.field_78116_c.field_78796_g = p_78087_4_ / 57.295776F;
      this.field_78116_c.field_78795_f = p_78087_5_ / 57.295776F;
      this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
      this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
      this.field_78112_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F;
      this.field_78113_g.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
      this.field_78112_f.field_78808_h = 0.0F;
      this.field_78113_g.field_78808_h = 0.0F;
      this.field_78123_h.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
      this.field_78124_i.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_;
      this.field_78123_h.field_78796_g = 0.0F;
      this.field_78124_i.field_78796_g = 0.0F;
      if(this.field_78093_q) {
         this.field_78112_f.field_78795_f += -0.62831855F;
         this.field_78113_g.field_78795_f += -0.62831855F;
         this.field_78123_h.field_78795_f = -1.2566371F;
         this.field_78124_i.field_78795_f = -1.2566371F;
         this.field_78123_h.field_78796_g = 0.31415927F;
         this.field_78124_i.field_78796_g = -0.31415927F;
      }

      if(this.field_78119_l != 0) {
         this.field_78113_g.field_78795_f = this.field_78113_g.field_78795_f * 0.5F - 0.31415927F * (float)this.field_78119_l;
      }

      if(this.field_78120_m != 0) {
         this.field_78112_f.field_78795_f = this.field_78112_f.field_78795_f * 0.5F - 0.31415927F * (float)this.field_78120_m;
      }

      this.field_78112_f.field_78796_g = 0.0F;
      this.field_78113_g.field_78796_g = 0.0F;
      float var8;
      float var9;
      if(this.field_78095_p > -9990.0F) {
         var8 = this.field_78095_p;
         this.field_78115_e.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
         this.field_78112_f.field_78798_e = MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
         this.field_78112_f.field_78800_c = -MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
         this.field_78113_g.field_78798_e = -MathHelper.func_76126_a(this.field_78115_e.field_78796_g) * 5.0F;
         this.field_78113_g.field_78800_c = MathHelper.func_76134_b(this.field_78115_e.field_78796_g) * 5.0F;
         this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g;
         this.field_78113_g.field_78796_g += this.field_78115_e.field_78796_g;
         this.field_78113_g.field_78795_f += this.field_78115_e.field_78796_g;
         var8 = 1.0F - this.field_78095_p;
         var8 *= var8;
         var8 *= var8;
         var8 = 1.0F - var8;
         var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
         float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.field_78116_c.field_78795_f - 0.7F) * 0.75F;
         this.field_78112_f.field_78795_f = (float)((double)this.field_78112_f.field_78795_f - ((double)var9 * 1.2D + (double)var10));
         this.field_78112_f.field_78796_g += this.field_78115_e.field_78796_g * 2.0F;
         this.field_78112_f.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
      }

      if(this.field_78117_n) {
         this.field_78115_e.field_78795_f = 0.5F;
         this.field_78112_f.field_78795_f += 0.4F;
         this.field_78113_g.field_78795_f += 0.4F;
         this.field_78123_h.field_78798_e = 4.0F;
         this.field_78124_i.field_78798_e = 4.0F;
         this.field_78123_h.field_78797_d = 9.0F;
         this.field_78124_i.field_78797_d = 9.0F;
         this.field_78116_c.field_78797_d = 1.0F;
         this.field_78114_d.field_78797_d = 1.0F;
      } else {
         this.field_78115_e.field_78795_f = 0.0F;
         this.field_78123_h.field_78798_e = 0.1F;
         this.field_78124_i.field_78798_e = 0.1F;
         this.field_78123_h.field_78797_d = 12.0F;
         this.field_78124_i.field_78797_d = 12.0F;
         this.field_78116_c.field_78797_d = 0.0F;
         this.field_78114_d.field_78797_d = 0.0F;
      }

      this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
      this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
      if(this.field_78118_o) {
         var8 = 0.0F;
         var9 = 0.0F;
         this.field_78112_f.field_78808_h = 0.0F;
         this.field_78113_g.field_78808_h = 0.0F;
         this.field_78112_f.field_78796_g = -(0.1F - var8 * 0.6F) + this.field_78116_c.field_78796_g;
         this.field_78113_g.field_78796_g = 0.1F - var8 * 0.6F + this.field_78116_c.field_78796_g + 0.4F;
         this.field_78112_f.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
         this.field_78113_g.field_78795_f = -1.5707964F + this.field_78116_c.field_78795_f;
         this.field_78112_f.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
         this.field_78113_g.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
         this.field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
         this.field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
         this.field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
         this.field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
      }

   }

   public void func_78110_b(float p_78110_1_) {
      this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
      this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
      this.field_78121_j.field_78800_c = 0.0F;
      this.field_78121_j.field_78797_d = 0.0F;
      this.field_78121_j.func_78785_a(p_78110_1_);
   }

   public void func_78111_c(float p_78111_1_) {
      this.field_78122_k.func_78785_a(p_78111_1_);
   }
}
