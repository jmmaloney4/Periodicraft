package net.minecraft.logging;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.logging.Logger;

public interface ILogAgent {

   void func_98233_a(String var1);

   @SideOnly(Side.SERVER)
   Logger func_98076_a();

   void func_98236_b(String var1);

   void func_98231_b(String var1, Object ... var2);

   void func_98235_b(String var1, Throwable var2);

   void func_98232_c(String var1);

   void func_98234_c(String var1, Throwable var2);

   @SideOnly(Side.CLIENT)
   void func_98230_d(String var1);
}
