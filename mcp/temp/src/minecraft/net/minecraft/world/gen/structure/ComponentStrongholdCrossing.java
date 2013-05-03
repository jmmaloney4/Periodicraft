package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdCrossing extends ComponentStronghold {

   protected final EnumDoor field_74998_a;
   private boolean field_74996_b;
   private boolean field_74997_c;
   private boolean field_74995_d;
   private boolean field_74999_h;


   public ComponentStrongholdCrossing(int p_i3842_1_, Random p_i3842_2_, StructureBoundingBox p_i3842_3_, int p_i3842_4_) {
      super(p_i3842_1_);
      this.field_74885_f = p_i3842_4_;
      this.field_74998_a = this.func_74988_a(p_i3842_2_);
      this.field_74887_e = p_i3842_3_;
      this.field_74996_b = p_i3842_2_.nextBoolean();
      this.field_74997_c = p_i3842_2_.nextBoolean();
      this.field_74995_d = p_i3842_2_.nextBoolean();
      this.field_74999_h = p_i3842_2_.nextInt(3) > 0;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      int var4 = 3;
      int var5 = 5;
      if(this.field_74885_f == 1 || this.field_74885_f == 2) {
         var4 = 8 - var4;
         var5 = 8 - var5;
      }

      this.func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 5, 1);
      if(this.field_74996_b) {
         this.func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, var4, 1);
      }

      if(this.field_74997_c) {
         this.func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, var5, 7);
      }

      if(this.field_74995_d) {
         this.func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, var4, 1);
      }

      if(this.field_74999_h) {
         this.func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, var5, 7);
      }

   }

   public static ComponentStrongholdCrossing func_74994_a(List p_74994_0_, Random p_74994_1_, int p_74994_2_, int p_74994_3_, int p_74994_4_, int p_74994_5_, int p_74994_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74994_2_, p_74994_3_, p_74994_4_, -4, -3, 0, 10, 9, 11, p_74994_5_);
      return func_74991_a(var7) && StructureComponent.func_74883_a(p_74994_0_, var7) == null?new ComponentStrongholdCrossing(p_74994_6_, p_74994_1_, var7, p_74994_5_):null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 8, 10, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_74998_a, 4, 3, 0);
         if(this.field_74996_b) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 5, 3, 0, 0, false);
         }

         if(this.field_74995_d) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 9, 3, 1, 9, 5, 3, 0, 0, false);
         }

         if(this.field_74997_c) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 7, 0, 7, 9, 0, 0, false);
         }

         if(this.field_74999_h) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 9, 5, 7, 9, 7, 9, 0, 0, false);
         }

         this.func_74884_a(p_74875_1_, p_74875_3_, 5, 1, 10, 7, 3, 10, 0, 0, false);
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 2, 1, 8, 2, 6, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 4, 4, 9, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 5, 8, 4, 9, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 4, 7, 3, 4, 9, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 5, 3, 3, 6, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 4, 3, 3, 4, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 6, 3, 4, 6, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
         this.func_74882_a(p_74875_1_, p_74875_3_, 5, 1, 7, 7, 1, 8, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74884_a(p_74875_1_, p_74875_3_, 5, 1, 9, 7, 1, 9, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 7, 7, 2, 7, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 7, 4, 5, 9, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 7, 8, 5, 9, Block.field_72079_ak.field_71990_ca, Block.field_72079_ak.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 5, 5, 7, 7, 5, 9, Block.field_72085_aj.field_71990_ca, Block.field_72085_aj.field_71990_ca, false);
         this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 6, 5, 6, p_74875_3_);
         return true;
      }
   }
}
