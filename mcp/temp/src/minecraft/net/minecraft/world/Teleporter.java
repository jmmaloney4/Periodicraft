package net.minecraft.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.PortalPosition;
import net.minecraft.world.WorldServer;

public class Teleporter {

   private final WorldServer field_85192_a;
   private final Random field_77187_a;
   private final LongHashMap field_85191_c = new LongHashMap();
   private final List field_85190_d = new ArrayList();


   public Teleporter(WorldServer p_i6816_1_) {
      this.field_85192_a = p_i6816_1_;
      this.field_77187_a = new Random(p_i6816_1_.func_72905_C());
   }

   public void func_77185_a(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_) {
      if(this.field_85192_a.field_73011_w.field_76574_g != 1) {
         if(!this.func_77184_b(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_)) {
            this.func_85188_a(p_77185_1_);
            this.func_77184_b(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
         }
      } else {
         int var9 = MathHelper.func_76128_c(p_77185_1_.field_70165_t);
         int var10 = MathHelper.func_76128_c(p_77185_1_.field_70163_u) - 1;
         int var11 = MathHelper.func_76128_c(p_77185_1_.field_70161_v);
         byte var12 = 1;
         byte var13 = 0;

         for(int var14 = -2; var14 <= 2; ++var14) {
            for(int var15 = -2; var15 <= 2; ++var15) {
               for(int var16 = -1; var16 < 3; ++var16) {
                  int var17 = var9 + var15 * var12 + var14 * var13;
                  int var18 = var10 + var16;
                  int var19 = var11 + var15 * var13 - var14 * var12;
                  boolean var20 = var16 < 0;
                  this.field_85192_a.func_94575_c(var17, var18, var19, var20?Block.field_72089_ap.field_71990_ca:0);
               }
            }
         }

         p_77185_1_.func_70012_b((double)var9, (double)var10, (double)var11, p_77185_1_.field_70177_z, 0.0F);
         p_77185_1_.field_70159_w = p_77185_1_.field_70181_x = p_77185_1_.field_70179_y = 0.0D;
      }
   }

   public boolean func_77184_b(Entity p_77184_1_, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_) {
      short var9 = 128;
      double var10 = -1.0D;
      int var12 = 0;
      int var13 = 0;
      int var14 = 0;
      int var15 = MathHelper.func_76128_c(p_77184_1_.field_70165_t);
      int var16 = MathHelper.func_76128_c(p_77184_1_.field_70161_v);
      long var17 = ChunkCoordIntPair.func_77272_a(var15, var16);
      boolean var19 = true;
      double var27;
      int var48;
      if(this.field_85191_c.func_76161_b(var17)) {
         PortalPosition var20 = (PortalPosition)this.field_85191_c.func_76164_a(var17);
         var10 = 0.0D;
         var12 = var20.field_71574_a;
         var13 = var20.field_71572_b;
         var14 = var20.field_71573_c;
         var20.field_85087_d = this.field_85192_a.func_82737_E();
         var19 = false;
      } else {
         for(var48 = var15 - var9; var48 <= var15 + var9; ++var48) {
            double var21 = (double)var48 + 0.5D - p_77184_1_.field_70165_t;

            for(int var23 = var16 - var9; var23 <= var16 + var9; ++var23) {
               double var24 = (double)var23 + 0.5D - p_77184_1_.field_70161_v;

               for(int var26 = this.field_85192_a.func_72940_L() - 1; var26 >= 0; --var26) {
                  if(this.field_85192_a.func_72798_a(var48, var26, var23) == Block.field_72015_be.field_71990_ca) {
                     while(this.field_85192_a.func_72798_a(var48, var26 - 1, var23) == Block.field_72015_be.field_71990_ca) {
                        --var26;
                     }

                     var27 = (double)var26 + 0.5D - p_77184_1_.field_70163_u;
                     double var29 = var21 * var21 + var27 * var27 + var24 * var24;
                     if(var10 < 0.0D || var29 < var10) {
                        var10 = var29;
                        var12 = var48;
                        var13 = var26;
                        var14 = var23;
                     }
                  }
               }
            }
         }
      }

      if(var10 >= 0.0D) {
         if(var19) {
            this.field_85191_c.func_76163_a(var17, new PortalPosition(this, var12, var13, var14, this.field_85192_a.func_82737_E()));
            this.field_85190_d.add(Long.valueOf(var17));
         }

         double var49 = (double)var12 + 0.5D;
         double var25 = (double)var13 + 0.5D;
         var27 = (double)var14 + 0.5D;
         int var50 = -1;
         if(this.field_85192_a.func_72798_a(var12 - 1, var13, var14) == Block.field_72015_be.field_71990_ca) {
            var50 = 2;
         }

         if(this.field_85192_a.func_72798_a(var12 + 1, var13, var14) == Block.field_72015_be.field_71990_ca) {
            var50 = 0;
         }

         if(this.field_85192_a.func_72798_a(var12, var13, var14 - 1) == Block.field_72015_be.field_71990_ca) {
            var50 = 3;
         }

         if(this.field_85192_a.func_72798_a(var12, var13, var14 + 1) == Block.field_72015_be.field_71990_ca) {
            var50 = 1;
         }

         int var30 = p_77184_1_.func_82148_at();
         if(var50 > -1) {
            int var31 = Direction.field_71578_g[var50];
            int var32 = Direction.field_71583_a[var50];
            int var33 = Direction.field_71581_b[var50];
            int var34 = Direction.field_71583_a[var31];
            int var35 = Direction.field_71581_b[var31];
            boolean var36 = !this.field_85192_a.func_72799_c(var12 + var32 + var34, var13, var14 + var33 + var35) || !this.field_85192_a.func_72799_c(var12 + var32 + var34, var13 + 1, var14 + var33 + var35);
            boolean var37 = !this.field_85192_a.func_72799_c(var12 + var32, var13, var14 + var33) || !this.field_85192_a.func_72799_c(var12 + var32, var13 + 1, var14 + var33);
            if(var36 && var37) {
               var50 = Direction.field_71580_e[var50];
               var31 = Direction.field_71580_e[var31];
               var32 = Direction.field_71583_a[var50];
               var33 = Direction.field_71581_b[var50];
               var34 = Direction.field_71583_a[var31];
               var35 = Direction.field_71581_b[var31];
               var48 = var12 - var34;
               var49 -= (double)var34;
               int var22 = var14 - var35;
               var27 -= (double)var35;
               var36 = !this.field_85192_a.func_72799_c(var48 + var32 + var34, var13, var22 + var33 + var35) || !this.field_85192_a.func_72799_c(var48 + var32 + var34, var13 + 1, var22 + var33 + var35);
               var37 = !this.field_85192_a.func_72799_c(var48 + var32, var13, var22 + var33) || !this.field_85192_a.func_72799_c(var48 + var32, var13 + 1, var22 + var33);
            }

            float var38 = 0.5F;
            float var39 = 0.5F;
            if(!var36 && var37) {
               var38 = 1.0F;
            } else if(var36 && !var37) {
               var38 = 0.0F;
            } else if(var36 && var37) {
               var39 = 0.0F;
            }

            var49 += (double)((float)var34 * var38 + var39 * (float)var32);
            var27 += (double)((float)var35 * var38 + var39 * (float)var33);
            float var40 = 0.0F;
            float var41 = 0.0F;
            float var42 = 0.0F;
            float var43 = 0.0F;
            if(var50 == var30) {
               var40 = 1.0F;
               var41 = 1.0F;
            } else if(var50 == Direction.field_71580_e[var30]) {
               var40 = -1.0F;
               var41 = -1.0F;
            } else if(var50 == Direction.field_71577_f[var30]) {
               var42 = 1.0F;
               var43 = -1.0F;
            } else {
               var42 = -1.0F;
               var43 = 1.0F;
            }

            double var44 = p_77184_1_.field_70159_w;
            double var46 = p_77184_1_.field_70179_y;
            p_77184_1_.field_70159_w = var44 * (double)var40 + var46 * (double)var43;
            p_77184_1_.field_70179_y = var44 * (double)var42 + var46 * (double)var41;
            p_77184_1_.field_70177_z = p_77184_8_ - (float)(var30 * 90) + (float)(var50 * 90);
         } else {
            p_77184_1_.field_70159_w = p_77184_1_.field_70181_x = p_77184_1_.field_70179_y = 0.0D;
         }

         p_77184_1_.func_70012_b(var49, var25, var27, p_77184_1_.field_70177_z, p_77184_1_.field_70125_A);
         return true;
      } else {
         return false;
      }
   }

   public boolean func_85188_a(Entity p_85188_1_) {
      byte var2 = 16;
      double var3 = -1.0D;
      int var5 = MathHelper.func_76128_c(p_85188_1_.field_70165_t);
      int var6 = MathHelper.func_76128_c(p_85188_1_.field_70163_u);
      int var7 = MathHelper.func_76128_c(p_85188_1_.field_70161_v);
      int var8 = var5;
      int var9 = var6;
      int var10 = var7;
      int var11 = 0;
      int var12 = this.field_77187_a.nextInt(4);

      int var13;
      double var14;
      double var17;
      int var16;
      int var19;
      int var21;
      int var20;
      int var23;
      int var22;
      int var25;
      int var24;
      int var27;
      int var26;
      double var31;
      double var32;
      for(var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
         var14 = (double)var13 + 0.5D - p_85188_1_.field_70165_t;

         for(var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
            var17 = (double)var16 + 0.5D - p_85188_1_.field_70161_v;

            label274:
            for(var19 = this.field_85192_a.func_72940_L() - 1; var19 >= 0; --var19) {
               if(this.field_85192_a.func_72799_c(var13, var19, var16)) {
                  while(var19 > 0 && this.field_85192_a.func_72799_c(var13, var19 - 1, var16)) {
                     --var19;
                  }

                  for(var20 = var12; var20 < var12 + 4; ++var20) {
                     var21 = var20 % 2;
                     var22 = 1 - var21;
                     if(var20 % 4 >= 2) {
                        var21 = -var21;
                        var22 = -var22;
                     }

                     for(var23 = 0; var23 < 3; ++var23) {
                        for(var24 = 0; var24 < 4; ++var24) {
                           for(var25 = -1; var25 < 4; ++var25) {
                              var26 = var13 + (var24 - 1) * var21 + var23 * var22;
                              var27 = var19 + var25;
                              int var28 = var16 + (var24 - 1) * var22 - var23 * var21;
                              if(var25 < 0 && !this.field_85192_a.func_72803_f(var26, var27, var28).func_76220_a() || var25 >= 0 && !this.field_85192_a.func_72799_c(var26, var27, var28)) {
                                 continue label274;
                              }
                           }
                        }
                     }

                     var32 = (double)var19 + 0.5D - p_85188_1_.field_70163_u;
                     var31 = var14 * var14 + var32 * var32 + var17 * var17;
                     if(var3 < 0.0D || var31 < var3) {
                        var3 = var31;
                        var8 = var13;
                        var9 = var19;
                        var10 = var16;
                        var11 = var20 % 4;
                     }
                  }
               }
            }
         }
      }

      if(var3 < 0.0D) {
         for(var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
            var14 = (double)var13 + 0.5D - p_85188_1_.field_70165_t;

            for(var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
               var17 = (double)var16 + 0.5D - p_85188_1_.field_70161_v;

               label222:
               for(var19 = this.field_85192_a.func_72940_L() - 1; var19 >= 0; --var19) {
                  if(this.field_85192_a.func_72799_c(var13, var19, var16)) {
                     while(var19 > 0 && this.field_85192_a.func_72799_c(var13, var19 - 1, var16)) {
                        --var19;
                     }

                     for(var20 = var12; var20 < var12 + 2; ++var20) {
                        var21 = var20 % 2;
                        var22 = 1 - var21;

                        for(var23 = 0; var23 < 4; ++var23) {
                           for(var24 = -1; var24 < 4; ++var24) {
                              var25 = var13 + (var23 - 1) * var21;
                              var26 = var19 + var24;
                              var27 = var16 + (var23 - 1) * var22;
                              if(var24 < 0 && !this.field_85192_a.func_72803_f(var25, var26, var27).func_76220_a() || var24 >= 0 && !this.field_85192_a.func_72799_c(var25, var26, var27)) {
                                 continue label222;
                              }
                           }
                        }

                        var32 = (double)var19 + 0.5D - p_85188_1_.field_70163_u;
                        var31 = var14 * var14 + var32 * var32 + var17 * var17;
                        if(var3 < 0.0D || var31 < var3) {
                           var3 = var31;
                           var8 = var13;
                           var9 = var19;
                           var10 = var16;
                           var11 = var20 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int var29 = var8;
      int var15 = var9;
      var16 = var10;
      int var30 = var11 % 2;
      int var18 = 1 - var30;
      if(var11 % 4 >= 2) {
         var30 = -var30;
         var18 = -var18;
      }

      boolean var33;
      if(var3 < 0.0D) {
         if(var9 < 70) {
            var9 = 70;
         }

         if(var9 > this.field_85192_a.func_72940_L() - 10) {
            var9 = this.field_85192_a.func_72940_L() - 10;
         }

         var15 = var9;

         for(var19 = -1; var19 <= 1; ++var19) {
            for(var20 = 1; var20 < 3; ++var20) {
               for(var21 = -1; var21 < 3; ++var21) {
                  var22 = var29 + (var20 - 1) * var30 + var19 * var18;
                  var23 = var15 + var21;
                  var24 = var16 + (var20 - 1) * var18 - var19 * var30;
                  var33 = var21 < 0;
                  this.field_85192_a.func_94575_c(var22, var23, var24, var33?Block.field_72089_ap.field_71990_ca:0);
               }
            }
         }
      }

      for(var19 = 0; var19 < 4; ++var19) {
         for(var20 = 0; var20 < 4; ++var20) {
            for(var21 = -1; var21 < 4; ++var21) {
               var22 = var29 + (var20 - 1) * var30;
               var23 = var15 + var21;
               var24 = var16 + (var20 - 1) * var18;
               var33 = var20 == 0 || var20 == 3 || var21 == -1 || var21 == 3;
               this.field_85192_a.func_72832_d(var22, var23, var24, var33?Block.field_72089_ap.field_71990_ca:Block.field_72015_be.field_71990_ca, 0, 2);
            }
         }

         for(var20 = 0; var20 < 4; ++var20) {
            for(var21 = -1; var21 < 4; ++var21) {
               var22 = var29 + (var20 - 1) * var30;
               var23 = var15 + var21;
               var24 = var16 + (var20 - 1) * var18;
               this.field_85192_a.func_72898_h(var22, var23, var24, this.field_85192_a.func_72798_a(var22, var23, var24));
            }
         }
      }

      return true;
   }

   public void func_85189_a(long p_85189_1_) {
      if(p_85189_1_ % 100L == 0L) {
         Iterator var3 = this.field_85190_d.iterator();
         long var4 = p_85189_1_ - 600L;

         while(var3.hasNext()) {
            Long var6 = (Long)var3.next();
            PortalPosition var7 = (PortalPosition)this.field_85191_c.func_76164_a(var6.longValue());
            if(var7 == null || var7.field_85087_d < var4) {
               var3.remove();
               this.field_85191_c.func_76159_d(var6.longValue());
            }
         }
      }

   }
}
