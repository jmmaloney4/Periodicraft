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

public class ComponentStrongholdChestCorridor extends ComponentStronghold {

   public static final WeightedRandomChestContent[] field_75003_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77730_bn.field_77779_bT, 0, 1, 1, 10), new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 3, 3), new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 1, 3, 5), new WeightedRandomChestContent(Item.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77696_g.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77716_q.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77822_ae.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77812_ad.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77824_af.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77818_ag.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77778_at.field_77779_bT, 0, 1, 1, 1)};
   private final EnumDoor field_75001_b;
   private boolean field_75002_c;


   public ComponentStrongholdChestCorridor(int p_i3840_1_, Random p_i3840_2_, StructureBoundingBox p_i3840_3_, int p_i3840_4_) {
      super(p_i3840_1_);
      this.field_74885_f = p_i3840_4_;
      this.field_75001_b = this.func_74988_a(p_i3840_2_);
      this.field_74887_e = p_i3840_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
   }

   public static ComponentStrongholdChestCorridor func_75000_a(List p_75000_0_, Random p_75000_1_, int p_75000_2_, int p_75000_3_, int p_75000_4_, int p_75000_5_, int p_75000_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75000_2_, p_75000_3_, p_75000_4_, -1, -1, 0, 5, 5, 7, p_75000_5_);
      return func_74991_a(var7) && StructureComponent.func_74883_a(p_75000_0_, var7) == null?new ComponentStrongholdChestCorridor(p_75000_6_, p_75000_1_, var7, p_75000_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_75001_b, 1, 1, 0);
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.OPENING, 1, 1, 6);
         this.func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 1, 4, Block.field_72007_bm.field_71990_ca, Block.field_72007_bm.field_71990_ca, false);
         this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 1, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 1, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 2, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 2, 4, p_74875_3_);

         int var4;
         for(var4 = 2; var4 <= 4; ++var4) {
            this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 2, 1, var4, p_74875_3_);
         }

         if(!this.field_75002_c) {
            var4 = this.func_74862_a(2);
            int var5 = this.func_74865_a(3, 3);
            int var6 = this.func_74873_b(3, 3);
            if(p_74875_3_.func_78890_b(var5, var4, var6)) {
               this.field_75002_c = true;
               this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, WeightedRandomChestContent.func_92080_a(field_75003_a, new WeightedRandomChestContent[]{Item.field_92105_bW.func_92114_b(p_74875_2_)}), 2 + p_74875_2_.nextInt(2));
            }
         }

         return true;
      }
   }

}
