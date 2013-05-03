package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.nbt.NBTBase;

public class NBTTagByteArray extends NBTBase {

   public byte[] field_74754_a;


   public NBTTagByteArray(String p_i3261_1_) {
      super(p_i3261_1_);
   }

   public NBTTagByteArray(String p_i3262_1_, byte[] p_i3262_2_) {
      super(p_i3262_1_);
      this.field_74754_a = p_i3262_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeInt(this.field_74754_a.length);
      p_74734_1_.write(this.field_74754_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      int var2 = p_74735_1_.readInt();
      this.field_74754_a = new byte[var2];
      p_74735_1_.readFully(this.field_74754_a);
   }

   public byte func_74732_a() {
      return (byte)7;
   }

   public String toString() {
      return "[" + this.field_74754_a.length + " bytes]";
   }

   public NBTBase func_74737_b() {
      byte[] var1 = new byte[this.field_74754_a.length];
      System.arraycopy(this.field_74754_a, 0, var1, 0, this.field_74754_a.length);
      return new NBTTagByteArray(this.func_74740_e(), var1);
   }

   public boolean equals(Object p_equals_1_) {
      return super.equals(p_equals_1_)?Arrays.equals(this.field_74754_a, ((NBTTagByteArray)p_equals_1_).field_74754_a):false;
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.field_74754_a);
   }
}
