package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet15Place extends Packet {

   private int field_73415_a;
   private int field_73413_b;
   private int field_73414_c;
   private int field_73411_d;
   private ItemStack field_73412_e;
   private float field_73409_f;
   private float field_73410_g;
   private float field_73416_h;


   public Packet15Place() {}

   @SideOnly(Side.CLIENT)
   public Packet15Place(int p_i3366_1_, int p_i3366_2_, int p_i3366_3_, int p_i3366_4_, ItemStack p_i3366_5_, float p_i3366_6_, float p_i3366_7_, float p_i3366_8_) {
      this.field_73415_a = p_i3366_1_;
      this.field_73413_b = p_i3366_2_;
      this.field_73414_c = p_i3366_3_;
      this.field_73411_d = p_i3366_4_;
      this.field_73412_e = p_i3366_5_ != null?p_i3366_5_.func_77946_l():null;
      this.field_73409_f = p_i3366_6_;
      this.field_73410_g = p_i3366_7_;
      this.field_73416_h = p_i3366_8_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73415_a = p_73267_1_.readInt();
      this.field_73413_b = p_73267_1_.read();
      this.field_73414_c = p_73267_1_.readInt();
      this.field_73411_d = p_73267_1_.read();
      this.field_73412_e = func_73276_c(p_73267_1_);
      this.field_73409_f = (float)p_73267_1_.read() / 16.0F;
      this.field_73410_g = (float)p_73267_1_.read() / 16.0F;
      this.field_73416_h = (float)p_73267_1_.read() / 16.0F;
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73415_a);
      p_73273_1_.write(this.field_73413_b);
      p_73273_1_.writeInt(this.field_73414_c);
      p_73273_1_.write(this.field_73411_d);
      func_73270_a(this.field_73412_e, p_73273_1_);
      p_73273_1_.write((int)(this.field_73409_f * 16.0F));
      p_73273_1_.write((int)(this.field_73410_g * 16.0F));
      p_73273_1_.write((int)(this.field_73416_h * 16.0F));
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72472_a(this);
   }

   public int func_73284_a() {
      return 19;
   }

   public int func_73403_d() {
      return this.field_73415_a;
   }

   public int func_73402_f() {
      return this.field_73413_b;
   }

   public int func_73407_g() {
      return this.field_73414_c;
   }

   public int func_73401_h() {
      return this.field_73411_d;
   }

   public ItemStack func_73405_i() {
      return this.field_73412_e;
   }

   public float func_73406_j() {
      return this.field_73409_f;
   }

   public float func_73404_l() {
      return this.field_73410_g;
   }

   public float func_73408_m() {
      return this.field_73416_h;
   }
}
