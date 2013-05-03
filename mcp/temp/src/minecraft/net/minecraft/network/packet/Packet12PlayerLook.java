package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.Packet10Flying;

public class Packet12PlayerLook extends Packet10Flying {

   public Packet12PlayerLook() {
      this.field_73547_i = true;
   }

   @SideOnly(Side.CLIENT)
   public Packet12PlayerLook(float p_i3334_1_, float p_i3334_2_, boolean p_i3334_3_) {
      this.field_73542_e = p_i3334_1_;
      this.field_73539_f = p_i3334_2_;
      this.field_73540_g = p_i3334_3_;
      this.field_73547_i = true;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73542_e = p_73267_1_.readFloat();
      this.field_73539_f = p_73267_1_.readFloat();
      super.func_73267_a(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeFloat(this.field_73542_e);
      p_73273_1_.writeFloat(this.field_73539_f);
      super.func_73273_a(p_73273_1_);
   }

   public int func_73284_a() {
      return 9;
   }
}
