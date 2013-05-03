package net.minecraft.client.gui.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@SideOnly(Side.CLIENT)
class ContainerCreative extends Container {

   public List field_75185_e = new ArrayList();


   public ContainerCreative(EntityPlayer p_i3082_1_) {
      InventoryPlayer var2 = p_i3082_1_.field_71071_by;

      int var3;
      for(var3 = 0; var3 < 5; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_75146_a(new Slot(GuiContainerCreative.func_74229_i(), var3 * 9 + var4, 9 + var4 * 18, 18 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_75146_a(new Slot(var2, var3, 9 + var3 * 18, 112));
      }

      this.func_75183_a(0.0F);
   }

   public boolean func_75145_c(EntityPlayer p_75145_1_) {
      return true;
   }

   public void func_75183_a(float p_75183_1_) {
      int var2 = this.field_75185_e.size() / 9 - 5 + 1;
      int var3 = (int)((double)(p_75183_1_ * (float)var2) + 0.5D);
      if(var3 < 0) {
         var3 = 0;
      }

      for(int var4 = 0; var4 < 5; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            int var6 = var5 + (var4 + var3) * 9;
            if(var6 >= 0 && var6 < this.field_75185_e.size()) {
               GuiContainerCreative.func_74229_i().func_70299_a(var5 + var4 * 9, (ItemStack)this.field_75185_e.get(var6));
            } else {
               GuiContainerCreative.func_74229_i().func_70299_a(var5 + var4 * 9, (ItemStack)null);
            }
         }
      }

   }

   public boolean func_75184_d() {
      return this.field_75185_e.size() > 45;
   }

   protected void func_75133_b(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_) {}

   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
      if(p_82846_2_ >= this.field_75151_b.size() - 9 && p_82846_2_ < this.field_75151_b.size()) {
         Slot var3 = (Slot)this.field_75151_b.get(p_82846_2_);
         if(var3 != null && var3.func_75216_d()) {
            var3.func_75215_d((ItemStack)null);
         }
      }

      return null;
   }

   public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
      return p_94530_2_.field_75221_f > 90;
   }

   public boolean func_94531_b(Slot p_94531_1_) {
      return p_94531_1_.field_75224_c instanceof InventoryPlayer || p_94531_1_.field_75221_f > 90 && p_94531_1_.field_75223_e <= 162;
   }
}
