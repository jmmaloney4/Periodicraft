package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageHouse4_Garden extends ComponentVillage {

   private int field_74914_a = -1;
   private final boolean field_74913_b;


   public ComponentVillageHouse4_Garden(ComponentVillageStartPiece p_i3866_1_, int p_i3866_2_, Random p_i3866_3_, StructureBoundingBox p_i3866_4_, int p_i3866_5_) {
      super(p_i3866_1_, p_i3866_2_);
      this.field_74885_f = p_i3866_5_;
      this.field_74887_e = p_i3866_4_;
      this.field_74913_b = p_i3866_3_.nextBoolean();
   }

   public static ComponentVillageHouse4_Garden func_74912_a(ComponentVillageStartPiece p_74912_0_, List p_74912_1_, Random p_74912_2_, int p_74912_3_, int p_74912_4_, int p_74912_5_, int p_74912_6_, int p_74912_7_) {
      StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74912_3_, p_74912_4_, p_74912_5_, 0, 0, 0, 5, 6, 5, p_74912_6_);
      return StructureComponent.func_74883_a(p_74912_1_, var8) != null?null:new ComponentVillageHouse4_Garden(p_74912_0_, p_74912_7_, p_74912_2_, var8, p_74912_6_);
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74914_a < 0) {
         this.field_74914_a = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74914_a < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74914_a - this.field_74887_e.field_78894_e + 6 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 0, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 1, 3, 4, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 3, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 1, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 3, 4, p_74875_3_);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 4, 3, 3, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 2, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 1, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 1, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 1, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 2, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 3, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 3, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 3, 1, 0, p_74875_3_);
      if(this.func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && this.func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0) {
         this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 3, 0, 0, false);
      if(this.field_74913_b) {
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 0, 5, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 5, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 2, 5, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 3, 5, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 5, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 0, 5, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 5, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 2, 5, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 3, 5, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 5, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 5, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 5, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 5, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 0, 5, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 0, 5, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 0, 5, 3, p_74875_3_);
      }

      int var4;
      if(this.field_74913_b) {
         var4 = this.func_74863_c(Block.field_72055_aF.field_71990_ca, 3);
         this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var4, 3, 1, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var4, 3, 2, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var4, 3, 3, 3, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var4, 3, 4, 3, p_74875_3_);
      }

      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, 1, p_74875_3_);

      for(var4 = 0; var4 < 5; ++var4) {
         for(int var5 = 0; var5 < 5; ++var5) {
            this.func_74871_b(p_74875_1_, var5, 6, var4, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, var5, -1, var4, p_74875_3_);
         }
      }

      this.func_74893_a(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
      return true;
   }
}
