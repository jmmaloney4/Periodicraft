package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityBeacon extends TileEntity implements IInventory {

   public static final Potion[][] field_82139_a = new Potion[][]{{Potion.field_76424_c, Potion.field_76422_e}, {Potion.field_76429_m, Potion.field_76430_j}, {Potion.field_76420_g}, {Potion.field_76428_l}};
   @SideOnly(Side.CLIENT)
   private long field_82137_b;
   @SideOnly(Side.CLIENT)
   private float field_82138_c;
   private boolean field_82135_d;
   private int field_82136_e = -1;
   private int field_82133_f;
   private int field_82134_g;
   private ItemStack field_82140_h;
   private String field_94048_i;


   public void func_70316_g() {
      if(this.field_70331_k.func_82737_E() % 80L == 0L) {
         this.func_82131_u();
         this.func_82124_t();
      }

   }

   private void func_82124_t() {
      if(this.field_82135_d && this.field_82136_e > 0 && !this.field_70331_k.field_72995_K && this.field_82133_f > 0) {
         double var1 = (double)(this.field_82136_e * 10 + 10);
         byte var3 = 0;
         if(this.field_82136_e >= 4 && this.field_82133_f == this.field_82134_g) {
            var3 = 1;
         }

         AxisAlignedBB var4 = AxisAlignedBB.func_72332_a().func_72299_a((double)this.field_70329_l, (double)this.field_70330_m, (double)this.field_70327_n, (double)(this.field_70329_l + 1), (double)(this.field_70330_m + 1), (double)(this.field_70327_n + 1)).func_72314_b(var1, var1, var1);
         var4.field_72337_e = (double)this.field_70331_k.func_72800_K();
         List var5 = this.field_70331_k.func_72872_a(EntityPlayer.class, var4);
         Iterator var6 = var5.iterator();

         EntityPlayer var7;
         while(var6.hasNext()) {
            var7 = (EntityPlayer)var6.next();
            var7.func_70690_d(new PotionEffect(this.field_82133_f, 180, var3, true));
         }

         if(this.field_82136_e >= 4 && this.field_82133_f != this.field_82134_g && this.field_82134_g > 0) {
            var6 = var5.iterator();

            while(var6.hasNext()) {
               var7 = (EntityPlayer)var6.next();
               var7.func_70690_d(new PotionEffect(this.field_82134_g, 180, 0, true));
            }
         }
      }

   }

   private void func_82131_u() {
      if(!this.field_70331_k.func_72937_j(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n)) {
         this.field_82135_d = false;
         this.field_82136_e = 0;
      } else {
         this.field_82135_d = true;
         this.field_82136_e = 0;

         for(int var1 = 1; var1 <= 4; this.field_82136_e = var1++) {
            int var2 = this.field_70330_m - var1;
            if(var2 < 0) {
               break;
            }

            boolean var3 = true;

            for(int var4 = this.field_70329_l - var1; var4 <= this.field_70329_l + var1 && var3; ++var4) {
               for(int var5 = this.field_70327_n - var1; var5 <= this.field_70327_n + var1; ++var5) {
                  int var6 = this.field_70331_k.func_72798_a(var4, var2, var5);
                  if(var6 != Block.field_72076_bV.field_71990_ca && var6 != Block.field_72105_ah.field_71990_ca && var6 != Block.field_72071_ax.field_71990_ca && var6 != Block.field_72083_ai.field_71990_ca) {
                     var3 = false;
                     break;
                  }
               }
            }

            if(!var3) {
               break;
            }
         }

         if(this.field_82136_e == 0) {
            this.field_82135_d = false;
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public float func_82125_v_() {
      if(!this.field_82135_d) {
         return 0.0F;
      } else {
         int var1 = (int)(this.field_70331_k.func_82737_E() - this.field_82137_b);
         this.field_82137_b = this.field_70331_k.func_82737_E();
         if(var1 > 1) {
            this.field_82138_c -= (float)var1 / 40.0F;
            if(this.field_82138_c < 0.0F) {
               this.field_82138_c = 0.0F;
            }
         }

         this.field_82138_c += 0.025F;
         if(this.field_82138_c > 1.0F) {
            this.field_82138_c = 1.0F;
         }

         return this.field_82138_c;
      }
   }

   public int func_82126_i() {
      return this.field_82133_f;
   }

   public int func_82132_j() {
      return this.field_82134_g;
   }

   public int func_82130_k() {
      return this.field_82136_e;
   }

   @SideOnly(Side.CLIENT)
   public void func_82129_c(int p_82129_1_) {
      this.field_82136_e = p_82129_1_;
   }

   public void func_82128_d(int p_82128_1_) {
      this.field_82133_f = 0;

      for(int var2 = 0; var2 < this.field_82136_e && var2 < 3; ++var2) {
         Potion[] var3 = field_82139_a[var2];
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Potion var6 = var3[var5];
            if(var6.field_76415_H == p_82128_1_) {
               this.field_82133_f = p_82128_1_;
               return;
            }
         }
      }

   }

   public void func_82127_e(int p_82127_1_) {
      this.field_82134_g = 0;
      if(this.field_82136_e >= 4) {
         for(int var2 = 0; var2 < 4; ++var2) {
            Potion[] var3 = field_82139_a[var2];
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               Potion var6 = var3[var5];
               if(var6.field_76415_H == p_82127_1_) {
                  this.field_82134_g = p_82127_1_;
                  return;
               }
            }
         }
      }

   }

   public Packet func_70319_e() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.func_70310_b(var1);
      return new Packet132TileEntityData(this.field_70329_l, this.field_70330_m, this.field_70327_n, 3, var1);
   }

   @SideOnly(Side.CLIENT)
   public double func_82115_m() {
      return 65536.0D;
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_82133_f = p_70307_1_.func_74762_e("Primary");
      this.field_82134_g = p_70307_1_.func_74762_e("Secondary");
      this.field_82136_e = p_70307_1_.func_74762_e("Levels");
   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74768_a("Primary", this.field_82133_f);
      p_70310_1_.func_74768_a("Secondary", this.field_82134_g);
      p_70310_1_.func_74768_a("Levels", this.field_82136_e);
   }

   public int func_70302_i_() {
      return 1;
   }

   public ItemStack func_70301_a(int p_70301_1_) {
      return p_70301_1_ == 0?this.field_82140_h:null;
   }

   public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_) {
      if(p_70298_1_ == 0 && this.field_82140_h != null) {
         if(p_70298_2_ >= this.field_82140_h.field_77994_a) {
            ItemStack var3 = this.field_82140_h;
            this.field_82140_h = null;
            return var3;
         } else {
            this.field_82140_h.field_77994_a -= p_70298_2_;
            return new ItemStack(this.field_82140_h.field_77993_c, p_70298_2_, this.field_82140_h.func_77960_j());
         }
      } else {
         return null;
      }
   }

   public ItemStack func_70304_b(int p_70304_1_) {
      if(p_70304_1_ == 0 && this.field_82140_h != null) {
         ItemStack var2 = this.field_82140_h;
         this.field_82140_h = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_) {
      if(p_70299_1_ == 0) {
         this.field_82140_h = p_70299_2_;
      }

   }

   public String func_70303_b() {
      return this.func_94042_c()?this.field_94048_i:"container.beacon";
   }

   public boolean func_94042_c() {
      return this.field_94048_i != null && this.field_94048_i.length() > 0;
   }

   public void func_94047_a(String p_94047_1_) {
      this.field_94048_i = p_94047_1_;
   }

   public int func_70297_j_() {
      return 1;
   }

   public boolean func_70300_a(EntityPlayer p_70300_1_) {
      return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this?false:p_70300_1_.func_70092_e((double)this.field_70329_l + 0.5D, (double)this.field_70330_m + 0.5D, (double)this.field_70327_n + 0.5D) <= 64.0D;
   }

   public void func_70295_k_() {}

   public void func_70305_f() {}

   public boolean func_94041_b(int p_94041_1_, ItemStack p_94041_2_) {
      return p_94041_2_.field_77993_c == Item.field_77817_bH.field_77779_bT || p_94041_2_.field_77993_c == Item.field_77702_n.field_77779_bT || p_94041_2_.field_77993_c == Item.field_77717_p.field_77779_bT || p_94041_2_.field_77993_c == Item.field_77703_o.field_77779_bT;
   }

}
