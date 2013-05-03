package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet105UpdateProgressbar extends Packet {

   public int field_73634_a;
   public int field_73632_b;
   public int field_73633_c;


   public Packet105UpdateProgressbar() {}

   public Packet105UpdateProgressbar(int p_i3313_1_, int p_i3313_2_, int p_i3313_3_) {
      this.field_73634_a = p_i3313_1_;
      this.field_73632_b = p_i3313_2_;
      this.field_73633_c = p_i3313_3_;
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72505_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73634_a = p_73267_1_.readByte();
      this.field_73632_b = p_73267_1_.readShort();
      this.field_73633_c = p_73267_1_.readShort();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73634_a);
      p_73273_1_.writeShort(this.field_73632_b);
      p_73273_1_.writeShort(this.field_73633_c);
   }

   public int func_73284_a() {
      return 5;
   }
}
