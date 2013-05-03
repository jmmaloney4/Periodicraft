package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityIronGolem;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderIronGolem extends RenderLiving {

   private ModelIronGolem field_77050_a;


   public RenderIronGolem() {
      super(new ModelIronGolem(), 0.5F);
      this.field_77050_a = (ModelIronGolem)this.field_77045_g;
   }

   public void func_77049_a(EntityIronGolem p_77049_1_, double p_77049_2_, double p_77049_4_, double p_77049_6_, float p_77049_8_, float p_77049_9_) {
      super.func_77031_a(p_77049_1_, p_77049_2_, p_77049_4_, p_77049_6_, p_77049_8_, p_77049_9_);
   }

   protected void func_77048_a(EntityIronGolem p_77048_1_, float p_77048_2_, float p_77048_3_, float p_77048_4_) {
      super.func_77043_a(p_77048_1_, p_77048_2_, p_77048_3_, p_77048_4_);
      if((double)p_77048_1_.field_70721_aZ >= 0.01D) {
         float var5 = 13.0F;
         float var6 = p_77048_1_.field_70754_ba - p_77048_1_.field_70721_aZ * (1.0F - p_77048_4_) + 6.0F;
         float var7 = (Math.abs(var6 % var5 - var5 * 0.5F) - var5 * 0.25F) / (var5 * 0.25F);
         GL11.glRotatef(6.5F * var7, 0.0F, 0.0F, 1.0F);
      }
   }

   protected void func_77047_a(EntityIronGolem p_77047_1_, float p_77047_2_) {
      super.func_77029_c(p_77047_1_, p_77047_2_);
      if(p_77047_1_.func_70853_p() != 0) {
         GL11.glEnable('\u803a');
         GL11.glPushMatrix();
         GL11.glRotatef(5.0F + 180.0F * this.field_77050_a.field_78177_c.field_78795_f / 3.1415927F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         float var3 = 0.8F;
         GL11.glScalef(var3, -var3, var3);
         int var4 = p_77047_1_.func_70070_b(p_77047_2_);
         int var5 = var4 % 65536;
         int var6 = var4 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var5 / 1.0F, (float)var6 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_76985_a("/terrain.png");
         this.field_76988_d.func_78600_a(Block.field_72107_ae, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glDisable('\u803a');
      }
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      this.func_77047_a((EntityIronGolem)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77048_a((EntityIronGolem)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77049_a((EntityIronGolem)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77049_a((EntityIronGolem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
