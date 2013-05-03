package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnchantmentTable extends TileEntitySpecialRenderer {

   private ModelBook field_76902_a = new ModelBook();


   public void func_76901_a(TileEntityEnchantmentTable p_76901_1_, double p_76901_2_, double p_76901_4_, double p_76901_6_, float p_76901_8_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_76901_2_ + 0.5F, (float)p_76901_4_ + 0.75F, (float)p_76901_6_ + 0.5F);
      float var9 = (float)p_76901_1_.field_70378_a + p_76901_8_;
      GL11.glTranslatef(0.0F, 0.1F + MathHelper.func_76126_a(var9 * 0.1F) * 0.01F, 0.0F);

      float var10;
      for(var10 = p_76901_1_.field_70380_h - p_76901_1_.field_70381_i; var10 >= 3.1415927F; var10 -= 6.2831855F) {
         ;
      }

      while(var10 < -3.1415927F) {
         var10 += 6.2831855F;
      }

      float var11 = p_76901_1_.field_70381_i + var10 * p_76901_8_;
      GL11.glRotatef(-var11 * 180.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
      this.func_76897_a("/item/book.png");
      float var12 = p_76901_1_.field_70377_c + (p_76901_1_.field_70375_b - p_76901_1_.field_70377_c) * p_76901_8_ + 0.25F;
      float var13 = p_76901_1_.field_70377_c + (p_76901_1_.field_70375_b - p_76901_1_.field_70377_c) * p_76901_8_ + 0.75F;
      var12 = (var12 - (float)MathHelper.func_76140_b((double)var12)) * 1.6F - 0.3F;
      var13 = (var13 - (float)MathHelper.func_76140_b((double)var13)) * 1.6F - 0.3F;
      if(var12 < 0.0F) {
         var12 = 0.0F;
      }

      if(var13 < 0.0F) {
         var13 = 0.0F;
      }

      if(var12 > 1.0F) {
         var12 = 1.0F;
      }

      if(var13 > 1.0F) {
         var13 = 1.0F;
      }

      float var14 = p_76901_1_.field_70372_g + (p_76901_1_.field_70371_f - p_76901_1_.field_70372_g) * p_76901_8_;
      GL11.glEnable(2884);
      this.field_76902_a.func_78088_a((Entity)null, var9, var12, var13, var14, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_) {
      this.func_76901_a((TileEntityEnchantmentTable)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
   }
}
