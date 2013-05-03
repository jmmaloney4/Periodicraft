package net.minecraft.entity.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.CallableItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ReportedException;

public class InventoryPlayer implements IInventory {

   public ItemStack[] field_70462_a = new ItemStack[36];
   public ItemStack[] field_70460_b = new ItemStack[4];
   public int field_70461_c = 0;
   @SideOnly(Side.CLIENT)
   private ItemStack field_70456_f;
   public EntityPlayer field_70458_d;
   private ItemStack field_70457_g;
   public boolean field_70459_e = false;


   public InventoryPlayer(EntityPlayer p_i3562_1_) {
      this.field_70458_d = p_i3562_1_;
   }

   public ItemStack func_70448_g() {
      return this.field_70461_c < 9 && this.field_70461_c >= 0?this.field_70462_a[this.field_70461_c]:null;
   }

   public static int func_70451_h() {
      return 9;
   }

   private int func_70446_h(int p_70446_1_) {
      for(int var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null && this.field_70462_a[var2].field_77993_c == p_70446_1_) {
            return var2;
         }
      }

      return -1;
   }

   @SideOnly(Side.CLIENT)
   private int func_70434_c(int p_70434_1_, int p_70434_2_) {
      for(int var3 = 0; var3 < this.field_70462_a.length; ++var3) {
         if(this.field_70462_a[var3] != null && this.field_70462_a[var3].field_77993_c == p_70434_1_ && this.field_70462_a[var3].func_77960_j() == p_70434_2_) {
            return var3;
         }
      }

      return -1;
   }

   private int func_70432_d(ItemStack p_70432_1_) {
      for(int var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null && this.field_70462_a[var2].field_77993_c == p_70432_1_.field_77993_c && this.field_70462_a[var2].func_77985_e() && this.field_70462_a[var2].field_77994_a < this.field_70462_a[var2].func_77976_d() && this.field_70462_a[var2].field_77994_a < this.func_70297_j_() && (!this.field_70462_a[var2].func_77981_g() || this.field_70462_a[var2].func_77960_j() == p_70432_1_.func_77960_j()) && ItemStack.func_77970_a(this.field_70462_a[var2], p_70432_1_)) {
            return var2;
         }
      }

      return -1;
   }

   public int func_70447_i() {
      for(int var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         if(this.field_70462_a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   @SideOnly(Side.CLIENT)
   public void func_70433_a(int p_70433_1_, int p_70433_2_, boolean p_70433_3_, boolean p_70433_4_) {
      boolean var5 = true;
      this.field_70456_f = this.func_70448_g();
      int var7;
      if(p_70433_3_) {
         var7 = this.func_70434_c(p_70433_1_, p_70433_2_);
      } else {
         var7 = this.func_70446_h(p_70433_1_);
      }

      if(var7 >= 0 && var7 < 9) {
         this.field_70461_c = var7;
      } else {
         if(p_70433_4_ && p_70433_1_ > 0) {
            int var6 = this.func_70447_i();
            if(var6 >= 0 && var6 < 9) {
               this.field_70461_c = var6;
            }

            this.func_70439_a(Item.field_77698_e[p_70433_1_], p_70433_2_);
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public void func_70453_c(int p_70453_1_) {
      if(p_70453_1_ > 0) {
         p_70453_1_ = 1;
      }

      if(p_70453_1_ < 0) {
         p_70453_1_ = -1;
      }

      for(this.field_70461_c -= p_70453_1_; this.field_70461_c < 0; this.field_70461_c += 9) {
         ;
      }

      while(this.field_70461_c >= 9) {
         this.field_70461_c -= 9;
      }

   }

   public int func_82347_b(int p_82347_1_, int p_82347_2_) {
      int var3 = 0;

      int var4;
      ItemStack var5;
      for(var4 = 0; var4 < this.field_70462_a.length; ++var4) {
         var5 = this.field_70462_a[var4];
         if(var5 != null && (p_82347_1_ <= -1 || var5.field_77993_c == p_82347_1_) && (p_82347_2_ <= -1 || var5.func_77960_j() == p_82347_2_)) {
            var3 += var5.field_77994_a;
            this.field_70462_a[var4] = null;
         }
      }

      for(var4 = 0; var4 < this.field_70460_b.length; ++var4) {
         var5 = this.field_70460_b[var4];
         if(var5 != null && (p_82347_1_ <= -1 || var5.field_77993_c == p_82347_1_) && (p_82347_2_ <= -1 || var5.func_77960_j() == p_82347_2_)) {
            var3 += var5.field_77994_a;
            this.field_70460_b[var4] = null;
         }
      }

      return var3;
   }

   @SideOnly(Side.CLIENT)
   public void func_70439_a(Item p_70439_1_, int p_70439_2_) {
      if(p_70439_1_ != null) {
         int var3 = this.func_70434_c(p_70439_1_.field_77779_bT, p_70439_2_);
         if(var3 >= 0) {
            this.field_70462_a[var3] = this.field_70462_a[this.field_70461_c];
         }

         if(this.field_70456_f != null && this.field_70456_f.func_77956_u() && this.func_70434_c(this.field_70456_f.field_77993_c, this.field_70456_f.func_77952_i()) == this.field_70461_c) {
            return;
         }

         this.field_70462_a[this.field_70461_c] = new ItemStack(Item.field_77698_e[p_70439_1_.field_77779_bT], 1, p_70439_2_);
      }

   }

   private int func_70452_e(ItemStack p_70452_1_) {
      int var2 = p_70452_1_.field_77993_c;
      int var3 = p_70452_1_.field_77994_a;
      int var4;
      if(p_70452_1_.func_77976_d() == 1) {
         var4 = this.func_70447_i();
         if(var4 < 0) {
            return var3;
         } else {
            if(this.field_70462_a[var4] == null) {
               this.field_70462_a[var4] = ItemStack.func_77944_b(p_70452_1_);
            }

            return 0;
         }
      } else {
         var4 = this.func_70432_d(p_70452_1_);
         if(var4 < 0) {
            var4 = this.func_70447_i();
         }

         if(var4 < 0) {
            return var3;
         } else {
            if(this.field_70462_a[var4] == null) {
               this.field_70462_a[var4] = new ItemStack(var2, 0, p_70452_1_.func_77960_j());
               if(p_70452_1_.func_77942_o()) {
                  this.field_70462_a[var4].func_77982_d((NBTTagCompound)p_70452_1_.func_77978_p().func_74737_b());
               }
            }

            int var5 = var3;
            if(var3 > this.field_70462_a[var4].func_77976_d() - this.field_70462_a[var4].field_77994_a) {
               var5 = this.field_70462_a[var4].func_77976_d() - this.field_70462_a[var4].field_77994_a;
            }

            if(var5 > this.func_70297_j_() - this.field_70462_a[var4].field_77994_a) {
               var5 = this.func_70297_j_() - this.field_70462_a[var4].field_77994_a;
            }

            if(var5 == 0) {
               return var3;
            } else {
               var3 -= var5;
               this.field_70462_a[var4].field_77994_a += var5;
               this.field_70462_a[var4].field_77992_b = 5;
               return var3;
            }
         }
      }
   }

   public void func_70429_k() {
      for(int var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         if(this.field_70462_a[var1] != null) {
            this.field_70462_a[var1].func_77945_a(this.field_70458_d.field_70170_p, this.field_70458_d, var1, this.field_70461_c == var1);
         }
      }

   }

   public boolean func_70435_d(int p_70435_1_) {
      int var2 = this.func_70446_h(p_70435_1_);
      if(var2 < 0) {
         return false;
      } else {
         if(--this.field_70462_a[var2].field_77994_a <= 0) {
            this.field_70462_a[var2] = null;
         }

         return true;
      }
   }

   public boolean func_70450_e(int p_70450_1_) {
      int var2 = this.func_70446_h(p_70450_1_);
      return var2 >= 0;
   }

   public boolean func_70441_a(ItemStack p_70441_1_) {
      if(p_70441_1_ == null) {
         return false;
      } else {
         try {
            int var2;
            if(p_70441_1_.func_77951_h()) {
               var2 = this.func_70447_i();
               if(var2 >= 0) {
                  this.field_70462_a[var2] = ItemStack.func_77944_b(p_70441_1_);
                  this.field_70462_a[var2].field_77992_b = 5;
                  p_70441_1_.field_77994_a = 0;
                  return true;
               } else if(this.field_70458_d.field_71075_bZ.field_75098_d) {
                  p_70441_1_.field_77994_a = 0;
                  return true;
               } else {
                  return false;
               }
            } else {
               do {
                  var2 = p_70441_1_.field_77994_a;
                  p_70441_1_.field_77994_a = this.func_70452_e(p_70441_1_);
               } while(p_70441_1_.field_77994_a > 0 && p_70441_1_.field_77994_a < var2);

               if(p_70441_1_.field_77994_a == var2 && this.field_70458_d.field_71075_bZ.field_75098_d) {
                  p_70441_1_.field_77994_a = 0;
                  return true;
               } else {
                  return p_70441_1_.field_77994_a < var2;
               }
            }
         } catch (Throwable var5) {
            CrashReport var3 = CrashReport.func_85055_a(var5, "Adding item to inventory");
            CrashReportCategory var4 = var3.func_85058_a("Item being added");
            var4.func_71507_a("Item ID", Integer.valueOf(p_70441_1_.field_77993_c));
            var4.func_71507_a("Item data", Integer.valueOf(p_70441_1_.func_77960_j()));
            var4.func_71500_a("Item name", new CallableItemName(this, p_70441_1_));
            throw new ReportedException(var3);
         }
      }
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      ItemStack[] var3 = this.field_70462_a;
      if(p_70298_1_ >= this.field_70462_a.length) {
         var3 = this.field_70460_b;
         p_70298_1_ -= this.field_70462_a.length;
      }

      if(var3[p_70298_1_] != null) {
         ItemStack var4;
         if(var3[p_70298_1_].field_77994_a <= p_70298_2_) {
            var4 = var3[p_70298_1_];
            var3[p_70298_1_] = null;
            return var4;
         } else {
            var4 = var3[p_70298_1_].func_77979_a(p_70298_2_);
            if(var3[p_70298_1_].field_77994_a == 0) {
               var3[p_70298_1_] = null;
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      ItemStack[] var2 = this.field_70462_a;
      if(p_70304_1_ >= this.field_70462_a.length) {
         var2 = this.field_70460_b;
         p_70304_1_ -= this.field_70462_a.length;
      }

      if(var2[p_70304_1_] != null) {
         ItemStack var3 = var2[p_70304_1_];
         var2[p_70304_1_] = null;
         return var3;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      ItemStack[] var3 = this.field_70462_a;
      if(p_70299_1_ >= var3.length) {
         p_70299_1_ -= var3.length;
         var3 = this.field_70460_b;
      }

      var3[p_70299_1_] = p_70299_2_;
   }

   public float func_70438_a(Block p_70438_1_) {
      float var2 = 1.0F;
      if(this.field_70462_a[this.field_70461_c] != null) {
         var2 *= this.field_70462_a[this.field_70461_c].func_77967_a(p_70438_1_);
      }

      return var2;
   }

   public NBTTagList func_70442_a(NBTTagList p_70442_1_) {
      int var2;
      NBTTagCompound var3;
      for(var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null) {
            var3 = new NBTTagCompound();
            var3.func_74774_a("Slot", (byte)var2);
            this.field_70462_a[var2].func_77955_b(var3);
            p_70442_1_.func_74742_a(var3);
         }
      }

      for(var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null) {
            var3 = new NBTTagCompound();
            var3.func_74774_a("Slot", (byte)(var2 + 100));
            this.field_70460_b[var2].func_77955_b(var3);
            p_70442_1_.func_74742_a(var3);
         }
      }

      return p_70442_1_;
   }

   public void func_70443_b(NBTTagList p_70443_1_) {
      this.field_70462_a = new ItemStack[36];
      this.field_70460_b = new ItemStack[4];

      for(int var2 = 0; var2 < p_70443_1_.func_74745_c(); ++var2) {
         NBTTagCompound var3 = (NBTTagCompound)p_70443_1_.func_74743_b(var2);
         int var4 = var3.func_74771_c("Slot") & 255;
         ItemStack var5 = ItemStack.func_77949_a(var3);
         if(var5 != null) {
            if(var4 >= 0 && var4 < this.field_70462_a.length) {
               this.field_70462_a[var4] = var5;
            }

            if(var4 >= 100 && var4 < this.field_70460_b.length + 100) {
               this.field_70460_b[var4 - 100] = var5;
            }
         }
      }

   }

   public int func_70302_i_() {
      return this.field_70462_a.length + 4;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      ItemStack[] var2 = this.field_70462_a;
      if(p_70301_1_ >= var2.length) {
         p_70301_1_ -= var2.length;
         var2 = this.field_70460_b;
      }

      return var2[p_70301_1_];
   }

   public String func_70303_b() {
      return "container.inventory";
   }

   public boolean func_94042_c() {
      return false;
   }

   public int func_70297_j_() {
      return 64;
   }

   public int func_70444_a(Entity p_70444_1_) {
      ItemStack var2 = this.func_70301_a(this.field_70461_c);
      return var2 != null?var2.func_77971_a(p_70444_1_):1;
   }

   public boolean func_70454_b(Block p_70454_1_) {
      if(p_70454_1_.field_72018_cp.func_76229_l()) {
         return true;
      } else {
         ItemStack var2 = this.func_70301_a(this.field_70461_c);
         return var2 != null?var2.func_77987_b(p_70454_1_):false;
      }
   }

   public ItemStack func_70440_f(int p_70440_1_) {
      return this.field_70460_b[p_70440_1_];
   }

   public int func_70430_l() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null && this.field_70460_b[var2].func_77973_b() instanceof ItemArmor) {
            int var3 = ((ItemArmor)this.field_70460_b[var2].func_77973_b()).field_77879_b;
            var1 += var3;
         }
      }

      return var1;
   }

   public void func_70449_g(int p_70449_1_) {
      p_70449_1_ /= 4;
      if(p_70449_1_ < 1) {
         p_70449_1_ = 1;
      }

      for(int var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null && this.field_70460_b[var2].func_77973_b() instanceof ItemArmor) {
            this.field_70460_b[var2].func_77972_a(p_70449_1_, this.field_70458_d);
            if(this.field_70460_b[var2].field_77994_a == 0) {
               this.field_70460_b[var2] = null;
            }
         }
      }

   }

   public void func_70436_m() {
      int var1;
      for(var1 = 0; var1 < this.field_70462_a.length; ++var1) {
         if(this.field_70462_a[var1] != null) {
            this.field_70458_d.func_71019_a(this.field_70462_a[var1], true);
            this.field_70462_a[var1] = null;
         }
      }

      for(var1 = 0; var1 < this.field_70460_b.length; ++var1) {
         if(this.field_70460_b[var1] != null) {
            this.field_70458_d.func_71019_a(this.field_70460_b[var1], true);
            this.field_70460_b[var1] = null;
         }
      }

   }

   public void func_70296_d() {
      this.field_70459_e = true;
   }

   public void func_70437_b(ItemStack p_70437_1_) {
      this.field_70457_g = p_70437_1_;
   }

   public ItemStack func_70445_o() {
      return this.field_70457_g;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70458_d.field_70128_L?false:p_70300_1_.func_70068_e(this.field_70458_d) <= 64.0D;
   }

   public boolean func_70431_c(ItemStack p_70431_1_) {
      int var2;
      for(var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         if(this.field_70460_b[var2] != null && this.field_70460_b[var2].func_77969_a(p_70431_1_)) {
            return true;
         }
      }

      for(var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         if(this.field_70462_a[var2] != null && this.field_70462_a[var2].func_77969_a(p_70431_1_)) {
            return true;
         }
      }

      return false;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public void func_70455_b(InventoryPlayer p_70455_1_) {
      int var2;
      for(var2 = 0; var2 < this.field_70462_a.length; ++var2) {
         this.field_70462_a[var2] = ItemStack.func_77944_b(p_70455_1_.field_70462_a[var2]);
      }

      for(var2 = 0; var2 < this.field_70460_b.length; ++var2) {
         this.field_70460_b[var2] = ItemStack.func_77944_b(p_70455_1_.field_70460_b[var2]);
      }

      this.field_70461_c = p_70455_1_.field_70461_c;
   }
}
