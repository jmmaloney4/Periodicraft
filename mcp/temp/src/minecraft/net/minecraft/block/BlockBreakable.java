package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;

public class BlockBreakable extends Block {

   private boolean field_72245_a;
   private String field_94430_b;


   protected BlockBreakable(int p_i9059_1_, String p_i9059_2_, Material p_i9059_3_, boolean p_i9059_4_) {
      super(p_i9059_1_, p_i9059_3_);
      this.field_72245_a = p_i9059_4_;
      this.field_94430_b = p_i9059_2_;
   }

   public boolean func_71926_d() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      int var6 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_);
      return !this.field_72245_a && var6 == this.field_71990_ca?false:super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_94430_b);
   }
}
