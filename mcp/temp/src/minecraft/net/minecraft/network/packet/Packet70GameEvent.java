package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet70GameEvent extends Packet {

   public static final String[] field_73620_a = new String[]{"tile.bed.notValid", null, null, "gameMode.changed"};
   public int field_73618_b;
   public int field_73619_c;


   public Packet70GameEvent() {}

   public Packet70GameEvent(int p_i3320_1_, int p_i3320_2_) {
      this.field_73618_b = p_i3320_1_;
      this.field_73619_c = p_i3320_2_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73618_b = p_73267_1_.readByte();
      this.field_73619_c = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73618_b);
      p_73273_1_.writeByte(this.field_73619_c);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72488_a(this);
   }

   public int func_73284_a() {
      return 2;
   }

}
