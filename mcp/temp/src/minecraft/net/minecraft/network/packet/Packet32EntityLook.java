package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet30Entity;

public class Packet32EntityLook extends Packet30Entity {

   public Packet32EntityLook() {
      this.field_73549_g = true;
   }

   public Packet32EntityLook(int p_i3330_1_, byte p_i3330_2_, byte p_i3330_3_) {
      super(p_i3330_1_);
      this.field_73551_e = p_i3330_2_;
      this.field_73548_f = p_i3330_3_;
      this.field_73549_g = true;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      super.func_73267_a(p_73267_1_);
      this.field_73551_e = p_73267_1_.readByte();
      this.field_73548_f = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      super.func_73273_a(p_73273_1_);
      p_73273_1_.writeByte(this.field_73551_e);
      p_73273_1_.writeByte(this.field_73548_f);
   }

   public int func_73284_a() {
      return 6;
   }
}
