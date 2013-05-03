package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet131MapData extends Packet {

   public short field_73438_a;
   public short field_73436_b;
   public byte[] field_73437_c;


   public Packet131MapData() {
      this.field_73287_r = true;
   }

   public Packet131MapData(short p_i3306_1_, short p_i3306_2_, byte[] p_i3306_3_) {
      this.field_73287_r = true;
      this.field_73438_a = p_i3306_1_;
      this.field_73436_b = p_i3306_2_;
      this.field_73437_c = p_i3306_3_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73438_a = p_73267_1_.readShort();
      this.field_73436_b = p_73267_1_.readShort();
      this.field_73437_c = new byte[p_73267_1_.readUnsignedShort()];
      p_73267_1_.readFully(this.field_73437_c);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeShort(this.field_73438_a);
      p_73273_1_.writeShort(this.field_73436_b);
      p_73273_1_.writeShort(this.field_73437_c.length);
      p_73273_1_.write(this.field_73437_c);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72494_a(this);
   }

   public int func_73284_a() {
      return 4 + this.field_73437_c.length;
   }
}
