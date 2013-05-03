package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSoulSand extends Block {

   public BlockSoulSand(int p_i9062_1_) {
      super(p_i9062_1_, Material.field_76251_o);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      float var5 = 0.125F;
      return AxisAlignedBB.func_72332_a().func_72299_a((double)p_71872_2_, (double)p_71872_3_, (double)p_71872_4_, (double)(p_71872_2_ + 1), (double)((float)(p_71872_3_ + 1) - var5), (double)(p_71872_4_ + 1));
   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      p_71869_5_.field_70159_w *= 0.4D;
      p_71869_5_.field_70179_y *= 0.4D;
   }
}
