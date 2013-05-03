package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer {

   public void func_82398_a(TileEntityBeacon p_82398_1_, double p_82398_2_, double p_82398_4_, double p_82398_6_, float p_82398_8_) {
      float var9 = p_82398_1_.func_82125_v_();
      if(var9 > 0.0F) {
         Tessellator var10 = Tessellator.field_78398_a;
         this.func_76897_a("/misc/beam.png");
         GL11.glTexParameterf(3553, 10242, 10497.0F);
         GL11.glTexParameterf(3553, 10243, 10497.0F);
         GL11.glDisable(2896);
         GL11.glDisable(2884);
         GL11.glDisable(3042);
         GL11.glDepthMask(true);
         GL11.glBlendFunc(770, 1);
         float var11 = (float)p_82398_1_.func_70314_l().func_82737_E() + p_82398_8_;
         float var12 = -var11 * 0.2F - (float)MathHelper.func_76141_d(-var11 * 0.1F);
         byte var13 = 1;
         double var14 = (double)var11 * 0.025D * (1.0D - (double)(var13 & 1) * 2.5D);
         var10.func_78382_b();
         var10.func_78370_a(255, 255, 255, 32);
         double var16 = (double)var13 * 0.2D;
         double var18 = 0.5D + Math.cos(var14 + 2.356194490192345D) * var16;
         double var20 = 0.5D + Math.sin(var14 + 2.356194490192345D) * var16;
         double var22 = 0.5D + Math.cos(var14 + 0.7853981633974483D) * var16;
         double var24 = 0.5D + Math.sin(var14 + 0.7853981633974483D) * var16;
         double var26 = 0.5D + Math.cos(var14 + 3.9269908169872414D) * var16;
         double var28 = 0.5D + Math.sin(var14 + 3.9269908169872414D) * var16;
         double var30 = 0.5D + Math.cos(var14 + 5.497787143782138D) * var16;
         double var32 = 0.5D + Math.sin(var14 + 5.497787143782138D) * var16;
         double var34 = (double)(256.0F * var9);
         double var36 = 0.0D;
         double var38 = 1.0D;
         double var40 = (double)(-1.0F + var12);
         double var42 = (double)(256.0F * var9) * (0.5D / var16) + var40;
         var10.func_78374_a(p_82398_2_ + var18, p_82398_4_ + var34, p_82398_6_ + var20, var38, var42);
         var10.func_78374_a(p_82398_2_ + var18, p_82398_4_, p_82398_6_ + var20, var38, var40);
         var10.func_78374_a(p_82398_2_ + var22, p_82398_4_, p_82398_6_ + var24, var36, var40);
         var10.func_78374_a(p_82398_2_ + var22, p_82398_4_ + var34, p_82398_6_ + var24, var36, var42);
         var10.func_78374_a(p_82398_2_ + var30, p_82398_4_ + var34, p_82398_6_ + var32, var38, var42);
         var10.func_78374_a(p_82398_2_ + var30, p_82398_4_, p_82398_6_ + var32, var38, var40);
         var10.func_78374_a(p_82398_2_ + var26, p_82398_4_, p_82398_6_ + var28, var36, var40);
         var10.func_78374_a(p_82398_2_ + var26, p_82398_4_ + var34, p_82398_6_ + var28, var36, var42);
         var10.func_78374_a(p_82398_2_ + var22, p_82398_4_ + var34, p_82398_6_ + var24, var38, var42);
         var10.func_78374_a(p_82398_2_ + var22, p_82398_4_, p_82398_6_ + var24, var38, var40);
         var10.func_78374_a(p_82398_2_ + var30, p_82398_4_, p_82398_6_ + var32, var36, var40);
         var10.func_78374_a(p_82398_2_ + var30, p_82398_4_ + var34, p_82398_6_ + var32, var36, var42);
         var10.func_78374_a(p_82398_2_ + var26, p_82398_4_ + var34, p_82398_6_ + var28, var38, var42);
         var10.func_78374_a(p_82398_2_ + var26, p_82398_4_, p_82398_6_ + var28, var38, var40);
         var10.func_78374_a(p_82398_2_ + var18, p_82398_4_, p_82398_6_ + var20, var36, var40);
         var10.func_78374_a(p_82398_2_ + var18, p_82398_4_ + var34, p_82398_6_ + var20, var36, var42);
         var10.func_78381_a();
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glDepthMask(false);
         var10.func_78382_b();
         var10.func_78370_a(255, 255, 255, 32);
         double var44 = 0.2D;
         double var15 = 0.2D;
         double var17 = 0.8D;
         double var19 = 0.2D;
         double var21 = 0.2D;
         double var23 = 0.8D;
         double var25 = 0.8D;
         double var27 = 0.8D;
         double var29 = (double)(256.0F * var9);
         double var31 = 0.0D;
         double var33 = 1.0D;
         double var35 = (double)(-1.0F + var12);
         double var37 = (double)(256.0F * var9) + var35;
         var10.func_78374_a(p_82398_2_ + var44, p_82398_4_ + var29, p_82398_6_ + var15, var33, var37);
         var10.func_78374_a(p_82398_2_ + var44, p_82398_4_, p_82398_6_ + var15, var33, var35);
         var10.func_78374_a(p_82398_2_ + var17, p_82398_4_, p_82398_6_ + var19, var31, var35);
         var10.func_78374_a(p_82398_2_ + var17, p_82398_4_ + var29, p_82398_6_ + var19, var31, var37);
         var10.func_78374_a(p_82398_2_ + var25, p_82398_4_ + var29, p_82398_6_ + var27, var33, var37);
         var10.func_78374_a(p_82398_2_ + var25, p_82398_4_, p_82398_6_ + var27, var33, var35);
         var10.func_78374_a(p_82398_2_ + var21, p_82398_4_, p_82398_6_ + var23, var31, var35);
         var10.func_78374_a(p_82398_2_ + var21, p_82398_4_ + var29, p_82398_6_ + var23, var31, var37);
         var10.func_78374_a(p_82398_2_ + var17, p_82398_4_ + var29, p_82398_6_ + var19, var33, var37);
         var10.func_78374_a(p_82398_2_ + var17, p_82398_4_, p_82398_6_ + var19, var33, var35);
         var10.func_78374_a(p_82398_2_ + var25, p_82398_4_, p_82398_6_ + var27, var31, var35);
         var10.func_78374_a(p_82398_2_ + var25, p_82398_4_ + var29, p_82398_6_ + var27, var31, var37);
         var10.func_78374_a(p_82398_2_ + var21, p_82398_4_ + var29, p_82398_6_ + var23, var33, var37);
         var10.func_78374_a(p_82398_2_ + var21, p_82398_4_, p_82398_6_ + var23, var33, var35);
         var10.func_78374_a(p_82398_2_ + var44, p_82398_4_, p_82398_6_ + var15, var31, var35);
         var10.func_78374_a(p_82398_2_ + var44, p_82398_4_ + var29, p_82398_6_ + var15, var31, var37);
         var10.func_78381_a();
         GL11.glEnable(2896);
         GL11.glEnable(3553);
         GL11.glDepthMask(true);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_82398_a((TileEntityBeacon)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
