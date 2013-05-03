package net.minecraft.network.packet;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class Packet52MultiBlockChange extends Packet {

   public int field_73452_a;
   public int field_73450_b;
   public byte[] field_73451_c;
   public int field_73448_d;
   private static byte[] field_73449_e = new byte[0];


   public Packet52MultiBlockChange() {
      this.field_73287_r = true;
   }

   public Packet52MultiBlockChange(int p_i3302_1_, int p_i3302_2_, short[] p_i3302_3_, int p_i3302_4_, World p_i3302_5_) {
      this.field_73287_r = true;
      this.field_73452_a = p_i3302_1_;
      this.field_73450_b = p_i3302_2_;
      this.field_73448_d = p_i3302_4_;
      int var6 = 4 * p_i3302_4_;
      Chunk var7 = p_i3302_5_.func_72964_e(p_i3302_1_, p_i3302_2_);

      try {
         if(p_i3302_4_ >= 64) {
            this.field_98193_m.func_98233_a("ChunkTilesUpdatePacket compress " + p_i3302_4_);
            if(field_73449_e.length < var6) {
               field_73449_e = new byte[var6];
            }
         } else {
            ByteArrayOutputStream var8 = new ByteArrayOutputStream(var6);
            DataOutputStream var9 = new DataOutputStream(var8);

            for(int var10 = 0; var10 < p_i3302_4_; ++var10) {
               int var11 = p_i3302_3_[var10] >> 12 & 15;
               int var12 = p_i3302_3_[var10] >> 8 & 15;
               int var13 = p_i3302_3_[var10] & 255;
               var9.writeShort(p_i3302_3_[var10]);
               var9.writeShort((short)((var7.func_76610_a(var11, var13, var12) & 4095) << 4 | var7.func_76628_c(var11, var13, var12) & 15));
            }

            this.field_73451_c = var8.toByteArray();
            if(this.field_73451_c.length != var6) {
               throw new RuntimeException("Expected length " + var6 + " doesn\'t match received length " + this.field_73451_c.length);
            }
         }
      } catch (IOException var14) {
         this.field_98193_m.func_98234_c("Couldn\'t create chunk packet", var14);
         this.field_73451_c = null;
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73452_a = p_73267_1_.readInt();
      this.field_73450_b = p_73267_1_.readInt();
      this.field_73448_d = p_73267_1_.readShort() & '\uffff';
      int var2 = p_73267_1_.readInt();
      if(var2 > 0) {
         this.field_73451_c = new byte[var2];
         p_73267_1_.readFully(this.field_73451_c);
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73452_a);
      p_73273_1_.writeInt(this.field_73450_b);
      p_73273_1_.writeShort((short)this.field_73448_d);
      if(this.field_73451_c != null) {
         p_73273_1_.writeInt(this.field_73451_c.length);
         p_73273_1_.write(this.field_73451_c);
      } else {
         p_73273_1_.writeInt(0);
      }

   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72496_a(this);
   }

   public int func_73284_a() {
      return 10 + this.field_73448_d * 4;
   }

}
