package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureStrongholdStart;

public class MapGenStronghold extends MapGenStructure {

   private BiomeGenBase[] field_75058_e;
   private boolean field_75056_f;
   private ChunkCoordIntPair[] field_75057_g;
   private double field_82671_h;
   private int field_82672_i;


   public MapGenStronghold() {
      this.field_75058_e = new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76768_g, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x};
      this.field_75057_g = new ChunkCoordIntPair[3];
      this.field_82671_h = 32.0D;
      this.field_82672_i = 3;
   }

   public MapGenStronghold(Map p_i5096_1_) {
      this.field_75058_e = new BiomeGenBase[]{BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76768_g, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x};
      this.field_75057_g = new ChunkCoordIntPair[3];
      this.field_82671_h = 32.0D;
      this.field_82672_i = 3;
      Iterator var2 = p_i5096_1_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(((String)var3.getKey()).equals("distance")) {
            this.field_82671_h = MathHelper.func_82713_a((String)var3.getValue(), this.field_82671_h, 1.0D);
         } else if(((String)var3.getKey()).equals("count")) {
            this.field_75057_g = new ChunkCoordIntPair[MathHelper.func_82714_a((String)var3.getValue(), this.field_75057_g.length, 1)];
         } else if(((String)var3.getKey()).equals("spread")) {
            this.field_82672_i = MathHelper.func_82714_a((String)var3.getValue(), this.field_82672_i, 1);
         }
      }

   }

   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
      if(!this.field_75056_f) {
         Random var3 = new Random();
         var3.setSeed(this.field_75039_c.func_72905_C());
         double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;
         int var6 = 1;

         for(int var7 = 0; var7 < this.field_75057_g.length; ++var7) {
            double var8 = (1.25D * (double)var6 + var3.nextDouble()) * this.field_82671_h * (double)var6;
            int var10 = (int)Math.round(Math.cos(var4) * var8);
            int var11 = (int)Math.round(Math.sin(var4) * var8);
            ArrayList var12 = new ArrayList();
            Collections.addAll(var12, this.field_75058_e);
            ChunkPosition var13 = this.field_75039_c.func_72959_q().func_76941_a((var10 << 4) + 8, (var11 << 4) + 8, 112, var12, var3);
            if(var13 != null) {
               var10 = var13.field_76930_a >> 4;
               var11 = var13.field_76929_c >> 4;
            }

            this.field_75057_g[var7] = new ChunkCoordIntPair(var10, var11);
            var4 += 6.283185307179586D * (double)var6 / (double)this.field_82672_i;
            if(var7 == this.field_82672_i) {
               var6 += 2 + var3.nextInt(5);
               this.field_82672_i += 1 + var3.nextInt(2);
            }
         }

         this.field_75056_f = true;
      }

      ChunkCoordIntPair[] var14 = this.field_75057_g;
      int var15 = var14.length;

      for(int var5 = 0; var5 < var15; ++var5) {
         ChunkCoordIntPair var16 = var14[var5];
         if(p_75047_1_ == var16.field_77276_a && p_75047_2_ == var16.field_77275_b) {
            return true;
         }
      }

      return false;
   }

   protected List func_75052_o_() {
      ArrayList var1 = new ArrayList();
      ChunkCoordIntPair[] var2 = this.field_75057_g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ChunkCoordIntPair var5 = var2[var4];
         if(var5 != null) {
            var1.add(var5.func_77271_a(64));
         }
      }

      return var1;
   }

   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
      StructureStrongholdStart var3;
      for(var3 = new StructureStrongholdStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_); var3.func_75073_b().isEmpty() || ((ComponentStrongholdStairs2)var3.func_75073_b().get(0)).field_75025_b == null; var3 = new StructureStrongholdStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_)) {
         ;
      }

      return var3;
   }
}
