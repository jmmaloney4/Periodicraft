package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChest extends Container {

   private IInventory field_75155_e;
   private int field_75154_f;


   public ContainerChest(IInventory p_i3601_1_, IInventory p_i3601_2_) {
      this.field_75155_e = p_i3601_2_;
      this.field_75154_f = p_i3601_2_.func_70302_i_() / 9;
      p_i3601_2_.func_70295_k_();
      int var3 = (this.field_75154_f - 4) * 18;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field_75154_f; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.func_75146_a(new Slot(p_i3601_2_, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.func_75146_a(new Slot(p_i3601_1_, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.func_75146_a(new Slot(p_i3601_1_, var4, 8 + var4 * 18, 161 + var3));
      }

   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75155_e.func_70300_a(p_75145_1_);
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if(p_82846_2_ < this.field_75154_f * 9) {
            if(!this.func_75135_a(var5, this.field_75154_f * 9, this.field_75151_b.size(), true)) {
               return null;
            }
         } else if(!this.func_75135_a(var5, 0, this.field_75154_f * 9, false)) {
            return null;
         }

         if(var5.field_77994_a == 0) {
            var4.func_75215_d((ItemStack)null);
         } else {
            var4.func_75218_e();
         }
      }

      return var3;
   }

   public void func_75134_a(EntityPlayer p_75134_1_) {
      super.func_75134_a(p_75134_1_);
      this.field_75155_e.func_70305_f();
   }

   public IInventory func_85151_d() {
      return this.field_75155_e;
   }
}
