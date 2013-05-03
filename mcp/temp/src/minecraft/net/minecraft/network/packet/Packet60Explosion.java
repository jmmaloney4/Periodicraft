package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;

public class Packet60Explosion extends Packet {

   public double field_73616_a;
   public double field_73614_b;
   public double field_73615_c;
   public float field_73612_d;
   public List field_73613_e;
   private float field_73610_f;
   private float field_73611_g;
   private float field_73617_h;


   public Packet60Explosion() {}

   public Packet60Explosion(double p_i3319_1_, double p_i3319_3_, double p_i3319_5_, float p_i3319_7_, List p_i3319_8_, Vec3 p_i3319_9_) {
      this.field_73616_a = p_i3319_1_;
      this.field_73614_b = p_i3319_3_;
      this.field_73615_c = p_i3319_5_;
      this.field_73612_d = p_i3319_7_;
      this.field_73613_e = new ArrayList(p_i3319_8_);
      if(p_i3319_9_ != null) {
         this.field_73610_f = (float)p_i3319_9_.field_72450_a;
         this.field_73611_g = (float)p_i3319_9_.field_72448_b;
         this.field_73617_h = (float)p_i3319_9_.field_72449_c;
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73616_a = p_73267_1_.readDouble();
      this.field_73614_b = p_73267_1_.readDouble();
      this.field_73615_c = p_73267_1_.readDouble();
      this.field_73612_d = p_73267_1_.readFloat();
      int var2 = p_73267_1_.readInt();
      this.field_73613_e = new ArrayList(var2);
      int var3 = (int)this.field_73616_a;
      int var4 = (int)this.field_73614_b;
      int var5 = (int)this.field_73615_c;

      for(int var6 = 0; var6 < var2; ++var6) {
         int var7 = p_73267_1_.readByte() + var3;
         int var8 = p_73267_1_.readByte() + var4;
         int var9 = p_73267_1_.readByte() + var5;
         this.field_73613_e.add(new ChunkPosition(var7, var8, var9));
      }

      this.field_73610_f = p_73267_1_.readFloat();
      this.field_73611_g = p_73267_1_.readFloat();
      this.field_73617_h = p_73267_1_.readFloat();
   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeDouble(this.field_73616_a);
      p_73273_1_.writeDouble(this.field_73614_b);
      p_73273_1_.writeDouble(this.field_73615_c);
      p_73273_1_.writeFloat(this.field_73612_d);
      p_73273_1_.writeInt(this.field_73613_e.size());
      int var2 = (int)this.field_73616_a;
      int var3 = (int)this.field_73614_b;
      int var4 = (int)this.field_73615_c;
      Iterator var5 = this.field_73613_e.iterator();

      while(var5.hasNext()) {
         ChunkPosition var6 = (ChunkPosition)var5.next();
         int var7 = var6.field_76930_a - var2;
         int var8 = var6.field_76928_b - var3;
         int var9 = var6.field_76929_c - var4;
         p_73273_1_.writeByte(var7);
         p_73273_1_.writeByte(var8);
         p_73273_1_.writeByte(var9);
      }

      p_73273_1_.writeFloat(this.field_73610_f);
      p_73273_1_.writeFloat(this.field_73611_g);
      p_73273_1_.writeFloat(this.field_73617_h);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72499_a(this);
   }

   public int func_73284_a() {
      return 32 + this.field_73613_e.size() * 3 + 3;
   }

   @SideOnly(Side.CLIENT)
   public float func_73607_d() {
      return this.field_73610_f;
   }

   @SideOnly(Side.CLIENT)
   public float func_73609_f() {
      return this.field_73611_g;
   }

   @SideOnly(Side.CLIENT)
   public float func_73608_g() {
      return this.field_73617_h;
   }
}
