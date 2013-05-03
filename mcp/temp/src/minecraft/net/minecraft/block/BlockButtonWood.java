package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.util.Icon;

public class BlockButtonWood extends BlockButton {

   protected BlockButtonWood(int p_i9017_1_) {
      super(p_i9017_1_, true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return Block.field_71988_x.func_71851_a(1);
   }
}
