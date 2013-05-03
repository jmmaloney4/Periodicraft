package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class CallableParticleScreenName implements Callable {

   // $FF: synthetic field
   final Minecraft field_90053_a;


   public CallableParticleScreenName(Minecraft p_i7001_1_) {
      this.field_90053_a = p_i7001_1_;
   }

   public String func_90052_a() {
      return this.field_90053_a.field_71462_r.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90052_a();
   }
}
