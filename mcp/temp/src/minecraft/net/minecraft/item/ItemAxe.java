package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemAxe extends ItemTool {

   public static final Block[] field_77868_c = new Block[]{Block.field_71988_x, Block.field_72093_an, Block.field_71951_J, Block.field_72077_au, Block.field_72085_aj, Block.field_72079_ak, Block.field_72061_ba, Block.field_72008_bf};


   public ItemAxe(int p_i3656_1_, EnumToolMaterial p_i3656_2_) {
      super(p_i3656_1_, 3, p_i3656_2_, field_77868_c);
   }

   public float func_77638_a(ItemStack p_77638_1_, Block p_77638_2_) {
      return p_77638_2_ != null && (p_77638_2_.field_72018_cp == Material.field_76245_d || p_77638_2_.field_72018_cp == Material.field_76254_j || p_77638_2_.field_72018_cp == Material.field_76255_k)?this.field_77864_a:super.func_77638_a(p_77638_1_, p_77638_2_);
   }

}
