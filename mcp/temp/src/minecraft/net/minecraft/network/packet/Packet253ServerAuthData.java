package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.PublicKey;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.CryptManager;

public class Packet253ServerAuthData extends Packet {

   private String field_73381_a;
   private PublicKey field_73379_b;
   private byte[] field_73380_c = new byte[0];


   public Packet253ServerAuthData() {}

   public Packet253ServerAuthData(String p_i3344_1_, PublicKey p_i3344_2_, byte[] p_i3344_3_) {
      this.field_73381_a = p_i3344_1_;
      this.field_73379_b = p_i3344_2_;
      this.field_73380_c = p_i3344_3_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73381_a = func_73282_a(p_73267_1_, 20);
      this.field_73379_b = CryptManager.func_75896_a(func_73280_b(p_73267_1_));
      this.field_73380_c = func_73280_b(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_73381_a, p_73273_1_);
      func_73274_a(p_73273_1_, this.field_73379_b.getEncoded());
      func_73274_a(p_73273_1_, this.field_73380_c);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72470_a(this);
   }

   public int func_73284_a() {
      return 2 + this.field_73381_a.length() * 2 + 2 + this.field_73379_b.getEncoded().length + 2 + this.field_73380_c.length;
   }

   @SideOnly(Side.CLIENT)
   public String func_73377_d() {
      return this.field_73381_a;
   }

   @SideOnly(Side.CLIENT)
   public PublicKey func_73376_f() {
      return this.field_73379_b;
   }

   @SideOnly(Side.CLIENT)
   public byte[] func_73378_g() {
      return this.field_73380_c;
   }
}
