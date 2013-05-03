package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.potion.PotionEffect;

public class Packet42RemoveEntityEffect extends Packet {

   public int field_73375_a;
   public byte field_73374_b;


   public Packet42RemoveEntityEffect() {}

   public Packet42RemoveEntityEffect(int p_i3341_1_, PotionEffect p_i3341_2_) {
      this.field_73375_a = p_i3341_1_;
      this.field_73374_b = (byte)(p_i3341_2_.func_76456_a() & 255);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73375_a = p_73267_1_.readInt();
      this.field_73374_b = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73375_a);
      p_73273_1_.writeByte(this.field_73374_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72452_a(this);
   }

   public int func_73284_a() {
      return 5;
   }
}
