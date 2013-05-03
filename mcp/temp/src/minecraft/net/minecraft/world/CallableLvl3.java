package net.minecraft.world;

import java.util.concurrent.Callable;
import net.minecraft.world.World;

class CallableLvl3 implements Callable {

   // $FF: synthetic field
   final World field_77440_a;


   CallableLvl3(World p_i3730_1_) {
      this.field_77440_a = p_i3730_1_;
   }

   public String func_77439_a() {
      return this.field_77440_a.field_73020_y.func_73148_d();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_77439_a();
   }
}
