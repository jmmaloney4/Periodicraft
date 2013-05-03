package net.minecraft.world.storage;

import java.util.concurrent.Callable;
import net.minecraft.world.storage.WorldInfo;

class CallableLevelStorageVersion implements Callable {

   // $FF: synthetic field
   final WorldInfo field_85113_a;


   CallableLevelStorageVersion(WorldInfo p_i6826_1_) {
      this.field_85113_a = p_i6826_1_;
   }

   public String func_85112_a() {
      String var1 = "Unknown?";

      try {
         switch(WorldInfo.func_85121_j(this.field_85113_a)) {
         case 19132:
            var1 = "McRegion";
            break;
         case 19133:
            var1 = "Anvil";
         }
      } catch (Throwable var3) {
         ;
      }

      return String.format("0x%05X - %s", new Object[]{Integer.valueOf(WorldInfo.func_85121_j(this.field_85113_a)), var1});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85112_a();
   }
}
