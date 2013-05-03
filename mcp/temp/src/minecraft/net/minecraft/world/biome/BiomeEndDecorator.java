package net.minecraft.world.biome;

import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenSpikes;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeEndDecorator extends BiomeDecorator {

   protected WorldGenerator field_76835_L;


   public BiomeEndDecorator(BiomeGenBase p_i3767_1_) {
      super(p_i3767_1_);
      this.field_76835_L = new WorldGenSpikes(Block.field_72082_bJ.field_71990_ca);
   }

   protected void func_76794_a() {
      this.func_76797_b();
      if(this.field_76813_b.nextInt(5) == 0) {
         int var1 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
         int var2 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
         int var3 = this.field_76815_a.func_72825_h(var1, var2);
         if(var3 > 0) {
            ;
         }

         this.field_76835_L.func_76484_a(this.field_76815_a, this.field_76813_b, var1, var3, var2);
      }

      if(this.field_76814_c == 0 && this.field_76811_d == 0) {
         EntityDragon var4 = new EntityDragon(this.field_76815_a);
         var4.func_70012_b(0.0D, 128.0D, 0.0D, this.field_76813_b.nextFloat() * 360.0F, 0.0F);
         this.field_76815_a.func_72838_d(var4);
      }

   }
}
