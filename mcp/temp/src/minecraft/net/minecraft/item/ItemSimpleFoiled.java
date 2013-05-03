package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSimpleFoiled extends Item {

   public ItemSimpleFoiled(int p_i5087_1_) {
      super(p_i5087_1_);
   }

   @SideOnly(Side.CLIENT)
   public boolean func_77636_d(ItemStack p_77636_1_) {
      return true;
   }
}
