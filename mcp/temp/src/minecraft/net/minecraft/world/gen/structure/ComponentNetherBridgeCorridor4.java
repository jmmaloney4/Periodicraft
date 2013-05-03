package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCorridor4 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCorridor4(int p_i3818_1_, Random p_i3818_2_, StructureBoundingBox p_i3818_3_, int p_i3818_4_) {
      super(p_i3818_1_);
      this.field_74885_f = p_i3818_4_;
      this.field_74887_e = p_i3818_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      byte var4 = 1;
      if(this.field_74885_f == 1 || this.field_74885_f == 2) {
         var4 = 5;
      }

      this.func_74961_b((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, var4, p_74861_3_.nextInt(8) > 0);
      this.func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, var4, p_74861_3_.nextInt(8) > 0);
   }

   public static ComponentNetherBridgeCorridor4 func_74985_a(List p_74985_0_, Random p_74985_1_, int p_74985_2_, int p_74985_3_, int p_74985_4_, int p_74985_5_, int p_74985_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74985_2_, p_74985_3_, p_74985_4_, -3, 0, 0, 9, 7, 9, p_74985_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74985_0_, var7) == null?new ComponentNetherBridgeCorridor4(p_74985_6_, p_74985_1_, var7, p_74985_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 8, 5, 8, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 0, 8, 6, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 2, 5, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 0, 8, 5, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 0, 1, 4, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 3, 0, 7, 4, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 8, 2, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 2, 4, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 1, 4, 7, 2, 4, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 8, 8, 3, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 6, 0, 3, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 3, 6, 8, 3, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 3, 4, 8, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 5, 2, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 3, 5, 7, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 5, 1, 5, 5, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 4, 5, 7, 5, 5, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);

      for(int var4 = 0; var4 <= 5; ++var4) {
         for(int var5 = 0; var5 <= 8; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var5, -1, var4, p_74875_3_);
         }
      }

      return true;
   }
}
