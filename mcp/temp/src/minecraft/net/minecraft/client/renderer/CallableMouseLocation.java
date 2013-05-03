package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.EntityRenderer;
import org.lwjgl.input.Mouse;

@SideOnly(Side.CLIENT)
class CallableMouseLocation implements Callable {

   // $FF: synthetic field
   final int field_90026_a;
   // $FF: synthetic field
   final int field_90024_b;
   // $FF: synthetic field
   final EntityRenderer field_90025_c;


   CallableMouseLocation(EntityRenderer p_i7005_1_, int p_i7005_2_, int p_i7005_3_) {
      this.field_90025_c = p_i7005_1_;
      this.field_90026_a = p_i7005_2_;
      this.field_90024_b = p_i7005_3_;
   }

   public String func_90023_a() {
      return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", new Object[]{Integer.valueOf(this.field_90026_a), Integer.valueOf(this.field_90024_b), Integer.valueOf(Mouse.getX()), Integer.valueOf(Mouse.getY())});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90023_a();
   }
}
