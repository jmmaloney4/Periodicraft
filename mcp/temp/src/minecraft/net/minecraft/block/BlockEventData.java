package net.minecraft.block;


public class BlockEventData {

   private int field_76927_a;
   private int field_76925_b;
   private int field_76926_c;
   private int field_76923_d;
   private int field_76924_e;
   private int field_76922_f;


   public BlockEventData(int p_i3742_1_, int p_i3742_2_, int p_i3742_3_, int p_i3742_4_, int p_i3742_5_, int p_i3742_6_) {
      this.field_76927_a = p_i3742_1_;
      this.field_76925_b = p_i3742_2_;
      this.field_76926_c = p_i3742_3_;
      this.field_76924_e = p_i3742_5_;
      this.field_76922_f = p_i3742_6_;
      this.field_76923_d = p_i3742_4_;
   }

   public int func_76919_a() {
      return this.field_76927_a;
   }

   public int func_76921_b() {
      return this.field_76925_b;
   }

   public int func_76920_c() {
      return this.field_76926_c;
   }

   public int func_76918_d() {
      return this.field_76924_e;
   }

   public int func_76917_e() {
      return this.field_76922_f;
   }

   public int func_76916_f() {
      return this.field_76923_d;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof BlockEventData)) {
         return false;
      } else {
         BlockEventData var2 = (BlockEventData)p_equals_1_;
         return this.field_76927_a == var2.field_76927_a && this.field_76925_b == var2.field_76925_b && this.field_76926_c == var2.field_76926_c && this.field_76924_e == var2.field_76924_e && this.field_76922_f == var2.field_76922_f && this.field_76923_d == var2.field_76923_d;
      }
   }

   public String toString() {
      return "TE(" + this.field_76927_a + "," + this.field_76925_b + "," + this.field_76926_c + ")," + this.field_76924_e + "," + this.field_76922_f + "," + this.field_76923_d;
   }
}
