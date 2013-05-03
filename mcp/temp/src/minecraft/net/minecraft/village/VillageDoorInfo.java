package net.minecraft.village;


public class VillageDoorInfo {

   public final int field_75481_a;
   public final int field_75479_b;
   public final int field_75480_c;
   public final int field_75477_d;
   public final int field_75478_e;
   public int field_75475_f;
   public boolean field_75476_g = false;
   private int field_75482_h = 0;


   public VillageDoorInfo(int p_i3509_1_, int p_i3509_2_, int p_i3509_3_, int p_i3509_4_, int p_i3509_5_, int p_i3509_6_) {
      this.field_75481_a = p_i3509_1_;
      this.field_75479_b = p_i3509_2_;
      this.field_75480_c = p_i3509_3_;
      this.field_75477_d = p_i3509_4_;
      this.field_75478_e = p_i3509_5_;
      this.field_75475_f = p_i3509_6_;
   }

   public int func_75474_b(int p_75474_1_, int p_75474_2_, int p_75474_3_) {
      int var4 = p_75474_1_ - this.field_75481_a;
      int var5 = p_75474_2_ - this.field_75479_b;
      int var6 = p_75474_3_ - this.field_75480_c;
      return var4 * var4 + var5 * var5 + var6 * var6;
   }

   public int func_75469_c(int p_75469_1_, int p_75469_2_, int p_75469_3_) {
      int var4 = p_75469_1_ - this.field_75481_a - this.field_75477_d;
      int var5 = p_75469_2_ - this.field_75479_b;
      int var6 = p_75469_3_ - this.field_75480_c - this.field_75478_e;
      return var4 * var4 + var5 * var5 + var6 * var6;
   }

   public int func_75471_a() {
      return this.field_75481_a + this.field_75477_d;
   }

   public int func_75473_b() {
      return this.field_75479_b;
   }

   public int func_75472_c() {
      return this.field_75480_c + this.field_75478_e;
   }

   public boolean func_75467_a(int p_75467_1_, int p_75467_2_) {
      int var3 = p_75467_1_ - this.field_75481_a;
      int var4 = p_75467_2_ - this.field_75480_c;
      return var3 * this.field_75477_d + var4 * this.field_75478_e >= 0;
   }

   public void func_75466_d() {
      this.field_75482_h = 0;
   }

   public void func_75470_e() {
      ++this.field_75482_h;
   }

   public int func_75468_f() {
      return this.field_75482_h;
   }
}
