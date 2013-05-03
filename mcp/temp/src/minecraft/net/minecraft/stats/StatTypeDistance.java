package net.minecraft.stats;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.stats.IStatType;
import net.minecraft.stats.StatBase;

final class StatTypeDistance implements IStatType {

   @SideOnly(Side.CLIENT)
   public String func_75843_a(int p_75843_1_) {
      double var2 = (double)p_75843_1_ / 100.0D;
      double var4 = var2 / 1000.0D;
      return var4 > 0.5D?StatBase.func_75969_k().format(var4) + " km":(var2 > 0.5D?StatBase.func_75969_k().format(var2) + " m":p_75843_1_ + " cm");
   }
}
