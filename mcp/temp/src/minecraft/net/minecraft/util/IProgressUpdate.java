package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IProgressUpdate {

   void func_73720_a(String var1);

   @SideOnly(Side.CLIENT)
   void func_73721_b(String var1);

   void func_73719_c(String var1);

   void func_73718_a(int var1);

   @SideOnly(Side.CLIENT)
   void func_73717_a();
}
