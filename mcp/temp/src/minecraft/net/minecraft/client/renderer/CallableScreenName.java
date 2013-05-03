package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.EntityRenderer;

@SideOnly(Side.CLIENT)
class CallableScreenName implements Callable {

   // $FF: synthetic field
   final EntityRenderer field_90032_a;


   CallableScreenName(EntityRenderer p_i7006_1_) {
      this.field_90032_a = p_i7006_1_;
   }

   public String func_90031_a() {
      return EntityRenderer.func_90030_a(this.field_90032_a).field_71462_r.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90031_a();
   }
}
