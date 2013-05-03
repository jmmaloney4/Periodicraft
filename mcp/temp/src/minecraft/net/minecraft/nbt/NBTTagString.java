package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagString extends NBTBase {

   public String field_74751_a;


   public NBTTagString(String p_i3279_1_) {
      super(p_i3279_1_);
   }

   public NBTTagString(String p_i3280_1_, String p_i3280_2_) {
      super(p_i3280_1_);
      this.field_74751_a = p_i3280_2_;
      if(p_i3280_2_ == null) {
         throw new IllegalArgumentException("Empty string not allowed");
      }
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeUTF(this.field_74751_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74751_a = p_74735_1_.readUTF();
   }

   public byte func_74732_a() {
      return (byte)8;
   }

   public String toString() {
      return "" + this.field_74751_a;
   }

   public NBTBase func_74737_b() {
      return new NBTTagString(this.func_74740_e(), this.field_74751_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(!super.equals(p_equals_1_)) {
         return false;
      } else {
         NBTTagString var2 = (NBTTagString)p_equals_1_;
         return this.field_74751_a == null && var2.field_74751_a == null || this.field_74751_a != null && this.field_74751_a.equals(var2.field_74751_a);
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74751_a.hashCode();
   }
}
