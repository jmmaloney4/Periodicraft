package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelEnderCrystal extends ModelBase {

   private ModelRenderer field_78230_a;
   private ModelRenderer field_78228_b = new ModelRenderer(this, "glass");
   private ModelRenderer field_78229_c;


   public ModelEnderCrystal(float p_i5023_1_, boolean p_i5023_2_) {
      this.field_78228_b.func_78784_a(0, 0).func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      this.field_78230_a = new ModelRenderer(this, "cube");
      this.field_78230_a.func_78784_a(32, 0).func_78789_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      if(p_i5023_2_) {
         this.field_78229_c = new ModelRenderer(this, "base");
         this.field_78229_c.func_78784_a(0, 16).func_78789_a(-6.0F, 0.0F, -6.0F, 12, 4, 12);
      }

   }

   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
      GL11.glPushMatrix();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      GL11.glTranslatef(0.0F, -0.5F, 0.0F);
      if(this.field_78229_c != null) {
         this.field_78229_c.func_78785_a(p_78088_7_);
      }

      GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.8F + p_78088_4_, 0.0F);
      GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
      this.field_78228_b.func_78785_a(p_78088_7_);
      float var8 = 0.875F;
      GL11.glScalef(var8, var8, var8);
      GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
      GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
      this.field_78228_b.func_78785_a(p_78088_7_);
      GL11.glScalef(var8, var8, var8);
      GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
      GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
      this.field_78230_a.func_78785_a(p_78088_7_);
      GL11.glPopMatrix();
   }
}
