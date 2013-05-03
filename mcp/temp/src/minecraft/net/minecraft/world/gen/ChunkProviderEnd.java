package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkProviderEnd implements IChunkProvider {

   private Random field_73204_i;
   private NoiseGeneratorOctaves field_73201_j;
   private NoiseGeneratorOctaves field_73202_k;
   private NoiseGeneratorOctaves field_73199_l;
   public NoiseGeneratorOctaves field_73196_a;
   public NoiseGeneratorOctaves field_73194_b;
   private World field_73200_m;
   private double[] field_73197_n;
   private BiomeGenBase[] field_73198_o;
   double[] field_73195_c;
   double[] field_73192_d;
   double[] field_73193_e;
   double[] field_73190_f;
   double[] field_73191_g;
   int[][] field_73203_h = new int[32][32];


   public ChunkProviderEnd(World p_i3783_1_, long p_i3783_2_) {
      this.field_73200_m = p_i3783_1_;
      this.field_73204_i = new Random(p_i3783_2_);
      this.field_73201_j = new NoiseGeneratorOctaves(this.field_73204_i, 16);
      this.field_73202_k = new NoiseGeneratorOctaves(this.field_73204_i, 16);
      this.field_73199_l = new NoiseGeneratorOctaves(this.field_73204_i, 8);
      this.field_73196_a = new NoiseGeneratorOctaves(this.field_73204_i, 10);
      this.field_73194_b = new NoiseGeneratorOctaves(this.field_73204_i, 16);
   }

   public void func_73189_a(int p_73189_1_, int p_73189_2_, byte[] p_73189_3_, BiomeGenBase[] p_73189_4_) {
      byte var5 = 2;
      int var6 = var5 + 1;
      byte var7 = 33;
      int var8 = var5 + 1;
      this.field_73197_n = this.func_73187_a(this.field_73197_n, p_73189_1_ * var5, 0, p_73189_2_ * var5, var6, var7, var8);

      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var5; ++var10) {
            for(int var11 = 0; var11 < 32; ++var11) {
               double var12 = 0.25D;
               double var14 = this.field_73197_n[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.field_73197_n[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.field_73197_n[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.field_73197_n[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.field_73197_n[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.field_73197_n[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.field_73197_n[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.field_73197_n[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 4; ++var30) {
                  double var31 = 0.125D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 8; ++var41) {
                     int var42 = var41 + var9 * 8 << 11 | 0 + var10 * 8 << 7 | var11 * 4 + var30;
                     short var43 = 128;
                     double var44 = 0.125D;
                     double var46 = var33;
                     double var48 = (var35 - var33) * var44;

                     for(int var50 = 0; var50 < 8; ++var50) {
                        int var51 = 0;
                        if(var46 > 0.0D) {
                           var51 = Block.field_72082_bJ.field_71990_ca;
                        }

                        p_73189_3_[var42] = (byte)var51;
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

   public void func_73188_b(int p_73188_1_, int p_73188_2_, byte[] p_73188_3_, BiomeGenBase[] p_73188_4_) {
      for(int var5 = 0; var5 < 16; ++var5) {
         for(int var6 = 0; var6 < 16; ++var6) {
            byte var7 = 1;
            int var8 = -1;
            byte var9 = (byte)Block.field_72082_bJ.field_71990_ca;
            byte var10 = (byte)Block.field_72082_bJ.field_71990_ca;

            for(int var11 = 127; var11 >= 0; --var11) {
               int var12 = (var6 * 16 + var5) * 128 + var11;
               byte var13 = p_73188_3_[var12];
               if(var13 == 0) {
                  var8 = -1;
               } else if(var13 == Block.field_71981_t.field_71990_ca) {
                  if(var8 == -1) {
                     if(var7 <= 0) {
                        var9 = 0;
                        var10 = (byte)Block.field_72082_bJ.field_71990_ca;
                     }

                     var8 = var7;
                     if(var11 >= 0) {
                        p_73188_3_[var12] = var9;
                     } else {
                        p_73188_3_[var12] = var10;
                     }
                  } else if(var8 > 0) {
                     --var8;
                     p_73188_3_[var12] = var10;
                  }
               }
            }
         }
      }

   }

   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
      return this.func_73154_d(p_73158_1_, p_73158_2_);
   }

   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
      this.field_73204_i.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.field_73198_o = this.field_73200_m.func_72959_q().func_76933_b(this.field_73198_o, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      this.func_73189_a(p_73154_1_, p_73154_2_, var3, this.field_73198_o);
      this.func_73188_b(p_73154_1_, p_73154_2_, var3, this.field_73198_o);
      Chunk var4 = new Chunk(this.field_73200_m, var3, p_73154_1_, p_73154_2_);
      byte[] var5 = var4.func_76605_m();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.field_73198_o[var6].field_76756_M;
      }

      var4.func_76603_b();
      return var4;
   }

   private double[] func_73187_a(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_) {
      if(p_73187_1_ == null) {
         p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.field_73190_f = this.field_73196_a.func_76305_a(this.field_73190_f, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D);
      this.field_73191_g = this.field_73194_b.func_76305_a(this.field_73191_g, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.field_73195_c = this.field_73199_l.func_76304_a(this.field_73195_c, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.field_73192_d = this.field_73201_j.func_76304_a(this.field_73192_d, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, var8, var10, var8);
      this.field_73193_e = this.field_73202_k.func_76304_a(this.field_73193_e, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;

      for(int var14 = 0; var14 < p_73187_5_; ++var14) {
         for(int var15 = 0; var15 < p_73187_7_; ++var15) {
            double var16 = (this.field_73190_f[var13] + 256.0D) / 512.0D;
            if(var16 > 1.0D) {
               var16 = 1.0D;
            }

            double var18 = this.field_73191_g[var13] / 8000.0D;
            if(var18 < 0.0D) {
               var18 = -var18 * 0.3D;
            }

            var18 = var18 * 3.0D - 2.0D;
            float var20 = (float)(var14 + p_73187_2_ - 0) / 1.0F;
            float var21 = (float)(var15 + p_73187_4_ - 0) / 1.0F;
            float var22 = 100.0F - MathHelper.func_76129_c(var20 * var20 + var21 * var21) * 8.0F;
            if(var22 > 80.0F) {
               var22 = 80.0F;
            }

            if(var22 < -100.0F) {
               var22 = -100.0F;
            }

            if(var18 > 1.0D) {
               var18 = 1.0D;
            }

            var18 /= 8.0D;
            var18 = 0.0D;
            if(var16 < 0.0D) {
               var16 = 0.0D;
            }

            var16 += 0.5D;
            var18 = var18 * (double)p_73187_6_ / 16.0D;
            ++var13;
            double var23 = (double)p_73187_6_ / 2.0D;

            for(int var25 = 0; var25 < p_73187_6_; ++var25) {
               double var26 = 0.0D;
               double var28 = ((double)var25 - var23) * 8.0D / var16;
               if(var28 < 0.0D) {
                  var28 *= -1.0D;
               }

               double var30 = this.field_73192_d[var12] / 512.0D;
               double var32 = this.field_73193_e[var12] / 512.0D;
               double var34 = (this.field_73195_c[var12] / 10.0D + 1.0D) / 2.0D;
               if(var34 < 0.0D) {
                  var26 = var30;
               } else if(var34 > 1.0D) {
                  var26 = var32;
               } else {
                  var26 = var30 + (var32 - var30) * var34;
               }

               var26 -= 8.0D;
               var26 += (double)var22;
               byte var36 = 2;
               double var37;
               if(var25 > p_73187_6_ / 2 - var36) {
                  var37 = (double)((float)(var25 - (p_73187_6_ / 2 - var36)) / 64.0F);
                  if(var37 < 0.0D) {
                     var37 = 0.0D;
                  }

                  if(var37 > 1.0D) {
                     var37 = 1.0D;
                  }

                  var26 = var26 * (1.0D - var37) + -3000.0D * var37;
               }

               var36 = 8;
               if(var25 < var36) {
                  var37 = (double)((float)(var36 - var25) / ((float)var36 - 1.0F));
                  var26 = var26 * (1.0D - var37) + -30.0D * var37;
               }

               p_73187_1_[var12] = var26;
               ++var12;
            }
         }
      }

      return p_73187_1_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      BlockSand.field_72192_a = true;
      int var4 = p_73153_2_ * 16;
      int var5 = p_73153_3_ * 16;
      BiomeGenBase var6 = this.field_73200_m.func_72807_a(var4 + 16, var5 + 16);
      var6.func_76728_a(this.field_73200_m, this.field_73200_m.field_73012_v, var4, var5);
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
      return "RandomLevelSource";
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      BiomeGenBase var5 = this.field_73200_m.func_72807_a(p_73155_2_, p_73155_4_);
      return var5 == null?null:var5.func_76747_a(p_73155_1_);
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int p_82695_1_, int p_82695_2_) {}
}
