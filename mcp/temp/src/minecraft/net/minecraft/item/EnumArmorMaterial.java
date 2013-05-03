package net.minecraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public enum EnumArmorMaterial {

   CLOTH("CLOTH", 0, 5, new int[]{1, 3, 2, 1}, 15),
   CHAIN("CHAIN", 1, 15, new int[]{2, 5, 4, 1}, 12),
   IRON("IRON", 2, 15, new int[]{2, 6, 5, 2}, 9),
   GOLD("GOLD", 3, 7, new int[]{2, 5, 3, 1}, 25),
   DIAMOND("DIAMOND", 4, 33, new int[]{3, 8, 6, 3}, 10);
   private int field_78048_f;
   private int[] field_78049_g;
   private int field_78055_h;
   // $FF: synthetic field
   private static final EnumArmorMaterial[] $VALUES = new EnumArmorMaterial[]{CLOTH, CHAIN, IRON, GOLD, DIAMOND};


   private EnumArmorMaterial(String p_i3618_1_, int p_i3618_2_, int p_i3618_3_, int[] p_i3618_4_, int p_i3618_5_) {
      this.field_78048_f = p_i3618_3_;
      this.field_78049_g = p_i3618_4_;
      this.field_78055_h = p_i3618_5_;
   }

   public int func_78046_a(int p_78046_1_) {
      return ItemArmor.func_77877_c()[p_78046_1_] * this.field_78048_f;
   }

   public int func_78044_b(int p_78044_1_) {
      return this.field_78049_g[p_78044_1_];
   }

   public int func_78045_a() {
      return this.field_78055_h;
   }

   public int func_82845_b() {
      return this == CLOTH?Item.field_77770_aF.field_77779_bT:(this == CHAIN?Item.field_77703_o.field_77779_bT:(this == GOLD?Item.field_77717_p.field_77779_bT:(this == IRON?Item.field_77703_o.field_77779_bT:(this == DIAMOND?Item.field_77702_n.field_77779_bT:0))));
   }

}
