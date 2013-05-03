package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageHouse1 extends ComponentVillage {

   private int field_74899_a = -1;


   public ComponentVillageHouse1(ComponentVillageStartPiece p_i3860_1_, int p_i3860_2_, Random p_i3860_3_, StructureBoundingBox p_i3860_4_, int p_i3860_5_) {
      super(p_i3860_1_, p_i3860_2_);
      this.field_74885_f = p_i3860_5_;
      this.field_74887_e = p_i3860_4_;
   }

   public static ComponentVillageHouse1 func_74898_a(ComponentVillageStartPiece p_74898_0_, List p_74898_1_, Random p_74898_2_, int p_74898_3_, int p_74898_4_, int p_74898_5_, int p_74898_6_, int p_74898_7_) {
      StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74898_3_, p_74898_4_, p_74898_5_, 0, 0, 0, 9, 9, 6, p_74898_6_);
      return func_74895_a(var8) && StructureComponent.func_74883_a(p_74898_1_, var8) == null?new ComponentVillageHouse1(p_74898_0_, p_74898_7_, p_74898_2_, var8, p_74898_6_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74899_a < 0) {
         this.field_74899_a = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74899_a < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74899_a - this.field_74887_e.field_78894_e + 9 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 5, 4, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 0, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 8, 5, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 1, 8, 6, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 7, 2, 8, 7, 3, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      int var4 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 3);
      int var5 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 2);

      int var6;
      int var7;
      for(var6 = -1; var6 <= 2; ++var6) {
         for(var7 = 0; var7 <= 8; ++var7) {
            this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var4, var7, 6 + var6, var6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var5, var7, 6 + var6, 5 - var6, p_74875_3_);
         }
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 5, 8, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 1, 0, 8, 1, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 0, 7, 1, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 4, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 4, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 2, 5, 8, 4, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 2, 0, 8, 4, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 4, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 2, 1, 8, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 4, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 3, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 3, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 3, 2, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 2, 5, p_74875_3_);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 1, 7, 4, 1, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 4, 7, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 4, 7, 3, 4, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 7, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, this.func_74863_c(Block.field_72063_at.field_71990_ca, 0), 7, 1, 3, p_74875_3_);
      var6 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 3);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var6, 6, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var6, 5, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var6, 4, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var6, 3, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 6, 1, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, 6, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 1, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, 4, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72060_ay.field_71990_ca, 0, 7, 1, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 1, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 1, 2, 0, p_74875_3_);
      this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, this.func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
      if(this.func_74866_a(p_74875_1_, 1, 0, -1, p_74875_3_) == 0 && this.func_74866_a(p_74875_1_, 1, -1, -1, p_74875_3_) != 0) {
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 1, 0, -1, p_74875_3_);
      }

      for(var7 = 0; var7 < 6; ++var7) {
         for(int var8 = 0; var8 < 9; ++var8) {
            this.func_74871_b(p_74875_1_, var8, 9, var7, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var8, -1, var7, p_74875_3_);
         }
      }

      this.func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
      return true;
   }

   protected int func_74888_b(int p_74888_1_) {
      return 1;
   }
}
