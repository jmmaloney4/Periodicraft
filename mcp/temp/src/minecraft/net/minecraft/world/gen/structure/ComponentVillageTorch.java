package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentVillageTorch extends ComponentVillage {

   private int field_74905_a = -1;


   public ComponentVillageTorch(ComponentVillageStartPiece p_i3863_1_, int p_i3863_2_, Random p_i3863_3_, StructureBoundingBox p_i3863_4_, int p_i3863_5_) {
      super(p_i3863_1_, p_i3863_2_);
      this.field_74885_f = p_i3863_5_;
      this.field_74887_e = p_i3863_4_;
   }

   public static StructureBoundingBox func_74904_a(ComponentVillageStartPiece p_74904_0_, List p_74904_1_, Random p_74904_2_, int p_74904_3_, int p_74904_4_, int p_74904_5_, int p_74904_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74904_3_, p_74904_4_, p_74904_5_, 0, 0, 0, 3, 4, 2, p_74904_6_);
      return StructureComponent.func_74883_a(p_74904_1_, var7) != null?null:var7;
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.field_74905_a < 0) {
         this.field_74905_a = this.func_74889_b(p_74875_1_, p_74875_3_);
         if(this.field_74905_a < 0) {
            return true;
         }

         this.field_74887_e.func_78886_a(0, this.field_74905_a - this.field_74887_e.field_78894_e + 4 - 1, 0);
      }

      this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 3, 1, 0, 0, false);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 0, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 1, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 2, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, 15, 1, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 0, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 1, 3, 1, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, 0, p_74875_3_);
      this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 1, 3, -1, p_74875_3_);
      return true;
   }
}
