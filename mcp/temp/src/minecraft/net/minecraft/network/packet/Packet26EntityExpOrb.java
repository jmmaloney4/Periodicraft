package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.MathHelper;

public class Packet26EntityExpOrb extends Packet {

   public int field_73533_a;
   public int field_73531_b;
   public int field_73532_c;
   public int field_73529_d;
   public int field_73530_e;


   public Packet26EntityExpOrb() {}

   public Packet26EntityExpOrb(EntityXPOrb p_i3291_1_) {
      this.field_73533_a = p_i3291_1_.field_70157_k;
      this.field_73531_b = MathHelper.func_76128_c(p_i3291_1_.field_70165_t * 32.0D);
      this.field_73532_c = MathHelper.func_76128_c(p_i3291_1_.field_70163_u * 32.0D);
      this.field_73529_d = MathHelper.func_76128_c(p_i3291_1_.field_70161_v * 32.0D);
      this.field_73530_e = p_i3291_1_.func_70526_d();
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73533_a = p_73267_1_.readInt();
      this.field_73531_b = p_73267_1_.readInt();
      this.field_73532_c = p_73267_1_.readInt();
      this.field_73529_d = p_73267_1_.readInt();
      this.field_73530_e = p_73267_1_.readShort();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73533_a);
      p_73273_1_.writeInt(this.field_73531_b);
      p_73273_1_.writeInt(this.field_73532_c);
      p_73273_1_.writeInt(this.field_73529_d);
      p_73273_1_.writeShort(this.field_73530_e);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72514_a(this);
   }

   public int func_73284_a() {
      return 18;
   }
}
