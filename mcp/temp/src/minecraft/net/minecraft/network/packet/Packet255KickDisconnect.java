package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet255KickDisconnect extends Packet {

   public String field_73631_a;


   public Packet255KickDisconnect() {}

   public Packet255KickDisconnect(String p_i3316_1_) {
      this.field_73631_a = p_i3316_1_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73631_a = func_73282_a(p_73267_1_, 256);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_73631_a, p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72492_a(this);
   }

   public int func_73284_a() {
      return this.field_73631_a.length();
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
