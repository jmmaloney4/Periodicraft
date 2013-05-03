package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.gui.GuiParticle;

@SideOnly(Side.CLIENT)
public class Particle {

   private static Random field_78080_s = new Random();
   public double field_78071_a;
   public double field_78069_b;
   public double field_78070_c;
   public double field_78067_d;
   public double field_78068_e;
   public double field_78065_f;
   public double field_78066_g;
   public boolean field_78078_h;
   public int field_78079_i;
   public int field_78076_j;
   public double field_78077_k;
   public double field_78074_l;
   public double field_78075_m;
   public double field_78072_n;
   public double field_78073_o;
   public double field_78083_p;
   public double field_78082_q;
   public double field_78081_r;


   public void func_78063_a(GuiParticle p_78063_1_) {
      this.field_78071_a += this.field_78068_e;
      this.field_78069_b += this.field_78065_f;
      this.field_78068_e *= this.field_78066_g;
      this.field_78065_f *= this.field_78066_g;
      this.field_78065_f += 0.1D;
      if(++this.field_78079_i > this.field_78076_j) {
         this.func_78064_b();
      }

      this.field_78072_n = 2.0D - (double)this.field_78079_i / (double)this.field_78076_j * 2.0D;
      if(this.field_78072_n > 1.0D) {
         this.field_78072_n = 1.0D;
      }

      this.field_78072_n *= this.field_78072_n;
      this.field_78072_n *= 0.5D;
   }

   public void func_78062_a() {
      this.field_78073_o = this.field_78077_k;
      this.field_78083_p = this.field_78074_l;
      this.field_78082_q = this.field_78075_m;
      this.field_78081_r = this.field_78072_n;
      this.field_78070_c = this.field_78071_a;
      this.field_78067_d = this.field_78069_b;
   }

   public void func_78064_b() {
      this.field_78078_h = true;
   }

}
