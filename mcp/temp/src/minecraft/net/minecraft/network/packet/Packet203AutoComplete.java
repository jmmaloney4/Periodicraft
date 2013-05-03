package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet3Chat;

public class Packet203AutoComplete extends Packet {

   private String field_73474_a;


   public Packet203AutoComplete() {}

   public Packet203AutoComplete(String p_i3299_1_) {
      this.field_73474_a = p_i3299_1_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73474_a = func_73282_a(p_73267_1_, Packet3Chat.field_73478_a);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_73474_a, p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72461_a(this);
   }

   public int func_73284_a() {
      return 2 + this.field_73474_a.length() * 2;
   }

   public String func_73473_d() {
      return this.field_73474_a;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
