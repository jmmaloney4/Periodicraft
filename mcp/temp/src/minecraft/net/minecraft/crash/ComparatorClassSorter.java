package net.minecraft.crash;

import java.util.Comparator;
import net.minecraft.crash.CallableSuspiciousClasses;

class ComparatorClassSorter implements Comparator {

   // $FF: synthetic field
   final CallableSuspiciousClasses field_85082_a;


   ComparatorClassSorter(CallableSuspiciousClasses p_i6802_1_) {
      this.field_85082_a = p_i6802_1_;
   }

   public int func_85081_a(Class p_85081_1_, Class p_85081_2_) {
      String var3 = p_85081_1_.getPackage() == null?"":p_85081_1_.getPackage().getName();
      String var4 = p_85081_2_.getPackage() == null?"":p_85081_2_.getPackage().getName();
      return var3.compareTo(var4);
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_85081_a((Class)p_compare_1_, (Class)p_compare_2_);
   }
}
