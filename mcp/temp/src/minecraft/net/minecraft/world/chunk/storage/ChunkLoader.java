package net.minecraft.world.chunk.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.AnvilConverterData;
import net.minecraft.world.chunk.storage.NibbleArrayReader;

public class ChunkLoader {

   public static AnvilConverterData func_76691_a(NBTTagCompound p_76691_0_) {
      int var1 = p_76691_0_.func_74762_e("xPos");
      int var2 = p_76691_0_.func_74762_e("zPos");
      AnvilConverterData var3 = new AnvilConverterData(var1, var2);
      var3.field_76693_g = p_76691_0_.func_74770_j("Blocks");
      var3.field_76692_f = new NibbleArrayReader(p_76691_0_.func_74770_j("Data"), 7);
      var3.field_76695_e = new NibbleArrayReader(p_76691_0_.func_74770_j("SkyLight"), 7);
      var3.field_76694_d = new NibbleArrayReader(p_76691_0_.func_74770_j("BlockLight"), 7);
      var3.field_76697_c = p_76691_0_.func_74770_j("HeightMap");
      var3.field_76696_b = p_76691_0_.func_74767_n("TerrainPopulated");
      var3.field_76702_h = p_76691_0_.func_74761_m("Entities");
      var3.field_76703_i = p_76691_0_.func_74761_m("TileEntities");
      var3.field_76700_j = p_76691_0_.func_74761_m("TileTicks");

      try {
         var3.field_76698_a = p_76691_0_.func_74763_f("LastUpdate");
      } catch (ClassCastException var5) {
         var3.field_76698_a = (long)p_76691_0_.func_74762_e("LastUpdate");
      }

      return var3;
   }

   public static void func_76690_a(AnvilConverterData p_76690_0_, NBTTagCompound p_76690_1_, WorldChunkManager p_76690_2_) {
      p_76690_1_.func_74768_a("xPos", p_76690_0_.field_76701_k);
      p_76690_1_.func_74768_a("zPos", p_76690_0_.field_76699_l);
      p_76690_1_.func_74772_a("LastUpdate", p_76690_0_.field_76698_a);
      int[] var3 = new int[p_76690_0_.field_76697_c.length];

      for(int var4 = 0; var4 < p_76690_0_.field_76697_c.length; ++var4) {
         var3[var4] = p_76690_0_.field_76697_c[var4];
      }

      p_76690_1_.func_74783_a("HeightMap", var3);
      p_76690_1_.func_74757_a("TerrainPopulated", p_76690_0_.field_76696_b);
      NBTTagList var16 = new NBTTagList("Sections");

      int var7;
      for(int var5 = 0; var5 < 8; ++var5) {
         boolean var6 = true;

         for(var7 = 0; var7 < 16 && var6; ++var7) {
            int var8 = 0;

            while(var8 < 16 && var6) {
               int var9 = 0;

               while(true) {
                  if(var9 < 16) {
                     int var10 = var7 << 11 | var9 << 7 | var8 + (var5 << 4);
                     byte var11 = p_76690_0_.field_76693_g[var10];
                     if(var11 == 0) {
                        ++var9;
                        continue;
                     }

                     var6 = false;
                  }

                  ++var8;
                  break;
               }
            }
         }

         if(!var6) {
            byte[] var19 = new byte[4096];
            NibbleArray var20 = new NibbleArray(var19.length, 4);
            NibbleArray var21 = new NibbleArray(var19.length, 4);
            NibbleArray var23 = new NibbleArray(var19.length, 4);

            for(int var22 = 0; var22 < 16; ++var22) {
               for(int var12 = 0; var12 < 16; ++var12) {
                  for(int var13 = 0; var13 < 16; ++var13) {
                     int var14 = var22 << 11 | var13 << 7 | var12 + (var5 << 4);
                     byte var15 = p_76690_0_.field_76693_g[var14];
                     var19[var12 << 8 | var13 << 4 | var22] = (byte)(var15 & 255);
                     var20.func_76581_a(var22, var12, var13, p_76690_0_.field_76692_f.func_76686_a(var22, var12 + (var5 << 4), var13));
                     var21.func_76581_a(var22, var12, var13, p_76690_0_.field_76695_e.func_76686_a(var22, var12 + (var5 << 4), var13));
                     var23.func_76581_a(var22, var12, var13, p_76690_0_.field_76694_d.func_76686_a(var22, var12 + (var5 << 4), var13));
                  }
               }
            }

            NBTTagCompound var24 = new NBTTagCompound();
            var24.func_74774_a("Y", (byte)(var5 & 255));
            var24.func_74773_a("Blocks", var19);
            var24.func_74773_a("Data", var20.field_76585_a);
            var24.func_74773_a("SkyLight", var21.field_76585_a);
            var24.func_74773_a("BlockLight", var23.field_76585_a);
            var16.func_74742_a(var24);
         }
      }

      p_76690_1_.func_74782_a("Sections", var16);
      byte[] var17 = new byte[256];

      for(int var18 = 0; var18 < 16; ++var18) {
         for(var7 = 0; var7 < 16; ++var7) {
            var17[var7 << 4 | var18] = (byte)(p_76690_2_.func_76935_a(p_76690_0_.field_76701_k << 4 | var18, p_76690_0_.field_76699_l << 4 | var7).field_76756_M & 255);
         }
      }

      p_76690_1_.func_74773_a("Biomes", var17);
      p_76690_1_.func_74782_a("Entities", p_76690_0_.field_76702_h);
      p_76690_1_.func_74782_a("TileEntities", p_76690_0_.field_76703_i);
      if(p_76690_0_.field_76700_j != null) {
         p_76690_1_.func_74782_a("TileTicks", p_76690_0_.field_76700_j);
      }

   }
}
