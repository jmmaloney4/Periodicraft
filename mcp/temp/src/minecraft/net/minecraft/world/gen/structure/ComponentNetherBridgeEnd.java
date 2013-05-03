package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentNetherBridgeEnd extends ComponentNetherBridgePiece {

   private int field_74972_a;


   public ComponentNetherBridgeEnd(int p_i3815_1_, Random p_i3815_2_, StructureBoundingBox p_i3815_3_, int p_i3815_4_) {
      super(p_i3815_1_);
      this.field_74885_f = p_i3815_4_;
      this.field_74887_e = p_i3815_3_;
      this.field_74972_a = p_i3815_2_.nextInt();
   }

   public static ComponentNetherBridgeEnd func_74971_a(List p_74971_0_, Random p_74971_1_, int p_74971_2_, int p_74971_3_, int p_74971_4_, int p_74971_5_, int p_74971_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74971_2_, p_74971_3_, p_74971_4_, -1, -3, 0, 5, 10, 8, p_74971_5_);
      return func_74964_a(var7) && StructureComponent.func_74883_a(p_74971_0_, var7) == null?new ComponentNetherBridgeEnd(p_74971_6_, p_74971_1_, var7, p_74971_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      Random var4 = new Random((long)this.field_74972_a);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 <= 4; ++var5) {
         for(var6 = 3; var6 <= 4; ++var6) {
            var7 = var4.nextInt(8);
            this.func_74884_a(p_74875_1_, p_74875_3_, var5, var6, 0, var5, var6, var7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
         }
      }

      var5 = var4.nextInt(8);
      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, var5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      var5 = var4.nextInt(8);
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, var5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

      for(var5 = 0; var5 <= 4; ++var5) {
         var6 = var4.nextInt(5);
         this.func_74884_a(p_74875_1_, p_74875_3_, var5, 2, 0, var5, 2, var6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
      }

      for(var5 = 0; var5 <= 4; ++var5) {
         for(var6 = 0; var6 <= 1; ++var6) {
            var7 = var4.nextInt(3);
            this.func_74884_a(p_74875_1_, p_74875_3_, var5, var6, 0, var5, var6, var7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
         }
      }

      return true;
   }
}
