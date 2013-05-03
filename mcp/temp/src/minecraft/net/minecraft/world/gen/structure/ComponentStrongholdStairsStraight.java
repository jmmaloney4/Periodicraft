package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdStairsStraight extends ComponentStronghold {

   private final EnumDoor field_75029_a;


   public ComponentStrongholdStairsStraight(int p_i3854_1_, Random p_i3854_2_, StructureBoundingBox p_i3854_3_, int p_i3854_4_) {
      super(p_i3854_1_);
      this.field_74885_f = p_i3854_4_;
      this.field_75029_a = this.func_74988_a(p_i3854_2_);
      this.field_74887_e = p_i3854_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
   }

   public static ComponentStrongholdStairsStraight func_75028_a(List p_75028_0_, Random p_75028_1_, int p_75028_2_, int p_75028_3_, int p_75028_4_, int p_75028_5_, int p_75028_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75028_2_, p_75028_3_, p_75028_4_, -1, -7, 0, 5, 11, 8, p_75028_5_);
      return func_74991_a(var7) && StructureComponent.func_74883_a(p_75028_0_, var7) == null?new ComponentStrongholdStairsStraight(p_75028_6_, p_75028_1_, var7, p_75028_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_75029_a, 1, 7, 0);
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.OPENING, 1, 1, 7);
         int var4 = this.func_74863_c(Block.field_72057_aH.field_71990_ca, 2);

         for(int var5 = 0; var5 < 6; ++var5) {
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 1, 6 - var5, 1 + var5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 2, 6 - var5, 1 + var5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, var4, 3, 6 - var5, 1 + var5, p_74875_3_);
            if(var5 < 5) {
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 5 - var5, 1 + var5, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 5 - var5, 1 + var5, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 5 - var5, 1 + var5, p_74875_3_);
            }
         }

         return true;
      }
   }
}
