package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldType;

public class Packet1Login extends Packet {

   public int field_73561_a = 0;
   public WorldType field_73559_b;
   public boolean field_73560_c;
   public EnumGameType field_73557_d;
   public int field_73558_e;
   public byte field_73555_f;
   public byte field_73556_g;
   public byte field_73562_h;


   public Packet1Login() {}

   public Packet1Login(int p_i3327_1_, WorldType p_i3327_2_, EnumGameType p_i3327_3_, boolean p_i3327_4_, int p_i3327_5_, int p_i3327_6_, int p_i3327_7_, int p_i3327_8_) {
      this.field_73561_a = p_i3327_1_;
      this.field_73559_b = p_i3327_2_;
      this.field_73558_e = p_i3327_5_;
      this.field_73555_f = (byte)p_i3327_6_;
      this.field_73557_d = p_i3327_3_;
      this.field_73556_g = (byte)p_i3327_7_;
      this.field_73562_h = (byte)p_i3327_8_;
      this.field_73560_c = p_i3327_4_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73561_a = p_73267_1_.readInt();
      String var2 = func_73282_a(p_73267_1_, 16);
      this.field_73559_b = WorldType.func_77130_a(var2);
      if(this.field_73559_b == null) {
         this.field_73559_b = WorldType.field_77137_b;
      }

      byte var3 = p_73267_1_.readByte();
      this.field_73560_c = (var3 & 8) == 8;
      int var4 = var3 & -9;
      this.field_73557_d = EnumGameType.func_77146_a(var4);
      this.field_73558_e = p_73267_1_.readByte();
      this.field_73555_f = p_73267_1_.readByte();
      this.field_73556_g = p_73267_1_.readByte();
      this.field_73562_h = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73561_a);
      func_73271_a(this.field_73559_b == null?"":this.field_73559_b.func_77127_a(), p_73273_1_);
      int var2 = this.field_73557_d.func_77148_a();
      if(this.field_73560_c) {
         var2 |= 8;
      }

      p_73273_1_.writeByte(var2);
      p_73273_1_.writeByte(this.field_73558_e);
      p_73273_1_.writeByte(this.field_73555_f);
      p_73273_1_.writeByte(this.field_73556_g);
      p_73273_1_.writeByte(this.field_73562_h);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72455_a(this);
   }

   public int func_73284_a() {
      int var1 = 0;
      if(this.field_73559_b != null) {
         var1 = this.field_73559_b.func_77127_a().length();
      }

      return 6 + 2 * var1 + 4 + 4 + 1 + 1 + 1;
   }
}
