package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeStraight extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeStraight(int p_i3816_1_, Random p_i3816_2_, StructureBoundingBox p_i3816_3_, int p_i3816_4_) {
      super(p_i3816_1_);
      this.field_74885_f = p_i3816_4_;
      this.field_74887_e = p_i3816_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 1, 3, false);
   }

   public static ComponentNetherBridgeStraight func_74983_a(List p_74983_0_, Random p_74983_1_, int p_74983_2_, int p_74983_3_, int p_74983_4_, int p_74983_5_, int p_74983_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74983_2_, p_74983_3_, p_74983_4_, -1, -3, 0, 5, 10, 19, p_74983_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74983_0_, var7) == null?new ComponentNetherBridgeStraight(p_74983_6_, p_74983_1_, var7, p_74983_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 0, 4, 4, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 0, 3, 7, 18, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 2, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 13, 4, 2, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 15, 4, 1, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

      for(int var4 = 0; var4 <= 4; ++var4) {
         for(int var5 = 0; var5 <= 2; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, 18 - var5, p_74875_3_);
         }
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 4, 1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 4, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 14, 0, 4, 14, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 17, 0, 4, 17, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 4, 1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 4, 4, 4, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 14, 4, 4, 14, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 17, 4, 4, 17, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      return true;
   }
}
