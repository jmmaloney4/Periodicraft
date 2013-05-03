package net.minecraft.item.crafting;

import java.util.ArrayList;
import net.minecraft.block.BlockCloth;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipesArmorDyes implements IRecipe {

   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
      ItemStack var3 = null;
      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < p_77569_1_.func_70302_i_(); ++var5) {
         ItemStack var6 = p_77569_1_.func_70301_a(var5);
         if(var6 != null) {
            if(var6.func_77973_b() instanceof ItemArmor) {
               ItemArmor var7 = (ItemArmor)var6.func_77973_b();
               if(var7.func_82812_d() != EnumArmorMaterial.CLOTH || var3 != null) {
                  return false;
               }

               var3 = var6;
            } else {
               if(var6.field_77993_c != Item.field_77756_aW.field_77779_bT) {
                  return false;
               }

               var4.add(var6);
            }
         }
      }

      return var3 != null && !var4.isEmpty();
   }

   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
      ItemStack var2 = null;
      int[] var3 = new int[3];
      int var4 = 0;
      int var5 = 0;
      ItemArmor var6 = null;

      int var7;
      int var9;
      float var10;
      float var11;
      int var17;
      for(var7 = 0; var7 < p_77572_1_.func_70302_i_(); ++var7) {
         ItemStack var8 = p_77572_1_.func_70301_a(var7);
         if(var8 != null) {
            if(var8.func_77973_b() instanceof ItemArmor) {
               var6 = (ItemArmor)var8.func_77973_b();
               if(var6.func_82812_d() != EnumArmorMaterial.CLOTH || var2 != null) {
                  return null;
               }

               var2 = var8.func_77946_l();
               var2.field_77994_a = 1;
               if(var6.func_82816_b_(var8)) {
                  var9 = var6.func_82814_b(var2);
                  var10 = (float)(var9 >> 16 & 255) / 255.0F;
                  var11 = (float)(var9 >> 8 & 255) / 255.0F;
                  float var12 = (float)(var9 & 255) / 255.0F;
                  var4 = (int)((float)var4 + Math.max(var10, Math.max(var11, var12)) * 255.0F);
                  var3[0] = (int)((float)var3[0] + var10 * 255.0F);
                  var3[1] = (int)((float)var3[1] + var11 * 255.0F);
                  var3[2] = (int)((float)var3[2] + var12 * 255.0F);
                  ++var5;
               }
            } else {
               if(var8.field_77993_c != Item.field_77756_aW.field_77779_bT) {
                  return null;
               }

               float[] var14 = EntitySheep.field_70898_d[BlockCloth.func_72238_e_(var8.func_77960_j())];
               int var16 = (int)(var14[0] * 255.0F);
               int var15 = (int)(var14[1] * 255.0F);
               var17 = (int)(var14[2] * 255.0F);
               var4 += Math.max(var16, Math.max(var15, var17));
               var3[0] += var16;
               var3[1] += var15;
               var3[2] += var17;
               ++var5;
            }
         }
      }

      if(var6 == null) {
         return null;
      } else {
         var7 = var3[0] / var5;
         int var13 = var3[1] / var5;
         var9 = var3[2] / var5;
         var10 = (float)var4 / (float)var5;
         var11 = (float)Math.max(var7, Math.max(var13, var9));
         var7 = (int)((float)var7 * var10 / var11);
         var13 = (int)((float)var13 * var10 / var11);
         var9 = (int)((float)var9 * var10 / var11);
         var17 = (var7 << 8) + var13;
         var17 = (var17 << 8) + var9;
         var6.func_82813_b(var2, var17);
         return var2;
      }
   }

   public int func_77570_a() {
      return 10;
   }

   public ItemStack func_77571_b() {
      return null;
   }
}
