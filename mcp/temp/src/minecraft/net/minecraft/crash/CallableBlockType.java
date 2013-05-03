package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;

final class CallableBlockType implements Callable {

   // $FF: synthetic field
   final int field_85080_a;


   CallableBlockType(int p_i6805_1_) {
      this.field_85080_a = p_i6805_1_;
   }

   public String func_85079_a() {
      try {
         return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(this.field_85080_a), Block.field_71973_m[this.field_85080_a].func_71917_a(), Block.field_71973_m[this.field_85080_a].getClass().getCanonicalName()});
      } catch (Throwable var2) {
         return "ID #" + this.field_85080_a;
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85079_a();
   }
}
