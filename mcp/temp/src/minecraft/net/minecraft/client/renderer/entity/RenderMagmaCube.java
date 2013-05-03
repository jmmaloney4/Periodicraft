package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMagmaCube;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderMagmaCube extends RenderLiving {

   private int field_77120_a;


   public RenderMagmaCube() {
      super(new ModelMagmaCube(), 0.25F);
      this.field_77120_a = ((ModelMagmaCube)this.field_77045_g).func_78107_a();
   }

   public void func_77119_a(EntityMagmaCube p_77119_1_, double p_77119_2_, double p_77119_4_, double p_77119_6_, float p_77119_8_, float p_77119_9_) {
      int var10 = ((ModelMagmaCube)this.field_77045_g).func_78107_a();
      if(var10 != this.field_77120_a) {
         this.field_77120_a = var10;
         this.field_77045_g = new ModelMagmaCube();
         Minecraft.func_71410_x().func_98033_al().func_98233_a("Loaded new lava slime model");
      }

      super.func_77031_a(p_77119_1_, p_77119_2_, p_77119_4_, p_77119_6_, p_77119_8_, p_77119_9_);
   }

   protected void func_77118_a(EntityMagmaCube p_77118_1_, float p_77118_2_) {
      int var3 = p_77118_1_.func_70809_q();
      float var4 = (p_77118_1_.field_70812_c + (p_77118_1_.field_70811_b - p_77118_1_.field_70812_c) * p_77118_2_) / ((float)var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      float var6 = (float)var3;
      GL11.glScalef(var5 * var6, 1.0F / var5 * var6, var5 * var6);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77118_a((EntityMagmaCube)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77119_a((EntityMagmaCube)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77119_a((EntityMagmaCube)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
