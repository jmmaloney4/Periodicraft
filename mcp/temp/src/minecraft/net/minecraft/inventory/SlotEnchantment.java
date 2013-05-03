package net.minecraft.inventory;

import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

class SlotEnchantment extends Slot {

   // $FF: synthetic field
   final ContainerEnchantment field_75227_a;


   SlotEnchantment(ContainerEnchantment p_i3605_1_, IInventory p_i3605_2_, int p_i3605_3_, int p_i3605_4_, int p_i3605_5_) {
      super(p_i3605_2_, p_i3605_3_, p_i3605_4_, p_i3605_5_);
      this.field_75227_a = p_i3605_1_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return true;
   }
}
