package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLever extends Block {

   protected BlockLever(int p_i9069_1_) {
      super(p_i9069_1_, Material.field_76265_p);
      this.func_71849_a(CreativeTabs.field_78028_d);
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
      return 12;
   }

   public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_) {
      return p_71850_5_ == 0 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_ + 1, p_71850_4_)?true:(p_71850_5_ == 1 && p_71850_1_.func_72797_t(p_71850_2_, p_71850_3_ - 1, p_71850_4_)?true:(p_71850_5_ == 2 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ + 1)?true:(p_71850_5_ == 3 && p_71850_1_.func_72809_s(p_71850_2_, p_71850_3_, p_71850_4_ - 1)?true:(p_71850_5_ == 4 && p_71850_1_.func_72809_s(p_71850_2_ + 1, p_71850_3_, p_71850_4_)?true:p_71850_5_ == 5 && p_71850_1_.func_72809_s(p_71850_2_ - 1, p_71850_3_, p_71850_4_)))));
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1)?true:(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1)?true:(p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_)?true:p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_ + 1, p_71930_4_)))));
   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      int var11 = p_85104_9_ & 8;
      int var10 = p_85104_9_ & 7;
      byte var12 = -1;
      if(p_85104_5_ == 0 && p_85104_1_.func_72809_s(p_85104_2_, p_85104_3_ + 1, p_85104_4_)) {
         var12 = 0;
      }

      if(p_85104_5_ == 1 && p_85104_1_.func_72797_t(p_85104_2_, p_85104_3_ - 1, p_85104_4_)) {
         var12 = 5;
      }

      if(p_85104_5_ == 2 && p_85104_1_.func_72809_s(p_85104_2_, p_85104_3_, p_85104_4_ + 1)) {
         var12 = 4;
      }

      if(p_85104_5_ == 3 && p_85104_1_.func_72809_s(p_85104_2_, p_85104_3_, p_85104_4_ - 1)) {
         var12 = 3;
      }

      if(p_85104_5_ == 4 && p_85104_1_.func_72809_s(p_85104_2_ + 1, p_85104_3_, p_85104_4_)) {
         var12 = 2;
      }

      if(p_85104_5_ == 5 && p_85104_1_.func_72809_s(p_85104_2_ - 1, p_85104_3_, p_85104_4_)) {
         var12 = 1;
      }

      return var12 + var11;
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = p_71860_1_.func_72805_g(p_71860_2_, p_71860_3_, p_71860_4_);
      int var8 = var7 & 7;
      int var9 = var7 & 8;
      if(var8 == func_72196_d(1)) {
         if((MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 5 | var9, 2);
         } else {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 6 | var9, 2);
         }
      } else if(var8 == func_72196_d(0)) {
         if((MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 1) == 0) {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 7 | var9, 2);
         } else {
            p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 0 | var9, 2);
         }
      }

   }

   public static int func_72196_d(int p_72196_0_) {
      switch(p_72196_0_) {
      case 0:
         return 0;
      case 1:
         return 5;
      case 2:
         return 4;
      case 3:
         return 3;
      case 4:
         return 2;
      case 5:
         return 1;
      default:
         return -1;
      }
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(this.func_72195_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_) & 7;
         boolean var7 = false;
         if(!p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_) && var6 == 1) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_) && var6 == 2) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1) && var6 == 3) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1) && var6 == 4) {
            var7 = true;
         }

         if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_) && var6 == 5) {
            var7 = true;
         }

         if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_) && var6 == 6) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_ + 1, p_71863_4_) && var6 == 0) {
            var7 = true;
         }

         if(!p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_ + 1, p_71863_4_) && var6 == 7) {
            var7 = true;
         }

         if(var7) {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         }
      }

   }

   private boolean func_72195_l(World p_72195_1_, int p_72195_2_, int p_72195_3_, int p_72195_4_) {
      if(!this.func_71930_b(p_72195_1_, p_72195_2_, p_72195_3_, p_72195_4_)) {
         this.func_71897_c(p_72195_1_, p_72195_2_, p_72195_3_, p_72195_4_, p_72195_1_.func_72805_g(p_72195_2_, p_72195_3_, p_72195_4_), 0);
         p_72195_1_.func_94571_i(p_72195_2_, p_72195_3_, p_72195_4_);
         return false;
      } else {
         return true;
      }
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) & 7;
      float var6 = 0.1875F;
      if(var5 == 1) {
         this.func_71905_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 2) {
         this.func_71905_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 3) {
         this.func_71905_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == 4) {
         this.func_71905_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else if(var5 != 5 && var5 != 6) {
         if(var5 == 0 || var5 == 7) {
            var6 = 0.25F;
            this.func_71905_a(0.5F - var6, 0.4F, 0.5F - var6, 0.5F + var6, 1.0F, 0.5F + var6);
         }
      } else {
         var6 = 0.25F;
         this.func_71905_a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
         int var11 = var10 & 7;
         int var12 = 8 - (var10 & 8);
         p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var11 + var12, 3);
         p_71903_1_.func_72908_a((double)p_71903_2_ + 0.5D, (double)p_71903_3_ + 0.5D, (double)p_71903_4_ + 0.5D, "random.click", 0.3F, var12 > 0?0.6F:0.5F);
         p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_, this.field_71990_ca);
         if(var11 == 1) {
            p_71903_1_.func_72898_h(p_71903_2_ - 1, p_71903_3_, p_71903_4_, this.field_71990_ca);
         } else if(var11 == 2) {
            p_71903_1_.func_72898_h(p_71903_2_ + 1, p_71903_3_, p_71903_4_, this.field_71990_ca);
         } else if(var11 == 3) {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_ - 1, this.field_71990_ca);
         } else if(var11 == 4) {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_, p_71903_4_ + 1, this.field_71990_ca);
         } else if(var11 != 5 && var11 != 6) {
            if(var11 == 0 || var11 == 7) {
               p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_ + 1, p_71903_4_, this.field_71990_ca);
            }
         } else {
            p_71903_1_.func_72898_h(p_71903_2_, p_71903_3_ - 1, p_71903_4_, this.field_71990_ca);
         }

         return true;
      }
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      if((p_71852_6_ & 8) > 0) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_, this.field_71990_ca);
         int var7 = p_71852_6_ & 7;
         if(var7 == 1) {
            p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         } else if(var7 == 2) {
            p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         } else if(var7 == 3) {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         } else if(var7 == 4) {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
         } else if(var7 != 5 && var7 != 6) {
            if(var7 == 0 || var7 == 7) {
               p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, this.field_71990_ca);
            }
         } else {
            p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, this.field_71990_ca);
         }
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      return (p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_) & 8) > 0?15:0;
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      int var6 = p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_);
      if((var6 & 8) == 0) {
         return 0;
      } else {
         int var7 = var6 & 7;
         return var7 == 0 && p_71855_5_ == 0?15:(var7 == 7 && p_71855_5_ == 0?15:(var7 == 6 && p_71855_5_ == 1?15:(var7 == 5 && p_71855_5_ == 1?15:(var7 == 4 && p_71855_5_ == 2?15:(var7 == 3 && p_71855_5_ == 3?15:(var7 == 2 && p_71855_5_ == 4?15:(var7 == 1 && p_71855_5_ == 5?15:0)))))));
      }
   }

   public boolean func_71853_i() {
      return true;
   }
}
