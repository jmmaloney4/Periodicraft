package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWolf extends RenderLiving {

   public RenderWolf(ModelBase p_i5024_1_, ModelBase p_i5024_2_, float p_i5024_3_) {
      super(p_i5024_1_, p_i5024_3_);
      this.func_77042_a(p_i5024_2_);
   }

   protected float func_77057_a(EntityWolf p_77057_1_, float p_77057_2_) {
      return p_77057_1_.func_70920_v();
   }

   protected int func_82447_a(EntityWolf p_82447_1_, int p_82447_2_, float p_82447_3_) {
      float var4;
      if(p_82447_2_ == 0 && p_82447_1_.func_70921_u()) {
         var4 = p_82447_1_.func_70013_c(p_82447_3_) * p_82447_1_.func_70915_j(p_82447_3_);
         this.func_76985_a(p_82447_1_.func_70073_O());
         GL11.glColor3f(var4, var4, var4);
         return 1;
      } else if(p_82447_2_ == 1 && p_82447_1_.func_70909_n()) {
         this.func_76985_a("/mob/wolf_collar.png");
         var4 = 1.0F;
         int var5 = p_82447_1_.func_82186_bH();
         GL11.glColor3f(var4 * EntitySheep.field_70898_d[var5][0], var4 * EntitySheep.field_70898_d[var5][1], var4 * EntitySheep.field_70898_d[var5][2]);
         return 1;
      } else {
         return -1;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_82447_a((EntityWolf)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_) {
      return this.func_77057_a((EntityWolf)p_77044_1_, p_77044_2_);
   }
}
