package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeEntrance extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeEntrance(int p_i3819_1_, Random p_i3819_2_, StructureBoundingBox p_i3819_3_, int p_i3819_4_) {
      super(p_i3819_1_);
      this.field_74885_f = p_i3819_4_;
      this.field_74887_e = p_i3819_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
   }

   public static ComponentNetherBridgeEntrance func_74984_a(List p_74984_0_, Random p_74984_1_, int p_74984_2_, int p_74984_3_, int p_74984_4_, int p_74984_5_, int p_74984_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74984_2_, p_74984_3_, p_74984_4_, -5, -3, 0, 13, 14, 13, p_74984_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74984_0_, var7) == null?new ComponentNetherBridgeEntrance(p_74984_6_, p_74984_1_, var7, p_74984_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 8, 0, 7, 8, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);

      int var4;
      for(var4 = 1; var4 <= 11; var4 += 2) {
         this.func_74884_a(p_74875_1_, p_74875_3_, var4, 10, 0, var4, 11, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, var4, 10, 12, var4, 11, 12, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, 10, var4, 0, 11, var4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 12, 10, var4, 12, 11, var4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
         this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, 13, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, 13, 12, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 0, 13, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12, 13, var4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, var4 + 1, 13, 0, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, var4 + 1, 13, 12, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, var4 + 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 12, 13, var4 + 1, p_74875_3_);
      }

      this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 12, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 12, 13, 0, p_74875_3_);

      for(var4 = 3; var4 <= 9; var4 += 2) {
         this.func_74884_a(p_74875_1_, p_74875_3_, 1, 7, var4, 1, 8, var4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 11, 7, var4, 11, 8, var4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

      int var5;
      for(var4 = 4; var4 <= 8; ++var4) {
         for(var5 = 0; var5 <= 2; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, 12 - var5, p_74875_3_);
         }
      }

      for(var4 = 0; var4 <= 2; ++var4) {
         for(var5 = 4; var5 <= 8; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12 - var4, -1, var5, p_74875_3_);
         }
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 5, 5, 7, 5, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 1, 6, 6, 4, 6, 0, 0, false);
      this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 6, 0, 6, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_71944_C.field_71990_ca, 0, 6, 5, 6, p_74875_3_);
      var4 = this.func_74865_a(6, 6);
      var5 = this.func_74862_a(5);
      int var6 = this.func_74873_b(6, 6);
      if(p_74875_3_.func_78890_b(var4, var5, var6)) {
         p_74875_1_.field_72999_e = true;
         Block.field_71973_m[Block.field_71944_C.field_71990_ca].func_71847_b(p_74875_1_, var4, var5, var6, p_74875_2_);
         p_74875_1_.field_72999_e = false;
      }

      return true;
   }
}
