package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;

public class ChunkProviderGenerate implements IChunkProvider {

   private Random field_73220_k;
   private NoiseGeneratorOctaves field_73217_l;
   private NoiseGeneratorOctaves field_73218_m;
   private NoiseGeneratorOctaves field_73215_n;
   private NoiseGeneratorOctaves field_73216_o;
   public NoiseGeneratorOctaves field_73214_a;
   public NoiseGeneratorOctaves field_73212_b;
   public NoiseGeneratorOctaves field_73213_c;
   private World field_73230_p;
   private final boolean field_73229_q;
   private double[] field_73228_r;
   private double[] field_73227_s = new double[256];
   private MapGenBase field_73226_t = new MapGenCaves();
   private MapGenStronghold field_73225_u = new MapGenStronghold();
   private MapGenVillage field_73224_v = new MapGenVillage();
   private MapGenMineshaft field_73223_w = new MapGenMineshaft();
   private MapGenScatteredFeature field_73233_x = new MapGenScatteredFeature();
   private MapGenBase field_73232_y = new MapGenRavine();
   private BiomeGenBase[] field_73231_z;
   double[] field_73210_d;
   double[] field_73211_e;
   double[] field_73208_f;
   double[] field_73209_g;
   double[] field_73221_h;
   float[] field_73222_i;
   int[][] field_73219_j = new int[32][32];


   public ChunkProviderGenerate(World p_i3782_1_, long p_i3782_2_, boolean p_i3782_4_) {
      this.field_73230_p = p_i3782_1_;
      this.field_73229_q = p_i3782_4_;
      this.field_73220_k = new Random(p_i3782_2_);
      this.field_73217_l = new NoiseGeneratorOctaves(this.field_73220_k, 16);
      this.field_73218_m = new NoiseGeneratorOctaves(this.field_73220_k, 16);
      this.field_73215_n = new NoiseGeneratorOctaves(this.field_73220_k, 8);
      this.field_73216_o = new NoiseGeneratorOctaves(this.field_73220_k, 4);
      this.field_73214_a = new NoiseGeneratorOctaves(this.field_73220_k, 10);
      this.field_73212_b = new NoiseGeneratorOctaves(this.field_73220_k, 16);
      this.field_73213_c = new NoiseGeneratorOctaves(this.field_73220_k, 8);
   }

   public void func_73206_a(int p_73206_1_, int p_73206_2_, byte[] p_73206_3_) {
      byte var4 = 4;
      byte var5 = 16;
      byte var6 = 63;
      int var7 = var4 + 1;
      byte var8 = 17;
      int var9 = var4 + 1;
      this.field_73231_z = this.field_73230_p.func_72959_q().func_76937_a(this.field_73231_z, p_73206_1_ * 4 - 2, p_73206_2_ * 4 - 2, var7 + 5, var9 + 5);
      this.field_73228_r = this.func_73205_a(this.field_73228_r, p_73206_1_ * var4, 0, p_73206_2_ * var4, var7, var8, var9);

      for(int var10 = 0; var10 < var4; ++var10) {
         for(int var11 = 0; var11 < var4; ++var11) {
            for(int var12 = 0; var12 < var5; ++var12) {
               double var13 = 0.125D;
               double var15 = this.field_73228_r[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
               double var17 = this.field_73228_r[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
               double var19 = this.field_73228_r[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
               double var21 = this.field_73228_r[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
               double var23 = (this.field_73228_r[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
               double var25 = (this.field_73228_r[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
               double var27 = (this.field_73228_r[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
               double var29 = (this.field_73228_r[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

               for(int var31 = 0; var31 < 8; ++var31) {
                  double var32 = 0.25D;
                  double var34 = var15;
                  double var36 = var17;
                  double var38 = (var19 - var15) * var32;
                  double var40 = (var21 - var17) * var32;

                  for(int var42 = 0; var42 < 4; ++var42) {
                     int var43 = var42 + var10 * 4 << 11 | 0 + var11 * 4 << 7 | var12 * 8 + var31;
                     short var44 = 128;
                     var43 -= var44;
                     double var45 = 0.25D;
                     double var49 = (var36 - var34) * var45;
                     double var47 = var34 - var49;

                     for(int var51 = 0; var51 < 4; ++var51) {
                        if((var47 += var49) > 0.0D) {
                           p_73206_3_[var43 += var44] = (byte)Block.field_71981_t.field_71990_ca;
                        } else if(var12 * 8 + var31 < var6) {
                           p_73206_3_[var43 += var44] = (byte)Block.field_71943_B.field_71990_ca;
                        } else {
                           p_73206_3_[var43 += var44] = 0;
                        }
                     }

                     var34 += var38;
                     var36 += var40;
                  }

                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
                  var21 += var29;
               }
            }
         }
      }

   }

   public void func_73207_a(int p_73207_1_, int p_73207_2_, byte[] p_73207_3_, BiomeGenBase[] p_73207_4_) {
      byte var5 = 63;
      double var6 = 0.03125D;
      this.field_73227_s = this.field_73216_o.func_76304_a(this.field_73227_s, p_73207_1_ * 16, p_73207_2_ * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

      for(int var8 = 0; var8 < 16; ++var8) {
         for(int var9 = 0; var9 < 16; ++var9) {
            BiomeGenBase var10 = p_73207_4_[var9 + var8 * 16];
            float var11 = var10.func_76743_j();
            int var12 = (int)(this.field_73227_s[var8 + var9 * 16] / 3.0D + 3.0D + this.field_73220_k.nextDouble() * 0.25D);
            int var13 = -1;
            byte var14 = var10.field_76752_A;
            byte var15 = var10.field_76753_B;

            for(int var16 = 127; var16 >= 0; --var16) {
               int var17 = (var9 * 16 + var8) * 128 + var16;
               if(var16 <= 0 + this.field_73220_k.nextInt(5)) {
                  p_73207_3_[var17] = (byte)Block.field_71986_z.field_71990_ca;
               } else {
                  byte var18 = p_73207_3_[var17];
                  if(var18 == 0) {
                     var13 = -1;
                  } else if(var18 == Block.field_71981_t.field_71990_ca) {
                     if(var13 == -1) {
                        if(var12 <= 0) {
                           var14 = 0;
                           var15 = (byte)Block.field_71981_t.field_71990_ca;
                        } else if(var16 >= var5 - 4 && var16 <= var5 + 1) {
                           var14 = var10.field_76752_A;
                           var15 = var10.field_76753_B;
                        }

                        if(var16 < var5 && var14 == 0) {
                           if(var11 < 0.15F) {
                              var14 = (byte)Block.field_72036_aT.field_71990_ca;
                           } else {
                              var14 = (byte)Block.field_71943_B.field_71990_ca;
                           }
                        }

                        var13 = var12;
                        if(var16 >= var5 - 1) {
                           p_73207_3_[var17] = var14;
                        } else {
                           p_73207_3_[var17] = var15;
                        }
                     } else if(var13 > 0) {
                        --var13;
                        p_73207_3_[var17] = var15;
                        if(var13 == 0 && var15 == Block.field_71939_E.field_71990_ca) {
                           var13 = this.field_73220_k.nextInt(4);
                           var15 = (byte)Block.field_71957_Q.field_71990_ca;
                        }
                     }
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
      this.field_73220_k.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.func_73206_a(p_73154_1_, p_73154_2_, var3);
      this.field_73231_z = this.field_73230_p.func_72959_q().func_76933_b(this.field_73231_z, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
      this.func_73207_a(p_73154_1_, p_73154_2_, var3, this.field_73231_z);
      this.field_73226_t.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, var3);
      this.field_73232_y.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, var3);
      if(this.field_73229_q) {
         this.field_73223_w.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, var3);
         this.field_73224_v.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, var3);
         this.field_73225_u.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, var3);
         this.field_73233_x.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, var3);
      }

      Chunk var4 = new Chunk(this.field_73230_p, var3, p_73154_1_, p_73154_2_);
      byte[] var5 = var4.func_76605_m();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.field_73231_z[var6].field_76756_M;
      }

      var4.func_76603_b();
      return var4;
   }

   private double[] func_73205_a(double[] p_73205_1_, int p_73205_2_, int p_73205_3_, int p_73205_4_, int p_73205_5_, int p_73205_6_, int p_73205_7_) {
      if(p_73205_1_ == null) {
         p_73205_1_ = new double[p_73205_5_ * p_73205_6_ * p_73205_7_];
      }

      if(this.field_73222_i == null) {
         this.field_73222_i = new float[25];

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               float var10 = 10.0F / MathHelper.func_76129_c((float)(var8 * var8 + var9 * var9) + 0.2F);
               this.field_73222_i[var8 + 2 + (var9 + 2) * 5] = var10;
            }
         }
      }

      double var44 = 684.412D;
      double var45 = 684.412D;
      this.field_73209_g = this.field_73214_a.func_76305_a(this.field_73209_g, p_73205_2_, p_73205_4_, p_73205_5_, p_73205_7_, 1.121D, 1.121D, 0.5D);
      this.field_73221_h = this.field_73212_b.func_76305_a(this.field_73221_h, p_73205_2_, p_73205_4_, p_73205_5_, p_73205_7_, 200.0D, 200.0D, 0.5D);
      this.field_73210_d = this.field_73215_n.func_76304_a(this.field_73210_d, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
      this.field_73211_e = this.field_73217_l.func_76304_a(this.field_73211_e, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, var44, var45, var44);
      this.field_73208_f = this.field_73218_m.func_76304_a(this.field_73208_f, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, var44, var45, var44);
      boolean var43 = false;
      boolean var42 = false;
      int var12 = 0;
      int var13 = 0;

      for(int var14 = 0; var14 < p_73205_5_; ++var14) {
         for(int var15 = 0; var15 < p_73205_7_; ++var15) {
            float var16 = 0.0F;
            float var17 = 0.0F;
            float var18 = 0.0F;
            byte var19 = 2;
            BiomeGenBase var20 = this.field_73231_z[var14 + 2 + (var15 + 2) * (p_73205_5_ + 5)];

            for(int var21 = -var19; var21 <= var19; ++var21) {
               for(int var22 = -var19; var22 <= var19; ++var22) {
                  BiomeGenBase var23 = this.field_73231_z[var14 + var21 + 2 + (var15 + var22 + 2) * (p_73205_5_ + 5)];
                  float var24 = this.field_73222_i[var21 + 2 + (var22 + 2) * 5] / (var23.field_76748_D + 2.0F);
                  if(var23.field_76748_D > var20.field_76748_D) {
                     var24 /= 2.0F;
                  }

                  var16 += var23.field_76749_E * var24;
                  var17 += var23.field_76748_D * var24;
                  var18 += var24;
               }
            }

            var16 /= var18;
            var17 /= var18;
            var16 = var16 * 0.9F + 0.1F;
            var17 = (var17 * 4.0F - 1.0F) / 8.0F;
            double var47 = this.field_73221_h[var13] / 8000.0D;
            if(var47 < 0.0D) {
               var47 = -var47 * 0.3D;
            }

            var47 = var47 * 3.0D - 2.0D;
            if(var47 < 0.0D) {
               var47 /= 2.0D;
               if(var47 < -1.0D) {
                  var47 = -1.0D;
               }

               var47 /= 1.4D;
               var47 /= 2.0D;
            } else {
               if(var47 > 1.0D) {
                  var47 = 1.0D;
               }

               var47 /= 8.0D;
            }

            ++var13;

            for(int var46 = 0; var46 < p_73205_6_; ++var46) {
               double var48 = (double)var17;
               double var26 = (double)var16;
               var48 += var47 * 0.2D;
               var48 = var48 * (double)p_73205_6_ / 16.0D;
               double var28 = (double)p_73205_6_ / 2.0D + var48 * 4.0D;
               double var30 = 0.0D;
               double var32 = ((double)var46 - var28) * 12.0D * 128.0D / 128.0D / var26;
               if(var32 < 0.0D) {
                  var32 *= 4.0D;
               }

               double var34 = this.field_73211_e[var12] / 512.0D;
               double var36 = this.field_73208_f[var12] / 512.0D;
               double var38 = (this.field_73210_d[var12] / 10.0D + 1.0D) / 2.0D;
               if(var38 < 0.0D) {
                  var30 = var34;
               } else if(var38 > 1.0D) {
                  var30 = var36;
               } else {
                  var30 = var34 + (var36 - var34) * var38;
               }

               var30 -= var32;
               if(var46 > p_73205_6_ - 4) {
                  double var40 = (double)((float)(var46 - (p_73205_6_ - 4)) / 3.0F);
                  var30 = var30 * (1.0D - var40) + -10.0D * var40;
               }

               p_73205_1_[var12] = var30;
               ++var12;
            }
         }
      }

      return p_73205_1_;
   }

   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
      return true;
   }

   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
      BlockSand.field_72192_a = true;
      int var4 = p_73153_2_ * 16;
      int var5 = p_73153_3_ * 16;
      BiomeGenBase var6 = this.field_73230_p.func_72807_a(var4 + 16, var5 + 16);
      this.field_73220_k.setSeed(this.field_73230_p.func_72905_C());
      long var7 = this.field_73220_k.nextLong() / 2L * 2L + 1L;
      long var9 = this.field_73220_k.nextLong() / 2L * 2L + 1L;
      this.field_73220_k.setSeed((long)p_73153_2_ * var7 + (long)p_73153_3_ * var9 ^ this.field_73230_p.func_72905_C());
      boolean var11 = false;
      if(this.field_73229_q) {
         this.field_73223_w.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
         var11 = this.field_73224_v.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
         this.field_73225_u.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
         this.field_73233_x.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
      }

      int var12;
      int var13;
      int var14;
      if(!var11 && this.field_73220_k.nextInt(4) == 0) {
         var12 = var4 + this.field_73220_k.nextInt(16) + 8;
         var13 = this.field_73220_k.nextInt(128);
         var14 = var5 + this.field_73220_k.nextInt(16) + 8;
         (new WorldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.field_73230_p, this.field_73220_k, var12, var13, var14);
      }

      if(!var11 && this.field_73220_k.nextInt(8) == 0) {
         var12 = var4 + this.field_73220_k.nextInt(16) + 8;
         var13 = this.field_73220_k.nextInt(this.field_73220_k.nextInt(120) + 8);
         var14 = var5 + this.field_73220_k.nextInt(16) + 8;
         if(var13 < 63 || this.field_73220_k.nextInt(10) == 0) {
            (new WorldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.field_73230_p, this.field_73220_k, var12, var13, var14);
         }
      }

      for(var12 = 0; var12 < 8; ++var12) {
         var13 = var4 + this.field_73220_k.nextInt(16) + 8;
         var14 = this.field_73220_k.nextInt(128);
         int var15 = var5 + this.field_73220_k.nextInt(16) + 8;
         if((new WorldGenDungeons()).func_76484_a(this.field_73230_p, this.field_73220_k, var13, var14, var15)) {
            ;
         }
      }

      var6.func_76728_a(this.field_73230_p, this.field_73220_k, var4, var5);
      SpawnerAnimals.func_77191_a(this.field_73230_p, var6, var4 + 8, var5 + 8, 16, 16, this.field_73220_k);
      var4 += 8;
      var5 += 8;

      for(var12 = 0; var12 < 16; ++var12) {
         for(var13 = 0; var13 < 16; ++var13) {
            var14 = this.field_73230_p.func_72874_g(var4 + var12, var5 + var13);
            if(this.field_73230_p.func_72884_u(var12 + var4, var14 - 1, var13 + var5)) {
               this.field_73230_p.func_72832_d(var12 + var4, var14 - 1, var13 + var5, Block.field_72036_aT.field_71990_ca, 0, 2);
            }

            if(this.field_73230_p.func_72858_w(var12 + var4, var14, var13 + var5)) {
               this.field_73230_p.func_72832_d(var12 + var4, var14, var13 + var5, Block.field_72037_aS.field_71990_ca, 0, 2);
            }
         }
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
      return "RandomLevelSource";
   }

   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
      BiomeGenBase var5 = this.field_73230_p.func_72807_a(p_73155_2_, p_73155_4_);
      return var5 == null?null:(var5 == BiomeGenBase.field_76780_h && p_73155_1_ == EnumCreatureType.monster && this.field_73233_x.func_75048_a(p_73155_2_, p_73155_3_, p_73155_4_)?this.field_73233_x.func_82667_a():var5.func_76747_a(p_73155_1_));
   }

   public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_) {
      return "Stronghold".equals(p_73150_2_) && this.field_73225_u != null?this.field_73225_u.func_75050_a(p_73150_1_, p_73150_3_, p_73150_4_, p_73150_5_):null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int p_82695_1_, int p_82695_2_) {
      if(this.field_73229_q) {
         this.field_73223_w.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
         this.field_73224_v.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
         this.field_73225_u.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
         this.field_73233_x.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
      }

   }
}
