package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.McoOption;

@SideOnly(Side.CLIENT)
public final class McoOptionNone extends McoOption {

   public Object func_98155_a() {
      throw new RuntimeException("None has no value");
   }
}
