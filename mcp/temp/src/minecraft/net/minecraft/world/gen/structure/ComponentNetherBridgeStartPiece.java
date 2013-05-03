package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.ComponentNetherBridgeCrossing3;
import net.minecraft.world.gen.structure.StructureNetherBridgePieceWeight;
import net.minecraft.world.gen.structure.StructureNetherBridgePieces;

public class ComponentNetherBridgeStartPiece extends ComponentNetherBridgeCrossing3 {

   public StructureNetherBridgePieceWeight field_74970_a;
   public List field_74968_b = new ArrayList();
   public List field_74969_c;
   public ArrayList field_74967_d = new ArrayList();


   public ComponentNetherBridgeStartPiece(Random p_i3831_1_, int p_i3831_2_, int p_i3831_3_) {
      super(p_i3831_1_, p_i3831_2_, p_i3831_3_);
      StructureNetherBridgePieceWeight[] var4 = StructureNetherBridgePieces.func_78739_a();
      int var5 = var4.length;

      int var6;
      StructureNetherBridgePieceWeight var7;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var4[var6];
         var7.field_78827_c = 0;
         this.field_74968_b.add(var7);
      }

      this.field_74969_c = new ArrayList();
      var4 = StructureNetherBridgePieces.func_78737_b();
      var5 = var4.length;

      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var4[var6];
         var7.field_78827_c = 0;
         this.field_74969_c.add(var7);
      }

   }
}
