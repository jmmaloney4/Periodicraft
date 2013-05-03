package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.BlockSand;
import net.minecraft.item.Item;

public class BlockGravel extends BlockSand {

   public BlockGravel(int p_i9058_1_) {
      super(p_i9058_1_);
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      if(p_71885_3_ > 3) {
         p_71885_3_ = 3;
      }

      return p_71885_2_.nextInt(10 - p_71885_3_ * 3) == 0?Item.field_77804_ap.field_77779_bT:this.field_71990_ca;
   }
}
