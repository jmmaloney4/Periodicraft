package net.minecraft.nbt;

import java.util.concurrent.Callable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

class CallableTagCompound1 implements Callable {

   // $FF: synthetic field
   final String field_82585_a;
   // $FF: synthetic field
   final NBTTagCompound field_82584_b;


   CallableTagCompound1(NBTTagCompound p_i5029_1_, String p_i5029_2_) {
      this.field_82584_b = p_i5029_1_;
      this.field_82585_a = p_i5029_2_;
   }

   public String func_82583_a() {
      return NBTBase.field_82578_b[((NBTBase)NBTTagCompound.func_82579_a(this.field_82584_b).get(this.field_82585_a)).func_74732_a()];
   }

   // $FF: synthetic method
   public Object call() {
      return this.func_82583_a();
   }
}
