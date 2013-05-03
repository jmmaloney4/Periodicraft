package net.minecraft.dispenser;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.dispenser.IRegistry;

public class RegistrySimple implements IRegistry {

   protected final Map field_82596_a = new HashMap();


   public Object func_82594_a(Object p_82594_1_) {
      return this.field_82596_a.get(p_82594_1_);
   }

   public void func_82595_a(Object p_82595_1_, Object p_82595_2_) {
      this.field_82596_a.put(p_82595_1_, p_82595_2_);
   }
}
