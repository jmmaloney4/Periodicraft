package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class CallableUpdatingScreenName implements Callable {

   // $FF: synthetic field
   final Minecraft field_90055_a;


   public CallableUpdatingScreenName(Minecraft p_i7002_1_) {
      this.field_90055_a = p_i7002_1_;
   }

   public String func_90054_a() {
      return this.field_90055_a.field_71462_r.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90054_a();
   }
}
