package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWireSource extends Block {

   public BlockTripWireSource(int p_i4017_1_) {
      super(p_i4017_1_, Material.field_76265_p);
      this.func_71849_a(CreativeTabs.field_78028_d);
      this.func_71907_b(true);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 29;
   }

   public int func_71859_p_(World p_71859_1_) {
      return 10;
   }

   public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_) {
      return p_71850_5_ == 2 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ + 1)?true:(p_71850_5_ == 3 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ - 1)?true:(p_71850_5_ == 4 && p_71850_1_.func_72809_s(p_71850_2_ + 1, p_71850_3_, p_71850_4_)?true:p_71850_5_ == 5 && p_71850_1_.func_72809_s(p_71850_2_ - 1, p_71850_3_, p_71850_4_)));
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1)?true:p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1)));
   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      byte var10 = 0;
      if(p_85104_5_ == 2 && p_85104_1_.func_72887_b(p_85104_2_, p_85104_3_, p_85104_4_ + 1, true)) {
         var10 = 2;
      }

      if(p_85104_5_ == 3 && p_85104_1_.func_72887_b(p_85104_2_, p_85104_3_, p_85104_4_ - 1, true)) {
         var10 = 0;
      }

      if(p_85104_5_ == 4 && p_85104_1_.func_72887_b(p_85104_2_ + 1, p_85104_3_, p_85104_4_, true)) {
         var10 = 1;
      }

      if(p_85104_5_ == 5 && p_85104_1_.func_72887_b(p_85104_2_ - 1, p_85104_3_, p_85104_4_, true)) {
         var10 = 3;
      }

      return var10;
   }

   public void func_85105_g(World p_85105_1_, int p_85105_2_, int p_85105_3_, int p_85105_4_, int p_85105_5_) {
      this.func_72143_a(p_85105_1_, p_85105_2_, p_85105_3_, p_85105_4_, this.field_71990_ca, p_85105_5_, false, -1, 0);
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(p_71863_5_ != this.field_71990_ca) {
         if(this.func_72144_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
            int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
            int var7 = var6 & 3;
            boolean var8 = false;
            if(!p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_) && var7 == 3) {
               var8 = true;
            }

            if(!p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_) && var7 == 1) {
               var8 = true;
            }

            if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1) && var7 == 0) {
               var8 = true;
            }

            if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1) && var7 == 2) {
               var8 = true;
            }

            if(var8) {
               this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
               p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
            }
         }

      }
   }

   public void func_72143_a(World p_72143_1_, int p_72143_2_, int p_72143_3_, int p_72143_4_, int p_72143_5_, int p_72143_6_, boolean p_72143_7_, int p_72143_8_, int p_72143_9_) {
      int var10 = p_72143_6_ & 3;
      boolean var11 = (p_72143_6_ & 4) == 4;
      boolean var12 = (p_72143_6_ & 8) == 8;
      boolean var13 = p_72143_5_ == Block.field_72064_bT.field_71990_ca;
      boolean var14 = false;
      boolean var15 = !p_72143_1_.func_72797_t(p_72143_2_, p_72143_3_ - 1, p_72143_4_);
      int var16 = Direction.field_71583_a[var10];
      int var17 = Direction.field_71581_b[var10];
      int var18 = 0;
      int[] var19 = new int[42];

      int var21;
      int var20;
      int var23;
      int var22;
      int var24;
      for(var20 = 1; var20 < 42; ++var20) {
         var21 = p_72143_2_ + var16 * var20;
         var22 = p_72143_4_ + var17 * var20;
         var23 = p_72143_1_.func_72798_a(var21, p_72143_3_, var22);
         if(var23 == Block.field_72064_bT.field_71990_ca) {
            var24 = p_72143_1_.func_72805_g(var21, p_72143_3_, var22);
            if((var24 & 3) == Direction.field_71580_e[var10]) {
               var18 = var20;
            }
            break;
         }

         if(var23 != Block.field_72062_bU.field_71990_ca && var20 != p_72143_8_) {
            var19[var20] = -1;
            var13 = false;
         } else {
            var24 = var20 == p_72143_8_?p_72143_9_:p_72143_1_.func_72805_g(var21, p_72143_3_, var22);
            boolean var25 = (var24 & 8) != 8;
            boolean var26 = (var24 & 1) == 1;
            boolean var27 = (var24 & 2) == 2;
            var13 &= var27 == var15;
            var14 |= var25 && var26;
            var19[var20] = var24;
            if(var20 == p_72143_8_) {
               p_72143_1_.func_72836_a(p_72143_2_, p_72143_3_, p_72143_4_, p_72143_5_, this.func_71859_p_(p_72143_1_));
               var13 &= var25;
            }
         }
      }

      var13 &= var18 > 1;
      var14 &= var13;
      var20 = (var13?4:0) | (var14?8:0);
      p_72143_6_ = var10 | var20;
      if(var18 > 0) {
         var21 = p_72143_2_ + var16 * var18;
         var22 = p_72143_4_ + var17 * var18;
         var23 = Direction.field_71580_e[var10];
         p_72143_1_.func_72921_c(var21, p_72143_3_, var22, var23 | var20, 3);
         this.func_72146_e(p_72143_1_, var21, p_72143_3_, var22, var23);
         this.func_72145_a(p_72143_1_, var21, p_72143_3_, var22, var13, var14, var11, var12);
      }

      this.func_72145_a(p_72143_1_, p_72143_2_, p_72143_3_, p_72143_4_, var13, var14, var11, var12);
      if(p_72143_5_ > 0) {
         p_72143_1_.func_72921_c(p_72143_2_, p_72143_3_, p_72143_4_, p_72143_6_, 3);
         if(p_72143_7_) {
            this.func_72146_e(p_72143_1_, p_72143_2_, p_72143_3_, p_72143_4_, var10);
         }
      }

      if(var11 != var13) {
         for(var21 = 1; var21 < var18; ++var21) {
            var22 = p_72143_2_ + var16 * var21;
            var23 = p_72143_4_ + var17 * var21;
            var24 = var19[var21];
            if(var24 >= 0) {
               if(var13) {
                  var24 |= 4;
               } else {
                  var24 &= -5;
               }

               p_72143_1_.func_72921_c(var22, p_72143_3_, var23, var24, 3);
            }
         }
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      this.func_72143_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, this.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), true, -1, 0);
   }

   private void func_72145_a(World p_72145_1_, int p_72145_2_, int p_72145_3_, int p_72145_4_, boolean p_72145_5_, boolean p_72145_6_, boolean p_72145_7_, boolean p_72145_8_) {
      if(p_72145_6_ && !p_72145_8_) {
         p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.1D, (double)p_72145_4_ + 0.5D, "random.click", 0.4F, 0.6F);
      } else if(!p_72145_6_ && p_72145_8_) {
         p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.1D, (double)p_72145_4_ + 0.5D, "random.click", 0.4F, 0.5F);
      } else if(p_72145_5_ && !p_72145_7_) {
         p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.1D, (double)p_72145_4_ + 0.5D, "random.click", 0.4F, 0.7F);
      } else if(!p_72145_5_ && p_72145_7_) {
         p_72145_1_.func_72908_a((double)p_72145_2_ + 0.5D, (double)p_72145_3_ + 0.1D, (double)p_72145_4_ + 0.5D, "random.bowhit", 0.4F, 1.2F / (p_72145_1_.field_73012_v.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void func_72146_e(World p_72146_1_, int p_72146_2_, int p_72146_3_, int p_72146_4_, int p_72146_5_) {
      p_72146_1_.func_72898_h(p_72146_2_, p_72146_3_, p_72146_4_, this.field_71990_ca);
      if(p_72146_5_ == 3) {
         p_72146_1_.func_72898_h(p_72146_2_ - 1, p_72146_3_, p_72146_4_, this.field_71990_ca);
      } else if(p_72146_5_ == 1) {
         p_72146_1_.func_72898_h(p_72146_2_ + 1, p_72146_3_, p_72146_4_, this.field_71990_ca);
      } else if(p_72146_5_ == 0) {
         p_72146_1_.func_72898_h(p_72146_2_, p_72146_3_, p_72146_4_ - 1, this.field_71990_ca);
      } else if(p_72146_5_ == 2) {
         p_72146_1_.func_72898_h(p_72146_2_, p_72146_3_, p_72146_4_ + 1, this.field_71990_ca);
      }

   }

   private boolean func_72144_l(World p_72144_1_, int p_72144_2_, int p_72144_3_, int p_72144_4_) {
      if(!this.func_71930_b(p_72144_1_, p_72144_2_, p_72144_3_, p_72144_4_)) {
         this.func_71897_c(p_72144_1_, p_72144_2_, p_72144_3_, p_72144_4_, p_72144_1_.func_72805_g(p_72144_2_, p_72144_3_, p_72144_4_), 0);
         p_72144_1_.func_94571_i(p_72144_2_, p_72144_3_, p_72144_4_);
         return false;
      } else {
         return true;
      }
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) & 3;
      float var6 = 0.1875F;
      if(var5 == 3) {
         this.func_71905_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 1) {
         this.func_71905_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 0) {
         this.func_71905_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == 2) {
         this.func_71905_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      }

   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      boolean var7 = (p_71852_6_ & 4) == 4;
      boolean var8 = (p_71852_6_ & 8) == 8;
      if(var7 || var8) {
         this.func_72143_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, 0, p_71852_6_, false, -1, 0);
      }

      if(var8) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, this.field_71990_ca);
         int var9 = p_71852_6_ & 3;
         if(var9 == 3) {
            p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         } else if(var9 == 1) {
            p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         } else if(var9 == 0) {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         } else if(var9 == 2) {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
         }
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      return (p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) & 8) == 8?15:0;
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      int var6 = p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_);
      if((var6 & 8) != 8) {
         return 0;
      } else {
         int var7 = var6 & 3;
         return var7 == 2 && p_71855_5_ == 2?15:(var7 == 0 && p_71855_5_ == 3?15:(var7 == 1 && p_71855_5_ == 4?15:(var7 == 3 && p_71855_5_ == 5?15:0)));
      }
   }

   public boolean func_71853_i() {
      return true;
   }
}
