package net.minecraft.item.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ShapelessRecipes implements IRecipe {

   private final ItemStack field_77580_a;
   public final List field_77579_b;


   public ShapelessRecipes(ItemStack p_i3701_1_, List p_i3701_2_) {
      this.field_77580_a = p_i3701_1_;
      this.field_77579_b = p_i3701_2_;
   }

   public ItemStack func_77571_b() {
      return this.field_77580_a;
   }

   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
      ArrayList var3 = new ArrayList(this.field_77579_b);

      for(int var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 3; ++var5) {
            ItemStack var6 = p_77569_1_.func_70463_b(var5, var4);
            if(var6 != null) {
               boolean var7 = false;
               Iterator var8 = var3.iterator();

               while(var8.hasNext()) {
                  ItemStack var9 = (ItemStack)var8.next();
                  if(var6.field_77993_c == var9.field_77993_c && (var9.func_77960_j() == 32767 || var6.func_77960_j() == var9.func_77960_j())) {
                     var7 = true;
                     var3.remove(var9);
                     break;
                  }
               }

               if(!var7) {
                  return false;
               }
            }
         }
      }

      return var3.isEmpty();
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      return this.field_77580_a.func_77946_l();
   }

   public int func_77570_a() {
      return this.field_77579_b.size();
   }
}
