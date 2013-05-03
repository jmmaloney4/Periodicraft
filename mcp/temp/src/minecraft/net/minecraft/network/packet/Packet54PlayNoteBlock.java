package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet54PlayNoteBlock extends Packet {

   public int field_73340_a;
   public int field_73338_b;
   public int field_73339_c;
   public int field_73336_d;
   public int field_73337_e;
   public int field_73335_f;


   public Packet54PlayNoteBlock() {}

   public Packet54PlayNoteBlock(int p_i3363_1_, int p_i3363_2_, int p_i3363_3_, int p_i3363_4_, int p_i3363_5_, int p_i3363_6_) {
      this.field_73340_a = p_i3363_1_;
      this.field_73338_b = p_i3363_2_;
      this.field_73339_c = p_i3363_3_;
      this.field_73336_d = p_i3363_5_;
      this.field_73337_e = p_i3363_6_;
      this.field_73335_f = p_i3363_4_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73340_a = p_73267_1_.readInt();
      this.field_73338_b = p_73267_1_.readShort();
      this.field_73339_c = p_73267_1_.readInt();
      this.field_73336_d = p_73267_1_.read();
      this.field_73337_e = p_73267_1_.read();
      this.field_73335_f = p_73267_1_.readShort() & 4095;
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73340_a);
      p_73273_1_.writeShort(this.field_73338_b);
      p_73273_1_.writeInt(this.field_73339_c);
      p_73273_1_.write(this.field_73336_d);
      p_73273_1_.write(this.field_73337_e);
      p_73273_1_.writeShort(this.field_73335_f & 4095);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72454_a(this);
   }

   public int func_73284_a() {
      return 14;
   }
}
