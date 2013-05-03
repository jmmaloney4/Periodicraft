package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLever;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentScatteredFeature;
import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces2;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureScatteredFeatureStones;

public class ComponentScatteredFeatureJunglePyramid extends ComponentScatteredFeature {

   private boolean field_74947_h;
   private boolean field_74948_i;
   private boolean field_74945_j;
   private boolean field_74946_k;
   public static final WeightedRandomChestContent[] field_74943_l = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 3, 3), new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 2, 7, 15), new WeightedRandomChestContent(Item.field_77817_bH.field_77779_bT, 0, 1, 3, 2), new WeightedRandomChestContent(Item.field_77755_aX.field_77779_bT, 0, 4, 6, 20), new WeightedRandomChestContent(Item.field_77737_bm.field_77779_bT, 0, 3, 7, 16)};
   public static final WeightedRandomChestContent[] field_74944_m = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77704_l.field_77779_bT, 0, 2, 7, 30)};
   private static StructureScatteredFeatureStones field_74942_n = new StructureScatteredFeatureStones((ComponentScatteredFeaturePieces2)null);


   public ComponentScatteredFeatureJunglePyramid(Random p_i3835_1_, int p_i3835_2_, int p_i3835_3_) {
      super(p_i3835_1_, p_i3835_2_, 64, p_i3835_3_, 12, 10, 15);
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(!this.func_74935_a(p_74875_1_, p_74875_3_, 0)) {
         return false;
      } else {
         int var4 = this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3);
         int var5 = this.func_74863_c(Block.field_72057_aH.field_71990_ca, 2);
         int var6 = this.func_74863_c(Block.field_72057_aH.field_71990_ca, 0);
         int var7 = this.func_74863_c(Block.field_72057_aH.field_71990_ca, 1);
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, -4, 0, this.field_74939_a - 1, 0, this.field_74938_c - 1, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 1, 2, 9, 2, 2, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 1, 12, 9, 2, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 1, 3, 2, 2, 11, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 9, 1, 3, 9, 2, 11, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 1, 10, 6, 1, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 13, 10, 6, 13, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 2, 1, 6, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 10, 3, 2, 10, 6, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 3, 2, 9, 3, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 6, 2, 9, 6, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 3, 7, 3, 8, 7, 11, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 8, 4, 7, 8, 10, false, p_74875_2_, field_74942_n);
         this.func_74878_a(p_74875_1_, p_74875_3_, 3, 1, 3, 8, 2, 11);
         this.func_74878_a(p_74875_1_, p_74875_3_, 4, 3, 6, 7, 3, 9);
         this.func_74878_a(p_74875_1_, p_74875_3_, 2, 4, 2, 9, 5, 12);
         this.func_74878_a(p_74875_1_, p_74875_3_, 4, 6, 5, 7, 6, 9);
         this.func_74878_a(p_74875_1_, p_74875_3_, 5, 7, 6, 6, 7, 8);
         this.func_74878_a(p_74875_1_, p_74875_3_, 5, 1, 2, 6, 2, 2);
         this.func_74878_a(p_74875_1_, p_74875_3_, 5, 2, 12, 6, 2, 12);
         this.func_74878_a(p_74875_1_, p_74875_3_, 5, 5, 1, 6, 5, 1);
         this.func_74878_a(p_74875_1_, p_74875_3_, 5, 5, 13, 6, 5, 13);
         this.func_74864_a(p_74875_1_, 0, 0, 1, 5, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, 0, 0, 10, 5, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, 0, 0, 1, 5, 9, p_74875_3_);
         this.func_74864_a(p_74875_1_, 0, 0, 10, 5, 9, p_74875_3_);

         int var8;
         for(var8 = 0; var8 <= 14; var8 += 14) {
            this.func_74882_a(p_74875_1_, p_74875_3_, 2, 4, var8, 2, 5, var8, false, p_74875_2_, field_74942_n);
            this.func_74882_a(p_74875_1_, p_74875_3_, 4, 4, var8, 4, 5, var8, false, p_74875_2_, field_74942_n);
            this.func_74882_a(p_74875_1_, p_74875_3_, 7, 4, var8, 7, 5, var8, false, p_74875_2_, field_74942_n);
            this.func_74882_a(p_74875_1_, p_74875_3_, 9, 4, var8, 9, 5, var8, false, p_74875_2_, field_74942_n);
         }

         this.func_74882_a(p_74875_1_, p_74875_3_, 5, 6, 0, 6, 6, 0, false, p_74875_2_, field_74942_n);

         for(var8 = 0; var8 <= 11; var8 += 11) {
            for(int var9 = 2; var9 <= 12; var9 += 2) {
               this.func_74882_a(p_74875_1_, p_74875_3_, var8, 4, var9, var8, 5, var9, false, p_74875_2_, field_74942_n);
            }

            this.func_74882_a(p_74875_1_, p_74875_3_, var8, 6, 5, var8, 6, 5, false, p_74875_2_, field_74942_n);
            this.func_74882_a(p_74875_1_, p_74875_3_, var8, 6, 9, var8, 6, 9, false, p_74875_2_, field_74942_n);
         }

         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 7, 2, 2, 9, 2, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 9, 7, 2, 9, 9, 2, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 2, 7, 12, 2, 9, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 9, 7, 12, 9, 9, 12, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 9, 4, 4, 9, 4, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 7, 9, 4, 7, 9, 4, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 9, 10, 4, 9, 10, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 7, 9, 10, 7, 9, 10, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 5, 9, 7, 6, 9, 7, false, p_74875_2_, field_74942_n);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 5, 9, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 6, 9, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var5, 5, 9, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var5, 6, 9, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 4, 0, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 5, 0, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 6, 0, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 7, 0, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 4, 1, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 4, 2, 9, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 4, 3, 10, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 7, 1, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 7, 2, 9, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 7, 3, 10, p_74875_3_);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 1, 9, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 7, 1, 9, 7, 1, 9, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 10, 7, 2, 10, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 5, 4, 5, 6, 4, 5, false, p_74875_2_, field_74942_n);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var6, 4, 4, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var7, 7, 4, 5, p_74875_3_);

         for(var8 = 0; var8 < 4; ++var8) {
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var5, 5, 0 - var8, 6 + var8, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var5, 6, 0 - var8, 6 + var8, p_74875_3_);
            this.func_74878_a(p_74875_1_, p_74875_3_, 5, 0 - var8, 7 + var8, 6, 0 - var8, 9 + var8);
         }

         this.func_74878_a(p_74875_1_, p_74875_3_, 1, -3, 12, 10, -1, 13);
         this.func_74878_a(p_74875_1_, p_74875_3_, 1, -3, 1, 3, -1, 13);
         this.func_74878_a(p_74875_1_, p_74875_3_, 1, -3, 1, 9, -1, 5);

         for(var8 = 1; var8 <= 13; var8 += 2) {
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, -3, var8, 1, -2, var8, false, p_74875_2_, field_74942_n);
         }

         for(var8 = 2; var8 <= 12; var8 += 2) {
            this.func_74882_a(p_74875_1_, p_74875_3_, 1, -1, var8, 3, -1, var8, false, p_74875_2_, field_74942_n);
         }

         this.func_74882_a(p_74875_1_, p_74875_3_, 2, -2, 1, 5, -2, 1, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 7, -2, 1, 9, -2, 1, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 6, -3, 1, 6, -3, 1, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 6, -1, 1, 6, -1, 1, false, p_74875_2_, field_74942_n);
         this.func_74864_a(p_74875_1_, Block.field_72064_bT.field_71990_ca, this.func_74863_c(Block.field_72064_bT.field_71990_ca, 3) | 4, 1, -3, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72064_bT.field_71990_ca, this.func_74863_c(Block.field_72064_bT.field_71990_ca, 1) | 4, 4, -3, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72062_bU.field_71990_ca, 4, 2, -3, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72062_bU.field_71990_ca, 4, 3, -3, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 7, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 5, -3, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 4, -3, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 3, -3, 1, p_74875_3_);
         if(!this.field_74945_j) {
            this.field_74945_j = this.func_74869_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, -2, 1, 2, field_74944_m, 2);
         }

         this.func_74864_a(p_74875_1_, Block.field_71998_bu.field_71990_ca, 15, 3, -2, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72064_bT.field_71990_ca, this.func_74863_c(Block.field_72064_bT.field_71990_ca, 2) | 4, 7, -3, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72064_bT.field_71990_ca, this.func_74863_c(Block.field_72064_bT.field_71990_ca, 0) | 4, 7, -3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72062_bU.field_71990_ca, 4, 7, -3, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72062_bU.field_71990_ca, 4, 7, -3, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72062_bU.field_71990_ca, 4, 7, -3, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 8, -3, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 9, -3, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 9, -3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 9, -3, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 9, -2, 4, p_74875_3_);
         if(!this.field_74946_k) {
            this.field_74946_k = this.func_74869_a(p_74875_1_, p_74875_3_, p_74875_2_, 9, -2, 3, 4, field_74944_m, 2);
         }

         this.func_74864_a(p_74875_1_, Block.field_71998_bu.field_71990_ca, 15, 8, -1, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_71998_bu.field_71990_ca, 15, 8, -2, 3, p_74875_3_);
         if(!this.field_74947_h) {
            this.field_74947_h = this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 8, -3, 3, WeightedRandomChestContent.func_92080_a(field_74943_l, new WeightedRandomChestContent[]{Item.field_92105_bW.func_92114_b(p_74875_2_)}), 2 + p_74875_2_.nextInt(5));
         }

         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 9, -3, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 8, -3, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 4, -3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 5, -2, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 5, -1, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 6, -3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 7, -2, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 7, -1, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 8, -3, 5, p_74875_3_);
         this.func_74882_a(p_74875_1_, p_74875_3_, 9, -1, 1, 9, -1, 5, false, p_74875_2_, field_74942_n);
         this.func_74878_a(p_74875_1_, p_74875_3_, 8, -3, 8, 10, -1, 10);
         this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 3, 8, -2, 11, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 3, 9, -2, 11, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 3, 10, -2, 11, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72043_aJ.field_71990_ca, BlockLever.func_72196_d(this.func_74863_c(Block.field_72043_aJ.field_71990_ca, 2)), 8, -2, 12, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72043_aJ.field_71990_ca, BlockLever.func_72196_d(this.func_74863_c(Block.field_72043_aJ.field_71990_ca, 2)), 9, -2, 12, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72043_aJ.field_71990_ca, BlockLever.func_72196_d(this.func_74863_c(Block.field_72043_aJ.field_71990_ca, 2)), 10, -2, 12, p_74875_3_);
         this.func_74882_a(p_74875_1_, p_74875_3_, 8, -3, 8, 8, -3, 10, false, p_74875_2_, field_74942_n);
         this.func_74882_a(p_74875_1_, p_74875_3_, 10, -3, 8, 10, -3, 10, false, p_74875_2_, field_74942_n);
         this.func_74864_a(p_74875_1_, Block.field_72087_ao.field_71990_ca, 0, 10, -2, 9, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 8, -2, 9, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 8, -2, 10, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72075_av.field_71990_ca, 0, 10, -1, 9, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_71956_V.field_71990_ca, 1, 9, -2, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_71956_V.field_71990_ca, this.func_74863_c(Block.field_71956_V.field_71990_ca, 4), 10, -2, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_71956_V.field_71990_ca, this.func_74863_c(Block.field_71956_V.field_71990_ca, 4), 10, -1, 8, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72010_bh.field_71990_ca, this.func_74863_c(Block.field_72010_bh.field_71990_ca, 2), 10, -2, 10, p_74875_3_);
         if(!this.field_74948_i) {
            this.field_74948_i = this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 9, -3, 10, WeightedRandomChestContent.func_92080_a(field_74943_l, new WeightedRandomChestContent[]{Item.field_92105_bW.func_92114_b(p_74875_2_)}), 2 + p_74875_2_.nextInt(5));
         }

         return true;
      }
   }

}
