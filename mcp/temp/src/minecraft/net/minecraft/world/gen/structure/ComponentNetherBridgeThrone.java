package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeThrone extends ComponentNetherBridgePiece {

   private boolean field_74976_a;


   public ComponentNetherBridgeThrone(int p_i3825_1_, Random p_i3825_2_, StructureBoundingBox p_i3825_3_, int p_i3825_4_) {
      super(p_i3825_1_);
      this.field_74885_f = p_i3825_4_;
      this.field_74887_e = p_i3825_3_;
   }

   public static ComponentNetherBridgeThrone func_74975_a(List p_74975_0_, Random p_74975_1_, int p_74975_2_, int p_74975_3_, int p_74975_4_, int p_74975_5_, int p_74975_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74975_2_, p_74975_3_, p_74975_4_, -2, 0, 0, 7, 8, 9, p_74975_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74975_0_, var7) == null?new ComponentNetherBridgeThrone(p_74975_6_, p_74975_1_, var7, p_74975_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 7, 0, 0, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 1, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 1, 5, 2, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 2, 5, 3, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 3, 5, 4, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 1, 4, 2, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 0, 5, 4, 2, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 2, 1, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 5, 5, 2, 5, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 3, 0, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 3, 6, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 8, 5, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 1, 6, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 5, 6, 3, p_74875_3_);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 3, 0, 6, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 6, 6, 3, 6, 6, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 6, 8, 5, 7, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 2, 8, 8, 4, 8, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
      int var4;
      int var5;
      if(!this.field_74976_a) {
         var4 = this.func_74862_a(5);
         var5 = this.func_74865_a(3, 5);
         int var6 = this.func_74873_b(3, 5);
         if(p_74875_3_.func_78890_b(var5, var4, var6)) {
            this.field_74976_a = true;
            p_74875_1_.func_72832_d(var5, var4, var6, Block.field_72065_as.field_71990_ca, 0, 2);
            TileEntityMobSpawner var7 = (TileEntityMobSpawner)p_74875_1_.func_72796_p(var5, var4, var6);
            if(var7 != null) {
               var7.func_98049_a().func_98272_a("Blaze");
            }
         }
      }

      for(var4 = 0; var4 <= 6; ++var4) {
         for(var5 = 0; var5 <= 6; ++var5) {
            this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, var4, -1, var5, p_74875_3_);
         }
      }

      return true;
   }
}
