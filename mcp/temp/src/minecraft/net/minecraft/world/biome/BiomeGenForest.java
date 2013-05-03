package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenForest extends BiomeGenBase {

   public BiomeGenForest(int p_i3756_1_) {
      super(p_i3756_1_);
      this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
      this.field_76760_I.field_76832_z = 10;
      this.field_76760_I.field_76803_B = 2;
   }

   public WorldGenerator func_76740_a(Random p_76740_1_) {
      return (WorldGenerator)(p_76740_1_.nextInt(5) == 0?this.field_76764_P:(p_76740_1_.nextInt(10) == 0?this.field_76758_O:this.field_76757_N));
   }
}
