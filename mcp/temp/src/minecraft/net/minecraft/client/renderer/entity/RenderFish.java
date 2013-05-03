package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFish extends Render {

   public void func_77000_a(EntityFishHook p_77000_1_, double p_77000_2_, double p_77000_4_, double p_77000_6_, float p_77000_8_, float p_77000_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_77000_2_, (float)p_77000_4_, (float)p_77000_6_);
      GL11.glEnable('\u803a');
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      byte var10 = 1;
      byte var11 = 2;
      this.func_76985_a("/particles.png");
      Tessellator var12 = Tessellator.field_78398_a;
      float var13 = (float)(var10 * 8 + 0) / 128.0F;
      float var14 = (float)(var10 * 8 + 8) / 128.0F;
      float var15 = (float)(var11 * 8 + 0) / 128.0F;
      float var16 = (float)(var11 * 8 + 8) / 128.0F;
      float var17 = 1.0F;
      float var18 = 0.5F;
      float var19 = 0.5F;
      GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
      var12.func_78382_b();
      var12.func_78375_b(0.0F, 1.0F, 0.0F);
      var12.func_78374_a((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
      var12.func_78374_a((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
      var12.func_78374_a((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
      var12.func_78374_a((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
      var12.func_78381_a();
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
      if(p_77000_1_.field_70204_b != null) {
         float var20 = p_77000_1_.field_70204_b.func_70678_g(p_77000_9_);
         float var21 = MathHelper.func_76126_a(MathHelper.func_76129_c(var20) * 3.1415927F);
         Vec3 var22 = p_77000_1_.field_70170_p.func_82732_R().func_72345_a(-0.5D, 0.03D, 0.8D);
         var22.func_72440_a(-(p_77000_1_.field_70204_b.field_70127_C + (p_77000_1_.field_70204_b.field_70125_A - p_77000_1_.field_70204_b.field_70127_C) * p_77000_9_) * 3.1415927F / 180.0F);
         var22.func_72442_b(-(p_77000_1_.field_70204_b.field_70126_B + (p_77000_1_.field_70204_b.field_70177_z - p_77000_1_.field_70204_b.field_70126_B) * p_77000_9_) * 3.1415927F / 180.0F);
         var22.func_72442_b(var21 * 0.5F);
         var22.func_72440_a(-var21 * 0.7F);
         double var23 = p_77000_1_.field_70204_b.field_70169_q + (p_77000_1_.field_70204_b.field_70165_t - p_77000_1_.field_70204_b.field_70169_q) * (double)p_77000_9_ + var22.field_72450_a;
         double var25 = p_77000_1_.field_70204_b.field_70167_r + (p_77000_1_.field_70204_b.field_70163_u - p_77000_1_.field_70204_b.field_70167_r) * (double)p_77000_9_ + var22.field_72448_b;
         double var27 = p_77000_1_.field_70204_b.field_70166_s + (p_77000_1_.field_70204_b.field_70161_v - p_77000_1_.field_70204_b.field_70166_s) * (double)p_77000_9_ + var22.field_72449_c;
         double var29 = p_77000_1_.field_70204_b != Minecraft.func_71410_x().field_71439_g?(double)p_77000_1_.field_70204_b.func_70047_e():0.0D;
         if(this.field_76990_c.field_78733_k.field_74320_O > 0 || p_77000_1_.field_70204_b != Minecraft.func_71410_x().field_71439_g) {
            float var31 = (p_77000_1_.field_70204_b.field_70760_ar + (p_77000_1_.field_70204_b.field_70761_aq - p_77000_1_.field_70204_b.field_70760_ar) * p_77000_9_) * 3.1415927F / 180.0F;
            double var32 = (double)MathHelper.func_76126_a(var31);
            double var34 = (double)MathHelper.func_76134_b(var31);
            var23 = p_77000_1_.field_70204_b.field_70169_q + (p_77000_1_.field_70204_b.field_70165_t - p_77000_1_.field_70204_b.field_70169_q) * (double)p_77000_9_ - var34 * 0.35D - var32 * 0.85D;
            var25 = p_77000_1_.field_70204_b.field_70167_r + var29 + (p_77000_1_.field_70204_b.field_70163_u - p_77000_1_.field_70204_b.field_70167_r) * (double)p_77000_9_ - 0.45D;
            var27 = p_77000_1_.field_70204_b.field_70166_s + (p_77000_1_.field_70204_b.field_70161_v - p_77000_1_.field_70204_b.field_70166_s) * (double)p_77000_9_ - var32 * 0.35D + var34 * 0.85D;
         }

         double var46 = p_77000_1_.field_70169_q + (p_77000_1_.field_70165_t - p_77000_1_.field_70169_q) * (double)p_77000_9_;
         double var33 = p_77000_1_.field_70167_r + (p_77000_1_.field_70163_u - p_77000_1_.field_70167_r) * (double)p_77000_9_ + 0.25D;
         double var35 = p_77000_1_.field_70166_s + (p_77000_1_.field_70161_v - p_77000_1_.field_70166_s) * (double)p_77000_9_;
         double var37 = (double)((float)(var23 - var46));
         double var39 = (double)((float)(var25 - var33));
         double var41 = (double)((float)(var27 - var35));
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         var12.func_78371_b(3);
         var12.func_78378_d(0);
         byte var43 = 16;

         for(int var44 = 0; var44 <= var43; ++var44) {
            float var45 = (float)var44 / (float)var43;
            var12.func_78377_a(p_77000_2_ + var37 * (double)var45, p_77000_4_ + var39 * (double)(var45 * var45 + var45) * 0.5D + 0.25D, p_77000_6_ + var41 * (double)var45);
         }

         var12.func_78381_a();
         GL11.glEnable(2896);
         GL11.glEnable(3553);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      this.func_77000_a((EntityFishHook)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }
}
