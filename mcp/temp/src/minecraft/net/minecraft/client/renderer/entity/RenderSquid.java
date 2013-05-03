package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntitySquid;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSquid extends RenderLiving {

   public RenderSquid(ModelBase p_i3201_1_, float p_i3201_2_) {
      super(p_i3201_1_, p_i3201_2_);
   }

   public void func_77123_a(EntitySquid p_77123_1_, double p_77123_2_, double p_77123_4_, double p_77123_6_, float p_77123_8_, float p_77123_9_) {
      super.func_77031_a(p_77123_1_, p_77123_2_, p_77123_4_, p_77123_6_, p_77123_8_, p_77123_9_);
   }

   protected void func_77122_a(EntitySquid p_77122_1_, float p_77122_2_, float p_77122_3_, float p_77122_4_) {
      float var5 = p_77122_1_.field_70862_e + (p_77122_1_.field_70861_d - p_77122_1_.field_70862_e) * p_77122_4_;
      float var6 = p_77122_1_.field_70860_g + (p_77122_1_.field_70859_f - p_77122_1_.field_70860_g) * p_77122_4_;
      GL11.glTranslatef(0.0F, 0.5F, 0.0F);
      GL11.glRotatef(180.0F - p_77122_3_, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(var5, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(var6, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.0F, -1.2F, 0.0F);
   }

   protected float func_77121_a(EntitySquid p_77121_1_, float p_77121_2_) {
      return p_77121_1_.field_70865_by + (p_77121_1_.field_70866_j - p_77121_1_.field_70865_by) * p_77121_2_;
   }

   // $FF: synthetic method
   protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_) {
      return this.func_77121_a((EntitySquid)p_77044_1_, p_77044_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      this.func_77122_a((EntitySquid)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_77123_a((EntitySquid)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77123_a((EntitySquid)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
