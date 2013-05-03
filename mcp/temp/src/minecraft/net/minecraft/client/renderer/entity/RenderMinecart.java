package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderMinecart extends Render {

   protected ModelBase field_77013_a;
   protected final RenderBlocks field_94145_f;


   public RenderMinecart() {
      this.field_76989_e = 0.5F;
      this.field_77013_a = new ModelMinecart();
      this.field_94145_f = new RenderBlocks();
   }

   public void func_77012_a(EntityMinecart p_77012_1_, double p_77012_2_, double p_77012_4_, double p_77012_6_, float p_77012_8_, float p_77012_9_) {
      GL11.glPushMatrix();
      long var10 = (long)p_77012_1_.field_70157_k * 493286711L;
      var10 = var10 * var10 * 4392167121L + var10 * 98761L;
      float var12 = (((float)(var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.0040F;
      float var13 = (((float)(var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.0040F;
      float var14 = (((float)(var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.0040F;
      GL11.glTranslatef(var12, var13, var14);
      double var15 = p_77012_1_.field_70142_S + (p_77012_1_.field_70165_t - p_77012_1_.field_70142_S) * (double)p_77012_9_;
      double var17 = p_77012_1_.field_70137_T + (p_77012_1_.field_70163_u - p_77012_1_.field_70137_T) * (double)p_77012_9_;
      double var19 = p_77012_1_.field_70136_U + (p_77012_1_.field_70161_v - p_77012_1_.field_70136_U) * (double)p_77012_9_;
      double var21 = 0.30000001192092896D;
      Vec3 var23 = p_77012_1_.func_70489_a(var15, var17, var19);
      float var24 = p_77012_1_.field_70127_C + (p_77012_1_.field_70125_A - p_77012_1_.field_70127_C) * p_77012_9_;
      if(var23 != null) {
         Vec3 var25 = p_77012_1_.func_70495_a(var15, var17, var19, var21);
         Vec3 var26 = p_77012_1_.func_70495_a(var15, var17, var19, -var21);
         if(var25 == null) {
            var25 = var23;
         }

         if(var26 == null) {
            var26 = var23;
         }

         p_77012_2_ += var23.field_72450_a - var15;
         p_77012_4_ += (var25.field_72448_b + var26.field_72448_b) / 2.0D - var17;
         p_77012_6_ += var23.field_72449_c - var19;
         Vec3 var27 = var26.func_72441_c(-var25.field_72450_a, -var25.field_72448_b, -var25.field_72449_c);
         if(var27.func_72433_c() != 0.0D) {
            var27 = var27.func_72432_b();
            p_77012_8_ = (float)(Math.atan2(var27.field_72449_c, var27.field_72450_a) * 180.0D / 3.141592653589793D);
            var24 = (float)(Math.atan(var27.field_72448_b) * 73.0D);
         }
      }

      GL11.glTranslatef((float)p_77012_2_, (float)p_77012_4_, (float)p_77012_6_);
      GL11.glRotatef(180.0F - p_77012_8_, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
      float var31 = (float)p_77012_1_.func_70496_j() - p_77012_9_;
      float var33 = (float)p_77012_1_.func_70491_i() - p_77012_9_;
      if(var33 < 0.0F) {
         var33 = 0.0F;
      }

      if(var31 > 0.0F) {
         GL11.glRotatef(MathHelper.func_76126_a(var31) * var31 * var33 / 10.0F * (float)p_77012_1_.func_70493_k(), 1.0F, 0.0F, 0.0F);
      }

      int var32 = p_77012_1_.func_94099_q();
      Block var28 = p_77012_1_.func_94089_m();
      int var29 = p_77012_1_.func_94098_o();
      if(var28 != null) {
         GL11.glPushMatrix();
         this.func_76985_a("/terrain.png");
         float var30 = 0.75F;
         GL11.glScalef(var30, var30, var30);
         GL11.glTranslatef(0.0F, (float)var32 / 16.0F, 0.0F);
         this.func_94144_a(p_77012_1_, p_77012_9_, var28, var29);
         GL11.glPopMatrix();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

      this.func_76985_a("/item/cart.png");
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.field_77013_a.func_78088_a(p_77012_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   protected void func_94144_a(EntityMinecart p_94144_1_, float p_94144_2_, Block p_94144_3_, int p_94144_4_) {
      float var5 = p_94144_1_.func_70013_c(p_94144_2_);
      GL11.glPushMatrix();
      this.field_94145_f.func_78600_a(p_94144_3_, p_94144_4_, var5);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77012_a((EntityMinecart)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
