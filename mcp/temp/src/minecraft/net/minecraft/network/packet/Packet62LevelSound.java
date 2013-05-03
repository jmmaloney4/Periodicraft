package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet62LevelSound extends Packet {

   private String field_73579_a;
   private int field_73577_b;
   private int field_73578_c = Integer.MAX_VALUE;
   private int field_73575_d;
   private float field_73576_e;
   private int field_73574_f;


   public Packet62LevelSound() {}

   public Packet62LevelSound(String p_i3326_1_, double p_i3326_2_, double p_i3326_4_, double p_i3326_6_, float p_i3326_8_, float p_i3326_9_) {
      this.field_73579_a = p_i3326_1_;
      this.field_73577_b = (int)(p_i3326_2_ * 8.0D);
      this.field_73578_c = (int)(p_i3326_4_ * 8.0D);
      this.field_73575_d = (int)(p_i3326_6_ * 8.0D);
      this.field_73576_e = p_i3326_8_;
      this.field_73574_f = (int)(p_i3326_9_ * 63.0F);
      if(this.field_73574_f < 0) {
         this.field_73574_f = 0;
      }

      if(this.field_73574_f > 255) {
         this.field_73574_f = 255;
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73579_a = func_73282_a(p_73267_1_, 32);
      this.field_73577_b = p_73267_1_.readInt();
      this.field_73578_c = p_73267_1_.readInt();
      this.field_73575_d = p_73267_1_.readInt();
      this.field_73576_e = p_73267_1_.readFloat();
      this.field_73574_f = p_73267_1_.readUnsignedByte();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_73579_a, p_73273_1_);
      p_73273_1_.writeInt(this.field_73577_b);
      p_73273_1_.writeInt(this.field_73578_c);
      p_73273_1_.writeInt(this.field_73575_d);
      p_73273_1_.writeFloat(this.field_73576_e);
      p_73273_1_.writeByte(this.field_73574_f);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72457_a(this);
   }

   public int func_73284_a() {
      return 24;
   }

   @SideOnly(Side.CLIENT)
   public String func_73570_d() {
      return this.field_73579_a;
   }

   @SideOnly(Side.CLIENT)
   public double func_73572_f() {
      return (double)((float)this.field_73577_b / 8.0F);
   }

   @SideOnly(Side.CLIENT)
   public double func_73568_g() {
      return (double)((float)this.field_73578_c / 8.0F);
   }

   @SideOnly(Side.CLIENT)
   public double func_73569_h() {
      return (double)((float)this.field_73575_d / 8.0F);
   }

   @SideOnly(Side.CLIENT)
   public float func_73571_i() {
      return this.field_73576_e;
   }

   @SideOnly(Side.CLIENT)
   public float func_73573_j() {
      return (float)this.field_73574_f / 63.0F;
   }
}
