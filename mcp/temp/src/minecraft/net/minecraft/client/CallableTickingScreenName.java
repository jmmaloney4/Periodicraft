package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class CallableTickingScreenName implements Callable {

   // $FF: synthetic field
   final Minecraft field_74421_a;


   public CallableTickingScreenName(Minecraft p_i7000_1_) {
      this.field_74421_a = p_i7000_1_;
   }

   public String func_74420_a() {
      return this.field_74421_a.field_71462_r.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_74420_a();
   }
}
