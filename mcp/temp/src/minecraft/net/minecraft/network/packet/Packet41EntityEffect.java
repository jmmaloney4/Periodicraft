package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.potion.PotionEffect;

public class Packet41EntityEffect extends Packet {

   public int field_73420_a;
   public byte field_73418_b;
   public byte field_73419_c;
   public short field_73417_d;


   public Packet41EntityEffect() {}

   public Packet41EntityEffect(int p_i3365_1_, PotionEffect p_i3365_2_) {
      this.field_73420_a = p_i3365_1_;
      this.field_73418_b = (byte)(p_i3365_2_.func_76456_a() & 255);
      this.field_73419_c = (byte)(p_i3365_2_.func_76458_c() & 255);
      if(p_i3365_2_.func_76459_b() > 32767) {
         this.field_73417_d = 32767;
      } else {
         this.field_73417_d = (short)p_i3365_2_.func_76459_b();
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73420_a = p_73267_1_.readInt();
      this.field_73418_b = p_73267_1_.readByte();
      this.field_73419_c = p_73267_1_.readByte();
      this.field_73417_d = p_73267_1_.readShort();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73420_a);
      p_73273_1_.writeByte(this.field_73418_b);
      p_73273_1_.writeByte(this.field_73419_c);
      p_73273_1_.writeShort(this.field_73417_d);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72503_a(this);
   }

   public int func_73284_a() {
      return 8;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_100008_d() {
      return this.field_73417_d == 32767;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      Packet41EntityEffect var2 = (Packet41EntityEffect)p_73268_1_;
      return var2.field_73420_a == this.field_73420_a && var2.field_73418_b == this.field_73418_b;
   }
}
