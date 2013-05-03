package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityWitherSkull;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWitherSkull extends Render {

   ModelSkeletonHead field_82401_a = new ModelSkeletonHead();


   private float func_82400_a(float p_82400_1_, float p_82400_2_, float p_82400_3_) {
      float var4;
      for(var4 = p_82400_2_ - p_82400_1_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return p_82400_1_ + p_82400_3_ * var4;
   }

   public void func_82399_a(EntityWitherSkull p_82399_1_, double p_82399_2_, double p_82399_4_, double p_82399_6_, float p_82399_8_, float p_82399_9_) {
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      float var10 = this.func_82400_a(p_82399_1_.field_70126_B, p_82399_1_.field_70177_z, p_82399_9_);
      float var11 = p_82399_1_.field_70127_C + (p_82399_1_.field_70125_A - p_82399_1_.field_70127_C) * p_82399_9_;
      GL11.glTranslatef((float)p_82399_2_, (float)p_82399_4_, (float)p_82399_6_);
      float var12 = 0.0625F;
      GL11.glEnable('\u803a');
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      GL11.glEnable(3008);
      if(p_82399_1_.func_82342_d()) {
         this.func_76985_a("/mob/wither_invul.png");
      } else {
         this.func_76985_a("/mob/wither.png");
      }

      this.field_82401_a.func_78088_a(p_82399_1_, 0.0F, 0.0F, 0.0F, var10, var11, var12);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_82399_a((EntityWitherSkull)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
