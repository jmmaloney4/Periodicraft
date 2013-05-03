package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet108EnchantItem extends Packet {

   public int field_73446_a;
   public int field_73445_b;


   public Packet108EnchantItem() {}

   @SideOnly(Side.CLIENT)
   public Packet108EnchantItem(int p_i3308_1_, int p_i3308_2_) {
      this.field_73446_a = p_i3308_1_;
      this.field_73445_b = p_i3308_2_;
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72479_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73446_a = p_73267_1_.readByte();
      this.field_73445_b = p_73267_1_.readByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeByte(this.field_73446_a);
      p_73273_1_.writeByte(this.field_73445_b);
   }

   public int func_73284_a() {
      return 2;
   }
}
