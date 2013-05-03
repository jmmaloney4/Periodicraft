package net.minecraft.world;


class GameRuleValue {

   private String field_82762_a;
   private boolean field_82760_b;
   private int field_82761_c;
   private double field_82759_d;


   public GameRuleValue(String p_i5089_1_) {
      this.func_82757_a(p_i5089_1_);
   }

   public void func_82757_a(String p_82757_1_) {
      this.field_82762_a = p_82757_1_;
      this.field_82760_b = Boolean.parseBoolean(p_82757_1_);

      try {
         this.field_82761_c = Integer.parseInt(p_82757_1_);
      } catch (NumberFormatException var4) {
         ;
      }

      try {
         this.field_82759_d = Double.parseDouble(p_82757_1_);
      } catch (NumberFormatException var3) {
         ;
      }

   }

   public String func_82756_a() {
      return this.field_82762_a;
   }

   public boolean func_82758_b() {
      return this.field_82760_b;
   }
}
