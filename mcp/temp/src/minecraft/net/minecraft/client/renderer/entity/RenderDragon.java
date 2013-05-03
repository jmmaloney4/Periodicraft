package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderDragon extends RenderLiving {

   private static int field_77086_i = 0;
   protected ModelDragon field_77084_b;


   public RenderDragon() {
      super(new ModelDragon(0.0F), 0.5F);
      this.field_77084_b = (ModelDragon)this.field_77045_g;
      this.func_77042_a(this.field_77045_g);
   }

   protected void func_77083_a(EntityDragon p_77083_1_, float p_77083_2_, float p_77083_3_, float p_77083_4_) {
      float var5 = (float)p_77083_1_.func_70974_a(7, p_77083_4_)[0];
      float var6 = (float)(p_77083_1_.func_70974_a(5, p_77083_4_)[1] - p_77083_1_.func_70974_a(10, p_77083_4_)[1]);
      GL11.glRotatef(-var5, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(var6 * 10.0F, 1.0F, 0.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.0F, 1.0F);
      if(p_77083_1_.field_70725_aQ > 0) {
         float var7 = ((float)p_77083_1_.field_70725_aQ + p_77083_4_ - 1.0F) / 20.0F * 1.6F;
         var7 = MathHelper.func_76129_c(var7);
         if(var7 > 1.0F) {
            var7 = 1.0F;
         }

         GL11.glRotatef(var7 * this.func_77037_a(p_77083_1_), 0.0F, 0.0F, 1.0F);
      }

   }

   protected void func_77081_a(EntityDragon p_77081_1_, float p_77081_2_, float p_77081_3_, float p_77081_4_, float p_77081_5_, float p_77081_6_, float p_77081_7_) {
      if(p_77081_1_.field_70995_bG > 0) {
         float var8 = (float)p_77081_1_.field_70995_bG / 200.0F;
         GL11.glDepthFunc(515);
         GL11.glEnable(3008);
         GL11.glAlphaFunc(516, var8);
         this.func_76985_a("/mob/enderdragon/shuffle.png");
         this.field_77045_g.func_78088_a(p_77081_1_, p_77081_2_, p_77081_3_, p_77081_4_, p_77081_5_, p_77081_6_, p_77081_7_);
         GL11.glAlphaFunc(516, 0.1F);
         GL11.glDepthFunc(514);
      }

      this.func_76985_a(p_77081_1_.func_70073_O());
      this.field_77045_g.func_78088_a(p_77081_1_, p_77081_2_, p_77081_3_, p_77081_4_, p_77081_5_, p_77081_6_, p_77081_7_);
      if(p_77081_1_.field_70737_aN > 0) {
         GL11.glDepthFunc(514);
         GL11.glDisable(3553);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
         this.field_77045_g.func_78088_a(p_77081_1_, p_77081_2_, p_77081_3_, p_77081_4_, p_77081_5_, p_77081_6_, p_77081_7_);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
         GL11.glDepthFunc(515);
      }

   }

   public void func_77079_a(EntityDragon p_77079_1_, double p_77079_2_, double p_77079_4_, double p_77079_6_, float p_77079_8_, float p_77079_9_) {
      BossStatus.func_82824_a(p_77079_1_, false);
      if(field_77086_i != 4) {
         this.field_77045_g = new ModelDragon(0.0F);
         field_77086_i = 4;
      }

      super.func_77031_a(p_77079_1_, p_77079_2_, p_77079_4_, p_77079_6_, p_77079_8_, p_77079_9_);
      if(p_77079_1_.field_70992_bH != null) {
         float var10 = (float)p_77079_1_.field_70992_bH.field_70261_a + p_77079_9_;
         float var11 = MathHelper.func_76126_a(var10 * 0.2F) / 2.0F + 0.5F;
         var11 = (var11 * var11 + var11) * 0.2F;
         float var12 = (float)(p_77079_1_.field_70992_bH.field_70165_t - p_77079_1_.field_70165_t - (p_77079_1_.field_70169_q - p_77079_1_.field_70165_t) * (double)(1.0F - p_77079_9_));
         float var13 = (float)((double)var11 + p_77079_1_.field_70992_bH.field_70163_u - 1.0D - p_77079_1_.field_70163_u - (p_77079_1_.field_70167_r - p_77079_1_.field_70163_u) * (double)(1.0F - p_77079_9_));
         float var14 = (float)(p_77079_1_.field_70992_bH.field_70161_v - p_77079_1_.field_70161_v - (p_77079_1_.field_70166_s - p_77079_1_.field_70161_v) * (double)(1.0F - p_77079_9_));
         float var15 = MathHelper.func_76129_c(var12 * var12 + var14 * var14);
         float var16 = MathHelper.func_76129_c(var12 * var12 + var13 * var13 + var14 * var14);
         GL11.glPushMatrix();
         GL11.glTranslatef((float)p_77079_2_, (float)p_77079_4_ + 2.0F, (float)p_77079_6_);
         GL11.glRotatef((float)(-Math.atan2((double)var14, (double)var12)) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(-Math.atan2((double)var15, (double)var13)) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
         Tessellator var17 = Tessellator.field_78398_a;
         RenderHelper.func_74518_a();
         GL11.glDisable(2884);
         this.func_76985_a("/mob/enderdragon/beam.png");
         GL11.glShadeModel(7425);
         float var18 = 0.0F - ((float)p_77079_1_.field_70173_aa + p_77079_9_) * 0.01F;
         float var19 = MathHelper.func_76129_c(var12 * var12 + var13 * var13 + var14 * var14) / 32.0F - ((float)p_77079_1_.field_70173_aa + p_77079_9_) * 0.01F;
         var17.func_78371_b(5);
         byte var20 = 8;

         for(int var21 = 0; var21 <= var20; ++var21) {
            float var22 = MathHelper.func_76126_a((float)(var21 % var20) * 3.1415927F * 2.0F / (float)var20) * 0.75F;
            float var23 = MathHelper.func_76134_b((float)(var21 % var20) * 3.1415927F * 2.0F / (float)var20) * 0.75F;
            float var24 = (float)(var21 % var20) * 1.0F / (float)var20;
            var17.func_78378_d(0);
            var17.func_78374_a((double)(var22 * 0.2F), (double)(var23 * 0.2F), 0.0D, (double)var24, (double)var19);
            var17.func_78378_d(16777215);
            var17.func_78374_a((double)var22, (double)var23, (double)var16, (double)var24, (double)var18);
         }

         var17.func_78381_a();
         GL11.glEnable(2884);
         GL11.glShadeModel(7424);
         RenderHelper.func_74519_b();
         GL11.glPopMatrix();
      }

   }

   protected void func_77080_a(EntityDragon p_77080_1_, float p_77080_2_) {
      super.func_77029_c(p_77080_1_, p_77080_2_);
      Tessellator var3 = Tessellator.field_78398_a;
      if(p_77080_1_.field_70995_bG > 0) {
         RenderHelper.func_74518_a();
         float var4 = ((float)p_77080_1_.field_70995_bG + p_77080_2_) / 200.0F;
         float var5 = 0.0F;
         if(var4 > 0.8F) {
            var5 = (var4 - 0.8F) / 0.2F;
         }

         Random var6 = new Random(432L);
         GL11.glDisable(3553);
         GL11.glShadeModel(7425);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(3008);
         GL11.glEnable(2884);
         GL11.glDepthMask(false);
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, -1.0F, -2.0F);

         for(int var7 = 0; (float)var7 < (var4 + var4 * var4) / 2.0F * 60.0F; ++var7) {
            GL11.glRotatef(var6.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F + var4 * 90.0F, 0.0F, 0.0F, 1.0F);
            var3.func_78371_b(6);
            float var8 = var6.nextFloat() * 20.0F + 5.0F + var5 * 10.0F;
            float var9 = var6.nextFloat() * 2.0F + 1.0F + var5 * 2.0F;
            var3.func_78384_a(16777215, (int)(255.0F * (1.0F - var5)));
            var3.func_78377_a(0.0D, 0.0D, 0.0D);
            var3.func_78384_a(16711935, 0);
            var3.func_78377_a(-0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
            var3.func_78377_a(0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
            var3.func_78377_a(0.0D, (double)var8, (double)(1.0F * var9));
            var3.func_78377_a(-0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
            var3.func_78381_a();
         }

         GL11.glPopMatrix();
         GL11.glDepthMask(true);
         GL11.glDisable(2884);
         GL11.glDisable(3042);
         GL11.glShadeModel(7424);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glEnable(3553);
         GL11.glEnable(3008);
         RenderHelper.func_74519_b();
      }

   }

   protected int func_77082_a(EntityDragon p_77082_1_, int p_77082_2_, float p_77082_3_) {
      if(p_77082_2_ == 1) {
         GL11.glDepthFunc(515);
      }

      if(p_77082_2_ != 0) {
         return -1;
      } else {
         this.func_76985_a("/mob/enderdragon/ender_eyes.png");
         float var4 = 1.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3008);
         GL11.glBlendFunc(1, 1);
         GL11.glDisable(2896);
         GL11.glDepthFunc(514);
         char var5 = '\uf0f0';
         int var6 = var5 % 65536;
         int var7 = var5 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glEnable(2896);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
         return 1;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77082_a((EntityDragon)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      this.func_77080_a((EntityDragon)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77083_a((EntityDragon)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77036_a(EntityLiving p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
      this.func_77081_a((EntityDragon)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77079_a((EntityDragon)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77079_a((EntityDragon)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
