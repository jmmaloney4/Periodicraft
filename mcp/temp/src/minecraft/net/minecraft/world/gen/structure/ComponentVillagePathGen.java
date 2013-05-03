package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillageRoadPiece;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentVillagePathGen extends ComponentVillageRoadPiece {

   private int field_74934_a;


   public ComponentVillagePathGen(ComponentVillageStartPiece p_i3871_1_, int p_i3871_2_, Random p_i3871_3_, StructureBoundingBox p_i3871_4_, int p_i3871_5_) {
      super(p_i3871_1_, p_i3871_2_);
      this.field_74885_f = p_i3871_5_;
      this.field_74887_e = p_i3871_4_;
      this.field_74934_a = Math.max(p_i3871_4_.func_78883_b(), p_i3871_4_.func_78880_d());
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      boolean var4 = false;

      int var5;
      StructureComponent var6;
      for(var5 = p_74861_3_.nextInt(5); var5 < this.field_74934_a - 8; var5 += 2 + p_74861_3_.nextInt(5)) {
         var6 = this.func_74891_a((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, var5);
         if(var6 != null) {
            var5 += Math.max(var6.field_74887_e.func_78883_b(), var6.field_74887_e.func_78880_d());
            var4 = true;
         }
      }

      for(var5 = p_74861_3_.nextInt(5); var5 < this.field_74934_a - 8; var5 += 2 + p_74861_3_.nextInt(5)) {
         var6 = this.func_74894_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, var5);
         if(var6 != null) {
            var5 += Math.max(var6.field_74887_e.func_78883_b(), var6.field_74887_e.func_78880_d());
            var4 = true;
         }
      }

      if(var4 && p_74861_3_.nextInt(3) > 0) {
         switch(this.field_74885_f) {
         case 0:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 1, this.func_74877_c());
            break;
         case 1:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
            break;
         case 2:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, this.func_74877_c());
            break;
         case 3:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
         }
      }

      if(var4 && p_74861_3_.nextInt(3) > 0) {
         switch(this.field_74885_f) {
         case 0:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 3, this.func_74877_c());
            break;
         case 1:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
            break;
         case 2:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, this.func_74877_c());
            break;
         case 3:
            StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
         }
      }

   }

   public static StructureBoundingBox func_74933_a(ComponentVillageStartPiece p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_) {
      for(int var7 = 7 * MathHelper.func_76136_a(p_74933_2_, 3, 5); var7 >= 7; var7 -= 7) {
         StructureBoundingBox var8 = StructureBoundingBox.func_78889_a(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, var7, p_74933_6_);
         if(StructureComponent.func_74883_a(p_74933_1_, var8) == null) {
            return var8;
         }
      }

      return null;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      int var4 = this.func_74890_d(Block.field_71940_F.field_71990_ca, 0);

      for(int var5 = this.field_74887_e.field_78897_a; var5 <= this.field_74887_e.field_78893_d; ++var5) {
         for(int var6 = this.field_74887_e.field_78896_c; var6 <= this.field_74887_e.field_78892_f; ++var6) {
            if(p_74875_3_.func_78890_b(var5, 64, var6)) {
               int var7 = p_74875_1_.func_72825_h(var5, var6) - 1;
               p_74875_1_.func_72832_d(var5, var7, var6, var4, 0, 2);
            }
         }
      }

      return true;
   }
}
