package net.minecraft.inventory;

import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

class SlotBeacon extends Slot {

   // $FF: synthetic field
   final ContainerBeacon field_82876_a;


   public SlotBeacon(ContainerBeacon p_i5075_1_, IInventory p_i5075_2_, int p_i5075_3_, int p_i5075_4_, int p_i5075_5_) {
      super(p_i5075_2_, p_i5075_3_, p_i5075_4_, p_i5075_5_);
      this.field_82876_a = p_i5075_1_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return p_75214_1_ == null?false:p_75214_1_.field_77993_c == Item.field_77817_bH.field_77779_bT || p_75214_1_.field_77993_c == Item.field_77702_n.field_77779_bT || p_75214_1_.field_77993_c == Item.field_77717_p.field_77779_bT || p_75214_1_.field_77993_c == Item.field_77703_o.field_77779_bT;
   }

   public int func_75219_a() {
      return 1;
   }
}
