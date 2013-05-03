package net.minecraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesIngots {

   private Object[][] field_77591_a;


   public RecipesIngots() {
      this.field_77591_a = new Object[][]{{Block.field_72105_ah, new ItemStack(Item.field_77717_p, 9)}, {Block.field_72083_ai, new ItemStack(Item.field_77703_o, 9)}, {Block.field_72071_ax, new ItemStack(Item.field_77702_n, 9)}, {Block.field_72076_bV, new ItemStack(Item.field_77817_bH, 9)}, {Block.field_71948_O, new ItemStack(Item.field_77756_aW, 9, 4)}, {Block.field_94341_cq, new ItemStack(Item.field_77767_aC, 9)}};
   }

   public void func_77590_a(CraftingManager p_77590_1_) {
      for(int var2 = 0; var2 < this.field_77591_a.length; ++var2) {
         Block var3 = (Block)this.field_77591_a[var2][0];
         ItemStack var4 = (ItemStack)this.field_77591_a[var2][1];
         p_77590_1_.func_92103_a(new ItemStack(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         p_77590_1_.func_92103_a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      p_77590_1_.func_92103_a(new ItemStack(Item.field_77717_p), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.field_77733_bq});
      p_77590_1_.func_92103_a(new ItemStack(Item.field_77733_bq, 9), new Object[]{"#", Character.valueOf('#'), Item.field_77717_p});
   }
}
