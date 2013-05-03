package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

class SlotArmor extends Slot {

   // $FF: synthetic field
   final int field_75236_a;
   // $FF: synthetic field
   final ContainerPlayer field_75235_b;


   SlotArmor(ContainerPlayer p_i3609_1_, IInventory p_i3609_2_, int p_i3609_3_, int p_i3609_4_, int p_i3609_5_, int p_i3609_6_) {
      super(p_i3609_2_, p_i3609_3_, p_i3609_4_, p_i3609_5_);
      this.field_75235_b = p_i3609_1_;
      this.field_75236_a = p_i3609_6_;
   }

   public int func_75219_a() {
      return 1;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return p_75214_1_ == null?false:(p_75214_1_.func_77973_b() instanceof ItemArmor?((ItemArmor)p_75214_1_.func_77973_b()).field_77881_a == this.field_75236_a:(p_75214_1_.func_77973_b().field_77779_bT != Block.field_72061_ba.field_71990_ca && p_75214_1_.func_77973_b().field_77779_bT != Item.field_82799_bQ.field_77779_bT?false:this.field_75236_a == 0));
   }

   @SideOnly(Side.CLIENT)
   public Icon func_75212_b() {
      return ItemArmor.func_94602_b(this.field_75236_a);
   }
}
