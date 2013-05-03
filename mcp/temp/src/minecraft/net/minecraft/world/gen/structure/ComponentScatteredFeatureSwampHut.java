package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentScatteredFeature;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentScatteredFeatureSwampHut extends ComponentScatteredFeature {

   private boolean field_82682_h;


   public ComponentScatteredFeatureSwampHut(Random p_i5095_1_, int p_i5095_2_, int p_i5095_3_) {
      super(p_i5095_1_, p_i5095_2_, 64, p_i5095_3_, 7, 5, 9);
   }

   public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
      if(!this.func_74935_a(p_74875_1_, p_74875_3_, 0)) {
         return false;
      } else {
         this.func_74872_a(p_74875_1_, p_74875_3_, 1, 1, 1, 5, 1, 7, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 1, 4, 2, 5, 4, 7, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 2, 1, 0, 4, 1, 0, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 2, 2, 2, 3, 3, 2, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 1, 2, 3, 1, 3, 6, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 5, 2, 3, 5, 3, 6, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 2, 2, 7, 4, 3, 7, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 2, 1, 3, 2, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 5, 0, 2, 5, 3, 2, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 7, 1, 3, 7, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
         this.func_74884_a(p_74875_1_, p_74875_3_, 5, 0, 7, 5, 3, 7, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 2, 3, 2, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 3, 3, 7, p_74875_3_);
         this.func_74864_a(p_74875_1_, 0, 0, 1, 3, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, 0, 0, 5, 3, 4, p_74875_3_);
         this.func_74864_a(p_74875_1_, 0, 0, 5, 3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_82516_cf.field_71990_ca, 7, 1, 3, 5, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72060_ay.field_71990_ca, 0, 3, 2, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72108_bG.field_71990_ca, 0, 4, 2, 6, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 2, 1, p_74875_3_);
         this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 5, 2, 1, p_74875_3_);
         int var4 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 3);
         int var5 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 1);
         int var6 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 0);
         int var7 = this.func_74863_c(Block.field_72063_at.field_71990_ca, 2);
         this.func_74872_a(p_74875_1_, p_74875_3_, 0, 4, 1, 6, 4, 1, Block.field_72074_bW.field_71990_ca, var4, Block.field_72074_bW.field_71990_ca, var4, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 0, 4, 2, 0, 4, 7, Block.field_72074_bW.field_71990_ca, var6, Block.field_72074_bW.field_71990_ca, var6, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 6, 4, 2, 6, 4, 7, Block.field_72074_bW.field_71990_ca, var5, Block.field_72074_bW.field_71990_ca, var5, false);
         this.func_74872_a(p_74875_1_, p_74875_3_, 0, 4, 8, 6, 4, 8, Block.field_72074_bW.field_71990_ca, var7, Block.field_72074_bW.field_71990_ca, var7, false);

         int var8;
         int var9;
         for(var8 = 2; var8 <= 7; var8 += 5) {
            for(var9 = 1; var9 <= 5; var9 += 4) {
               this.func_74870_b(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, var9, -1, var8, p_74875_3_);
            }
         }

         if(!this.field_82682_h) {
            var8 = this.func_74865_a(2, 5);
            var9 = this.func_74862_a(2);
            int var10 = this.func_74873_b(2, 5);
            if(p_74875_3_.func_78890_b(var8, var9, var10)) {
               this.field_82682_h = true;
               EntityWitch var11 = new EntityWitch(p_74875_1_);
               var11.func_70012_b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
               var11.func_82163_bD();
               p_74875_1_.func_72838_d(var11);
            }
         }

         return true;
      }
   }
}
