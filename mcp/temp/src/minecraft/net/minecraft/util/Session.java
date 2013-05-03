package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Session {

   public String field_74286_b;
   public String field_74287_c;


   public Session(String p_i3014_1_, String p_i3014_2_) {
      this.field_74286_b = p_i3014_1_;
      this.field_74287_c = p_i3014_2_;
   }
}
