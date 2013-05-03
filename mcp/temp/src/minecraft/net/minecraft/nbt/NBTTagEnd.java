package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;

public class NBTTagEnd extends NBTBase {

   public NBTTagEnd() {
      super((String)null);
   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {}

   void func_74734_a(DataOutput p_74734_1_) throws IOException {}

   public byte func_74732_a() {
      return (byte)0;
   }

   public String toString() {
      return "END";
   }

   public NBTBase func_74737_b() {
      return new NBTTagEnd();
   }
}
