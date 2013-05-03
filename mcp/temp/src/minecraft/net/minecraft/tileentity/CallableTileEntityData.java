package net.minecraft.tileentity;

import java.util.concurrent.Callable;
import net.minecraft.tileentity.TileEntity;

class CallableTileEntityData implements Callable {

   // $FF: synthetic field
   final TileEntity field_94612_a;


   CallableTileEntityData(TileEntity p_i9104_1_) {
      this.field_94612_a = p_i9104_1_;
   }

   public String func_94611_a() {
      int var1 = this.field_94612_a.field_70331_k.func_72805_g(this.field_94612_a.field_70329_l, this.field_94612_a.field_70330_m, this.field_94612_a.field_70327_n);
      if(var1 < 0) {
         return "Unknown? (Got " + var1 + ")";
      } else {
         String var2 = String.format("%4s", new Object[]{Integer.toBinaryString(var1)}).replace(" ", "0");
         return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[]{Integer.valueOf(var1), var2});
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_94611_a();
   }
}
