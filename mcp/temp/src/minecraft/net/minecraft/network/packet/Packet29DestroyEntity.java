package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet29DestroyEntity extends Packet {

   public int[] field_73368_a;


   public Packet29DestroyEntity() {}

   public Packet29DestroyEntity(int ... p_i3340_1_) {
      this.field_73368_a = p_i3340_1_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73368_a = new int[p_73267_1_.readByte()];

      for(int var2 = 0; var2 < this.field_73368_a.length; ++var2) {
         this.field_73368_a[var2] = p_73267_1_.readInt();
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73368_a.length);

      for(int var2 = 0; var2 < this.field_73368_a.length; ++var2) {
         p_73273_1_.writeInt(this.field_73368_a[var2]);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72491_a(this);
   }

   public int func_73284_a() {
      return 1 + this.field_73368_a.length * 4;
   }
}
