package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet63WorldParticles extends Packet {

   private String field_98209_a;
   private float field_98207_b;
   private float field_98208_c;
   private float field_98205_d;
   private float field_98206_e;
   private float field_98203_f;
   private float field_98204_g;
   private float field_98210_h;
   private int field_98211_i;


   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_98209_a = func_73282_a(p_73267_1_, 64);
      this.field_98207_b = p_73267_1_.readFloat();
      this.field_98208_c = p_73267_1_.readFloat();
      this.field_98205_d = p_73267_1_.readFloat();
      this.field_98206_e = p_73267_1_.readFloat();
      this.field_98203_f = p_73267_1_.readFloat();
      this.field_98204_g = p_73267_1_.readFloat();
      this.field_98210_h = p_73267_1_.readFloat();
      this.field_98211_i = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_98209_a, p_73273_1_);
      p_73273_1_.writeFloat(this.field_98207_b);
      p_73273_1_.writeFloat(this.field_98208_c);
      p_73273_1_.writeFloat(this.field_98205_d);
      p_73273_1_.writeFloat(this.field_98206_e);
      p_73273_1_.writeFloat(this.field_98203_f);
      p_73273_1_.writeFloat(this.field_98204_g);
      p_73273_1_.writeFloat(this.field_98210_h);
      p_73273_1_.writeInt(this.field_98211_i);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_98182_a(this);
   }

   public int func_73284_a() {
      return 64;
   }

   @SideOnly(Side.CLIENT)
   public String func_98195_d() {
      return this.field_98209_a;
   }

   @SideOnly(Side.CLIENT)
   public double func_98200_f() {
      return (double)this.field_98207_b;
   }

   @SideOnly(Side.CLIENT)
   public double func_98194_g() {
      return (double)this.field_98208_c;
   }

   @SideOnly(Side.CLIENT)
   public double func_98198_h() {
      return (double)this.field_98205_d;
   }

   @SideOnly(Side.CLIENT)
   public float func_98196_i() {
      return this.field_98206_e;
   }

   @SideOnly(Side.CLIENT)
   public float func_98201_j() {
      return this.field_98203_f;
   }

   @SideOnly(Side.CLIENT)
   public float func_98199_k() {
      return this.field_98204_g;
   }

   @SideOnly(Side.CLIENT)
   public float func_98197_l() {
      return this.field_98210_h;
   }

   @SideOnly(Side.CLIENT)
   public int func_98202_m() {
      return this.field_98211_i;
   }
}
