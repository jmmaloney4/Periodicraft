package net.minecraft.world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;

public final class SpawnerAnimals {

   private static HashMap field_77193_b = new HashMap();
   protected static final Class[] field_77194_a = new Class[]{EntitySpider.class, EntityZombie.class, EntitySkeleton.class};


   protected static ChunkPosition func_77189_a(World p_77189_0_, int p_77189_1_, int p_77189_2_) {
      Chunk var3 = p_77189_0_.func_72964_e(p_77189_1_, p_77189_2_);
      int var4 = p_77189_1_ * 16 + p_77189_0_.field_73012_v.nextInt(16);
      int var5 = p_77189_2_ * 16 + p_77189_0_.field_73012_v.nextInt(16);
      int var6 = p_77189_0_.field_73012_v.nextInt(var3 == null?p_77189_0_.func_72940_L():var3.func_76625_h() + 16 - 1);
      return new ChunkPosition(var4, var6, var5);
   }

   public static final int func_77192_a(WorldServer p_77192_0_, boolean p_77192_1_, boolean p_77192_2_, boolean p_77192_3_) {
      if(!p_77192_1_ && !p_77192_2_) {
         return 0;
      } else {
         field_77193_b.clear();

         int var4;
         int var7;
         for(var4 = 0; var4 < p_77192_0_.field_73010_i.size(); ++var4) {
            EntityPlayer var5 = (EntityPlayer)p_77192_0_.field_73010_i.get(var4);
            int var6 = MathHelper.func_76128_c(var5.field_70165_t / 16.0D);
            var7 = MathHelper.func_76128_c(var5.field_70161_v / 16.0D);
            byte var8 = 8;

            for(int var9 = -var8; var9 <= var8; ++var9) {
               for(int var10 = -var8; var10 <= var8; ++var10) {
                  boolean var11 = var9 == -var8 || var9 == var8 || var10 == -var8 || var10 == var8;
                  ChunkCoordIntPair var12 = new ChunkCoordIntPair(var9 + var6, var10 + var7);
                  if(!var11) {
                     field_77193_b.put(var12, Boolean.valueOf(false));
                  } else if(!field_77193_b.containsKey(var12)) {
                     field_77193_b.put(var12, Boolean.valueOf(true));
                  }
               }
            }
         }

         var4 = 0;
         ChunkCoordinates var32 = p_77192_0_.func_72861_E();
         EnumCreatureType[] var33 = EnumCreatureType.values();
         var7 = var33.length;

         for(int var34 = 0; var34 < var7; ++var34) {
            EnumCreatureType var35 = var33[var34];
            if((!var35.func_75599_d() || p_77192_2_) && (var35.func_75599_d() || p_77192_1_) && (!var35.func_82705_e() || p_77192_3_) && p_77192_0_.func_72907_a(var35.func_75598_a()) <= var35.func_75601_b() * field_77193_b.size() / 256) {
               Iterator var37 = field_77193_b.keySet().iterator();

               label110:
               while(var37.hasNext()) {
                  ChunkCoordIntPair var36 = (ChunkCoordIntPair)var37.next();
                  if(!((Boolean)field_77193_b.get(var36)).booleanValue()) {
                     ChunkPosition var38 = func_77189_a(p_77192_0_, var36.field_77276_a, var36.field_77275_b);
                     int var13 = var38.field_76930_a;
                     int var14 = var38.field_76928_b;
                     int var15 = var38.field_76929_c;
                     if(!p_77192_0_.func_72809_s(var13, var14, var15) && p_77192_0_.func_72803_f(var13, var14, var15) == var35.func_75600_c()) {
                        int var16 = 0;
                        int var17 = 0;

                        while(var17 < 3) {
                           int var18 = var13;
                           int var19 = var14;
                           int var20 = var15;
                           byte var21 = 6;
                           SpawnListEntry var22 = null;
                           int var23 = 0;

                           while(true) {
                              if(var23 < 4) {
                                 label103: {
                                    var18 += p_77192_0_.field_73012_v.nextInt(var21) - p_77192_0_.field_73012_v.nextInt(var21);
                                    var19 += p_77192_0_.field_73012_v.nextInt(1) - p_77192_0_.field_73012_v.nextInt(1);
                                    var20 += p_77192_0_.field_73012_v.nextInt(var21) - p_77192_0_.field_73012_v.nextInt(var21);
                                    if(func_77190_a(var35, p_77192_0_, var18, var19, var20)) {
                                       float var24 = (float)var18 + 0.5F;
                                       float var25 = (float)var19;
                                       float var26 = (float)var20 + 0.5F;
                                       if(p_77192_0_.func_72977_a((double)var24, (double)var25, (double)var26, 24.0D) == null) {
                                          float var27 = var24 - (float)var32.field_71574_a;
                                          float var28 = var25 - (float)var32.field_71572_b;
                                          float var29 = var26 - (float)var32.field_71573_c;
                                          float var30 = var27 * var27 + var28 * var28 + var29 * var29;
                                          if(var30 >= 576.0F) {
                                             if(var22 == null) {
                                                var22 = p_77192_0_.func_73057_a(var35, var18, var19, var20);
                                                if(var22 == null) {
                                                   break label103;
                                                }
                                             }

                                             EntityLiving var39;
                                             try {
                                                var39 = (EntityLiving)var22.field_76300_b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_77192_0_});
                                             } catch (Exception var31) {
                                                var31.printStackTrace();
                                                return var4;
                                             }

                                             var39.func_70012_b((double)var24, (double)var25, (double)var26, p_77192_0_.field_73012_v.nextFloat() * 360.0F, 0.0F);
                                             if(var39.func_70601_bi()) {
                                                ++var16;
                                                p_77192_0_.func_72838_d(var39);
                                                func_77188_a(var39, p_77192_0_, var24, var25, var26);
                                                if(var16 >= var39.func_70641_bl()) {
                                                   continue label110;
                                                }
                                             }

                                             var4 += var16;
                                          }
                                       }
                                    }

                                    ++var23;
                                    continue;
                                 }
                              }

                              ++var17;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var4;
      }
   }

   public static boolean func_77190_a(EnumCreatureType p_77190_0_, World p_77190_1_, int p_77190_2_, int p_77190_3_, int p_77190_4_) {
      if(p_77190_0_.func_75600_c() == Material.field_76244_g) {
         return p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_, p_77190_4_).func_76224_d() && p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_ - 1, p_77190_4_).func_76224_d() && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_ + 1, p_77190_4_);
      } else if(!p_77190_1_.func_72797_t(p_77190_2_, p_77190_3_ - 1, p_77190_4_)) {
         return false;
      } else {
         int var5 = p_77190_1_.func_72798_a(p_77190_2_, p_77190_3_ - 1, p_77190_4_);
         return var5 != Block.field_71986_z.field_71990_ca && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_, p_77190_4_) && !p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_, p_77190_4_).func_76224_d() && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_ + 1, p_77190_4_);
      }
   }

   private static void func_77188_a(EntityLiving p_77188_0_, World p_77188_1_, float p_77188_2_, float p_77188_3_, float p_77188_4_) {
      p_77188_0_.func_82163_bD();
   }

   public static void func_77191_a(World p_77191_0_, BiomeGenBase p_77191_1_, int p_77191_2_, int p_77191_3_, int p_77191_4_, int p_77191_5_, Random p_77191_6_) {
      List var7 = p_77191_1_.func_76747_a(EnumCreatureType.creature);
      if(!var7.isEmpty()) {
         while(p_77191_6_.nextFloat() < p_77191_1_.func_76741_f()) {
            SpawnListEntry var8 = (SpawnListEntry)WeightedRandom.func_76271_a(p_77191_0_.field_73012_v, var7);
            int var9 = var8.field_76301_c + p_77191_6_.nextInt(1 + var8.field_76299_d - var8.field_76301_c);
            int var10 = p_77191_2_ + p_77191_6_.nextInt(p_77191_4_);
            int var11 = p_77191_3_ + p_77191_6_.nextInt(p_77191_5_);
            int var12 = var10;
            int var13 = var11;

            for(int var14 = 0; var14 < var9; ++var14) {
               boolean var15 = false;

               for(int var16 = 0; !var15 && var16 < 4; ++var16) {
                  int var17 = p_77191_0_.func_72825_h(var10, var11);
                  if(func_77190_a(EnumCreatureType.creature, p_77191_0_, var10, var17, var11)) {
                     float var18 = (float)var10 + 0.5F;
                     float var19 = (float)var17;
                     float var20 = (float)var11 + 0.5F;

                     EntityLiving var21;
                     try {
                        var21 = (EntityLiving)var8.field_76300_b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_77191_0_});
                     } catch (Exception var23) {
                        var23.printStackTrace();
                        continue;
                     }

                     var21.func_70012_b((double)var18, (double)var19, (double)var20, p_77191_6_.nextFloat() * 360.0F, 0.0F);
                     p_77191_0_.func_72838_d(var21);
                     func_77188_a(var21, p_77191_0_, var18, var19, var20);
                     var15 = true;
                  }

                  var10 += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);

                  for(var11 += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5); var10 < p_77191_2_ || var10 >= p_77191_2_ + p_77191_4_ || var11 < p_77191_3_ || var11 >= p_77191_3_ + p_77191_4_; var11 = var13 + p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5)) {
                     var10 = var12 + p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
                  }
               }
            }
         }

      }
   }

}
