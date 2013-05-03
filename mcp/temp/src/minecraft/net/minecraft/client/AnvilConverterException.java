package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AnvilConverterException extends Exception {

   public AnvilConverterException(String p_i11045_1_) {
      super(p_i11045_1_);
   }
}
