package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.item.ItemMultiTextureTile;

public class ItemAnvilBlock extends ItemMultiTextureTile {

   public ItemAnvilBlock(Block p_i5081_1_) {
      super(p_i5081_1_.field_71990_ca - 256, p_i5081_1_, BlockAnvil.field_82522_a);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_ << 2;
   }
}
