package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet130UpdateSign extends Packet {

   public int field_73311_a;
   public int field_73309_b;
   public int field_73310_c;
   public String[] field_73308_d;


   public Packet130UpdateSign() {
      this.field_73287_r = true;
   }

   public Packet130UpdateSign(int p_i3357_1_, int p_i3357_2_, int p_i3357_3_, String[] p_i3357_4_) {
      this.field_73287_r = true;
      this.field_73311_a = p_i3357_1_;
      this.field_73309_b = p_i3357_2_;
      this.field_73310_c = p_i3357_3_;
      this.field_73308_d = new String[]{p_i3357_4_[0], p_i3357_4_[1], p_i3357_4_[2], p_i3357_4_[3]};
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73311_a = p_73267_1_.readInt();
      this.field_73309_b = p_73267_1_.readShort();
      this.field_73310_c = p_73267_1_.readInt();
      this.field_73308_d = new String[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_73308_d[var2] = func_73282_a(p_73267_1_, 15);
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73311_a);
      p_73273_1_.writeShort(this.field_73309_b);
      p_73273_1_.writeInt(this.field_73310_c);

      for(int var2 = 0; var2 < 4; ++var2) {
         func_73271_a(this.field_73308_d[var2], p_73273_1_);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72487_a(this);
   }

   public int func_73284_a() {
      int var1 = 0;

      for(int var2 = 0; var2 < 4; ++var2) {
         var1 += this.field_73308_d[var2].length();
      }

      return var1;
   }
}
