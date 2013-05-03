package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLilyPad extends BlockFlower {

   protected BlockLilyPad(int p_i9099_1_) {
      super(p_i9099_1_);
      float var2 = 0.5F;
      float var3 = 0.015625F;
      this.func_71905_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var3, 0.5F + var2);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public int func_71857_b() {
      return 23;
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      if(p_71871_7_ == null || !(p_71871_7_ instanceof EntityBoat)) {
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return AxisAlignedBB.func_72332_a().func_72299_a((double)p_71872_2_ + this.field_72026_ch, (double)p_71872_3_ + this.field_72023_ci, (double)p_71872_4_ + this.field_72024_cj, (double)p_71872_2_ + this.field_72021_ck, (double)p_71872_3_ + this.field_72022_cl, (double)p_71872_4_ + this.field_72019_cm);
   }

   @SideOnly(Side.CLIENT)
   public int func_71933_m() {
      return 2129968;
   }

   @SideOnly(Side.CLIENT)
   public int func_71889_f_(int p_71889_1_) {
      return 2129968;
   }

   @SideOnly(Side.CLIENT)
   public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_) {
      return 2129968;
   }

   protected boolean func_72263_d_(int p_72263_1_) {
      return p_72263_1_ == Block.field_71943_B.field_71990_ca;
   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      return p_71854_3_ >= 0 && p_71854_3_ < 256?p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_ - 1, p_71854_4_) == Material.field_76244_g && p_71854_1_.func_72805_g(p_71854_2_, p_71854_3_ - 1, p_71854_4_) == 0:false;
   }
}
