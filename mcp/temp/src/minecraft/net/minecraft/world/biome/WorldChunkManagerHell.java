package net.minecraft.world.biome;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerHell extends WorldChunkManager {

   private BiomeGenBase field_76947_d;
   private float field_76948_e;
   private float field_76946_f;


   public WorldChunkManagerHell(BiomeGenBase p_i3755_1_, float p_i3755_2_, float p_i3755_3_) {
      this.field_76947_d = p_i3755_1_;
      this.field_76948_e = p_i3755_2_;
      this.field_76946_f = p_i3755_3_;
   }

   public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_) {
      return this.field_76947_d;
   }

   public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_) {
      if(p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_) {
         p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
      }

      Arrays.fill(p_76937_1_, 0, p_76937_4_ * p_76937_5_, this.field_76947_d);
      return p_76937_1_;
   }

   public float[] func_76934_b(float[] p_76934_1_, int p_76934_2_, int p_76934_3_, int p_76934_4_, int p_76934_5_) {
      if(p_76934_1_ == null || p_76934_1_.length < p_76934_4_ * p_76934_5_) {
         p_76934_1_ = new float[p_76934_4_ * p_76934_5_];
      }

      Arrays.fill(p_76934_1_, 0, p_76934_4_ * p_76934_5_, this.field_76948_e);
      return p_76934_1_;
   }

   public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_) {
      if(p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_) {
         p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
      }

      Arrays.fill(p_76936_1_, 0, p_76936_4_ * p_76936_5_, this.field_76946_f);
      return p_76936_1_;
   }

   public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_) {
      if(p_76933_1_ == null || p_76933_1_.length < p_76933_4_ * p_76933_5_) {
         p_76933_1_ = new BiomeGenBase[p_76933_4_ * p_76933_5_];
      }

      Arrays.fill(p_76933_1_, 0, p_76933_4_ * p_76933_5_, this.field_76947_d);
      return p_76933_1_;
   }

   public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_) {
      return this.func_76933_b(p_76931_1_, p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
   }

   public ChunkPosition func_76941_a(int p_76941_1_, int p_76941_2_, int p_76941_3_, List p_76941_4_, Random p_76941_5_) {
      return p_76941_4_.contains(this.field_76947_d)?new ChunkPosition(p_76941_1_ - p_76941_3_ + p_76941_5_.nextInt(p_76941_3_ * 2 + 1), 0, p_76941_2_ - p_76941_3_ + p_76941_5_.nextInt(p_76941_3_ * 2 + 1)):null;
   }

   public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_) {
      return p_76940_4_.contains(this.field_76947_d);
   }
}
