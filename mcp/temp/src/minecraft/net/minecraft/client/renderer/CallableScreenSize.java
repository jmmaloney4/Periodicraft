package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.EntityRenderer;

@SideOnly(Side.CLIENT)
class CallableScreenSize implements Callable {

   // $FF: synthetic field
   final ScaledResolution field_90029_a;
   // $FF: synthetic field
   final EntityRenderer field_90028_b;


   CallableScreenSize(EntityRenderer p_i7004_1_, ScaledResolution p_i7004_2_) {
      this.field_90028_b = p_i7004_1_;
      this.field_90029_a = p_i7004_2_;
   }

   public String func_90027_a() {
      return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", new Object[]{Integer.valueOf(this.field_90029_a.func_78326_a()), Integer.valueOf(this.field_90029_a.func_78328_b()), Integer.valueOf(EntityRenderer.func_90030_a(this.field_90028_b).field_71443_c), Integer.valueOf(EntityRenderer.func_90030_a(this.field_90028_b).field_71440_d), Integer.valueOf(this.field_90029_a.func_78325_e())});
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_90027_a();
   }
}
