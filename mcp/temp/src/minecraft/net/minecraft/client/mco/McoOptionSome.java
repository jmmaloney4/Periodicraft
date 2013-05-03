package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.McoOption;

@SideOnly(Side.CLIENT)
public final class McoOptionSome extends McoOption {

   private final Object field_98156_a;


   public McoOptionSome(Object p_i11017_1_) {
      this.field_98156_a = p_i11017_1_;
   }

   public Object func_98155_a() {
      return this.field_98156_a;
   }
}
