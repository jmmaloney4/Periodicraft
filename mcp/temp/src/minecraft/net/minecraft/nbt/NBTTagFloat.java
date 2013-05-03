package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagFloat extends NBTBase {

   public float field_74750_a;


   public NBTTagFloat(String p_i3268_1_) {
      super(p_i3268_1_);
   }

   public NBTTagFloat(String p_i3269_1_, float p_i3269_2_) {
      super(p_i3269_1_);
      this.field_74750_a = p_i3269_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeFloat(this.field_74750_a);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74750_a = p_74735_1_.readFloat();
   }

   public byte func_74732_a() {
      return (byte)5;
   }

   public String toString() {
      return "" + this.field_74750_a;
   }

   public NBTBase func_74737_b() {
      return new NBTTagFloat(this.func_74740_e(), this.field_74750_a);
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagFloat var2 = (NBTTagFloat)p_equals_1_;
         return this.field_74750_a == var2.field_74750_a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Float.floatToIntBits(this.field_74750_a);
   }
}
