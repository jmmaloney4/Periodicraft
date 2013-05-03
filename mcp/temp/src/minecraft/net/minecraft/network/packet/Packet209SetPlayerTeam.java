package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.scoreboard.ScorePlayerTeam;

public class Packet209SetPlayerTeam extends Packet {

   public String field_96495_a = "";
   public String field_96493_b = "";
   public String field_96494_c = "";
   public String field_96491_d = "";
   public Collection field_96492_e = new ArrayList();
   public int field_96489_f = 0;
   public int field_98212_g;


   public Packet209SetPlayerTeam() {}

   public Packet209SetPlayerTeam(ScorePlayerTeam p_i10004_1_, int p_i10004_2_) {
      this.field_96495_a = p_i10004_1_.func_96661_b();
      this.field_96489_f = p_i10004_2_;
      if(p_i10004_2_ == 0 || p_i10004_2_ == 2) {
         this.field_96493_b = p_i10004_1_.func_96669_c();
         this.field_96494_c = p_i10004_1_.func_96668_e();
         this.field_96491_d = p_i10004_1_.func_96663_f();
         this.field_98212_g = p_i10004_1_.func_98299_i();
      }

      if(p_i10004_2_ == 0) {
         this.field_96492_e.addAll(p_i10004_1_.func_96670_d());
      }

   }

   public Packet209SetPlayerTeam(ScorePlayerTeam p_i10005_1_, Collection p_i10005_2_, int p_i10005_3_) {
      if(p_i10005_3_ != 3 && p_i10005_3_ != 4) {
         throw new IllegalArgumentException("Method must be join or leave for player constructor");
      } else if(p_i10005_2_ != null && !p_i10005_2_.isEmpty()) {
         this.field_96489_f = p_i10005_3_;
         this.field_96495_a = p_i10005_1_.func_96661_b();
         this.field_96492_e.addAll(p_i10005_2_);
      } else {
         throw new IllegalArgumentException("Players cannot be null/empty");
      }
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_96495_a = func_73282_a(p_73267_1_, 16);
      this.field_96489_f = p_73267_1_.readByte();
      if(this.field_96489_f == 0 || this.field_96489_f == 2) {
         this.field_96493_b = func_73282_a(p_73267_1_, 32);
         this.field_96494_c = func_73282_a(p_73267_1_, 16);
         this.field_96491_d = func_73282_a(p_73267_1_, 16);
         this.field_98212_g = p_73267_1_.readByte();
      }

      if(this.field_96489_f == 0 || this.field_96489_f == 3 || this.field_96489_f == 4) {
         short var2 = p_73267_1_.readShort();

         for(int var3 = 0; var3 < var2; ++var3) {
            this.field_96492_e.add(func_73282_a(p_73267_1_, 16));
         }
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      func_73271_a(this.field_96495_a, p_73273_1_);
      p_73273_1_.writeByte(this.field_96489_f);
      if(this.field_96489_f == 0 || this.field_96489_f == 2) {
         func_73271_a(this.field_96493_b, p_73273_1_);
         func_73271_a(this.field_96494_c, p_73273_1_);
         func_73271_a(this.field_96491_d, p_73273_1_);
         p_73273_1_.writeByte(this.field_98212_g);
      }

      if(this.field_96489_f == 0 || this.field_96489_f == 3 || this.field_96489_f == 4) {
         p_73273_1_.writeShort(this.field_96492_e.size());
         Iterator var2 = this.field_96492_e.iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            func_73271_a(var3, p_73273_1_);
         }
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_96435_a(this);
   }

   public int func_73284_a() {
      return 3 + this.field_96495_a.length();
   }
}
