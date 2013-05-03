package net.minecraft.item.crafting;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FurnaceRecipes {

   private static final FurnaceRecipes field_77606_a = new FurnaceRecipes();
   private Map field_77604_b = new HashMap();
   private Map field_77605_c = new HashMap();


   public static final FurnaceRecipes func_77602_a() {
      return field_77606_a;
   }

   private FurnaceRecipes() {
      this.func_77600_a(Block.field_71949_H.field_71990_ca, new ItemStack(Item.field_77703_o), 0.7F);
      this.func_77600_a(Block.field_71941_G.field_71990_ca, new ItemStack(Item.field_77717_p), 1.0F);
      this.func_77600_a(Block.field_72073_aw.field_71990_ca, new ItemStack(Item.field_77702_n), 1.0F);
      this.func_77600_a(Block.field_71939_E.field_71990_ca, new ItemStack(Block.field_71946_M), 0.1F);
      this.func_77600_a(Item.field_77784_aq.field_77779_bT, new ItemStack(Item.field_77782_ar), 0.35F);
      this.func_77600_a(Item.field_77741_bi.field_77779_bT, new ItemStack(Item.field_77734_bj), 0.35F);
      this.func_77600_a(Item.field_77735_bk.field_77779_bT, new ItemStack(Item.field_77736_bl), 0.35F);
      this.func_77600_a(Item.field_77754_aU.field_77779_bT, new ItemStack(Item.field_77753_aV), 0.35F);
      this.func_77600_a(Block.field_71978_w.field_71990_ca, new ItemStack(Block.field_71981_t), 0.1F);
      this.func_77600_a(Item.field_77757_aI.field_77779_bT, new ItemStack(Item.field_77772_aH), 0.3F);
      this.func_77600_a(Block.field_72038_aV.field_71990_ca, new ItemStack(Item.field_77756_aW, 1, 2), 0.2F);
      this.func_77600_a(Block.field_71951_J.field_71990_ca, new ItemStack(Item.field_77705_m, 1, 1), 0.15F);
      this.func_77600_a(Block.field_72068_bR.field_71990_ca, new ItemStack(Item.field_77817_bH), 1.0F);
      this.func_77600_a(Item.field_82794_bL.field_77779_bT, new ItemStack(Item.field_82795_bM), 0.35F);
      this.func_77600_a(Block.field_72012_bb.field_71990_ca, new ItemStack(Item.field_94584_bZ), 0.1F);
      this.func_77600_a(Block.field_71950_I.field_71990_ca, new ItemStack(Item.field_77705_m), 0.1F);
      this.func_77600_a(Block.field_72047_aN.field_71990_ca, new ItemStack(Item.field_77767_aC), 0.7F);
      this.func_77600_a(Block.field_71947_N.field_71990_ca, new ItemStack(Item.field_77756_aW, 1, 4), 0.2F);
      this.func_77600_a(Block.field_94342_cr.field_71990_ca, new ItemStack(Item.field_94583_ca), 0.2F);
   }

   public void func_77600_a(int p_77600_1_, ItemStack p_77600_2_, float p_77600_3_) {
      this.field_77604_b.put(Integer.valueOf(p_77600_1_), p_77600_2_);
      this.field_77605_c.put(Integer.valueOf(p_77600_2_.field_77993_c), Float.valueOf(p_77600_3_));
   }

   public ItemStack func_77603_b(int p_77603_1_) {
      return (ItemStack)this.field_77604_b.get(Integer.valueOf(p_77603_1_));
   }

   public Map func_77599_b() {
      return this.field_77604_b;
   }

   public float func_77601_c(int p_77601_1_) {
      return this.field_77605_c.containsKey(Integer.valueOf(p_77601_1_))?((Float)this.field_77605_c.get(Integer.valueOf(p_77601_1_))).floatValue():0.0F;
   }

}
