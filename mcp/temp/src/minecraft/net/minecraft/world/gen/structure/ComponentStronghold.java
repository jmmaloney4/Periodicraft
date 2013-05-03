package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.EnumDoorHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

abstract class ComponentStronghold extends StructureComponent {

   protected ComponentStronghold(int p_i3856_1_) {
      super(p_i3856_1_);
   }

   protected void func_74990_a(World p_74990_1_, Random p_74990_2_, StructureBoundingBox p_74990_3_, EnumDoor p_74990_4_, int p_74990_5_, int p_74990_6_, int p_74990_7_) {
      switch(EnumDoorHelper.field_75245_a[p_74990_4_.ordinal()]) {
      case 1:
      default:
         this.func_74884_a(p_74990_1_, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_5_ + 3 - 1, p_74990_6_ + 3 - 1, p_74990_7_, 0, 0, false);
         break;
      case 2:
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72054_aE.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72054_aE.field_71990_ca, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         break;
      case 3:
         this.func_74864_a(p_74990_1_, 0, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, 0, 0, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
         break;
      case 4:
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72045_aL.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72045_aL.field_71990_ca, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72034_aR.field_71990_ca, this.func_74863_c(Block.field_72034_aR.field_71990_ca, 4), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
         this.func_74864_a(p_74990_1_, Block.field_72034_aR.field_71990_ca, this.func_74863_c(Block.field_72034_aR.field_71990_ca, 3), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
      }

   }

   protected EnumDoor func_74988_a(Random p_74988_1_) {
      int var2 = p_74988_1_.nextInt(5);
      switch(var2) {
      case 0:
      case 1:
      default:
         return EnumDoor.OPENING;
      case 2:
         return EnumDoor.WOOD_DOOR;
      case 3:
         return EnumDoor.GRATES;
      case 4:
         return EnumDoor.IRON_DOOR;
      }
   }

   protected StructureComponent func_74986_a(ComponentStrongholdStairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_) {
      switch(this.field_74885_f) {
      case 0:
         return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78892_f + 1, this.field_74885_f, this.func_74877_c());
      case 1:
         return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, this.func_74877_c());
      case 2:
         return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c - 1, this.field_74885_f, this.func_74877_c());
      case 3:
         return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, this.func_74877_c());
      default:
         return null;
      }
   }

   protected StructureComponent func_74989_b(ComponentStrongholdStairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_) {
      switch(this.field_74885_f) {
      case 0:
         return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, 1, this.func_74877_c());
      case 1:
         return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
      case 2:
         return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, 1, this.func_74877_c());
      case 3:
         return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
      default:
         return null;
      }
   }

   protected StructureComponent func_74987_c(ComponentStrongholdStairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_) {
      switch(this.field_74885_f) {
      case 0:
         return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, 3, this.func_74877_c());
      case 1:
         return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
      case 2:
         return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, 3, this.func_74877_c());
      case 3:
         return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
      default:
         return null;
      }
   }

   protected static boolean func_74991_a(StructureBoundingBox p_74991_0_) {
      return p_74991_0_ != null && p_74991_0_.field_78895_b > 10;
   }
}
