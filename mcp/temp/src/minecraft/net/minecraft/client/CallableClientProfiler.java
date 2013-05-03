package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class CallableClientProfiler implements Callable {

   // $FF: synthetic field
   final Minecraft field_90046_a;


   public CallableClientProfiler(Minecraft p_i3017_1_) {
      this.field_90046_a = p_i3017_1_;
   }

   public String func_90045_a() {
      return this.field_90046_a.field_71424_I.field_76327_a?this.field_90046_a.field_71424_I.func_76322_c():"N/A (disabled)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90045_a();
   }
}
