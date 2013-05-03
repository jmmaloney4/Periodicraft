package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Icon;

@SideOnly(Side.CLIENT)
public class IconFlipped implements Icon {

   private final Icon field_96454_a;
   private final boolean field_96452_b;
   private final boolean field_96453_c;


   public IconFlipped(Icon p_i10047_1_, boolean p_i10047_2_, boolean p_i10047_3_) {
      this.field_96454_a = p_i10047_1_;
      this.field_96452_b = p_i10047_2_;
      this.field_96453_c = p_i10047_3_;
   }

   public int func_94211_a() {
      return this.field_96454_a.func_94211_a();
   }

   public int func_94216_b() {
      return this.field_96454_a.func_94216_b();
   }

   public float func_94209_e() {
      return this.field_96452_b?this.field_96454_a.func_94212_f():this.field_96454_a.func_94209_e();
   }

   public float func_94212_f() {
      return this.field_96452_b?this.field_96454_a.func_94209_e():this.field_96454_a.func_94212_f();
   }

   public float func_94214_a(double p_94214_1_) {
      float var3 = this.func_94212_f() - this.func_94209_e();
      return this.func_94209_e() + var3 * ((float)p_94214_1_ / 16.0F);
   }

   public float func_94206_g() {
      return this.field_96453_c?this.field_96454_a.func_94206_g():this.field_96454_a.func_94206_g();
   }

   public float func_94210_h() {
      return this.field_96453_c?this.field_96454_a.func_94206_g():this.field_96454_a.func_94210_h();
   }

   public float func_94207_b(double p_94207_1_) {
      float var3 = this.func_94210_h() - this.func_94206_g();
      return this.func_94206_g() + var3 * ((float)p_94207_1_ / 16.0F);
   }

   public String func_94215_i() {
      return this.field_96454_a.func_94215_i();
   }

   public int func_94213_j() {
      return this.field_96454_a.func_94213_j();
   }

   public int func_94208_k() {
      return this.field_96454_a.func_94208_k();
   }
}
