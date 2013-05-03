package net.minecraft.inventory;

import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;

class SlotEnchantmentTable extends InventoryBasic {

   // $FF: synthetic field
   final ContainerEnchantment field_70484_a;


   SlotEnchantmentTable(ContainerEnchantment p_i9031_1_, String p_i9031_2_, boolean p_i9031_3_, int p_i9031_4_) {
      super(p_i9031_2_, p_i9031_3_, p_i9031_4_);
      this.field_70484_a = p_i9031_1_;
   }

   public int func_70297_j_() {
      return 1;
   }

   public void func_70296_d() {
      super.func_70296_d();
      this.field_70484_a.func_75130_a(this);
   }

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }
}
