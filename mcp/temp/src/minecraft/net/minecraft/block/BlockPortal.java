package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPortal extends BlockBreakable {

   public BlockPortal(int p_i9077_1_) {
      super(p_i9077_1_, "portal", Material.field_76237_B, false);
      this.func_71907_b(true);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
      if(p_71847_1_.field_73011_w.func_76569_d() && p_71847_5_.nextInt(2000) < p_71847_1_.field_73013_u) {
         int var6;
         for(var6 = p_71847_3_; !p_71847_1_.func_72797_t(p_71847_2_, var6, p_71847_4_) && var6 > 0; --var6) {
            ;
         }

         if(var6 > 0 && !p_71847_1_.func_72809_s(p_71847_2_, var6 + 1, p_71847_4_)) {
            Entity var7 = ItemMonsterPlacer.func_77840_a(p_71847_1_, 57, (double)p_71847_2_ + 0.5D, (double)var6 + 1.1D, (double)p_71847_4_ + 0.5D);
            if(var7 != null) {
               var7.field_71088_bW = var7.func_82147_ab();
            }
         }
      }

   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      float var5;
      float var6;
      if(p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_) != this.field_71990_ca && p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_) != this.field_71990_ca) {
         var5 = 0.125F;
         var6 = 0.5F;
         this.func_71905_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
      } else {
         var5 = 0.5F;
         var6 = 0.125F;
         this.func_71905_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
      }

   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_72246_i_(World p_72246_1_, int p_72246_2_, int p_72246_3_, int p_72246_4_) {
      byte var5 = 0;
      byte var6 = 0;
      if(p_72246_1_.func_72798_a(p_72246_2_ - 1, p_72246_3_, p_72246_4_) == Block.field_72089_ap.field_71990_ca || p_72246_1_.func_72798_a(p_72246_2_ + 1, p_72246_3_, p_72246_4_) == Block.field_72089_ap.field_71990_ca) {
         var5 = 1;
      }

      if(p_72246_1_.func_72798_a(p_72246_2_, p_72246_3_, p_72246_4_ - 1) == Block.field_72089_ap.field_71990_ca || p_72246_1_.func_72798_a(p_72246_2_, p_72246_3_, p_72246_4_ + 1) == Block.field_72089_ap.field_71990_ca) {
         var6 = 1;
      }

      if(var5 == var6) {
         return false;
      } else {
         if(p_72246_1_.func_72798_a(p_72246_2_ - var5, p_72246_3_, p_72246_4_ - var6) == 0) {
            p_72246_2_ -= var5;
            p_72246_4_ -= var6;
         }

         int var7;
         int var8;
         for(var7 = -1; var7 <= 2; ++var7) {
            for(var8 = -1; var8 <= 3; ++var8) {
               boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
               if(var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                  int var10 = p_72246_1_.func_72798_a(p_72246_2_ + var5 * var7, p_72246_3_ + var8, p_72246_4_ + var6 * var7);
                  if(var9) {
                     if(var10 != Block.field_72089_ap.field_71990_ca) {
                        return false;
                     }
                  } else if(var10 != 0 && var10 != Block.field_72067_ar.field_71990_ca) {
                     return false;
                  }
               }
            }
         }

         for(var7 = 0; var7 < 2; ++var7) {
            for(var8 = 0; var8 < 3; ++var8) {
               p_72246_1_.func_72832_d(p_72246_2_ + var5 * var7, p_72246_3_ + var8, p_72246_4_ + var6 * var7, Block.field_72015_be.field_71990_ca, 0, 2);
            }
         }

         return true;
      }
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      byte var6 = 0;
      byte var7 = 1;
      if(p_71863_1_.func_72798_a(p_71863_2_ - 1, p_71863_3_, p_71863_4_) == this.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + 1, p_71863_3_, p_71863_4_) == this.field_71990_ca) {
         var6 = 1;
         var7 = 0;
      }

      int var8;
      for(var8 = p_71863_3_; p_71863_1_.func_72798_a(p_71863_2_, var8 - 1, p_71863_4_) == this.field_71990_ca; --var8) {
         ;
      }

      if(p_71863_1_.func_72798_a(p_71863_2_, var8 - 1, p_71863_4_) != Block.field_72089_ap.field_71990_ca) {
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      } else {
         int var9;
         for(var9 = 1; var9 < 4 && p_71863_1_.func_72798_a(p_71863_2_, var8 + var9, p_71863_4_) == this.field_71990_ca; ++var9) {
            ;
         }

         if(var9 == 3 && p_71863_1_.func_72798_a(p_71863_2_, var8 + var9, p_71863_4_) == Block.field_72089_ap.field_71990_ca) {
            boolean var10 = p_71863_1_.func_72798_a(p_71863_2_ - 1, p_71863_3_, p_71863_4_) == this.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + 1, p_71863_3_, p_71863_4_) == this.field_71990_ca;
            boolean var11 = p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_ - 1) == this.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_ + 1) == this.field_71990_ca;
            if(var10 && var11) {
               p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
            } else {
               if((p_71863_1_.func_72798_a(p_71863_2_ + var6, p_71863_3_, p_71863_4_ + var7) != Block.field_72089_ap.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ - var6, p_71863_3_, p_71863_4_ - var7) != this.field_71990_ca) && (p_71863_1_.func_72798_a(p_71863_2_ - var6, p_71863_3_, p_71863_4_ - var7) != Block.field_72089_ap.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + var6, p_71863_3_, p_71863_4_ + var7) != this.field_71990_ca)) {
                  p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
               }

            }
         } else {
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      if(p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_) == this.field_71990_ca) {
         return false;
      } else {
         boolean var6 = p_71877_1_.func_72798_a(p_71877_2_ - 1, p_71877_3_, p_71877_4_) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_ - 2, p_71877_3_, p_71877_4_) != this.field_71990_ca;
         boolean var7 = p_71877_1_.func_72798_a(p_71877_2_ + 1, p_71877_3_, p_71877_4_) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_ + 2, p_71877_3_, p_71877_4_) != this.field_71990_ca;
         boolean var8 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ - 1) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ - 2) != this.field_71990_ca;
         boolean var9 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ + 1) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ + 2) != this.field_71990_ca;
         boolean var10 = var6 || var7;
         boolean var11 = var8 || var9;
         return var10 && p_71877_5_ == 4?true:(var10 && p_71877_5_ == 5?true:(var11 && p_71877_5_ == 2?true:var11 && p_71877_5_ == 3));
      }
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      if(p_71869_5_.field_70154_o == null && p_71869_5_.field_70153_n == null) {
         p_71869_5_.func_70063_aa();
      }

   }

   @SideOnly(Side.CLIENT)
   public int func_71856_s_() {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      if(p_71862_5_.nextInt(100) == 0) {
         p_71862_1_.func_72980_b((double)p_71862_2_ + 0.5D, (double)p_71862_3_ + 0.5D, (double)p_71862_4_ + 0.5D, "portal.portal", 0.5F, p_71862_5_.nextFloat() * 0.4F + 0.8F, false);
      }

      for(int var6 = 0; var6 < 4; ++var6) {
         double var7 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
         double var9 = (double)((float)p_71862_3_ + p_71862_5_.nextFloat());
         double var11 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         int var19 = p_71862_5_.nextInt(2) * 2 - 1;
         var13 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
         var15 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
         var17 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
         if(p_71862_1_.func_72798_a(p_71862_2_ - 1, p_71862_3_, p_71862_4_) != this.field_71990_ca && p_71862_1_.func_72798_a(p_71862_2_ + 1, p_71862_3_, p_71862_4_) != this.field_71990_ca) {
            var7 = (double)p_71862_2_ + 0.5D + 0.25D * (double)var19;
            var13 = (double)(p_71862_5_.nextFloat() * 2.0F * (float)var19);
         } else {
            var11 = (double)p_71862_4_ + 0.5D + 0.25D * (double)var19;
            var17 = (double)(p_71862_5_.nextFloat() * 2.0F * (float)var19);
         }

         p_71862_1_.func_72869_a("portal", var7, var9, var11, var13, var15, var17);
      }

   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return 0;
   }
}
