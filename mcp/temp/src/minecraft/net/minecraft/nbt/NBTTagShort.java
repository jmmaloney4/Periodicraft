package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagShort extends NBTBase {

   public short field_74752_a;


   public NBTTagShort(String p_i3277_1_) {
      super(p_i3277_1_);
   }

   public NBTTagShort(String p_i3278_1_, short p_i3278_2_) {
      super(p_i3278_1_);
      this.field_74752_a = p_i3278_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeShort(this.field_74752_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74752_a = p_74735_1_.readShort();
   }

   public byte func_74732_a() {
      return (byte)2;
   }

   public String toString() {
      return "" + this.field_74752_a;
   }

   public NBTBase func_74737_b() {
      return new NBTTagShort(this.func_74740_e(), this.field_74752_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagShort var2 = (NBTTagShort)p_equals_1_;
         return this.field_74752_a == var2.field_74752_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74752_a;
   }
}
