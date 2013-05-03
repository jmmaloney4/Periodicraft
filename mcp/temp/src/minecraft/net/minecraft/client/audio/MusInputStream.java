package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import net.minecraft.client.audio.CodecMus;

@SideOnly(Side.CLIENT)
class MusInputStream extends InputStream {

   private int field_77388_c;
   private InputStream field_77386_d;
   byte[] field_77389_a;
   // $FF: synthetic field
   final CodecMus field_77387_b;


   public MusInputStream(CodecMus p_i3126_1_, URL p_i3126_2_, InputStream p_i3126_3_) {
      this.field_77387_b = p_i3126_1_;
      this.field_77389_a = new byte[1];
      this.field_77386_d = p_i3126_3_;
      String var4 = p_i3126_2_.getPath();
      var4 = var4.substring(var4.lastIndexOf("/") + 1);
      this.field_77388_c = var4.hashCode();
   }

   public int read() throws IOException {
      int var1 = this.read(this.field_77389_a, 0, 1);
      return var1 < 0?var1:this.field_77389_a[0];
   }

   public int read(byte[] p_read_1_, int p_read_2_, int p_read_3_) throws IOException {
      p_read_3_ = this.field_77386_d.read(p_read_1_, p_read_2_, p_read_3_);

      for(int var4 = 0; var4 < p_read_3_; ++var4) {
         byte var5 = p_read_1_[p_read_2_ + var4] = (byte)(p_read_1_[p_read_2_ + var4] ^ this.field_77388_c >> 8);
         this.field_77388_c = this.field_77388_c * 498729871 + 85731 * var5;
      }

      return p_read_3_;
   }
}
