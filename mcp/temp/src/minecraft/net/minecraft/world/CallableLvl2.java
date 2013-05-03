package net.minecraft.world;

import java.util.concurrent.Callable;
import net.minecraft.world.World;

class CallableLvl2 implements Callable {

   // $FF: synthetic field
   final World field_77405_a;


   CallableLvl2(World p_i3729_1_) {
      this.field_77405_a = p_i3729_1_;
   }

   public String func_77404_a() {
      return this.field_77405_a.field_73010_i.size() + " total; " + this.field_77405_a.field_73010_i.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_77404_a();
   }
}
