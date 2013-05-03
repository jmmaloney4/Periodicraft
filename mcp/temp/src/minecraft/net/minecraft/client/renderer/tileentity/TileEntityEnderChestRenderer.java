package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer {

   private ModelChest field_76900_a = new ModelChest();


   public void func_76899_a(TileEntityEnderChest p_76899_1_, double p_76899_2_, double p_76899_4_, double p_76899_6_, float p_76899_8_) {
      int var9 = 0;
      if(p_76899_1_.func_70309_m()) {
         var9 = p_76899_1_.func_70322_n();
      }

      this.func_76897_a("/item/enderchest.png");
      GL11.glPushMatrix();
      GL11.glEnable('\u803a');
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glTranslatef((float)p_76899_2_, (float)p_76899_4_ + 1.0F, (float)p_76899_6_ + 1.0F);
      GL11.glScalef(1.0F, -1.0F, -1.0F);
      GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      short var10 = 0;
      if(var9 == 2) {
         var10 = 180;
      }

      if(var9 == 3) {
         var10 = 0;
      }

      if(var9 == 4) {
         var10 = 90;
      }

      if(var9 == 5) {
         var10 = -90;
      }

      GL11.glRotatef((float)var10, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
      float var11 = p_76899_1_.field_70368_b + (p_76899_1_.field_70370_a - p_76899_1_.field_70368_b) * p_76899_8_;
      var11 = 1.0F - var11;
      var11 = 1.0F - var11 * var11 * var11;
      this.field_76900_a.field_78234_a.field_78795_f = -(var11 * 3.1415927F / 2.0F);
      this.field_76900_a.func_78231_a();
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_76899_a((TileEntityEnderChest)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
