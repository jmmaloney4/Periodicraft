package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionHelper;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBrewingStand extends TileEntity implements ISidedInventory {

   private static final int[] field_102017_a = new int[]{3};
   private static final int[] field_102016_b = new int[]{0, 1, 2};
   private ItemStack[] field_70359_a = new ItemStack[4];
   private int field_70357_b;
   private int field_70358_c;
   private int field_70356_d;
   private String field_94132_e;


   public String func_70303_b() {
      return this.func_94042_c()?this.field_94132_e:"container.brewing";
   }

   public boolean func_94042_c() {
      return this.field_94132_e != null && this.field_94132_e.length() > 0;
   }

   public void func_94131_a(String p_94131_1_) {
      this.field_94132_e = p_94131_1_;
   }

   public int func_70302_i_() {
      return this.field_70359_a.length;
   }

   public void func_70316_g() {
      if(this.field_70357_b > 0) {
         --this.field_70357_b;
         if(this.field_70357_b == 0) {
            this.func_70353_r();
            this.func_70296_d();
         } else if(!this.func_70350_k()) {
            this.field_70357_b = 0;
            this.func_70296_d();
         } else if(this.field_70356_d != this.field_70359_a[3].field_77993_c) {
            this.field_70357_b = 0;
            this.func_70296_d();
         }
      } else if(this.func_70350_k()) {
         this.field_70357_b = 400;
         this.field_70356_d = this.field_70359_a[3].field_77993_c;
      }

      int var1 = this.func_70351_i();
      if(var1 != this.field_70358_c) {
         this.field_70358_c = var1;
         this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, var1, 2);
      }

      super.func_70316_g();
   }

   public int func_70355_t_() {
      return this.field_70357_b;
   }

   private boolean func_70350_k() {
      if(this.field_70359_a[3] != null && this.field_70359_a[3].field_77994_a > 0) {
         ItemStack var1 = this.field_70359_a[3];
         if(!Item.field_77698_e[var1.field_77993_c].func_77632_u()) {
            return false;
         } else {
            boolean var2 = false;

            for(int var3 = 0; var3 < 3; ++var3) {
               if(this.field_70359_a[var3] != null && this.field_70359_a[var3].field_77993_c == Item.field_77726_bs.field_77779_bT) {
                  int var4 = this.field_70359_a[var3].func_77960_j();
                  int var5 = this.func_70352_b(var4, var1);
                  if(!ItemPotion.func_77831_g(var4) && ItemPotion.func_77831_g(var5)) {
                     var2 = true;
                     break;
                  }

                  List var6 = Item.field_77726_bs.func_77834_f(var4);
                  List var7 = Item.field_77726_bs.func_77834_f(var5);
                  if((var4 <= 0 || var6 != var7) && (var6 == null || !var6.equals(var7) && var7 != null) && var4 != var5) {
                     var2 = true;
                     break;
                  }
               }
            }

            return var2;
         }
      } else {
         return false;
      }
   }

   private void func_70353_r() {
      if(this.func_70350_k()) {
         ItemStack var1 = this.field_70359_a[3];

         for(int var2 = 0; var2 < 3; ++var2) {
            if(this.field_70359_a[var2] != null && this.field_70359_a[var2].field_77993_c == Item.field_77726_bs.field_77779_bT) {
               int var3 = this.field_70359_a[var2].func_77960_j();
               int var4 = this.func_70352_b(var3, var1);
               List var5 = Item.field_77726_bs.func_77834_f(var3);
               List var6 = Item.field_77726_bs.func_77834_f(var4);
               if((var3 <= 0 || var5 != var6) && (var5 == null || !var5.equals(var6) && var6 != null)) {
                  if(var3 != var4) {
                     this.field_70359_a[var2].func_77964_b(var4);
                  }
               } else if(!ItemPotion.func_77831_g(var3) && ItemPotion.func_77831_g(var4)) {
                  this.field_70359_a[var2].func_77964_b(var4);
               }
            }
         }

         if(Item.field_77698_e[var1.field_77993_c].func_77634_r()) {
            this.field_70359_a[3] = new ItemStack(Item.field_77698_e[var1.field_77993_c].func_77668_q());
         } else {
            --this.field_70359_a[3].field_77994_a;
            if(this.field_70359_a[3].field_77994_a <= 0) {
               this.field_70359_a[3] = null;
            }
         }

      }
   }

   private int func_70352_b(int p_70352_1_, ItemStack p_70352_2_) {
      return p_70352_2_ == null?p_70352_1_:(Item.field_77698_e[p_70352_2_.field_77993_c].func_77632_u()?PotionHelper.func_77913_a(p_70352_1_, Item.field_77698_e[p_70352_2_.field_77993_c].func_77666_t()):p_70352_1_);
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      NBTTagList var2 = p_70307_1_.func_74761_m("Items");
      this.field_70359_a = new ItemStack[this.func_70302_i_()];

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         byte var5 = var4.func_74771_c("Slot");
         if(var5 >= 0 && var5 < this.field_70359_a.length) {
            this.field_70359_a[var5] = ItemStack.func_77949_a(var4);
         }
      }

      this.field_70357_b = p_70307_1_.func_74765_d("BrewTime");
      if(p_70307_1_.func_74764_b("CustomName")) {
         this.field_94132_e = p_70307_1_.func_74779_i("CustomName");
      }

   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74777_a("BrewTime", (short)this.field_70357_b);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_70359_a.length; ++var3) {
         if(this.field_70359_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_70359_a[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_70310_1_.func_74782_a("Items", var2);
      if(this.func_94042_c()) {
         p_70310_1_.func_74778_a("CustomName", this.field_94132_e);
      }

   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return p_70301_1_ >= 0 && p_70301_1_ < this.field_70359_a.length?this.field_70359_a[p_70301_1_]:null;
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(p_70298_1_ >= 0 && p_70298_1_ < this.field_70359_a.length) {
         ItemStack var3 = this.field_70359_a[p_70298_1_];
         this.field_70359_a[p_70298_1_] = null;
         return var3;
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(p_70304_1_ >= 0 && p_70304_1_ < this.field_70359_a.length) {
         ItemStack var2 = this.field_70359_a[p_70304_1_];
         this.field_70359_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      if(p_70299_1_ >= 0 && p_70299_1_ < this.field_70359_a.length) {
         this.field_70359_a[p_70299_1_] = p_70299_2_;
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
      return p_94041_1_ == 3?Item.field_77698_e[p_94041_2_.field_77993_c].func_77632_u():p_94041_2_.field_77993_c == Item.field_77726_bs.field_77779_bT || p_94041_2_.field_77993_c == Item.field_77729_bt.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public void func_70354_c(int p_70354_1_) {
      this.field_70357_b = p_70354_1_;
   }

   public int func_70351_i() {
      int var1 = 0;

      for(int var2 = 0; var2 < 3; ++var2) {
         if(this.field_70359_a[var2] != null) {
            var1 |= 1 << var2;
         }
      }

      return var1;
   }

   public int[] func_94128_d(int p_94128_1_) {
      return p_94128_1_ == 1?field_102017_a:field_102016_b;
   }

   public boolean func_102007_a(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
      return this.func_94041_b(p_102007_1_, p_102007_2_);
   }

   public boolean func_102008_b(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
      return true;
   }

}
