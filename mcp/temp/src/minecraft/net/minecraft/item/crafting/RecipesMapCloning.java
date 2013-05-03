package net.minecraft.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesMapCloning implements IRecipe {

   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
      int var3 = 0;
      ItemStack var4 = null;

      for(int var5 = 0; var5 < p_77569_1_.func_70302_i_(); ++var5) {
         ItemStack var6 = p_77569_1_.func_70301_a(var5);
         if(var6 != null) {
            if(var6.field_77993_c == Item.field_77744_bd.field_77779_bT) {
               if(var4 != null) {
                  return false;
               }

               var4 = var6;
            } else {
               if(var6.field_77993_c != Item.field_82801_bO.field_77779_bT) {
                  return false;
               }

               ++var3;
            }
         }
      }

      return var4 != null && var3 > 0;
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      int var2 = 0;
      ItemStack var3 = null;

      for(int var4 = 0; var4 < p_77572_1_.func_70302_i_(); ++var4) {
         ItemStack var5 = p_77572_1_.func_70301_a(var4);
         if(var5 != null) {
            if(var5.field_77993_c == Item.field_77744_bd.field_77779_bT) {
               if(var3 != null) {
                  return null;
               }

               var3 = var5;
            } else {
               if(var5.field_77993_c != Item.field_82801_bO.field_77779_bT) {
                  return null;
               }

               ++var2;
            }
         }
      }

      if(var3 != null && var2 >= 1) {
         ItemStack var6 = new ItemStack(Item.field_77744_bd, var2 + 1, var3.func_77960_j());
         if(var3.func_82837_s()) {
            var6.func_82834_c(var3.func_82833_r());
         }

         return var6;
      } else {
         return null;
      }
   }

   public int func_77570_a() {
      return 9;
   }

   public ItemStack func_77571_b() {
      return null;
   }
}
