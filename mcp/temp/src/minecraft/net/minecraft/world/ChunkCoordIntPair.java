package net.minecraft.world;

import net.minecraft.world.ChunkPosition;

public class ChunkCoordIntPair {

   public final int field_77276_a;
   public final int field_77275_b;


   public ChunkCoordIntPair(int p_i3726_1_, int p_i3726_2_) {
      this.field_77276_a = p_i3726_1_;
      this.field_77275_b = p_i3726_2_;
   }

   public static long func_77272_a(int p_77272_0_, int p_77272_1_) {
      return (long)p_77272_0_ & 4294967295L | ((long)p_77272_1_ & 4294967295L) << 32;
   }

   public int hashCode() {
      long var1 = func_77272_a(this.field_77276_a, this.field_77275_b);
      int var3 = (int)var1;
      int var4 = (int)(var1 >> 32);
      return var3 ^ var4;
   }

   public boolean equals(Object p_equals_1_) {
      ChunkCoordIntPair var2 = (ChunkCoordIntPair)p_equals_1_;
      return var2.field_77276_a == this.field_77276_a && var2.field_77275_b == this.field_77275_b;
   }

   public int func_77273_a() {
      return (this.field_77276_a << 4) + 8;
   }

   public int func_77274_b() {
      return (this.field_77275_b << 4) + 8;
   }

   public ChunkPosition func_77271_a(int p_77271_1_) {
      return new ChunkPosition(this.func_77273_a(), p_77271_1_, this.func_77274_b());
   }

   public String toString() {
      return "[" + this.field_77276_a + ", " + this.field_77275_b + "]";
   }
}
