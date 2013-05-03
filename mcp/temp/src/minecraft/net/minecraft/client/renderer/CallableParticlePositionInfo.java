package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.crash.CrashReportCategory;

@SideOnly(Side.CLIENT)
class CallableParticlePositionInfo implements Callable {

   // $FF: synthetic field
   final double field_85101_a;
   // $FF: synthetic field
   final double field_85099_b;
   // $FF: synthetic field
   final double field_85100_c;
   // $FF: synthetic field
   final RenderGlobal field_85098_d;


   CallableParticlePositionInfo(RenderGlobal p_i6801_1_, double p_i6801_2_, double p_i6801_4_, double p_i6801_6_) {
      this.field_85098_d = p_i6801_1_;
      this.field_85101_a = p_i6801_2_;
      this.field_85099_b = p_i6801_4_;
      this.field_85100_c = p_i6801_6_;
   }

   public String func_85097_a() {
      return CrashReportCategory.func_85074_a(this.field_85101_a, this.field_85099_b, this.field_85100_c);
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_85097_a();
   }
}
