package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityMinecartContainer extends EntityMinecart implements IInventory {

   private ItemStack[] field_94113_a = new ItemStack[36];
   private boolean field_94112_b = true;


   public EntityMinecartContainer(World p_i10051_1_) {
      super(p_i10051_1_);
   }

   public EntityMinecartContainer(World p_i10052_1_, double p_i10052_2_, double p_i10052_4_, double p_i10052_6_) {
      super(p_i10052_1_, p_i10052_2_, p_i10052_4_, p_i10052_6_);
   }

   public void func_94095_a(DamageSource p_94095_1_) {
      super.func_94095_a(p_94095_1_);

      for(int var2 = 0; var2 < this.func_70302_i_(); ++var2) {
         ItemStack var3 = this.func_70301_a(var2);
         if(var3 != null) {
            float var4 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
            float var5 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
            float var6 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;

            while(var3.field_77994_a > 0) {
               int var7 = this.field_70146_Z.nextInt(21) + 10;
               if(var7 > var3.field_77994_a) {
                  var7 = var3.field_77994_a;
               }

               var3.field_77994_a -= var7;
               EntityItem var8 = new EntityItem(this.field_70170_p, this.field_70165_t + (double)var4, this.field_70163_u + (double)var5, this.field_70161_v + (double)var6, new ItemStack(var3.field_77993_c, var7, var3.func_77960_j()));
               float var9 = 0.05F;
               var8.field_70159_w = (double)((float)this.field_70146_Z.nextGaussian() * var9);
               var8.field_70181_x = (double)((float)this.field_70146_Z.nextGaussian() * var9 + 0.2F);
               var8.field_70179_y = (double)((float)this.field_70146_Z.nextGaussian() * var9);
               this.field_70170_p.func_72838_d(var8);
            }
         }
      }

   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return this.field_94113_a[p_70301_1_];
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(this.field_94113_a[p_70298_1_] != null) {
         ItemStack var3;
         if(this.field_94113_a[p_70298_1_].field_77994_a <= p_70298_2_) {
            var3 = this.field_94113_a[p_70298_1_];
            this.field_94113_a[p_70298_1_] = null;
            return var3;
         } else {
            var3 = this.field_94113_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(this.field_94113_a[p_70298_1_].field_77994_a == 0) {
               this.field_94113_a[p_70298_1_] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(this.field_94113_a[p_70304_1_] != null) {
         ItemStack var2 = this.field_94113_a[p_70304_1_];
         this.field_94113_a[p_70304_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      this.field_94113_a[p_70299_1_] = p_70299_2_;
      if(p_70299_2_ != null && p_70299_2_.field_77994_a > this.func_70297_j_()) {
         p_70299_2_.field_77994_a = this.func_70297_j_();
      }

   }

   public void func_70296_d() {}

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70128_L?false:p_70300_1_.func_70068_e(this) <= 64.0D;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return true;
   }

   public String func_70303_b() {
      return this.func_94042_c()?this.func_95999_t():"container.minecart";
   }

   public int func_70297_j_() {
      return 64;
   }

   public void func_71027_c(int p_71027_1_) {
      this.field_94112_b = false;
      super.func_71027_c(p_71027_1_);
   }

   public void func_70106_y() {
      if(this.field_94112_b) {
         for(int var1 = 0; var1 < this.func_70302_i_(); ++var1) {
            ItemStack var2 = this.func_70301_a(var1);
            if(var2 != null) {
               float var3 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
               float var4 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
               float var5 = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;

               while(var2.field_77994_a > 0) {
                  int var6 = this.field_70146_Z.nextInt(21) + 10;
                  if(var6 > var2.field_77994_a) {
                     var6 = var2.field_77994_a;
                  }

                  var2.field_77994_a -= var6;
                  EntityItem var7 = new EntityItem(this.field_70170_p, this.field_70165_t + (double)var3, this.field_70163_u + (double)var4, this.field_70161_v + (double)var5, new ItemStack(var2.field_77993_c, var6, var2.func_77960_j()));
                  if(var2.func_77942_o()) {
                     var7.func_92059_d().func_77982_d((NBTTagCompound)var2.func_77978_p().func_74737_b());
                  }

                  float var8 = 0.05F;
                  var7.field_70159_w = (double)((float)this.field_70146_Z.nextGaussian() * var8);
                  var7.field_70181_x = (double)((float)this.field_70146_Z.nextGaussian() * var8 + 0.2F);
                  var7.field_70179_y = (double)((float)this.field_70146_Z.nextGaussian() * var8);
                  this.field_70170_p.func_72838_d(var7);
               }
            }
         }
      }

      super.func_70106_y();
   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_94113_a.length; ++var3) {
         if(this.field_94113_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_74774_a("Slot", (byte)var3);
            this.field_94113_a[var3].func_77955_b(var4);
            var2.func_74742_a(var4);
         }
      }

      p_70014_1_.func_74782_a("Items", var2);
   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      NBTTagList var2 = p_70037_1_.func_74761_m("Items");
      this.field_94113_a = new ItemStack[this.func_70302_i_()];

      for(int var3 = 0; var3 < var2.func_74745_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_74743_b(var3);
         int var5 = var4.func_74771_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_94113_a.length) {
            this.field_94113_a[var5] = ItemStack.func_77949_a(var4);
         }
      }

   }

   public boolean func_70085_c(EntityPlayer p_70085_1_) {
      if(!this.field_70170_p.field_72995_K) {
         p_70085_1_.func_71007_a(this);
      }

      return true;
   }

   protected void func_94101_h() {
      int var1 = 15 - Container.func_94526_b(this);
      float var2 = 0.98F + (float)var1 * 0.0010F;
      this.field_70159_w *= (double)var2;
      this.field_70181_x *= 0.0D;
      this.field_70179_y *= (double)var2;
   }
}
