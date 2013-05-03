package net.minecraft.tileentity;

import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDispenser extends TileEntity implements IInventory {

   private ItemStack[] field_70363_a = new ItemStack[9];
   private Random field_70362_b = new Random();
   protected String field_94050_c;


   public int func_70302_i_() {
      return 9;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_70363_a[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_70363_a[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_70363_a[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_70363_a[p_70298_1_];
            this.field_70363_a[p_70298_1_] = null;
            this.func_70296_d();
            return var3;
         } else {
            var3 = this.field_70363_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_70363_a[p_70298_1_].field_77994_a == 0) {
               this.field_70363_a[p_70298_1_] = null;
            }

            this.func_70296_d();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_70363_a[p_70304_1_] != null) {
         ItemStack var2 = this.field_70363_a[p_70304_1_];
         this.field_70363_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public int func_70361_i() {
      int var1 = -1;
      int var2 = 1;

      for(int var3 = 0; var3 < this.field_70363_a.length; ++var3) {
         if(this.field_70363_a[var3] != null && this.field_70362_b.nextInt(var2++) == 0) {
            var1 = var3;
         }
      }

      return var1;
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_70363_a[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

      this.func_70296_d();
   }

   public int func_70360_a(ItemStack p_70360_1_) {
      for(int var2 = 0; var2 < this.field_70363_a.length; ++var2) {
         if(this.field_70363_a[var2] == null || this.field_70363_a[var2].field_77993_c == 0) {
            this.func_70299_a(var2, p_70360_1_);
            return var2;
         }
      }

      return -1;
   }

   public String func_70303_b() {
      return this.func_94042_c()?this.field_94050_c:"container.dispenser";
   }

   public void func_94049_a(String p_94049_1_) {
      this.field_94050_c = p_94049_1_;
   }

   public boolean func_94042_c() {
      return this.field_94050_c != null;
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      NBTTagList var2 = p_70307_1_.func_74761_m("Items");
      this.field_70363_a = new ItemStack[this.func_70302_i_()];

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_70363_a.length) {
            this.field_70363_a[var5] = ItemStack.func_77949_a(var4);
         }
      }

      if(p_70307_1_.func_74764_b("CustomName")) {
         this.field_94050_c = p_70307_1_.func_74779_i("CustomName");
      }

   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_70363_a.length; ++var3) {
         if(this.field_70363_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_70363_a[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_70310_1_.func_74782_a("Items", var2);
      if(this.func_94042_c()) {
         p_70310_1_.func_74778_a("CustomName", this.field_94050_c);
      }

   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this?false:p_70300_1_.func_70092_e((double)this.field_70329_l + 0.5D, (double)this.field_70330_m + 0.5D, (double)this.field_70327_n + 0.5D) <= 64.0D;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }
}
