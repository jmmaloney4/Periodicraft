package net.minecraft.world.chunk;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class Chunk {

   public static boolean field_76640_a;
   private ExtendedBlockStorage[] field_76652_q;
   private byte[] field_76651_r;
   public int[] field_76638_b;
   public boolean[] field_76639_c;
   public boolean field_76636_d;
   public World field_76637_e;
   public int[] field_76634_f;
   public final int field_76635_g;
   public final int field_76647_h;
   private boolean field_76650_s;
   public Map field_76648_i;
   public List[] field_76645_j;
   public boolean field_76646_k;
   public boolean field_76643_l;
   public boolean field_76644_m;
   public long field_76641_n;
   public boolean field_76642_o;
   public int field_82912_p;
   private int field_76649_t;
   boolean field_76653_p;


   public Chunk(World p_i3771_1_, int p_i3771_2_, int p_i3771_3_) {
      this.field_76652_q = new ExtendedBlockStorage[16];
      this.field_76651_r = new byte[256];
      this.field_76638_b = new int[256];
      this.field_76639_c = new boolean[256];
      this.field_76650_s = false;
      this.field_76648_i = new HashMap();
      this.field_76646_k = false;
      this.field_76643_l = false;
      this.field_76644_m = false;
      this.field_76641_n = 0L;
      this.field_76642_o = false;
      this.field_82912_p = 0;
      this.field_76649_t = 4096;
      this.field_76653_p = false;
      this.field_76645_j = new List[16];
      this.field_76637_e = p_i3771_1_;
      this.field_76635_g = p_i3771_2_;
      this.field_76647_h = p_i3771_3_;
      this.field_76634_f = new int[256];

      for(int var4 = 0; var4 < this.field_76645_j.length; ++var4) {
         this.field_76645_j[var4] = new ArrayList();
      }

      Arrays.fill(this.field_76638_b, -999);
      Arrays.fill(this.field_76651_r, (byte)-1);
   }

   public Chunk(World p_i3772_1_, byte[] p_i3772_2_, int p_i3772_3_, int p_i3772_4_) {
      this(p_i3772_1_, p_i3772_3_, p_i3772_4_);
      int var5 = p_i3772_2_.length / 256;

      for(int var6 = 0; var6 < 16; ++var6) {
         for(int var7 = 0; var7 < 16; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
               byte var9 = p_i3772_2_[var6 << 11 | var7 << 7 | var8];
               if(var9 != 0) {
                  int var10 = var8 >> 4;
                  if(this.field_76652_q[var10] == null) {
                     this.field_76652_q[var10] = new ExtendedBlockStorage(var10 << 4, !p_i3772_1_.field_73011_w.field_76576_e);
                  }

                  this.field_76652_q[var10].func_76655_a(var6, var8 & 15, var7, var9);
               }
            }
         }
      }

   }

   public boolean func_76600_a(int p_76600_1_, int p_76600_2_) {
      return p_76600_1_ == this.field_76635_g && p_76600_2_ == this.field_76647_h;
   }

   public int func_76611_b(int p_76611_1_, int p_76611_2_) {
      return this.field_76634_f[p_76611_2_ << 4 | p_76611_1_];
   }

   public int func_76625_h() {
      for(int var1 = this.field_76652_q.length - 1; var1 >= 0; --var1) {
         if(this.field_76652_q[var1] != null) {
            return this.field_76652_q[var1].func_76662_d();
         }
      }

      return 0;
   }

   public ExtendedBlockStorage[] func_76587_i() {
      return this.field_76652_q;
   }

   @SideOnly(Side.CLIENT)
   public void func_76590_a() {
      int var1 = this.func_76625_h();

      for(int var2 = 0; var2 < 16; ++var2) {
         int var3 = 0;

         while(var3 < 16) {
            this.field_76638_b[var2 + (var3 << 4)] = -999;
            int var4 = var1 + 16 - 1;

            while(true) {
               if(var4 > 0) {
                  int var5 = this.func_76610_a(var2, var4 - 1, var3);
                  if(Block.field_71971_o[var5] == 0) {
                     --var4;
                     continue;
                  }

                  this.field_76634_f[var3 << 4 | var2] = var4;
               }

               ++var3;
               break;
            }
         }
      }

      this.field_76643_l = true;
   }

   public void func_76603_b() {
      int var1 = this.func_76625_h();
      this.field_82912_p = Integer.MAX_VALUE;

      int var2;
      int var3;
      for(var2 = 0; var2 < 16; ++var2) {
         var3 = 0;

         while(var3 < 16) {
            this.field_76638_b[var2 + (var3 << 4)] = -999;
            int var4 = var1 + 16 - 1;

            while(true) {
               if(var4 > 0) {
                  if(this.func_76596_b(var2, var4 - 1, var3) == 0) {
                     --var4;
                     continue;
                  }

                  this.field_76634_f[var3 << 4 | var2] = var4;
                  if(var4 < this.field_82912_p) {
                     this.field_82912_p = var4;
                  }
               }

               if(!this.field_76637_e.field_73011_w.field_76576_e) {
                  var4 = 15;
                  int var5 = var1 + 16 - 1;

                  do {
                     var4 -= this.func_76596_b(var2, var5, var3);
                     if(var4 > 0) {
                        ExtendedBlockStorage var6 = this.field_76652_q[var5 >> 4];
                        if(var6 != null) {
                           var6.func_76657_c(var2, var5 & 15, var3, var4);
                           this.field_76637_e.func_72902_n((this.field_76635_g << 4) + var2, var5, (this.field_76647_h << 4) + var3);
                        }
                     }

                     --var5;
                  } while(var5 > 0 && var4 > 0);
               }

               ++var3;
               break;
            }
         }
      }

      this.field_76643_l = true;

      for(var2 = 0; var2 < 16; ++var2) {
         for(var3 = 0; var3 < 16; ++var3) {
            this.func_76595_e(var2, var3);
         }
      }

   }

   private void func_76595_e(int p_76595_1_, int p_76595_2_) {
      this.field_76639_c[p_76595_1_ + p_76595_2_ * 16] = true;
      this.field_76650_s = true;
   }

   private void func_76593_q() {
      this.field_76637_e.field_72984_F.func_76320_a("recheckGaps");
      if(this.field_76637_e.func_72873_a(this.field_76635_g * 16 + 8, 0, this.field_76647_h * 16 + 8, 16)) {
         for(int var1 = 0; var1 < 16; ++var1) {
            for(int var2 = 0; var2 < 16; ++var2) {
               if(this.field_76639_c[var1 + var2 * 16]) {
                  this.field_76639_c[var1 + var2 * 16] = false;
                  int var3 = this.func_76611_b(var1, var2);
                  int var4 = this.field_76635_g * 16 + var1;
                  int var5 = this.field_76647_h * 16 + var2;
                  int var6 = this.field_76637_e.func_82734_g(var4 - 1, var5);
                  int var7 = this.field_76637_e.func_82734_g(var4 + 1, var5);
                  int var8 = this.field_76637_e.func_82734_g(var4, var5 - 1);
                  int var9 = this.field_76637_e.func_82734_g(var4, var5 + 1);
                  if(var7 < var6) {
                     var6 = var7;
                  }

                  if(var8 < var6) {
                     var6 = var8;
                  }

                  if(var9 < var6) {
                     var6 = var9;
                  }

                  this.func_76599_g(var4, var5, var6);
                  this.func_76599_g(var4 - 1, var5, var3);
                  this.func_76599_g(var4 + 1, var5, var3);
                  this.func_76599_g(var4, var5 - 1, var3);
                  this.func_76599_g(var4, var5 + 1, var3);
               }
            }
         }

         this.field_76650_s = false;
      }

      this.field_76637_e.field_72984_F.func_76319_b();
   }

   private void func_76599_g(int p_76599_1_, int p_76599_2_, int p_76599_3_) {
      int var4 = this.field_76637_e.func_72976_f(p_76599_1_, p_76599_2_);
      if(var4 > p_76599_3_) {
         this.func_76609_d(p_76599_1_, p_76599_2_, p_76599_3_, var4 + 1);
      } else if(var4 < p_76599_3_) {
         this.func_76609_d(p_76599_1_, p_76599_2_, var4, p_76599_3_ + 1);
      }

   }

   private void func_76609_d(int p_76609_1_, int p_76609_2_, int p_76609_3_, int p_76609_4_) {
      if(p_76609_4_ > p_76609_3_ && this.field_76637_e.func_72873_a(p_76609_1_, 0, p_76609_2_, 16)) {
         for(int var5 = p_76609_3_; var5 < p_76609_4_; ++var5) {
            this.field_76637_e.func_72936_c(EnumSkyBlock.Sky, p_76609_1_, var5, p_76609_2_);
         }

         this.field_76643_l = true;
      }

   }

   private void func_76615_h(int p_76615_1_, int p_76615_2_, int p_76615_3_) {
      int var4 = this.field_76634_f[p_76615_3_ << 4 | p_76615_1_] & 255;
      int var5 = var4;
      if(p_76615_2_ > var4) {
         var5 = p_76615_2_;
      }

      while(var5 > 0 && this.func_76596_b(p_76615_1_, var5 - 1, p_76615_3_) == 0) {
         --var5;
      }

      if(var5 != var4) {
         this.field_76637_e.func_72975_g(p_76615_1_ + this.field_76635_g * 16, p_76615_3_ + this.field_76647_h * 16, var5, var4);
         this.field_76634_f[p_76615_3_ << 4 | p_76615_1_] = var5;
         int var6 = this.field_76635_g * 16 + p_76615_1_;
         int var7 = this.field_76647_h * 16 + p_76615_3_;
         int var8;
         int var12;
         if(!this.field_76637_e.field_73011_w.field_76576_e) {
            ExtendedBlockStorage var9;
            if(var5 < var4) {
               for(var8 = var5; var8 < var4; ++var8) {
                  var9 = this.field_76652_q[var8 >> 4];
                  if(var9 != null) {
                     var9.func_76657_c(p_76615_1_, var8 & 15, p_76615_3_, 15);
                     this.field_76637_e.func_72902_n((this.field_76635_g << 4) + p_76615_1_, var8, (this.field_76647_h << 4) + p_76615_3_);
                  }
               }
            } else {
               for(var8 = var4; var8 < var5; ++var8) {
                  var9 = this.field_76652_q[var8 >> 4];
                  if(var9 != null) {
                     var9.func_76657_c(p_76615_1_, var8 & 15, p_76615_3_, 0);
                     this.field_76637_e.func_72902_n((this.field_76635_g << 4) + p_76615_1_, var8, (this.field_76647_h << 4) + p_76615_3_);
                  }
               }
            }

            var8 = 15;

            while(var5 > 0 && var8 > 0) {
               --var5;
               var12 = this.func_76596_b(p_76615_1_, var5, p_76615_3_);
               if(var12 == 0) {
                  var12 = 1;
               }

               var8 -= var12;
               if(var8 < 0) {
                  var8 = 0;
               }

               ExtendedBlockStorage var10 = this.field_76652_q[var5 >> 4];
               if(var10 != null) {
                  var10.func_76657_c(p_76615_1_, var5 & 15, p_76615_3_, var8);
               }
            }
         }

         var8 = this.field_76634_f[p_76615_3_ << 4 | p_76615_1_];
         var12 = var4;
         int var13 = var8;
         if(var8 < var4) {
            var12 = var8;
            var13 = var4;
         }

         if(var8 < this.field_82912_p) {
            this.field_82912_p = var8;
         }

         if(!this.field_76637_e.field_73011_w.field_76576_e) {
            this.func_76609_d(var6 - 1, var7, var12, var13);
            this.func_76609_d(var6 + 1, var7, var12, var13);
            this.func_76609_d(var6, var7 - 1, var12, var13);
            this.func_76609_d(var6, var7 + 1, var12, var13);
            this.func_76609_d(var6, var7, var12, var13);
         }

         this.field_76643_l = true;
      }
   }

   public int func_76596_b(int p_76596_1_, int p_76596_2_, int p_76596_3_) {
      return Block.field_71971_o[this.func_76610_a(p_76596_1_, p_76596_2_, p_76596_3_)];
   }

   public int func_76610_a(int p_76610_1_, int p_76610_2_, int p_76610_3_) {
      if(p_76610_2_ >> 4 >= this.field_76652_q.length) {
         return 0;
      } else {
         ExtendedBlockStorage var4 = this.field_76652_q[p_76610_2_ >> 4];
         return var4 != null?var4.func_76656_a(p_76610_1_, p_76610_2_ & 15, p_76610_3_):0;
      }
   }

   public int func_76628_c(int p_76628_1_, int p_76628_2_, int p_76628_3_) {
      if(p_76628_2_ >> 4 >= this.field_76652_q.length) {
         return 0;
      } else {
         ExtendedBlockStorage var4 = this.field_76652_q[p_76628_2_ >> 4];
         return var4 != null?var4.func_76665_b(p_76628_1_, p_76628_2_ & 15, p_76628_3_):0;
      }
   }

   public boolean func_76592_a(int p_76592_1_, int p_76592_2_, int p_76592_3_, int p_76592_4_, int p_76592_5_) {
      int var6 = p_76592_3_ << 4 | p_76592_1_;
      if(p_76592_2_ >= this.field_76638_b[var6] - 1) {
         this.field_76638_b[var6] = -999;
      }

      int var7 = this.field_76634_f[var6];
      int var8 = this.func_76610_a(p_76592_1_, p_76592_2_, p_76592_3_);
      int var9 = this.func_76628_c(p_76592_1_, p_76592_2_, p_76592_3_);
      if(var8 == p_76592_4_ && var9 == p_76592_5_) {
         return false;
      } else {
         ExtendedBlockStorage var10 = this.field_76652_q[p_76592_2_ >> 4];
         boolean var11 = false;
         if(var10 == null) {
            if(p_76592_4_ == 0) {
               return false;
            }

            var10 = this.field_76652_q[p_76592_2_ >> 4] = new ExtendedBlockStorage(p_76592_2_ >> 4 << 4, !this.field_76637_e.field_73011_w.field_76576_e);
            var11 = p_76592_2_ >= var7;
         }

         int var12 = this.field_76635_g * 16 + p_76592_1_;
         int var13 = this.field_76647_h * 16 + p_76592_3_;
         if(var8 != 0 && !this.field_76637_e.field_72995_K) {
            Block.field_71973_m[var8].func_71927_h(this.field_76637_e, var12, p_76592_2_, var13, var9);
         }

         var10.func_76655_a(p_76592_1_, p_76592_2_ & 15, p_76592_3_, p_76592_4_);
         if(var8 != 0) {
            if(!this.field_76637_e.field_72995_K) {
               Block.field_71973_m[var8].func_71852_a(this.field_76637_e, var12, p_76592_2_, var13, var8, var9);
            } else if(Block.field_71973_m[var8] instanceof ITileEntityProvider && var8 != p_76592_4_) {
               this.field_76637_e.func_72932_q(var12, p_76592_2_, var13);
            }
         }

         if(var10.func_76656_a(p_76592_1_, p_76592_2_ & 15, p_76592_3_) != p_76592_4_) {
            return false;
         } else {
            var10.func_76654_b(p_76592_1_, p_76592_2_ & 15, p_76592_3_, p_76592_5_);
            if(var11) {
               this.func_76603_b();
            } else {
               if(Block.field_71971_o[p_76592_4_ & 4095] > 0) {
                  if(p_76592_2_ >= var7) {
                     this.func_76615_h(p_76592_1_, p_76592_2_ + 1, p_76592_3_);
                  }
               } else if(p_76592_2_ == var7 - 1) {
                  this.func_76615_h(p_76592_1_, p_76592_2_, p_76592_3_);
               }

               this.func_76595_e(p_76592_1_, p_76592_3_);
            }

            TileEntity var14;
            if(p_76592_4_ != 0) {
               if(!this.field_76637_e.field_72995_K) {
                  Block.field_71973_m[p_76592_4_].func_71861_g(this.field_76637_e, var12, p_76592_2_, var13);
               }

               if(Block.field_71973_m[p_76592_4_] instanceof ITileEntityProvider) {
                  var14 = this.func_76597_e(p_76592_1_, p_76592_2_, p_76592_3_);
                  if(var14 == null) {
                     var14 = ((ITileEntityProvider)Block.field_71973_m[p_76592_4_]).func_72274_a(this.field_76637_e);
                     this.field_76637_e.func_72837_a(var12, p_76592_2_, var13, var14);
                  }

                  if(var14 != null) {
                     var14.func_70321_h();
                  }
               }
            } else if(var8 > 0 && Block.field_71973_m[var8] instanceof ITileEntityProvider) {
               var14 = this.func_76597_e(p_76592_1_, p_76592_2_, p_76592_3_);
               if(var14 != null) {
                  var14.func_70321_h();
               }
            }

            this.field_76643_l = true;
            return true;
         }
      }
   }

   public boolean func_76589_b(int p_76589_1_, int p_76589_2_, int p_76589_3_, int p_76589_4_) {
      ExtendedBlockStorage var5 = this.field_76652_q[p_76589_2_ >> 4];
      if(var5 == null) {
         return false;
      } else {
         int var6 = var5.func_76665_b(p_76589_1_, p_76589_2_ & 15, p_76589_3_);
         if(var6 == p_76589_4_) {
            return false;
         } else {
            this.field_76643_l = true;
            var5.func_76654_b(p_76589_1_, p_76589_2_ & 15, p_76589_3_, p_76589_4_);
            int var7 = var5.func_76656_a(p_76589_1_, p_76589_2_ & 15, p_76589_3_);
            if(var7 > 0 && Block.field_71973_m[var7] instanceof ITileEntityProvider) {
               TileEntity var8 = this.func_76597_e(p_76589_1_, p_76589_2_, p_76589_3_);
               if(var8 != null) {
                  var8.func_70321_h();
                  var8.field_70325_p = p_76589_4_;
               }
            }

            return true;
         }
      }
   }

   public int func_76614_a(EnumSkyBlock p_76614_1_, int p_76614_2_, int p_76614_3_, int p_76614_4_) {
      ExtendedBlockStorage var5 = this.field_76652_q[p_76614_3_ >> 4];
      return var5 == null?(this.func_76619_d(p_76614_2_, p_76614_3_, p_76614_4_)?p_76614_1_.field_77198_c:0):(p_76614_1_ == EnumSkyBlock.Sky?(this.field_76637_e.field_73011_w.field_76576_e?0:var5.func_76670_c(p_76614_2_, p_76614_3_ & 15, p_76614_4_)):(p_76614_1_ == EnumSkyBlock.Block?var5.func_76674_d(p_76614_2_, p_76614_3_ & 15, p_76614_4_):p_76614_1_.field_77198_c));
   }

   public void func_76633_a(EnumSkyBlock p_76633_1_, int p_76633_2_, int p_76633_3_, int p_76633_4_, int p_76633_5_) {
      ExtendedBlockStorage var6 = this.field_76652_q[p_76633_3_ >> 4];
      if(var6 == null) {
         var6 = this.field_76652_q[p_76633_3_ >> 4] = new ExtendedBlockStorage(p_76633_3_ >> 4 << 4, !this.field_76637_e.field_73011_w.field_76576_e);
         this.func_76603_b();
      }

      this.field_76643_l = true;
      if(p_76633_1_ == EnumSkyBlock.Sky) {
         if(!this.field_76637_e.field_73011_w.field_76576_e) {
            var6.func_76657_c(p_76633_2_, p_76633_3_ & 15, p_76633_4_, p_76633_5_);
         }
      } else if(p_76633_1_ == EnumSkyBlock.Block) {
         var6.func_76677_d(p_76633_2_, p_76633_3_ & 15, p_76633_4_, p_76633_5_);
      }

   }

   public int func_76629_c(int p_76629_1_, int p_76629_2_, int p_76629_3_, int p_76629_4_) {
      ExtendedBlockStorage var5 = this.field_76652_q[p_76629_2_ >> 4];
      if(var5 == null) {
         return !this.field_76637_e.field_73011_w.field_76576_e && p_76629_4_ < EnumSkyBlock.Sky.field_77198_c?EnumSkyBlock.Sky.field_77198_c - p_76629_4_:0;
      } else {
         int var6 = this.field_76637_e.field_73011_w.field_76576_e?0:var5.func_76670_c(p_76629_1_, p_76629_2_ & 15, p_76629_3_);
         if(var6 > 0) {
            field_76640_a = true;
         }

         var6 -= p_76629_4_;
         int var7 = var5.func_76674_d(p_76629_1_, p_76629_2_ & 15, p_76629_3_);
         if(var7 > var6) {
            var6 = var7;
         }

         return var6;
      }
   }

   public void func_76612_a(Entity p_76612_1_) {
      this.field_76644_m = true;
      int var2 = MathHelper.func_76128_c(p_76612_1_.field_70165_t / 16.0D);
      int var3 = MathHelper.func_76128_c(p_76612_1_.field_70161_v / 16.0D);
      if(var2 != this.field_76635_g || var3 != this.field_76647_h) {
         this.field_76637_e.func_98180_V().func_98232_c("Wrong location! " + p_76612_1_);
         Thread.dumpStack();
      }

      int var4 = MathHelper.func_76128_c(p_76612_1_.field_70163_u / 16.0D);
      if(var4 < 0) {
         var4 = 0;
      }

      if(var4 >= this.field_76645_j.length) {
         var4 = this.field_76645_j.length - 1;
      }

      p_76612_1_.field_70175_ag = true;
      p_76612_1_.field_70176_ah = this.field_76635_g;
      p_76612_1_.field_70162_ai = var4;
      p_76612_1_.field_70164_aj = this.field_76647_h;
      this.field_76645_j[var4].add(p_76612_1_);
   }

   public void func_76622_b(Entity p_76622_1_) {
      this.func_76608_a(p_76622_1_, p_76622_1_.field_70162_ai);
   }

   public void func_76608_a(Entity p_76608_1_, int p_76608_2_) {
      if(p_76608_2_ < 0) {
         p_76608_2_ = 0;
      }

      if(p_76608_2_ >= this.field_76645_j.length) {
         p_76608_2_ = this.field_76645_j.length - 1;
      }

      this.field_76645_j[p_76608_2_].remove(p_76608_1_);
   }

   public boolean func_76619_d(int p_76619_1_, int p_76619_2_, int p_76619_3_) {
      return p_76619_2_ >= this.field_76634_f[p_76619_3_ << 4 | p_76619_1_];
   }

   public TileEntity func_76597_e(int p_76597_1_, int p_76597_2_, int p_76597_3_) {
      ChunkPosition var4 = new ChunkPosition(p_76597_1_, p_76597_2_, p_76597_3_);
      TileEntity var5 = (TileEntity)this.field_76648_i.get(var4);
      if(var5 == null) {
         int var6 = this.func_76610_a(p_76597_1_, p_76597_2_, p_76597_3_);
         if(var6 <= 0 || !Block.field_71973_m[var6].func_71887_s()) {
            return null;
         }

         if(var5 == null) {
            var5 = ((ITileEntityProvider)Block.field_71973_m[var6]).func_72274_a(this.field_76637_e);
            this.field_76637_e.func_72837_a(this.field_76635_g * 16 + p_76597_1_, p_76597_2_, this.field_76647_h * 16 + p_76597_3_, var5);
         }

         var5 = (TileEntity)this.field_76648_i.get(var4);
      }

      if(var5 != null && var5.func_70320_p()) {
         this.field_76648_i.remove(var4);
         return null;
      } else {
         return var5;
      }
   }

   public void func_76620_a(TileEntity p_76620_1_) {
      int var2 = p_76620_1_.field_70329_l - this.field_76635_g * 16;
      int var3 = p_76620_1_.field_70330_m;
      int var4 = p_76620_1_.field_70327_n - this.field_76647_h * 16;
      this.func_76604_a(var2, var3, var4, p_76620_1_);
      if(this.field_76636_d) {
         this.field_76637_e.field_73009_h.add(p_76620_1_);
      }

   }

   public void func_76604_a(int p_76604_1_, int p_76604_2_, int p_76604_3_, TileEntity p_76604_4_) {
      ChunkPosition var5 = new ChunkPosition(p_76604_1_, p_76604_2_, p_76604_3_);
      p_76604_4_.func_70308_a(this.field_76637_e);
      p_76604_4_.field_70329_l = this.field_76635_g * 16 + p_76604_1_;
      p_76604_4_.field_70330_m = p_76604_2_;
      p_76604_4_.field_70327_n = this.field_76647_h * 16 + p_76604_3_;
      if(this.func_76610_a(p_76604_1_, p_76604_2_, p_76604_3_) != 0 && Block.field_71973_m[this.func_76610_a(p_76604_1_, p_76604_2_, p_76604_3_)] instanceof ITileEntityProvider) {
         if(this.field_76648_i.containsKey(var5)) {
            ((TileEntity)this.field_76648_i.get(var5)).func_70313_j();
         }

         p_76604_4_.func_70312_q();
         this.field_76648_i.put(var5, p_76604_4_);
      }
   }

   public void func_76627_f(int p_76627_1_, int p_76627_2_, int p_76627_3_) {
      ChunkPosition var4 = new ChunkPosition(p_76627_1_, p_76627_2_, p_76627_3_);
      if(this.field_76636_d) {
         TileEntity var5 = (TileEntity)this.field_76648_i.remove(var4);
         if(var5 != null) {
            var5.func_70313_j();
         }
      }

   }

   public void func_76631_c() {
      this.field_76636_d = true;
      this.field_76637_e.func_72852_a(this.field_76648_i.values());

      for(int var1 = 0; var1 < this.field_76645_j.length; ++var1) {
         this.field_76637_e.func_72868_a(this.field_76645_j[var1]);
      }

   }

   public void func_76623_d() {
      this.field_76636_d = false;
      Iterator var1 = this.field_76648_i.values().iterator();

      while(var1.hasNext()) {
         TileEntity var2 = (TileEntity)var1.next();
         this.field_76637_e.func_72928_a(var2);
      }

      for(int var3 = 0; var3 < this.field_76645_j.length; ++var3) {
         this.field_76637_e.func_72828_b(this.field_76645_j[var3]);
      }

   }

   public void func_76630_e() {
      this.field_76643_l = true;
   }

   public void func_76588_a(Entity p_76588_1_, AxisAlignedBB p_76588_2_, List p_76588_3_, IEntitySelector p_76588_4_) {
      int var5 = MathHelper.func_76128_c((p_76588_2_.field_72338_b - 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_76588_2_.field_72337_e + 2.0D) / 16.0D);
      if(var5 < 0) {
         var5 = 0;
         var6 = Math.max(var5, var6);
      }

      if(var6 >= this.field_76645_j.length) {
         var6 = this.field_76645_j.length - 1;
         var5 = Math.min(var5, var6);
      }

      for(int var7 = var5; var7 <= var6; ++var7) {
         List var8 = this.field_76645_j[var7];

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            Entity var10 = (Entity)var8.get(var9);
            if(var10 != p_76588_1_ && var10.field_70121_D.func_72326_a(p_76588_2_) && (p_76588_4_ == null || p_76588_4_.func_82704_a(var10))) {
               p_76588_3_.add(var10);
               Entity[] var11 = var10.func_70021_al();
               if(var11 != null) {
                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     var10 = var11[var12];
                     if(var10 != p_76588_1_ && var10.field_70121_D.func_72326_a(p_76588_2_) && (p_76588_4_ == null || p_76588_4_.func_82704_a(var10))) {
                        p_76588_3_.add(var10);
                     }
                  }
               }
            }
         }
      }

   }

   public void func_76618_a(Class p_76618_1_, AxisAlignedBB p_76618_2_, List p_76618_3_, IEntitySelector p_76618_4_) {
      int var5 = MathHelper.func_76128_c((p_76618_2_.field_72338_b - 2.0D) / 16.0D);
      int var6 = MathHelper.func_76128_c((p_76618_2_.field_72337_e + 2.0D) / 16.0D);
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 >= this.field_76645_j.length) {
         var5 = this.field_76645_j.length - 1;
      }

      if(var6 >= this.field_76645_j.length) {
         var6 = this.field_76645_j.length - 1;
      } else if(var6 < 0) {
         var6 = 0;
      }

      for(int var7 = var5; var7 <= var6; ++var7) {
         List var8 = this.field_76645_j[var7];

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            Entity var10 = (Entity)var8.get(var9);
            if(p_76618_1_.isAssignableFrom(var10.getClass()) && var10.field_70121_D.func_72326_a(p_76618_2_) && (p_76618_4_ == null || p_76618_4_.func_82704_a(var10))) {
               p_76618_3_.add(var10);
            }
         }
      }

   }

   public boolean func_76601_a(boolean p_76601_1_) {
      if(p_76601_1_) {
         if(this.field_76644_m && this.field_76637_e.func_82737_E() != this.field_76641_n || this.field_76643_l) {
            return true;
         }
      } else if(this.field_76644_m && this.field_76637_e.func_82737_E() >= this.field_76641_n + 600L) {
         return true;
      }

      return this.field_76643_l;
   }

   public Random func_76617_a(long p_76617_1_) {
      return new Random(this.field_76637_e.func_72905_C() + (long)(this.field_76635_g * this.field_76635_g * 4987142) + (long)(this.field_76635_g * 5947611) + (long)(this.field_76647_h * this.field_76647_h) * 4392871L + (long)(this.field_76647_h * 389711) ^ p_76617_1_);
   }

   public boolean func_76621_g() {
      return false;
   }

   public void func_76624_a(IChunkProvider p_76624_1_, IChunkProvider p_76624_2_, int p_76624_3_, int p_76624_4_) {
      if(!this.field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_)) {
         p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_, p_76624_4_);
      }

      if(p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_) && !p_76624_1_.func_73154_d(p_76624_3_ - 1, p_76624_4_).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ + 1) && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ + 1)) {
         p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_ - 1, p_76624_4_);
      }

      if(p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ - 1) && !p_76624_1_.func_73154_d(p_76624_3_, p_76624_4_ - 1).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ + 1, p_76624_4_)) {
         p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_, p_76624_4_ - 1);
      }

      if(p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_ - 1) && !p_76624_1_.func_73154_d(p_76624_3_ - 1, p_76624_4_ - 1).field_76646_k && p_76624_1_.func_73149_a(p_76624_3_, p_76624_4_ - 1) && p_76624_1_.func_73149_a(p_76624_3_ - 1, p_76624_4_)) {
         p_76624_1_.func_73153_a(p_76624_2_, p_76624_3_ - 1, p_76624_4_ - 1);
      }

   }

   public int func_76626_d(int p_76626_1_, int p_76626_2_) {
      int var3 = p_76626_1_ | p_76626_2_ << 4;
      int var4 = this.field_76638_b[var3];
      if(var4 == -999) {
         int var5 = this.func_76625_h() + 15;
         var4 = -1;

         while(var5 > 0 && var4 == -1) {
            int var6 = this.func_76610_a(p_76626_1_, var5, p_76626_2_);
            Material var7 = var6 == 0?Material.field_76249_a:Block.field_71973_m[var6].field_72018_cp;
            if(!var7.func_76230_c() && !var7.func_76224_d()) {
               --var5;
            } else {
               var4 = var5 + 1;
            }
         }

         this.field_76638_b[var3] = var4;
      }

      return var4;
   }

   public void func_76586_k() {
      if(this.field_76650_s && !this.field_76637_e.field_73011_w.field_76576_e) {
         this.func_76593_q();
      }

   }

   public ChunkCoordIntPair func_76632_l() {
      return new ChunkCoordIntPair(this.field_76635_g, this.field_76647_h);
   }

   public boolean func_76606_c(int p_76606_1_, int p_76606_2_) {
      if(p_76606_1_ < 0) {
         p_76606_1_ = 0;
      }

      if(p_76606_2_ >= 256) {
         p_76606_2_ = 255;
      }

      for(int var3 = p_76606_1_; var3 <= p_76606_2_; var3 += 16) {
         ExtendedBlockStorage var4 = this.field_76652_q[var3 >> 4];
         if(var4 != null && !var4.func_76663_a()) {
            return false;
         }
      }

      return true;
   }

   public void func_76602_a(ExtendedBlockStorage[] p_76602_1_) {
      this.field_76652_q = p_76602_1_;
   }

   @SideOnly(Side.CLIENT)
   public void func_76607_a(byte[] p_76607_1_, int p_76607_2_, int p_76607_3_, boolean p_76607_4_) {
      int var5 = 0;
      boolean var6 = !this.field_76637_e.field_73011_w.field_76576_e;

      int var7;
      for(var7 = 0; var7 < this.field_76652_q.length; ++var7) {
         if((p_76607_2_ & 1 << var7) != 0) {
            if(this.field_76652_q[var7] == null) {
               this.field_76652_q[var7] = new ExtendedBlockStorage(var7 << 4, var6);
            }

            byte[] var8 = this.field_76652_q[var7].func_76658_g();
            System.arraycopy(p_76607_1_, var5, var8, 0, var8.length);
            var5 += var8.length;
         } else if(p_76607_4_ && this.field_76652_q[var7] != null) {
            this.field_76652_q[var7] = null;
         }
      }

      NibbleArray var9;
      for(var7 = 0; var7 < this.field_76652_q.length; ++var7) {
         if((p_76607_2_ & 1 << var7) != 0 && this.field_76652_q[var7] != null) {
            var9 = this.field_76652_q[var7].func_76669_j();
            System.arraycopy(p_76607_1_, var5, var9.field_76585_a, 0, var9.field_76585_a.length);
            var5 += var9.field_76585_a.length;
         }
      }

      for(var7 = 0; var7 < this.field_76652_q.length; ++var7) {
         if((p_76607_2_ & 1 << var7) != 0 && this.field_76652_q[var7] != null) {
            var9 = this.field_76652_q[var7].func_76661_k();
            System.arraycopy(p_76607_1_, var5, var9.field_76585_a, 0, var9.field_76585_a.length);
            var5 += var9.field_76585_a.length;
         }
      }

      if(var6) {
         for(var7 = 0; var7 < this.field_76652_q.length; ++var7) {
            if((p_76607_2_ & 1 << var7) != 0 && this.field_76652_q[var7] != null) {
               var9 = this.field_76652_q[var7].func_76671_l();
               System.arraycopy(p_76607_1_, var5, var9.field_76585_a, 0, var9.field_76585_a.length);
               var5 += var9.field_76585_a.length;
            }
         }
      }

      for(var7 = 0; var7 < this.field_76652_q.length; ++var7) {
         if((p_76607_3_ & 1 << var7) != 0) {
            if(this.field_76652_q[var7] == null) {
               var5 += 2048;
            } else {
               var9 = this.field_76652_q[var7].func_76660_i();
               if(var9 == null) {
                  var9 = this.field_76652_q[var7].func_76667_m();
               }

               System.arraycopy(p_76607_1_, var5, var9.field_76585_a, 0, var9.field_76585_a.length);
               var5 += var9.field_76585_a.length;
            }
         } else if(p_76607_4_ && this.field_76652_q[var7] != null && this.field_76652_q[var7].func_76660_i() != null) {
            this.field_76652_q[var7].func_76676_h();
         }
      }

      if(p_76607_4_) {
         System.arraycopy(p_76607_1_, var5, this.field_76651_r, 0, this.field_76651_r.length);
         int var10000 = var5 + this.field_76651_r.length;
      }

      for(var7 = 0; var7 < this.field_76652_q.length; ++var7) {
         if(this.field_76652_q[var7] != null && (p_76607_2_ & 1 << var7) != 0) {
            this.field_76652_q[var7].func_76672_e();
         }
      }

      this.func_76590_a();
      Iterator var10 = this.field_76648_i.values().iterator();

      while(var10.hasNext()) {
         TileEntity var11 = (TileEntity)var10.next();
         var11.func_70321_h();
      }

   }

   public BiomeGenBase func_76591_a(int p_76591_1_, int p_76591_2_, WorldChunkManager p_76591_3_) {
      int var4 = this.field_76651_r[p_76591_2_ << 4 | p_76591_1_] & 255;
      if(var4 == 255) {
         BiomeGenBase var5 = p_76591_3_.func_76935_a((this.field_76635_g << 4) + p_76591_1_, (this.field_76647_h << 4) + p_76591_2_);
         var4 = var5.field_76756_M;
         this.field_76651_r[p_76591_2_ << 4 | p_76591_1_] = (byte)(var4 & 255);
      }

      return BiomeGenBase.field_76773_a[var4] == null?BiomeGenBase.field_76772_c:BiomeGenBase.field_76773_a[var4];
   }

   public byte[] func_76605_m() {
      return this.field_76651_r;
   }

   public void func_76616_a(byte[] p_76616_1_) {
      this.field_76651_r = p_76616_1_;
   }

   public void func_76613_n() {
      this.field_76649_t = 0;
   }

   public void func_76594_o() {
      for(int var1 = 0; var1 < 8; ++var1) {
         if(this.field_76649_t >= 4096) {
            return;
         }

         int var2 = this.field_76649_t % 16;
         int var3 = this.field_76649_t / 16 % 16;
         int var4 = this.field_76649_t / 256;
         ++this.field_76649_t;
         int var5 = (this.field_76635_g << 4) + var3;
         int var6 = (this.field_76647_h << 4) + var4;

         for(int var7 = 0; var7 < 16; ++var7) {
            int var8 = (var2 << 4) + var7;
            if(this.field_76652_q[var2] == null && (var7 == 0 || var7 == 15 || var3 == 0 || var3 == 15 || var4 == 0 || var4 == 15) || this.field_76652_q[var2] != null && this.field_76652_q[var2].func_76656_a(var3, var7, var4) == 0) {
               if(Block.field_71984_q[this.field_76637_e.func_72798_a(var5, var8 - 1, var6)] > 0) {
                  this.field_76637_e.func_72969_x(var5, var8 - 1, var6);
               }

               if(Block.field_71984_q[this.field_76637_e.func_72798_a(var5, var8 + 1, var6)] > 0) {
                  this.field_76637_e.func_72969_x(var5, var8 + 1, var6);
               }

               if(Block.field_71984_q[this.field_76637_e.func_72798_a(var5 - 1, var8, var6)] > 0) {
                  this.field_76637_e.func_72969_x(var5 - 1, var8, var6);
               }

               if(Block.field_71984_q[this.field_76637_e.func_72798_a(var5 + 1, var8, var6)] > 0) {
                  this.field_76637_e.func_72969_x(var5 + 1, var8, var6);
               }

               if(Block.field_71984_q[this.field_76637_e.func_72798_a(var5, var8, var6 - 1)] > 0) {
                  this.field_76637_e.func_72969_x(var5, var8, var6 - 1);
               }

               if(Block.field_71984_q[this.field_76637_e.func_72798_a(var5, var8, var6 + 1)] > 0) {
                  this.field_76637_e.func_72969_x(var5, var8, var6 + 1);
               }

               this.field_76637_e.func_72969_x(var5, var8, var6);
            }
         }
      }

   }
}
