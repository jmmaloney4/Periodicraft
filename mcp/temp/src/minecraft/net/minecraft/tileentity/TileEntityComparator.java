package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityComparator extends TileEntity {

   private int field_96101_a = 0;


   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      p_70310_1_.func_74768_a("OutputSignal", this.field_96101_a);
   }

   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      this.field_96101_a = p_70307_1_.func_74762_e("OutputSignal");
   }

   public int func_96100_a() {
      return this.field_96101_a;
   }

   public void func_96099_a(int p_96099_1_) {
      this.field_96101_a = p_96099_1_;
   }
}
