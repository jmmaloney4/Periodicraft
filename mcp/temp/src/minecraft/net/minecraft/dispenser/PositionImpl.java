package net.minecraft.dispenser;

import net.minecraft.dispenser.IPosition;

public class PositionImpl implements IPosition {

   protected final double field_82630_a;
   protected final double field_82628_b;
   protected final double field_82629_c;


   public PositionImpl(double p_i5028_1_, double p_i5028_3_, double p_i5028_5_) {
      this.field_82630_a = p_i5028_1_;
      this.field_82628_b = p_i5028_3_;
      this.field_82629_c = p_i5028_5_;
   }

   public double func_82615_a() {
      return this.field_82630_a;
   }

   public double func_82617_b() {
      return this.field_82628_b;
   }

   public double func_82616_c() {
      return this.field_82629_c;
   }
}
