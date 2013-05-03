package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ColorizerGrass {

   private static int[] field_77481_a = new int[65536];


   public static void func_77479_a(int[] p_77479_0_) {
      field_77481_a = p_77479_0_;
   }

   public static int func_77480_a(double p_77480_0_, double p_77480_2_) {
      p_77480_2_ *= p_77480_0_;
      int var4 = (int)((1.0D - p_77480_0_) * 255.0D);
      int var5 = (int)((1.0D - p_77480_2_) * 255.0D);
      return field_77481_a[var5 << 8 | var4];
   }

}
