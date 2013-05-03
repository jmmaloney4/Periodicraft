package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.MathHelper;

public class Packet23VehicleSpawn extends Packet {

   public int field_73526_a;
   public int field_73524_b;
   public int field_73525_c;
   public int field_73522_d;
   public int field_73523_e;
   public int field_73520_f;
   public int field_73521_g;
   public int field_92077_h;
   public int field_92078_i;
   public int field_73527_h;
   public int field_73528_i;


   public Packet23VehicleSpawn() {}

   public Packet23VehicleSpawn(Entity p_i3289_1_, int p_i3289_2_) {
      this(p_i3289_1_, p_i3289_2_, 0);
   }

   public Packet23VehicleSpawn(Entity p_i3290_1_, int p_i3290_2_, int p_i3290_3_) {
      this.field_73526_a = p_i3290_1_.field_70157_k;
      this.field_73524_b = MathHelper.func_76128_c(p_i3290_1_.field_70165_t * 32.0D);
      this.field_73525_c = MathHelper.func_76128_c(p_i3290_1_.field_70163_u * 32.0D);
      this.field_73522_d = MathHelper.func_76128_c(p_i3290_1_.field_70161_v * 32.0D);
      this.field_92077_h = MathHelper.func_76141_d(p_i3290_1_.field_70125_A * 256.0F / 360.0F);
      this.field_92078_i = MathHelper.func_76141_d(p_i3290_1_.field_70177_z * 256.0F / 360.0F);
      this.field_73527_h = p_i3290_2_;
      this.field_73528_i = p_i3290_3_;
      if(p_i3290_3_ > 0) {
         double var4 = p_i3290_1_.field_70159_w;
         double var6 = p_i3290_1_.field_70181_x;
         double var8 = p_i3290_1_.field_70179_y;
         double var10 = 3.9D;
         if(var4 < -var10) {
            var4 = -var10;
         }

         if(var6 < -var10) {
            var6 = -var10;
         }

         if(var8 < -var10) {
            var8 = -var10;
         }

         if(var4 > var10) {
            var4 = var10;
         }

         if(var6 > var10) {
            var6 = var10;
         }

         if(var8 > var10) {
            var8 = var10;
         }

         this.field_73523_e = (int)(var4 * 8000.0D);
         this.field_73520_f = (int)(var6 * 8000.0D);
         this.field_73521_g = (int)(var8 * 8000.0D);
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73526_a = p_73267_1_.readInt();
      this.field_73527_h = p_73267_1_.readByte();
      this.field_73524_b = p_73267_1_.readInt();
      this.field_73525_c = p_73267_1_.readInt();
      this.field_73522_d = p_73267_1_.readInt();
      this.field_92077_h = p_73267_1_.readByte();
      this.field_92078_i = p_73267_1_.readByte();
      this.field_73528_i = p_73267_1_.readInt();
      if(this.field_73528_i > 0) {
         this.field_73523_e = p_73267_1_.readShort();
         this.field_73520_f = p_73267_1_.readShort();
         this.field_73521_g = p_73267_1_.readShort();
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73526_a);
      p_73273_1_.writeByte(this.field_73527_h);
      p_73273_1_.writeInt(this.field_73524_b);
      p_73273_1_.writeInt(this.field_73525_c);
      p_73273_1_.writeInt(this.field_73522_d);
      p_73273_1_.writeByte(this.field_92077_h);
      p_73273_1_.writeByte(this.field_92078_i);
      p_73273_1_.writeInt(this.field_73528_i);
      if(this.field_73528_i > 0) {
         p_73273_1_.writeShort(this.field_73523_e);
         p_73273_1_.writeShort(this.field_73520_f);
         p_73273_1_.writeShort(this.field_73521_g);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72511_a(this);
   }

   public int func_73284_a() {
      return 21 + this.field_73528_i > 0?6:0;
   }
}
