package net.minecraft.util;

import net.minecraft.crash.CrashReport;

public class ReportedException extends RuntimeException {

   private final CrashReport field_71576_a;


   public ReportedException(CrashReport p_i3253_1_) {
      this.field_71576_a = p_i3253_1_;
   }

   public CrashReport func_71575_a() {
      return this.field_71576_a;
   }

   public Throwable getCause() {
      return this.field_71576_a.func_71505_b();
   }

   public String getMessage() {
      return this.field_71576_a.func_71501_a();
   }
}
