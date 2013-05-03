package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCrossing3 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCrossing3(int p_i3813_1_, Random p_i3813_2_, StructureBoundingBox p_i3813_3_, int p_i3813_4_) {
      super(p_i3813_1_);
      this.field_74885_f = p_i3813_4_;
      this.field_74887_e = p_i3813_3_;
   }

   protected ComponentNetherBridgeCrossing3(Random p_i3814_1_, int p_i3814_2_, int p_i3814_3_) {
      super(0);
      this.field_74885_f = p_i3814_1_.nextInt(4);
      switch(this.field_74885_f) {
      case 0:
      case 2:
         this.field_74887_e = new StructureBoundingBox(p_i3814_2_, 64, p_i3814_3_, p_i3814_2_ + 19 - 1, 73, p_i3814_3_ + 19 - 1);
         break;
      default:
         this.field_74887_e = new StructureBoundingBox(p_i3814_2_, 64, p_i3814_3_, p_i3814_2_ + 19 - 1, 73, p_i3814_3_ + 19 - 1);
      }

   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 8, 3, false);
      this.func_74961_b((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
      this.func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
   }

   public static ComponentNetherBridgeCrossing3 func_74966_a(List p_74966_0_, Random p_74966_1_, int p_74966_2_, int p_74966_3_, int p_74966_4_, int p_74966_5_, int p_74966_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74966_2_, p_74966_3_, p_74966_4_, -8, -3, 0, 19, 10, 19, p_74966_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74966_0_, var7) == null?new ComponentNetherBridgeCrossing3(p_74966_6_, p_74966_1_, var7, p_74966_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 3, 0, 11, 4, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 7, 18, 4, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 7, 18, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 8, 18, 7, 10, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 5, 0, 7, 5, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 5, 11, 7, 5, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 0, 11, 5, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 11, 11, 5, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 7, 7, 5, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 7, 18, 5, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 11, 7, 5, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 11, 18, 5, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 2, 0, 11, 2, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 2, 13, 11, 2, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 0, 0, 11, 1, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 7, 0, 15, 11, 1, 18, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

      int var4;
      int var5;
      for(var4 = 7; var4 <= 11; ++var4) {
         for(var5 = 0; var5 <= 2; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, 18 - var5, p_74875_3_);
         }
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 7, 5, 2, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 13, 2, 7, 18, 2, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 7, 3, 1, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 15, 0, 7, 18, 1, 11, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

      for(var4 = 0; var4 <= 2; ++var4) {
         for(var5 = 7; var5 <= 11; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 18 - var4, -1, var5, p_74875_3_);
         }
      }

      return true;
   }
}
