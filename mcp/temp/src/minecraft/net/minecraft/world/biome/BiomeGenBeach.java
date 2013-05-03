package net.minecraft.world.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBeach extends BiomeGenBase {

   public BiomeGenBeach(int p_i3745_1_) {
      super(p_i3745_1_);
      this.field_76762_K.clear();
      this.field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
      this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
      this.field_76760_I.field_76832_z = -999;
      this.field_76760_I.field_76804_C = 0;
      this.field_76760_I.field_76799_E = 0;
      this.field_76760_I.field_76800_F = 0;
   }
}
