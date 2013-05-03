package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityOcelot;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderOcelot extends RenderLiving {

   public RenderOcelot(ModelBase p_i3206_1_, float p_i3206_2_) {
      super(p_i3206_1_, p_i3206_2_);
   }

   public void func_77117_a(EntityOcelot p_77117_1_, double p_77117_2_, double p_77117_4_, double p_77117_6_, float p_77117_8_, float p_77117_9_) {
      super.func_77031_a(p_77117_1_, p_77117_2_, p_77117_4_, p_77117_6_, p_77117_8_, p_77117_9_);
   }

   protected void func_77116_a(EntityOcelot p_77116_1_, float p_77116_2_) {
      super.func_77041_b(p_77116_1_, p_77116_2_);
      if(p_77116_1_.func_70909_n()) {
         GL11.glScalef(0.8F, 0.8F, 0.8F);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77116_a((EntityOcelot)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77117_a((EntityOcelot)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77117_a((EntityOcelot)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
