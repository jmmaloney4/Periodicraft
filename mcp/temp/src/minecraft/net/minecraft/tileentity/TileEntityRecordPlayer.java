package net.minecraft.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRecordPlayer extends TileEntity {

   private ItemStack field_70417_a;


   public void func_70307_a(NBTTagCompound p_70307_1_) {
      super.func_70307_a(p_70307_1_);
      if(p_70307_1_.func_74764_b("RecordItem")) {
         this.func_96098_a(ItemStack.func_77949_a(p_70307_1_.func_74775_l("RecordItem")));
      } else if(p_70307_1_.func_74762_e("Record") > 0) {
         this.func_96098_a(new ItemStack(p_70307_1_.func_74762_e("Record"), 1, 0));
      }

   }

   public void func_70310_b(NBTTagCompound p_70310_1_) {
      super.func_70310_b(p_70310_1_);
      if(this.func_96097_a() != null) {
         p_70310_1_.func_74766_a("RecordItem", this.func_96097_a().func_77955_b(new NBTTagCompound()));
         p_70310_1_.func_74768_a("Record", this.func_96097_a().field_77993_c);
      }

   }

   public ItemStack func_96097_a() {
      return this.field_70417_a;
   }

   public void func_96098_a(ItemStack p_96098_1_) {
      this.field_70417_a = p_96098_1_;
      this.func_70296_d();
   }
}
