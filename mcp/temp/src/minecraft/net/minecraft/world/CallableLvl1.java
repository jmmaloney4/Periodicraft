package net.minecraft.world;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.world.World;

class CallableLvl1 implements Callable {

   // $FF: synthetic field
   final int field_85179_a;
   // $FF: synthetic field
   final World field_77485_a;


   CallableLvl1(World p_i6814_1_, int p_i6814_2_) {
      this.field_77485_a = p_i6814_1_;
      this.field_85179_a = p_i6814_2_;
   }

   public String func_77484_a() {
      try {
         return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(this.field_85179_a), Block.field_71973_m[this.field_85179_a].func_71917_a(), Block.field_71973_m[this.field_85179_a].getClass().getCanonicalName()});
      } catch (Throwable var2) {
         return "ID #" + this.field_85179_a;
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_77484_a();
   }
}
