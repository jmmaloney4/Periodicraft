package net.minecraft.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public class Packet132TileEntityData extends Packet {

   public int field_73334_a;
   public int field_73332_b;
   public int field_73333_c;
   public int field_73330_d;
   public NBTTagCompound field_73331_e;


   public Packet132TileEntityData() {
      this.field_73287_r = true;
   }

   public Packet132TileEntityData(int p_i3362_1_, int p_i3362_2_, int p_i3362_3_, int p_i3362_4_, NBTTagCompound p_i3362_5_) {
      this.field_73287_r = true;
      this.field_73334_a = p_i3362_1_;
      this.field_73332_b = p_i3362_2_;
      this.field_73333_c = p_i3362_3_;
      this.field_73330_d = p_i3362_4_;
      this.field_73331_e = p_i3362_5_;
   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73334_a = p_73267_1_.readInt();
      this.field_73332_b = p_73267_1_.readShort();
      this.field_73333_c = p_73267_1_.readInt();
      this.field_73330_d = p_73267_1_.readByte();
      this.field_73331_e = func_73283_d(p_73267_1_);
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73334_a);
      p_73273_1_.writeShort(this.field_73332_b);
      p_73273_1_.writeInt(this.field_73333_c);
      p_73273_1_.writeByte((byte)this.field_73330_d);
      func_73275_a(this.field_73331_e, p_73273_1_);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72468_a(this);
   }

   public int func_73284_a() {
      return 25;
   }
}
