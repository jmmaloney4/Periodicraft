package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.CryptManager;

public class Packet252SharedKey extends Packet {

   private byte[] field_73307_a = new byte[0];
   private byte[] field_73305_b = new byte[0];
   private SecretKey field_73306_c;


   public Packet252SharedKey() {}

   @SideOnly(Side.CLIENT)
   public Packet252SharedKey(SecretKey p_i3356_1_, PublicKey p_i3356_2_, byte[] p_i3356_3_) {
      this.field_73306_c = p_i3356_1_;
      this.field_73307_a = CryptManager.func_75894_a(p_i3356_2_, p_i3356_1_.getEncoded());
      this.field_73305_b = CryptManager.func_75894_a(p_i3356_2_, p_i3356_3_);
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73307_a = func_73280_b(p_73267_1_);
      this.field_73305_b = func_73280_b(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73274_a(p_73273_1_, this.field_73307_a);
      func_73274_a(p_73273_1_, this.field_73305_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72513_a(this);
   }

   public int func_73284_a() {
      return 2 + this.field_73307_a.length + 2 + this.field_73305_b.length;
   }

   public SecretKey func_73303_a(PrivateKey p_73303_1_) {
      return p_73303_1_ == null?this.field_73306_c:(this.field_73306_c = CryptManager.func_75887_a(p_73303_1_, this.field_73307_a));
   }

   public SecretKey func_73304_d() {
      return this.func_73303_a((PrivateKey)null);
   }

   public byte[] func_73302_b(PrivateKey p_73302_1_) {
      return p_73302_1_ == null?this.field_73305_b:CryptManager.func_75889_b(p_73302_1_, this.field_73305_b);
   }
}
