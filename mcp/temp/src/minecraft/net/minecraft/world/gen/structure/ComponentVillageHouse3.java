package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageHouse3 extends ComponentVillage {

   private int field_74922_a = -1;


   public ComponentVillageHouse3(ComponentVillageStartPiece p_i3872_1_, int p_i3872_2_, Random p_i3872_3_, StructureBoundingBox p_i3872_4_, int p_i3872_5_) {
      super(p_i3872_1_, p_i3872_2_);
      this.field_74885_f = p_i3872_5_;
      this.field_74887_e = p_i3872_4_;
   }

   public static ComponentVillageHouse3 func_74921_a(ComponentVillageStartPiece p_74921_0_, List p_74921_1_, Random p_74921_2_, int p_74921_3_, int p_74921_4_, int p_74921_5_, int p_74921_6_, int p_74921_7_) {
      StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74921_3_, p_74921_4_, p_74921_5_, 0, 0, 0, 9, 7, 12, p_74921_6_);
      return func_74895_a(var8) && StructureComponent.func_74883_a(p_74921_1_, var8) == null?new ComponentVillageHouse3(p_74921_0_, p_74921_7_, p_74921_2_, var8, p_74921_6_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74922_a < 0) {
         this.field_74922_a = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74922_a < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74922_a - this.field_74887_e.field_78894_e + 7 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 5, 8, 0, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 2, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 5, 2, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 6, 2, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 3, 0, 10, 7, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 2, 3, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 4, 3, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 4, p_74875_3_);
      int var4 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 3);
      int var5 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 2);

      int var6;
      int var7;
      for(var6 = -1; var6 <= 2; ++var6) {
         for(var7 = 0; var7 <= 8; ++var7) {
            this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var4, var7, 4 + var6, var6, p_74875_3_);
            if((var6 > -1 || var7 <= 1) && (var6 > 0 || var7 <= 3) && (var6 > 1 || var7 <= 4 || var7 >= 6)) {
               this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var5, var7, 4 + var6, 5 - var6, p_74875_3_);
            }
         }
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 3, 4, 5, 3, 4, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 4, 2, 7, 4, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 4, 4, 5, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 4, 6, 5, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 6, 3, 5, 6, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      var6 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 0);

      int var8;
      for(var7 = 4; var7 >= 1; --var7) {
         this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, var7, 2 + var7, 7 - var7, p_74875_3_);

         for(var8 = 8 - var7; var8 <= 10; ++var8) {
            this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var6, var7, 2 + var7, var8, p_74875_3_);
         }
      }

      var7 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 1);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 6, 6, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 7, 5, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var7, 6, 6, 4, p_74875_3_);

      int var9;
      for(var8 = 6; var8 <= 8; ++var8) {
         for(var9 = 5; var9 <= 10; ++var9) {
            this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, var7, var8, 12 - var8, var9, p_74875_3_);
         }
      }

      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 4, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 6, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 2, 5, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 8, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 9, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 2, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 7, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 8, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 2, 9, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 4, 4, 10, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 4, 10, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 6, 4, 10, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 5, 5, 10, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 2, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 2, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, 1, p_74875_3_);
      this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, -1, 3, 2, -1, 0, 0, false);
      if(this.func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && this.func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0) {
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
      }

      for(var8 = 0; var8 < 5; ++var8) {
         for(var9 = 0; var9 < 9; ++var9) {
            this.func_74871_b(p_74875_1_, var9, 7, var8, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var9, -1, var8, p_74875_3_);
         }
      }

      for(var8 = 5; var8 < 11; ++var8) {
         for(var9 = 2; var9 < 9; ++var9) {
            this.func_74871_b(p_74875_1_, var9, 7, var8, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var9, -1, var8, p_74875_3_);
         }
      }

      this.func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
      return true;
   }
}
