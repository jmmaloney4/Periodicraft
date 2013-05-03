package net.minecraft.item.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesTools {

   private String[][] field_77588_a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] field_77587_b;


   public RecipesTools() {
      this.field_77587_b = new Object[][]{{Block.field_71988_x, Block.field_71978_w, Item.field_77703_o, Item.field_77702_n, Item.field_77717_p}, {Item.field_77713_t, Item.field_77720_x, Item.field_77696_g, Item.field_77674_B, Item.field_77681_I}, {Item.field_77714_s, Item.field_77710_w, Item.field_77695_f, Item.field_77673_A, Item.field_77680_H}, {Item.field_77712_u, Item.field_77719_y, Item.field_77708_h, Item.field_77675_C, Item.field_77682_J}, {Item.field_77678_N, Item.field_77679_O, Item.field_77689_P, Item.field_77688_Q, Item.field_77691_R}};
   }

   public void func_77586_a(CraftingManager p_77586_1_) {
      for(int var2 = 0; var2 < this.field_77587_b[0].length; ++var2) {
         Object var3 = this.field_77587_b[0][var2];

         for(int var4 = 0; var4 < this.field_77587_b.length - 1; ++var4) {
            Item var5 = (Item)this.field_77587_b[var4 + 1][var2];
            p_77586_1_.func_92103_a(new ItemStack(var5), new Object[]{this.field_77588_a[var4], Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), var3});
         }
      }

      p_77586_1_.func_92103_a(new ItemStack(Item.field_77745_be), new Object[]{" #", "# ", Character.valueOf('#'), Item.field_77703_o});
   }
}
