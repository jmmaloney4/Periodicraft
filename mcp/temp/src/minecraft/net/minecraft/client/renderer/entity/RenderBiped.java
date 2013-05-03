package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBiped extends RenderLiving {

   protected ModelBiped field_77071_a;
   protected float field_77070_b;
   protected ModelBiped field_82423_g;
   protected ModelBiped field_82425_h;
   public static String[] field_82424_k = new String[]{"cloth", "chain", "iron", "diamond", "gold"};


   public RenderBiped(ModelBiped p_i3202_1_, float p_i3202_2_) {
      this(p_i3202_1_, p_i3202_2_, 1.0F);
   }

   public RenderBiped(ModelBiped p_i3203_1_, float p_i3203_2_, float p_i3203_3_) {
      super(p_i3203_1_, p_i3203_2_);
      this.field_77071_a = p_i3203_1_;
      this.field_77070_b = p_i3203_3_;
      this.func_82421_b();
   }

   protected void func_82421_b() {
      this.field_82423_g = new ModelBiped(1.0F);
      this.field_82425_h = new ModelBiped(0.5F);
   }

   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      ItemStack var4 = p_77032_1_.func_82169_q(3 - p_77032_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            ItemArmor var6 = (ItemArmor)var5;
            this.func_76985_a("/armor/" + field_82424_k[var6.field_77880_c] + "_" + (p_77032_2_ == 2?2:1) + ".png");
            ModelBiped var7 = p_77032_2_ == 2?this.field_82425_h:this.field_82423_g;
            var7.field_78116_c.field_78806_j = p_77032_2_ == 0;
            var7.field_78114_d.field_78806_j = p_77032_2_ == 0;
            var7.field_78115_e.field_78806_j = p_77032_2_ == 1 || p_77032_2_ == 2;
            var7.field_78112_f.field_78806_j = p_77032_2_ == 1;
            var7.field_78113_g.field_78806_j = p_77032_2_ == 1;
            var7.field_78123_h.field_78806_j = p_77032_2_ == 2 || p_77032_2_ == 3;
            var7.field_78124_i.field_78806_j = p_77032_2_ == 2 || p_77032_2_ == 3;
            this.func_77042_a(var7);
            if(var7 != null) {
               var7.field_78095_p = this.field_77045_g.field_78095_p;
            }

            if(var7 != null) {
               var7.field_78093_q = this.field_77045_g.field_78093_q;
            }

            if(var7 != null) {
               var7.field_78091_s = this.field_77045_g.field_78091_s;
            }

            float var8 = 1.0F;
            if(var6.func_82812_d() == EnumArmorMaterial.CLOTH) {
               int var9 = var6.func_82814_b(var4);
               float var10 = (float)(var9 >> 16 & 255) / 255.0F;
               float var11 = (float)(var9 >> 8 & 255) / 255.0F;
               float var12 = (float)(var9 & 255) / 255.0F;
               GL11.glColor3f(var8 * var10, var8 * var11, var8 * var12);
               if(var4.func_77948_v()) {
                  return 31;
               }

               return 16;
            }

            GL11.glColor3f(var8, var8, var8);
            if(var4.func_77948_v()) {
               return 15;
            }

            return 1;
         }
      }

      return -1;
   }

   protected void func_82408_c(EntityLiving p_82408_1_, int p_82408_2_, float p_82408_3_) {
      ItemStack var4 = p_82408_1_.func_82169_q(3 - p_82408_2_);
      if(var4 != null) {
         Item var5 = var4.func_77973_b();
         if(var5 instanceof ItemArmor) {
            ItemArmor var6 = (ItemArmor)var5;
            this.func_76985_a("/armor/" + field_82424_k[var6.field_77880_c] + "_" + (p_82408_2_ == 2?2:1) + "_b.png");
            float var7 = 1.0F;
            GL11.glColor3f(var7, var7, var7);
         }
      }

   }

   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      float var10 = 1.0F;
      GL11.glColor3f(var10, var10, var10);
      ItemStack var11 = p_77031_1_.func_70694_bm();
      this.func_82420_a(p_77031_1_, var11);
      double var12 = p_77031_4_ - (double)p_77031_1_.field_70129_M;
      if(p_77031_1_.func_70093_af() && !(p_77031_1_ instanceof EntityPlayerSP)) {
         var12 -= 0.125D;
      }

      super.func_77031_a(p_77031_1_, p_77031_2_, var12, p_77031_6_, p_77031_8_, p_77031_9_);
      this.field_82423_g.field_78118_o = this.field_82425_h.field_78118_o = this.field_77071_a.field_78118_o = false;
      this.field_82423_g.field_78117_n = this.field_82425_h.field_78117_n = this.field_77071_a.field_78117_n = false;
      this.field_82423_g.field_78120_m = this.field_82425_h.field_78120_m = this.field_77071_a.field_78120_m = 0;
   }

   protected void func_82420_a(EntityLiving p_82420_1_, ItemStack p_82420_2_) {
      this.field_82423_g.field_78120_m = this.field_82425_h.field_78120_m = this.field_77071_a.field_78120_m = p_82420_2_ != null?1:0;
      this.field_82423_g.field_78117_n = this.field_82425_h.field_78117_n = this.field_77071_a.field_78117_n = p_82420_1_.func_70093_af();
   }

   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      float var3 = 1.0F;
      GL11.glColor3f(var3, var3, var3);
      super.func_77029_c(p_77029_1_, p_77029_2_);
      ItemStack var4 = p_77029_1_.func_70694_bm();
      ItemStack var5 = p_77029_1_.func_82169_q(3);
      float var6;
      if(var5 != null) {
         GL11.glPushMatrix();
         this.field_77071_a.field_78116_c.func_78794_c(0.0625F);
         if(var5.func_77973_b().field_77779_bT < 256) {
            if(RenderBlocks.func_78597_b(Block.field_71973_m[var5.field_77993_c].func_71857_b())) {
               var6 = 0.625F;
               GL11.glTranslatef(0.0F, -0.25F, 0.0F);
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glScalef(var6, -var6, -var6);
            }

            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var5, 0);
         } else if(var5.func_77973_b().field_77779_bT == Item.field_82799_bQ.field_77779_bT) {
            var6 = 1.0625F;
            GL11.glScalef(var6, -var6, -var6);
            String var7 = "";
            if(var5.func_77942_o() && var5.func_77978_p().func_74764_b("SkullOwner")) {
               var7 = var5.func_77978_p().func_74779_i("SkullOwner");
            }

            TileEntitySkullRenderer.field_82397_a.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, var5.func_77960_j(), var7);
         }

         GL11.glPopMatrix();
      }

      if(var4 != null) {
         GL11.glPushMatrix();
         if(this.field_77045_g.field_78091_s) {
            var6 = 0.5F;
            GL11.glTranslatef(0.0F, 0.625F, 0.0F);
            GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
            GL11.glScalef(var6, var6, var6);
         }

         this.field_77071_a.field_78112_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         if(var4.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[var4.field_77993_c].func_71857_b())) {
            var6 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var6 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-var6, -var6, var6);
         } else if(var4.field_77993_c == Item.field_77707_k.field_77779_bT) {
            var6 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(Item.field_77698_e[var4.field_77993_c].func_77662_d()) {
            var6 = 0.625F;
            if(Item.field_77698_e[var4.field_77993_c].func_77629_n_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            this.func_82422_c();
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var6 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var6, var6, var6);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var4, 0);
         if(var4.func_77973_b().func_77623_v()) {
            this.field_76990_c.field_78721_f.func_78443_a(p_77029_1_, var4, 1);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_82422_c() {
      GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77031_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

}
