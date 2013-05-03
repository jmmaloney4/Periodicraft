package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet14BlockDig extends Packet {

   public int field_73345_a;
   public int field_73343_b;
   public int field_73344_c;
   public int field_73341_d;
   public int field_73342_e;


   public Packet14BlockDig() {}

   @SideOnly(Side.CLIENT)
   public Packet14BlockDig(int p_i3337_1_, int p_i3337_2_, int p_i3337_3_, int p_i3337_4_, int p_i3337_5_) {
      this.field_73342_e = p_i3337_1_;
      this.field_73345_a = p_i3337_2_;
      this.field_73343_b = p_i3337_3_;
      this.field_73344_c = p_i3337_4_;
      this.field_73341_d = p_i3337_5_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73342_e = p_73267_1_.read();
      this.field_73345_a = p_73267_1_.readInt();
      this.field_73343_b = p_73267_1_.read();
      this.field_73344_c = p_73267_1_.readInt();
      this.field_73341_d = p_73267_1_.read();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.write(this.field_73342_e);
      p_73273_1_.writeInt(this.field_73345_a);
      p_73273_1_.write(this.field_73343_b);
      p_73273_1_.writeInt(this.field_73344_c);
      p_73273_1_.write(this.field_73341_d);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72510_a(this);
   }

   public int func_73284_a() {
      return 11;
   }
}
