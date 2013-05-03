package net.minecraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesArmor {

   private String[][] field_77611_a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private Object[][] field_77610_b;


   public RecipesArmor() {
      this.field_77610_b = new Object[][]{{Item.field_77770_aF, Block.field_72067_ar, Item.field_77703_o, Item.field_77702_n, Item.field_77717_p}, {Item.field_77687_V, Item.field_77694_Z, Item.field_77812_ad, Item.field_77820_ah, Item.field_77796_al}, {Item.field_77686_W, Item.field_77814_aa, Item.field_77822_ae, Item.field_77798_ai, Item.field_77806_am}, {Item.field_77693_X, Item.field_77816_ab, Item.field_77824_af, Item.field_77800_aj, Item.field_77808_an}, {Item.field_77692_Y, Item.field_77810_ac, Item.field_77818_ag, Item.field_77794_ak, Item.field_77802_ao}};
   }

   public void func_77609_a(CraftingManager p_77609_1_) {
      for(int var2 = 0; var2 < this.field_77610_b[0].length; ++var2) {
         Object var3 = this.field_77610_b[0][var2];

         for(int var4 = 0; var4 < this.field_77610_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_77610_b[var4 + 1][var2];
            p_77609_1_.func_92103_a(new ItemStack(var5), new Object[]{this.field_77611_a[var4], Character.valueOf('X'), var3});
         }
      }

   }
}
