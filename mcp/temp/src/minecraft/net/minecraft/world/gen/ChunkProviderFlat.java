package net.minecraft.world.gen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenVillage;

public class ChunkProviderFlat implements IChunkProvider {

   private World field_73163_a;
   private Random field_73161_b;
   private final byte[] field_82700_c = new byte[256];
   private final byte[] field_82698_d = new byte[256];
   private final FlatGeneratorInfo field_82699_e;
   private final List field_82696_f = new ArrayList();
   private final boolean field_82697_g;
   private final boolean field_82702_h;
   private WorldGenLakes field_82703_i;
   private WorldGenLakes field_82701_j;


   public ChunkProviderFlat(World p_i5090_1_, long p_i5090_2_, boolean p_i5090_4_, String p_i5090_5_) {
      this.field_73163_a = p_i5090_1_;
      this.field_73161_b = new Random(p_i5090_2_);
      this.field_82699_e = FlatGeneratorInfo.func_82651_a(p_i5090_5_);
      if(p_i5090_4_) {
         Map var6 = this.field_82699_e.func_82644_b();
         if(var6.containsKey("village")) {
            Map var7 = (Map)var6.get("village");
            if(!var7.containsKey("size")) {
               var7.put("size", "1");
            }

            this.field_82696_f.add(new MapGenVillage(var7));
         }

         if(var6.containsKey("biome_1")) {
            this.field_82696_f.add(new MapGenScatteredFeature((Map)var6.get("biome_1")));
         }

         if(var6.containsKey("mineshaft")) {
            this.field_82696_f.add(new MapGenMineshaft((Map)var6.get("mineshaft")));
         }

         if(var6.containsKey("stronghold")) {
            this.field_82696_f.add(new MapGenStronghold((Map)var6.get("stronghold")));
         }
      }

      this.field_82697_g = this.field_82699_e.func_82644_b().containsKey("decoration");
      if(this.field_82699_e.func_82644_b().containsKey("lake")) {
         this.field_82703_i = new WorldGenLakes(Block.field_71943_B.field_71990_ca);
      }

      if(this.field_82699_e.func_82644_b().containsKey("lava_lake")) {
         this.field_82701_j = new WorldGenLakes(Block.field_71938_D.field_71990_ca);
      }

      this.field_82702_h = this.field_82699_e.func_82644_b().containsKey("dungeon");
      Iterator var9 = this.field_82699_e.func_82650_c().iterator();

      while(var9.hasNext()) {
         FlatLayerInfo var10 = (FlatLayerInfo)var9.next();

         for(int var8 = var10.func_82656_d(); var8 < var10.func_82656_d() + var10.func_82657_a(); ++var8) {
            this.field_82700_c[var8] = (byte)(var10.func_82659_b() & 255);
            this.field_82698_d[var8] = (byte)var10.func_82658_c();
         }
      }

   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      return this.func_73154_d(p_73158_1_, p_73158_2_);
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      Chunk var3 = new Chunk(this.field_73163_a, p_73154_1_, p_73154_2_);

      for(int var4 = 0; var4 < this.field_82700_c.length; ++var4) {
         int var5 = var4 >> 4;
         ExtendedBlockStorage var6 = var3.func_76587_i()[var5];
         if(var6 == null) {
            var6 = new ExtendedBlockStorage(var4, !this.field_73163_a.field_73011_w.field_76576_e);
            var3.func_76587_i()[var5] = var6;
         }

         for(int var7 = 0; var7 < 16; ++var7) {
            for(int var8 = 0; var8 < 16; ++var8) {
               var6.func_76655_a(var7, var4 & 15, var8, this.field_82700_c[var4] & 255);
               var6.func_76654_b(var7, var4 & 15, var8, this.field_82698_d[var4]);
            }
         }
      }

      var3.func_76603_b();
      BiomeGenBase[] var9 = this.field_73163_a.func_72959_q().func_76933_b((BiomeGenBase[])null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      byte[] var10 = var3.func_76605_m();

      for(int var11 = 0; var11 < var10.length; ++var11) {
         var10[var11] = (byte)var9[var11].field_76756_M;
      }

      Iterator var12 = this.field_82696_f.iterator();

      while(var12.hasNext()) {
         MapGenStructure var13 = (MapGenStructure)var12.next();
         var13.func_75036_a(this, this.field_73163_a, p_73154_1_, p_73154_2_, (byte[])null);
      }

      var3.func_76603_b();
      return var3;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      int var4 = p_73153_2_ * 16;
      int var5 = p_73153_3_ * 16;
      BiomeGenBase var6 = this.field_73163_a.func_72807_a(var4 + 16, var5 + 16);
      boolean var7 = false;
      this.field_73161_b.setSeed(this.field_73163_a.func_72905_C());
      long var8 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
      long var10 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
      this.field_73161_b.setSeed((long)p_73153_2_ * var8 + (long)p_73153_3_ * var10 ^ this.field_73163_a.func_72905_C());
      Iterator var12 = this.field_82696_f.iterator();

      while(var12.hasNext()) {
         MapGenStructure var13 = (MapGenStructure)var12.next();
         boolean var14 = var13.func_75051_a(this.field_73163_a, this.field_73161_b, p_73153_2_, p_73153_3_);
         if(var13 instanceof MapGenVillage) {
            var7 |= var14;
         }
      }

      int var17;
      int var16;
      int var18;
      if(this.field_82703_i != null && !var7 && this.field_73161_b.nextInt(4) == 0) {
         var16 = var4 + this.field_73161_b.nextInt(16) + 8;
         var17 = this.field_73161_b.nextInt(128);
         var18 = var5 + this.field_73161_b.nextInt(16) + 8;
         this.field_82703_i.func_76484_a(this.field_73163_a, this.field_73161_b, var16, var17, var18);
      }

      if(this.field_82701_j != null && !var7 && this.field_73161_b.nextInt(8) == 0) {
         var16 = var4 + this.field_73161_b.nextInt(16) + 8;
         var17 = this.field_73161_b.nextInt(this.field_73161_b.nextInt(120) + 8);
         var18 = var5 + this.field_73161_b.nextInt(16) + 8;
         if(var17 < 63 || this.field_73161_b.nextInt(10) == 0) {
            this.field_82701_j.func_76484_a(this.field_73163_a, this.field_73161_b, var16, var17, var18);
         }
      }

      if(this.field_82702_h) {
         for(var16 = 0; var16 < 8; ++var16) {
            var17 = var4 + this.field_73161_b.nextInt(16) + 8;
            var18 = this.field_73161_b.nextInt(128);
            int var15 = var5 + this.field_73161_b.nextInt(16) + 8;
            (new WorldGenDungeons()).func_76484_a(this.field_73163_a, this.field_73161_b, var17, var18, var15);
         }
      }

      if(this.field_82697_g) {
         var6.func_76728_a(this.field_73163_a, this.field_73161_b, var4, var5);
      }

   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "FlatLevelSource";
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      BiomeGenBase var5 = this.field_73163_a.func_72807_a(p_73155_2_, p_73155_4_);
      return var5 == null?null:var5.func_76747_a(p_73155_1_);
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      if("Stronghold".equals(p_73150_2_)) {
         Iterator var6 = this.field_82696_f.iterator();

         while(var6.hasNext()) {
            MapGenStructure var7 = (MapGenStructure)var6.next();
            if(var7 instanceof MapGenStronghold) {
               return var7.func_75050_a(p_73150_1_, p_73150_3_, p_73150_4_, p_73150_5_);
            }
         }
      }

      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int p_82695_1_, int p_82695_2_) {
      Iterator var3 = this.field_82696_f.iterator();

      while(var3.hasNext()) {
         MapGenStructure var4 = (MapGenStructure)var3.next();
         var4.func_75036_a(this, this.field_73163_a, p_82695_1_, p_82695_2_, (byte[])null);
      }

   }
}
