package net.minecraft.nbt;

import java.util.concurrent.Callable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

class CallableTagCompound2 implements Callable {

   // $FF: synthetic field
   final int field_82588_a;
   // $FF: synthetic field
   final NBTTagCompound field_82587_b;


   CallableTagCompound2(NBTTagCompound p_i5030_1_, int p_i5030_2_) {
      this.field_82587_b = p_i5030_1_;
      this.field_82588_a = p_i5030_2_;
   }

   public String func_82586_a() {
      return NBTBase.field_82578_b[this.field_82588_a];
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_82586_a();
   }
}
