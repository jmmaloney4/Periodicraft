package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.multiplayer.WorldClient;

@SideOnly(Side.CLIENT)
class CallableMPL1 implements Callable {

   // $FF: synthetic field
   final WorldClient field_78833_a;


   CallableMPL1(WorldClient p_i3098_1_) {
      this.field_78833_a = p_i3098_1_;
   }

   public String func_78832_a() {
      return WorldClient.func_73026_a(this.field_78833_a).size() + " total; " + WorldClient.func_73026_a(this.field_78833_a).toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_78832_a();
   }
}
