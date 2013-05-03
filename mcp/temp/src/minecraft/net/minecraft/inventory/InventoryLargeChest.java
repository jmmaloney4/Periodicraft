package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryLargeChest implements IInventory {

   private String field_70479_a;
   private IInventory field_70477_b;
   private IInventory field_70478_c;


   public InventoryLargeChest(String p_i3425_1_, IInventory p_i3425_2_, IInventory p_i3425_3_) {
      this.field_70479_a = p_i3425_1_;
      if(p_i3425_2_ == null) {
         p_i3425_2_ = p_i3425_3_;
      }

      if(p_i3425_3_ == null) {
         p_i3425_3_ = p_i3425_2_;
      }

      this.field_70477_b = p_i3425_2_;
      this.field_70478_c = p_i3425_3_;
   }

   public int func_70302_i_() {
      return this.field_70477_b.func_70302_i_() + this.field_70478_c.func_70302_i_();
   }

   public boolean func_90010_a(IInventory p_90010_1_) {
      return this.field_70477_b == p_90010_1_ || this.field_70478_c == p_90010_1_;
   }

   public String func_70303_b() {
      return this.field_70477_b.func_94042_c()?this.field_70477_b.func_70303_b():(this.field_70478_c.func_94042_c()?this.field_70478_c.func_70303_b():this.field_70479_a);
   }

   public boolean func_94042_c() {
      return this.field_70477_b.func_94042_c() || this.field_70478_c.func_94042_c();
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return p_70301_1_ >= this.field_70477_b.func_70302_i_()?this.field_70478_c.func_70301_a(p_70301_1_ - this.field_70477_b.func_70302_i_()):this.field_70477_b.func_70301_a(p_70301_1_);
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      return p_70298_1_ >= this.field_70477_b.func_70302_i_()?this.field_70478_c.func_70298_a(p_70298_1_ - this.field_70477_b.func_70302_i_(), p_70298_2_):this.field_70477_b.func_70298_a(p_70298_1_, p_70298_2_);
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      return p_70304_1_ >= this.field_70477_b.func_70302_i_()?this.field_70478_c.func_70304_b(p_70304_1_ - this.field_70477_b.func_70302_i_()):this.field_70477_b.func_70304_b(p_70304_1_);
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      if(p_70299_1_ >= this.field_70477_b.func_70302_i_()) {
         this.field_70478_c.func_70299_a(p_70299_1_ - this.field_70477_b.func_70302_i_(), p_70299_2_);
      } else {
         this.field_70477_b.func_70299_a(p_70299_1_, p_70299_2_);
      }

   }

   public int func_70297_j_() {
      return this.field_70477_b.func_70297_j_();
   }

   public void func_70296_d() {
      this.field_70477_b.func_70296_d();
      this.field_70478_c.func_70296_d();
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70477_b.func_70300_a(p_70300_1_) && this.field_70478_c.func_70300_a(p_70300_1_);
   }

   public void func_70295_k_() {
      this.field_70477_b.func_70295_k_();
      this.field_70478_c.func_70295_k_();
   }

   public void func_70305_f() {
      this.field_70477_b.func_70305_f();
      this.field_70478_c.func_70305_f();
   }

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }
}
