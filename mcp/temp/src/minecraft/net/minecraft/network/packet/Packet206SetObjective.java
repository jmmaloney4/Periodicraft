package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.ScoreObjective;

public class Packet206SetObjective extends Packet {

   public String field_96484_a;
   public String field_96482_b;
   public int field_96483_c;


   public Packet206SetObjective() {}

   public Packet206SetObjective(ScoreObjective p_i10003_1_, int p_i10003_2_) {
      this.field_96484_a = p_i10003_1_.func_96679_b();
      this.field_96482_b = p_i10003_1_.func_96678_d();
      this.field_96483_c = p_i10003_2_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_96484_a = func_73282_a(p_73267_1_, 16);
      this.field_96482_b = func_73282_a(p_73267_1_, 32);
      this.field_96483_c = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_96484_a, p_73273_1_);
      func_73271_a(this.field_96482_b, p_73273_1_);
      p_73273_1_.writeByte(this.field_96483_c);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_96436_a(this);
   }

   public int func_73284_a() {
      return 2 + this.field_96484_a.length() + 2 + this.field_96482_b.length() + 1;
   }
}
