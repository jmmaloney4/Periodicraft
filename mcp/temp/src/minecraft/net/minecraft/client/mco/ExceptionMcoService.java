package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ExceptionMcoService extends Exception {

   public final int field_96392_a;
   public final String field_96391_b;


   public ExceptionMcoService(int p_i10025_1_, String p_i10025_2_) {
      super(p_i10025_2_);
      this.field_96392_a = p_i10025_1_;
      this.field_96391_b = p_i10025_2_;
   }
}
