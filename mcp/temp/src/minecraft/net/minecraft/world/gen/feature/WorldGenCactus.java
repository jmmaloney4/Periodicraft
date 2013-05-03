package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCactus extends WorldGenerator {

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      for(int var6 = 0; var6 < 10; ++var6) {
         int var7 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         int var8 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
         int var9 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         if(p_76484_1_.func_72799_c(var7, var8, var9)) {
            int var10 = 1 + p_76484_2_.nextInt(p_76484_2_.nextInt(3) + 1);

            for(int var11 = 0; var11 < var10; ++var11) {
               if(Block.field_72038_aV.func_71854_d(p_76484_1_, var7, var8 + var11, var9)) {
                  p_76484_1_.func_72832_d(var7, var8 + var11, var9, Block.field_72038_aV.field_71990_ca, 0, 2);
               }
            }
         }
      }

      return true;
   }
}
