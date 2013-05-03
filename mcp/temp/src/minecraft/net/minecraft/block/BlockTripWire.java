package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTripWire extends Block {

   public BlockTripWire(int p_i4018_1_) {
      super(p_i4018_1_, Material.field_76265_p);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
      this.func_71907_b(true);
   }

   public int func_71859_p_(World p_71859_1_) {
      return 10;
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

   @SideOnly(Side.CLIENT)
   public int func_71856_s_() {
      return 1;
   }

   public int func_71857_b() {
      return 30;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77683_K.field_77779_bT;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
      boolean var7 = (var6 & 2) == 2;
      boolean var8 = !p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_);
      if(var7 != var8) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
      boolean var6 = (var5 & 4) == 4;
      boolean var7 = (var5 & 2) == 2;
      if(!var7) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
      } else if(!var6) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         this.func_71905_a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
      }

   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      int var5 = p_71861_1_.func_72797_t(p_71861_2_, p_71861_3_ - 1, p_71861_4_)?0:2;
      p_71861_1_.func_72921_c(p_71861_2_, p_71861_3_, p_71861_4_, var5, 3);
      this.func_72149_e(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, var5);
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      this.func_72149_e(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_6_ | 1);
   }

   public void func_71846_a(World p_71846_1_, int p_71846_2_, int p_71846_3_, int p_71846_4_, int p_71846_5_, EntityPlayer p_71846_6_) {
      if(!p_71846_1_.field_72995_K) {
         if(p_71846_6_.func_71045_bC() != null && p_71846_6_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT) {
            p_71846_1_.func_72921_c(p_71846_2_, p_71846_3_, p_71846_4_, p_71846_5_ | 8, 4);
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77683_K.field_77779_bT;
   }

   private void func_72149_e(World p_72149_1_, int p_72149_2_, int p_72149_3_, int p_72149_4_, int p_72149_5_) {
      int var6 = 0;

      while(var6 < 2) {
         int var7 = 1;

         while(true) {
            if(var7 < 42) {
               int var8 = p_72149_2_ + Direction.field_71583_a[var6] * var7;
               int var9 = p_72149_4_ + Direction.field_71581_b[var6] * var7;
               int var10 = p_72149_1_.func_72798_a(var8, p_72149_3_, var9);
               if(var10 == Block.field_72064_bT.field_71990_ca) {
                  int var11 = p_72149_1_.func_72805_g(var8, p_72149_3_, var9) & 3;
                  if(var11 == Direction.field_71580_e[var6]) {
                     Block.field_72064_bT.func_72143_a(p_72149_1_, var8, p_72149_3_, var9, var10, p_72149_1_.func_72805_g(var8, p_72149_3_, var9), true, var7, p_72149_5_);
                  }
               } else if(var10 == Block.field_72062_bU.field_71990_ca) {
                  ++var7;
                  continue;
               }
            }

            ++var6;
            break;
         }
      }

   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      if(!p_71869_1_.field_72995_K) {
         if((p_71869_1_.func_72805_g(p_71869_2_, p_71869_3_, p_71869_4_) & 1) != 1) {
            this.func_72147_l(p_71869_1_, p_71869_2_, p_71869_3_, p_71869_4_);
         }
      }
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         if((p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_) & 1) == 1) {
            this.func_72147_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
         }
      }
   }

   private void func_72147_l(World p_72147_1_, int p_72147_2_, int p_72147_3_, int p_72147_4_) {
      int var5 = p_72147_1_.func_72805_g(p_72147_2_, p_72147_3_, p_72147_4_);
      boolean var6 = (var5 & 1) == 1;
      boolean var7 = false;
      List var8 = p_72147_1_.func_72839_b((Entity)null, AxisAlignedBB.func_72332_a().func_72299_a((double)p_72147_2_ + this.field_72026_ch, (double)p_72147_3_ + this.field_72023_ci, (double)p_72147_4_ + this.field_72024_cj, (double)p_72147_2_ + this.field_72021_ck, (double)p_72147_3_ + this.field_72022_cl, (double)p_72147_4_ + this.field_72019_cm));
      if(!var8.isEmpty()) {
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            Entity var10 = (Entity)var9.next();
            if(!var10.func_82144_au()) {
               var7 = true;
               break;
            }
         }
      }

      if(var7 && !var6) {
         var5 |= 1;
      }

      if(!var7 && var6) {
         var5 &= -2;
      }

      if(var7 != var6) {
         p_72147_1_.func_72921_c(p_72147_2_, p_72147_3_, p_72147_4_, var5, 3);
         this.func_72149_e(p_72147_1_, p_72147_2_, p_72147_3_, p_72147_4_, var5);
      }

      if(var7) {
         p_72147_1_.func_72836_a(p_72147_2_, p_72147_3_, p_72147_4_, this.field_71990_ca, this.func_71859_p_(p_72147_1_));
      }

   }

   @SideOnly(Side.CLIENT)
   public static boolean func_72148_a(IBlockAccess p_72148_0_, int p_72148_1_, int p_72148_2_, int p_72148_3_, int p_72148_4_, int p_72148_5_) {
      int var6 = p_72148_1_ + Direction.field_71583_a[p_72148_5_];
      int var8 = p_72148_3_ + Direction.field_71581_b[p_72148_5_];
      int var9 = p_72148_0_.func_72798_a(var6, p_72148_2_, var8);
      boolean var10 = (p_72148_4_ & 2) == 2;
      int var11;
      if(var9 == Block.field_72064_bT.field_71990_ca) {
         var11 = p_72148_0_.func_72805_g(var6, p_72148_2_, var8);
         int var13 = var11 & 3;
         return var13 == Direction.field_71580_e[p_72148_5_];
      } else if(var9 == Block.field_72062_bU.field_71990_ca) {
         var11 = p_72148_0_.func_72805_g(var6, p_72148_2_, var8);
         boolean var12 = (var11 & 2) == 2;
         return var10 == var12;
      } else {
         return false;
      }
   }
}
