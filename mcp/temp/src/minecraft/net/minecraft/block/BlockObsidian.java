package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;

public class BlockObsidian extends BlockStone {

   public BlockObsidian(int p_i9075_1_) {
      super(p_i9075_1_);
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72089_ap.field_71990_ca;
   }
}
