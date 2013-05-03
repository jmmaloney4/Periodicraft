package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.nbt.NBTBase;

public class NBTTagIntArray extends NBTBase {

   public int[] field_74749_a;


   public NBTTagIntArray(String p_i3270_1_) {
      super(p_i3270_1_);
   }

   public NBTTagIntArray(String p_i3271_1_, int[] p_i3271_2_) {
      super(p_i3271_1_);
      this.field_74749_a = p_i3271_2_;
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      p_74734_1_.writeInt(this.field_74749_a.length);

      for(int var2 = 0; var2 < this.field_74749_a.length; ++var2) {
         p_74734_1_.writeInt(this.field_74749_a[var2]);
      }

   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      int var2 = p_74735_1_.readInt();
      this.field_74749_a = new int[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_74749_a[var3] = p_74735_1_.readInt();
      }

   }

   public byte func_74732_a() {
      return (byte)11;
   }

   public String toString() {
      return "[" + this.field_74749_a.length + " bytes]";
   }

   public NBTBase func_74737_b() {
      int[] var1 = new int[this.field_74749_a.length];
      System.arraycopy(this.field_74749_a, 0, var1, 0, this.field_74749_a.length);
      return new NBTTagIntArray(this.func_74740_e(), var1);
   }

   public boolean equals(Object p_equals_1_) {
      if(!super.equals(p_equals_1_)) {
         return false;
      } else {
         NBTTagIntArray var2 = (NBTTagIntArray)p_equals_1_;
         return this.field_74749_a == null && var2.field_74749_a == null || this.field_74749_a != null && Arrays.equals(this.field_74749_a, var2.field_74749_a);
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.field_74749_a);
   }
}
