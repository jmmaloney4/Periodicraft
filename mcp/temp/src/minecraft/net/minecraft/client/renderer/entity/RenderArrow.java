package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderArrow extends Render {

   public void func_76999_a(EntityArrow p_76999_1_, double p_76999_2_, double p_76999_4_, double p_76999_6_, float p_76999_8_, float p_76999_9_) {
      this.func_76985_a("/item/arrows.png");
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76999_2_, (float)p_76999_4_, (float)p_76999_6_);
      GL11.glRotatef(p_76999_1_.field_70126_B + (p_76999_1_.field_70177_z - p_76999_1_.field_70126_B) * p_76999_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(p_76999_1_.field_70127_C + (p_76999_1_.field_70125_A - p_76999_1_.field_70127_C) * p_76999_9_, 0.0F, 0.0F, 1.0F);
      Tessellator var10 = Tessellator.field_78398_a;
      byte var11 = 0;
      float var12 = 0.0F;
      float var13 = 0.5F;
      float var14 = (float)(0 + var11 * 10) / 32.0F;
      float var15 = (float)(5 + var11 * 10) / 32.0F;
      float var16 = 0.0F;
      float var17 = 0.15625F;
      float var18 = (float)(5 + var11 * 10) / 32.0F;
      float var19 = (float)(10 + var11 * 10) / 32.0F;
      float var20 = 0.05625F;
      GL11.glEnable('\u803a');
      float var21 = (float)p_76999_1_.field_70249_b - p_76999_9_;
      if(var21 > 0.0F) {
         float var22 = -MathHelper.func_76126_a(var21 * 3.0F) * var21;
         GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
      }

      GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
      GL11.glScalef(var20, var20, var20);
      GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
      GL11.glNormal3f(var20, 0.0F, 0.0F);
      var10.func_78382_b();
      var10.func_78374_a(-7.0D, -2.0D, -2.0D, (double)var16, (double)var18);
      var10.func_78374_a(-7.0D, -2.0D, 2.0D, (double)var17, (double)var18);
      var10.func_78374_a(-7.0D, 2.0D, 2.0D, (double)var17, (double)var19);
      var10.func_78374_a(-7.0D, 2.0D, -2.0D, (double)var16, (double)var19);
      var10.func_78381_a();
      GL11.glNormal3f(-var20, 0.0F, 0.0F);
      var10.func_78382_b();
      var10.func_78374_a(-7.0D, 2.0D, -2.0D, (double)var16, (double)var18);
      var10.func_78374_a(-7.0D, 2.0D, 2.0D, (double)var17, (double)var18);
      var10.func_78374_a(-7.0D, -2.0D, 2.0D, (double)var17, (double)var19);
      var10.func_78374_a(-7.0D, -2.0D, -2.0D, (double)var16, (double)var19);
      var10.func_78381_a();

      for(int var23 = 0; var23 < 4; ++var23) {
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glNormal3f(0.0F, 0.0F, var20);
         var10.func_78382_b();
         var10.func_78374_a(-8.0D, -2.0D, 0.0D, (double)var12, (double)var14);
         var10.func_78374_a(8.0D, -2.0D, 0.0D, (double)var13, (double)var14);
         var10.func_78374_a(8.0D, 2.0D, 0.0D, (double)var13, (double)var15);
         var10.func_78374_a(-8.0D, 2.0D, 0.0D, (double)var12, (double)var15);
         var10.func_78381_a();
      }

      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76999_a((EntityArrow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
