package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReportCategory;

final class CallableBlockLocation implements Callable {

   // $FF: synthetic field
   final int field_85067_a;
   // $FF: synthetic field
   final int field_85065_b;
   // $FF: synthetic field
   final int field_85066_c;


   CallableBlockLocation(int p_i6807_1_, int p_i6807_2_, int p_i6807_3_) {
      this.field_85067_a = p_i6807_1_;
      this.field_85065_b = p_i6807_2_;
      this.field_85066_c = p_i6807_3_;
   }

   public String func_85064_a() {
      return CrashReportCategory.func_85071_a(this.field_85067_a, this.field_85065_b, this.field_85066_c);
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85064_a();
   }
}
