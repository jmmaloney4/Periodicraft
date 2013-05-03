package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet39AttachEntity extends Packet {

   public int field_73297_a;
   public int field_73296_b;


   public Packet39AttachEntity() {}

   public Packet39AttachEntity(Entity p_i3353_1_, Entity p_i3353_2_) {
      this.field_73297_a = p_i3353_1_.field_70157_k;
      this.field_73296_b = p_i3353_2_ != null?p_i3353_2_.field_70157_k:-1;
   }

   public int func_73284_a() {
      return 8;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73297_a = p_73267_1_.readInt();
      this.field_73296_b = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73297_a);
      p_73273_1_.writeInt(this.field_73296_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72484_a(this);
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      Packet39AttachEntity var2 = (Packet39AttachEntity)p_73268_1_;
      return var2.field_73297_a == this.field_73297_a;
   }
}
