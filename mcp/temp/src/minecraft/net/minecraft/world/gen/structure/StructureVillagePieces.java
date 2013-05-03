package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageChurch;
import net.minecraft.world.gen.structure.ComponentVillageField;
import net.minecraft.world.gen.structure.ComponentVillageField2;
import net.minecraft.world.gen.structure.ComponentVillageHall;
import net.minecraft.world.gen.structure.ComponentVillageHouse1;
import net.minecraft.world.gen.structure.ComponentVillageHouse2;
import net.minecraft.world.gen.structure.ComponentVillageHouse3;
import net.minecraft.world.gen.structure.ComponentVillageHouse4_Garden;
import net.minecraft.world.gen.structure.ComponentVillagePathGen;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.ComponentVillageTorch;
import net.minecraft.world.gen.structure.ComponentVillageWoodHut;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;

public class StructureVillagePieces {

   public static ArrayList func_75084_a(Random p_75084_0_, int p_75084_1_) {
      ArrayList var2 = new ArrayList();
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse4_Garden.class, 4, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageChurch.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse1.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageWoodHut.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHall.class, 15, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageField.class, 3, MathHelper.func_76136_a(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageField2.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse2.class, 15, MathHelper.func_76136_a(p_75084_0_, 0, 1 + p_75084_1_)));
      var2.add(new StructureVillagePieceWeight(ComponentVillageHouse3.class, 8, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         if(((StructureVillagePieceWeight)var3.next()).field_75087_d == 0) {
            var3.remove();
         }
      }

      return var2;
   }

   private static int func_75079_a(List p_75079_0_) {
      boolean var1 = false;
      int var2 = 0;

      StructureVillagePieceWeight var4;
      for(Iterator var3 = p_75079_0_.iterator(); var3.hasNext(); var2 += var4.field_75088_b) {
         var4 = (StructureVillagePieceWeight)var3.next();
         if(var4.field_75087_d > 0 && var4.field_75089_c < var4.field_75087_d) {
            var1 = true;
         }
      }

      return var1?var2:-1;
   }

   private static ComponentVillage func_75083_a(ComponentVillageStartPiece p_75083_0_, StructureVillagePieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, int p_75083_8_) {
      Class var9 = p_75083_1_.field_75090_a;
      Object var10 = null;
      if(var9 == ComponentVillageHouse4_Garden.class) {
         var10 = ComponentVillageHouse4_Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageChurch.class) {
         var10 = ComponentVillageChurch.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageHouse1.class) {
         var10 = ComponentVillageHouse1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageWoodHut.class) {
         var10 = ComponentVillageWoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageHall.class) {
         var10 = ComponentVillageHall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageField.class) {
         var10 = ComponentVillageField.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageField2.class) {
         var10 = ComponentVillageField2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageHouse2.class) {
         var10 = ComponentVillageHouse2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      } else if(var9 == ComponentVillageHouse3.class) {
         var10 = ComponentVillageHouse3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
      }

      return (ComponentVillage)var10;
   }

   private static ComponentVillage func_75081_c(ComponentVillageStartPiece p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_) {
      int var8 = func_75079_a(p_75081_0_.field_74931_h);
      if(var8 <= 0) {
         return null;
      } else {
         int var9 = 0;

         while(var9 < 5) {
            ++var9;
            int var10 = p_75081_2_.nextInt(var8);
            Iterator var11 = p_75081_0_.field_74931_h.iterator();

            while(var11.hasNext()) {
               StructureVillagePieceWeight var12 = (StructureVillagePieceWeight)var11.next();
               var10 -= var12.field_75088_b;
               if(var10 < 0) {
                  if(!var12.func_75085_a(p_75081_7_) || var12 == p_75081_0_.field_74926_d && p_75081_0_.field_74931_h.size() > 1) {
                     break;
                  }

                  ComponentVillage var13 = func_75083_a(p_75081_0_, var12, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);
                  if(var13 != null) {
                     ++var12.field_75089_c;
                     p_75081_0_.field_74926_d = var12;
                     if(!var12.func_75086_a()) {
                        p_75081_0_.field_74931_h.remove(var12);
                     }

                     return var13;
                  }
               }
            }
         }

         StructureBoundingBox var14 = ComponentVillageTorch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);
         if(var14 != null) {
            return new ComponentVillageTorch(p_75081_0_, p_75081_7_, p_75081_2_, var14, p_75081_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_75077_d(ComponentVillageStartPiece p_75077_0_, List p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_) {
      if(p_75077_7_ > 50) {
         return null;
      } else if(Math.abs(p_75077_3_ - p_75077_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75077_5_ - p_75077_0_.func_74874_b().field_78896_c) <= 112) {
         ComponentVillage var8 = func_75081_c(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);
         if(var8 != null) {
            int var9 = (var8.field_74887_e.field_78897_a + var8.field_74887_e.field_78893_d) / 2;
            int var10 = (var8.field_74887_e.field_78896_c + var8.field_74887_e.field_78892_f) / 2;
            int var11 = var8.field_74887_e.field_78893_d - var8.field_74887_e.field_78897_a;
            int var12 = var8.field_74887_e.field_78892_f - var8.field_74887_e.field_78896_c;
            int var13 = var11 > var12?var11:var12;
            if(p_75077_0_.func_74925_d().func_76940_a(var9, var10, var13 / 2 + 4, MapGenVillage.field_75055_e)) {
               p_75077_1_.add(var8);
               p_75077_0_.field_74932_i.add(var8);
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static StructureComponent func_75080_e(ComponentVillageStartPiece p_75080_0_, List p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_) {
      if(p_75080_7_ > 3 + p_75080_0_.field_74928_c) {
         return null;
      } else if(Math.abs(p_75080_3_ - p_75080_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75080_5_ - p_75080_0_.func_74874_b().field_78896_c) <= 112) {
         StructureBoundingBox var8 = ComponentVillagePathGen.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);
         if(var8 != null && var8.field_78895_b > 10) {
            ComponentVillagePathGen var9 = new ComponentVillagePathGen(p_75080_0_, p_75080_7_, p_75080_2_, var8, p_75080_6_);
            int var10 = (var9.field_74887_e.field_78897_a + var9.field_74887_e.field_78893_d) / 2;
            int var11 = (var9.field_74887_e.field_78896_c + var9.field_74887_e.field_78892_f) / 2;
            int var12 = var9.field_74887_e.field_78893_d - var9.field_74887_e.field_78897_a;
            int var13 = var9.field_74887_e.field_78892_f - var9.field_74887_e.field_78896_c;
            int var14 = var12 > var13?var12:var13;
            if(p_75080_0_.func_74925_d().func_76940_a(var10, var11, var14 / 2 + 4, MapGenVillage.field_75055_e)) {
               p_75080_1_.add(var9);
               p_75080_0_.field_74930_j.add(var9);
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static StructureComponent func_75078_a(ComponentVillageStartPiece p_75078_0_, List p_75078_1_, Random p_75078_2_, int p_75078_3_, int p_75078_4_, int p_75078_5_, int p_75078_6_, int p_75078_7_) {
      return func_75077_d(p_75078_0_, p_75078_1_, p_75078_2_, p_75078_3_, p_75078_4_, p_75078_5_, p_75078_6_, p_75078_7_);
   }

   // $FF: synthetic method
   static StructureComponent func_75082_b(ComponentVillageStartPiece p_75082_0_, List p_75082_1_, Random p_75082_2_, int p_75082_3_, int p_75082_4_, int p_75082_5_, int p_75082_6_, int p_75082_7_) {
      return func_75080_e(p_75082_0_, p_75082_1_, p_75082_2_, p_75082_3_, p_75082_4_, p_75082_5_, p_75082_6_, p_75082_7_);
   }
}
