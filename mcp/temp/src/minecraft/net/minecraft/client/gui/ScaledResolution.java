package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ScaledResolution {

   private int field_78333_a;
   private int field_78331_b;
   private double field_78332_c;
   private double field_78329_d;
   private int field_78330_e;


   public ScaledResolution(GameSettings p_i3065_1_, int p_i3065_2_, int p_i3065_3_) {
      this.field_78333_a = p_i3065_2_;
      this.field_78331_b = p_i3065_3_;
      this.field_78330_e = 1;
      int var4 = p_i3065_1_.field_74335_Z;
      if(var4 == 0) {
         var4 = 1000;
      }

      while(this.field_78330_e < var4 && this.field_78333_a / (this.field_78330_e + 1) >= 320 && this.field_78331_b / (this.field_78330_e + 1) >= 240) {
         ++this.field_78330_e;
      }

      this.field_78332_c = (double)this.field_78333_a / (double)this.field_78330_e;
      this.field_78329_d = (double)this.field_78331_b / (double)this.field_78330_e;
      this.field_78333_a = MathHelper.func_76143_f(this.field_78332_c);
      this.field_78331_b = MathHelper.func_76143_f(this.field_78329_d);
   }

   public int func_78326_a() {
      return this.field_78333_a;
   }

   public int func_78328_b() {
      return this.field_78331_b;
   }

   public double func_78327_c() {
      return this.field_78332_c;
   }

   public double func_78324_d() {
      return this.field_78329_d;
   }

   public int func_78325_e() {
      return this.field_78330_e;
   }
}
