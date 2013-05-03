package net.minecraft.block;

import net.minecraft.block.BlockOreStorage;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

public class BlockPoweredOre extends BlockOreStorage {

   public BlockPoweredOre(int p_i9013_1_) {
      super(p_i9013_1_);
      this.func_71849_a(CreativeTabs.field_78028_d);
   }

   public boolean func_71853_i() {
      return true;
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      return 15;
   }
}
