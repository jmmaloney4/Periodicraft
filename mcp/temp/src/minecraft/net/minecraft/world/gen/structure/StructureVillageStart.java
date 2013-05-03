package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillageRoadPiece;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillagePieces;

class StructureVillageStart extends StructureStart {

   private boolean field_75076_c = false;


   public StructureVillageStart(World p_i3858_1_, Random p_i3858_2_, int p_i3858_3_, int p_i3858_4_, int p_i3858_5_) {
      ArrayList var6 = StructureVillagePieces.func_75084_a(p_i3858_2_, p_i3858_5_);
      ComponentVillageStartPiece var7 = new ComponentVillageStartPiece(p_i3858_1_.func_72959_q(), 0, p_i3858_2_, (p_i3858_3_ << 4) + 2, (p_i3858_4_ << 4) + 2, var6, p_i3858_5_);
      this.field_75075_a.add(var7);
      var7.func_74861_a(var7, this.field_75075_a, p_i3858_2_);
      ArrayList var8 = var7.field_74930_j;
      ArrayList var9 = var7.field_74932_i;

      int var10;
      while(!var8.isEmpty() || !var9.isEmpty()) {
         StructureComponent var11;
         if(var8.isEmpty()) {
            var10 = p_i3858_2_.nextInt(var9.size());
            var11 = (StructureComponent)var9.remove(var10);
            var11.func_74861_a(var7, this.field_75075_a, p_i3858_2_);
         } else {
            var10 = p_i3858_2_.nextInt(var8.size());
            var11 = (StructureComponent)var8.remove(var10);
            var11.func_74861_a(var7, this.field_75075_a, p_i3858_2_);
         }
      }

      this.func_75072_c();
      var10 = 0;
      Iterator var13 = this.field_75075_a.iterator();

      while(var13.hasNext()) {
         StructureComponent var12 = (StructureComponent)var13.next();
         if(!(var12 instanceof ComponentVillageRoadPiece)) {
            ++var10;
         }
      }

      this.field_75076_c = var10 > 2;
   }

   public boolean func_75069_d() {
      return this.field_75076_c;
   }
}
