package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagLong extends NBTBase {

   public long field_74753_a;


   public NBTTagLong(String p_i3275_1_) {
      super(p_i3275_1_);
   }

   public NBTTagLong(String p_i3276_1_, long p_i3276_2_) {
      super(p_i3276_1_);
      this.field_74753_a = p_i3276_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeLong(this.field_74753_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74753_a = p_74735_1_.readLong();
   }

   public byte func_74732_a() {
      return (byte)4;
   }

   public String toString() {
      return "" + this.field_74753_a;
   }

   public NBTBase func_74737_b() {
      return new NBTTagLong(this.func_74740_e(), this.field_74753_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagLong var2 = (NBTTagLong)p_equals_1_;
         return this.field_74753_a == var2.field_74753_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ (int)(this.field_74753_a ^ this.field_74753_a >>> 32);
   }
}
