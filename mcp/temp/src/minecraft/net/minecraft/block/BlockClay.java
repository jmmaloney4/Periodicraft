package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockClay extends Block {

   public BlockClay(int p_i9046_1_) {
      super(p_i9046_1_, Material.field_76267_y);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77757_aI.field_77779_bT;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 4;
   }
}
