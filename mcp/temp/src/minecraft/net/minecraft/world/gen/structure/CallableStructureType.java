package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;
import net.minecraft.world.gen.structure.MapGenStructure;

class CallableStructureType implements Callable {

   // $FF: synthetic field
   final MapGenStructure field_85161_a;


   CallableStructureType(MapGenStructure p_i6819_1_) {
      this.field_85161_a = p_i6819_1_;
   }

   public String func_85160_a() {
      return this.field_85161_a.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85160_a();
   }
}
