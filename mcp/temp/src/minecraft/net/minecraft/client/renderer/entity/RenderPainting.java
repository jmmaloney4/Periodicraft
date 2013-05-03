package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.util.EnumArt;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPainting extends Render {

   public void func_77009_a(EntityPainting p_77009_1_, double p_77009_2_, double p_77009_4_, double p_77009_6_, float p_77009_8_, float p_77009_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_77009_2_, (float)p_77009_4_, (float)p_77009_6_);
      GL11.glRotatef(p_77009_8_, 0.0F, 1.0F, 0.0F);
      GL11.glEnable('\u803a');
      this.func_76985_a("/art/kz.png");
      EnumArt var10 = p_77009_1_.field_70522_e;
      float var11 = 0.0625F;
      GL11.glScalef(var11, var11, var11);
      this.func_77010_a(p_77009_1_, var10.field_75703_B, var10.field_75704_C, var10.field_75699_D, var10.field_75700_E);
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   private void func_77010_a(EntityPainting p_77010_1_, int p_77010_2_, int p_77010_3_, int p_77010_4_, int p_77010_5_) {
      float var6 = (float)(-p_77010_2_) / 2.0F;
      float var7 = (float)(-p_77010_3_) / 2.0F;
      float var8 = 0.5F;
      float var9 = 0.75F;
      float var10 = 0.8125F;
      float var11 = 0.0F;
      float var12 = 0.0625F;
      float var13 = 0.75F;
      float var14 = 0.8125F;
      float var15 = 0.001953125F;
      float var16 = 0.001953125F;
      float var17 = 0.7519531F;
      float var18 = 0.7519531F;
      float var19 = 0.0F;
      float var20 = 0.0625F;

      for(int var21 = 0; var21 < p_77010_2_ / 16; ++var21) {
         for(int var22 = 0; var22 < p_77010_3_ / 16; ++var22) {
            float var23 = var6 + (float)((var21 + 1) * 16);
            float var24 = var6 + (float)(var21 * 16);
            float var25 = var7 + (float)((var22 + 1) * 16);
            float var26 = var7 + (float)(var22 * 16);
            this.func_77008_a(p_77010_1_, (var23 + var24) / 2.0F, (var25 + var26) / 2.0F);
            float var27 = (float)(p_77010_4_ + p_77010_2_ - var21 * 16) / 256.0F;
            float var28 = (float)(p_77010_4_ + p_77010_2_ - (var21 + 1) * 16) / 256.0F;
            float var29 = (float)(p_77010_5_ + p_77010_3_ - var22 * 16) / 256.0F;
            float var30 = (float)(p_77010_5_ + p_77010_3_ - (var22 + 1) * 16) / 256.0F;
            Tessellator var31 = Tessellator.field_78398_a;
            var31.func_78382_b();
            var31.func_78375_b(0.0F, 0.0F, -1.0F);
            var31.func_78374_a((double)var23, (double)var26, (double)(-var8), (double)var28, (double)var29);
            var31.func_78374_a((double)var24, (double)var26, (double)(-var8), (double)var27, (double)var29);
            var31.func_78374_a((double)var24, (double)var25, (double)(-var8), (double)var27, (double)var30);
            var31.func_78374_a((double)var23, (double)var25, (double)(-var8), (double)var28, (double)var30);
            var31.func_78375_b(0.0F, 0.0F, 1.0F);
            var31.func_78374_a((double)var23, (double)var25, (double)var8, (double)var9, (double)var11);
            var31.func_78374_a((double)var24, (double)var25, (double)var8, (double)var10, (double)var11);
            var31.func_78374_a((double)var24, (double)var26, (double)var8, (double)var10, (double)var12);
            var31.func_78374_a((double)var23, (double)var26, (double)var8, (double)var9, (double)var12);
            var31.func_78375_b(0.0F, 1.0F, 0.0F);
            var31.func_78374_a((double)var23, (double)var25, (double)(-var8), (double)var13, (double)var15);
            var31.func_78374_a((double)var24, (double)var25, (double)(-var8), (double)var14, (double)var15);
            var31.func_78374_a((double)var24, (double)var25, (double)var8, (double)var14, (double)var16);
            var31.func_78374_a((double)var23, (double)var25, (double)var8, (double)var13, (double)var16);
            var31.func_78375_b(0.0F, -1.0F, 0.0F);
            var31.func_78374_a((double)var23, (double)var26, (double)var8, (double)var13, (double)var15);
            var31.func_78374_a((double)var24, (double)var26, (double)var8, (double)var14, (double)var15);
            var31.func_78374_a((double)var24, (double)var26, (double)(-var8), (double)var14, (double)var16);
            var31.func_78374_a((double)var23, (double)var26, (double)(-var8), (double)var13, (double)var16);
            var31.func_78375_b(-1.0F, 0.0F, 0.0F);
            var31.func_78374_a((double)var23, (double)var25, (double)var8, (double)var18, (double)var19);
            var31.func_78374_a((double)var23, (double)var26, (double)var8, (double)var18, (double)var20);
            var31.func_78374_a((double)var23, (double)var26, (double)(-var8), (double)var17, (double)var20);
            var31.func_78374_a((double)var23, (double)var25, (double)(-var8), (double)var17, (double)var19);
            var31.func_78375_b(1.0F, 0.0F, 0.0F);
            var31.func_78374_a((double)var24, (double)var25, (double)(-var8), (double)var18, (double)var19);
            var31.func_78374_a((double)var24, (double)var26, (double)(-var8), (double)var18, (double)var20);
            var31.func_78374_a((double)var24, (double)var26, (double)var8, (double)var17, (double)var20);
            var31.func_78374_a((double)var24, (double)var25, (double)var8, (double)var17, (double)var19);
            var31.func_78381_a();
         }
      }

   }

   private void func_77008_a(EntityPainting p_77008_1_, float p_77008_2_, float p_77008_3_) {
      int var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t);
      int var5 = MathHelper.func_76128_c(p_77008_1_.field_70163_u + (double)(p_77008_3_ / 16.0F));
      int var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v);
      if(p_77008_1_.field_82332_a == 2) {
         var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t + (double)(p_77008_2_ / 16.0F));
      }

      if(p_77008_1_.field_82332_a == 1) {
         var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v - (double)(p_77008_2_ / 16.0F));
      }

      if(p_77008_1_.field_82332_a == 0) {
         var4 = MathHelper.func_76128_c(p_77008_1_.field_70165_t - (double)(p_77008_2_ / 16.0F));
      }

      if(p_77008_1_.field_82332_a == 3) {
         var6 = MathHelper.func_76128_c(p_77008_1_.field_70161_v + (double)(p_77008_2_ / 16.0F));
      }

      int var7 = this.field_76990_c.field_78722_g.func_72802_i(var4, var5, var6, 0);
      int var8 = var7 % 65536;
      int var9 = var7 / 65536;
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var8, (float)var9);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77009_a((EntityPainting)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
