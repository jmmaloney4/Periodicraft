package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet28EntityVelocity extends Packet {

   public int field_73390_a;
   public int field_73388_b;
   public int field_73389_c;
   public int field_73387_d;


   public Packet28EntityVelocity() {}

   public Packet28EntityVelocity(Entity p_i3348_1_) {
      this(p_i3348_1_.field_70157_k, p_i3348_1_.field_70159_w, p_i3348_1_.field_70181_x, p_i3348_1_.field_70179_y);
   }

   public Packet28EntityVelocity(int p_i3349_1_, double p_i3349_2_, double p_i3349_4_, double p_i3349_6_) {
      this.field_73390_a = p_i3349_1_;
      double var8 = 3.9D;
      if(p_i3349_2_ < -var8) {
         p_i3349_2_ = -var8;
      }

      if(p_i3349_4_ < -var8) {
         p_i3349_4_ = -var8;
      }

      if(p_i3349_6_ < -var8) {
         p_i3349_6_ = -var8;
      }

      if(p_i3349_2_ > var8) {
         p_i3349_2_ = var8;
      }

      if(p_i3349_4_ > var8) {
         p_i3349_4_ = var8;
      }

      if(p_i3349_6_ > var8) {
         p_i3349_6_ = var8;
      }

      this.field_73388_b = (int)(p_i3349_2_ * 8000.0D);
      this.field_73389_c = (int)(p_i3349_4_ * 8000.0D);
      this.field_73387_d = (int)(p_i3349_6_ * 8000.0D);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73390_a = p_73267_1_.readInt();
      this.field_73388_b = p_73267_1_.readShort();
      this.field_73389_c = p_73267_1_.readShort();
      this.field_73387_d = p_73267_1_.readShort();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73390_a);
      p_73273_1_.writeShort(this.field_73388_b);
      p_73273_1_.writeShort(this.field_73389_c);
      p_73273_1_.writeShort(this.field_73387_d);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72520_a(this);
   }

   public int func_73284_a() {
      return 10;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      Packet28EntityVelocity var2 = (Packet28EntityVelocity)p_73268_1_;
      return var2.field_73390_a == this.field_73390_a;
   }
}
