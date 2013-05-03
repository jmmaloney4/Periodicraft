package net.minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBook extends Item {

   public ItemBook(int p_i8010_1_) {
      super(p_i8010_1_);
   }

   public boolean func_77616_k(ItemStack p_77616_1_) {
      return p_77616_1_.field_77994_a == 1;
   }

   public int func_77619_b() {
      return 1;
   }
}
