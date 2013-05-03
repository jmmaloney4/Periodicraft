package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderItem extends Render {

   private RenderBlocks field_77022_g = new RenderBlocks();
   private Random field_77025_h = new Random();
   public boolean field_77024_a = true;
   public float field_77023_b = 0.0F;
   public static boolean field_82407_g = false;


   public RenderItem() {
      this.field_76989_e = 0.15F;
      this.field_76987_f = 0.75F;
   }

   public void func_77014_a(EntityItem p_77014_1_, double p_77014_2_, double p_77014_4_, double p_77014_6_, float p_77014_8_, float p_77014_9_) {
      this.field_77025_h.setSeed(187L);
      ItemStack var10 = p_77014_1_.func_92059_d();
      if(var10.func_77973_b() != null) {
         GL11.glPushMatrix();
         float var11 = MathHelper.func_76126_a(((float)p_77014_1_.field_70292_b + p_77014_9_) / 10.0F + p_77014_1_.field_70290_d) * 0.1F + 0.1F;
         float var12 = (((float)p_77014_1_.field_70292_b + p_77014_9_) / 20.0F + p_77014_1_.field_70290_d) * 57.295776F;
         byte var13 = 1;
         if(p_77014_1_.func_92059_d().field_77994_a > 1) {
            var13 = 2;
         }

         if(p_77014_1_.func_92059_d().field_77994_a > 5) {
            var13 = 3;
         }

         if(p_77014_1_.func_92059_d().field_77994_a > 20) {
            var13 = 4;
         }

         if(p_77014_1_.func_92059_d().field_77994_a > 40) {
            var13 = 5;
         }

         GL11.glTranslatef((float)p_77014_2_, (float)p_77014_4_ + var11, (float)p_77014_6_);
         GL11.glEnable('\u803a');
         int var17;
         float var19;
         float var18;
         float var20;
         if(var10.func_94608_d() == 0 && Block.field_71973_m[var10.field_77993_c] != null && RenderBlocks.func_78597_b(Block.field_71973_m[var10.field_77993_c].func_71857_b())) {
            Block var21 = Block.field_71973_m[var10.field_77993_c];
            GL11.glRotatef(var12, 0.0F, 1.0F, 0.0F);
            if(field_82407_g) {
               GL11.glScalef(1.25F, 1.25F, 1.25F);
               GL11.glTranslatef(0.0F, 0.05F, 0.0F);
               GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            this.func_76985_a("/terrain.png");
            float var25 = 0.25F;
            int var24 = var21.func_71857_b();
            if(var24 == 1 || var24 == 19 || var24 == 12 || var24 == 2) {
               var25 = 0.5F;
            }

            GL11.glScalef(var25, var25, var25);

            for(var17 = 0; var17 < var13; ++var17) {
               GL11.glPushMatrix();
               if(var17 > 0) {
                  var18 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / var25;
                  var19 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / var25;
                  var20 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / var25;
                  GL11.glTranslatef(var18, var19, var20);
               }

               var18 = 1.0F;
               this.field_77022_g.func_78600_a(var21, var10.func_77960_j(), var18);
               GL11.glPopMatrix();
            }
         } else {
            float var16;
            if(var10.func_77973_b().func_77623_v()) {
               if(field_82407_g) {
                  GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
                  GL11.glTranslatef(0.0F, -0.05F, 0.0F);
               } else {
                  GL11.glScalef(0.5F, 0.5F, 0.5F);
               }

               this.func_76985_a("/gui/items.png");

               for(int var14 = 0; var14 <= 1; ++var14) {
                  this.field_77025_h.setSeed(187L);
                  Icon var15 = var10.func_77973_b().func_77618_c(var10.func_77960_j(), var14);
                  var16 = 1.0F;
                  if(this.field_77024_a) {
                     var17 = Item.field_77698_e[var10.field_77993_c].func_82790_a(var10, var14);
                     var18 = (float)(var17 >> 16 & 255) / 255.0F;
                     var19 = (float)(var17 >> 8 & 255) / 255.0F;
                     var20 = (float)(var17 & 255) / 255.0F;
                     GL11.glColor4f(var18 * var16, var19 * var16, var20 * var16, 1.0F);
                     this.func_77020_a(p_77014_1_, var15, var13, p_77014_9_, var18 * var16, var19 * var16, var20 * var16);
                  } else {
                     this.func_77020_a(p_77014_1_, var15, var13, p_77014_9_, 1.0F, 1.0F, 1.0F);
                  }
               }
            } else {
               if(field_82407_g) {
                  GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
                  GL11.glTranslatef(0.0F, -0.05F, 0.0F);
               } else {
                  GL11.glScalef(0.5F, 0.5F, 0.5F);
               }

               Icon var23 = var10.func_77954_c();
               if(var10.func_94608_d() == 0) {
                  this.func_76985_a("/terrain.png");
               } else {
                  this.func_76985_a("/gui/items.png");
               }

               if(this.field_77024_a) {
                  int var22 = Item.field_77698_e[var10.field_77993_c].func_82790_a(var10, 0);
                  var16 = (float)(var22 >> 16 & 255) / 255.0F;
                  float var26 = (float)(var22 >> 8 & 255) / 255.0F;
                  var18 = (float)(var22 & 255) / 255.0F;
                  var19 = 1.0F;
                  this.func_77020_a(p_77014_1_, var23, var13, p_77014_9_, var16 * var19, var26 * var19, var18 * var19);
               } else {
                  this.func_77020_a(p_77014_1_, var23, var13, p_77014_9_, 1.0F, 1.0F, 1.0F);
               }
            }
         }

         GL11.glDisable('\u803a');
         GL11.glPopMatrix();
      }
   }

   private void func_77020_a(EntityItem p_77020_1_, Icon p_77020_2_, int p_77020_3_, float p_77020_4_, float p_77020_5_, float p_77020_6_, float p_77020_7_) {
      Tessellator var8 = Tessellator.field_78398_a;
      if(p_77020_2_ == null) {
         p_77020_2_ = this.field_76990_c.field_78724_e.func_96448_c(p_77020_1_.func_92059_d().func_94608_d());
      }

      float var9 = p_77020_2_.func_94209_e();
      float var10 = p_77020_2_.func_94212_f();
      float var11 = p_77020_2_.func_94206_g();
      float var12 = p_77020_2_.func_94210_h();
      float var13 = 1.0F;
      float var14 = 0.5F;
      float var15 = 0.25F;
      float var17;
      if(this.field_76990_c.field_78733_k.field_74347_j) {
         GL11.glPushMatrix();
         if(field_82407_g) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         } else {
            GL11.glRotatef((((float)p_77020_1_.field_70292_b + p_77020_4_) / 20.0F + p_77020_1_.field_70290_d) * 57.295776F, 0.0F, 1.0F, 0.0F);
         }

         float var16 = 0.0625F;
         var17 = 0.021875F;
         ItemStack var18 = p_77020_1_.func_92059_d();
         int var19 = var18.field_77994_a;
         byte var24;
         if(var19 < 2) {
            var24 = 1;
         } else if(var19 < 16) {
            var24 = 2;
         } else if(var19 < 32) {
            var24 = 3;
         } else {
            var24 = 4;
         }

         GL11.glTranslatef(-var14, -var15, -((var16 + var17) * (float)var24 / 2.0F));

         for(int var20 = 0; var20 < var24; ++var20) {
            GL11.glTranslatef(0.0F, 0.0F, var16 + var17);
            if(var18.func_94608_d() == 0 && Block.field_71973_m[var18.field_77993_c] != null) {
               this.func_76985_a("/terrain.png");
            } else {
               this.func_76985_a("/gui/items.png");
            }

            GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
            ItemRenderer.func_78439_a(var8, var10, var11, var9, var12, p_77020_2_.func_94213_j(), p_77020_2_.func_94208_k(), var16);
            if(var18 != null && var18.func_77962_s()) {
               GL11.glDepthFunc(514);
               GL11.glDisable(2896);
               this.field_76990_c.field_78724_e.func_98187_b("%blur%/misc/glint.png");
               GL11.glEnable(3042);
               GL11.glBlendFunc(768, 1);
               float var21 = 0.76F;
               GL11.glColor4f(0.5F * var21, 0.25F * var21, 0.8F * var21, 1.0F);
               GL11.glMatrixMode(5890);
               GL11.glPushMatrix();
               float var22 = 0.125F;
               GL11.glScalef(var22, var22, var22);
               float var23 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
               GL11.glTranslatef(var23, 0.0F, 0.0F);
               GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
               ItemRenderer.func_78439_a(var8, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, var16);
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glScalef(var22, var22, var22);
               var23 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
               GL11.glTranslatef(-var23, 0.0F, 0.0F);
               GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
               ItemRenderer.func_78439_a(var8, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, var16);
               GL11.glPopMatrix();
               GL11.glMatrixMode(5888);
               GL11.glDisable(3042);
               GL11.glEnable(2896);
               GL11.glDepthFunc(515);
            }
         }

         GL11.glPopMatrix();
      } else {
         for(int var25 = 0; var25 < p_77020_3_; ++var25) {
            GL11.glPushMatrix();
            if(var25 > 0) {
               var17 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
               float var27 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
               float var26 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
               GL11.glTranslatef(var17, var27, var26);
            }

            if(!field_82407_g) {
               GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
            }

            GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
            var8.func_78382_b();
            var8.func_78375_b(0.0F, 1.0F, 0.0F);
            var8.func_78374_a((double)(0.0F - var14), (double)(0.0F - var15), 0.0D, (double)var9, (double)var12);
            var8.func_78374_a((double)(var13 - var14), (double)(0.0F - var15), 0.0D, (double)var10, (double)var12);
            var8.func_78374_a((double)(var13 - var14), (double)(1.0F - var15), 0.0D, (double)var10, (double)var11);
            var8.func_78374_a((double)(0.0F - var14), (double)(1.0F - var15), 0.0D, (double)var9, (double)var11);
            var8.func_78381_a();
            GL11.glPopMatrix();
         }
      }

   }

   public void func_77015_a(FontRenderer p_77015_1_, RenderEngine p_77015_2_, ItemStack p_77015_3_, int p_77015_4_, int p_77015_5_) {
      int var6 = p_77015_3_.field_77993_c;
      int var7 = p_77015_3_.func_77960_j();
      Icon var8 = p_77015_3_.func_77954_c();
      float var12;
      float var13;
      float var16;
      if(p_77015_3_.func_94608_d() == 0 && RenderBlocks.func_78597_b(Block.field_71973_m[var6].func_71857_b())) {
         p_77015_2_.func_98187_b("/terrain.png");
         Block var15 = Block.field_71973_m[var6];
         GL11.glPushMatrix();
         GL11.glTranslatef((float)(p_77015_4_ - 2), (float)(p_77015_5_ + 3), -3.0F + this.field_77023_b);
         GL11.glScalef(10.0F, 10.0F, 10.0F);
         GL11.glTranslatef(1.0F, 0.5F, 1.0F);
         GL11.glScalef(1.0F, 1.0F, -1.0F);
         GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         int var18 = Item.field_77698_e[var6].func_82790_a(p_77015_3_, 0);
         var16 = (float)(var18 >> 16 & 255) / 255.0F;
         var12 = (float)(var18 >> 8 & 255) / 255.0F;
         var13 = (float)(var18 & 255) / 255.0F;
         if(this.field_77024_a) {
            GL11.glColor4f(var16, var12, var13, 1.0F);
         }

         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         this.field_77022_g.field_78668_c = this.field_77024_a;
         this.field_77022_g.func_78600_a(var15, var7, 1.0F);
         this.field_77022_g.field_78668_c = true;
         GL11.glPopMatrix();
      } else {
         int var9;
         if(Item.field_77698_e[var6].func_77623_v()) {
            GL11.glDisable(2896);
            p_77015_2_.func_98187_b("/gui/items.png");

            for(var9 = 0; var9 <= 1; ++var9) {
               Icon var10 = Item.field_77698_e[var6].func_77618_c(var7, var9);
               int var11 = Item.field_77698_e[var6].func_82790_a(p_77015_3_, var9);
               var12 = (float)(var11 >> 16 & 255) / 255.0F;
               var13 = (float)(var11 >> 8 & 255) / 255.0F;
               float var14 = (float)(var11 & 255) / 255.0F;
               if(this.field_77024_a) {
                  GL11.glColor4f(var12, var13, var14, 1.0F);
               }

               this.func_94149_a(p_77015_4_, p_77015_5_, var10, 16, 16);
            }

            GL11.glEnable(2896);
         } else {
            GL11.glDisable(2896);
            if(p_77015_3_.func_94608_d() == 0) {
               p_77015_2_.func_98187_b("/terrain.png");
            } else {
               p_77015_2_.func_98187_b("/gui/items.png");
            }

            if(var8 == null) {
               var8 = p_77015_2_.func_96448_c(p_77015_3_.func_94608_d());
            }

            var9 = Item.field_77698_e[var6].func_82790_a(p_77015_3_, 0);
            float var17 = (float)(var9 >> 16 & 255) / 255.0F;
            var16 = (float)(var9 >> 8 & 255) / 255.0F;
            var12 = (float)(var9 & 255) / 255.0F;
            if(this.field_77024_a) {
               GL11.glColor4f(var17, var16, var12, 1.0F);
            }

            this.func_94149_a(p_77015_4_, p_77015_5_, var8, 16, 16);
            GL11.glEnable(2896);
         }
      }

      GL11.glEnable(2884);
   }

   public void func_82406_b(FontRenderer p_82406_1_, RenderEngine p_82406_2_, ItemStack p_82406_3_, int p_82406_4_, int p_82406_5_) {
      if(p_82406_3_ != null) {
         this.func_77015_a(p_82406_1_, p_82406_2_, p_82406_3_, p_82406_4_, p_82406_5_);
         if(p_82406_3_.func_77962_s()) {
            GL11.glDepthFunc(516);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            p_82406_2_.func_98187_b("%blur%/misc/glint.png");
            this.field_77023_b -= 50.0F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(774, 774);
            GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
            this.func_77018_a(p_82406_4_ * 431278612 + p_82406_5_ * 32178161, p_82406_4_ - 2, p_82406_5_ - 2, 20, 20);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            this.field_77023_b += 50.0F;
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
         }

      }
   }

   private void func_77018_a(int p_77018_1_, int p_77018_2_, int p_77018_3_, int p_77018_4_, int p_77018_5_) {
      for(int var6 = 0; var6 < 2; ++var6) {
         if(var6 == 0) {
            GL11.glBlendFunc(768, 1);
         }

         if(var6 == 1) {
            GL11.glBlendFunc(768, 1);
         }

         float var7 = 0.00390625F;
         float var8 = 0.00390625F;
         float var9 = (float)(Minecraft.func_71386_F() % (long)(3000 + var6 * 1873)) / (3000.0F + (float)(var6 * 1873)) * 256.0F;
         float var10 = 0.0F;
         Tessellator var11 = Tessellator.field_78398_a;
         float var12 = 4.0F;
         if(var6 == 1) {
            var12 = -1.0F;
         }

         var11.func_78382_b();
         var11.func_78374_a((double)(p_77018_2_ + 0), (double)(p_77018_3_ + p_77018_5_), (double)this.field_77023_b, (double)((var9 + (float)p_77018_5_ * var12) * var7), (double)((var10 + (float)p_77018_5_) * var8));
         var11.func_78374_a((double)(p_77018_2_ + p_77018_4_), (double)(p_77018_3_ + p_77018_5_), (double)this.field_77023_b, (double)((var9 + (float)p_77018_4_ + (float)p_77018_5_ * var12) * var7), (double)((var10 + (float)p_77018_5_) * var8));
         var11.func_78374_a((double)(p_77018_2_ + p_77018_4_), (double)(p_77018_3_ + 0), (double)this.field_77023_b, (double)((var9 + (float)p_77018_4_) * var7), (double)((var10 + 0.0F) * var8));
         var11.func_78374_a((double)(p_77018_2_ + 0), (double)(p_77018_3_ + 0), (double)this.field_77023_b, (double)((var9 + 0.0F) * var7), (double)((var10 + 0.0F) * var8));
         var11.func_78381_a();
      }

   }

   public void func_77021_b(FontRenderer p_77021_1_, RenderEngine p_77021_2_, ItemStack p_77021_3_, int p_77021_4_, int p_77021_5_) {
      this.func_94148_a(p_77021_1_, p_77021_2_, p_77021_3_, p_77021_4_, p_77021_5_, (String)null);
   }

   public void func_94148_a(FontRenderer p_94148_1_, RenderEngine p_94148_2_, ItemStack p_94148_3_, int p_94148_4_, int p_94148_5_, String p_94148_6_) {
      if(p_94148_3_ != null) {
         if(p_94148_3_.field_77994_a > 1 || p_94148_6_ != null) {
            String var7 = p_94148_6_ == null?String.valueOf(p_94148_3_.field_77994_a):p_94148_6_;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            p_94148_1_.func_78261_a(var7, p_94148_4_ + 19 - 2 - p_94148_1_.func_78256_a(var7), p_94148_5_ + 6 + 3, 16777215);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
         }

         if(p_94148_3_.func_77951_h()) {
            int var12 = (int)Math.round(13.0D - (double)p_94148_3_.func_77952_i() * 13.0D / (double)p_94148_3_.func_77958_k());
            int var8 = (int)Math.round(255.0D - (double)p_94148_3_.func_77952_i() * 255.0D / (double)p_94148_3_.func_77958_k());
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            Tessellator var9 = Tessellator.field_78398_a;
            int var10 = 255 - var8 << 16 | var8 << 8;
            int var11 = (255 - var8) / 4 << 16 | 16128;
            this.func_77017_a(var9, p_94148_4_ + 2, p_94148_5_ + 13, 13, 2, 0);
            this.func_77017_a(var9, p_94148_4_ + 2, p_94148_5_ + 13, 12, 1, var11);
            this.func_77017_a(var9, p_94148_4_ + 2, p_94148_5_ + 13, var12, 1, var10);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   private void func_77017_a(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_) {
      p_77017_1_.func_78382_b();
      p_77017_1_.func_78378_d(p_77017_6_);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + 0), (double)(p_77017_3_ + 0), 0.0D);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + 0), (double)(p_77017_3_ + p_77017_5_), 0.0D);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + p_77017_5_), 0.0D);
      p_77017_1_.func_78377_a((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + 0), 0.0D);
      p_77017_1_.func_78381_a();
   }

   public void func_94149_a(int p_94149_1_, int p_94149_2_, Icon p_94149_3_, int p_94149_4_, int p_94149_5_) {
      Tessellator var6 = Tessellator.field_78398_a;
      var6.func_78382_b();
      var6.func_78374_a((double)(p_94149_1_ + 0), (double)(p_94149_2_ + p_94149_5_), (double)this.field_77023_b, (double)p_94149_3_.func_94209_e(), (double)p_94149_3_.func_94210_h());
      var6.func_78374_a((double)(p_94149_1_ + p_94149_4_), (double)(p_94149_2_ + p_94149_5_), (double)this.field_77023_b, (double)p_94149_3_.func_94212_f(), (double)p_94149_3_.func_94210_h());
      var6.func_78374_a((double)(p_94149_1_ + p_94149_4_), (double)(p_94149_2_ + 0), (double)this.field_77023_b, (double)p_94149_3_.func_94212_f(), (double)p_94149_3_.func_94206_g());
      var6.func_78374_a((double)(p_94149_1_ + 0), (double)(p_94149_2_ + 0), (double)this.field_77023_b, (double)p_94149_3_.func_94209_e(), (double)p_94149_3_.func_94206_g());
      var6.func_78381_a();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77014_a((EntityItem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
