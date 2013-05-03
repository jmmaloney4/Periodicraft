package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet30Entity extends Packet {

   public int field_73554_a;
   public byte field_73552_b;
   public byte field_73553_c;
   public byte field_73550_d;
   public byte field_73551_e;
   public byte field_73548_f;
   public boolean field_73549_g = false;


   public Packet30Entity() {}

   public Packet30Entity(int p_i3331_1_) {
      this.field_73554_a = p_i3331_1_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73554_a = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73554_a);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72482_a(this);
   }

   public int func_73284_a() {
      return 4;
   }

   public String toString() {
      return "Entity_" + super.toString();
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      Packet30Entity var2 = (Packet30Entity)p_73268_1_;
      return var2.field_73554_a == this.field_73554_a;
   }
}
