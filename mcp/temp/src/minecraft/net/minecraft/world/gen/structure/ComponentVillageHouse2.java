package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageHouse2 extends ComponentVillage {

   public static final WeightedRandomChestContent[] field_74918_a = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 3, 3), new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 1, 3, 5), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77696_g.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77716_q.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77822_ae.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77812_ad.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77824_af.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77818_ag.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Block.field_72089_ap.field_71990_ca, 0, 3, 7, 5), new WeightedRandomChestContent(Block.field_71987_y.field_71990_ca, 0, 3, 7, 5)};
   private int field_74916_b = -1;
   private boolean field_74917_c;


   public ComponentVillageHouse2(ComponentVillageStartPiece p_i3869_1_, int p_i3869_2_, Random p_i3869_3_, StructureBoundingBox p_i3869_4_, int p_i3869_5_) {
      super(p_i3869_1_, p_i3869_2_);
      this.field_74885_f = p_i3869_5_;
      this.field_74887_e = p_i3869_4_;
   }

   public static ComponentVillageHouse2 func_74915_a(ComponentVillageStartPiece p_74915_0_, List p_74915_1_, Random p_74915_2_, int p_74915_3_, int p_74915_4_, int p_74915_5_, int p_74915_6_, int p_74915_7_) {
      StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74915_3_, p_74915_4_, p_74915_5_, 0, 0, 0, 10, 6, 7, p_74915_6_);
      return func_74895_a(var8) && StructureComponent.func_74883_a(p_74915_1_, var8) == null?new ComponentVillageHouse2(p_74915_0_, p_74915_7_, p_74915_2_, var8, p_74915_6_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74916_b < 0) {
         this.field_74916_b = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74916_b < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74916_b - this.field_74887_e.field_78894_e + 6 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 9, 4, 6, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 0, 6, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 0, 9, 4, 6, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 9, 5, 6, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 8, 5, 5, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 4, 0, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 4, 0, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 6, 0, 4, 6, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 3, 3, 1, p_74875_3_);
      this.func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 3, 2, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 3, 5, 3, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 6, 5, 3, 6, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 1, 0, 5, 3, 0, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 9, 1, 0, 9, 3, 0, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 1, 4, 9, 4, 6, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_71944_C.field_71990_ca, 0, 7, 1, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71944_C.field_71990_ca, 0, 8, 1, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72002_bp.field_71990_ca, 0, 9, 2, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72002_bp.field_71990_ca, 0, 9, 2, 4, p_74875_3_);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 2, 4, 8, 2, 5, 0, 0, false);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 6, 1, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72051_aB.field_71990_ca, 0, 6, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72051_aB.field_71990_ca, 0, 6, 3, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72085_aj.field_71990_ca, 0, 8, 1, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 2, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 2, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, 2, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 1, 1, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, this.func_74863_c(Block.field_72063_at.field_71990_ca, 3), 2, 1, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, this.func_74863_c(Block.field_72063_at.field_71990_ca, 1), 1, 1, 4, p_74875_3_);
      int var4;
      int var5;
      if(!this.field_74917_c) {
         var4 = this.func_74862_a(1);
         var5 = this.func_74865_a(5, 5);
         int var6 = this.func_74873_b(5, 5);
         if(p_74875_3_.func_78890_b(var5, var4, var6)) {
            this.field_74917_c = true;
            this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 5, 1, 5, field_74918_a, 3 + p_74875_2_.nextInt(6));
         }
      }

      for(var4 = 6; var4 <= 8; ++var4) {
         if(this.func_74866_a(p_74875_1_, var4, 0, -1, p_74875_3_) == 0 && this.func_74866_a(p_74875_1_, var4, -1, -1, p_74875_3_) != 0) {
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), var4, 0, -1, p_74875_3_);
         }
      }

      for(var4 = 0; var4 < 7; ++var4) {
         for(var5 = 0; var5 < 10; ++var5) {
            this.func_74871_b(p_74875_1_, var5, 6, var4, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var5, -1, var4, p_74875_3_);
         }
      }

      this.func_74893_a(p_74875_1_, p_74875_3_, 7, 1, 1, 1);
      return true;
   }

   protected int func_74888_b(int p_74888_1_) {
      return 3;
   }

}
