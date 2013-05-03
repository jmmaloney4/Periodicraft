package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet101CloseWindow extends Packet {

   public int field_73432_a;


   public Packet101CloseWindow() {}

   public Packet101CloseWindow(int p_i3310_1_) {
      this.field_73432_a = p_i3310_1_;
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72474_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73432_a = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73432_a);
   }

   public int func_73284_a() {
      return 1;
   }
}
