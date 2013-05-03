package net.minecraft.entity;


public class WatchableObject {

   private final int field_75678_a;
   private final int field_75676_b;
   private Object field_75677_c;
   private boolean field_75675_d;


   public WatchableObject(int p_i3451_1_, int p_i3451_2_, Object p_i3451_3_) {
      this.field_75676_b = p_i3451_2_;
      this.field_75677_c = p_i3451_3_;
      this.field_75678_a = p_i3451_1_;
      this.field_75675_d = true;
   }

   public int func_75672_a() {
      return this.field_75676_b;
   }

   public void func_75673_a(Object p_75673_1_) {
      this.field_75677_c = p_75673_1_;
   }

   public Object func_75669_b() {
      return this.field_75677_c;
   }

   public int func_75674_c() {
      return this.field_75678_a;
   }

   public boolean func_75670_d() {
      return this.field_75675_d;
   }

   public void func_75671_a(boolean p_75671_1_) {
      this.field_75675_d = p_75671_1_;
   }

   // $FF: synthetic method
   static boolean func_82711_a(WatchableObject p_82711_0_, boolean p_82711_1_) {
      return p_82711_0_.field_75675_d = p_82711_1_;
   }
}
