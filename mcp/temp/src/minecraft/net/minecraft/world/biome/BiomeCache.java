package net.minecraft.world.biome;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.biome.BiomeCacheBlock;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class BiomeCache {

   private final WorldChunkManager field_76844_a;
   private long field_76842_b = 0L;
   private LongHashMap field_76843_c = new LongHashMap();
   private List field_76841_d = new ArrayList();


   public BiomeCache(WorldChunkManager p_i3749_1_) {
      this.field_76844_a = p_i3749_1_;
   }

   public BiomeCacheBlock func_76840_a(int p_76840_1_, int p_76840_2_) {
      p_76840_1_ >>= 4;
      p_76840_2_ >>= 4;
      long var3 = (long)p_76840_1_ & 4294967295L | ((long)p_76840_2_ & 4294967295L) << 32;
      BiomeCacheBlock var5 = (BiomeCacheBlock)this.field_76843_c.func_76164_a(var3);
      if(var5 == null) {
         var5 = new BiomeCacheBlock(this, p_76840_1_, p_76840_2_);
         this.field_76843_c.func_76163_a(var3, var5);
         this.field_76841_d.add(var5);
      }

      var5.field_76886_f = System.currentTimeMillis();
      return var5;
   }

   public BiomeGenBase func_76837_b(int p_76837_1_, int p_76837_2_) {
      return this.func_76840_a(p_76837_1_, p_76837_2_).func_76885_a(p_76837_1_, p_76837_2_);
   }

   public void func_76838_a() {
      long var1 = System.currentTimeMillis();
      long var3 = var1 - this.field_76842_b;
      if(var3 > 7500L || var3 < 0L) {
         this.field_76842_b = var1;

         for(int var5 = 0; var5 < this.field_76841_d.size(); ++var5) {
            BiomeCacheBlock var6 = (BiomeCacheBlock)this.field_76841_d.get(var5);
            long var7 = var1 - var6.field_76886_f;
            if(var7 > 30000L || var7 < 0L) {
               this.field_76841_d.remove(var5--);
               long var9 = (long)var6.field_76888_d & 4294967295L | ((long)var6.field_76889_e & 4294967295L) << 32;
               this.field_76843_c.func_76159_d(var9);
            }
         }
      }

   }

   public BiomeGenBase[] func_76839_e(int p_76839_1_, int p_76839_2_) {
      return this.func_76840_a(p_76839_1_, p_76839_2_).field_76891_c;
   }

   // $FF: synthetic method
   static WorldChunkManager func_76836_a(BiomeCache p_76836_0_) {
      return p_76836_0_.field_76844_a;
   }
}
