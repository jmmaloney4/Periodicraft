package net.minecraft.util;


public enum EnumArt {

   Kebab("Kebab", 0, "Kebab", 16, 16, 0, 0),
   Aztec("Aztec", 1, "Aztec", 16, 16, 16, 0),
   Alban("Alban", 2, "Alban", 16, 16, 32, 0),
   Aztec2("Aztec2", 3, "Aztec2", 16, 16, 48, 0),
   Bomb("Bomb", 4, "Bomb", 16, 16, 64, 0),
   Plant("Plant", 5, "Plant", 16, 16, 80, 0),
   Wasteland("Wasteland", 6, "Wasteland", 16, 16, 96, 0),
   Pool("Pool", 7, "Pool", 32, 16, 0, 32),
   Courbet("Courbet", 8, "Courbet", 32, 16, 32, 32),
   Sea("Sea", 9, "Sea", 32, 16, 64, 32),
   Sunset("Sunset", 10, "Sunset", 32, 16, 96, 32),
   Creebet("Creebet", 11, "Creebet", 32, 16, 128, 32),
   Wanderer("Wanderer", 12, "Wanderer", 16, 32, 0, 64),
   Graham("Graham", 13, "Graham", 16, 32, 16, 64),
   Match("Match", 14, "Match", 32, 32, 0, 128),
   Bust("Bust", 15, "Bust", 32, 32, 32, 128),
   Stage("Stage", 16, "Stage", 32, 32, 64, 128),
   Void("Void", 17, "Void", 32, 32, 96, 128),
   SkullAndRoses("SkullAndRoses", 18, "SkullAndRoses", 32, 32, 128, 128),
   Wither("Wither", 19, "Wither", 32, 32, 160, 128),
   Fighters("Fighters", 20, "Fighters", 64, 32, 0, 96),
   Pointer("Pointer", 21, "Pointer", 64, 64, 0, 192),
   Pigscene("Pigscene", 22, "Pigscene", 64, 64, 64, 192),
   BurningSkull("BurningSkull", 23, "BurningSkull", 64, 64, 128, 192),
   Skeleton("Skeleton", 24, "Skeleton", 64, 48, 192, 64),
   DonkeyKong("DonkeyKong", 25, "DonkeyKong", 64, 48, 192, 112);
   public static final int field_75728_z = "SkullAndRoses".length();
   public final String field_75702_A;
   public final int field_75703_B;
   public final int field_75704_C;
   public final int field_75699_D;
   public final int field_75700_E;
   // $FF: synthetic field
   private static final EnumArt[] $VALUES = new EnumArt[]{Kebab, Aztec, Alban, Aztec2, Bomb, Plant, Wasteland, Pool, Courbet, Sea, Sunset, Creebet, Wanderer, Graham, Match, Bust, Stage, Void, SkullAndRoses, Wither, Fighters, Pointer, Pigscene, BurningSkull, Skeleton, DonkeyKong};


   private EnumArt(String p_i3446_1_, int p_i3446_2_, String p_i3446_3_, int p_i3446_4_, int p_i3446_5_, int p_i3446_6_, int p_i3446_7_) {
      this.field_75702_A = p_i3446_3_;
      this.field_75703_B = p_i3446_4_;
      this.field_75704_C = p_i3446_5_;
      this.field_75699_D = p_i3446_6_;
      this.field_75700_E = p_i3446_7_;
   }

}
