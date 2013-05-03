package net.minecraft.world.biome;

import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeCacheBlock {

   public float[] field_76892_a;
   public float[] field_76890_b;
   public BiomeGenBase[] field_76891_c;
   public int field_76888_d;
   public int field_76889_e;
   public long field_76886_f;
   // $FF: synthetic field
   final BiomeCache field_76887_g;


   public BiomeCacheBlock(BiomeCache p_i3748_1_, int p_i3748_2_, int p_i3748_3_) {
      this.field_76887_g = p_i3748_1_;
      this.field_76892_a = new float[256];
      this.field_76890_b = new float[256];
      this.field_76891_c = new BiomeGenBase[256];
      this.field_76888_d = p_i3748_2_;
      this.field_76889_e = p_i3748_3_;
      BiomeCache.func_76836_a(p_i3748_1_).func_76934_b(this.field_76892_a, p_i3748_2_ << 4, p_i3748_3_ << 4, 16, 16);
      BiomeCache.func_76836_a(p_i3748_1_).func_76936_a(this.field_76890_b, p_i3748_2_ << 4, p_i3748_3_ << 4, 16, 16);
      BiomeCache.func_76836_a(p_i3748_1_).func_76931_a(this.field_76891_c, p_i3748_2_ << 4, p_i3748_3_ << 4, 16, 16, false);
   }

   public BiomeGenBase func_76885_a(int p_76885_1_, int p_76885_2_) {
      return this.field_76891_c[p_76885_1_ & 15 | (p_76885_2_ & 15) << 4];
   }
}
