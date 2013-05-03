package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet6SpawnPosition extends Packet {

   public int field_73300_a;
   public int field_73298_b;
   public int field_73299_c;


   public Packet6SpawnPosition() {}

   public Packet6SpawnPosition(int p_i3354_1_, int p_i3354_2_, int p_i3354_3_) {
      this.field_73300_a = p_i3354_1_;
      this.field_73298_b = p_i3354_2_;
      this.field_73299_c = p_i3354_3_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73300_a = p_73267_1_.readInt();
      this.field_73298_b = p_73267_1_.readInt();
      this.field_73299_c = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73300_a);
      p_73273_1_.writeInt(this.field_73298_b);
      p_73273_1_.writeInt(this.field_73299_c);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72466_a(this);
   }

   public int func_73284_a() {
      return 12;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }

   public boolean func_73277_a_() {
      return false;
   }
}
