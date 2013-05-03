package net.minecraft.util;

import net.minecraft.util.AABBPool;

final class AABBLocalPool extends ThreadLocal {

   protected AABBPool func_72341_a() {
      return new AABBPool(300, 2000);
   }

   // $FF: synthetic method
   protected Object initialValue() {
      return this.func_72341_a();
   }
}
