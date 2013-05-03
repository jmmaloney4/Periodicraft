package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.Score;

public class Packet207SetScore extends Packet {

   public String field_96488_a = "";
   public String field_96486_b = "";
   public int field_96487_c = 0;
   public int field_96485_d = 0;


   public Packet207SetScore() {}

   public Packet207SetScore(Score p_i10006_1_, int p_i10006_2_) {
      this.field_96488_a = p_i10006_1_.func_96653_e();
      this.field_96486_b = p_i10006_1_.func_96645_d().func_96679_b();
      this.field_96487_c = p_i10006_1_.func_96652_c();
      this.field_96485_d = p_i10006_2_;
   }

   public Packet207SetScore(String p_i10007_1_) {
      this.field_96488_a = p_i10007_1_;
      this.field_96486_b = "";
      this.field_96487_c = 0;
      this.field_96485_d = 1;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_96488_a = func_73282_a(p_73267_1_, 16);
      this.field_96485_d = p_73267_1_.readByte();
      if(this.field_96485_d != 1) {
         this.field_96486_b = func_73282_a(p_73267_1_, 16);
         this.field_96487_c = p_73267_1_.readInt();
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_96488_a, p_73273_1_);
      p_73273_1_.writeByte(this.field_96485_d);
      if(this.field_96485_d != 1) {
         func_73271_a(this.field_96486_b, p_73273_1_);
         p_73273_1_.writeInt(this.field_96487_c);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_96437_a(this);
   }

   public int func_73284_a() {
      return 2 + this.field_96488_a.length() + 2 + this.field_96486_b.length() + 4 + 1;
   }
}
