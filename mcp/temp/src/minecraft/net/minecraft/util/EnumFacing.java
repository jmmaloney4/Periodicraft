package net.minecraft.util;


public enum EnumFacing {

   DOWN("DOWN", 0, 0, 1, 0, -1, 0),
   UP("UP", 1, 1, 0, 0, 1, 0),
   NORTH("NORTH", 2, 2, 3, 0, 0, -1),
   SOUTH("SOUTH", 3, 3, 2, 0, 0, 1),
   EAST("EAST", 4, 4, 5, -1, 0, 0),
   WEST("WEST", 5, 5, 4, 1, 0, 0);
   private final int field_82603_g;
   private final int field_82613_h;
   private final int field_82614_i;
   private final int field_82611_j;
   private final int field_82612_k;
   private static final EnumFacing[] field_82609_l = new EnumFacing[6];
   // $FF: synthetic field
   private static final EnumFacing[] $VALUES = new EnumFacing[]{DOWN, UP, NORTH, SOUTH, EAST, WEST};


   private EnumFacing(String p_i5027_1_, int p_i5027_2_, int p_i5027_3_, int p_i5027_4_, int p_i5027_5_, int p_i5027_6_, int p_i5027_7_) {
      this.field_82603_g = p_i5027_3_;
      this.field_82613_h = p_i5027_4_;
      this.field_82614_i = p_i5027_5_;
      this.field_82611_j = p_i5027_6_;
      this.field_82612_k = p_i5027_7_;
   }

   public int func_82601_c() {
      return this.field_82614_i;
   }

   public int func_96559_d() {
      return this.field_82611_j;
   }

   public int func_82599_e() {
      return this.field_82612_k;
   }

   public static EnumFacing func_82600_a(int p_82600_0_) {
      return field_82609_l[p_82600_0_ % field_82609_l.length];
   }

   static {
      EnumFacing[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumFacing var3 = var0[var2];
         field_82609_l[var3.field_82603_g] = var3;
      }

   }
}
