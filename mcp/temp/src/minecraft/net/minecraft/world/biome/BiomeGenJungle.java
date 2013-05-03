package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenJungle extends BiomeGenBase {

   public BiomeGenJungle(int p_i3759_1_) {
      super(p_i3759_1_);
      this.field_76760_I.field_76832_z = 50;
      this.field_76760_I.field_76803_B = 25;
      this.field_76760_I.field_76802_A = 4;
      this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
      this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
   }

   public WorldGenerator func_76740_a(Random p_76740_1_) {
      return (WorldGenerator)(p_76740_1_.nextInt(10) == 0?this.field_76758_O:(p_76740_1_.nextInt(2) == 0?new WorldGenShrub(3, 0):(p_76740_1_.nextInt(3) == 0?new WorldGenHugeTrees(false, 10 + p_76740_1_.nextInt(20), 3, 3):new WorldGenTrees(false, 4 + p_76740_1_.nextInt(7), 3, 3, true))));
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return p_76730_1_.nextInt(4) == 0?new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2):new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
      WorldGenVines var5 = new WorldGenVines();

      for(int var6 = 0; var6 < 50; ++var6) {
         int var7 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
         byte var8 = 64;
         int var9 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
         var5.func_76484_a(p_76728_1_, p_76728_2_, var7, var8, var9);
      }

   }
}
