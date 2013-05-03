package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet10Flying;

public class Packet11PlayerPosition extends Packet10Flying {

   public Packet11PlayerPosition() {
      this.field_73546_h = true;
   }

   @SideOnly(Side.CLIENT)
   public Packet11PlayerPosition(double p_i3332_1_, double p_i3332_3_, double p_i3332_5_, double p_i3332_7_, boolean p_i3332_9_) {
      this.field_73545_a = p_i3332_1_;
      this.field_73543_b = p_i3332_3_;
      this.field_73541_d = p_i3332_5_;
      this.field_73544_c = p_i3332_7_;
      this.field_73540_g = p_i3332_9_;
      this.field_73546_h = true;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73545_a = p_73267_1_.readDouble();
      this.field_73543_b = p_73267_1_.readDouble();
      this.field_73541_d = p_73267_1_.readDouble();
      this.field_73544_c = p_73267_1_.readDouble();
      super.func_73267_a(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeDouble(this.field_73545_a);
      p_73273_1_.writeDouble(this.field_73543_b);
      p_73273_1_.writeDouble(this.field_73541_d);
      p_73273_1_.writeDouble(this.field_73544_c);
      super.func_73273_a(p_73273_1_);
   }

   public int func_73284_a() {
      return 33;
   }
}
