package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenTaiga extends BiomeGenBase {

   public BiomeGenTaiga(int p_i3765_1_) {
      super(p_i3765_1_);
      this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
      this.field_76760_I.field_76832_z = 10;
      this.field_76760_I.field_76803_B = 1;
   }

   public WorldGenerator func_76740_a(Random p_76740_1_) {
      return (WorldGenerator)(p_76740_1_.nextInt(3) == 0?new WorldGenTaiga1():new WorldGenTaiga2(false));
   }
}
