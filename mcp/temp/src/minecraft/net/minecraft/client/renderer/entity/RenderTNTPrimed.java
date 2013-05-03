package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTNTPrimed extends Render {

   private RenderBlocks field_76993_a = new RenderBlocks();


   public RenderTNTPrimed() {
      this.field_76989_e = 0.5F;
   }

   public void func_76992_a(EntityTNTPrimed p_76992_1_, double p_76992_2_, double p_76992_4_, double p_76992_6_, float p_76992_8_, float p_76992_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76992_2_, (float)p_76992_4_, (float)p_76992_6_);
      float var10;
      if((float)p_76992_1_.field_70516_a - p_76992_9_ + 1.0F < 10.0F) {
         var10 = 1.0F - ((float)p_76992_1_.field_70516_a - p_76992_9_ + 1.0F) / 10.0F;
         if(var10 < 0.0F) {
            var10 = 0.0F;
         }

         if(var10 > 1.0F) {
            var10 = 1.0F;
         }

         var10 *= var10;
         var10 *= var10;
         float var11 = 1.0F + var10 * 0.3F;
         GL11.glScalef(var11, var11, var11);
      }

      var10 = (1.0F - ((float)p_76992_1_.field_70516_a - p_76992_9_ + 1.0F) / 100.0F) * 0.8F;
      this.func_76985_a("/terrain.png");
      this.field_76993_a.func_78600_a(Block.field_72091_am, 0, p_76992_1_.func_70013_c(p_76992_9_));
      if(p_76992_1_.field_70516_a / 5 % 2 == 0) {
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 772);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var10);
         this.field_76993_a.func_78600_a(Block.field_72091_am, 0, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glEnable(3553);
      }

      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_76992_a((EntityTNTPrimed)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
