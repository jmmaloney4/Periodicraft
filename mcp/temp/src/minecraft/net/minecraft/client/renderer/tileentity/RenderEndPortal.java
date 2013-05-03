package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEndPortal;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEndPortal extends TileEntitySpecialRenderer {

   FloatBuffer field_76908_a = GLAllocation.func_74529_h(16);


   public void func_76906_a(TileEntityEndPortal p_76906_1_, double p_76906_2_, double p_76906_4_, double p_76906_6_, float p_76906_8_) {
      float var9 = (float)this.field_76898_b.field_76967_j;
      float var10 = (float)this.field_76898_b.field_76968_k;
      float var11 = (float)this.field_76898_b.field_76965_l;
      GL11.glDisable(2896);
      Random var12 = new Random(31100L);
      float var13 = 0.75F;

      for(int var14 = 0; var14 < 16; ++var14) {
         GL11.glPushMatrix();
         float var15 = (float)(16 - var14);
         float var16 = 0.0625F;
         float var17 = 1.0F / (var15 + 1.0F);
         if(var14 == 0) {
            this.func_76897_a("/misc/tunnel.png");
            var17 = 0.1F;
            var15 = 65.0F;
            var16 = 0.125F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
         }

         if(var14 == 1) {
            this.func_76897_a("/misc/particlefield.png");
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            var16 = 0.5F;
         }

         float var18 = (float)(-(p_76906_4_ + (double)var13));
         float var19 = var18 + ActiveRenderInfo.field_74590_b;
         float var20 = var18 + var15 + ActiveRenderInfo.field_74590_b;
         float var21 = var19 / var20;
         var21 += (float)(p_76906_4_ + (double)var13);
         GL11.glTranslatef(var9, var21, var11);
         GL11.glTexGeni(8192, 9472, 9217);
         GL11.glTexGeni(8193, 9472, 9217);
         GL11.glTexGeni(8194, 9472, 9217);
         GL11.glTexGeni(8195, 9472, 9216);
         GL11.glTexGen(8192, 9473, this.func_76907_a(1.0F, 0.0F, 0.0F, 0.0F));
         GL11.glTexGen(8193, 9473, this.func_76907_a(0.0F, 0.0F, 1.0F, 0.0F));
         GL11.glTexGen(8194, 9473, this.func_76907_a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glTexGen(8195, 9474, this.func_76907_a(0.0F, 1.0F, 0.0F, 0.0F));
         GL11.glEnable(3168);
         GL11.glEnable(3169);
         GL11.glEnable(3170);
         GL11.glEnable(3171);
         GL11.glPopMatrix();
         GL11.glMatrixMode(5890);
         GL11.glPushMatrix();
         GL11.glLoadIdentity();
         GL11.glTranslatef(0.0F, (float)(Minecraft.func_71386_F() % 700000L) / 700000.0F, 0.0F);
         GL11.glScalef(var16, var16, var16);
         GL11.glTranslatef(0.5F, 0.5F, 0.0F);
         GL11.glRotatef((float)(var14 * var14 * 4321 + var14 * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
         GL11.glTranslatef(-var9, -var11, -var10);
         var19 = var18 + ActiveRenderInfo.field_74590_b;
         GL11.glTranslatef(ActiveRenderInfo.field_74592_a * var15 / var19, ActiveRenderInfo.field_74591_c * var15 / var19, -var10);
         Tessellator var24 = Tessellator.field_78398_a;
         var24.func_78382_b();
         var21 = var12.nextFloat() * 0.5F + 0.1F;
         float var22 = var12.nextFloat() * 0.5F + 0.4F;
         float var23 = var12.nextFloat() * 0.5F + 0.5F;
         if(var14 == 0) {
            var23 = 1.0F;
            var22 = 1.0F;
            var21 = 1.0F;
         }

         var24.func_78369_a(var21 * var17, var22 * var17, var23 * var17, 1.0F);
         var24.func_78377_a(p_76906_2_, p_76906_4_ + (double)var13, p_76906_6_);
         var24.func_78377_a(p_76906_2_, p_76906_4_ + (double)var13, p_76906_6_ + 1.0D);
         var24.func_78377_a(p_76906_2_ + 1.0D, p_76906_4_ + (double)var13, p_76906_6_ + 1.0D);
         var24.func_78377_a(p_76906_2_ + 1.0D, p_76906_4_ + (double)var13, p_76906_6_);
         var24.func_78381_a();
         GL11.glPopMatrix();
         GL11.glMatrixMode(5888);
      }

      GL11.glDisable(3042);
      GL11.glDisable(3168);
      GL11.glDisable(3169);
      GL11.glDisable(3170);
      GL11.glDisable(3171);
      GL11.glEnable(2896);
   }

   private FloatBuffer func_76907_a(float p_76907_1_, float p_76907_2_, float p_76907_3_, float p_76907_4_) {
      this.field_76908_a.clear();
      this.field_76908_a.put(p_76907_1_).put(p_76907_2_).put(p_76907_3_).put(p_76907_4_);
      this.field_76908_a.flip();
      return this.field_76908_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_76906_a((TileEntityEndPortal)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
