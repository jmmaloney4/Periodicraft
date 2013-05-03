package net.minecraft.pathfinding;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class PathFinder {

   private IBlockAccess field_75868_a;
   private Path field_75866_b = new Path();
   private IntHashMap field_75867_c = new IntHashMap();
   private PathPoint[] field_75864_d = new PathPoint[32];
   private boolean field_75865_e;
   private boolean field_75862_f;
   private boolean field_75863_g;
   private boolean field_75869_h;


   public PathFinder(IBlockAccess p_i3903_1_, boolean p_i3903_2_, boolean p_i3903_3_, boolean p_i3903_4_, boolean p_i3903_5_) {
      this.field_75868_a = p_i3903_1_;
      this.field_75865_e = p_i3903_2_;
      this.field_75862_f = p_i3903_3_;
      this.field_75863_g = p_i3903_4_;
      this.field_75869_h = p_i3903_5_;
   }

   public PathEntity func_75856_a(Entity p_75856_1_, Entity p_75856_2_, float p_75856_3_) {
      return this.func_75857_a(p_75856_1_, p_75856_2_.field_70165_t, p_75856_2_.field_70121_D.field_72338_b, p_75856_2_.field_70161_v, p_75856_3_);
   }

   public PathEntity func_75859_a(Entity p_75859_1_, int p_75859_2_, int p_75859_3_, int p_75859_4_, float p_75859_5_) {
      return this.func_75857_a(p_75859_1_, (double)((float)p_75859_2_ + 0.5F), (double)((float)p_75859_3_ + 0.5F), (double)((float)p_75859_4_ + 0.5F), p_75859_5_);
   }

   private PathEntity func_75857_a(Entity p_75857_1_, double p_75857_2_, double p_75857_4_, double p_75857_6_, float p_75857_8_) {
      this.field_75866_b.func_75848_a();
      this.field_75867_c.func_76046_c();
      boolean var9 = this.field_75863_g;
      int var10 = MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72338_b + 0.5D);
      if(this.field_75869_h && p_75857_1_.func_70090_H()) {
         var10 = (int)p_75857_1_.field_70121_D.field_72338_b;

         for(int var11 = this.field_75868_a.func_72798_a(MathHelper.func_76128_c(p_75857_1_.field_70165_t), var10, MathHelper.func_76128_c(p_75857_1_.field_70161_v)); var11 == Block.field_71942_A.field_71990_ca || var11 == Block.field_71943_B.field_71990_ca; var11 = this.field_75868_a.func_72798_a(MathHelper.func_76128_c(p_75857_1_.field_70165_t), var10, MathHelper.func_76128_c(p_75857_1_.field_70161_v))) {
            ++var10;
         }

         var9 = this.field_75863_g;
         this.field_75863_g = false;
      } else {
         var10 = MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72338_b + 0.5D);
      }

      PathPoint var15 = this.func_75854_a(MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72340_a), var10, MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72339_c));
      PathPoint var12 = this.func_75854_a(MathHelper.func_76128_c(p_75857_2_ - (double)(p_75857_1_.field_70130_N / 2.0F)), MathHelper.func_76128_c(p_75857_4_), MathHelper.func_76128_c(p_75857_6_ - (double)(p_75857_1_.field_70130_N / 2.0F)));
      PathPoint var13 = new PathPoint(MathHelper.func_76141_d(p_75857_1_.field_70130_N + 1.0F), MathHelper.func_76141_d(p_75857_1_.field_70131_O + 1.0F), MathHelper.func_76141_d(p_75857_1_.field_70130_N + 1.0F));
      PathEntity var14 = this.func_75861_a(p_75857_1_, var15, var12, var13, p_75857_8_);
      this.field_75863_g = var9;
      return var14;
   }

   private PathEntity func_75861_a(Entity p_75861_1_, PathPoint p_75861_2_, PathPoint p_75861_3_, PathPoint p_75861_4_, float p_75861_5_) {
      p_75861_2_.field_75836_e = 0.0F;
      p_75861_2_.field_75833_f = p_75861_2_.func_75832_b(p_75861_3_);
      p_75861_2_.field_75834_g = p_75861_2_.field_75833_f;
      this.field_75866_b.func_75848_a();
      this.field_75866_b.func_75849_a(p_75861_2_);
      PathPoint var6 = p_75861_2_;

      while(!this.field_75866_b.func_75845_e()) {
         PathPoint var7 = this.field_75866_b.func_75844_c();
         if(var7.equals(p_75861_3_)) {
            return this.func_75853_a(p_75861_2_, p_75861_3_);
         }

         if(var7.func_75832_b(p_75861_3_) < var6.func_75832_b(p_75861_3_)) {
            var6 = var7;
         }

         var7.field_75842_i = true;
         int var8 = this.func_75860_b(p_75861_1_, var7, p_75861_4_, p_75861_3_, p_75861_5_);

         for(int var9 = 0; var9 < var8; ++var9) {
            PathPoint var10 = this.field_75864_d[var9];
            float var11 = var7.field_75836_e + var7.func_75832_b(var10);
            if(!var10.func_75831_a() || var11 < var10.field_75836_e) {
               var10.field_75841_h = var7;
               var10.field_75836_e = var11;
               var10.field_75833_f = var10.func_75832_b(p_75861_3_);
               if(var10.func_75831_a()) {
                  this.field_75866_b.func_75850_a(var10, var10.field_75836_e + var10.field_75833_f);
               } else {
                  var10.field_75834_g = var10.field_75836_e + var10.field_75833_f;
                  this.field_75866_b.func_75849_a(var10);
               }
            }
         }
      }

      if(var6 == p_75861_2_) {
         return null;
      } else {
         return this.func_75853_a(p_75861_2_, var6);
      }
   }

   private int func_75860_b(Entity p_75860_1_, PathPoint p_75860_2_, PathPoint p_75860_3_, PathPoint p_75860_4_, float p_75860_5_) {
      int var6 = 0;
      byte var7 = 0;
      if(this.func_75855_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b + 1, p_75860_2_.field_75838_c, p_75860_3_) == 1) {
         var7 = 1;
      }

      PathPoint var8 = this.func_75858_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c + 1, p_75860_3_, var7);
      PathPoint var9 = this.func_75858_a(p_75860_1_, p_75860_2_.field_75839_a - 1, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c, p_75860_3_, var7);
      PathPoint var10 = this.func_75858_a(p_75860_1_, p_75860_2_.field_75839_a + 1, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c, p_75860_3_, var7);
      PathPoint var11 = this.func_75858_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c - 1, p_75860_3_, var7);
      if(var8 != null && !var8.field_75842_i && var8.func_75829_a(p_75860_4_) < p_75860_5_) {
         this.field_75864_d[var6++] = var8;
      }

      if(var9 != null && !var9.field_75842_i && var9.func_75829_a(p_75860_4_) < p_75860_5_) {
         this.field_75864_d[var6++] = var9;
      }

      if(var10 != null && !var10.field_75842_i && var10.func_75829_a(p_75860_4_) < p_75860_5_) {
         this.field_75864_d[var6++] = var10;
      }

      if(var11 != null && !var11.field_75842_i && var11.func_75829_a(p_75860_4_) < p_75860_5_) {
         this.field_75864_d[var6++] = var11;
      }

      return var6;
   }

   private PathPoint func_75858_a(Entity p_75858_1_, int p_75858_2_, int p_75858_3_, int p_75858_4_, PathPoint p_75858_5_, int p_75858_6_) {
      PathPoint var7 = null;
      int var8 = this.func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_, p_75858_4_, p_75858_5_);
      if(var8 == 2) {
         return this.func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
      } else {
         if(var8 == 1) {
            var7 = this.func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
         }

         if(var7 == null && p_75858_6_ > 0 && var8 != -3 && var8 != -4 && this.func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_ + p_75858_6_, p_75858_4_, p_75858_5_) == 1) {
            var7 = this.func_75854_a(p_75858_2_, p_75858_3_ + p_75858_6_, p_75858_4_);
            p_75858_3_ += p_75858_6_;
         }

         if(var7 != null) {
            int var9 = 0;
            int var10 = 0;

            while(p_75858_3_ > 0) {
               var10 = this.func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_ - 1, p_75858_4_, p_75858_5_);
               if(this.field_75863_g && var10 == -1) {
                  return null;
               }

               if(var10 != 1) {
                  break;
               }

               if(var9++ >= p_75858_1_.func_82143_as()) {
                  return null;
               }

               --p_75858_3_;
               if(p_75858_3_ > 0) {
                  var7 = this.func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
               }
            }

            if(var10 == -2) {
               return null;
            }
         }

         return var7;
      }
   }

   private final PathPoint func_75854_a(int p_75854_1_, int p_75854_2_, int p_75854_3_) {
      int var4 = PathPoint.func_75830_a(p_75854_1_, p_75854_2_, p_75854_3_);
      PathPoint var5 = (PathPoint)this.field_75867_c.func_76041_a(var4);
      if(var5 == null) {
         var5 = new PathPoint(p_75854_1_, p_75854_2_, p_75854_3_);
         this.field_75867_c.func_76038_a(var4, var5);
      }

      return var5;
   }

   public int func_75855_a(Entity p_75855_1_, int p_75855_2_, int p_75855_3_, int p_75855_4_, PathPoint p_75855_5_) {
      return func_82565_a(p_75855_1_, p_75855_2_, p_75855_3_, p_75855_4_, p_75855_5_, this.field_75863_g, this.field_75862_f, this.field_75865_e);
   }

   public static int func_82565_a(Entity p_82565_0_, int p_82565_1_, int p_82565_2_, int p_82565_3_, PathPoint p_82565_4_, boolean p_82565_5_, boolean p_82565_6_, boolean p_82565_7_) {
      boolean var8 = false;

      for(int var9 = p_82565_1_; var9 < p_82565_1_ + p_82565_4_.field_75839_a; ++var9) {
         for(int var10 = p_82565_2_; var10 < p_82565_2_ + p_82565_4_.field_75837_b; ++var10) {
            for(int var11 = p_82565_3_; var11 < p_82565_3_ + p_82565_4_.field_75838_c; ++var11) {
               int var12 = p_82565_0_.field_70170_p.func_72798_a(var9, var10, var11);
               if(var12 > 0) {
                  if(var12 == Block.field_72005_bk.field_71990_ca) {
                     var8 = true;
                  } else if(var12 != Block.field_71942_A.field_71990_ca && var12 != Block.field_71943_B.field_71990_ca) {
                     if(!p_82565_7_ && var12 == Block.field_72054_aE.field_71990_ca) {
                        return 0;
                     }
                  } else {
                     if(p_82565_5_) {
                        return -1;
                     }

                     var8 = true;
                  }

                  Block var13 = Block.field_71973_m[var12];
                  int var14 = var13.func_71857_b();
                  if(p_82565_0_.field_70170_p.func_85175_e(var9, var10, var11) == 9) {
                     int var18 = MathHelper.func_76128_c(p_82565_0_.field_70165_t);
                     int var16 = MathHelper.func_76128_c(p_82565_0_.field_70163_u);
                     int var17 = MathHelper.func_76128_c(p_82565_0_.field_70161_v);
                     if(p_82565_0_.field_70170_p.func_85175_e(var18, var16, var17) != 9 && p_82565_0_.field_70170_p.func_85175_e(var18, var16 - 1, var17) != 9) {
                        return -3;
                     }
                  } else if(!var13.func_71918_c(p_82565_0_.field_70170_p, var9, var10, var11) && (!p_82565_6_ || var12 != Block.field_72054_aE.field_71990_ca)) {
                     if(var14 == 11 || var12 == Block.field_71993_bv.field_71990_ca || var14 == 32) {
                        return -3;
                     }

                     if(var12 == Block.field_72005_bk.field_71990_ca) {
                        return -4;
                     }

                     Material var15 = var13.field_72018_cp;
                     if(var15 != Material.field_76256_h) {
                        return 0;
                     }

                     if(!p_82565_0_.func_70058_J()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return var8?2:1;
   }

   private PathEntity func_75853_a(PathPoint p_75853_1_, PathPoint p_75853_2_) {
      int var3 = 1;

      PathPoint var4;
      for(var4 = p_75853_2_; var4.field_75841_h != null; var4 = var4.field_75841_h) {
         ++var3;
      }

      PathPoint[] var5 = new PathPoint[var3];
      var4 = p_75853_2_;
      --var3;

      for(var5[var3] = p_75853_2_; var4.field_75841_h != null; var5[var3] = var4) {
         var4 = var4.field_75841_h;
         --var3;
      }

      return new PathEntity(var5);
   }
}
