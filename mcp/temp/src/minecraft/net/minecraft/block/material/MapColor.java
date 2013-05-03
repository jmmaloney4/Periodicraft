package net.minecraft.block.material;


public class MapColor {

   public static final MapColor[] field_76281_a = new MapColor[16];
   public static final MapColor field_76279_b = new MapColor(0, 0);
   public static final MapColor field_76280_c = new MapColor(1, 8368696);
   public static final MapColor field_76277_d = new MapColor(2, 16247203);
   public static final MapColor field_76278_e = new MapColor(3, 10987431);
   public static final MapColor field_76275_f = new MapColor(4, 16711680);
   public static final MapColor field_76276_g = new MapColor(5, 10526975);
   public static final MapColor field_76288_h = new MapColor(6, 10987431);
   public static final MapColor field_76289_i = new MapColor(7, 31744);
   public static final MapColor field_76286_j = new MapColor(8, 16777215);
   public static final MapColor field_76287_k = new MapColor(9, 10791096);
   public static final MapColor field_76284_l = new MapColor(10, 12020271);
   public static final MapColor field_76285_m = new MapColor(11, 7368816);
   public static final MapColor field_76282_n = new MapColor(12, 4210943);
   public static final MapColor field_76283_o = new MapColor(13, 6837042);
   public final int field_76291_p;
   public final int field_76290_q;


   private MapColor(int p_i3883_1_, int p_i3883_2_) {
      this.field_76290_q = p_i3883_1_;
      this.field_76291_p = p_i3883_2_;
      field_76281_a[p_i3883_1_] = this;
   }

}
