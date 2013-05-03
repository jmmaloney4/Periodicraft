package net.minecraft.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenSwamp extends BiomeGenBase {

   protected BiomeGenSwamp(int p_i3764_1_) {
      super(p_i3764_1_);
      this.field_76760_I.field_76832_z = 2;
      this.field_76760_I.field_76802_A = -999;
      this.field_76760_I.field_76804_C = 1;
      this.field_76760_I.field_76798_D = 8;
      this.field_76760_I.field_76799_E = 10;
      this.field_76760_I.field_76806_I = 1;
      this.field_76760_I.field_76833_y = 4;
      this.field_76759_H = 14745518;
      this.field_76761_J.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
   }

   public WorldGenerator func_76740_a(Random p_76740_1_) {
      return this.field_76763_Q;
   }

   @SideOnly(Side.CLIENT)
   public int func_76737_k() {
      double var1 = (double)this.func_76743_j();
      double var3 = (double)this.func_76727_i();
      return ((ColorizerGrass.func_77480_a(var1, var3) & 16711422) + 5115470) / 2;
   }

   @SideOnly(Side.CLIENT)
   public int func_76726_l() {
      double var1 = (double)this.func_76743_j();
      double var3 = (double)this.func_76727_i();
      return ((ColorizerFoliage.func_77470_a(var1, var3) & 16711422) + 5115470) / 2;
   }
}
