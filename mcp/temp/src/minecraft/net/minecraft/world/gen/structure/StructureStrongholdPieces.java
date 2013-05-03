package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.world.gen.structure.ComponentStronghold;
import net.minecraft.world.gen.structure.ComponentStrongholdChestCorridor;
import net.minecraft.world.gen.structure.ComponentStrongholdCorridor;
import net.minecraft.world.gen.structure.ComponentStrongholdCrossing;
import net.minecraft.world.gen.structure.ComponentStrongholdLeftTurn;
import net.minecraft.world.gen.structure.ComponentStrongholdLibrary;
import net.minecraft.world.gen.structure.ComponentStrongholdPortalRoom;
import net.minecraft.world.gen.structure.ComponentStrongholdPrison;
import net.minecraft.world.gen.structure.ComponentStrongholdRightTurn;
import net.minecraft.world.gen.structure.ComponentStrongholdRoomCrossing;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs;
import net.minecraft.world.gen.structure.ComponentStrongholdStairs2;
import net.minecraft.world.gen.structure.ComponentStrongholdStairsStraight;
import net.minecraft.world.gen.structure.ComponentStrongholdStraight;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieceWeight;
import net.minecraft.world.gen.structure.StructureStrongholdPieceWeight2;
import net.minecraft.world.gen.structure.StructureStrongholdPieceWeight3;
import net.minecraft.world.gen.structure.StructureStrongholdStones;

public class StructureStrongholdPieces {

   private static final StructureStrongholdPieceWeight[] field_75205_b = new StructureStrongholdPieceWeight[]{new StructureStrongholdPieceWeight(ComponentStrongholdStraight.class, 40, 0), new StructureStrongholdPieceWeight(ComponentStrongholdPrison.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdLeftTurn.class, 20, 0), new StructureStrongholdPieceWeight(ComponentStrongholdRightTurn.class, 20, 0), new StructureStrongholdPieceWeight(ComponentStrongholdRoomCrossing.class, 10, 6), new StructureStrongholdPieceWeight(ComponentStrongholdStairsStraight.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdStairs.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdCrossing.class, 5, 4), new StructureStrongholdPieceWeight(ComponentStrongholdChestCorridor.class, 5, 4), new StructureStrongholdPieceWeight2(ComponentStrongholdLibrary.class, 10, 2), new StructureStrongholdPieceWeight3(ComponentStrongholdPortalRoom.class, 20, 1)};
   private static List field_75206_c;
   private static Class field_75203_d;
   static int field_75207_a = 0;
   private static final StructureStrongholdStones field_75204_e = new StructureStrongholdStones((StructureStrongholdPieceWeight2)null);


   public static void func_75198_a() {
      field_75206_c = new ArrayList();
      StructureStrongholdPieceWeight[] var0 = field_75205_b;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         StructureStrongholdPieceWeight var3 = var0[var2];
         var3.field_75193_c = 0;
         field_75206_c.add(var3);
      }

      field_75203_d = null;
   }

   private static boolean func_75202_c() {
      boolean var0 = false;
      field_75207_a = 0;

      StructureStrongholdPieceWeight var2;
      for(Iterator var1 = field_75206_c.iterator(); var1.hasNext(); field_75207_a += var2.field_75192_b) {
         var2 = (StructureStrongholdPieceWeight)var1.next();
         if(var2.field_75191_d > 0 && var2.field_75193_c < var2.field_75191_d) {
            var0 = true;
         }
      }

      return var0;
   }

   private static ComponentStronghold func_75200_a(Class p_75200_0_, List p_75200_1_, Random p_75200_2_, int p_75200_3_, int p_75200_4_, int p_75200_5_, int p_75200_6_, int p_75200_7_) {
      Object var8 = null;
      if(p_75200_0_ == ComponentStrongholdStraight.class) {
         var8 = ComponentStrongholdStraight.func_75018_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdPrison.class) {
         var8 = ComponentStrongholdPrison.func_75016_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdLeftTurn.class) {
         var8 = ComponentStrongholdLeftTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdRightTurn.class) {
         var8 = ComponentStrongholdRightTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdRoomCrossing.class) {
         var8 = ComponentStrongholdRoomCrossing.func_75012_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdStairsStraight.class) {
         var8 = ComponentStrongholdStairsStraight.func_75028_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdStairs.class) {
         var8 = ComponentStrongholdStairs.func_75022_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdCrossing.class) {
         var8 = ComponentStrongholdCrossing.func_74994_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdChestCorridor.class) {
         var8 = ComponentStrongholdChestCorridor.func_75000_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdLibrary.class) {
         var8 = ComponentStrongholdLibrary.func_75006_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      } else if(p_75200_0_ == ComponentStrongholdPortalRoom.class) {
         var8 = ComponentStrongholdPortalRoom.func_75004_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
      }

      return (ComponentStronghold)var8;
   }

   private static ComponentStronghold func_75201_b(ComponentStrongholdStairs2 p_75201_0_, List p_75201_1_, Random p_75201_2_, int p_75201_3_, int p_75201_4_, int p_75201_5_, int p_75201_6_, int p_75201_7_) {
      if(!func_75202_c()) {
         return null;
      } else {
         if(field_75203_d != null) {
            ComponentStronghold var8 = func_75200_a(field_75203_d, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
            field_75203_d = null;
            if(var8 != null) {
               return var8;
            }
         }

         int var13 = 0;

         while(var13 < 5) {
            ++var13;
            int var9 = p_75201_2_.nextInt(field_75207_a);
            Iterator var10 = field_75206_c.iterator();

            while(var10.hasNext()) {
               StructureStrongholdPieceWeight var11 = (StructureStrongholdPieceWeight)var10.next();
               var9 -= var11.field_75192_b;
               if(var9 < 0) {
                  if(!var11.func_75189_a(p_75201_7_) || var11 == p_75201_0_.field_75027_a) {
                     break;
                  }

                  ComponentStronghold var12 = func_75200_a(var11.field_75194_a, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
                  if(var12 != null) {
                     ++var11.field_75193_c;
                     p_75201_0_.field_75027_a = var11;
                     if(!var11.func_75190_a()) {
                        field_75206_c.remove(var11);
                     }

                     return var12;
                  }
               }
            }
         }

         StructureBoundingBox var14 = ComponentStrongholdCorridor.func_74992_a(p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_);
         if(var14 != null && var14.field_78895_b > 1) {
            return new ComponentStrongholdCorridor(p_75201_7_, p_75201_2_, var14, p_75201_6_);
         } else {
            return null;
         }
      }
   }

   private static StructureComponent func_75196_c(ComponentStrongholdStairs2 p_75196_0_, List p_75196_1_, Random p_75196_2_, int p_75196_3_, int p_75196_4_, int p_75196_5_, int p_75196_6_, int p_75196_7_) {
      if(p_75196_7_ > 50) {
         return null;
      } else if(Math.abs(p_75196_3_ - p_75196_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75196_5_ - p_75196_0_.func_74874_b().field_78896_c) <= 112) {
         ComponentStronghold var8 = func_75201_b(p_75196_0_, p_75196_1_, p_75196_2_, p_75196_3_, p_75196_4_, p_75196_5_, p_75196_6_, p_75196_7_ + 1);
         if(var8 != null) {
            p_75196_1_.add(var8);
            p_75196_0_.field_75026_c.add(var8);
         }

         return var8;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static StructureComponent func_75195_a(ComponentStrongholdStairs2 p_75195_0_, List p_75195_1_, Random p_75195_2_, int p_75195_3_, int p_75195_4_, int p_75195_5_, int p_75195_6_, int p_75195_7_) {
      return func_75196_c(p_75195_0_, p_75195_1_, p_75195_2_, p_75195_3_, p_75195_4_, p_75195_5_, p_75195_6_, p_75195_7_);
   }

   // $FF: synthetic method
   static Class func_75199_a(Class p_75199_0_) {
      field_75203_d = p_75199_0_;
      return p_75199_0_;
   }

   // $FF: synthetic method
   static StructureStrongholdStones func_75197_b() {
      return field_75204_e;
   }

}
