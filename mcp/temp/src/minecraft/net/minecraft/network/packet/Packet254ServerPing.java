package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet254ServerPing extends Packet {

   public int field_82559_a = 0;


   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      try {
         this.field_82559_a = p_73267_1_.readByte();
      } catch (Throwable var3) {
         this.field_82559_a = 0;
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {}

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72467_a(this);
   }

   public int func_73284_a() {
      return 0;
   }
}
