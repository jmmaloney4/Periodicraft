package net.minecraft.block;


public class StepSound {

   public final String field_72681_a;
   public final float field_72679_b;
   public final float field_72680_c;


   public StepSound(String p_i4008_1_, float p_i4008_2_, float p_i4008_3_) {
      this.field_72681_a = p_i4008_1_;
      this.field_72679_b = p_i4008_2_;
      this.field_72680_c = p_i4008_3_;
   }

   public float func_72677_b() {
      return this.field_72679_b;
   }

   public float func_72678_c() {
      return this.field_72680_c;
   }

   public String func_72676_a() {
      return "dig." + this.field_72681_a;
   }

   public String func_72675_d() {
      return "step." + this.field_72681_a;
   }

   public String func_82593_b() {
      return this.func_72676_a();
   }
}
