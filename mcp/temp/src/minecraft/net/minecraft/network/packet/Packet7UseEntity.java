package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet7UseEntity extends Packet {

   public int field_73606_a;
   public int field_73604_b;
   public int field_73605_c;


   public Packet7UseEntity() {}

   @SideOnly(Side.CLIENT)
   public Packet7UseEntity(int p_i3321_1_, int p_i3321_2_, int p_i3321_3_) {
      this.field_73606_a = p_i3321_1_;
      this.field_73604_b = p_i3321_2_;
      this.field_73605_c = p_i3321_3_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73606_a = p_73267_1_.readInt();
      this.field_73604_b = p_73267_1_.readInt();
      this.field_73605_c = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73606_a);
      p_73273_1_.writeInt(this.field_73604_b);
      p_73273_1_.writeByte(this.field_73605_c);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72507_a(this);
   }

   public int func_73284_a() {
      return 9;
   }
}
