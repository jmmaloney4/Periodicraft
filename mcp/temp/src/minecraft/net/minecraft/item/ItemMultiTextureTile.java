package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemMultiTextureTile extends ItemBlock {

   private final Block field_82805_a;
   private final String[] field_82804_b;


   public ItemMultiTextureTile(int p_i5085_1_, Block p_i5085_2_, String[] p_i5085_3_) {
      super(p_i5085_1_);
      this.field_82805_a = p_i5085_2_;
      this.field_82804_b = p_i5085_3_;
      this.func_77656_e(0);
      this.func_77627_a(true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_77617_a(int p_77617_1_) {
      return this.field_82805_a.func_71858_a(2, p_77617_1_);
   }

   public int func_77647_b(int p_77647_1_) {
      return p_77647_1_;
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      int var2 = p_77667_1_.func_77960_j();
      if(var2 < 0 || var2 >= this.field_82804_b.length) {
         var2 = 0;
      }

      return super.func_77658_a() + "." + this.field_82804_b[var2];
   }
}
