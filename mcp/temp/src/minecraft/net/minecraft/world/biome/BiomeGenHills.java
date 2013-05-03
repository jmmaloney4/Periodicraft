package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenHills extends BiomeGenBase {

   private WorldGenerator field_82915_S;


   protected BiomeGenHills(int p_i3754_1_) {
      super(p_i3754_1_);
      this.field_82915_S = new WorldGenMinable(Block.field_72006_bl.field_71990_ca, 8);
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
      int var5 = 3 + p_76728_2_.nextInt(6);

      int var6;
      int var7;
      int var8;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = p_76728_3_ + p_76728_2_.nextInt(16);
         var8 = p_76728_2_.nextInt(28) + 4;
         int var9 = p_76728_4_ + p_76728_2_.nextInt(16);
         int var10 = p_76728_1_.func_72798_a(var7, var8, var9);
         if(var10 == Block.field_71981_t.field_71990_ca) {
            p_76728_1_.func_72832_d(var7, var8, var9, Block.field_72068_bR.field_71990_ca, 0, 2);
         }
      }

      for(var5 = 0; var5 < 7; ++var5) {
         var6 = p_76728_3_ + p_76728_2_.nextInt(16);
         var7 = p_76728_2_.nextInt(64);
         var8 = p_76728_4_ + p_76728_2_.nextInt(16);
         this.field_82915_S.func_76484_a(p_76728_1_, p_76728_2_, var6, var7, var8);
      }

   }
}
