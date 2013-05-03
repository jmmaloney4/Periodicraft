package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntitySignRenderer extends TileEntitySpecialRenderer {

   private ModelSign field_76910_a = new ModelSign();


   public void func_76909_a(TileEntitySign p_76909_1_, double p_76909_2_, double p_76909_4_, double p_76909_6_, float p_76909_8_) {
      Block var9 = p_76909_1_.func_70311_o();
      GL11.glPushMatrix();
      float var10 = 0.6666667F;
      float var12;
      if(var9 == Block.field_72053_aD) {
         GL11.glTranslatef((float)p_76909_2_ + 0.5F, (float)p_76909_4_ + 0.75F * var10, (float)p_76909_6_ + 0.5F);
         float var11 = (float)(p_76909_1_.func_70322_n() * 360) / 16.0F;
         GL11.glRotatef(-var11, 0.0F, 1.0F, 0.0F);
         this.field_76910_a.field_78165_b.field_78806_j = true;
      } else {
         int var16 = p_76909_1_.func_70322_n();
         var12 = 0.0F;
         if(var16 == 2) {
            var12 = 180.0F;
         }

         if(var16 == 4) {
            var12 = 90.0F;
         }

         if(var16 == 5) {
            var12 = -90.0F;
         }

         GL11.glTranslatef((float)p_76909_2_ + 0.5F, (float)p_76909_4_ + 0.75F * var10, (float)p_76909_6_ + 0.5F);
         GL11.glRotatef(-var12, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
         this.field_76910_a.field_78165_b.field_78806_j = false;
      }

      this.func_76897_a("/item/sign.png");
      GL11.glPushMatrix();
      GL11.glScalef(var10, -var10, -var10);
      this.field_76910_a.func_78164_a();
      GL11.glPopMatrix();
      FontRenderer var17 = this.func_76895_b();
      var12 = 0.016666668F * var10;
      GL11.glTranslatef(0.0F, 0.5F * var10, 0.07F * var10);
      GL11.glScalef(var12, -var12, var12);
      GL11.glNormal3f(0.0F, 0.0F, -1.0F * var12);
      GL11.glDepthMask(false);
      byte var13 = 0;

      for(int var14 = 0; var14 < p_76909_1_.field_70412_a.length; ++var14) {
         String var15 = p_76909_1_.field_70412_a[var14];
         if(var14 == p_76909_1_.field_70410_b) {
            var15 = "> " + var15 + " <";
            var17.func_78276_b(var15, -var17.func_78256_a(var15) / 2, var14 * 10 - p_76909_1_.field_70412_a.length * 5, var13);
         } else {
            var17.func_78276_b(var15, -var17.func_78256_a(var15) / 2, var14 * 10 - p_76909_1_.field_70412_a.length * 5, var13);
         }
      }

      GL11.glDepthMask(true);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_76909_a((TileEntitySign)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
