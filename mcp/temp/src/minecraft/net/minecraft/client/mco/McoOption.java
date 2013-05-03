package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.McoOptionNone;
import net.minecraft.client.mco.McoOptionSome;

@SideOnly(Side.CLIENT)
public abstract class McoOption {

   public abstract Object func_98155_a();

   public static McoOptionSome func_98153_a(Object p_98153_0_) {
      return new McoOptionSome(p_98153_0_);
   }

   public static McoOptionNone func_98154_b() {
      return new McoOptionNone();
   }
}
