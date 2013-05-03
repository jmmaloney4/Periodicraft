package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.item.ItemDoor;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;

public abstract class StructureComponent {

   protected StructureBoundingBox field_74887_e;
   protected int field_74885_f;
   protected int field_74886_g;


   protected StructureComponent(int p_i3857_1_) {
      this.field_74886_g = p_i3857_1_;
      this.field_74885_f = -1;
   }

   public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {}

   public abstract boolean func_74875_a(World var1, Random var2, StructureBoundingBox var3);

   public StructureBoundingBox func_74874_b() {
      return this.field_74887_e;
   }

   public int func_74877_c() {
      return this.field_74886_g;
   }

   public static StructureComponent func_74883_a(List p_74883_0_, StructureBoundingBox p_74883_1_) {
      Iterator var2 = p_74883_0_.iterator();

      StructureComponent var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (StructureComponent)var2.next();
      } while(var3.func_74874_b() == null || !var3.func_74874_b().func_78884_a(p_74883_1_));

      return var3;
   }

   public ChunkPosition func_74868_a() {
      return new ChunkPosition(this.field_74887_e.func_78881_e(), this.field_74887_e.func_78879_f(), this.field_74887_e.func_78891_g());
   }

   protected boolean func_74860_a(World p_74860_1_, StructureBoundingBox p_74860_2_) {
      int var3 = Math.max(this.field_74887_e.field_78897_a - 1, p_74860_2_.field_78897_a);
      int var4 = Math.max(this.field_74887_e.field_78895_b - 1, p_74860_2_.field_78895_b);
      int var5 = Math.max(this.field_74887_e.field_78896_c - 1, p_74860_2_.field_78896_c);
      int var6 = Math.min(this.field_74887_e.field_78893_d + 1, p_74860_2_.field_78893_d);
      int var7 = Math.min(this.field_74887_e.field_78894_e + 1, p_74860_2_.field_78894_e);
      int var8 = Math.min(this.field_74887_e.field_78892_f + 1, p_74860_2_.field_78892_f);

      int var9;
      int var10;
      int var11;
      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var5; var10 <= var8; ++var10) {
            var11 = p_74860_1_.func_72798_a(var9, var4, var10);
            if(var11 > 0 && Block.field_71973_m[var11].field_72018_cp.func_76224_d()) {
               return true;
            }

            var11 = p_74860_1_.func_72798_a(var9, var7, var10);
            if(var11 > 0 && Block.field_71973_m[var11].field_72018_cp.func_76224_d()) {
               return true;
            }
         }
      }

      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            var11 = p_74860_1_.func_72798_a(var9, var10, var5);
            if(var11 > 0 && Block.field_71973_m[var11].field_72018_cp.func_76224_d()) {
               return true;
            }

            var11 = p_74860_1_.func_72798_a(var9, var10, var8);
            if(var11 > 0 && Block.field_71973_m[var11].field_72018_cp.func_76224_d()) {
               return true;
            }
         }
      }

      for(var9 = var5; var9 <= var8; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            var11 = p_74860_1_.func_72798_a(var3, var10, var9);
            if(var11 > 0 && Block.field_71973_m[var11].field_72018_cp.func_76224_d()) {
               return true;
            }

            var11 = p_74860_1_.func_72798_a(var6, var10, var9);
            if(var11 > 0 && Block.field_71973_m[var11].field_72018_cp.func_76224_d()) {
               return true;
            }
         }
      }

      return false;
   }

   protected int func_74865_a(int p_74865_1_, int p_74865_2_) {
      switch(this.field_74885_f) {
      case 0:
      case 2:
         return this.field_74887_e.field_78897_a + p_74865_1_;
      case 1:
         return this.field_74887_e.field_78893_d - p_74865_2_;
      case 3:
         return this.field_74887_e.field_78897_a + p_74865_2_;
      default:
         return p_74865_1_;
      }
   }

   protected int func_74862_a(int p_74862_1_) {
      return this.field_74885_f == -1?p_74862_1_:p_74862_1_ + this.field_74887_e.field_78895_b;
   }

   protected int func_74873_b(int p_74873_1_, int p_74873_2_) {
      switch(this.field_74885_f) {
      case 0:
         return this.field_74887_e.field_78896_c + p_74873_2_;
      case 1:
      case 3:
         return this.field_74887_e.field_78896_c + p_74873_1_;
      case 2:
         return this.field_74887_e.field_78892_f - p_74873_2_;
      default:
         return p_74873_2_;
      }
   }

   protected int func_74863_c(int p_74863_1_, int p_74863_2_) {
      if(p_74863_1_ == Block.field_72056_aG.field_71990_ca) {
         if(this.field_74885_f == 1 || this.field_74885_f == 3) {
            if(p_74863_2_ == 1) {
               return 0;
            }

            return 1;
         }
      } else if(p_74863_1_ != Block.field_72054_aE.field_71990_ca && p_74863_1_ != Block.field_72045_aL.field_71990_ca) {
         if(p_74863_1_ != Block.field_72057_aH.field_71990_ca && p_74863_1_ != Block.field_72063_at.field_71990_ca && p_74863_1_ != Block.field_72100_bC.field_71990_ca && p_74863_1_ != Block.field_71995_bx.field_71990_ca && p_74863_1_ != Block.field_72088_bQ.field_71990_ca) {
            if(p_74863_1_ == Block.field_72055_aF.field_71990_ca) {
               if(this.field_74885_f == 0) {
                  if(p_74863_2_ == 2) {
                     return 3;
                  }

                  if(p_74863_2_ == 3) {
                     return 2;
                  }
               } else if(this.field_74885_f == 1) {
                  if(p_74863_2_ == 2) {
                     return 4;
                  }

                  if(p_74863_2_ == 3) {
                     return 5;
                  }

                  if(p_74863_2_ == 4) {
                     return 2;
                  }

                  if(p_74863_2_ == 5) {
                     return 3;
                  }
               } else if(this.field_74885_f == 3) {
                  if(p_74863_2_ == 2) {
                     return 5;
                  }

                  if(p_74863_2_ == 3) {
                     return 4;
                  }

                  if(p_74863_2_ == 4) {
                     return 2;
                  }

                  if(p_74863_2_ == 5) {
                     return 3;
                  }
               }
            } else if(p_74863_1_ == Block.field_72034_aR.field_71990_ca) {
               if(this.field_74885_f == 0) {
                  if(p_74863_2_ == 3) {
                     return 4;
                  }

                  if(p_74863_2_ == 4) {
                     return 3;
                  }
               } else if(this.field_74885_f == 1) {
                  if(p_74863_2_ == 3) {
                     return 1;
                  }

                  if(p_74863_2_ == 4) {
                     return 2;
                  }

                  if(p_74863_2_ == 2) {
                     return 3;
                  }

                  if(p_74863_2_ == 1) {
                     return 4;
                  }
               } else if(this.field_74885_f == 3) {
                  if(p_74863_2_ == 3) {
                     return 2;
                  }

                  if(p_74863_2_ == 4) {
                     return 1;
                  }

                  if(p_74863_2_ == 2) {
                     return 3;
                  }

                  if(p_74863_2_ == 1) {
                     return 4;
                  }
               }
            } else if(p_74863_1_ != Block.field_72064_bT.field_71990_ca && (Block.field_71973_m[p_74863_1_] == null || !(Block.field_71973_m[p_74863_1_] instanceof BlockDirectional))) {
               if(p_74863_1_ == Block.field_71963_Z.field_71990_ca || p_74863_1_ == Block.field_71956_V.field_71990_ca || p_74863_1_ == Block.field_72043_aJ.field_71990_ca || p_74863_1_ == Block.field_71958_P.field_71990_ca) {
                  if(this.field_74885_f == 0) {
                     if(p_74863_2_ == 2 || p_74863_2_ == 3) {
                        return Facing.field_71588_a[p_74863_2_];
                     }
                  } else if(this.field_74885_f == 1) {
                     if(p_74863_2_ == 2) {
                        return 4;
                     }

                     if(p_74863_2_ == 3) {
                        return 5;
                     }

                     if(p_74863_2_ == 4) {
                        return 2;
                     }

                     if(p_74863_2_ == 5) {
                        return 3;
                     }
                  } else if(this.field_74885_f == 3) {
                     if(p_74863_2_ == 2) {
                        return 5;
                     }

                     if(p_74863_2_ == 3) {
                        return 4;
                     }

                     if(p_74863_2_ == 4) {
                        return 2;
                     }

                     if(p_74863_2_ == 5) {
                        return 3;
                     }
                  }
               }
            } else if(this.field_74885_f == 0) {
               if(p_74863_2_ == 0 || p_74863_2_ == 2) {
                  return Direction.field_71580_e[p_74863_2_];
               }
            } else if(this.field_74885_f == 1) {
               if(p_74863_2_ == 2) {
                  return 1;
               }

               if(p_74863_2_ == 0) {
                  return 3;
               }

               if(p_74863_2_ == 1) {
                  return 2;
               }

               if(p_74863_2_ == 3) {
                  return 0;
               }
            } else if(this.field_74885_f == 3) {
               if(p_74863_2_ == 2) {
                  return 3;
               }

               if(p_74863_2_ == 0) {
                  return 1;
               }

               if(p_74863_2_ == 1) {
                  return 2;
               }

               if(p_74863_2_ == 3) {
                  return 0;
               }
            }
         } else if(this.field_74885_f == 0) {
            if(p_74863_2_ == 2) {
               return 3;
            }

            if(p_74863_2_ == 3) {
               return 2;
            }
         } else if(this.field_74885_f == 1) {
            if(p_74863_2_ == 0) {
               return 2;
            }

            if(p_74863_2_ == 1) {
               return 3;
            }

            if(p_74863_2_ == 2) {
               return 0;
            }

            if(p_74863_2_ == 3) {
               return 1;
            }
         } else if(this.field_74885_f == 3) {
            if(p_74863_2_ == 0) {
               return 2;
            }

            if(p_74863_2_ == 1) {
               return 3;
            }

            if(p_74863_2_ == 2) {
               return 1;
            }

            if(p_74863_2_ == 3) {
               return 0;
            }
         }
      } else if(this.field_74885_f == 0) {
         if(p_74863_2_ == 0) {
            return 2;
         }

         if(p_74863_2_ == 2) {
            return 0;
         }
      } else {
         if(this.field_74885_f == 1) {
            return p_74863_2_ + 1 & 3;
         }

         if(this.field_74885_f == 3) {
            return p_74863_2_ + 3 & 3;
         }
      }

      return p_74863_2_;
   }

   protected void func_74864_a(World p_74864_1_, int p_74864_2_, int p_74864_3_, int p_74864_4_, int p_74864_5_, int p_74864_6_, StructureBoundingBox p_74864_7_) {
      int var8 = this.func_74865_a(p_74864_4_, p_74864_6_);
      int var9 = this.func_74862_a(p_74864_5_);
      int var10 = this.func_74873_b(p_74864_4_, p_74864_6_);
      if(p_74864_7_.func_78890_b(var8, var9, var10)) {
         p_74864_1_.func_72832_d(var8, var9, var10, p_74864_2_, p_74864_3_, 2);
      }
   }

   protected int func_74866_a(World p_74866_1_, int p_74866_2_, int p_74866_3_, int p_74866_4_, StructureBoundingBox p_74866_5_) {
      int var6 = this.func_74865_a(p_74866_2_, p_74866_4_);
      int var7 = this.func_74862_a(p_74866_3_);
      int var8 = this.func_74873_b(p_74866_2_, p_74866_4_);
      return !p_74866_5_.func_78890_b(var6, var7, var8)?0:p_74866_1_.func_72798_a(var6, var7, var8);
   }

   protected void func_74878_a(World p_74878_1_, StructureBoundingBox p_74878_2_, int p_74878_3_, int p_74878_4_, int p_74878_5_, int p_74878_6_, int p_74878_7_, int p_74878_8_) {
      for(int var9 = p_74878_4_; var9 <= p_74878_7_; ++var9) {
         for(int var10 = p_74878_3_; var10 <= p_74878_6_; ++var10) {
            for(int var11 = p_74878_5_; var11 <= p_74878_8_; ++var11) {
               this.func_74864_a(p_74878_1_, 0, 0, var10, var9, var11, p_74878_2_);
            }
         }
      }

   }

   protected void func_74884_a(World p_74884_1_, StructureBoundingBox p_74884_2_, int p_74884_3_, int p_74884_4_, int p_74884_5_, int p_74884_6_, int p_74884_7_, int p_74884_8_, int p_74884_9_, int p_74884_10_, boolean p_74884_11_) {
      for(int var12 = p_74884_4_; var12 <= p_74884_7_; ++var12) {
         for(int var13 = p_74884_3_; var13 <= p_74884_6_; ++var13) {
            for(int var14 = p_74884_5_; var14 <= p_74884_8_; ++var14) {
               if(!p_74884_11_ || this.func_74866_a(p_74884_1_, var13, var12, var14, p_74884_2_) != 0) {
                  if(var12 != p_74884_4_ && var12 != p_74884_7_ && var13 != p_74884_3_ && var13 != p_74884_6_ && var14 != p_74884_5_ && var14 != p_74884_8_) {
                     this.func_74864_a(p_74884_1_, p_74884_10_, 0, var13, var12, var14, p_74884_2_);
                  } else {
                     this.func_74864_a(p_74884_1_, p_74884_9_, 0, var13, var12, var14, p_74884_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74872_a(World p_74872_1_, StructureBoundingBox p_74872_2_, int p_74872_3_, int p_74872_4_, int p_74872_5_, int p_74872_6_, int p_74872_7_, int p_74872_8_, int p_74872_9_, int p_74872_10_, int p_74872_11_, int p_74872_12_, boolean p_74872_13_) {
      for(int var14 = p_74872_4_; var14 <= p_74872_7_; ++var14) {
         for(int var15 = p_74872_3_; var15 <= p_74872_6_; ++var15) {
            for(int var16 = p_74872_5_; var16 <= p_74872_8_; ++var16) {
               if(!p_74872_13_ || this.func_74866_a(p_74872_1_, var15, var14, var16, p_74872_2_) != 0) {
                  if(var14 != p_74872_4_ && var14 != p_74872_7_ && var15 != p_74872_3_ && var15 != p_74872_6_ && var16 != p_74872_5_ && var16 != p_74872_8_) {
                     this.func_74864_a(p_74872_1_, p_74872_11_, p_74872_12_, var15, var14, var16, p_74872_2_);
                  } else {
                     this.func_74864_a(p_74872_1_, p_74872_9_, p_74872_10_, var15, var14, var16, p_74872_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74882_a(World p_74882_1_, StructureBoundingBox p_74882_2_, int p_74882_3_, int p_74882_4_, int p_74882_5_, int p_74882_6_, int p_74882_7_, int p_74882_8_, boolean p_74882_9_, Random p_74882_10_, StructurePieceBlockSelector p_74882_11_) {
      for(int var12 = p_74882_4_; var12 <= p_74882_7_; ++var12) {
         for(int var13 = p_74882_3_; var13 <= p_74882_6_; ++var13) {
            for(int var14 = p_74882_5_; var14 <= p_74882_8_; ++var14) {
               if(!p_74882_9_ || this.func_74866_a(p_74882_1_, var13, var12, var14, p_74882_2_) != 0) {
                  p_74882_11_.func_75062_a(p_74882_10_, var13, var12, var14, var12 == p_74882_4_ || var12 == p_74882_7_ || var13 == p_74882_3_ || var13 == p_74882_6_ || var14 == p_74882_5_ || var14 == p_74882_8_);
                  this.func_74864_a(p_74882_1_, p_74882_11_.func_75063_a(), p_74882_11_.func_75064_b(), var13, var12, var14, p_74882_2_);
               }
            }
         }
      }

   }

   protected void func_74880_a(World p_74880_1_, StructureBoundingBox p_74880_2_, Random p_74880_3_, float p_74880_4_, int p_74880_5_, int p_74880_6_, int p_74880_7_, int p_74880_8_, int p_74880_9_, int p_74880_10_, int p_74880_11_, int p_74880_12_, boolean p_74880_13_) {
      for(int var14 = p_74880_6_; var14 <= p_74880_9_; ++var14) {
         for(int var15 = p_74880_5_; var15 <= p_74880_8_; ++var15) {
            for(int var16 = p_74880_7_; var16 <= p_74880_10_; ++var16) {
               if(p_74880_3_.nextFloat() <= p_74880_4_ && (!p_74880_13_ || this.func_74866_a(p_74880_1_, var15, var14, var16, p_74880_2_) != 0)) {
                  if(var14 != p_74880_6_ && var14 != p_74880_9_ && var15 != p_74880_5_ && var15 != p_74880_8_ && var16 != p_74880_7_ && var16 != p_74880_10_) {
                     this.func_74864_a(p_74880_1_, p_74880_12_, 0, var15, var14, var16, p_74880_2_);
                  } else {
                     this.func_74864_a(p_74880_1_, p_74880_11_, 0, var15, var14, var16, p_74880_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74876_a(World p_74876_1_, StructureBoundingBox p_74876_2_, Random p_74876_3_, float p_74876_4_, int p_74876_5_, int p_74876_6_, int p_74876_7_, int p_74876_8_, int p_74876_9_) {
      if(p_74876_3_.nextFloat() < p_74876_4_) {
         this.func_74864_a(p_74876_1_, p_74876_8_, p_74876_9_, p_74876_5_, p_74876_6_, p_74876_7_, p_74876_2_);
      }

   }

   protected void func_74867_a(World p_74867_1_, StructureBoundingBox p_74867_2_, int p_74867_3_, int p_74867_4_, int p_74867_5_, int p_74867_6_, int p_74867_7_, int p_74867_8_, int p_74867_9_, boolean p_74867_10_) {
      float var11 = (float)(p_74867_6_ - p_74867_3_ + 1);
      float var12 = (float)(p_74867_7_ - p_74867_4_ + 1);
      float var13 = (float)(p_74867_8_ - p_74867_5_ + 1);
      float var14 = (float)p_74867_3_ + var11 / 2.0F;
      float var15 = (float)p_74867_5_ + var13 / 2.0F;

      for(int var16 = p_74867_4_; var16 <= p_74867_7_; ++var16) {
         float var17 = (float)(var16 - p_74867_4_) / var12;

         for(int var18 = p_74867_3_; var18 <= p_74867_6_; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = p_74867_5_; var20 <= p_74867_8_; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if(!p_74867_10_ || this.func_74866_a(p_74867_1_, var18, var16, var20, p_74867_2_) != 0) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if(var22 <= 1.05F) {
                     this.func_74864_a(p_74867_1_, p_74867_9_, 0, var18, var16, var20, p_74867_2_);
                  }
               }
            }
         }
      }

   }

   protected void func_74871_b(World p_74871_1_, int p_74871_2_, int p_74871_3_, int p_74871_4_, StructureBoundingBox p_74871_5_) {
      int var6 = this.func_74865_a(p_74871_2_, p_74871_4_);
      int var7 = this.func_74862_a(p_74871_3_);
      int var8 = this.func_74873_b(p_74871_2_, p_74871_4_);
      if(p_74871_5_.func_78890_b(var6, var7, var8)) {
         while(!p_74871_1_.func_72799_c(var6, var7, var8) && var7 < 255) {
            p_74871_1_.func_72832_d(var6, var7, var8, 0, 0, 2);
            ++var7;
         }

      }
   }

   protected void func_74870_b(World p_74870_1_, int p_74870_2_, int p_74870_3_, int p_74870_4_, int p_74870_5_, int p_74870_6_, StructureBoundingBox p_74870_7_) {
      int var8 = this.func_74865_a(p_74870_4_, p_74870_6_);
      int var9 = this.func_74862_a(p_74870_5_);
      int var10 = this.func_74873_b(p_74870_4_, p_74870_6_);
      if(p_74870_7_.func_78890_b(var8, var9, var10)) {
         while((p_74870_1_.func_72799_c(var8, var9, var10) || p_74870_1_.func_72803_f(var8, var9, var10).func_76224_d()) && var9 > 1) {
            p_74870_1_.func_72832_d(var8, var9, var10, p_74870_2_, p_74870_3_, 2);
            --var9;
         }

      }
   }

   protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_) {
      int var9 = this.func_74865_a(p_74879_4_, p_74879_6_);
      int var10 = this.func_74862_a(p_74879_5_);
      int var11 = this.func_74873_b(p_74879_4_, p_74879_6_);
      if(p_74879_2_.func_78890_b(var9, var10, var11) && p_74879_1_.func_72798_a(var9, var10, var11) != Block.field_72077_au.field_71990_ca) {
         p_74879_1_.func_72832_d(var9, var10, var11, Block.field_72077_au.field_71990_ca, 0, 2);
         TileEntityChest var12 = (TileEntityChest)p_74879_1_.func_72796_p(var9, var10, var11);
         if(var12 != null) {
            WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, var12, p_74879_8_);
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean func_74869_a(World p_74869_1_, StructureBoundingBox p_74869_2_, Random p_74869_3_, int p_74869_4_, int p_74869_5_, int p_74869_6_, int p_74869_7_, WeightedRandomChestContent[] p_74869_8_, int p_74869_9_) {
      int var10 = this.func_74865_a(p_74869_4_, p_74869_6_);
      int var11 = this.func_74862_a(p_74869_5_);
      int var12 = this.func_74873_b(p_74869_4_, p_74869_6_);
      if(p_74869_2_.func_78890_b(var10, var11, var12) && p_74869_1_.func_72798_a(var10, var11, var12) != Block.field_71958_P.field_71990_ca) {
         p_74869_1_.func_72832_d(var10, var11, var12, Block.field_71958_P.field_71990_ca, this.func_74863_c(Block.field_71958_P.field_71990_ca, p_74869_7_), 2);
         TileEntityDispenser var13 = (TileEntityDispenser)p_74869_1_.func_72796_p(var10, var11, var12);
         if(var13 != null) {
            WeightedRandomChestContent.func_76294_a(p_74869_3_, p_74869_8_, var13, p_74869_9_);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void func_74881_a(World p_74881_1_, StructureBoundingBox p_74881_2_, Random p_74881_3_, int p_74881_4_, int p_74881_5_, int p_74881_6_, int p_74881_7_) {
      int var8 = this.func_74865_a(p_74881_4_, p_74881_6_);
      int var9 = this.func_74862_a(p_74881_5_);
      int var10 = this.func_74873_b(p_74881_4_, p_74881_6_);
      if(p_74881_2_.func_78890_b(var8, var9, var10)) {
         ItemDoor.func_77869_a(p_74881_1_, var8, var9, var10, p_74881_7_, Block.field_72054_aE);
      }

   }
}
