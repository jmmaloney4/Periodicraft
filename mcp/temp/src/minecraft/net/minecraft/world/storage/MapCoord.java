package net.minecraft.world.storage;

import net.minecraft.world.storage.MapData;

public class MapCoord {

   public byte field_76216_a;
   public byte field_76214_b;
   public byte field_76215_c;
   public byte field_76212_d;
   // $FF: synthetic field
   final MapData field_76213_e;


   public MapCoord(MapData p_i3905_1_, byte p_i3905_2_, byte p_i3905_3_, byte p_i3905_4_, byte p_i3905_5_) {
      this.field_76213_e = p_i3905_1_;
      this.field_76216_a = p_i3905_2_;
      this.field_76214_b = p_i3905_3_;
      this.field_76215_c = p_i3905_4_;
      this.field_76212_d = p_i3905_5_;
   }
}
