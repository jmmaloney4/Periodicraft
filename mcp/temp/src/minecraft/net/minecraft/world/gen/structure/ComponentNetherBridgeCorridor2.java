package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCorridor2 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCorridor2(int p_i3823_1_, Random p_i3823_2_, StructureBoundingBox p_i3823_3_, int p_i3823_4_) {
      super(p_i3823_1_);
      this.field_74885_f = p_i3823_4_;
      this.field_74887_e = p_i3823_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
   }

   public static ComponentNetherBridgeCorridor2 func_74980_a(List p_74980_0_, Random p_74980_1_, int p_74980_2_, int p_74980_3_, int p_74980_4_, int p_74980_5_, int p_74980_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74980_2_, p_74980_3_, p_74980_4_, -1, 0, 0, 5, 7, 5, p_74980_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74980_0_, var7) == null?new ComponentNetherBridgeCorridor2(p_74980_6_, p_74980_1_, var7, p_74980_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 4, 1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 3, 0, 4, 3, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 4, 4, 5, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 4, 1, 4, 4, Block.field_72098_bB.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 3, 3, 4, 3, 4, 4, Block.field_72098_bB.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

      for(int var4 = 0; var4 <= 4; ++var4) {
         for(int var5 = 0; var5 <= 4; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
         }
      }

      return true;
   }
}
