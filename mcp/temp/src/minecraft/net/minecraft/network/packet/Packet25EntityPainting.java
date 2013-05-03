package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.EnumArt;

public class Packet25EntityPainting extends Packet {

   public int field_73508_a;
   public int field_73506_b;
   public int field_73507_c;
   public int field_73504_d;
   public int field_73505_e;
   public String field_73503_f;


   public Packet25EntityPainting() {}

   public Packet25EntityPainting(EntityPainting p_i3295_1_) {
      this.field_73508_a = p_i3295_1_.field_70157_k;
      this.field_73506_b = p_i3295_1_.field_70523_b;
      this.field_73507_c = p_i3295_1_.field_70524_c;
      this.field_73504_d = p_i3295_1_.field_70521_d;
      this.field_73505_e = p_i3295_1_.field_82332_a;
      this.field_73503_f = p_i3295_1_.field_70522_e.field_75702_A;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73508_a = p_73267_1_.readInt();
      this.field_73503_f = func_73282_a(p_73267_1_, EnumArt.field_75728_z);
      this.field_73506_b = p_73267_1_.readInt();
      this.field_73507_c = p_73267_1_.readInt();
      this.field_73504_d = p_73267_1_.readInt();
      this.field_73505_e = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73508_a);
      func_73271_a(this.field_73503_f, p_73273_1_);
      p_73273_1_.writeInt(this.field_73506_b);
      p_73273_1_.writeInt(this.field_73507_c);
      p_73273_1_.writeInt(this.field_73504_d);
      p_73273_1_.writeInt(this.field_73505_e);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72495_a(this);
   }

   public int func_73284_a() {
      return 24;
   }
}
