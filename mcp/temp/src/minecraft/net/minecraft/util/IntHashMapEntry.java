package net.minecraft.util;

import net.minecraft.util.IntHashMap;

class IntHashMapEntry {

   final int field_76035_a;
   Object field_76033_b;
   IntHashMapEntry field_76034_c;
   final int field_76032_d;


   IntHashMapEntry(int p_i3419_1_, int p_i3419_2_, Object p_i3419_3_, IntHashMapEntry p_i3419_4_) {
      this.field_76033_b = p_i3419_3_;
      this.field_76034_c = p_i3419_4_;
      this.field_76035_a = p_i3419_2_;
      this.field_76032_d = p_i3419_1_;
   }

   public final int func_76031_a() {
      return this.field_76035_a;
   }

   public final Object func_76030_b() {
      return this.field_76033_b;
   }

   public final boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof IntHashMapEntry)) {
         return false;
      } else {
         IntHashMapEntry var2 = (IntHashMapEntry)p_equals_1_;
         Integer var3 = Integer.valueOf(this.func_76031_a());
         Integer var4 = Integer.valueOf(var2.func_76031_a());
         if(var3 == var4 || var3 != null && var3.equals(var4)) {
            Object var5 = this.func_76030_b();
            Object var6 = var2.func_76030_b();
            if(var5 == var6 || var5 != null && var5.equals(var6)) {
               return true;
            }
         }

         return false;
      }
   }

   public final int hashCode() {
      return IntHashMap.func_76042_f(this.field_76035_a);
   }

   public final String toString() {
      return this.func_76031_a() + "=" + this.func_76030_b();
   }
}
