package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.EnumOS;

@SideOnly(Side.CLIENT)
// $FF: synthetic class
public class EnumOSHelper {

   // $FF: synthetic field
   public static final int[] field_90049_a = new int[EnumOS.values().length];


   static {
      try {
         field_90049_a[EnumOS.LINUX.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         field_90049_a[EnumOS.SOLARIS.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         field_90049_a[EnumOS.WINDOWS.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         field_90049_a[EnumOS.MACOS.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
