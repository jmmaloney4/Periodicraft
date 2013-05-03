package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWitch extends RenderLiving {

   private ModelWitch field_82414_a;
   private int field_82413_f;


   public RenderWitch() {
      super(new ModelWitch(0.0F), 0.5F);
      this.field_82414_a = (ModelWitch)this.field_77045_g;
      this.field_82413_f = this.field_82414_a.func_82899_a();
   }

   public void func_82412_a(EntityWitch p_82412_1_, double p_82412_2_, double p_82412_4_, double p_82412_6_, float p_82412_8_, float p_82412_9_) {
      ItemStack var10 = p_82412_1_.func_70694_bm();
      if(this.field_82414_a.func_82899_a() != this.field_82413_f) {
         Minecraft.func_71410_x().func_98033_al().func_98233_a("Loaded new witch model");
         this.field_77045_g = this.field_82414_a = new ModelWitch(0.0F);
         this.field_82413_f = this.field_82414_a.func_82899_a();
      }

      this.field_82414_a.field_82900_g = var10 != null;
      super.func_77031_a(p_82412_1_, p_82412_2_, p_82412_4_, p_82412_6_, p_82412_8_, p_82412_9_);
   }

   protected void func_82411_a(EntityWitch p_82411_1_, float p_82411_2_) {
      float var3 = 1.0F;
      GL11.glColor3f(var3, var3, var3);
      super.func_77029_c(p_82411_1_, p_82411_2_);
      ItemStack var4 = p_82411_1_.func_70694_bm();
      if(var4 != null) {
         GL11.glPushMatrix();
         float var5;
         if(this.field_77045_g.field_78091_s) {
            var5 = 0.5F;
            GL11.glTranslatef(0.0F, 0.625F, 0.0F);
            GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
            GL11.glScalef(var5, var5, var5);
         }

         this.field_82414_a.field_82898_f.func_78794_c(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.53125F, 0.21875F);
         if(var4.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[var4.field_77993_c].func_71857_b())) {
            var5 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var5 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var5, -var5, var5);
         } else if(var4.field_77993_c == Item.field_77707_k.field_77779_bT) {
            var5 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var5, -var5, var5);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(Item.field_77698_e[var4.field_77993_c].func_77662_d()) {
            var5 = 0.625F;
            if(Item.field_77698_e[var4.field_77993_c].func_77629_n_()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            this.func_82410_b();
            GL11.glScalef(var5, -var5, var5);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var5 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var5, var5, var5);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         GL11.glRotatef(-15.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F);
         this.field_76990_c.field_78721_f.func_78443_a(p_82411_1_, var4, 0);
         if(var4.func_77973_b().func_77623_v()) {
            this.field_76990_c.field_78721_f.func_78443_a(p_82411_1_, var4, 1);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_82410_b() {
      GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
   }

   protected void func_82409_b(EntityWitch p_82409_1_, float p_82409_2_) {
      float var3 = 0.9375F;
      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_82409_b((EntityWitch)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      this.func_82411_a((EntityWitch)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_82412_a((EntityWitch)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_82412_a((EntityWitch)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
