package net.minecraft.world.biome;

import net.minecraft.util.WeightedRandomItem;

public class SpawnListEntry extends WeightedRandomItem {

   public Class field_76300_b;
   public int field_76301_c;
   public int field_76299_d;


   public SpawnListEntry(Class p_i3746_1_, int p_i3746_2_, int p_i3746_3_, int p_i3746_4_) {
      super(p_i3746_2_);
      this.field_76300_b = p_i3746_1_;
      this.field_76301_c = p_i3746_3_;
      this.field_76299_d = p_i3746_4_;
   }
}
