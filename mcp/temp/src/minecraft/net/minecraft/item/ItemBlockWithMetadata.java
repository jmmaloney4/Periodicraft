package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.Icon;

public class ItemBlockWithMetadata extends ItemBlock {

   private Block field_96601_a;


   public ItemBlockWithMetadata(int p_i10057_1_, Block p_i10057_2_) {
      super(p_i10057_1_);
      this.field_96601_a = p_i10057_2_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77617_a(int p_77617_1_) {
      return this.field_96601_a.func_71858_a(2, p_77617_1_);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }
}
