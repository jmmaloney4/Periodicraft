package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet38EntityStatus extends Packet {

   public int field_73627_a;
   public byte field_73626_b;


   public Packet38EntityStatus() {}

   public Packet38EntityStatus(int p_i3318_1_, byte p_i3318_2_) {
      this.field_73627_a = p_i3318_1_;
      this.field_73626_b = p_i3318_2_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73627_a = p_73267_1_.readInt();
      this.field_73626_b = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73627_a);
      p_73273_1_.writeByte(this.field_73626_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72485_a(this);
   }

   public int func_73284_a() {
      return 5;
   }
}
