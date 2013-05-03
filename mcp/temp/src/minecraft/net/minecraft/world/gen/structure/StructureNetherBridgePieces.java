package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor2;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor3;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor4;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCorridor5;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCrossing;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCrossing2;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCrossing3;
import net.minecraft.world.gen.structure.ComponentNetherBridgeEntrance;
import net.minecraft.world.gen.structure.ComponentNetherBridgeNetherStalkRoom;
import net.minecraft.world.gen.structure.ComponentNetherBridgePiece;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStairs;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStraight;
import net.minecraft.world.gen.structure.ComponentNetherBridgeThrone;
import net.minecraft.world.gen.structure.StructureNetherBridgePieceWeight;

public class StructureNetherBridgePieces {

   private static final StructureNetherBridgePieceWeight[] field_78742_a = new StructureNetherBridgePieceWeight[]{new StructureNetherBridgePieceWeight(ComponentNetherBridgeStraight.class, 30, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing3.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeStairs.class, 10, 3), new StructureNetherBridgePieceWeight(ComponentNetherBridgeThrone.class, 5, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeEntrance.class, 5, 1)};
   private static final StructureNetherBridgePieceWeight[] field_78741_b = new StructureNetherBridgePieceWeight[]{new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor5.class, 25, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing2.class, 15, 5), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor2.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor3.class, 10, 3, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor4.class, 7, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeNetherStalkRoom.class, 5, 2)};


   private static ComponentNetherBridgePiece func_78738_b(StructureNetherBridgePieceWeight p_78738_0_, List p_78738_1_, Random p_78738_2_, int p_78738_3_, int p_78738_4_, int p_78738_5_, int p_78738_6_, int p_78738_7_) {
      Class var8 = p_78738_0_.field_78828_a;
      Object var9 = null;
      if(var8 == ComponentNetherBridgeStraight.class) {
         var9 = ComponentNetherBridgeStraight.func_74983_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCrossing3.class) {
         var9 = ComponentNetherBridgeCrossing3.func_74966_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCrossing.class) {
         var9 = ComponentNetherBridgeCrossing.func_74974_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeStairs.class) {
         var9 = ComponentNetherBridgeStairs.func_74973_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeThrone.class) {
         var9 = ComponentNetherBridgeThrone.func_74975_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeEntrance.class) {
         var9 = ComponentNetherBridgeEntrance.func_74984_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCorridor5.class) {
         var9 = ComponentNetherBridgeCorridor5.func_74981_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCorridor2.class) {
         var9 = ComponentNetherBridgeCorridor2.func_74980_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCorridor.class) {
         var9 = ComponentNetherBridgeCorridor.func_74978_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCorridor3.class) {
         var9 = ComponentNetherBridgeCorridor3.func_74982_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCorridor4.class) {
         var9 = ComponentNetherBridgeCorridor4.func_74985_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeCrossing2.class) {
         var9 = ComponentNetherBridgeCrossing2.func_74979_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      } else if(var8 == ComponentNetherBridgeNetherStalkRoom.class) {
         var9 = ComponentNetherBridgeNetherStalkRoom.func_74977_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
      }

      return (ComponentNetherBridgePiece)var9;
   }

   // $FF: synthetic method
   static ComponentNetherBridgePiece func_78740_a(StructureNetherBridgePieceWeight p_78740_0_, List p_78740_1_, Random p_78740_2_, int p_78740_3_, int p_78740_4_, int p_78740_5_, int p_78740_6_, int p_78740_7_) {
      return func_78738_b(p_78740_0_, p_78740_1_, p_78740_2_, p_78740_3_, p_78740_4_, p_78740_5_, p_78740_6_, p_78740_7_);
   }

   // $FF: synthetic method
   static StructureNetherBridgePieceWeight[] func_78739_a() {
      return field_78742_a;
   }

   // $FF: synthetic method
   static StructureNetherBridgePieceWeight[] func_78737_b() {
      return field_78741_b;
   }

}
