package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeCorridor3 extends ComponentNetherBridgePiece {

   public ComponentNetherBridgeCorridor3(int p_i3817_1_, Random p_i3817_2_, StructureBoundingBox p_i3817_3_, int p_i3817_4_) {
      super(p_i3817_1_);
      this.field_74885_f = p_i3817_4_;
      this.field_74887_e = p_i3817_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
   }

   public static ComponentNetherBridgeCorridor3 func_74982_a(List p_74982_0_, Random p_74982_1_, int p_74982_2_, int p_74982_3_, int p_74982_4_, int p_74982_5_, int p_74982_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74982_2_, p_74982_3_, p_74982_4_, -1, -7, 0, 5, 14, 10, p_74982_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74982_0_, var7) == null?new ComponentNetherBridgeCorridor3(p_74982_6_, p_74982_1_, var7, p_74982_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      int var4 = this.func_74863_c(Block.field_72100_bC.field_71990_ca, 2);

      for(int var5 = 0; var5 <= 9; ++var5) {
         int var6 = Math.max(1, 7 - var5);
         int var7 = Math.min(Math.max(var6 + 5, 14 - var5), 13);
         int var8 = var5;
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, var5, 4, var6, var5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 1, var6 + 1, var5, 3, var7 - 1, var5, 0, 0, false);
         if(var5 <= 6) {
            this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, var4, 1, var6 + 1, var5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, var4, 2, var6 + 1, var5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, var4, 3, var6 + 1, var5, p_74875_3_);
         }

         this.func_74884_a(p_74875_1_, p_74875_3_, 0, var7, var5, 4, var7, var5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, var6 + 1, var5, 0, var7 - 1, var5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 4, var6 + 1, var5, 4, var7 - 1, var5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
         if((var5 & 1) == 0) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, var6 + 2, var5, 0, var6 + 3, var5, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, var6 + 2, var5, 4, var6 + 3, var5, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
         }

         for(int var9 = 0; var9 <= 4; ++var9) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var9, -1, var8, p_74875_3_);
         }
      }

      return true;
   }
}
