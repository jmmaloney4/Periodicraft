package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageField extends ComponentVillage {

   private int field_74901_a = -1;
   private int field_82679_b;
   private int field_82680_c;
   private int field_82678_d;
   private int field_82681_h;


   public ComponentVillageField(ComponentVillageStartPiece p_i3861_1_, int p_i3861_2_, Random p_i3861_3_, StructureBoundingBox p_i3861_4_, int p_i3861_5_) {
      super(p_i3861_1_, p_i3861_2_);
      this.field_74885_f = p_i3861_5_;
      this.field_74887_e = p_i3861_4_;
      this.field_82679_b = this.func_82677_a(p_i3861_3_);
      this.field_82680_c = this.func_82677_a(p_i3861_3_);
      this.field_82678_d = this.func_82677_a(p_i3861_3_);
      this.field_82681_h = this.func_82677_a(p_i3861_3_);
   }

   private int func_82677_a(Random p_82677_1_) {
      switch(p_82677_1_.nextInt(5)) {
      case 0:
         return Block.field_82513_cg.field_71990_ca;
      case 1:
         return Block.field_82514_ch.field_71990_ca;
      default:
         return Block.field_72058_az.field_71990_ca;
      }
   }

   public static ComponentVillageField func_74900_a(ComponentVillageStartPiece p_74900_0_, List p_74900_1_, Random p_74900_2_, int p_74900_3_, int p_74900_4_, int p_74900_5_, int p_74900_6_, int p_74900_7_) {
      StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74900_3_, p_74900_4_, p_74900_5_, 0, 0, 0, 13, 4, 9, p_74900_6_);
      return func_74895_a(var8) && StructureComponent.func_74883_a(p_74900_1_, var8) == null?new ComponentVillageField(p_74900_0_, p_74900_7_, p_74900_2_, var8, p_74900_6_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74901_a < 0) {
         this.field_74901_a = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74901_a < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74901_a - this.field_74887_e.field_78894_e + 4 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 12, 4, 8, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Block.field_72050_aA.field_71990_ca, Block.field_72050_aA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Block.field_72050_aA.field_71990_ca, Block.field_72050_aA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 0, 1, 8, 0, 7, Block.field_72050_aA.field_71990_ca, Block.field_72050_aA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 10, 0, 1, 11, 0, 7, Block.field_72050_aA.field_71990_ca, Block.field_72050_aA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 12, 0, 0, 12, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 11, 0, 0, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 8, 11, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Block.field_71942_A.field_71990_ca, Block.field_71942_A.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 9, 0, 1, 9, 0, 7, Block.field_71942_A.field_71990_ca, Block.field_71942_A.field_71990_ca, false);

      int var4;
      for(var4 = 1; var4 <= 7; ++var4) {
         this.func_74864_a(p_74875_1_, this.field_82679_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 1, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82679_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 2, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82680_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 4, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82680_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 5, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82678_d, MathHelper.func_76136_a(p_74875_2_, 2, 7), 7, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82678_d, MathHelper.func_76136_a(p_74875_2_, 2, 7), 8, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82681_h, MathHelper.func_76136_a(p_74875_2_, 2, 7), 10, 1, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, this.field_82681_h, MathHelper.func_76136_a(p_74875_2_, 2, 7), 11, 1, var4, p_74875_3_);
      }

      for(var4 = 0; var4 < 9; ++var4) {
         for(int var5 = 0; var5 < 13; ++var5) {
            this.func_74871_b(p_74875_1_, var5, 4, var4, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_71979_v.field_71990_ca, 0, var5, -1, var4, p_74875_3_);
         }
      }

      return true;
   }
}
