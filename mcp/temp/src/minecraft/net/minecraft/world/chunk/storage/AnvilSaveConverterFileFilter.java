package net.minecraft.world.chunk.storage;

import java.io.File;
import java.io.FilenameFilter;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;

class AnvilSaveConverterFileFilter implements FilenameFilter {

   // $FF: synthetic field
   final AnvilSaveConverter field_76172_a;


   AnvilSaveConverterFileFilter(AnvilSaveConverter p_i3909_1_) {
      this.field_76172_a = p_i3909_1_;
   }

   public boolean accept(File p_accept_1_, String p_accept_2_) {
      return p_accept_2_.endsWith(".mcr");
   }
}
