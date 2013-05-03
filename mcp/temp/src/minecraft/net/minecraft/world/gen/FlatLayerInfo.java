package net.minecraft.world.gen;


public class FlatLayerInfo {

   private int field_82664_a;
   private int field_82662_b;
   private int field_82663_c;
   private int field_82661_d;


   public FlatLayerInfo(int p_i5091_1_, int p_i5091_2_) {
      this.field_82664_a = 1;
      this.field_82662_b = 0;
      this.field_82663_c = 0;
      this.field_82661_d = 0;
      this.field_82664_a = p_i5091_1_;
      this.field_82662_b = p_i5091_2_;
   }

   public FlatLayerInfo(int p_i5092_1_, int p_i5092_2_, int p_i5092_3_) {
      this(p_i5092_1_, p_i5092_2_);
      this.field_82663_c = p_i5092_3_;
   }

   public int func_82657_a() {
      return this.field_82664_a;
   }

   public int func_82659_b() {
      return this.field_82662_b;
   }

   public int func_82658_c() {
      return this.field_82663_c;
   }

   public int func_82656_d() {
      return this.field_82661_d;
   }

   public void func_82660_d(int p_82660_1_) {
      this.field_82661_d = p_82660_1_;
   }

   public String toString() {
      String var1 = Integer.toString(this.field_82662_b);
      if(this.field_82664_a > 1) {
         var1 = this.field_82664_a + "x" + var1;
      }

      if(this.field_82663_c > 0) {
         var1 = var1 + ":" + this.field_82663_c;
      }

      return var1;
   }
}
