package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.EnumDoor;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class ComponentStrongholdLibrary extends ComponentStronghold {

   public static final WeightedRandomChestContent[] field_75007_b = new WeightedRandomChestContent[]{new WeightedRandomChestContent(Item.field_77760_aL.field_77779_bT, 0, 1, 3, 20), new WeightedRandomChestContent(Item.field_77759_aK.field_77779_bT, 0, 2, 7, 20), new WeightedRandomChestContent(Item.field_82801_bO.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Item.field_77750_aQ.field_77779_bT, 0, 1, 1, 1)};
   protected final EnumDoor field_75009_a;
   private final boolean field_75008_c;


   public ComponentStrongholdLibrary(int p_i3844_1_, Random p_i3844_2_, StructureBoundingBox p_i3844_3_, int p_i3844_4_) {
      super(p_i3844_1_);
      this.field_74885_f = p_i3844_4_;
      this.field_75009_a = this.func_74988_a(p_i3844_2_);
      this.field_74887_e = p_i3844_3_;
      this.field_75008_c = p_i3844_3_.func_78882_c() > 6;
   }

   public static ComponentStrongholdLibrary func_75006_a(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_) {
      StructureBoundingBox var7 = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);
      if(!func_74991_a(var7) || StructureComponent.func_74883_a(p_75006_0_, var7) != null) {
         var7 = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);
         if(!func_74991_a(var7) || StructureComponent.func_74883_a(p_75006_0_, var7) != null) {
            return null;
         }
      }

      return new ComponentStrongholdLibrary(p_75006_6_, p_75006_1_, var7, p_75006_5_);
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(this.func_74860_a(p_74875_1_, p_74875_3_)) {
         return false;
      } else {
         byte var4 = 11;
         if(!this.field_75008_c) {
            var4 = 6;
         }

         this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 13, var4 - 1, 14, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
         this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_75009_a, 4, 1, 0);
         this.func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Block.field_71955_W.field_71990_ca, Block.field_71955_W.field_71990_ca, false);

         int var7;
         for(var7 = 1; var7 <= 13; ++var7) {
            if((var7 - 1) % 4 == 0) {
               this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, var7, 1, 4, var7, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
               this.func_74884_a(p_74875_1_, p_74875_3_, 12, 1, var7, 12, 4, var7, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
               this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, var7, p_74875_3_);
               this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 11, 3, var7, p_74875_3_);
               if(this.field_75008_c) {
                  this.func_74884_a(p_74875_1_, p_74875_3_, 1, 6, var7, 1, 9, var7, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                  this.func_74884_a(p_74875_1_, p_74875_3_, 12, 6, var7, 12, 9, var7, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
               }
            } else {
               this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, var7, 1, 4, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
               this.func_74884_a(p_74875_1_, p_74875_3_, 12, 1, var7, 12, 4, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
               if(this.field_75008_c) {
                  this.func_74884_a(p_74875_1_, p_74875_3_, 1, 6, var7, 1, 9, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                  this.func_74884_a(p_74875_1_, p_74875_3_, 12, 6, var7, 12, 9, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
               }
            }
         }

         for(var7 = 3; var7 < 12; var7 += 2) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 3, 1, var7, 4, 3, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 6, 1, var7, 7, 3, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 9, 1, var7, 10, 3, var7, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
         }

         if(this.field_75008_c) {
            this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 9, 5, 11, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 5, 11, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 9, 5, 10, p_74875_3_);
            this.func_74884_a(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 9, 6, 11, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 8, 6, 11, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 9, 6, 10, p_74875_3_);
            var7 = this.func_74863_c(Block.field_72055_aF.field_71990_ca, 3);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 1, 13, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 2, 13, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 3, 13, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 4, 13, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 5, 13, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 6, 13, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, var7, 10, 7, 13, p_74875_3_);
            byte var8 = 7;
            byte var9 = 7;
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 - 1, 9, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8, 9, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 - 1, 8, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8, 8, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 - 1, 7, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8, 7, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 - 2, 7, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 + 1, 7, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 - 1, 7, var9 - 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8 - 1, 7, var9 + 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8, 7, var9 - 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, var8, 7, var9 + 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, var8 - 2, 8, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, var8 + 1, 8, var9, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, var8 - 1, 8, var9 - 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, var8 - 1, 8, var9 + 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, var8, 8, var9 - 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, var8, 8, var9 + 1, p_74875_3_);
         }

         this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[]{Item.field_92105_bW.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
         if(this.field_75008_c) {
            this.func_74864_a(p_74875_1_, 0, 0, 12, 9, 1, p_74875_3_);
            this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[]{Item.field_92105_bW.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
         }

         return true;
      }
   }

}
