package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;

public class Packet53BlockChange extends Packet {

   public int field_73425_a;
   public int field_73423_b;
   public int field_73424_c;
   public int field_73421_d;
   public int field_73422_e;


   public Packet53BlockChange() {
      this.field_73287_r = true;
   }

   public Packet53BlockChange(int p_i3364_1_, int p_i3364_2_, int p_i3364_3_, World p_i3364_4_) {
      this.field_73287_r = true;
      this.field_73425_a = p_i3364_1_;
      this.field_73423_b = p_i3364_2_;
      this.field_73424_c = p_i3364_3_;
      this.field_73421_d = p_i3364_4_.func_72798_a(p_i3364_1_, p_i3364_2_, p_i3364_3_);
      this.field_73422_e = p_i3364_4_.func_72805_g(p_i3364_1_, p_i3364_2_, p_i3364_3_);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73425_a = p_73267_1_.readInt();
      this.field_73423_b = p_73267_1_.read();
      this.field_73424_c = p_73267_1_.readInt();
      this.field_73421_d = p_73267_1_.readShort();
      this.field_73422_e = p_73267_1_.read();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73425_a);
      p_73273_1_.write(this.field_73423_b);
      p_73273_1_.writeInt(this.field_73424_c);
      p_73273_1_.writeShort(this.field_73421_d);
      p_73273_1_.write(this.field_73422_e);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72456_a(this);
   }

   public int func_73284_a() {
      return 11;
   }
}
