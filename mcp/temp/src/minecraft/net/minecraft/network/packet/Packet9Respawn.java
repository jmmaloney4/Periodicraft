package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldType;

public class Packet9Respawn extends Packet {

   public int field_73373_a;
   public int field_73371_b;
   public int field_73372_c;
   public EnumGameType field_73369_d;
   public WorldType field_73370_e;


   public Packet9Respawn() {}

   public Packet9Respawn(int p_i3342_1_, byte p_i3342_2_, WorldType p_i3342_3_, int p_i3342_4_, EnumGameType p_i3342_5_) {
      this.field_73373_a = p_i3342_1_;
      this.field_73371_b = p_i3342_2_;
      this.field_73372_c = p_i3342_4_;
      this.field_73369_d = p_i3342_5_;
      this.field_73370_e = p_i3342_3_;
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72483_a(this);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73373_a = p_73267_1_.readInt();
      this.field_73371_b = p_73267_1_.readByte();
      this.field_73369_d = EnumGameType.func_77146_a(p_73267_1_.readByte());
      this.field_73372_c = p_73267_1_.readShort();
      String var2 = func_73282_a(p_73267_1_, 16);
      this.field_73370_e = WorldType.func_77130_a(var2);
      if(this.field_73370_e == null) {
         this.field_73370_e = WorldType.field_77137_b;
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73373_a);
      p_73273_1_.writeByte(this.field_73371_b);
      p_73273_1_.writeByte(this.field_73369_d.func_77148_a());
      p_73273_1_.writeShort(this.field_73372_c);
      func_73271_a(this.field_73370_e.func_77127_a(), p_73273_1_);
   }

   public int func_73284_a() {
      return 8 + (this.field_73370_e == null?0:this.field_73370_e.func_77127_a().length());
   }
}
