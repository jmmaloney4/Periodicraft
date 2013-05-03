package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryCrafting implements IInventory {

   private ItemStack[] field_70466_a;
   private int field_70464_b;
   private Container field_70465_c;


   public InventoryCrafting(Container p_i3602_1_, int p_i3602_2_, int p_i3602_3_) {
      int var4 = p_i3602_2_ * p_i3602_3_;
      this.field_70466_a = new ItemStack[var4];
      this.field_70465_c = p_i3602_1_;
      this.field_70464_b = p_i3602_2_;
   }

   public int func_70302_i_() {
      return this.field_70466_a.length;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return p_70301_1_ >= this.func_70302_i_()?null:this.field_70466_a[p_70301_1_];
   }

   public ItemStack func_70463_b(int p_70463_1_, int p_70463_2_) {
      if(p_70463_1_ >= 0 && p_70463_1_ < this.field_70464_b) {
         int var3 = p_70463_1_ + p_70463_2_ * this.field_70464_b;
         return this.func_70301_a(var3);
      } else {
         return null;
      }
   }

   public String func_70303_b() {
      return "container.crafting";
   }

   public boolean func_94042_c() {
      return false;
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_70466_a[p_70304_1_] != null) {
         ItemStack var2 = this.field_70466_a[p_70304_1_];
         this.field_70466_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_70466_a[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_70466_a[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_70466_a[p_70298_1_];
            this.field_70466_a[p_70298_1_] = null;
            this.field_70465_c.func_75130_a(this);
            return var3;
         } else {
            var3 = this.field_70466_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_70466_a[p_70298_1_].field_77994_a == 0) {
               this.field_70466_a[p_70298_1_] = null;
            }

            this.field_70465_c.func_75130_a(this);
            return var3;
         }
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_70466_a[p_70299_1_] = p_70299_2_;
      this.field_70465_c.func_75130_a(this);
   }

   public int func_70297_j_() {
      return 64;
   }

   public void func_70296_d() {}

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return true;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }
}
