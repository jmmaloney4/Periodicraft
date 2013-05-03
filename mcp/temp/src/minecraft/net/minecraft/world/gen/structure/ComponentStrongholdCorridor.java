package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentStrongholdCorridor extends ComponentStronghold {

   private final int field_74993_a;


   public ComponentStrongholdCorridor(int p_i3841_1_, Random p_i3841_2_, StructureBoundingBox p_i3841_3_, int p_i3841_4_) {
      super(p_i3841_1_);
      this.field_74885_f = p_i3841_4_;
      this.field_74887_e = p_i3841_3_;
      this.field_74993_a = p_i3841_4_ != 2 && p_i3841_4_ != 0?p_i3841_3_.func_78883_b():p_i3841_3_.func_78880_d();
   }

   public static StructureBoundingBox func_74992_a(List p_74992_0_, Random p_74992_1_, int p_74992_2_, int p_74992_3_, int p_74992_4_, int p_74992_5_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, 4, p_74992_5_);
      StructureComponent var8 = StructureComponent.func_74883_a(p_74992_0_, var7);
      if(var8 == null) {
         return null;
      } else {
         if(var8.func_74874_b().field_78895_b == var7.field_78895_b) {
            for(int var9 = 3; var9 >= 1; --var9) {
               var7 = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, var9 - 1, p_74992_5_);
               if(!var8.func_74874_b().func_78884_a(var7)) {
                  return StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, var9, p_74992_5_);
               }
            }
         }

         return null;
      }
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         for(int var4 = 0; var4 < this.field_74993_a; ++var4) {
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, 0, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 0, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 0, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 0, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, 0, var4, p_74875_3_);

            for(int var5 = 1; var5 <= 3; ++var5) {
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, var5, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, 0, 0, 1, var5, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, 0, 0, 2, var5, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, 0, 0, 3, var5, var4, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, var5, var4, p_74875_3_);
            }

            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, 4, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 4, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 4, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 4, var4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, 4, var4, p_74875_3_);
         }

         return true;
      }
   }
}
