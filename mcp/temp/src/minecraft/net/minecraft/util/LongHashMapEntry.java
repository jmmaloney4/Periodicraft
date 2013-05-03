package net.minecraft.util;

import net.minecraft.util.LongHashMap;

class LongHashMapEntry {

   final long field_76150_a;
   Object field_76148_b;
   LongHashMapEntry field_76149_c;
   final int field_76147_d;


   LongHashMapEntry(int p_i3420_1_, long p_i3420_2_, Object p_i3420_4_, LongHashMapEntry p_i3420_5_) {
      this.field_76148_b = p_i3420_4_;
      this.field_76149_c = p_i3420_5_;
      this.field_76150_a = p_i3420_2_;
      this.field_76147_d = p_i3420_1_;
   }

   public final long func_76146_a() {
      return this.field_76150_a;
   }

   public final Object func_76145_b() {
      return this.field_76148_b;
   }

   public final boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof LongHashMapEntry)) {
         return false;
      } else {
         LongHashMapEntry var2 = (LongHashMapEntry)p_equals_1_;
         Long var3 = Long.valueOf(this.func_76146_a());
         Long var4 = Long.valueOf(var2.func_76146_a());
         if(var3 == var4 || var3 != null && var3.equals(var4)) {
            Object var5 = this.func_76145_b();
            Object var6 = var2.func_76145_b();
            if(var5 == var6 || var5 != null && var5.equals(var6)) {
               return true;
            }
         }

         return false;
      }
   }

   public final int hashCode() {
      return LongHashMap.func_76151_f(this.field_76150_a);
   }

   public final String toString() {
      return this.func_76146_a() + "=" + this.func_76145_b();
   }
}
