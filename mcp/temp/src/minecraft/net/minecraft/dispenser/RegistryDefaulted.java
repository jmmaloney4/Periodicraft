package net.minecraft.dispenser;

import net.minecraft.dispenser.RegistrySimple;

public class RegistryDefaulted extends RegistrySimple {

   private final Object field_82597_b;


   public RegistryDefaulted(Object p_i5026_1_) {
      this.field_82597_b = p_i5026_1_;
   }

   public Object func_82594_a(Object p_82594_1_) {
      Object var2 = super.func_82594_a(p_82594_1_);
      return var2 == null?this.field_82597_b:var2;
   }
}
