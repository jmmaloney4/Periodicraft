package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderWither extends RenderLiving {

   private int field_82419_a;


   public RenderWither() {
      super(new ModelWither(), 1.0F);
      this.field_82419_a = ((ModelWither)this.field_77045_g).func_82903_a();
   }

   public void func_82418_a(EntityWither p_82418_1_, double p_82418_2_, double p_82418_4_, double p_82418_6_, float p_82418_8_, float p_82418_9_) {
      BossStatus.func_82824_a(p_82418_1_, true);
      int var10 = ((ModelWither)this.field_77045_g).func_82903_a();
      if(var10 != this.field_82419_a) {
         this.field_82419_a = var10;
         this.field_77045_g = new ModelWither();
      }

      super.func_77031_a(p_82418_1_, p_82418_2_, p_82418_4_, p_82418_6_, p_82418_8_, p_82418_9_);
   }

   protected void func_82415_a(EntityWither p_82415_1_, float p_82415_2_) {
      int var3 = p_82415_1_.func_82212_n();
      if(var3 > 0) {
         float var4 = 2.0F - ((float)var3 - p_82415_2_) / 220.0F * 0.5F;
         GL11.glScalef(var4, var4, var4);
      } else {
         GL11.glScalef(2.0F, 2.0F, 2.0F);
      }

   }

   protected int func_82417_a(EntityWither p_82417_1_, int p_82417_2_, float p_82417_3_) {
      if(p_82417_1_.func_82205_o()) {
         if(p_82417_1_.func_82150_aj()) {
            GL11.glDepthMask(false);
         } else {
            GL11.glDepthMask(true);
         }

         if(p_82417_2_ == 1) {
            float var4 = (float)p_82417_1_.field_70173_aa + p_82417_3_;
            this.func_76985_a("/armor/witherarmor.png");
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            float var5 = MathHelper.func_76134_b(var4 * 0.02F) * 3.0F;
            float var6 = var4 * 0.01F;
            GL11.glTranslatef(var5, var6, 0.0F);
            this.func_77042_a(this.field_77045_g);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            float var7 = 0.5F;
            GL11.glColor4f(var7, var7, var7, 1.0F);
            GL11.glDisable(2896);
            GL11.glBlendFunc(1, 1);
            GL11.glTranslatef(0.0F, -0.01F, 0.0F);
            GL11.glScalef(1.1F, 1.1F, 1.1F);
            return 1;
         }

         if(p_82417_2_ == 2) {
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
         }
      }

      return -1;
   }

   protected int func_82416_b(EntityWither p_82416_1_, int p_82416_2_, float p_82416_3_) {
      return -1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_) {
      this.func_82415_a((EntityWither)p_77041_1_, p_77041_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
      return this.func_82417_a((EntityWither)p_77032_1_, p_77032_2_, p_77032_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_77035_b(EntityLiving p_77035_1_, int p_77035_2_, float p_77035_3_) {
      return this.func_82416_b((EntityWither)p_77035_1_, p_77035_2_, p_77035_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_) {
      this.func_82418_a((EntityWither)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_82418_a((EntityWither)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
