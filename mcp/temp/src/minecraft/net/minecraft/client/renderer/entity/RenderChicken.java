package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class RenderChicken extends RenderLiving {

   public RenderChicken(ModelBase p_i3200_1_, float p_i3200_2_) {
      super(p_i3200_1_, p_i3200_2_);
   }

   public void func_77065_a(EntityChicken p_77065_1_, double p_77065_2_, double p_77065_4_, double p_77065_6_, float p_77065_8_, float p_77065_9_) {
      super.func_77031_a(p_77065_1_, p_77065_2_, p_77065_4_, p_77065_6_, p_77065_8_, p_77065_9_);
   }

   protected float func_77066_a(EntityChicken p_77066_1_, float p_77066_2_) {
      float var3 = p_77066_1_.field_70888_h + (p_77066_1_.field_70886_e - p_77066_1_.field_70888_h) * p_77066_2_;
      float var4 = p_77066_1_.field_70884_g + (p_77066_1_.field_70883_f - p_77066_1_.field_70884_g) * p_77066_2_;
      return (MathHelper.func_76126_a(var3) + 1.0F) * var4;
   }

   // $FF: synthetic method
   protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_) {
      return this.func_77066_a((EntityChicken)p_77044_1_, p_77044_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77065_a((EntityChicken)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77065_a((EntityChicken)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
