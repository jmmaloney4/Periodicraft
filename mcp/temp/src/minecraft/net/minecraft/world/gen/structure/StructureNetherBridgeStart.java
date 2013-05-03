package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentNetherBridgeStartPiece;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

class StructureNetherBridgeStart extends StructureStart {

   public StructureNetherBridgeStart(World p_i3812_1_, Random p_i3812_2_, int p_i3812_3_, int p_i3812_4_) {
      ComponentNetherBridgeStartPiece var5 = new ComponentNetherBridgeStartPiece(p_i3812_2_, (p_i3812_3_ << 4) + 2, (p_i3812_4_ << 4) + 2);
      this.field_75075_a.add(var5);
      var5.func_74861_a(var5, this.field_75075_a, p_i3812_2_);
      ArrayList var6 = var5.field_74967_d;

      while(!var6.isEmpty()) {
         int var7 = p_i3812_2_.nextInt(var6.size());
         StructureComponent var8 = (StructureComponent)var6.remove(var7);
         var8.func_74861_a(var5, this.field_75075_a, p_i3812_2_);
      }

      this.func_75072_c();
      this.func_75070_a(p_i3812_1_, p_i3812_2_, 48, 70);
   }
}
