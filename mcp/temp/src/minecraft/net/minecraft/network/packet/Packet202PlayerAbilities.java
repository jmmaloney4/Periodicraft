package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet202PlayerAbilities extends Packet {

   private boolean field_73362_a = false;
   private boolean field_73360_b = false;
   private boolean field_73361_c = false;
   private boolean field_73358_d = false;
   private float field_73359_e;
   private float field_73357_f;


   public Packet202PlayerAbilities() {}

   public Packet202PlayerAbilities(PlayerCapabilities p_i3336_1_) {
      this.func_73353_a(p_i3336_1_.field_75102_a);
      this.func_73349_b(p_i3336_1_.field_75100_b);
      this.func_73354_c(p_i3336_1_.field_75101_c);
      this.func_73356_d(p_i3336_1_.field_75098_d);
      this.func_73351_a(p_i3336_1_.func_75093_a());
      this.func_73355_b(p_i3336_1_.func_75094_b());
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      byte var2 = p_73267_1_.readByte();
      this.func_73353_a((var2 & 1) > 0);
      this.func_73349_b((var2 & 2) > 0);
      this.func_73354_c((var2 & 4) > 0);
      this.func_73356_d((var2 & 8) > 0);
      this.func_73351_a((float)p_73267_1_.readByte() / 255.0F);
      this.func_73355_b((float)p_73267_1_.readByte() / 255.0F);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      byte var2 = 0;
      if(this.func_73352_d()) {
         var2 = (byte)(var2 | 1);
      }

      if(this.func_73350_f()) {
         var2 = (byte)(var2 | 2);
      }

      if(this.func_73348_g()) {
         var2 = (byte)(var2 | 4);
      }

      if(this.func_73346_h()) {
         var2 = (byte)(var2 | 8);
      }

      p_73273_1_.writeByte(var2);
      p_73273_1_.writeByte((int)(this.field_73359_e * 255.0F));
      p_73273_1_.writeByte((int)(this.field_73357_f * 255.0F));
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72471_a(this);
   }

   public int func_73284_a() {
      return 2;
   }

   public boolean func_73352_d() {
      return this.field_73362_a;
   }

   public void func_73353_a(boolean p_73353_1_) {
      this.field_73362_a = p_73353_1_;
   }

   public boolean func_73350_f() {
      return this.field_73360_b;
   }

   public void func_73349_b(boolean p_73349_1_) {
      this.field_73360_b = p_73349_1_;
   }

   public boolean func_73348_g() {
      return this.field_73361_c;
   }

   public void func_73354_c(boolean p_73354_1_) {
      this.field_73361_c = p_73354_1_;
   }

   public boolean func_73346_h() {
      return this.field_73358_d;
   }

   public void func_73356_d(boolean p_73356_1_) {
      this.field_73358_d = p_73356_1_;
   }

   @SideOnly(Side.CLIENT)
   public float func_73347_i() {
      return this.field_73359_e;
   }

   public void func_73351_a(float p_73351_1_) {
      this.field_73359_e = p_73351_1_;
   }

   @SideOnly(Side.CLIENT)
   public float func_82558_j() {
      return this.field_73357_f;
   }

   public void func_73355_b(float p_73355_1_) {
      this.field_73357_f = p_73355_1_;
   }

   public boolean func_73278_e() {
      return true;
   }

   public boolean func_73268_a(Packet p_73268_1_) {
      return true;
   }
}
