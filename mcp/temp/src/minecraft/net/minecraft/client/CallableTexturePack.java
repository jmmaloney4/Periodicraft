package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class CallableTexturePack implements Callable {

   // $FF: synthetic field
   final Minecraft field_90051_a;


   public CallableTexturePack(Minecraft p_i3012_1_) {
      this.field_90051_a = p_i3012_1_;
   }

   public String func_90050_a() {
      return this.field_90051_a.field_71474_y.field_74346_m;
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90050_a();
   }
}
