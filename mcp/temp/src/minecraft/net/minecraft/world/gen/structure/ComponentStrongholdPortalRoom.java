package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdPortalRoom extends ComponentStronghold {

   private boolean field_75005_a;


   public ComponentStrongholdPortalRoom(int p_i3846_1_, Random p_i3846_2_, StructureBoundingBox p_i3846_3_, int p_i3846_4_) {
      super(p_i3846_1_);
      this.field_74885_f = p_i3846_4_;
      this.field_74887_e = p_i3846_3_;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      if(p_74861_1_ != null) {
         ((ComponentStrongholdStairs2)p_74861_1_).field_75025_b = this;
      }

   }

   public static ComponentStrongholdPortalRoom func_75004_a(List p_75004_0_, Random p_75004_1_, int p_75004_2_, int p_75004_3_, int p_75004_4_, int p_75004_5_, int p_75004_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75004_2_, p_75004_3_, p_75004_4_, -4, -1, 0, 11, 8, 16, p_75004_5_);
      return func_74991_a(var7) && StructureComponent.func_74883_a(p_75004_0_, var7) == null?new ComponentStrongholdPortalRoom(p_75004_6_, p_75004_1_, var7, p_75004_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.GRATES, 4, 1, 0);
      byte var4 = 6;
      this.func_74882_a(p_74875_1_, p_74875_3_, 1, var4, 1, 1, var4, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 9, var4, 1, 9, var4, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 2, var4, 1, 8, var4, 2, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 2, var4, 14, 8, var4, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
      this.func_74884_a(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
      this.func_74882_a(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);

      int var5;
      for(var5 = 3; var5 < 14; var5 += 2) {
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, var5, 0, 4, var5, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 10, 3, var5, 10, 4, var5, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
      }

      for(var5 = 2; var5 < 9; var5 += 2) {
         this.func_74884_a(p_74875_1_, p_74875_3_, var5, 3, 15, var5, 4, 15, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
      }

      var5 = this.func_74863_c(Block.field_71995_bx.field_71990_ca, 3);
      this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
      this.func_74882_a(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());

      for(int var6 = 4; var6 <= 6; ++var6) {
         this.func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, var5, var6, 1, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, var5, var6, 2, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, var5, var6, 3, 6, p_74875_3_);
      }

      byte var14 = 2;
      byte var7 = 0;
      byte var8 = 3;
      byte var9 = 1;
      switch(this.field_74885_f) {
      case 0:
         var14 = 0;
         var7 = 2;
         break;
      case 1:
         var14 = 1;
         var7 = 3;
         var8 = 0;
         var9 = 2;
      case 2:
      default:
         break;
      case 3:
         var14 = 3;
         var7 = 1;
         var8 = 0;
         var9 = 2;
      }

      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var14 + (p_74875_2_.nextFloat() > 0.9F?4:0), 4, 3, 8, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var14 + (p_74875_2_.nextFloat() > 0.9F?4:0), 5, 3, 8, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var14 + (p_74875_2_.nextFloat() > 0.9F?4:0), 6, 3, 8, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var7 + (p_74875_2_.nextFloat() > 0.9F?4:0), 4, 3, 12, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var7 + (p_74875_2_.nextFloat() > 0.9F?4:0), 5, 3, 12, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var7 + (p_74875_2_.nextFloat() > 0.9F?4:0), 6, 3, 12, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var8 + (p_74875_2_.nextFloat() > 0.9F?4:0), 3, 3, 9, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var8 + (p_74875_2_.nextFloat() > 0.9F?4:0), 3, 3, 10, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var8 + (p_74875_2_.nextFloat() > 0.9F?4:0), 3, 3, 11, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var9 + (p_74875_2_.nextFloat() > 0.9F?4:0), 7, 3, 9, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var9 + (p_74875_2_.nextFloat() > 0.9F?4:0), 7, 3, 10, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, var9 + (p_74875_2_.nextFloat() > 0.9F?4:0), 7, 3, 11, p_74875_3_);
      if(!this.field_75005_a) {
         int var13 = this.func_74862_a(3);
         int var10 = this.func_74865_a(5, 6);
         int var11 = this.func_74873_b(5, 6);
         if(p_74875_3_.func_78890_b(var10, var13, var11)) {
            this.field_75005_a = true;
            p_74875_1_.func_72832_d(var10, var13, var11, Block.field_72065_as.field_71990_ca, 0, 2);
            TileEntityMobSpawner var12 = (TileEntityMobSpawner)p_74875_1_.func_72796_p(var10, var13, var11);
            if(var12 != null) {
               var12.func_98049_a().func_98272_a("Silverfish");
            }
         }
      }

      return true;
   }
}
