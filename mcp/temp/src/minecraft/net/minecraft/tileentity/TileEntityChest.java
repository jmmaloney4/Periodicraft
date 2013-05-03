package net.minecraft.tileentity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityChest extends TileEntity implements IInventory {

   private ItemStack[] field_70428_i = new ItemStack[36];
   public boolean field_70425_a = false;
   public TileEntityChest field_70423_b;
   public TileEntityChest field_70424_c;
   public TileEntityChest field_70421_d;
   public TileEntityChest field_70422_e;
   public float field_70419_f;
   public float field_70420_g;
   public int field_70427_h;
   private int field_70426_j;
   private int field_94046_i = -1;
   private String field_94045_s;


   public int func_70302_i_() {
      return 27;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_70428_i[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_70428_i[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_70428_i[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_70428_i[p_70298_1_];
            this.field_70428_i[p_70298_1_] = null;
            this.func_70296_d();
            return var3;
         } else {
            var3 = this.field_70428_i[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_70428_i[p_70298_1_].field_77994_a == 0) {
               this.field_70428_i[p_70298_1_] = null;
            }

            this.func_70296_d();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_70428_i[p_70304_1_] != null) {
         ItemStack var2 = this.field_70428_i[p_70304_1_];
         this.field_70428_i[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_70428_i[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

      this.func_70296_d();
   }

   public String func_70303_b() {
      return this.func_94042_c()?this.field_94045_s:"container.chest";
   }

   public boolean func_94042_c() {
      return this.field_94045_s != null && this.field_94045_s.length() > 0;
   }

   public void func_94043_a(String p_94043_1_) {
      this.field_94045_s = p_94043_1_;
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      NBTTagList var2 = p_70307_1_.func_74761_m("Items");
      this.field_70428_i = new ItemStack[this.func_70302_i_()];
      if(p_70307_1_.func_74764_b("CustomName")) {
         this.field_94045_s = p_70307_1_.func_74779_i("CustomName");
      }

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_70428_i.length) {
            this.field_70428_i[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_70428_i.length; ++var3) {
         if(this.field_70428_i[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_70428_i[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_70310_1_.func_74782_a("Items", var2);
      if(this.func_94042_c()) {
         p_70310_1_.func_74778_a("CustomName", this.field_94045_s);
      }

   }

   public int func_70297_j_() {
      return 64;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this?false:p_70300_1_.func_70092_e((double)this.field_70329_l + 0.5D, (double)this.field_70330_m + 0.5D, (double)this.field_70327_n + 0.5D) <= 64.0D;
   }

   public void func_70321_h() {
      super.func_70321_h();
      this.field_70425_a = false;
   }

   private void func_90009_a(TileEntityChest p_90009_1_, int p_90009_2_) {
      if(p_90009_1_.func_70320_p()) {
         this.field_70425_a = false;
      } else if(this.field_70425_a) {
         switch(p_90009_2_) {
         case 0:
            if(this.field_70422_e != p_90009_1_) {
               this.field_70425_a = false;
            }
            break;
         case 1:
            if(this.field_70421_d != p_90009_1_) {
               this.field_70425_a = false;
            }
            break;
         case 2:
            if(this.field_70423_b != p_90009_1_) {
               this.field_70425_a = false;
            }
            break;
         case 3:
            if(this.field_70424_c != p_90009_1_) {
               this.field_70425_a = false;
            }
         }
      }

   }

   public void func_70418_i() {
      if(!this.field_70425_a) {
         this.field_70425_a = true;
         this.field_70423_b = null;
         this.field_70424_c = null;
         this.field_70421_d = null;
         this.field_70422_e = null;
         if(this.func_94044_a(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n)) {
            this.field_70421_d = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l - 1, this.field_70330_m, this.field_70327_n);
         }

         if(this.func_94044_a(this.field_70329_l + 1, this.field_70330_m, this.field_70327_n)) {
            this.field_70424_c = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l + 1, this.field_70330_m, this.field_70327_n);
         }

         if(this.func_94044_a(this.field_70329_l, this.field_70330_m, this.field_70327_n - 1)) {
            this.field_70423_b = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n - 1);
         }

         if(this.func_94044_a(this.field_70329_l, this.field_70330_m, this.field_70327_n + 1)) {
            this.field_70422_e = (TileEntityChest)this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n + 1);
         }

         if(this.field_70423_b != null) {
            this.field_70423_b.func_90009_a(this, 0);
         }

         if(this.field_70422_e != null) {
            this.field_70422_e.func_90009_a(this, 2);
         }

         if(this.field_70424_c != null) {
            this.field_70424_c.func_90009_a(this, 1);
         }

         if(this.field_70421_d != null) {
            this.field_70421_d.func_90009_a(this, 3);
         }

      }
   }

   private boolean func_94044_a(int p_94044_1_, int p_94044_2_, int p_94044_3_) {
      Block var4 = Block.field_71973_m[this.field_70331_k.func_72798_a(p_94044_1_, p_94044_2_, p_94044_3_)];
      return var4 != null && var4 instanceof BlockChest?((BlockChest)var4).field_94443_a == this.func_98041_l():false;
   }

   public void func_70316_g() {
      super.func_70316_g();
      this.func_70418_i();
      ++this.field_70426_j;
      float var1;
      if(!this.field_70331_k.field_72995_K && this.field_70427_h != 0 && (this.field_70426_j + this.field_70329_l + this.field_70330_m + this.field_70327_n) % 200 == 0) {
         this.field_70427_h = 0;
         var1 = 5.0F;
         List var2 = this.field_70331_k.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72332_a().func_72299_a((double)((float)this.field_70329_l - var1), (double)((float)this.field_70330_m - var1), (double)((float)this.field_70327_n - var1), (double)((float)(this.field_70329_l + 1) + var1), (double)((float)(this.field_70330_m + 1) + var1), (double)((float)(this.field_70327_n + 1) + var1)));
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            if(var4.field_71070_bA instanceof ContainerChest) {
               IInventory var5 = ((ContainerChest)var4.field_71070_bA).func_85151_d();
               if(var5 == this || var5 instanceof InventoryLargeChest && ((InventoryLargeChest)var5).func_90010_a(this)) {
                  ++this.field_70427_h;
               }
            }
         }
      }

      this.field_70420_g = this.field_70419_f;
      var1 = 0.1F;
      double var11;
      if(this.field_70427_h > 0 && this.field_70419_f == 0.0F && this.field_70423_b == null && this.field_70421_d == null) {
         double var8 = (double)this.field_70329_l + 0.5D;
         var11 = (double)this.field_70327_n + 0.5D;
         if(this.field_70422_e != null) {
            var11 += 0.5D;
         }

         if(this.field_70424_c != null) {
            var8 += 0.5D;
         }

         this.field_70331_k.func_72908_a(var8, (double)this.field_70330_m + 0.5D, var11, "random.chestopen", 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
      }

      if(this.field_70427_h == 0 && this.field_70419_f > 0.0F || this.field_70427_h > 0 && this.field_70419_f < 1.0F) {
         float var9 = this.field_70419_f;
         if(this.field_70427_h > 0) {
            this.field_70419_f += var1;
         } else {
            this.field_70419_f -= var1;
         }

         if(this.field_70419_f > 1.0F) {
            this.field_70419_f = 1.0F;
         }

         float var10 = 0.5F;
         if(this.field_70419_f < var10 && var9 >= var10 && this.field_70423_b == null && this.field_70421_d == null) {
            var11 = (double)this.field_70329_l + 0.5D;
            double var6 = (double)this.field_70327_n + 0.5D;
            if(this.field_70422_e != null) {
               var6 += 0.5D;
            }

            if(this.field_70424_c != null) {
               var11 += 0.5D;
            }

            this.field_70331_k.func_72908_a(var11, (double)this.field_70330_m + 0.5D, var6, "random.chestclosed", 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
         }

         if(this.field_70419_f < 0.0F) {
            this.field_70419_f = 0.0F;
         }
      }

   }

   public boolean func_70315_b(int p_70315_1_, int p_70315_2_) {
      if(p_70315_1_ == 1) {
         this.field_70427_h = p_70315_2_;
         return true;
      } else {
         return super.func_70315_b(p_70315_1_, p_70315_2_);
      }
   }

   public void func_70295_k_() {
      if(this.field_70427_h < 0) {
         this.field_70427_h = 0;
      }

      ++this.field_70427_h;
      this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, 1, this.field_70427_h);
      this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
      this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n, this.func_70311_o().field_71990_ca);
   }

   public void func_70305_f() {
      if(this.func_70311_o() != null && this.func_70311_o() instanceof BlockChest) {
         --this.field_70427_h;
         this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca, 1, this.field_70427_h);
         this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.func_70311_o().field_71990_ca);
         this.field_70331_k.func_72898_h(this.field_70329_l, this.field_70330_m - 1, this.field_70327_n, this.func_70311_o().field_71990_ca);
      }
   }

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public void func_70313_j() {
      super.func_70313_j();
      this.func_70321_h();
      this.func_70418_i();
   }

   public int func_98041_l() {
      if(this.field_94046_i == -1) {
         if(this.field_70331_k == null || !(this.func_70311_o() instanceof BlockChest)) {
            return 0;
         }

         this.field_94046_i = ((BlockChest)this.func_70311_o()).field_94443_a;
      }

      return this.field_94046_i;
   }
}
