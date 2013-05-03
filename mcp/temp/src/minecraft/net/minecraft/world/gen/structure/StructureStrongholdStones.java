package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;
import net.minecraft.world.gen.structure.StructureStrongholdPieceWeight2;

class StructureStrongholdStones extends StructurePieceBlockSelector {

   private StructureStrongholdStones() {}

   public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_) {
      if(p_75062_5_) {
         this.field_75066_a = Block.field_72007_bm.field_71990_ca;
         float var6 = p_75062_1_.nextFloat();
         if(var6 < 0.2F) {
            this.field_75065_b = 2;
         } else if(var6 < 0.5F) {
            this.field_75065_b = 1;
         } else if(var6 < 0.55F) {
            this.field_75066_a = Block.field_72006_bl.field_71990_ca;
            this.field_75065_b = 2;
         } else {
            this.field_75065_b = 0;
         }
      } else {
         this.field_75066_a = 0;
         this.field_75065_b = 0;
      }

   }

   // $FF: synthetic method
   StructureStrongholdStones(StructureStrongholdPieceWeight2 p_i3849_1_) {
      this();
   }
}
