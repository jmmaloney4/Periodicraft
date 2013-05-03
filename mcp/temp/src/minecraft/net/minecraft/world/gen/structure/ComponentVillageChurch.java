package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageChurch extends ComponentVillage {

   private int field_74920_a = -1;


   public ComponentVillageChurch(ComponentVillageStartPiece p_i3868_1_, int p_i3868_2_, Random p_i3868_3_, StructureBoundingBox p_i3868_4_, int p_i3868_5_) {
      super(p_i3868_1_, p_i3868_2_);
      this.field_74885_f = p_i3868_5_;
      this.field_74887_e = p_i3868_4_;
   }

   public static ComponentVillageChurch func_74919_a(ComponentVillageStartPiece p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_) {
      StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 5, 12, 9, p_74919_6_);
      return func_74895_a(var8) && StructureComponent.func_74883_a(p_74919_1_, var8) == null?new ComponentVillageChurch(p_74919_0_, p_74919_7_, p_74919_2_, var8, p_74919_6_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74920_a < 0) {
         this.field_74920_a = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74920_a < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74920_a - this.field_74887_e.field_78894_e + 12 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 7, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 9, 3, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 3, 0, 8, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 0, 3, 10, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 10, 3, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 10, 3, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 4, 0, 4, 7, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 4, 4, 4, 7, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 8, 3, 4, 8, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 4, 3, 10, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 5, 3, 5, 7, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 9, 0, 4, 9, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 11, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 11, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 2, 11, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 2, 11, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 1, 1, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 1, 1, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 2, 1, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 3, 1, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 3, 1, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 1, 1, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 1, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 3, 1, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 1), 1, 2, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 0), 3, 2, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 3, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 6, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 7, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 6, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 7, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 6, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 7, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 6, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 7, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 3, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 3, 8, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 4, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 1, 4, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 3, 4, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 4, 5, p_74875_3_);
      int var4 = this.func_74863_c(Block.field_72055_aF.field_71990_ca, 4);

      int var5;
      for(var5 = 1; var5 <= 9; ++var5) {
         this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var4, 3, var5, 3, p_74875_3_);
      }

      this.func_74864_a(p_74875_1_, 0, 0, 2, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 2, 2, 0, p_74875_3_);
      this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
      if(this.func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && this.func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0) {
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
      }

      for(var5 = 0; var5 < 9; ++var5) {
         for(int var6 = 0; var6 < 5; ++var6) {
            this.func_74871_b(p_74875_1_, var6, 12, var5, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var6, -1, var5, p_74875_3_);
         }
      }

      this.func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
      return true;
   }

   protected int func_74888_b(int p_74888_1_) {
      return 2;
   }
}
