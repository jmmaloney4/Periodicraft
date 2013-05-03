package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockContainer extends Block implements ITileEntityProvider {

   protected BlockContainer(int p_i10059_1_, Material p_i10059_2_) {
      super(p_i10059_1_, p_i10059_2_);
      this.field_72025_cg = true;
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      p_71852_1_.func_72932_q(p_71852_2_, p_71852_3_, p_71852_4_);
   }

   public boolean func_71883_b(World p_71883_1_, int p_71883_2_, int p_71883_3_, int p_71883_4_, int p_71883_5_, int p_71883_6_) {
      super.func_71883_b(p_71883_1_, p_71883_2_, p_71883_3_, p_71883_4_, p_71883_5_, p_71883_6_);
      TileEntity var7 = p_71883_1_.func_72796_p(p_71883_2_, p_71883_3_, p_71883_4_);
      return var7 != null?var7.func_70315_b(p_71883_5_, p_71883_6_):false;
   }
}
