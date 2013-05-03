package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureMineshaftPieces;

public class ComponentMineshaftRoom extends StructureComponent {

   private List field_74949_a = new LinkedList();


   public ComponentMineshaftRoom(int p_i3809_1_, Random p_i3809_2_, int p_i3809_3_, int p_i3809_4_) {
      super(p_i3809_1_);
      this.field_74887_e = new StructureBoundingBox(p_i3809_3_, 50, p_i3809_4_, p_i3809_3_ + 7 + p_i3809_2_.nextInt(6), 54 + p_i3809_2_.nextInt(6), p_i3809_4_ + 7 + p_i3809_2_.nextInt(6));
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      int var4 = this.func_74877_c();
      int var6 = this.field_74887_e.func_78882_c() - 3 - 1;
      if(var6 <= 0) {
         var6 = 1;
      }

      int var5;
      StructureComponent var7;
      StructureBoundingBox var8;
      for(var5 = 0; var5 < this.field_74887_e.func_78883_b(); var5 += 4) {
         var5 += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
         if(var5 + 3 > this.field_74887_e.func_78883_b()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + var5, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c - 1, 2, var4);
         if(var7 != null) {
            var8 = var7.func_74874_b();
            this.field_74949_a.add(new StructureBoundingBox(var8.field_78897_a, var8.field_78895_b, this.field_74887_e.field_78896_c, var8.field_78893_d, var8.field_78894_e, this.field_74887_e.field_78896_c + 1));
         }
      }

      for(var5 = 0; var5 < this.field_74887_e.func_78883_b(); var5 += 4) {
         var5 += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
         if(var5 + 3 > this.field_74887_e.func_78883_b()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + var5, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78892_f + 1, 0, var4);
         if(var7 != null) {
            var8 = var7.func_74874_b();
            this.field_74949_a.add(new StructureBoundingBox(var8.field_78897_a, var8.field_78895_b, this.field_74887_e.field_78892_f - 1, var8.field_78893_d, var8.field_78894_e, this.field_74887_e.field_78892_f));
         }
      }

      for(var5 = 0; var5 < this.field_74887_e.func_78880_d(); var5 += 4) {
         var5 += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
         if(var5 + 3 > this.field_74887_e.func_78880_d()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c + var5, 1, var4);
         if(var7 != null) {
            var8 = var7.func_74874_b();
            this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78897_a, var8.field_78895_b, var8.field_78896_c, this.field_74887_e.field_78897_a + 1, var8.field_78894_e, var8.field_78892_f));
         }
      }

      for(var5 = 0; var5 < this.field_74887_e.func_78880_d(); var5 += 4) {
         var5 += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
         if(var5 + 3 > this.field_74887_e.func_78880_d()) {
            break;
         }

         var7 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(var6) + 1, this.field_74887_e.field_78896_c + var5, 3, var4);
         if(var7 != null) {
            var8 = var7.func_74874_b();
            this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78893_d - 1, var8.field_78895_b, var8.field_78896_c, this.field_74887_e.field_78893_d, var8.field_78894_e, var8.field_78892_f));
         }
      }

   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f, Block.field_71979_v.field_71990_ca, 0, true);
         this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, Math.min(this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78894_e), this.field_74887_e.field_78892_f, 0, 0, false);
         Iterator var4 = this.field_74949_a.iterator();

         while(var4.hasNext()) {
            StructureBoundingBox var5 = (StructureBoundingBox)var4.next();
            this.func_74884_a(p_74875_1_, p_74875_3_, var5.field_78897_a, var5.field_78894_e - 2, var5.field_78896_c, var5.field_78893_d, var5.field_78894_e, var5.field_78892_f, 0, 0, false);
         }

         this.func_74867_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 4, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, 0, false);
         return true;
      }
   }
}
