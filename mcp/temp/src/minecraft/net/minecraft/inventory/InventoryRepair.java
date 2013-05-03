package net.minecraft.inventory;

import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;

class InventoryRepair extends InventoryBasic {

   // $FF: synthetic field
   final ContainerRepair field_82346_a;


   InventoryRepair(ContainerRepair p_i9033_1_, String p_i9033_2_, boolean p_i9033_3_, int p_i9033_4_) {
      super(p_i9033_2_, p_i9033_3_, p_i9033_4_);
      this.field_82346_a = p_i9033_1_;
   }

   public void func_70296_d() {
      super.func_70296_d();
      this.field_82346_a.func_75130_a(this);
   }

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }
}
