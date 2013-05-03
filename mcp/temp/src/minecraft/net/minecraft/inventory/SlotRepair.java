package net.minecraft.inventory;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

class SlotRepair extends Slot {

   // $FF: synthetic field
   final World field_82875_a;
   // $FF: synthetic field
   final int field_82873_b;
   // $FF: synthetic field
   final int field_82874_c;
   // $FF: synthetic field
   final int field_82871_d;
   // $FF: synthetic field
   final ContainerRepair field_82872_e;


   SlotRepair(ContainerRepair p_i5079_1_, IInventory p_i5079_2_, int p_i5079_3_, int p_i5079_4_, int p_i5079_5_, World p_i5079_6_, int p_i5079_7_, int p_i5079_8_, int p_i5079_9_) {
      super(p_i5079_2_, p_i5079_3_, p_i5079_4_, p_i5079_5_);
      this.field_82872_e = p_i5079_1_;
      this.field_82875_a = p_i5079_6_;
      this.field_82873_b = p_i5079_7_;
      this.field_82874_c = p_i5079_8_;
      this.field_82871_d = p_i5079_9_;
   }

   public boolean func_75214_a(ItemStack p_75214_1_) {
      return false;
   }

   public boolean func_82869_a(EntityPlayer p_82869_1_) {
      return (p_82869_1_.field_71075_bZ.field_75098_d || p_82869_1_.field_71068_ca >= this.field_82872_e.field_82854_e) && this.field_82872_e.field_82854_e > 0 && this.func_75216_d();
   }

   public void func_82870_a(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
      if(!p_82870_1_.field_71075_bZ.field_75098_d) {
         p_82870_1_.func_82242_a(-this.field_82872_e.field_82854_e);
      }

      ContainerRepair.func_82851_a(this.field_82872_e).func_70299_a(0, (ItemStack)null);
      if(ContainerRepair.func_82849_b(this.field_82872_e) > 0) {
         ItemStack var3 = ContainerRepair.func_82851_a(this.field_82872_e).func_70301_a(1);
         if(var3 != null && var3.field_77994_a > ContainerRepair.func_82849_b(this.field_82872_e)) {
            var3.field_77994_a -= ContainerRepair.func_82849_b(this.field_82872_e);
            ContainerRepair.func_82851_a(this.field_82872_e).func_70299_a(1, var3);
         } else {
            ContainerRepair.func_82851_a(this.field_82872_e).func_70299_a(1, (ItemStack)null);
         }
      } else {
         ContainerRepair.func_82851_a(this.field_82872_e).func_70299_a(1, (ItemStack)null);
      }

      this.field_82872_e.field_82854_e = 0;
      if(!p_82870_1_.field_71075_bZ.field_75098_d && !this.field_82875_a.field_72995_K && this.field_82875_a.func_72798_a(this.field_82873_b, this.field_82874_c, this.field_82871_d) == Block.field_82510_ck.field_71990_ca && p_82870_1_.func_70681_au().nextFloat() < 0.12F) {
         int var6 = this.field_82875_a.func_72805_g(this.field_82873_b, this.field_82874_c, this.field_82871_d);
         int var4 = var6 & 3;
         int var5 = var6 >> 2;
         ++var5;
         if(var5 > 2) {
            this.field_82875_a.func_94571_i(this.field_82873_b, this.field_82874_c, this.field_82871_d);
            this.field_82875_a.func_72926_e(1020, this.field_82873_b, this.field_82874_c, this.field_82871_d, 0);
         } else {
            this.field_82875_a.func_72921_c(this.field_82873_b, this.field_82874_c, this.field_82871_d, var4 | var5 << 2, 2);
            this.field_82875_a.func_72926_e(1021, this.field_82873_b, this.field_82874_c, this.field_82871_d, 0);
         }
      } else if(!this.field_82875_a.field_72995_K) {
         this.field_82875_a.func_72926_e(1021, this.field_82873_b, this.field_82874_c, this.field_82871_d, 0);
      }

   }
}
