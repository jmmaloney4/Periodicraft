package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.MapGenNetherBridge;

public class ChunkProviderHell implements IChunkProvider {

   private Random field_73181_i;
   private NoiseGeneratorOctaves field_73178_j;
   private NoiseGeneratorOctaves field_73179_k;
   private NoiseGeneratorOctaves field_73176_l;
   private NoiseGeneratorOctaves field_73177_m;
   private NoiseGeneratorOctaves field_73174_n;
   public NoiseGeneratorOctaves field_73173_a;
   public NoiseGeneratorOctaves field_73171_b;
   private World field_73175_o;
   private double[] field_73186_p;
   public MapGenNetherBridge field_73172_c = new MapGenNetherBridge();
   private double[] field_73185_q = new double[256];
   private double[] field_73184_r = new double[256];
   private double[] field_73183_s = new double[256];
   private MapGenBase field_73182_t = new MapGenCavesHell();
   double[] field_73169_d;
   double[] field_73170_e;
   double[] field_73167_f;
   double[] field_73168_g;
   double[] field_73180_h;


   public ChunkProviderHell(World p_i3781_1_, long p_i3781_2_) {
      this.field_73175_o = p_i3781_1_;
      this.field_73181_i = new Random(p_i3781_2_);
      this.field_73178_j = new NoiseGeneratorOctaves(this.field_73181_i, 16);
      this.field_73179_k = new NoiseGeneratorOctaves(this.field_73181_i, 16);
      this.field_73176_l = new NoiseGeneratorOctaves(this.field_73181_i, 8);
      this.field_73177_m = new NoiseGeneratorOctaves(this.field_73181_i, 4);
      this.field_73174_n = new NoiseGeneratorOctaves(this.field_73181_i, 4);
      this.field_73173_a = new NoiseGeneratorOctaves(this.field_73181_i, 10);
      this.field_73171_b = new NoiseGeneratorOctaves(this.field_73181_i, 16);
   }

   public void func_73165_a(int p_73165_1_, int p_73165_2_, byte[] p_73165_3_) {
      byte var4 = 4;
      byte var5 = 32;
      int var6 = var4 + 1;
      byte var7 = 17;
      int var8 = var4 + 1;
      this.field_73186_p = this.func_73164_a(this.field_73186_p, p_73165_1_ * var4, 0, p_73165_2_ * var4, var6, var7, var8);

      for(int var9 = 0; var9 < var4; ++var9) {
         for(int var10 = 0; var10 < var4; ++var10) {
            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = 0.125D;
               double var14 = this.field_73186_p[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.field_73186_p[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.field_73186_p[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.field_73186_p[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.field_73186_p[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.field_73186_p[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.field_73186_p[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.field_73186_p[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 8; ++var30) {
                  double var31 = 0.25D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 4; ++var41) {
                     int var42 = var41 + var9 * 4 << 11 | 0 + var10 * 4 << 7 | var11 * 8 + var30;
                     short var43 = 128;
                     double var44 = 0.25D;
                     double var46 = var33;
                     double var48 = (var35 - var33) * var44;

                     for(int var50 = 0; var50 < 4; ++var50) {
                        int var51 = 0;
                        if(var11 * 8 + var30 < var5) {
                           var51 = Block.field_71938_D.field_71990_ca;
                        }

                        if(var46 > 0.0D) {
                           var51 = Block.field_72012_bb.field_71990_ca;
                        }

                        p_73165_3_[var42] = (byte)var51;
                        var42 += var43;
                        var46 += var48;
                     }

                     var33 += var37;
                     var35 += var39;
                  }

                  var14 += var22;
                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
               }
            }
         }
      }

   }

   public void func_73166_b(int p_73166_1_, int p_73166_2_, byte[] p_73166_3_) {
      byte var4 = 64;
      double var5 = 0.03125D;
      this.field_73185_q = this.field_73177_m.func_76304_a(this.field_73185_q, p_73166_1_ * 16, p_73166_2_ * 16, 0, 16, 16, 1, var5, var5, 1.0D);
      this.field_73184_r = this.field_73177_m.func_76304_a(this.field_73184_r, p_73166_1_ * 16, 109, p_73166_2_ * 16, 16, 1, 16, var5, 1.0D, var5);
      this.field_73183_s = this.field_73174_n.func_76304_a(this.field_73183_s, p_73166_1_ * 16, p_73166_2_ * 16, 0, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            boolean var9 = this.field_73185_q[var7 + var8 * 16] + this.field_73181_i.nextDouble() * 0.2D > 0.0D;
            boolean var10 = this.field_73184_r[var7 + var8 * 16] + this.field_73181_i.nextDouble() * 0.2D > 0.0D;
            int var11 = (int)(this.field_73183_s[var7 + var8 * 16] / 3.0D + 3.0D + this.field_73181_i.nextDouble() * 0.25D);
            int var12 = -1;
            byte var13 = (byte)Block.field_72012_bb.field_71990_ca;
            byte var14 = (byte)Block.field_72012_bb.field_71990_ca;

            for(int var15 = 127; var15 >= 0; --var15) {
               int var16 = (var8 * 16 + var7) * 128 + var15;
               if(var15 < 127 - this.field_73181_i.nextInt(5) && var15 > 0 + this.field_73181_i.nextInt(5)) {
                  byte var17 = p_73166_3_[var16];
                  if(var17 == 0) {
                     var12 = -1;
                  } else if(var17 == Block.field_72012_bb.field_71990_ca) {
                     if(var12 == -1) {
                        if(var11 <= 0) {
                           var13 = 0;
                           var14 = (byte)Block.field_72012_bb.field_71990_ca;
                        } else if(var15 >= var4 - 4 && var15 <= var4 + 1) {
                           var13 = (byte)Block.field_72012_bb.field_71990_ca;
                           var14 = (byte)Block.field_72012_bb.field_71990_ca;
                           if(var10) {
                              var13 = (byte)Block.field_71940_F.field_71990_ca;
                           }

                           if(var10) {
                              var14 = (byte)Block.field_72012_bb.field_71990_ca;
                           }

                           if(var9) {
                              var13 = (byte)Block.field_72013_bc.field_71990_ca;
                           }

                           if(var9) {
                              var14 = (byte)Block.field_72013_bc.field_71990_ca;
                           }
                        }

                        if(var15 < var4 && var13 == 0) {
                           var13 = (byte)Block.field_71938_D.field_71990_ca;
                        }

                        var12 = var11;
                        if(var15 >= var4 - 1) {
                           p_73166_3_[var16] = var13;
                        } else {
                           p_73166_3_[var16] = var14;
                        }
                     } else if(var12 > 0) {
                        --var12;
                        p_73166_3_[var16] = var14;
                     }
                  }
               } else {
                  p_73166_3_[var16] = (byte)Block.field_71986_z.field_71990_ca;
               }
            }
         }
      }

   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      return this.func_73154_d(p_73158_1_, p_73158_2_);
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      this.field_73181_i.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.func_73165_a(p_73154_1_, p_73154_2_, var3);
      this.func_73166_b(p_73154_1_, p_73154_2_, var3);
      this.field_73182_t.func_75036_a(this, this.field_73175_o, p_73154_1_, p_73154_2_, var3);
      this.field_73172_c.func_75036_a(this, this.field_73175_o, p_73154_1_, p_73154_2_, var3);
      Chunk var4 = new Chunk(this.field_73175_o, var3, p_73154_1_, p_73154_2_);
      BiomeGenBase[] var5 = this.field_73175_o.func_72959_q().func_76933_b((BiomeGenBase[])null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      byte[] var6 = var4.func_76605_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].field_76756_M;
      }

      var4.func_76613_n();
      return var4;
   }

   private double[] func_73164_a(double[] p_73164_1_, int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_) {
      if(p_73164_1_ == null) {
         p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
      }

      double var8 = 684.412D;
      double var10 = 2053.236D;
      this.field_73168_g = this.field_73173_a.func_76304_a(this.field_73168_g, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
      this.field_73180_h = this.field_73171_b.func_76304_a(this.field_73180_h, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100.0D, 0.0D, 100.0D);
      this.field_73169_d = this.field_73176_l.func_76304_a(this.field_73169_d, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, var8 / 80.0D, var10 / 60.0D, var8 / 80.0D);
      this.field_73170_e = this.field_73178_j.func_76304_a(this.field_73170_e, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, var8, var10, var8);
      this.field_73167_f = this.field_73179_k.func_76304_a(this.field_73167_f, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;
      double[] var14 = new double[p_73164_6_];

      int var15;
      for(var15 = 0; var15 < p_73164_6_; ++var15) {
         var14[var15] = Math.cos((double)var15 * 3.141592653589793D * 6.0D / (double)p_73164_6_) * 2.0D;
         double var16 = (double)var15;
         if(var15 > p_73164_6_ / 2) {
            var16 = (double)(p_73164_6_ - 1 - var15);
         }

         if(var16 < 4.0D) {
            var16 = 4.0D - var16;
            var14[var15] -= var16 * var16 * var16 * 10.0D;
         }
      }

      for(var15 = 0; var15 < p_73164_5_; ++var15) {
         for(int var36 = 0; var36 < p_73164_7_; ++var36) {
            double var17 = (this.field_73168_g[var13] + 256.0D) / 512.0D;
            if(var17 > 1.0D) {
               var17 = 1.0D;
            }

            double var19 = 0.0D;
            double var21 = this.field_73180_h[var13] / 8000.0D;
            if(var21 < 0.0D) {
               var21 = -var21;
            }

            var21 = var21 * 3.0D - 3.0D;
            if(var21 < 0.0D) {
               var21 /= 2.0D;
               if(var21 < -1.0D) {
                  var21 = -1.0D;
               }

               var21 /= 1.4D;
               var21 /= 2.0D;
               var17 = 0.0D;
            } else {
               if(var21 > 1.0D) {
                  var21 = 1.0D;
               }

               var21 /= 6.0D;
            }

            var17 += 0.5D;
            var21 = var21 * (double)p_73164_6_ / 16.0D;
            ++var13;

            for(int var23 = 0; var23 < p_73164_6_; ++var23) {
               double var24 = 0.0D;
               double var26 = var14[var23];
               double var28 = this.field_73170_e[var12] / 512.0D;
               double var30 = this.field_73167_f[var12] / 512.0D;
               double var32 = (this.field_73169_d[var12] / 10.0D + 1.0D) / 2.0D;
               if(var32 < 0.0D) {
                  var24 = var28;
               } else if(var32 > 1.0D) {
                  var24 = var30;
               } else {
                  var24 = var28 + (var30 - var28) * var32;
               }

               var24 -= var26;
               double var34;
               if(var23 > p_73164_6_ - 4) {
                  var34 = (double)((float)(var23 - (p_73164_6_ - 4)) / 3.0F);
                  var24 = var24 * (1.0D - var34) + -10.0D * var34;
               }

               if((double)var23 < var19) {
                  var34 = (var19 - (double)var23) / 4.0D;
                  if(var34 < 0.0D) {
                     var34 = 0.0D;
                  }

                  if(var34 > 1.0D) {
                     var34 = 1.0D;
                  }

                  var24 = var24 * (1.0D - var34) + -10.0D * var34;
               }

               p_73164_1_[var12] = var24;
               ++var12;
            }
         }
      }

      return p_73164_1_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      BlockSand.field_72192_a = true;
      int var4 = p_73153_2_ * 16;
      int var5 = p_73153_3_ * 16;
      this.field_73172_c.func_75051_a(this.field_73175_o, this.field_73181_i, p_73153_2_, p_73153_3_);

      int var6;
      int var7;
      int var8;
      int var9;
      for(var6 = 0; var6 < 8; ++var6) {
         var7 = var4 + this.field_73181_i.nextInt(16) + 8;
         var8 = this.field_73181_i.nextInt(120) + 4;
         var9 = var5 + this.field_73181_i.nextInt(16) + 8;
         (new WorldGenHellLava(Block.field_71944_C.field_71990_ca, false)).func_76484_a(this.field_73175_o, this.field_73181_i, var7, var8, var9);
      }

      var6 = this.field_73181_i.nextInt(this.field_73181_i.nextInt(10) + 1) + 1;

      int var10;
      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var4 + this.field_73181_i.nextInt(16) + 8;
         var9 = this.field_73181_i.nextInt(120) + 4;
         var10 = var5 + this.field_73181_i.nextInt(16) + 8;
         (new WorldGenFire()).func_76484_a(this.field_73175_o, this.field_73181_i, var8, var9, var10);
      }

      var6 = this.field_73181_i.nextInt(this.field_73181_i.nextInt(10) + 1);

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var4 + this.field_73181_i.nextInt(16) + 8;
         var9 = this.field_73181_i.nextInt(120) + 4;
         var10 = var5 + this.field_73181_i.nextInt(16) + 8;
         (new WorldGenGlowStone1()).func_76484_a(this.field_73175_o, this.field_73181_i, var8, var9, var10);
      }

      for(var7 = 0; var7 < 10; ++var7) {
         var8 = var4 + this.field_73181_i.nextInt(16) + 8;
         var9 = this.field_73181_i.nextInt(128);
         var10 = var5 + this.field_73181_i.nextInt(16) + 8;
         (new WorldGenGlowStone2()).func_76484_a(this.field_73175_o, this.field_73181_i, var8, var9, var10);
      }

      if(this.field_73181_i.nextInt(1) == 0) {
         var7 = var4 + this.field_73181_i.nextInt(16) + 8;
         var8 = this.field_73181_i.nextInt(128);
         var9 = var5 + this.field_73181_i.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(this.field_73175_o, this.field_73181_i, var7, var8, var9);
      }

      if(this.field_73181_i.nextInt(1) == 0) {
         var7 = var4 + this.field_73181_i.nextInt(16) + 8;
         var8 = this.field_73181_i.nextInt(128);
         var9 = var5 + this.field_73181_i.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(this.field_73175_o, this.field_73181_i, var7, var8, var9);
      }

      WorldGenMinable var12 = new WorldGenMinable(Block.field_94342_cr.field_71990_ca, 13, Block.field_72012_bb.field_71990_ca);

      int var11;
      for(var8 = 0; var8 < 16; ++var8) {
         var9 = var4 + this.field_73181_i.nextInt(16);
         var10 = this.field_73181_i.nextInt(108) + 10;
         var11 = var5 + this.field_73181_i.nextInt(16);
         var12.func_76484_a(this.field_73175_o, this.field_73181_i, var9, var10, var11);
      }

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = var4 + this.field_73181_i.nextInt(16);
         var10 = this.field_73181_i.nextInt(108) + 10;
         var11 = var5 + this.field_73181_i.nextInt(16);
         (new WorldGenHellLava(Block.field_71944_C.field_71990_ca, true)).func_76484_a(this.field_73175_o, this.field_73181_i, var9, var10, var11);
      }

      BlockSand.field_72192_a = false;
   }

   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
      return true;
   }

   public boolean func_73156_b() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "HellRandomLevelSource";
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      if(p_73155_1_ == EnumCreatureType.monster && this.field_73172_c.func_75048_a(p_73155_2_, p_73155_3_, p_73155_4_)) {
         return this.field_73172_c.func_75059_a();
      } else {
         BiomeGenBase var5 = this.field_73175_o.func_72807_a(p_73155_2_, p_73155_4_);
         return var5 == null?null:var5.func_76747_a(p_73155_1_);
      }
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int p_82695_1_, int p_82695_2_) {
      this.field_73172_c.func_75036_a(this, this.field_73175_o, p_82695_1_, p_82695_2_, (byte[])null);
   }
}
