package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.gen.structure.ComponentMineshaftCorridor;
import net.minecraft.world.gen.structure.ComponentMineshaftCross;
import net.minecraft.world.gen.structure.ComponentMineshaftStairs;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureMineshaftPieces {

   public static final WeightedRandomChestContent[] field_78818_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 1, 3, 5), new WeightedRandomChestContent(Item.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new WeightedRandomChestContent(Item.field_77756_aW.field_77779_bT, 4, 4, 9, 5), new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 2, 3), new WeightedRandomChestContent(Item.field_77705_m.field_77779_bT, 0, 3, 8, 10), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77696_g.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Block.field_72056_aG.field_71990_ca, 0, 4, 8, 1), new WeightedRandomChestContent(Item.field_77740_bh.field_77779_bT, 0, 2, 4, 10), new WeightedRandomChestContent(Item.field_77739_bg.field_77779_bT, 0, 2, 4, 10)};


   private static StructureComponent func_78815_a(List p_78815_0_, Random p_78815_1_, int p_78815_2_, int p_78815_3_, int p_78815_4_, int p_78815_5_, int p_78815_6_) {
      int var7 = p_78815_1_.nextInt(100);
      StructureBoundingBox var8;
      if(var7 >= 80) {
         var8 = ComponentMineshaftCross.func_74951_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
         if(var8 != null) {
            return new ComponentMineshaftCross(p_78815_6_, p_78815_1_, var8, p_78815_5_);
         }
      } else if(var7 >= 70) {
         var8 = ComponentMineshaftStairs.func_74950_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
         if(var8 != null) {
            return new ComponentMineshaftStairs(p_78815_6_, p_78815_1_, var8, p_78815_5_);
         }
      } else {
         var8 = ComponentMineshaftCorridor.func_74954_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
         if(var8 != null) {
            return new ComponentMineshaftCorridor(p_78815_6_, p_78815_1_, var8, p_78815_5_);
         }
      }

      return null;
   }

   private static StructureComponent func_78817_b(StructureComponent p_78817_0_, List p_78817_1_, Random p_78817_2_, int p_78817_3_, int p_78817_4_, int p_78817_5_, int p_78817_6_, int p_78817_7_) {
      if(p_78817_7_ > 8) {
         return null;
      } else if(Math.abs(p_78817_3_ - p_78817_0_.func_74874_b().field_78897_a) <= 80 && Math.abs(p_78817_5_ - p_78817_0_.func_74874_b().field_78896_c) <= 80) {
         StructureComponent var8 = func_78815_a(p_78817_1_, p_78817_2_, p_78817_3_, p_78817_4_, p_78817_5_, p_78817_6_, p_78817_7_ + 1);
         if(var8 != null) {
            p_78817_1_.add(var8);
            var8.func_74861_a(p_78817_0_, p_78817_1_, p_78817_2_);
         }

         return var8;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static StructureComponent func_78814_a(StructureComponent p_78814_0_, List p_78814_1_, Random p_78814_2_, int p_78814_3_, int p_78814_4_, int p_78814_5_, int p_78814_6_, int p_78814_7_) {
      return func_78817_b(p_78814_0_, p_78814_1_, p_78814_2_, p_78814_3_, p_78814_4_, p_78814_5_, p_78814_6_, p_78814_7_);
   }

   // $FF: synthetic method
   static WeightedRandomChestContent[] func_78816_a() {
      return field_78818_a;
   }

}
