package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCrossing extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCrossing(int p_i3829_1_, Random p_i3829_2_, StructureBoundingBox p_i3829_3_, int p_i3829_4_) {
      super(p_i3829_1_);
      this.field_74885_f = p_i3829_4_;
      this.field_74887_e = p_i3829_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 2, 0, false);
      this.func_74961_b((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
      this.func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
   }

   public static ComponentNetherBridgeCrossing func_74974_a(List p_74974_0_, Random p_74974_1_, int p_74974_2_, int p_74974_3_, int p_74974_4_, int p_74974_5_, int p_74974_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74974_2_, p_74974_3_, p_74974_4_, -2, 0, 0, 7, 9, 7, p_74974_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74974_0_, var7) == null?new ComponentNetherBridgeCrossing(p_74974_6_, p_74974_1_, var7, p_74974_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 6, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 6, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 6, 1, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 6, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 6, 6, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 6, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 0, 6, 6, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 5, 6, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 6, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 6, 6, 4, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 6, 4, 5, 6, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 2, 0, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 2, 0, 5, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 6, 2, 6, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 2, 6, 5, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);

      for(int var4 = 0; var4 <= 6; ++var4) {
         for(int var5 = 0; var5 <= 6; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
         }
      }

      return true;
   }
}
