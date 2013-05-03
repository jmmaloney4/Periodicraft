package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

@SideOnly(Side.CLIENT)
public class ChestItemRenderHelper {

   public static ChestItemRenderHelper field_78545_a = new ChestItemRenderHelper();
   private TileEntityChest field_78543_b = new TileEntityChest();
   private TileEntityEnderChest field_78544_c = new TileEntityEnderChest();


   public void func_78542_a(Block p_78542_1_, int p_78542_2_, float p_78542_3_) {
      if(p_78542_1_.field_71990_ca == Block.field_72066_bS.field_71990_ca) {
         TileEntityRenderer.field_76963_a.func_76949_a(this.field_78544_c, 0.0D, 0.0D, 0.0D, 0.0F);
      } else {
         TileEntityRenderer.field_76963_a.func_76949_a(this.field_78543_b, 0.0D, 0.0D, 0.0D, 0.0F);
      }

   }

}
