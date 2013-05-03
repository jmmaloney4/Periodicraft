package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;

public class ComponentMineshaftCross extends StructureComponent {

   private final int field_74953_a;
   private final boolean field_74952_b;


   public ComponentMineshaftCross(int p_i3808_1_, Random p_i3808_2_, StructureBoundingBox p_i3808_3_, int p_i3808_4_) {
      super(p_i3808_1_);
      this.field_74953_a = p_i3808_4_;
      this.field_74887_e = p_i3808_3_;
      this.field_74952_b = p_i3808_3_.func_78882_c() > 3;
   }

   public static StructureBoundingBox func_74951_a(List p_74951_0_, Random p_74951_1_, int p_74951_2_, int p_74951_3_, int p_74951_4_, int p_74951_5_) {
      StructureBoundingBox var6 = new StructureBoundingBox(p_74951_2_, p_74951_3_, p_74951_4_, p_74951_2_, p_74951_3_ + 2, p_74951_4_);
      if(p_74951_1_.nextInt(4) == 0) {
         var6.field_78894_e += 4;
      }

      switch(p_74951_5_) {
      case 0:
         var6.field_78897_a = p_74951_2_ - 1;
         var6.field_78893_d = p_74951_2_ + 3;
         var6.field_78892_f = p_74951_4_ + 4;
         break;
      case 1:
         var6.field_78897_a = p_74951_2_ - 4;
         var6.field_78896_c = p_74951_4_ - 1;
         var6.field_78892_f = p_74951_4_ + 3;
         break;
      case 2:
         var6.field_78897_a = p_74951_2_ - 1;
         var6.field_78893_d = p_74951_2_ + 3;
         var6.field_78896_c = p_74951_4_ - 4;
         break;
      case 3:
         var6.field_78893_d = p_74951_2_ + 4;
         var6.field_78896_c = p_74951_4_ - 1;
         var6.field_78892_f = p_74951_4_ + 3;
      }

      return StructureComponent.func_74883_a(p_74951_0_, var6) != null?null:var6;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      int var4 = this.func_74877_c();
      switch(this.field_74953_a) {
      case 0:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, var4);
         break;
      case 1:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, var4);
         break;
      case 2:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, var4);
         break;
      case 3:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, var4);
      }

      if(this.field_74952_b) {
         if(p_74861_3_.nextBoolean()) {
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c - 1, 2, var4);
         }

         if(p_74861_3_.nextBoolean()) {
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, 1, var4);
         }

         if(p_74861_3_.nextBoolean()) {
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, 3, var4);
         }

         if(p_74861_3_.nextBoolean()) {
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78892_f + 1, 0, var4);
         }
      }

   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         if(this.field_74952_b) {
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f, 0, 0, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f - 1, 0, 0, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, 0, 0, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, 0, 0, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f - 1, 0, 0, false);
         } else {
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, 0, 0, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, 0, 0, false);
         }

         this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Block.field_71988_x.field_71990_ca, 0, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Block.field_71988_x.field_71990_ca, 0, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Block.field_71988_x.field_71990_ca, 0, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Block.field_71988_x.field_71990_ca, 0, false);

         for(int var4 = this.field_74887_e.field_78897_a; var4 <= this.field_74887_e.field_78893_d; ++var4) {
            for(int var5 = this.field_74887_e.field_78896_c; var5 <= this.field_74887_e.field_78892_f; ++var5) {
               int var6 = this.func_74866_a(p_74875_1_, var4, this.field_74887_e.field_78895_b - 1, var5, p_74875_3_);
               if(var6 == 0) {
                  this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, var4, this.field_74887_e.field_78895_b - 1, var5, p_74875_3_);
               }
            }
         }

         return true;
      }
   }
}
