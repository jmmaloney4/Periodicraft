package net.minecraft.inventory;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class InventoryMerchant implements IInventory {

   private final IMerchant field_70476_a;
   private ItemStack[] field_70474_b = new ItemStack[3];
   private final EntityPlayer field_70475_c;
   private MerchantRecipe field_70472_d;
   private int field_70473_e;


   public InventoryMerchant(EntityPlayer p_i3612_1_, IMerchant p_i3612_2_) {
      this.field_70475_c = p_i3612_1_;
      this.field_70476_a = p_i3612_2_;
   }

   public int func_70302_i_() {
      return this.field_70474_b.length;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_70474_b[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_70474_b[p_70298_1_] != null) {
         ItemStack var3;
         if(p_70298_1_ == 2) {
            var3 = this.field_70474_b[p_70298_1_];
            this.field_70474_b[p_70298_1_] = null;
            return var3;
         } else if(this.field_70474_b[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_70474_b[p_70298_1_];
            this.field_70474_b[p_70298_1_] = null;
            if(this.func_70469_d(p_70298_1_)) {
               this.func_70470_g();
            }

            return var3;
         } else {
            var3 = this.field_70474_b[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_70474_b[p_70298_1_].field_77994_a == 0) {
               this.field_70474_b[p_70298_1_] = null;
            }

            if(this.func_70469_d(p_70298_1_)) {
               this.func_70470_g();
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   private boolean func_70469_d(int p_70469_1_) {
      return p_70469_1_ == 0 || p_70469_1_ == 1;
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_70474_b[p_70304_1_] != null) {
         ItemStack var2 = this.field_70474_b[p_70304_1_];
         this.field_70474_b[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_70474_b[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

      if(this.func_70469_d(p_70299_1_)) {
         this.func_70470_g();
      }

   }

   public String func_70303_b() {
      return "mob.villager";
   }

   public boolean func_94042_c() {
      return false;
   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70476_a.func_70931_l_() == p_70300_1_;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public void func_70296_d() {
      this.func_70470_g();
   }

   public void func_70470_g() {
      this.field_70472_d = null;
      ItemStack var1 = this.field_70474_b[0];
      ItemStack var2 = this.field_70474_b[1];
      if(var1 == null) {
         var1 = var2;
         var2 = null;
      }

      if(var1 == null) {
         this.func_70299_a(2, (ItemStack)null);
      } else {
         MerchantRecipeList var3 = this.field_70476_a.func_70934_b(this.field_70475_c);
         if(var3 != null) {
            MerchantRecipe var4 = var3.func_77203_a(var1, var2, this.field_70473_e);
            if(var4 != null && !var4.func_82784_g()) {
               this.field_70472_d = var4;
               this.func_70299_a(2, var4.func_77397_d().func_77946_l());
            } else if(var2 != null) {
               var4 = var3.func_77203_a(var2, var1, this.field_70473_e);
               if(var4 != null && !var4.func_82784_g()) {
                  this.field_70472_d = var4;
                  this.func_70299_a(2, var4.func_77397_d().func_77946_l());
               } else {
                  this.func_70299_a(2, (ItemStack)null);
               }
            } else {
               this.func_70299_a(2, (ItemStack)null);
            }
         }
      }

   }

   public MerchantRecipe func_70468_h() {
      return this.field_70472_d;
   }

   public void func_70471_c(int p_70471_1_) {
      this.field_70473_e = p_70471_1_;
      this.func_70470_g();
   }
}
