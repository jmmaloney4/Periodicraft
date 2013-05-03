package net.minecraft.world.gen.structure;


public class StructureBoundingBox {

   public int field_78897_a;
   public int field_78895_b;
   public int field_78896_c;
   public int field_78893_d;
   public int field_78894_e;
   public int field_78892_f;


   public StructureBoundingBox() {}

   public static StructureBoundingBox func_78887_a() {
      return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
   }

   public static StructureBoundingBox func_78889_a(int p_78889_0_, int p_78889_1_, int p_78889_2_, int p_78889_3_, int p_78889_4_, int p_78889_5_, int p_78889_6_, int p_78889_7_, int p_78889_8_, int p_78889_9_) {
      switch(p_78889_9_) {
      case 0:
         return new StructureBoundingBox(p_78889_0_ + p_78889_3_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_5_, p_78889_0_ + p_78889_6_ - 1 + p_78889_3_, p_78889_1_ + p_78889_7_ - 1 + p_78889_4_, p_78889_2_ + p_78889_8_ - 1 + p_78889_5_);
      case 1:
         return new StructureBoundingBox(p_78889_0_ - p_78889_8_ + 1 + p_78889_5_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_3_, p_78889_0_ + p_78889_5_, p_78889_1_ + p_78889_7_ - 1 + p_78889_4_, p_78889_2_ + p_78889_6_ - 1 + p_78889_3_);
      case 2:
         return new StructureBoundingBox(p_78889_0_ + p_78889_3_, p_78889_1_ + p_78889_4_, p_78889_2_ - p_78889_8_ + 1 + p_78889_5_, p_78889_0_ + p_78889_6_ - 1 + p_78889_3_, p_78889_1_ + p_78889_7_ - 1 + p_78889_4_, p_78889_2_ + p_78889_5_);
      case 3:
         return new StructureBoundingBox(p_78889_0_ + p_78889_5_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_3_, p_78889_0_ + p_78889_8_ - 1 + p_78889_5_, p_78889_1_ + p_78889_7_ - 1 + p_78889_4_, p_78889_2_ + p_78889_6_ - 1 + p_78889_3_);
      default:
         return new StructureBoundingBox(p_78889_0_ + p_78889_3_, p_78889_1_ + p_78889_4_, p_78889_2_ + p_78889_5_, p_78889_0_ + p_78889_6_ - 1 + p_78889_3_, p_78889_1_ + p_78889_7_ - 1 + p_78889_4_, p_78889_2_ + p_78889_8_ - 1 + p_78889_5_);
      }
   }

   public StructureBoundingBox(StructureBoundingBox p_i3804_1_) {
      this.field_78897_a = p_i3804_1_.field_78897_a;
      this.field_78895_b = p_i3804_1_.field_78895_b;
      this.field_78896_c = p_i3804_1_.field_78896_c;
      this.field_78893_d = p_i3804_1_.field_78893_d;
      this.field_78894_e = p_i3804_1_.field_78894_e;
      this.field_78892_f = p_i3804_1_.field_78892_f;
   }

   public StructureBoundingBox(int p_i3805_1_, int p_i3805_2_, int p_i3805_3_, int p_i3805_4_, int p_i3805_5_, int p_i3805_6_) {
      this.field_78897_a = p_i3805_1_;
      this.field_78895_b = p_i3805_2_;
      this.field_78896_c = p_i3805_3_;
      this.field_78893_d = p_i3805_4_;
      this.field_78894_e = p_i3805_5_;
      this.field_78892_f = p_i3805_6_;
   }

   public StructureBoundingBox(int p_i3806_1_, int p_i3806_2_, int p_i3806_3_, int p_i3806_4_) {
      this.field_78897_a = p_i3806_1_;
      this.field_78896_c = p_i3806_2_;
      this.field_78893_d = p_i3806_3_;
      this.field_78892_f = p_i3806_4_;
      this.field_78895_b = 1;
      this.field_78894_e = 512;
   }

   public boolean func_78884_a(StructureBoundingBox p_78884_1_) {
      return this.field_78893_d >= p_78884_1_.field_78897_a && this.field_78897_a <= p_78884_1_.field_78893_d && this.field_78892_f >= p_78884_1_.field_78896_c && this.field_78896_c <= p_78884_1_.field_78892_f && this.field_78894_e >= p_78884_1_.field_78895_b && this.field_78895_b <= p_78884_1_.field_78894_e;
   }

   public boolean func_78885_a(int p_78885_1_, int p_78885_2_, int p_78885_3_, int p_78885_4_) {
      return this.field_78893_d >= p_78885_1_ && this.field_78897_a <= p_78885_3_ && this.field_78892_f >= p_78885_2_ && this.field_78896_c <= p_78885_4_;
   }

   public void func_78888_b(StructureBoundingBox p_78888_1_) {
      this.field_78897_a = Math.min(this.field_78897_a, p_78888_1_.field_78897_a);
      this.field_78895_b = Math.min(this.field_78895_b, p_78888_1_.field_78895_b);
      this.field_78896_c = Math.min(this.field_78896_c, p_78888_1_.field_78896_c);
      this.field_78893_d = Math.max(this.field_78893_d, p_78888_1_.field_78893_d);
      this.field_78894_e = Math.max(this.field_78894_e, p_78888_1_.field_78894_e);
      this.field_78892_f = Math.max(this.field_78892_f, p_78888_1_.field_78892_f);
   }

   public void func_78886_a(int p_78886_1_, int p_78886_2_, int p_78886_3_) {
      this.field_78897_a += p_78886_1_;
      this.field_78895_b += p_78886_2_;
      this.field_78896_c += p_78886_3_;
      this.field_78893_d += p_78886_1_;
      this.field_78894_e += p_78886_2_;
      this.field_78892_f += p_78886_3_;
   }

   public boolean func_78890_b(int p_78890_1_, int p_78890_2_, int p_78890_3_) {
      return p_78890_1_ >= this.field_78897_a && p_78890_1_ <= this.field_78893_d && p_78890_3_ >= this.field_78896_c && p_78890_3_ <= this.field_78892_f && p_78890_2_ >= this.field_78895_b && p_78890_2_ <= this.field_78894_e;
   }

   public int func_78883_b() {
      return this.field_78893_d - this.field_78897_a + 1;
   }

   public int func_78882_c() {
      return this.field_78894_e - this.field_78895_b + 1;
   }

   public int func_78880_d() {
      return this.field_78892_f - this.field_78896_c + 1;
   }

   public int func_78881_e() {
      return this.field_78897_a + (this.field_78893_d - this.field_78897_a + 1) / 2;
   }

   public int func_78879_f() {
      return this.field_78895_b + (this.field_78894_e - this.field_78895_b + 1) / 2;
   }

   public int func_78891_g() {
      return this.field_78896_c + (this.field_78892_f - this.field_78896_c + 1) / 2;
   }

   public String toString() {
      return "(" + this.field_78897_a + ", " + this.field_78895_b + ", " + this.field_78896_c + "; " + this.field_78893_d + ", " + this.field_78894_e + ", " + this.field_78892_f + ")";
   }
}
