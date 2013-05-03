package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet43Experience extends Packet {

   public float field_73396_a;
   public int field_73394_b;
   public int field_73395_c;


   public Packet43Experience() {}

   public Packet43Experience(float p_i3351_1_, int p_i3351_2_, int p_i3351_3_) {
      this.field_73396_a = p_i3351_1_;
      this.field_73394_b = p_i3351_2_;
      this.field_73395_c = p_i3351_3_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73396_a = p_73267_1_.readFloat();
      this.field_73395_c = p_73267_1_.readShort();
      this.field_73394_b = p_73267_1_.readShort();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeFloat(this.field_73396_a);
      p_73273_1_.writeShort(this.field_73395_c);
      p_73273_1_.writeShort(this.field_73394_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72522_a(this);
   }

   public int func_73284_a() {
      return 4;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
