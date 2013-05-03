package net.minecraft.tileentity;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

class CallableTileEntityID implements Callable {

   // $FF: synthetic field
   final TileEntity field_94610_a;


   CallableTileEntityID(TileEntity p_i9103_1_) {
      this.field_94610_a = p_i9103_1_;
   }

   public String func_94609_a() {
      int var1 = this.field_94610_a.field_70331_k.func_72798_a(this.field_94610_a.field_70329_l, this.field_94610_a.field_70330_m, this.field_94610_a.field_70327_n);

      try {
         return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(var1), Block.field_71973_m[var1].func_71917_a(), Block.field_71973_m[var1].getClass().getCanonicalName()});
      } catch (Throwable var3) {
         return "ID #" + var1;
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_94609_a();
   }
}
