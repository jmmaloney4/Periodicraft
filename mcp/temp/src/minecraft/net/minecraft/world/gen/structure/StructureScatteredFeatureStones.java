package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces2;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;

class StructureScatteredFeatureStones extends StructurePieceBlockSelector {

   private StructureScatteredFeatureStones() {}

   public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_) {
      if(p_75062_1_.nextFloat() < 0.4F) {
         this.field_75066_a = Block.field_71978_w.field_71990_ca;
      } else {
         this.field_75066_a = Block.field_72087_ao.field_71990_ca;
      }

   }

   // $FF: synthetic method
   StructureScatteredFeatureStones(ComponentScatteredFeaturePieces2 p_i3834_1_) {
      this();
   }
}
