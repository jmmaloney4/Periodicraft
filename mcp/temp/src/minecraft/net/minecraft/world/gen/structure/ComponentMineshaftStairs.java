package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;

public class ComponentMineshaftStairs extends StructureComponent {

   public ComponentMineshaftStairs(int p_i3810_1_, Random p_i3810_2_, StructureBoundingBox p_i3810_3_, int p_i3810_4_) {
      super(p_i3810_1_);
      this.field_74885_f = p_i3810_4_;
      this.field_74887_e = p_i3810_3_;
   }

   public static StructureBoundingBox func_74950_a(List p_74950_0_, Random p_74950_1_, int p_74950_2_, int p_74950_3_, int p_74950_4_, int p_74950_5_) {
      StructureBoundingBox var6 = new StructureBoundingBox(p_74950_2_, p_74950_3_ - 5, p_74950_4_, p_74950_2_, p_74950_3_ + 2, p_74950_4_);
      switch(p_74950_5_) {
      case 0:
         var6.field_78893_d = p_74950_2_ + 2;
         var6.field_78892_f = p_74950_4_ + 8;
         break;
      case 1:
         var6.field_78897_a = p_74950_2_ - 8;
         var6.field_78892_f = p_74950_4_ + 2;
         break;
      case 2:
         var6.field_78893_d = p_74950_2_ + 2;
         var6.field_78896_c = p_74950_4_ - 8;
         break;
      case 3:
         var6.field_78893_d = p_74950_2_ + 8;
         var6.field_78892_f = p_74950_4_ + 2;
      }

      return StructureComponent.func_74883_a(p_74950_0_, var6) != null?null:var6;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      int var4 = this.func_74877_c();
      switch(this.field_74885_f) {
      case 0:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, var4);
         break;
      case 1:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, var4);
         break;
      case 2:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, var4);
         break;
      case 3:
         StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, var4);
      }

   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 2, 7, 1, 0, 0, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 7, 2, 2, 8, 0, 0, false);

         for(int var4 = 0; var4 < 5; ++var4) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5 - var4 - (var4 < 4?1:0), 2 + var4, 2, 7 - var4, 2 + var4, 0, 0, false);
         }

         return true;
      }
   }
}
