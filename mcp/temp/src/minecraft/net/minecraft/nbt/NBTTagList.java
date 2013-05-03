package net.minecraft.nbt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.nbt.NBTBase;

public class NBTTagList extends NBTBase {

   private List field_74747_a = new ArrayList();
   private byte field_74746_b;


   public NBTTagList() {
      super("");
   }

   public NBTTagList(String p_i3274_1_) {
      super(p_i3274_1_);
   }

   void func_74734_a(DataOutput p_74734_1_) throws IOException {
      if(!this.field_74747_a.isEmpty()) {
         this.field_74746_b = ((NBTBase)this.field_74747_a.get(0)).func_74732_a();
      } else {
         this.field_74746_b = 1;
      }

      p_74734_1_.writeByte(this.field_74746_b);
      p_74734_1_.writeInt(this.field_74747_a.size());

      for(int var2 = 0; var2 < this.field_74747_a.size(); ++var2) {
         ((NBTBase)this.field_74747_a.get(var2)).func_74734_a(p_74734_1_);
      }

   }

   void func_74735_a(DataInput p_74735_1_) throws IOException {
      this.field_74746_b = p_74735_1_.readByte();
      int var2 = p_74735_1_.readInt();
      this.field_74747_a = new ArrayList();

      for(int var3 = 0; var3 < var2; ++var3) {
         NBTBase var4 = NBTBase.func_74733_a(this.field_74746_b, (String)null);
         var4.func_74735_a(p_74735_1_);
         this.field_74747_a.add(var4);
      }

   }

   public byte func_74732_a() {
      return (byte)9;
   }

   public String toString() {
      return "" + this.field_74747_a.size() + " entries of type " + NBTBase.func_74736_a(this.field_74746_b);
   }

   public void func_74742_a(NBTBase p_74742_1_) {
      this.field_74746_b = p_74742_1_.func_74732_a();
      this.field_74747_a.add(p_74742_1_);
   }

   @SideOnly(Side.CLIENT)
   public NBTBase func_74744_a(int p_74744_1_) {
      return (NBTBase)this.field_74747_a.remove(p_74744_1_);
   }

   public NBTBase func_74743_b(int p_74743_1_) {
      return (NBTBase)this.field_74747_a.get(p_74743_1_);
   }

   public int func_74745_c() {
      return this.field_74747_a.size();
   }

   public NBTBase func_74737_b() {
      NBTTagList var1 = new NBTTagList(this.func_74740_e());
      var1.field_74746_b = this.field_74746_b;
      Iterator var2 = this.field_74747_a.iterator();

      while(var2.hasNext()) {
         NBTBase var3 = (NBTBase)var2.next();
         NBTBase var4 = var3.func_74737_b();
         var1.field_74747_a.add(var4);
      }

      return var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(super.equals(p_equals_1_)) {
         NBTTagList var2 = (NBTTagList)p_equals_1_;
         if(this.field_74746_b == var2.field_74746_b) {
            return this.field_74747_a.equals(var2.field_74747_a);
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() ^ this.field_74747_a.hashCode();
   }
}
