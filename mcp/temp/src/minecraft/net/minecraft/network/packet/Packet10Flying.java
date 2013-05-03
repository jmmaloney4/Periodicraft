package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet10Flying extends Packet {

   public double field_73545_a;
   public double field_73543_b;
   public double field_73544_c;
   public double field_73541_d;
   public float field_73542_e;
   public float field_73539_f;
   public boolean field_73540_g;
   public boolean field_73546_h;
   public boolean field_73547_i;


   public Packet10Flying() {}

   @SideOnly(Side.CLIENT)
   public Packet10Flying(boolean p_i3335_1_) {
      this.field_73540_g = p_i3335_1_;
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72498_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73540_g = p_73267_1_.read() != 0;
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.write(this.field_73540_g?1:0);
   }

   public int func_73284_a() {
      return 1;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
