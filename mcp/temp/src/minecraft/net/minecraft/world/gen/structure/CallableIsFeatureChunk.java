package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;
import net.minecraft.world.gen.structure.MapGenStructure;

class CallableIsFeatureChunk implements Callable {

   // $FF: synthetic field
   final int field_85169_a;
   // $FF: synthetic field
   final int field_85167_b;
   // $FF: synthetic field
   final MapGenStructure field_85168_c;


   CallableIsFeatureChunk(MapGenStructure p_i6817_1_, int p_i6817_2_, int p_i6817_3_) {
      this.field_85168_c = p_i6817_1_;
      this.field_85169_a = p_i6817_2_;
      this.field_85167_b = p_i6817_3_;
   }

   public String func_85166_a() {
      return this.field_85168_c.func_75047_a(this.field_85169_a, this.field_85167_b)?"True":"False";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85166_a();
   }
}
