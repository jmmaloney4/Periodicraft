package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet250CustomPayload extends Packet {

   public String field_73630_a;
   public int field_73628_b;
   public byte[] field_73629_c;


   public Packet250CustomPayload() {}

   public Packet250CustomPayload(String p_i3315_1_, byte[] p_i3315_2_) {
      this.field_73630_a = p_i3315_1_;
      this.field_73629_c = p_i3315_2_;
      if(p_i3315_2_ != null) {
         this.field_73628_b = p_i3315_2_.length;
         if(this.field_73628_b > 32767) {
            throw new IllegalArgumentException("Payload may not be larger than 32k");
         }
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73630_a = func_73282_a(p_73267_1_, 20);
      this.field_73628_b = p_73267_1_.readShort();
      if(this.field_73628_b > 0 && this.field_73628_b < 32767) {
         this.field_73629_c = new byte[this.field_73628_b];
         p_73267_1_.readFully(this.field_73629_c);
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_73630_a, p_73273_1_);
      p_73273_1_.writeShort((short)this.field_73628_b);
      if(this.field_73629_c != null) {
         p_73273_1_.write(this.field_73629_c);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72501_a(this);
   }

   public int func_73284_a() {
      return 2 + this.field_73630_a.length() * 2 + 2 + this.field_73628_b;
   }
}
