package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFlowers extends WorldGenerator {

   private int field_76528_a;


   public WorldGenFlowers(int p_i3790_1_) {
      this.field_76528_a = p_i3790_1_;
   }

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      for(int var6 = 0; var6 < 64; ++var6) {
         int var7 = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         int var8 = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
         int var9 = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
         if(p_76484_1_.func_72799_c(var7, var8, var9) && (!p_76484_1_.field_73011_w.field_76576_e || var8 < 127) && Block.field_71973_m[this.field_76528_a].func_71854_d(p_76484_1_, var7, var8, var9)) {
            p_76484_1_.func_72832_d(var7, var8, var9, this.field_76528_a, 0, 2);
         }
      }

      return true;
   }
}
