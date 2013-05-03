package net.minecraft.crash;

import java.util.concurrent.Callable;

final class CallableBlockDataValue implements Callable {

   // $FF: synthetic field
   final int field_85063_a;


   CallableBlockDataValue(int p_i6806_1_) {
      this.field_85063_a = p_i6806_1_;
   }

   public String func_85062_a() {
      if(this.field_85063_a < 0) {
         return "Unknown? (Got " + this.field_85063_a + ")";
      } else {
         String var1 = String.format("%4s", new Object[]{Integer.toBinaryString(this.field_85063_a)}).replace(" ", "0");
         return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[]{Integer.valueOf(this.field_85063_a), var1});
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85062_a();
   }
}
