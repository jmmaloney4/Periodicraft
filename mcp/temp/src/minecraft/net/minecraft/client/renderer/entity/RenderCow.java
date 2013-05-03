package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;

@SideOnly(Side.CLIENT)
public class RenderCow extends RenderLiving {

   public RenderCow(ModelBase p_i3210_1_, float p_i3210_2_) {
      super(p_i3210_1_, p_i3210_2_);
   }

   public void func_77059_a(EntityCow p_77059_1_, double p_77059_2_, double p_77059_4_, double p_77059_6_, float p_77059_8_, float p_77059_9_) {
      super.func_77031_a(p_77059_1_, p_77059_2_, p_77059_4_, p_77059_6_, p_77059_8_, p_77059_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77059_a((EntityCow)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77059_a((EntityCow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
