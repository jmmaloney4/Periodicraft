package net.minecraft.profiler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class ProfilerResult implements Comparable {

   public double field_76332_a;
   public double field_76330_b;
   public String field_76331_c;


   public ProfilerResult(String p_i3421_1_, double p_i3421_2_, double p_i3421_4_) {
      this.field_76331_c = p_i3421_1_;
      this.field_76332_a = p_i3421_2_;
      this.field_76330_b = p_i3421_4_;
   }

   public int func_76328_a(ProfilerResult p_76328_1_) {
      return p_76328_1_.field_76332_a < this.field_76332_a?-1:(p_76328_1_.field_76332_a > this.field_76332_a?1:p_76328_1_.field_76331_c.compareTo(this.field_76331_c));
   }

   @SideOnly(Side.CLIENT)
   public int func_76329_a() {
      return (this.field_76331_c.hashCode() & 11184810) + 4473924;
   }

   // $FF: synthetic method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_76328_a((ProfilerResult)p_compareTo_1_);
   }
}
