package net.minecraft.item.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.item.crafting.RecipeSorter;
import net.minecraft.item.crafting.RecipesArmor;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.crafting.RecipesDyes;
import net.minecraft.item.crafting.RecipesFood;
import net.minecraft.item.crafting.RecipesIngots;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesMapExtending;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.item.crafting.RecipesWeapons;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class CraftingManager {

   private static final CraftingManager field_77598_a = new CraftingManager();
   private List field_77597_b = new ArrayList();


   public static final CraftingManager func_77594_a() {
      return field_77598_a;
   }

   private CraftingManager() {
      (new RecipesTools()).func_77586_a(this);
      (new RecipesWeapons()).func_77583_a(this);
      (new RecipesIngots()).func_77590_a(this);
      (new RecipesFood()).func_77608_a(this);
      (new RecipesCrafting()).func_77589_a(this);
      (new RecipesArmor()).func_77609_a(this);
      (new RecipesDyes()).func_77607_a(this);
      this.field_77597_b.add(new RecipesArmorDyes());
      this.field_77597_b.add(new RecipesMapCloning());
      this.field_77597_b.add(new RecipesMapExtending());
      this.field_77597_b.add(new RecipeFireworks());
      this.func_92103_a(new ItemStack(Item.field_77759_aK, 3), new Object[]{"###", Character.valueOf('#'), Item.field_77758_aJ});
      this.func_77596_b(new ItemStack(Item.field_77760_aL, 1), new Object[]{Item.field_77759_aK, Item.field_77759_aK, Item.field_77759_aK, Item.field_77770_aF});
      this.func_77596_b(new ItemStack(Item.field_77821_bF, 1), new Object[]{Item.field_77760_aL, new ItemStack(Item.field_77756_aW, 1, 0), Item.field_77676_L});
      this.func_92103_a(new ItemStack(Block.field_72031_aZ, 2), new Object[]{"###", "###", Character.valueOf('#'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Block.field_82515_ce, 6, 0), new Object[]{"###", "###", Character.valueOf('#'), Block.field_71978_w});
      this.func_92103_a(new ItemStack(Block.field_82515_ce, 6, 1), new Object[]{"###", "###", Character.valueOf('#'), Block.field_72087_ao});
      this.func_92103_a(new ItemStack(Block.field_72098_bB, 6), new Object[]{"###", "###", Character.valueOf('#'), Block.field_72033_bA});
      this.func_92103_a(new ItemStack(Block.field_71993_bv, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('W'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_72032_aY, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77702_n});
      this.func_92103_a(new ItemStack(Block.field_71960_R, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77767_aC});
      this.func_92103_a(new ItemStack(Block.field_72093_an, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77760_aL});
      this.func_92103_a(new ItemStack(Block.field_72039_aU, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77768_aD});
      this.func_92103_a(new ItemStack(Block.field_72037_aS, 6), new Object[]{"###", Character.valueOf('#'), Block.field_72039_aU});
      this.func_92103_a(new ItemStack(Block.field_72041_aW, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77757_aI});
      this.func_92103_a(new ItemStack(Block.field_72081_al, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77772_aH});
      this.func_92103_a(new ItemStack(Block.field_72014_bd, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77751_aT});
      this.func_92103_a(new ItemStack(Block.field_94339_ct, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_94583_ca});
      this.func_92103_a(new ItemStack(Block.field_72101_ab, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.field_77683_K});
      this.func_92103_a(new ItemStack(Block.field_72091_am, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Item.field_77677_M, Character.valueOf('#'), Block.field_71939_E});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 3), new Object[]{"###", Character.valueOf('#'), Block.field_71978_w});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 0), new Object[]{"###", Character.valueOf('#'), Block.field_71981_t});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 1), new Object[]{"###", Character.valueOf('#'), Block.field_71957_Q});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 4), new Object[]{"###", Character.valueOf('#'), Block.field_72081_al});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 5), new Object[]{"###", Character.valueOf('#'), Block.field_72007_bm});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 6), new Object[]{"###", Character.valueOf('#'), Block.field_72033_bA});
      this.func_92103_a(new ItemStack(Block.field_72079_ak, 6, 7), new Object[]{"###", Character.valueOf('#'), Block.field_94339_ct});
      this.func_92103_a(new ItemStack(Block.field_72092_bO, 6, 0), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 0)});
      this.func_92103_a(new ItemStack(Block.field_72092_bO, 6, 2), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 2)});
      this.func_92103_a(new ItemStack(Block.field_72092_bO, 6, 1), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 1)});
      this.func_92103_a(new ItemStack(Block.field_72092_bO, 6, 3), new Object[]{"###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 3)});
      this.func_92103_a(new ItemStack(Block.field_72055_aF, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Item.field_77790_av, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_72005_bk, 2), new Object[]{"###", "###", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Item.field_77766_aB, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Item.field_77703_o});
      this.func_92103_a(new ItemStack(Item.field_77792_au, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('X'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Item.field_77746_aZ, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Item.field_77771_aG, Character.valueOf('B'), Item.field_77747_aY, Character.valueOf('C'), Item.field_77685_T, Character.valueOf('E'), Item.field_77764_aP});
      this.func_92103_a(new ItemStack(Item.field_77747_aY, 1), new Object[]{"#", Character.valueOf('#'), Item.field_77758_aJ});
      this.func_92103_a(new ItemStack(Block.field_71988_x, 4, 0), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 0)});
      this.func_92103_a(new ItemStack(Block.field_71988_x, 4, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 1)});
      this.func_92103_a(new ItemStack(Block.field_71988_x, 4, 2), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 2)});
      this.func_92103_a(new ItemStack(Block.field_71988_x, 4, 3), new Object[]{"#", Character.valueOf('#'), new ItemStack(Block.field_71951_J, 1, 3)});
      this.func_92103_a(new ItemStack(Item.field_77669_D, 4), new Object[]{"#", "#", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_72069_aq, 4), new Object[]{"X", "#", Character.valueOf('X'), Item.field_77705_m, Character.valueOf('#'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Block.field_72069_aq, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Item.field_77705_m, 1, 1), Character.valueOf('#'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Item.field_77670_E, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Item.field_77729_bt, 3), new Object[]{"# #", " # ", Character.valueOf('#'), Block.field_71946_M});
      this.func_92103_a(new ItemStack(Block.field_72056_aG, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('#'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Block.field_71954_T, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Item.field_77717_p, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('#'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Block.field_94337_cv, 6), new Object[]{"XSX", "X#X", "XSX", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('#'), Block.field_72035_aQ, Character.valueOf('S'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Block.field_71953_U, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Item.field_77703_o, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('#'), Block.field_72044_aK});
      this.func_92103_a(new ItemStack(Item.field_77773_az, 1), new Object[]{"# #", "###", Character.valueOf('#'), Item.field_77703_o});
      this.func_92103_a(new ItemStack(Item.field_77721_bz, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Item.field_77703_o});
      this.func_92103_a(new ItemStack(Item.field_77724_by, 1), new Object[]{" B ", "###", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('B'), Item.field_77731_bo});
      this.func_92103_a(new ItemStack(Block.field_72008_bf, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72061_ba, Character.valueOf('B'), Block.field_72069_aq});
      this.func_92103_a(new ItemStack(Item.field_77762_aN, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72077_au, Character.valueOf('B'), Item.field_77773_az});
      this.func_92103_a(new ItemStack(Item.field_77763_aO, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72051_aB, Character.valueOf('B'), Item.field_77773_az});
      this.func_92103_a(new ItemStack(Item.field_94582_cb, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_72091_am, Character.valueOf('B'), Item.field_77773_az});
      this.func_92103_a(new ItemStack(Item.field_96600_cc, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.field_94340_cs, Character.valueOf('B'), Item.field_77773_az});
      this.func_92103_a(new ItemStack(Item.field_77769_aE, 1), new Object[]{"# #", "###", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Item.field_77788_aw, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Item.field_77703_o});
      this.func_92103_a(new ItemStack(Item.field_82796_bJ, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Item.field_77772_aH});
      this.func_92103_a(new ItemStack(Item.field_77709_i, 1), new Object[]{"A ", " B", Character.valueOf('A'), Item.field_77703_o, Character.valueOf('B'), Item.field_77804_ap});
      this.func_92103_a(new ItemStack(Item.field_77684_U, 1), new Object[]{"###", Character.valueOf('#'), Item.field_77685_T});
      this.func_92103_a(new ItemStack(Block.field_72063_at, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 0)});
      this.func_92103_a(new ItemStack(Block.field_72072_bX, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 2)});
      this.func_92103_a(new ItemStack(Block.field_72074_bW, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 1)});
      this.func_92103_a(new ItemStack(Block.field_72070_bY, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Block.field_71988_x, 1, 3)});
      this.func_92103_a(new ItemStack(Item.field_77749_aR, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77683_K});
      this.func_92103_a(new ItemStack(Item.field_82793_bR, 1), new Object[]{"# ", " X", Character.valueOf('#'), Item.field_77749_aR, Character.valueOf('X'), Item.field_82797_bK}).func_92100_c();
      this.func_92103_a(new ItemStack(Block.field_72057_aH, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_71978_w});
      this.func_92103_a(new ItemStack(Block.field_71992_bw, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_72081_al});
      this.func_92103_a(new ItemStack(Block.field_71995_bx, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_72007_bm});
      this.func_92103_a(new ItemStack(Block.field_72100_bC, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_72033_bA});
      this.func_92103_a(new ItemStack(Block.field_72088_bQ, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_71957_Q});
      this.func_92103_a(new ItemStack(Block.field_94338_cu, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.field_94339_ct});
      this.func_92103_a(new ItemStack(Item.field_77780_as, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Block.field_72101_ab});
      this.func_92103_a(new ItemStack(Item.field_82802_bI, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77770_aF});
      this.func_92103_a(new ItemStack(Item.field_77778_at, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77733_bq, Character.valueOf('X'), Item.field_77706_j});
      this.func_92103_a(new ItemStack(Item.field_77778_at, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.field_72105_ah, Character.valueOf('X'), Item.field_77706_j});
      this.func_92103_a(new ItemStack(Item.field_82798_bP, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77733_bq, Character.valueOf('X'), Item.field_82797_bK});
      this.func_92103_a(new ItemStack(Block.field_72043_aJ, 1), new Object[]{"X", "#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77669_D});
      this.func_92103_a(new ItemStack(Block.field_72064_bT, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), Block.field_71988_x, Character.valueOf('S'), Item.field_77669_D, Character.valueOf('I'), Item.field_77703_o});
      this.func_92103_a(new ItemStack(Block.field_72035_aQ, 1), new Object[]{"X", "#", Character.valueOf('#'), Item.field_77669_D, Character.valueOf('X'), Item.field_77767_aC});
      this.func_92103_a(new ItemStack(Item.field_77742_bb, 1), new Object[]{"#X#", "III", Character.valueOf('#'), Block.field_72035_aQ, Character.valueOf('X'), Item.field_77767_aC, Character.valueOf('I'), Block.field_71981_t});
      this.func_92103_a(new ItemStack(Item.field_94585_bY, 1), new Object[]{" # ", "#X#", "III", Character.valueOf('#'), Block.field_72035_aQ, Character.valueOf('X'), Item.field_94583_ca, Character.valueOf('I'), Block.field_71981_t});
      this.func_92103_a(new ItemStack(Item.field_77752_aS, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.field_77717_p, Character.valueOf('X'), Item.field_77767_aC});
      this.func_92103_a(new ItemStack(Item.field_77750_aQ, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.field_77703_o, Character.valueOf('X'), Item.field_77767_aC});
      this.func_92103_a(new ItemStack(Item.field_82801_bO, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.field_77759_aK, Character.valueOf('X'), Item.field_77750_aQ});
      this.func_92103_a(new ItemStack(Block.field_72034_aR, 1), new Object[]{"#", Character.valueOf('#'), Block.field_71981_t});
      this.func_92103_a(new ItemStack(Block.field_82511_ci, 1), new Object[]{"#", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_72044_aK, 1), new Object[]{"##", Character.valueOf('#'), Block.field_71981_t});
      this.func_92103_a(new ItemStack(Block.field_72046_aM, 1), new Object[]{"##", Character.valueOf('#'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_94345_cm, 1), new Object[]{"##", Character.valueOf('#'), Item.field_77703_o});
      this.func_92103_a(new ItemStack(Block.field_94348_cl, 1), new Object[]{"##", Character.valueOf('#'), Item.field_77717_p});
      this.func_92103_a(new ItemStack(Block.field_71958_P, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77707_k, Character.valueOf('R'), Item.field_77767_aC});
      this.func_92103_a(new ItemStack(Block.field_96469_cy, 1), new Object[]{"###", "# #", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('R'), Item.field_77767_aC});
      this.func_92103_a(new ItemStack(Block.field_71963_Z, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), Block.field_71978_w, Character.valueOf('X'), Item.field_77703_o, Character.valueOf('R'), Item.field_77767_aC, Character.valueOf('T'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_71956_V, 1), new Object[]{"S", "P", Character.valueOf('S'), Item.field_77761_aM, Character.valueOf('P'), Block.field_71963_Z});
      this.func_92103_a(new ItemStack(Item.field_77776_ba, 1), new Object[]{"###", "XXX", Character.valueOf('#'), Block.field_72101_ab, Character.valueOf('X'), Block.field_71988_x});
      this.func_92103_a(new ItemStack(Block.field_72096_bE, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), Block.field_72089_ap, Character.valueOf('B'), Item.field_77760_aL, Character.valueOf('D'), Item.field_77702_n});
      this.func_92103_a(new ItemStack(Block.field_82510_ck, 1), new Object[]{"III", " i ", "iii", Character.valueOf('I'), Block.field_72083_ai, Character.valueOf('i'), Item.field_77703_o});
      this.func_77596_b(new ItemStack(Item.field_77748_bA, 1), new Object[]{Item.field_77730_bn, Item.field_77722_bw});
      this.func_77596_b(new ItemStack(Item.field_77811_bE, 3), new Object[]{Item.field_77677_M, Item.field_77722_bw, Item.field_77705_m});
      this.func_77596_b(new ItemStack(Item.field_77811_bE, 3), new Object[]{Item.field_77677_M, Item.field_77722_bw, new ItemStack(Item.field_77705_m, 1, 1)});
      this.func_92103_a(new ItemStack(Block.field_94344_cp), new Object[]{"GGG", "QQQ", "WWW", Character.valueOf('G'), Block.field_71946_M, Character.valueOf('Q'), Item.field_94583_ca, Character.valueOf('W'), Block.field_72092_bO});
      this.func_92103_a(new ItemStack(Block.field_94340_cs), new Object[]{"I I", "ICI", " I ", Character.valueOf('I'), Item.field_77703_o, Character.valueOf('C'), Block.field_72077_au});
      Collections.sort(this.field_77597_b, new RecipeSorter(this));
      System.out.println(this.field_77597_b.size() + " recipes");
   }

   public ShapedRecipes func_92103_a(ItemStack p_92103_1_, Object ... p_92103_2_) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if(p_92103_2_[var4] instanceof String[]) {
         String[] var7 = (String[])((String[])p_92103_2_[var4++]);

         for(int var8 = 0; var8 < var7.length; ++var8) {
            String var9 = var7[var8];
            ++var6;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while(p_92103_2_[var4] instanceof String) {
            String var11 = (String)p_92103_2_[var4++];
            ++var6;
            var5 = var11.length();
            var3 = var3 + var11;
         }
      }

      HashMap var12;
      for(var12 = new HashMap(); var4 < p_92103_2_.length; var4 += 2) {
         Character var13 = (Character)p_92103_2_[var4];
         ItemStack var14 = null;
         if(p_92103_2_[var4 + 1] instanceof Item) {
            var14 = new ItemStack((Item)p_92103_2_[var4 + 1]);
         } else if(p_92103_2_[var4 + 1] instanceof Block) {
            var14 = new ItemStack((Block)p_92103_2_[var4 + 1], 1, 32767);
         } else if(p_92103_2_[var4 + 1] instanceof ItemStack) {
            var14 = (ItemStack)p_92103_2_[var4 + 1];
         }

         var12.put(var13, var14);
      }

      ItemStack[] var15 = new ItemStack[var5 * var6];

      for(int var16 = 0; var16 < var5 * var6; ++var16) {
         char var10 = var3.charAt(var16);
         if(var12.containsKey(Character.valueOf(var10))) {
            var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).func_77946_l();
         } else {
            var15[var16] = null;
         }
      }

      ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, p_92103_1_);
      this.field_77597_b.add(var17);
      return var17;
   }

   public void func_77596_b(ItemStack p_77596_1_, Object ... p_77596_2_) {
      ArrayList var3 = new ArrayList();
      Object[] var4 = p_77596_2_;
      int var5 = p_77596_2_.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).func_77946_l());
         } else if(var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new RuntimeException("Invalid shapeless recipy!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.field_77597_b.add(new ShapelessRecipes(p_77596_1_, var3));
   }

   public ItemStack func_82787_a(InventoryCrafting p_82787_1_, World p_82787_2_) {
      int var3 = 0;
      ItemStack var4 = null;
      ItemStack var5 = null;

      int var6;
      for(var6 = 0; var6 < p_82787_1_.func_70302_i_(); ++var6) {
         ItemStack var7 = p_82787_1_.func_70301_a(var6);
         if(var7 != null) {
            if(var3 == 0) {
               var4 = var7;
            }

            if(var3 == 1) {
               var5 = var7;
            }

            ++var3;
         }
      }

      if(var3 == 2 && var4.field_77993_c == var5.field_77993_c && var4.field_77994_a == 1 && var5.field_77994_a == 1 && Item.field_77698_e[var4.field_77993_c].func_77645_m()) {
         Item var11 = Item.field_77698_e[var4.field_77993_c];
         int var13 = var11.func_77612_l() - var4.func_77952_i();
         int var8 = var11.func_77612_l() - var5.func_77952_i();
         int var9 = var13 + var8 + var11.func_77612_l() * 5 / 100;
         int var10 = var11.func_77612_l() - var9;
         if(var10 < 0) {
            var10 = 0;
         }

         return new ItemStack(var4.field_77993_c, 1, var10);
      } else {
         for(var6 = 0; var6 < this.field_77597_b.size(); ++var6) {
            IRecipe var12 = (IRecipe)this.field_77597_b.get(var6);
            if(var12.func_77569_a(p_82787_1_, p_82787_2_)) {
               return var12.func_77572_b(p_82787_1_);
            }
         }

         return null;
      }
   }

   public List func_77592_b() {
      return this.field_77597_b;
   }

}
