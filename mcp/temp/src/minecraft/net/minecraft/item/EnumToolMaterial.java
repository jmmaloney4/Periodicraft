package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumToolMaterial {

   WOOD("WOOD", 0, 0, 59, 2.0F, 0, 15),
   STONE("STONE", 1, 1, 131, 4.0F, 1, 5),
   IRON("IRON", 2, 2, 250, 6.0F, 2, 14),
   EMERALD("EMERALD", 3, 3, 1561, 8.0F, 3, 10),
   GOLD("GOLD", 4, 0, 32, 12.0F, 0, 22);
   private final int field_78001_f;
   private final int field_78002_g;
   private final float field_78010_h;
   private final int field_78011_i;
   private final int field_78008_j;
   // $FF: synthetic field
   private static final EnumToolMaterial[] $VALUES = new EnumToolMaterial[]{WOOD, STONE, IRON, EMERALD, GOLD};


   private EnumToolMaterial(String p_i3658_1_, int p_i3658_2_, int p_i3658_3_, int p_i3658_4_, float p_i3658_5_, int p_i3658_6_, int p_i3658_7_) {
      this.field_78001_f = p_i3658_3_;
      this.field_78002_g = p_i3658_4_;
      this.field_78010_h = p_i3658_5_;
      this.field_78011_i = p_i3658_6_;
      this.field_78008_j = p_i3658_7_;
   }

   public int func_77997_a() {
      return this.field_78002_g;
   }

   public float func_77998_b() {
      return this.field_78010_h;
   }

   public int func_78000_c() {
      return this.field_78011_i;
   }

   public int func_77996_d() {
      return this.field_78001_f;
   }

   public int func_77995_e() {
      return this.field_78008_j;
   }

   public int func_82844_f() {
      return this == WOOD?Block.field_71988_x.field_71990_ca:(this == STONE?Block.field_71978_w.field_71990_ca:(this == GOLD?Item.field_77717_p.field_77779_bT:(this == IRON?Item.field_77703_o.field_77779_bT:(this == EMERALD?Item.field_77702_n.field_77779_bT:0))));
   }

}
