package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapInfo;

public class ItemMap extends ItemMapBase {

   protected ItemMap(int p_i3668_1_) {
      super(p_i3668_1_);
      this.func_77627_a(true);
   }

   @SideOnly(Side.CLIENT)
   public static MapData func_77874_a(short p_77874_0_, World p_77874_1_) {
      String var2 = "map_" + p_77874_0_;
      MapData var3 = (MapData)p_77874_1_.func_72943_a(MapData.class, var2);
      if(var3 == null) {
         var3 = new MapData(var2);
         p_77874_1_.func_72823_a(var2, var3);
      }

      return var3;
   }

   public MapData func_77873_a(ItemStack p_77873_1_, World p_77873_2_) {
      String var3 = "map_" + p_77873_1_.func_77960_j();
      MapData var4 = (MapData)p_77873_2_.func_72943_a(MapData.class, var3);
      if(var4 == null && !p_77873_2_.field_72995_K) {
         p_77873_1_.func_77964_b(p_77873_2_.func_72841_b("map"));
         var3 = "map_" + p_77873_1_.func_77960_j();
         var4 = new MapData(var3);
         var4.field_76197_d = 3;
         int var5 = 128 * (1 << var4.field_76197_d);
         var4.field_76201_a = Math.round((float)p_77873_2_.func_72912_H().func_76079_c() / (float)var5) * var5;
         var4.field_76199_b = Math.round((float)(p_77873_2_.func_72912_H().func_76074_e() / var5)) * var5;
         var4.field_76200_c = (byte)p_77873_2_.field_73011_w.field_76574_g;
         var4.func_76185_a();
         p_77873_2_.func_72823_a(var3, var4);
      }

      return var4;
   }

   public void func_77872_a(World p_77872_1_, Entity p_77872_2_, MapData p_77872_3_) {
      if(p_77872_1_.field_73011_w.field_76574_g == p_77872_3_.field_76200_c && p_77872_2_ instanceof EntityPlayer) {
         short var4 = 128;
         short var5 = 128;
         int var6 = 1 << p_77872_3_.field_76197_d;
         int var7 = p_77872_3_.field_76201_a;
         int var8 = p_77872_3_.field_76199_b;
         int var9 = MathHelper.func_76128_c(p_77872_2_.field_70165_t - (double)var7) / var6 + var4 / 2;
         int var10 = MathHelper.func_76128_c(p_77872_2_.field_70161_v - (double)var8) / var6 + var5 / 2;
         int var11 = 128 / var6;
         if(p_77872_1_.field_73011_w.field_76576_e) {
            var11 /= 2;
         }

         MapInfo var12 = p_77872_3_.func_82568_a((EntityPlayer)p_77872_2_);
         ++var12.field_82569_d;

         for(int var13 = var9 - var11 + 1; var13 < var9 + var11; ++var13) {
            if((var13 & 15) == (var12.field_82569_d & 15)) {
               int var14 = 255;
               int var15 = 0;
               double var16 = 0.0D;

               for(int var18 = var10 - var11 - 1; var18 < var10 + var11; ++var18) {
                  if(var13 >= 0 && var18 >= -1 && var13 < var4 && var18 < var5) {
                     int var19 = var13 - var9;
                     int var20 = var18 - var10;
                     boolean var21 = var19 * var19 + var20 * var20 > (var11 - 2) * (var11 - 2);
                     int var22 = (var7 / var6 + var13 - var4 / 2) * var6;
                     int var23 = (var8 / var6 + var18 - var5 / 2) * var6;
                     int[] var24 = new int[256];
                     Chunk var25 = p_77872_1_.func_72938_d(var22, var23);
                     if(!var25.func_76621_g()) {
                        int var26 = var22 & 15;
                        int var27 = var23 & 15;
                        int var28 = 0;
                        double var29 = 0.0D;
                        int var31;
                        int var32;
                        int var33;
                        int var36;
                        if(p_77872_1_.field_73011_w.field_76576_e) {
                           var31 = var22 + var23 * 231871;
                           var31 = var31 * var31 * 31287121 + var31 * 11;
                           if((var31 >> 20 & 1) == 0) {
                              var24[Block.field_71979_v.field_71990_ca] += 10;
                           } else {
                              var24[Block.field_71981_t.field_71990_ca] += 10;
                           }

                           var29 = 100.0D;
                        } else {
                           for(var31 = 0; var31 < var6; ++var31) {
                              for(var32 = 0; var32 < var6; ++var32) {
                                 var33 = var25.func_76611_b(var31 + var26, var32 + var27) + 1;
                                 int var34 = 0;
                                 if(var33 > 1) {
                                    boolean var35;
                                    do {
                                       var35 = true;
                                       var34 = var25.func_76610_a(var31 + var26, var33 - 1, var32 + var27);
                                       if(var34 == 0) {
                                          var35 = false;
                                       } else if(var33 > 0 && var34 > 0 && Block.field_71973_m[var34].field_72018_cp.field_76234_F == MapColor.field_76279_b) {
                                          var35 = false;
                                       }

                                       if(!var35) {
                                          --var33;
                                          if(var33 <= 0) {
                                             break;
                                          }

                                          var34 = var25.func_76610_a(var31 + var26, var33 - 1, var32 + var27);
                                       }
                                    } while(var33 > 0 && !var35);

                                    if(var33 > 0 && var34 != 0 && Block.field_71973_m[var34].field_72018_cp.func_76224_d()) {
                                       var36 = var33 - 1;
                                       boolean var37 = false;

                                       int var43;
                                       do {
                                          var43 = var25.func_76610_a(var31 + var26, var36--, var32 + var27);
                                          ++var28;
                                       } while(var36 > 0 && var43 != 0 && Block.field_71973_m[var43].field_72018_cp.func_76224_d());
                                    }
                                 }

                                 var29 += (double)var33 / (double)(var6 * var6);
                                 ++var24[var34];
                              }
                           }
                        }

                        var28 /= var6 * var6;
                        var31 = 0;
                        var32 = 0;

                        for(var33 = 0; var33 < 256; ++var33) {
                           if(var24[var33] > var31) {
                              var32 = var33;
                              var31 = var24[var33];
                           }
                        }

                        double var40 = (var29 - var16) * 4.0D / (double)(var6 + 4) + ((double)(var13 + var18 & 1) - 0.5D) * 0.4D;
                        byte var39 = 1;
                        if(var40 > 0.6D) {
                           var39 = 2;
                        }

                        if(var40 < -0.6D) {
                           var39 = 0;
                        }

                        var36 = 0;
                        if(var32 > 0) {
                           MapColor var42 = Block.field_71973_m[var32].field_72018_cp.field_76234_F;
                           if(var42 == MapColor.field_76282_n) {
                              var40 = (double)var28 * 0.1D + (double)(var13 + var18 & 1) * 0.2D;
                              var39 = 1;
                              if(var40 < 0.5D) {
                                 var39 = 2;
                              }

                              if(var40 > 0.9D) {
                                 var39 = 0;
                              }
                           }

                           var36 = var42.field_76290_q;
                        }

                        var16 = var29;
                        if(var18 >= 0 && var19 * var19 + var20 * var20 < var11 * var11 && (!var21 || (var13 + var18 & 1) != 0)) {
                           byte var41 = p_77872_3_.field_76198_e[var13 + var18 * var4];
                           byte var38 = (byte)(var36 * 4 + var39);
                           if(var41 != var38) {
                              if(var14 > var18) {
                                 var14 = var18;
                              }

                              if(var15 < var18) {
                                 var15 = var18;
                              }

                              p_77872_3_.field_76198_e[var13 + var18 * var4] = var38;
                           }
                        }
                     }
                  }
               }

               if(var14 <= var15) {
                  p_77872_3_.func_76194_a(var13, var14, var15);
               }
            }
         }

      }
   }

   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
      if(!p_77663_2_.field_72995_K) {
         MapData var6 = this.func_77873_a(p_77663_1_, p_77663_2_);
         if(p_77663_3_ instanceof EntityPlayer) {
            EntityPlayer var7 = (EntityPlayer)p_77663_3_;
            var6.func_76191_a(var7, p_77663_1_);
         }

         if(p_77663_5_) {
            this.func_77872_a(p_77663_2_, p_77663_3_, var6);
         }

      }
   }

   public Packet func_77871_c(ItemStack p_77871_1_, World p_77871_2_, EntityPlayer p_77871_3_) {
      byte[] var4 = this.func_77873_a(p_77871_1_, p_77871_2_).func_76193_a(p_77871_1_, p_77871_2_, p_77871_3_);
      return var4 == null?null:new Packet131MapData((short)Item.field_77744_bd.field_77779_bT, (short)p_77871_1_.func_77960_j(), var4);
   }

   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
      if(p_77622_1_.func_77942_o() && p_77622_1_.func_77978_p().func_74767_n("map_is_scaling")) {
         MapData var4 = Item.field_77744_bd.func_77873_a(p_77622_1_, p_77622_2_);
         p_77622_1_.func_77964_b(p_77622_2_.func_72841_b("map"));
         MapData var5 = new MapData("map_" + p_77622_1_.func_77960_j());
         var5.field_76197_d = (byte)(var4.field_76197_d + 1);
         if(var5.field_76197_d > 4) {
            var5.field_76197_d = 4;
         }

         var5.field_76201_a = var4.field_76201_a;
         var5.field_76199_b = var4.field_76199_b;
         var5.field_76200_c = var4.field_76200_c;
         var5.func_76185_a();
         p_77622_2_.func_72823_a("map_" + p_77622_1_.func_77960_j(), var5);
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
      MapData var5 = this.func_77873_a(p_77624_1_, p_77624_2_.field_70170_p);
      if(p_77624_4_) {
         if(var5 == null) {
            p_77624_3_.add("Unknown map");
         } else {
            p_77624_3_.add("Scaling at 1:" + (1 << var5.field_76197_d));
            p_77624_3_.add("(Level " + var5.field_76197_d + "/" + 4 + ")");
         }
      }

   }
}
