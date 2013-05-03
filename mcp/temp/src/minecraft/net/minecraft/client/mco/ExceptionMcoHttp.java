package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ExceptionMcoHttp extends RuntimeException {

   public ExceptionMcoHttp(String p_i10032_1_, Exception p_i10032_2_) {
      super(p_i10032_1_, p_i10032_2_);
   }
}
