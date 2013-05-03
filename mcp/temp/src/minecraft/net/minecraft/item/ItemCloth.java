package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCloth;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemCloth extends ItemBlock {

   public ItemCloth(int p_i3626_1_) {
      super(p_i3626_1_);
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77617_a(int p_77617_1_) {
      return Block.field_72101_ab.func_71858_a(2, BlockCloth.func_72238_e_(p_77617_1_));
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return super.func_77658_a() + "." + ItemDye.field_77860_a[BlockCloth.func_72238_e_(p_77667_1_.func_77960_j())];
   }
}
