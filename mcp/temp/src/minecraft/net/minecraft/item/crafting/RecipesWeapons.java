package net.minecraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesWeapons {

   private String[][] field_77585_a = new String[][]{{"X", "X", "#"}};
   private Object[][] field_77584_b;


   public RecipesWeapons() {
      this.field_77584_b = new Object[][]{{Block.field_71988_x, Block.field_71978_w, Item.field_77703_o, Item.field_77702_n, Item.field_77717_p}, {Item.field_77715_r, Item.field_77711_v, Item.field_77716_q, Item.field_77718_z, Item.field_77672_G}};
   }

   public void func_77583_a(CraftingManager p_77583_1_) {
      for(int var2 = 0; var2 < this.field_77584_b[0].length; ++var2) {
         Object var3 = this.field_77584_b[0][var2];

         for(int var4 = 0; var4 < this.field_77584_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_77584_b[var4 + 1][var2];
            p_77583_1_.func_92103_a(new ItemStack(var5), new Object[]{this.field_77585_a[var4], Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), var3});
         }
      }

      p_77583_1_.func_92103_a(new ItemStack(Item.field_77707_k, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Item.field_77683_K, Character.valueOf('#'), Item.field_77669_D});
      p_77583_1_.func_92103_a(new ItemStack(Item.field_77704_l, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Item.field_77676_L, Character.valueOf('X'), Item.field_77804_ap, Character.valueOf('#'), Item.field_77669_D});
   }
}
