package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.MathHelper;

public class Packet24MobSpawn extends Packet {

   public int field_73496_a;
   public int field_73494_b;
   public int field_73495_c;
   public int field_73492_d;
   public int field_73493_e;
   public int field_73490_f;
   public int field_73491_g;
   public int field_73499_h;
   public byte field_73500_i;
   public byte field_73497_j;
   public byte field_73498_k;
   private DataWatcher field_73502_s;
   private List field_73501_t;


   public Packet24MobSpawn() {}

   public Packet24MobSpawn(EntityLiving p_i3294_1_) {
      this.field_73496_a = p_i3294_1_.field_70157_k;
      this.field_73494_b = (byte)EntityList.func_75619_a(p_i3294_1_);
      this.field_73495_c = p_i3294_1_.field_70168_am.func_75630_a(p_i3294_1_.field_70165_t);
      this.field_73492_d = MathHelper.func_76128_c(p_i3294_1_.field_70163_u * 32.0D);
      this.field_73493_e = p_i3294_1_.field_70168_am.func_75630_a(p_i3294_1_.field_70161_v);
      this.field_73500_i = (byte)((int)(p_i3294_1_.field_70177_z * 256.0F / 360.0F));
      this.field_73497_j = (byte)((int)(p_i3294_1_.field_70125_A * 256.0F / 360.0F));
      this.field_73498_k = (byte)((int)(p_i3294_1_.field_70759_as * 256.0F / 360.0F));
      double var2 = 3.9D;
      double var4 = p_i3294_1_.field_70159_w;
      double var6 = p_i3294_1_.field_70181_x;
      double var8 = p_i3294_1_.field_70179_y;
      if(var4 < -var2) {
         var4 = -var2;
      }

      if(var6 < -var2) {
         var6 = -var2;
      }

      if(var8 < -var2) {
         var8 = -var2;
      }

      if(var4 > var2) {
         var4 = var2;
      }

      if(var6 > var2) {
         var6 = var2;
      }

      if(var8 > var2) {
         var8 = var2;
      }

      this.field_73490_f = (int)(var4 * 8000.0D);
      this.field_73491_g = (int)(var6 * 8000.0D);
      this.field_73499_h = (int)(var8 * 8000.0D);
      this.field_73502_s = p_i3294_1_.func_70096_w();
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73496_a = p_73267_1_.readInt();
      this.field_73494_b = p_73267_1_.readByte() & 255;
      this.field_73495_c = p_73267_1_.readInt();
      this.field_73492_d = p_73267_1_.readInt();
      this.field_73493_e = p_73267_1_.readInt();
      this.field_73500_i = p_73267_1_.readByte();
      this.field_73497_j = p_73267_1_.readByte();
      this.field_73498_k = p_73267_1_.readByte();
      this.field_73490_f = p_73267_1_.readShort();
      this.field_73491_g = p_73267_1_.readShort();
      this.field_73499_h = p_73267_1_.readShort();
      this.field_73501_t = DataWatcher.func_75686_a(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73496_a);
      p_73273_1_.writeByte(this.field_73494_b & 255);
      p_73273_1_.writeInt(this.field_73495_c);
      p_73273_1_.writeInt(this.field_73492_d);
      p_73273_1_.writeInt(this.field_73493_e);
      p_73273_1_.writeByte(this.field_73500_i);
      p_73273_1_.writeByte(this.field_73497_j);
      p_73273_1_.writeByte(this.field_73498_k);
      p_73273_1_.writeShort(this.field_73490_f);
      p_73273_1_.writeShort(this.field_73491_g);
      p_73273_1_.writeShort(this.field_73499_h);
      this.field_73502_s.func_75689_a(p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72519_a(this);
   }

   public int func_73284_a() {
      return 26;
   }

   @SideOnly(Side.CLIENT)
   public List func_73489_c() {
      if(this.field_73501_t == null) {
         this.field_73501_t = this.field_73502_s.func_75685_c();
      }

      return this.field_73501_t;
   }
}
