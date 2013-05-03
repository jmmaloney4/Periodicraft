package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class ComponentVillageWell extends ComponentVillage {

   private final boolean field_74924_a = true;
   private int field_74923_b = -1;


   public ComponentVillageWell(ComponentVillageStartPiece p_i3875_1_, int p_i3875_2_, Random p_i3875_3_, int p_i3875_4_, int p_i3875_5_) {
      super(p_i3875_1_, p_i3875_2_);
      this.field_74885_f = p_i3875_3_.nextInt(4);
      switch(this.field_74885_f) {
      case 0:
      case 2:
         this.field_74887_e = new StructureBoundingBox(p_i3875_4_, 64, p_i3875_5_, p_i3875_4_ + 6 - 1, 78, p_i3875_5_ + 6 - 1);
         break;
      default:
         this.field_74887_e = new StructureBoundingBox(p_i3875_4_, 64, p_i3875_5_, p_i3875_4_ + 6 - 1, 78, p_i3875_5_ + 6 - 1);
      }

   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
      StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c + 1, 1, this.func_74877_c());
      StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c + 1, 3, this.func_74877_c());
      StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
      StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74923_b < 0) {
         this.field_74923_b = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74923_b < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74923_b - this.field_74887_e.field_78894_e + 3, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 4, 12, 4, Block.field_71978_w.field_71990_ca, Block.field_71942_A.field_71990_ca, false);
      this.func_74864_a(p_74875_1_, 0, 0, 2, 12, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 3, 12, 2, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 2, 12, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, 0, 0, 3, 12, 3, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 13, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 14, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 13, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 14, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 13, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 14, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 13, 4, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 14, 4, p_74875_3_);
      this.func_74884_a(p_74875_1_, p_74875_3_, 1, 15, 1, 4, 15, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);

      for(int var4 = 0; var4 <= 5; ++var4) {
         for(int var5 = 0; var5 <= 5; ++var5) {
            if(var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
               this.func_74864_a(p_74875_1_, Block.field_71940_F.field_71990_ca, 0, var5, 11, var4, p_74875_3_);
               this.func_74871_b(p_74875_1_, var5, 12, var4, p_74875_3_);
            }
         }
      }

      return true;
   }
}
