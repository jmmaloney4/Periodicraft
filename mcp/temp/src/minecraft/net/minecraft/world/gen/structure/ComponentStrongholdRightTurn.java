package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStrongholdLeftTurn;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdRightTurn extends ComponentStrongholdLeftTurn {

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      if(this.field_74885_f != 2 && this.field_74885_f != 3) {
         this.func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      } else {
         this.func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
      }

   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_75011_a, 1, 1, 0);
         if(this.field_74885_f != 2 && this.field_74885_f != 3) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, 0, 0, false);
         } else {
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, 0, 0, false);
         }

         return true;
      }
   }
}
