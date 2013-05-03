package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.ComponentVillageWell;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;

public class ComponentVillageStartPiece extends ComponentVillageWell {

   public final WorldChunkManager field_74929_a;
   public final boolean field_74927_b;
   public final int field_74928_c;
   public StructureVillagePieceWeight field_74926_d;
   public ArrayList field_74931_h;
   public ArrayList field_74932_i = new ArrayList();
   public ArrayList field_74930_j = new ArrayList();


   public ComponentVillageStartPiece(WorldChunkManager p_i3870_1_, int p_i3870_2_, Random p_i3870_3_, int p_i3870_4_, int p_i3870_5_, ArrayList p_i3870_6_, int p_i3870_7_) {
      super((ComponentVillageStartPiece)null, 0, p_i3870_3_, p_i3870_4_, p_i3870_5_);
      this.field_74929_a = p_i3870_1_;
      this.field_74931_h = p_i3870_6_;
      this.field_74928_c = p_i3870_7_;
      BiomeGenBase var8 = p_i3870_1_.func_76935_a(p_i3870_4_, p_i3870_5_);
      this.field_74927_b = var8 == BiomeGenBase.field_76769_d || var8 == BiomeGenBase.field_76786_s;
      this.field_74897_k = this;
   }

   public WorldChunkManager func_74925_d() {
      return this.field_74929_a;
   }
}
