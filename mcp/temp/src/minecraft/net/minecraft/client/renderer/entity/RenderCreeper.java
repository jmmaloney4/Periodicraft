package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCreeper extends RenderLiving {

   private ModelBase field_77064_a = new ModelCreeper(2.0F);


   public RenderCreeper() {
      super(new ModelCreeper(), 0.5F);
   }

   protected void func_77060_a(EntityCreeper p_77060_1_, float p_77060_2_) {
      float var4 = p_77060_1_.func_70831_j(p_77060_2_);
      float var5 = 1.0F + MathHelper.func_76126_a(var4 * 100.0F) * var4 * 0.01F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      var4 *= var4;
      var4 *= var4;
      float var6 = (1.0F + var4 * 0.4F) * var5;
      float var7 = (1.0F + var4 * 0.1F) / var5;
      GL11.glScalef(var6, var7, var6);
   }

   protected int func_77063_a(EntityCreeper p_77063_1_, float p_77063_2_, float p_77063_3_) {
      float var5 = p_77063_1_.func_70831_j(p_77063_3_);
      if((int)(var5 * 10.0F) % 2 == 0) {
         return 0;
      } else {
         int var6 = (int)(var5 * 0.2F * 255.0F);
         if(var6 < 0) {
            var6 = 0;
         }

         if(var6 > 255) {
            var6 = 255;
         }

         short var7 = 255;
         short var8 = 255;
         short var9 = 255;
         return var6 << 24 | var7 << 16 | var8 << 8 | var9;
      }
   }

   protected int func_77062_a(EntityCreeper p_77062_1_, int p_77062_2_, float p_77062_3_) {
      if(p_77062_1_.func_70830_n()) {
         if(p_77062_1_.func_82150_aj()) {
            GL11.glDepthMask(false);
         } else {
            GL11.glDepthMask(true);
         }

         if(p_77062_2_ == 1) {
            float var4 = (float)p_77062_1_.field_70173_aa + p_77062_3_;
            this.func_76985_a("/armor/power.png");
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            float var5 = var4 * 0.01F;
            float var6 = var4 * 0.01F;
            GL11.glTranslatef(var5, var6, 0.0F);
            this.func_77042_a(this.field_77064_a);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            float var7 = 0.5F;
            GL11.glColor4f(var7, var7, var7, 1.0F);
            GL11.glDisable(2896);
            GL11.glBlendFunc(1, 1);
            return 1;
         }

         if(p_77062_2_ == 2) {
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
         }
      }

      return -1;
   }

   protected int func_77061_b(EntityCreeper p_77061_1_, int p_77061_2_, float p_77061_3_) {
      return -1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_77060_a((EntityCreeper)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77030_a(EntityLiving p_77030_1_, float p_77030_2_, float p_77030_3_) {
      return this.func_77063_a((EntityCreeper)p_77030_1_, p_77030_2_, p_77030_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_77062_a((EntityCreeper)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77035_b(EntityLiving p_77035_1_, int p_77035_2_, float p_77035_3_) {
      return this.func_77061_b((EntityCreeper)p_77035_1_, p_77035_2_, p_77035_3_);
   }
}
