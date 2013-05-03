package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet204ClientInfo extends Packet {

   private String field_73468_a;
   private int field_73466_b;
   private int field_73467_c;
   private boolean field_73464_d;
   private int field_73465_e;
   private boolean field_82564_f;


   public Packet204ClientInfo() {}

   @SideOnly(Side.CLIENT)
   public Packet204ClientInfo(String p_i5031_1_, int p_i5031_2_, int p_i5031_3_, boolean p_i5031_4_, int p_i5031_5_, boolean p_i5031_6_) {
      this.field_73468_a = p_i5031_1_;
      this.field_73466_b = p_i5031_2_;
      this.field_73467_c = p_i5031_3_;
      this.field_73464_d = p_i5031_4_;
      this.field_73465_e = p_i5031_5_;
      this.field_82564_f = p_i5031_6_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73468_a = func_73282_a(p_73267_1_, 7);
      this.field_73466_b = p_73267_1_.readByte();
      byte var2 = p_73267_1_.readByte();
      this.field_73467_c = var2 & 7;
      this.field_73464_d = (var2 & 8) == 8;
      this.field_73465_e = p_73267_1_.readByte();
      this.field_82564_f = p_73267_1_.readBoolean();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_73468_a, p_73273_1_);
      p_73273_1_.writeByte(this.field_73466_b);
      p_73273_1_.writeByte(this.field_73467_c | (this.field_73464_d?1:0) << 3);
      p_73273_1_.writeByte(this.field_73465_e);
      p_73273_1_.writeBoolean(this.field_82564_f);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72504_a(this);
   }

   public int func_73284_a() {
      return 7;
   }

   public String func_73459_d() {
      return this.field_73468_a;
   }

   public int func_73461_f() {
      return this.field_73466_b;
   }

   public int func_73463_g() {
      return this.field_73467_c;
   }

   public boolean func_73460_h() {
      return this.field_73464_d;
   }

   public int func_73462_i() {
      return this.field_73465_e;
   }

   public boolean func_82563_j() {
      return this.field_82564_f;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
