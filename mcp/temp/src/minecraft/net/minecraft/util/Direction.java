package net.minecraft.util;

import net.minecraft.util.MathHelper;

public class Direction {

   public static final int[] field_71583_a = new int[]{0, -1, 0, 1};
   public static final int[] field_71581_b = new int[]{1, 0, -1, 0};
   public static final String[] field_82373_c = new String[]{"SOUTH", "WEST", "NORTH", "EAST"};
   public static final int[] field_71582_c = new int[]{3, 4, 2, 5};
   public static final int[] field_71579_d = new int[]{-1, -1, 2, 0, 1, 3};
   public static final int[] field_71580_e = new int[]{2, 3, 0, 1};
   public static final int[] field_71577_f = new int[]{1, 2, 3, 0};
   public static final int[] field_71578_g = new int[]{3, 0, 1, 2};
   public static final int[][] field_71584_h = new int[][]{{1, 0, 3, 2, 5, 4}, {1, 0, 5, 4, 2, 3}, {1, 0, 2, 3, 4, 5}, {1, 0, 4, 5, 3, 2}};


   public static int func_82372_a(double p_82372_0_, double p_82372_2_) {
      return MathHelper.func_76135_e((float)p_82372_0_) > MathHelper.func_76135_e((float)p_82372_2_)?(p_82372_0_ > 0.0D?1:3):(p_82372_2_ > 0.0D?2:0);
   }

}
