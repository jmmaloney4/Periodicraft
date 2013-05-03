package net.minecraft.world;

import net.minecraft.block.Block;

public class NextTickListEntry implements Comparable {

   private static long field_77177_f = 0L;
   public int field_77183_a;
   public int field_77181_b;
   public int field_77182_c;
   public int field_77179_d;
   public long field_77180_e;
   public int field_82754_f;
   private long field_77178_g;


   public NextTickListEntry(int p_i3741_1_, int p_i3741_2_, int p_i3741_3_, int p_i3741_4_) {
      this.field_77178_g = (long)(field_77177_f++);
      this.field_77183_a = p_i3741_1_;
      this.field_77181_b = p_i3741_2_;
      this.field_77182_c = p_i3741_3_;
      this.field_77179_d = p_i3741_4_;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof NextTickListEntry)) {
         return false;
      } else {
         NextTickListEntry var2 = (NextTickListEntry)p_equals_1_;
         return this.field_77183_a == var2.field_77183_a && this.field_77181_b == var2.field_77181_b && this.field_77182_c == var2.field_77182_c && Block.func_94329_b(this.field_77179_d, var2.field_77179_d);
      }
   }

   public int hashCode() {
      return (this.field_77183_a * 1024 * 1024 + this.field_77182_c * 1024 + this.field_77181_b) * 256;
   }

   public NextTickListEntry func_77176_a(long p_77176_1_) {
      this.field_77180_e = p_77176_1_;
      return this;
   }

   public void func_82753_a(int p_82753_1_) {
      this.field_82754_f = p_82753_1_;
   }

   public int func_77175_a(NextTickListEntry p_77175_1_) {
      return this.field_77180_e < p_77175_1_.field_77180_e?-1:(this.field_77180_e > p_77175_1_.field_77180_e?1:(this.field_82754_f != p_77175_1_.field_82754_f?this.field_82754_f - p_77175_1_.field_82754_f:(this.field_77178_g < p_77175_1_.field_77178_g?-1:(this.field_77178_g > p_77175_1_.field_77178_g?1:0))));
   }

   public String toString() {
      return this.field_77179_d + ": (" + this.field_77183_a + ", " + this.field_77181_b + ", " + this.field_77182_c + "), " + this.field_77180_e + ", " + this.field_82754_f + ", " + this.field_77178_g;
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_77175_a((NextTickListEntry)p_compareTo_1_);
   }

}
