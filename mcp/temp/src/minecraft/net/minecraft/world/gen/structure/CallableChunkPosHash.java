package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.gen.structure.MapGenStructure;

class CallableChunkPosHash implements Callable {

   // $FF: synthetic field
   final int field_85165_a;
   // $FF: synthetic field
   final int field_85163_b;
   // $FF: synthetic field
   final MapGenStructure field_85164_c;


   CallableChunkPosHash(MapGenStructure p_i6818_1_, int p_i6818_2_, int p_i6818_3_) {
      this.field_85164_c = p_i6818_1_;
      this.field_85165_a = p_i6818_2_;
      this.field_85163_b = p_i6818_3_;
   }

   public String func_85162_a() {
      return String.valueOf(ChunkCoordIntPair.func_77272_a(this.field_85165_a, this.field_85163_b));
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85162_a();
   }
}
