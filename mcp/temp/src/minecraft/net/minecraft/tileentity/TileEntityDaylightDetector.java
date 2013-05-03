package net.minecraft.tileentity;

import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDaylightDetector extends TileEntity {

   public void func_70316_g() {
      if(this.field_70331_k != null && !this.field_70331_k.field_72995_K && this.field_70331_k.func_82737_E() % 20L == 0L) {
         this.field_70324_q = this.func_70311_o();
         if(this.field_70324_q != null && this.field_70324_q instanceof BlockDaylightDetector) {
            ((BlockDaylightDetector)this.field_70324_q).func_94444_j_(this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
         }
      }

   }
}
