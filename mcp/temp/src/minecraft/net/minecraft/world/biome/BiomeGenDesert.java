package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenDesert extends BiomeGenBase {

   public BiomeGenDesert(int p_i3753_1_) {
      super(p_i3753_1_);
      this.field_76762_K.clear();
      this.field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
      this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
      this.field_76760_I.field_76832_z = -999;
      this.field_76760_I.field_76804_C = 2;
      this.field_76760_I.field_76799_E = 50;
      this.field_76760_I.field_76800_F = 10;
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
      if(p_76728_2_.nextInt(1000) == 0) {
         int var5 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
         int var6 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
         WorldGenDesertWells var7 = new WorldGenDesertWells();
         var7.func_76484_a(p_76728_1_, p_76728_2_, var5, p_76728_1_.func_72976_f(var5, var6) + 1, var6);
      }

   }
}
