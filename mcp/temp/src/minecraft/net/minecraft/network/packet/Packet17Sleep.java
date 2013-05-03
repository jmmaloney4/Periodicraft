package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet17Sleep extends Packet {

   public int field_73625_a;
   public int field_73623_b;
   public int field_73624_c;
   public int field_73621_d;
   public int field_73622_e;


   public Packet17Sleep() {}

   public Packet17Sleep(Entity p_i3317_1_, int p_i3317_2_, int p_i3317_3_, int p_i3317_4_, int p_i3317_5_) {
      this.field_73622_e = p_i3317_2_;
      this.field_73623_b = p_i3317_3_;
      this.field_73624_c = p_i3317_4_;
      this.field_73621_d = p_i3317_5_;
      this.field_73625_a = p_i3317_1_.field_70157_k;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73625_a = p_73267_1_.readInt();
      this.field_73622_e = p_73267_1_.readByte();
      this.field_73623_b = p_73267_1_.readInt();
      this.field_73624_c = p_73267_1_.readByte();
      this.field_73621_d = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73625_a);
      p_73273_1_.writeByte(this.field_73622_e);
      p_73273_1_.writeInt(this.field_73623_b);
      p_73273_1_.writeByte(this.field_73624_c);
      p_73273_1_.writeInt(this.field_73621_d);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72460_a(this);
   }

   public int func_73284_a() {
      return 14;
   }
}
