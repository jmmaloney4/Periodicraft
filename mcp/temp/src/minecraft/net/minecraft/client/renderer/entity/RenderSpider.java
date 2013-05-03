package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySpider;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSpider extends RenderLiving {

   public RenderSpider() {
      super(new ModelSpider(), 1.0F);
      this.func_77042_a(new ModelSpider());
   }

   protected float func_77095_a(EntitySpider p_77095_1_) {
      return 180.0F;
   }

   protected int func_77097_a(EntitySpider p_77097_1_, int p_77097_2_, float p_77097_3_) {
      if(p_77097_2_ != 0) {
         return -1;
      } else {
         this.func_76985_a("/mob/spider_eyes.png");
         float var4 = 1.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3008);
         GL11.glBlendFunc(1, 1);
         if(p_77097_1_.func_82150_aj()) {
            GL11.glDepthMask(false);
         } else {
            GL11.glDepthMask(true);
         }

         char var5 = '\uf0f0';
         int var6 = var5 % 65536;
         int var7 = var5 / 65536;
         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
         return 1;
      }
   }

   protected void func_77096_a(EntitySpider p_77096_1_, float p_77096_2_) {
      float var3 = p_77096_1_.func_70840_n();
      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77096_a((EntitySpider)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   protected float func_77037_a(EntityLiving p_77037_1_) {
      return this.func_77095_a((EntitySpider)p_77037_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77097_a((EntitySpider)p_77032_1_, p_77032_2_, p_77032_3_);
   }
}
