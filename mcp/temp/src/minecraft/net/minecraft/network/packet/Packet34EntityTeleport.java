package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.MathHelper;

public class Packet34EntityTeleport extends Packet {

   public int field_73319_a;
   public int field_73317_b;
   public int field_73318_c;
   public int field_73315_d;
   public byte field_73316_e;
   public byte field_73314_f;


   public Packet34EntityTeleport() {}

   public Packet34EntityTeleport(Entity p_i3359_1_) {
      this.field_73319_a = p_i3359_1_.field_70157_k;
      this.field_73317_b = MathHelper.func_76128_c(p_i3359_1_.field_70165_t * 32.0D);
      this.field_73318_c = MathHelper.func_76128_c(p_i3359_1_.field_70163_u * 32.0D);
      this.field_73315_d = MathHelper.func_76128_c(p_i3359_1_.field_70161_v * 32.0D);
      this.field_73316_e = (byte)((int)(p_i3359_1_.field_70177_z * 256.0F / 360.0F));
      this.field_73314_f = (byte)((int)(p_i3359_1_.field_70125_A * 256.0F / 360.0F));
   }

   public Packet34EntityTeleport(int p_i3360_1_, int p_i3360_2_, int p_i3360_3_, int p_i3360_4_, byte p_i3360_5_, byte p_i3360_6_) {
      this.field_73319_a = p_i3360_1_;
      this.field_73317_b = p_i3360_2_;
      this.field_73318_c = p_i3360_3_;
      this.field_73315_d = p_i3360_4_;
      this.field_73316_e = p_i3360_5_;
      this.field_73314_f = p_i3360_6_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73319_a = p_73267_1_.readInt();
      this.field_73317_b = p_73267_1_.readInt();
      this.field_73318_c = p_73267_1_.readInt();
      this.field_73315_d = p_73267_1_.readInt();
      this.field_73316_e = (byte)p_73267_1_.read();
      this.field_73314_f = (byte)p_73267_1_.read();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73319_a);
      p_73273_1_.writeInt(this.field_73317_b);
      p_73273_1_.writeInt(this.field_73318_c);
      p_73273_1_.writeInt(this.field_73315_d);
      p_73273_1_.write(this.field_73316_e);
      p_73273_1_.write(this.field_73314_f);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72512_a(this);
   }

   public int func_73284_a() {
      return 34;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      Packet34EntityTeleport var2 = (Packet34EntityTeleport)p_73268_1_;
      return var2.field_73319_a == this.field_73319_a;
   }
}
