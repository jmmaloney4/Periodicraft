package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet16BlockItemSwitch extends Packet {

   public int field_73386_a;


   public Packet16BlockItemSwitch() {}

   public Packet16BlockItemSwitch(int p_i3345_1_) {
      this.field_73386_a = p_i3345_1_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73386_a = p_73267_1_.readShort();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeShort(this.field_73386_a);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72502_a(this);
   }

   public int func_73284_a() {
      return 2;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
