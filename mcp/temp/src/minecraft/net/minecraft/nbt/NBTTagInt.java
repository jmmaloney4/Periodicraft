package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagInt extends NBTBase {

   public int field_74748_a;


   public NBTTagInt(String p_i3272_1_) {
      super(p_i3272_1_);
   }

   public NBTTagInt(String p_i3273_1_, int p_i3273_2_) {
      super(p_i3273_1_);
      this.field_74748_a = p_i3273_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeInt(this.field_74748_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74748_a = p_74735_1_.readInt();
   }

   public byte func_74732_a() {
      return (byte)3;
   }

   public String toString() {
      return "" + this.field_74748_a;
   }

   public NBTBase func_74737_b() {
      return new NBTTagInt(this.func_74740_e(), this.field_74748_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagInt var2 = (NBTTagInt)p_equals_1_;
         return this.field_74748_a == var2.field_74748_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74748_a;
   }
}
