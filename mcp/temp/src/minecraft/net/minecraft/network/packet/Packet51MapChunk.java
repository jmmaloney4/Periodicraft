package net.minecraft.network.packet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet51MapChunkData;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class Packet51MapChunk extends Packet {

   public int field_73601_a;
   public int field_73599_b;
   public int field_73600_c;
   public int field_73597_d;
   private byte[] field_73595_f;
   private byte[] field_73596_g;
   public boolean field_73598_e;
   private int field_73602_h;
   private static byte[] field_73603_i = new byte[196864];


   public Packet51MapChunk() {
      this.field_73287_r = true;
   }

   public Packet51MapChunk(Chunk p_i3323_1_, boolean p_i3323_2_, int p_i3323_3_) {
      this.field_73287_r = true;
      this.field_73601_a = p_i3323_1_.field_76635_g;
      this.field_73599_b = p_i3323_1_.field_76647_h;
      this.field_73598_e = p_i3323_2_;
      Packet51MapChunkData var4 = func_73594_a(p_i3323_1_, p_i3323_2_, p_i3323_3_);
      Deflater var5 = new Deflater(-1);
      this.field_73597_d = var4.field_74581_c;
      this.field_73600_c = var4.field_74580_b;

      try {
         this.field_73596_g = var4.field_74582_a;
         var5.setInput(var4.field_74582_a, 0, var4.field_74582_a.length);
         var5.finish();
         this.field_73595_f = new byte[var4.field_74582_a.length];
         this.field_73602_h = var5.deflate(this.field_73595_f);
      } finally {
         var5.end();
      }

   }

   public void func_73267_a(DataInputStream p_73267_1_) throws IOException {
      this.field_73601_a = p_73267_1_.readInt();
      this.field_73599_b = p_73267_1_.readInt();
      this.field_73598_e = p_73267_1_.readBoolean();
      this.field_73600_c = p_73267_1_.readShort();
      this.field_73597_d = p_73267_1_.readShort();
      this.field_73602_h = p_73267_1_.readInt();
      if(field_73603_i.length < this.field_73602_h) {
         field_73603_i = new byte[this.field_73602_h];
      }

      p_73267_1_.readFully(field_73603_i, 0, this.field_73602_h);
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < 16; ++var3) {
         var2 += this.field_73600_c >> var3 & 1;
      }

      var3 = 12288 * var2;
      if(this.field_73598_e) {
         var3 += 256;
      }

      this.field_73596_g = new byte[var3];
      Inflater var4 = new Inflater();
      var4.setInput(field_73603_i, 0, this.field_73602_h);

      try {
         var4.inflate(this.field_73596_g);
      } catch (DataFormatException var9) {
         throw new IOException("Bad compressed data format");
      } finally {
         var4.end();
      }

   }

   public void func_73273_a(DataOutputStream p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73601_a);
      p_73273_1_.writeInt(this.field_73599_b);
      p_73273_1_.writeBoolean(this.field_73598_e);
      p_73273_1_.writeShort((short)(this.field_73600_c & '\uffff'));
      p_73273_1_.writeShort((short)(this.field_73597_d & '\uffff'));
      p_73273_1_.writeInt(this.field_73602_h);
      p_73273_1_.write(this.field_73595_f, 0, this.field_73602_h);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72463_a(this);
   }

   public int func_73284_a() {
      return 17 + this.field_73602_h;
   }

   public static Packet51MapChunkData func_73594_a(Chunk p_73594_0_, boolean p_73594_1_, int p_73594_2_) {
      int var3 = 0;
      ExtendedBlockStorage[] var4 = p_73594_0_.func_76587_i();
      int var5 = 0;
      Packet51MapChunkData var6 = new Packet51MapChunkData();
      byte[] var7 = field_73603_i;
      if(p_73594_1_) {
         p_73594_0_.field_76642_o = true;
      }

      int var8;
      for(var8 = 0; var8 < var4.length; ++var8) {
         if(var4[var8] != null && (!p_73594_1_ || !var4[var8].func_76663_a()) && (p_73594_2_ & 1 << var8) != 0) {
            var6.field_74580_b |= 1 << var8;
            if(var4[var8].func_76660_i() != null) {
               var6.field_74581_c |= 1 << var8;
               ++var5;
            }
         }
      }

      for(var8 = 0; var8 < var4.length; ++var8) {
         if(var4[var8] != null && (!p_73594_1_ || !var4[var8].func_76663_a()) && (p_73594_2_ & 1 << var8) != 0) {
            byte[] var9 = var4[var8].func_76658_g();
            System.arraycopy(var9, 0, var7, var3, var9.length);
            var3 += var9.length;
         }
      }

      NibbleArray var10;
      for(var8 = 0; var8 < var4.length; ++var8) {
         if(var4[var8] != null && (!p_73594_1_ || !var4[var8].func_76663_a()) && (p_73594_2_ & 1 << var8) != 0) {
            var10 = var4[var8].func_76669_j();
            System.arraycopy(var10.field_76585_a, 0, var7, var3, var10.field_76585_a.length);
            var3 += var10.field_76585_a.length;
         }
      }

      for(var8 = 0; var8 < var4.length; ++var8) {
         if(var4[var8] != null && (!p_73594_1_ || !var4[var8].func_76663_a()) && (p_73594_2_ & 1 << var8) != 0) {
            var10 = var4[var8].func_76661_k();
            System.arraycopy(var10.field_76585_a, 0, var7, var3, var10.field_76585_a.length);
            var3 += var10.field_76585_a.length;
         }
      }

      if(!p_73594_0_.field_76637_e.field_73011_w.field_76576_e) {
         for(var8 = 0; var8 < var4.length; ++var8) {
            if(var4[var8] != null && (!p_73594_1_ || !var4[var8].func_76663_a()) && (p_73594_2_ & 1 << var8) != 0) {
               var10 = var4[var8].func_76671_l();
               System.arraycopy(var10.field_76585_a, 0, var7, var3, var10.field_76585_a.length);
               var3 += var10.field_76585_a.length;
            }
         }
      }

      if(var5 > 0) {
         for(var8 = 0; var8 < var4.length; ++var8) {
            if(var4[var8] != null && (!p_73594_1_ || !var4[var8].func_76663_a()) && var4[var8].func_76660_i() != null && (p_73594_2_ & 1 << var8) != 0) {
               var10 = var4[var8].func_76660_i();
               System.arraycopy(var10.field_76585_a, 0, var7, var3, var10.field_76585_a.length);
               var3 += var10.field_76585_a.length;
            }
         }
      }

      if(p_73594_1_) {
         byte[] var11 = p_73594_0_.func_76605_m();
         System.arraycopy(var11, 0, var7, var3, var11.length);
         var3 += var11.length;
      }

      var6.field_74582_a = new byte[var3];
      System.arraycopy(var7, 0, var6.field_74582_a, 0, var3);
      return var6;
   }

   @SideOnly(Side.CLIENT)
   public byte[] func_73593_d() {
      return this.field_73596_g;
   }

}
