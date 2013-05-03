package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagByte extends NBTBase {

   public byte field_74756_a;


   public NBTTagByte(String p_i3263_1_) {
      super(p_i3263_1_);
   }

   public NBTTagByte(String p_i3264_1_, byte p_i3264_2_) {
      super(p_i3264_1_);
      this.field_74756_a = p_i3264_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeByte(this.field_74756_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74756_a = p_74735_1_.readByte();
   }

   public byte func_74732_a() {
      return (byte)1;
   }

   public String toString() {
      return "" + this.field_74756_a;
   }

   public NBTBase func_74737_b() {
      return new NBTTagByte(this.func_74740_e(), this.field_74756_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagByte var2 = (NBTTagByte)p_equals_1_;
         return this.field_74756_a == var2.field_74756_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74756_a;
   }
}
