package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface Icon {

   @SideOnly(Side.CLIENT)
   int func_94211_a();

   @SideOnly(Side.CLIENT)
   int func_94216_b();

   @SideOnly(Side.CLIENT)
   float func_94209_e();

   @SideOnly(Side.CLIENT)
   float func_94212_f();

   @SideOnly(Side.CLIENT)
   float func_94214_a(double var1);

   @SideOnly(Side.CLIENT)
   float func_94206_g();

   @SideOnly(Side.CLIENT)
   float func_94210_h();

   @SideOnly(Side.CLIENT)
   float func_94207_b(double var1);

   @SideOnly(Side.CLIENT)
   String func_94215_i();

   @SideOnly(Side.CLIENT)
   int func_94213_j();

   @SideOnly(Side.CLIENT)
   int func_94208_k();
}
