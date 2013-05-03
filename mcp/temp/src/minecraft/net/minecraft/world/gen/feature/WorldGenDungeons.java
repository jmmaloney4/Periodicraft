package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDungeons extends WorldGenerator {

   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
      byte var6 = 3;
      int var7 = p_76484_2_.nextInt(2) + 2;
      int var8 = p_76484_2_.nextInt(2) + 2;
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      for(var10 = p_76484_3_ - var7 - 1; var10 <= p_76484_3_ + var7 + 1; ++var10) {
         for(var11 = p_76484_4_ - 1; var11 <= p_76484_4_ + var6 + 1; ++var11) {
            for(var12 = p_76484_5_ - var8 - 1; var12 <= p_76484_5_ + var8 + 1; ++var12) {
               Material var13 = p_76484_1_.func_72803_f(var10, var11, var12);
               if(var11 == p_76484_4_ - 1 && !var13.func_76220_a()) {
                  return false;
               }

               if(var11 == p_76484_4_ + var6 + 1 && !var13.func_76220_a()) {
                  return false;
               }

               if((var10 == p_76484_3_ - var7 - 1 || var10 == p_76484_3_ + var7 + 1 || var12 == p_76484_5_ - var8 - 1 || var12 == p_76484_5_ + var8 + 1) && var11 == p_76484_4_ && p_76484_1_.func_72799_c(var10, var11, var12) && p_76484_1_.func_72799_c(var10, var11 + 1, var12)) {
                  ++var9;
               }
            }
         }
      }

      if(var9 >= 1 && var9 <= 5) {
         for(var10 = p_76484_3_ - var7 - 1; var10 <= p_76484_3_ + var7 + 1; ++var10) {
            for(var11 = p_76484_4_ + var6; var11 >= p_76484_4_ - 1; --var11) {
               for(var12 = p_76484_5_ - var8 - 1; var12 <= p_76484_5_ + var8 + 1; ++var12) {
                  if(var10 != p_76484_3_ - var7 - 1 && var11 != p_76484_4_ - 1 && var12 != p_76484_5_ - var8 - 1 && var10 != p_76484_3_ + var7 + 1 && var11 != p_76484_4_ + var6 + 1 && var12 != p_76484_5_ + var8 + 1) {
                     p_76484_1_.func_94571_i(var10, var11, var12);
                  } else if(var11 >= 0 && !p_76484_1_.func_72803_f(var10, var11 - 1, var12).func_76220_a()) {
                     p_76484_1_.func_94571_i(var10, var11, var12);
                  } else if(p_76484_1_.func_72803_f(var10, var11, var12).func_76220_a()) {
                     if(var11 == p_76484_4_ - 1 && p_76484_2_.nextInt(4) != 0) {
                        p_76484_1_.func_72832_d(var10, var11, var12, Block.field_72087_ao.field_71990_ca, 0, 2);
                     } else {
                        p_76484_1_.func_72832_d(var10, var11, var12, Block.field_71978_w.field_71990_ca, 0, 2);
                     }
                  }
               }
            }
         }

         var10 = 0;

         while(var10 < 2) {
            var11 = 0;

            while(true) {
               if(var11 < 3) {
                  label210: {
                     var12 = p_76484_3_ + p_76484_2_.nextInt(var7 * 2 + 1) - var7;
                     int var14 = p_76484_5_ + p_76484_2_.nextInt(var8 * 2 + 1) - var8;
                     if(p_76484_1_.func_72799_c(var12, p_76484_4_, var14)) {
                        int var15 = 0;
                        if(p_76484_1_.func_72803_f(var12 - 1, p_76484_4_, var14).func_76220_a()) {
                           ++var15;
                        }

                        if(p_76484_1_.func_72803_f(var12 + 1, p_76484_4_, var14).func_76220_a()) {
                           ++var15;
                        }

                        if(p_76484_1_.func_72803_f(var12, p_76484_4_, var14 - 1).func_76220_a()) {
                           ++var15;
                        }

                        if(p_76484_1_.func_72803_f(var12, p_76484_4_, var14 + 1).func_76220_a()) {
                           ++var15;
                        }

                        if(var15 == 1) {
                           p_76484_1_.func_72832_d(var12, p_76484_4_, var14, Block.field_72077_au.field_71990_ca, 0, 2);
                           TileEntityChest var16 = (TileEntityChest)p_76484_1_.func_72796_p(var12, p_76484_4_, var14);
                           if(var16 != null) {
                              for(int var17 = 0; var17 < 8; ++var17) {
                                 ItemStack var18 = this.func_76544_a(p_76484_2_);
                                 if(var18 != null) {
                                    var16.func_70299_a(p_76484_2_.nextInt(var16.func_70302_i_()), var18);
                                 }
                              }
                           }
                           break label210;
                        }
                     }

                     ++var11;
                     continue;
                  }
               }

               ++var10;
               break;
            }
         }

         p_76484_1_.func_72832_d(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_72065_as.field_71990_ca, 0, 2);
         TileEntityMobSpawner var19 = (TileEntityMobSpawner)p_76484_1_.func_72796_p(p_76484_3_, p_76484_4_, p_76484_5_);
         if(var19 != null) {
            var19.func_98049_a().func_98272_a(this.func_76543_b(p_76484_2_));
         } else {
            System.err.println("Failed to fetch mob spawner entity at (" + p_76484_3_ + ", " + p_76484_4_ + ", " + p_76484_5_ + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private ItemStack func_76544_a(Random p_76544_1_) {
      int var2 = p_76544_1_.nextInt(12);
      return var2 == 0?new ItemStack(Item.field_77765_aA):(var2 == 1?new ItemStack(Item.field_77703_o, p_76544_1_.nextInt(4) + 1):(var2 == 2?new ItemStack(Item.field_77684_U):(var2 == 3?new ItemStack(Item.field_77685_T, p_76544_1_.nextInt(4) + 1):(var2 == 4?new ItemStack(Item.field_77677_M, p_76544_1_.nextInt(4) + 1):(var2 == 5?new ItemStack(Item.field_77683_K, p_76544_1_.nextInt(4) + 1):(var2 == 6?new ItemStack(Item.field_77788_aw):(var2 == 7 && p_76544_1_.nextInt(100) == 0?new ItemStack(Item.field_77778_at):(var2 == 8 && p_76544_1_.nextInt(2) == 0?new ItemStack(Item.field_77767_aC, p_76544_1_.nextInt(4) + 1):(var2 == 9 && p_76544_1_.nextInt(10) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + p_76544_1_.nextInt(2)]):(var2 == 10?new ItemStack(Item.field_77756_aW, 1, 3):(var2 == 11?Item.field_92105_bW.func_92109_a(p_76544_1_):null)))))))))));
   }

   private String func_76543_b(Random p_76543_1_) {
      int var2 = p_76543_1_.nextInt(4);
      return var2 == 0?"Skeleton":(var2 == 1?"Zombie":(var2 == 2?"Zombie":(var2 == 3?"Spider":"")));
   }
}
