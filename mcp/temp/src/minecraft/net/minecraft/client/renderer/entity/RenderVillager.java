package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderVillager extends RenderLiving {

   protected ModelVillager field_77056_a;


   public RenderVillager() {
      super(new ModelVillager(0.0F), 0.5F);
      this.field_77056_a = (ModelVillager)this.field_77045_g;
   }

   protected int func_77053_a(EntityVillager p_77053_1_, int p_77053_2_, float p_77053_3_) {
      return -1;
   }

   public void func_77054_a(EntityVillager p_77054_1_, double p_77054_2_, double p_77054_4_, double p_77054_6_, float p_77054_8_, float p_77054_9_) {
      super.func_77031_a(p_77054_1_, p_77054_2_, p_77054_4_, p_77054_6_, p_77054_8_, p_77054_9_);
   }

   protected void func_77051_a(EntityVillager p_77051_1_, float p_77051_2_) {
      super.func_77029_c(p_77051_1_, p_77051_2_);
   }

   protected void func_77052_b(EntityVillager p_77052_1_, float p_77052_2_) {
      float var3 = 0.9375F;
      if(p_77052_1_.func_70874_b() < 0) {
         var3 = (float)((double)var3 * 0.5D);
         this.field_76989_e = 0.25F;
      } else {
         this.field_76989_e = 0.5F;
      }

      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77052_b((EntityVillager)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77053_a((EntityVillager)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
      this.func_77051_a((EntityVillager)p_77029_1_, p_77029_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77054_a((EntityVillager)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77054_a((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
