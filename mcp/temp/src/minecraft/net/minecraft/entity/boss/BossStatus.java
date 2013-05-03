package net.minecraft.entity.boss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.boss.IBossDisplayData;

@SideOnly(Side.CLIENT)
public final class BossStatus {

   public static float field_82828_a;
   public static int field_82826_b;
   public static String field_82827_c;
   public static boolean field_82825_d;


   public static void func_82824_a(IBossDisplayData p_82824_0_, boolean p_82824_1_) {
      field_82828_a = (float)p_82824_0_.func_70968_i() / (float)p_82824_0_.func_70667_aM();
      field_82826_b = 100;
      field_82827_c = p_82824_0_.func_70023_ak();
      field_82825_d = p_82824_1_;
   }
}
