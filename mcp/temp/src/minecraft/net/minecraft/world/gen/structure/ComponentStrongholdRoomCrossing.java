package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdRoomCrossing extends ComponentStronghold {

   public static final WeightedRandomChestContent[] field_75014_c = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 1, 3, 5), new WeightedRandomChestContent(Item.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new WeightedRandomChestContent(Item.field_77705_m.field_77779_bT, 0, 3, 8, 10), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77696_g.field_77779_bT, 0, 1, 1, 1)};
   protected final EnumDoor field_75015_a;
   protected final int field_75013_b;


   public ComponentStrongholdRoomCrossing(int p_i3848_1_, Random p_i3848_2_, StructureBoundingBox p_i3848_3_, int p_i3848_4_) {
      super(p_i3848_1_);
      this.field_74885_f = p_i3848_4_;
      this.field_75015_a = this.func_74988_a(p_i3848_2_);
      this.field_74887_e = p_i3848_3_;
      this.field_75013_b = p_i3848_2_.nextInt(5);
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 4, 1);
      this.func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
      this.func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
   }

   public static ComponentStrongholdRoomCrossing func_75012_a(List p_75012_0_, Random p_75012_1_, int p_75012_2_, int p_75012_3_, int p_75012_4_, int p_75012_5_, int p_75012_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75012_2_, p_75012_3_, p_75012_4_, -4, -1, 0, 11, 7, 11, p_75012_5_);
      return func_74991_a(var7) && StructureComponent.func_74883_a(p_75012_0_, var7) == null?new ComponentStrongholdRoomCrossing(p_75012_6_, p_75012_1_, var7, p_75012_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 6, 10, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_75015_a, 4, 1, 0);
         this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 10, 6, 3, 10, 0, 0, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 6, 0, 0, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 10, 1, 4, 10, 3, 6, 0, 0, false);
         int var4;
         switch(this.field_75013_b) {
         case 0:
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 5, 1, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 5, 2, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 5, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 4, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 6, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 5, 3, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 5, 3, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 4, 1, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 4, 1, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 4, 1, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 6, 1, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 6, 1, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 6, 1, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 5, 1, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 0, 5, 1, 6, p_74875_3_);
            break;
         case 1:
            for(var4 = 0; var4 < 5; ++var4) {
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 1, 3 + var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 7, 1, 3 + var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3 + var4, 1, 3, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3 + var4, 1, 7, p_74875_3_);
            }

            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 5, 1, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 5, 2, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 5, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71942_A.field_71990_ca, 0, 5, 4, 5, p_74875_3_);
            break;
         case 2:
            for(var4 = 1; var4 <= 9; ++var4) {
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 1, 3, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 9, 3, var4, p_74875_3_);
            }

            for(var4 = 1; var4 <= 9; ++var4) {
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var4, 3, 1, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var4, 3, 9, p_74875_3_);
            }

            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 5, 1, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 5, 1, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 5, 3, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 5, 3, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 1, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 6, 1, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 6, 3, 5, p_74875_3_);

            for(var4 = 1; var4 <= 3; ++var4) {
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, var4, 4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 6, var4, 4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, var4, 6, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 6, var4, 6, p_74875_3_);
            }

            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 5, 3, 5, p_74875_3_);

            for(var4 = 2; var4 <= 8; ++var4) {
               this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 2, 3, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 3, 3, var4, p_74875_3_);
               if(var4 <= 3 || var4 >= 7) {
                  this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 4, 3, var4, p_74875_3_);
                  this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 5, 3, var4, p_74875_3_);
                  this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 6, 3, var4, p_74875_3_);
               }

               this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 7, 3, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 3, var4, p_74875_3_);
            }

            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, this.func_74863_c(Block.field_72055_aF.field_71990_ca, 4), 9, 1, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, this.func_74863_c(Block.field_72055_aF.field_71990_ca, 4), 9, 2, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, this.func_74863_c(Block.field_72055_aF.field_71990_ca, 4), 9, 3, 3, p_74875_3_);
            this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 4, 8, WeightedRandomChestContent.func_92080_a(field_75014_c, new WeightedRandomChestContent[]{Item.field_92105_bW.func_92114_b(p_74875_2_)}), 1 + p_74875_2_.nextInt(4));
         }

         return true;
      }
   }

}
