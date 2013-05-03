package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorBonusChest extends WorldGenerator {

   private final WeightedRandomChestContent[] field_76546_a;
   private final int field_76545_b;


   public WorldGeneratorBonusChest(WeightedRandomChestContent[] p_i3786_1_, int p_i3786_2_) {
      this.field_76546_a = p_i3786_1_;
      this.field_76545_b = p_i3786_2_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      int var12;
      for(boolean var6 = false; ((var12 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || var12 == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 1; --p_76484_4_) {
         ;
      }

      if(p_76484_4_ < 1) {
         return false;
      } else {
         ++p_76484_4_;

         for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int var9 = p_76484_4_ + p_76484_2_.nextInt(3) - p_76484_2_.nextInt(3);
            int var10 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            if(p_76484_1_.func_72799_c(var8, var9, var10) && p_76484_1_.func_72797_t(var8, var9 - 1, var10)) {
               p_76484_1_.func_72832_d(var8, var9, var10, Block.field_72077_au.field_71990_ca, 0, 2);
               TileEntityChest var11 = (TileEntityChest)p_76484_1_.func_72796_p(var8, var9, var10);
               if(var11 != null && var11 != null) {
                  WeightedRandomChestContent.func_76293_a(p_76484_2_, this.field_76546_a, var11, this.field_76545_b);
               }

               if(p_76484_1_.func_72799_c(var8 - 1, var9, var10) && p_76484_1_.func_72797_t(var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_72832_d(var8 - 1, var9, var10, Block.field_72069_aq.field_71990_ca, 0, 2);
               }

               if(p_76484_1_.func_72799_c(var8 + 1, var9, var10) && p_76484_1_.func_72797_t(var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_72832_d(var8 + 1, var9, var10, Block.field_72069_aq.field_71990_ca, 0, 2);
               }

               if(p_76484_1_.func_72799_c(var8, var9, var10 - 1) && p_76484_1_.func_72797_t(var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_72832_d(var8, var9, var10 - 1, Block.field_72069_aq.field_71990_ca, 0, 2);
               }

               if(p_76484_1_.func_72799_c(var8, var9, var10 + 1) && p_76484_1_.func_72797_t(var8 - 1, var9 - 1, var10)) {
                  p_76484_1_.func_72832_d(var8, var9, var10 + 1, Block.field_72069_aq.field_71990_ca, 0, 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
