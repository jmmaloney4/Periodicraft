package net.minecraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotBrewingStandIngredient;
import net.minecraft.inventory.SlotBrewingStandPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBrewingStand;

public class ContainerBrewingStand extends Container {

   private TileEntityBrewingStand field_75188_e;
   private final Slot field_75186_f;
   private int field_75187_g = 0;


   public ContainerBrewingStand(InventoryPlayer p_i3600_1_, TileEntityBrewingStand p_i3600_2_) {
      this.field_75188_e = p_i3600_2_;
      this.func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 0, 56, 46));
      this.func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 1, 79, 53));
      this.func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 2, 102, 46));
      this.field_75186_f = this.func_75146_a(new SlotBrewingStandIngredient(this, p_i3600_2_, 3, 79, 17));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(p_i3600_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(p_i3600_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public void func_75132_a(ICrafting p_75132_1_) {
      super.func_75132_a(p_75132_1_);
      p_75132_1_.func_71112_a(this, 0, this.field_75188_e.func_70355_t_());
   }

   public void func_75142_b() {
      super.func_75142_b();

      for(int var1 = 0; var1 < this.field_75149_d.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_75149_d.get(var1);
         if(this.field_75187_g != this.field_75188_e.func_70355_t_()) {
            var2.func_71112_a(this, 0, this.field_75188_e.func_70355_t_());
         }
      }

      this.field_75187_g = this.field_75188_e.func_70355_t_();
   }

   @SideOnly(Side.CLIENT)
   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
      if(p_75137_1_ == 0) {
         this.field_75188_e.func_70354_c(p_75137_2_);
      }

   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return this.field_75188_e.func_70300_a(p_75145_1_);
   }

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.field_75151_b.get(p_82846_2_);
      if(var4 != null && var4.func_75216_d()) {
         ItemStack var5 = var4.func_75211_c();
         var3 = var5.func_77946_l();
         if((p_82846_2_ < 0 || p_82846_2_ > 2) && p_82846_2_ != 3) {
            if(!this.field_75186_f.func_75216_d() && this.field_75186_f.func_75214_a(var5)) {
               if(!this.func_75135_a(var5, 3, 4, false)) {
                  return null;
               }
            } else if(SlotBrewingStandPotion.func_75243_a_(var3)) {
               if(!this.func_75135_a(var5, 0, 3, false)) {
                  return null;
               }
            } else if(p_82846_2_ >= 4 && p_82846_2_ < 31) {
               if(!this.func_75135_a(var5, 31, 40, false)) {
                  return null;
               }
            } else if(p_82846_2_ >= 31 && p_82846_2_ < 40) {
               if(!this.func_75135_a(var5, 4, 31, false)) {
                  return null;
               }
            } else if(!this.func_75135_a(var5, 4, 40, false)) {
               return null;
            }
         } else {
            if(!this.func_75135_a(var5, 4, 40, true)) {
               return null;
            }

            var4.func_75220_a(var5, var3);
         }

         if(var5.field_77994_a == 0) {
            var4.func_75215_d((ItemStack)null);
         } else {
            var4.func_75218_e();
         }

         if(var5.field_77994_a == var3.field_77994_a) {
            return null;
         }

         var4.func_82870_a(p_82846_1_, var5);
      }

      return var3;
   }
}
