package net.minecraft.world.chunk.storage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.minecraft.world.chunk.storage.RegionFile;

class RegionFileChunkBuffer extends ByteArrayOutputStream {

   private int field_76722_b;
   private int field_76723_c;
   // $FF: synthetic field
   final RegionFile field_76724_a;


   public RegionFileChunkBuffer(RegionFile p_i3776_1_, int p_i3776_2_, int p_i3776_3_) {
      super(8096);
      this.field_76724_a = p_i3776_1_;
      this.field_76722_b = p_i3776_2_;
      this.field_76723_c = p_i3776_3_;
   }

   public void close() throws IOException {
      this.field_76724_a.func_76706_a(this.field_76722_b, this.field_76723_c, this.buf, this.count);
   }
}
