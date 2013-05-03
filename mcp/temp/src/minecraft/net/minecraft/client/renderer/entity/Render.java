package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class Render {

   protected RenderManager field_76990_c;
   private ModelBase field_76991_a = new ModelBiped();
   protected RenderBlocks field_76988_d = new RenderBlocks();
   protected float field_76989_e = 0.0F;
   protected float field_76987_f = 1.0F;


   public abstract void func_76986_a(Entity var1, double var2, double var4, double var6, float var8, float var9);

   protected void func_76985_a(String p_76985_1_) {
      this.field_76990_c.field_78724_e.func_98187_b(p_76985_1_);
   }

   protected boolean func_76984_a(String p_76984_1_, String p_76984_2_) {
      RenderEngine var3 = this.field_76990_c.field_78724_e;
      int var4 = var3.func_78350_a(p_76984_1_, p_76984_2_);
      if(var4 >= 0) {
         GL11.glBindTexture(3553, var4);
         var3.func_98185_a();
         return true;
      } else {
         return false;
      }
   }

   private void func_76977_a(Entity p_76977_1_, double p_76977_2_, double p_76977_4_, double p_76977_6_, float p_76977_8_) {
      GL11.glDisable(2896);
      Icon var9 = Block.field_72067_ar.func_94438_c(0);
      Icon var10 = Block.field_72067_ar.func_94438_c(1);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76977_2_, (float)p_76977_4_, (float)p_76977_6_);
      float var11 = p_76977_1_.field_70130_N * 1.4F;
      GL11.glScalef(var11, var11, var11);
      this.func_76985_a("/terrain.png");
      Tessellator var12 = Tessellator.field_78398_a;
      float var13 = 0.5F;
      float var14 = 0.0F;
      float var15 = p_76977_1_.field_70131_O / var11;
      float var16 = (float)(p_76977_1_.field_70163_u - p_76977_1_.field_70121_D.field_72338_b);
      GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.0F, -0.3F + (float)((int)var15) * 0.02F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var17 = 0.0F;
      int var18 = 0;
      var12.func_78382_b();

      while(var15 > 0.0F) {
         Icon var19;
         if(var18 % 2 == 0) {
            var19 = var9;
         } else {
            var19 = var10;
         }

         float var20 = var19.func_94209_e();
         float var21 = var19.func_94206_g();
         float var22 = var19.func_94212_f();
         float var23 = var19.func_94210_h();
         if(var18 / 2 % 2 == 0) {
            float var24 = var22;
            var22 = var20;
            var20 = var24;
         }

         var12.func_78374_a((double)(var13 - var14), (double)(0.0F - var16), (double)var17, (double)var22, (double)var23);
         var12.func_78374_a((double)(-var13 - var14), (double)(0.0F - var16), (double)var17, (double)var20, (double)var23);
         var12.func_78374_a((double)(-var13 - var14), (double)(1.4F - var16), (double)var17, (double)var20, (double)var21);
         var12.func_78374_a((double)(var13 - var14), (double)(1.4F - var16), (double)var17, (double)var22, (double)var21);
         var15 -= 0.45F;
         var16 -= 0.45F;
         var13 *= 0.9F;
         var17 += 0.03F;
         ++var18;
      }

      var12.func_78381_a();
      GL11.glPopMatrix();
      GL11.glEnable(2896);
   }

   private void func_76975_c(Entity p_76975_1_, double p_76975_2_, double p_76975_4_, double p_76975_6_, float p_76975_8_, float p_76975_9_) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      this.field_76990_c.field_78724_e.func_98187_b("%clamp%/misc/shadow.png");
      World var10 = this.func_76982_b();
      GL11.glDepthMask(false);
      float var11 = this.field_76989_e;
      if(p_76975_1_ instanceof EntityLiving) {
         EntityLiving var12 = (EntityLiving)p_76975_1_;
         var11 *= var12.func_70603_bj();
         if(var12.func_70631_g_()) {
            var11 *= 0.5F;
         }
      }

      double var35 = p_76975_1_.field_70142_S + (p_76975_1_.field_70165_t - p_76975_1_.field_70142_S) * (double)p_76975_9_;
      double var14 = p_76975_1_.field_70137_T + (p_76975_1_.field_70163_u - p_76975_1_.field_70137_T) * (double)p_76975_9_ + (double)p_76975_1_.func_70053_R();
      double var16 = p_76975_1_.field_70136_U + (p_76975_1_.field_70161_v - p_76975_1_.field_70136_U) * (double)p_76975_9_;
      int var18 = MathHelper.func_76128_c(var35 - (double)var11);
      int var19 = MathHelper.func_76128_c(var35 + (double)var11);
      int var20 = MathHelper.func_76128_c(var14 - (double)var11);
      int var21 = MathHelper.func_76128_c(var14);
      int var22 = MathHelper.func_76128_c(var16 - (double)var11);
      int var23 = MathHelper.func_76128_c(var16 + (double)var11);
      double var24 = p_76975_2_ - var35;
      double var26 = p_76975_4_ - var14;
      double var28 = p_76975_6_ - var16;
      Tessellator var30 = Tessellator.field_78398_a;
      var30.func_78382_b();

      for(int var31 = var18; var31 <= var19; ++var31) {
         for(int var32 = var20; var32 <= var21; ++var32) {
            for(int var33 = var22; var33 <= var23; ++var33) {
               int var34 = var10.func_72798_a(var31, var32 - 1, var33);
               if(var34 > 0 && var10.func_72957_l(var31, var32, var33) > 3) {
                  this.func_76981_a(Block.field_71973_m[var34], p_76975_2_, p_76975_4_ + (double)p_76975_1_.func_70053_R(), p_76975_6_, var31, var32, var33, p_76975_8_, var11, var24, var26 + (double)p_76975_1_.func_70053_R(), var28);
               }
            }
         }
      }

      var30.func_78381_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glDepthMask(true);
   }

   private World func_76982_b() {
      return this.field_76990_c.field_78722_g;
   }

   private void func_76981_a(Block p_76981_1_, double p_76981_2_, double p_76981_4_, double p_76981_6_, int p_76981_8_, int p_76981_9_, int p_76981_10_, float p_76981_11_, float p_76981_12_, double p_76981_13_, double p_76981_15_, double p_76981_17_) {
      Tessellator var19 = Tessellator.field_78398_a;
      if(p_76981_1_.func_71886_c()) {
         double var20 = ((double)p_76981_11_ - (p_76981_4_ - ((double)p_76981_9_ + p_76981_15_)) / 2.0D) * 0.5D * (double)this.func_76982_b().func_72801_o(p_76981_8_, p_76981_9_, p_76981_10_);
         if(var20 >= 0.0D) {
            if(var20 > 1.0D) {
               var20 = 1.0D;
            }

            var19.func_78369_a(1.0F, 1.0F, 1.0F, (float)var20);
            double var22 = (double)p_76981_8_ + p_76981_1_.func_83009_v() + p_76981_13_;
            double var24 = (double)p_76981_8_ + p_76981_1_.func_83007_w() + p_76981_13_;
            double var26 = (double)p_76981_9_ + p_76981_1_.func_83008_x() + p_76981_15_ + 0.015625D;
            double var28 = (double)p_76981_10_ + p_76981_1_.func_83005_z() + p_76981_17_;
            double var30 = (double)p_76981_10_ + p_76981_1_.func_83006_A() + p_76981_17_;
            float var32 = (float)((p_76981_2_ - var22) / 2.0D / (double)p_76981_12_ + 0.5D);
            float var33 = (float)((p_76981_2_ - var24) / 2.0D / (double)p_76981_12_ + 0.5D);
            float var34 = (float)((p_76981_6_ - var28) / 2.0D / (double)p_76981_12_ + 0.5D);
            float var35 = (float)((p_76981_6_ - var30) / 2.0D / (double)p_76981_12_ + 0.5D);
            var19.func_78374_a(var22, var26, var28, (double)var32, (double)var34);
            var19.func_78374_a(var22, var26, var30, (double)var32, (double)var35);
            var19.func_78374_a(var24, var26, var30, (double)var33, (double)var35);
            var19.func_78374_a(var24, var26, var28, (double)var33, (double)var34);
         }
      }
   }

   public static void func_76978_a(AxisAlignedBB p_76978_0_, double p_76978_1_, double p_76978_3_, double p_76978_5_) {
      GL11.glDisable(3553);
      Tessellator var7 = Tessellator.field_78398_a;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var7.func_78382_b();
      var7.func_78373_b(p_76978_1_, p_76978_3_, p_76978_5_);
      var7.func_78375_b(0.0F, 0.0F, -1.0F);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var7.func_78375_b(0.0F, 0.0F, 1.0F);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var7.func_78375_b(0.0F, -1.0F, 0.0F);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var7.func_78375_b(0.0F, 1.0F, 0.0F);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var7.func_78375_b(-1.0F, 0.0F, 0.0F);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var7.func_78375_b(1.0F, 0.0F, 0.0F);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
      var7.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
      var7.func_78373_b(0.0D, 0.0D, 0.0D);
      var7.func_78381_a();
      GL11.glEnable(3553);
   }

   public static void func_76980_a(AxisAlignedBB p_76980_0_) {
      Tessellator var1 = Tessellator.field_78398_a;
      var1.func_78382_b();
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
      var1.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
      var1.func_78381_a();
   }

   public void func_76976_a(RenderManager p_76976_1_) {
      this.field_76990_c = p_76976_1_;
   }

   public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
      if(this.field_76990_c.field_78733_k.field_74347_j && this.field_76989_e > 0.0F && !p_76979_1_.func_82150_aj()) {
         double var10 = this.field_76990_c.func_78714_a(p_76979_1_.field_70165_t, p_76979_1_.field_70163_u, p_76979_1_.field_70161_v);
         float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.field_76987_f);
         if(var12 > 0.0F) {
            this.func_76975_c(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, var12, p_76979_9_);
         }
      }

      if(p_76979_1_.func_90999_ad()) {
         this.func_76977_a(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_9_);
      }

   }

   public FontRenderer func_76983_a() {
      return this.field_76990_c.func_78716_a();
   }

   public void func_94143_a(IconRegister p_94143_1_) {}
}
