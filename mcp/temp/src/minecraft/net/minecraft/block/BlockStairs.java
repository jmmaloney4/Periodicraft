package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStairs extends Block {

   private static final int[][] field_72159_a = new int[][]{{2, 6}, {3, 7}, {2, 3}, {6, 7}, {0, 4}, {1, 5}, {0, 1}, {4, 5}};
   private final Block field_72157_b;
   private final int field_72158_c;
   private boolean field_72156_cr = false;
   private int field_72160_cs = 0;


   protected BlockStairs(int p_i3997_1_, Block p_i3997_2_, int p_i3997_3_) {
      super(p_i3997_1_, p_i3997_2_.field_72018_cp);
      this.field_72157_b = p_i3997_2_;
      this.field_72158_c = p_i3997_3_;
      this.func_71848_c(p_i3997_2_.field_71989_cb);
      this.func_71894_b(p_i3997_2_.field_72029_cc / 3.0F);
      this.func_71884_a(p_i3997_2_.field_72020_cn);
      this.func_71868_h(255);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      if(this.field_72156_cr) {
         this.func_71905_a(0.5F * (float)(this.field_72160_cs % 2), 0.5F * (float)(this.field_72160_cs / 2 % 2), 0.5F * (float)(this.field_72160_cs / 4 % 2), 0.5F + 0.5F * (float)(this.field_72160_cs % 2), 0.5F + 0.5F * (float)(this.field_72160_cs / 2 % 2), 0.5F + 0.5F * (float)(this.field_72160_cs / 4 % 2));
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 10;
   }

   public void func_82541_d(IBlockAccess p_82541_1_, int p_82541_2_, int p_82541_3_, int p_82541_4_) {
      int var5 = p_82541_1_.func_72805_g(p_82541_2_, p_82541_3_, p_82541_4_);
      if((var5 & 4) != 0) {
         this.func_71905_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public static boolean func_82543_e(int p_82543_0_) {
      return p_82543_0_ > 0 && Block.field_71973_m[p_82543_0_] instanceof BlockStairs;
   }

   private boolean func_82540_f(IBlockAccess p_82540_1_, int p_82540_2_, int p_82540_3_, int p_82540_4_, int p_82540_5_) {
      int var6 = p_82540_1_.func_72798_a(p_82540_2_, p_82540_3_, p_82540_4_);
      return func_82543_e(var6) && p_82540_1_.func_72805_g(p_82540_2_, p_82540_3_, p_82540_4_) == p_82540_5_;
   }

   public boolean func_82542_g(IBlockAccess p_82542_1_, int p_82542_2_, int p_82542_3_, int p_82542_4_) {
      int var5 = p_82542_1_.func_72805_g(p_82542_2_, p_82542_3_, p_82542_4_);
      int var6 = var5 & 3;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if((var5 & 4) != 0) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 1.0F;
      float var11 = 0.0F;
      float var12 = 0.5F;
      boolean var13 = true;
      int var14;
      int var15;
      int var16;
      if(var6 == 0) {
         var9 = 0.5F;
         var12 = 1.0F;
         var14 = p_82542_1_.func_72798_a(p_82542_2_ + 1, p_82542_3_, p_82542_4_);
         var15 = p_82542_1_.func_72805_g(p_82542_2_ + 1, p_82542_3_, p_82542_4_);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var16 = var15 & 3;
            if(var16 == 3 && !this.func_82540_f(p_82542_1_, p_82542_2_, p_82542_3_, p_82542_4_ + 1, var5)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == 2 && !this.func_82540_f(p_82542_1_, p_82542_2_, p_82542_3_, p_82542_4_ - 1, var5)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var6 == 1) {
         var10 = 0.5F;
         var12 = 1.0F;
         var14 = p_82542_1_.func_72798_a(p_82542_2_ - 1, p_82542_3_, p_82542_4_);
         var15 = p_82542_1_.func_72805_g(p_82542_2_ - 1, p_82542_3_, p_82542_4_);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var16 = var15 & 3;
            if(var16 == 3 && !this.func_82540_f(p_82542_1_, p_82542_2_, p_82542_3_, p_82542_4_ + 1, var5)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == 2 && !this.func_82540_f(p_82542_1_, p_82542_2_, p_82542_3_, p_82542_4_ - 1, var5)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var6 == 2) {
         var11 = 0.5F;
         var12 = 1.0F;
         var14 = p_82542_1_.func_72798_a(p_82542_2_, p_82542_3_, p_82542_4_ + 1);
         var15 = p_82542_1_.func_72805_g(p_82542_2_, p_82542_3_, p_82542_4_ + 1);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var16 = var15 & 3;
            if(var16 == 1 && !this.func_82540_f(p_82542_1_, p_82542_2_ + 1, p_82542_3_, p_82542_4_, var5)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == 0 && !this.func_82540_f(p_82542_1_, p_82542_2_ - 1, p_82542_3_, p_82542_4_, var5)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      } else if(var6 == 3) {
         var14 = p_82542_1_.func_72798_a(p_82542_2_, p_82542_3_, p_82542_4_ - 1);
         var15 = p_82542_1_.func_72805_g(p_82542_2_, p_82542_3_, p_82542_4_ - 1);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var16 = var15 & 3;
            if(var16 == 1 && !this.func_82540_f(p_82542_1_, p_82542_2_ + 1, p_82542_3_, p_82542_4_, var5)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == 0 && !this.func_82540_f(p_82542_1_, p_82542_2_ - 1, p_82542_3_, p_82542_4_, var5)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      }

      this.func_71905_a(var9, var7, var11, var10, var8, var12);
      return var13;
   }

   public boolean func_82544_h(IBlockAccess p_82544_1_, int p_82544_2_, int p_82544_3_, int p_82544_4_) {
      int var5 = p_82544_1_.func_72805_g(p_82544_2_, p_82544_3_, p_82544_4_);
      int var6 = var5 & 3;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if((var5 & 4) != 0) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      boolean var13 = false;
      int var14;
      int var15;
      int var16;
      if(var6 == 0) {
         var14 = p_82544_1_.func_72798_a(p_82544_2_ - 1, p_82544_3_, p_82544_4_);
         var15 = p_82544_1_.func_72805_g(p_82544_2_ - 1, p_82544_3_, p_82544_4_);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var16 = var15 & 3;
            if(var16 == 3 && !this.func_82540_f(p_82544_1_, p_82544_2_, p_82544_3_, p_82544_4_ - 1, var5)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == 2 && !this.func_82540_f(p_82544_1_, p_82544_2_, p_82544_3_, p_82544_4_ + 1, var5)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var6 == 1) {
         var14 = p_82544_1_.func_72798_a(p_82544_2_ + 1, p_82544_3_, p_82544_4_);
         var15 = p_82544_1_.func_72805_g(p_82544_2_ + 1, p_82544_3_, p_82544_4_);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var9 = 0.5F;
            var10 = 1.0F;
            var16 = var15 & 3;
            if(var16 == 3 && !this.func_82540_f(p_82544_1_, p_82544_2_, p_82544_3_, p_82544_4_ - 1, var5)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == 2 && !this.func_82540_f(p_82544_1_, p_82544_2_, p_82544_3_, p_82544_4_ + 1, var5)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var6 == 2) {
         var14 = p_82544_1_.func_72798_a(p_82544_2_, p_82544_3_, p_82544_4_ - 1);
         var15 = p_82544_1_.func_72805_g(p_82544_2_, p_82544_3_, p_82544_4_ - 1);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var11 = 0.0F;
            var12 = 0.5F;
            var16 = var15 & 3;
            if(var16 == 1 && !this.func_82540_f(p_82544_1_, p_82544_2_ - 1, p_82544_3_, p_82544_4_, var5)) {
               var13 = true;
            } else if(var16 == 0 && !this.func_82540_f(p_82544_1_, p_82544_2_ + 1, p_82544_3_, p_82544_4_, var5)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      } else if(var6 == 3) {
         var14 = p_82544_1_.func_72798_a(p_82544_2_, p_82544_3_, p_82544_4_ + 1);
         var15 = p_82544_1_.func_72805_g(p_82544_2_, p_82544_3_, p_82544_4_ + 1);
         if(func_82543_e(var14) && (var5 & 4) == (var15 & 4)) {
            var16 = var15 & 3;
            if(var16 == 1 && !this.func_82540_f(p_82544_1_, p_82544_2_ - 1, p_82544_3_, p_82544_4_, var5)) {
               var13 = true;
            } else if(var16 == 0 && !this.func_82540_f(p_82544_1_, p_82544_2_ + 1, p_82544_3_, p_82544_4_, var5)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      }

      if(var13) {
         this.func_71905_a(var9, var7, var11, var10, var8, var12);
      }

      return var13;
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      this.func_82541_d(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      boolean var8 = this.func_82542_g(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      if(var8 && this.func_82544_h(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_)) {
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_) {
      this.field_72157_b.func_71921_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_);
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      this.field_72157_b.func_71862_a(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_, p_71862_5_);
   }

   public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_) {
      this.field_72157_b.func_71898_d(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_);
   }

   @SideOnly(Side.CLIENT)
   public int func_71874_e(IBlockAccess p_71874_1_, int p_71874_2_, int p_71874_3_, int p_71874_4_) {
      return this.field_72157_b.func_71874_e(p_71874_1_, p_71874_2_, p_71874_3_, p_71874_4_);
   }

   @SideOnly(Side.CLIENT)
   public float func_71870_f(IBlockAccess p_71870_1_, int p_71870_2_, int p_71870_3_, int p_71870_4_) {
      return this.field_72157_b.func_71870_f(p_71870_1_, p_71870_2_, p_71870_3_, p_71870_4_);
   }

   public float func_71904_a(Entity p_71904_1_) {
      return this.field_72157_b.func_71904_a(p_71904_1_);
   }

   public int func_71859_p_(World p_71859_1_) {
      return this.field_72157_b.func_71859_p_(p_71859_1_);
   }

   public void func_71901_a(World p_71901_1_, int p_71901_2_, int p_71901_3_, int p_71901_4_, Entity p_71901_5_, Vec3 p_71901_6_) {
      this.field_72157_b.func_71901_a(p_71901_1_, p_71901_2_, p_71901_3_, p_71901_4_, p_71901_5_, p_71901_6_);
   }

   @SideOnly(Side.CLIENT)
   public int func_71856_s_() {
      return this.field_72157_b.func_71856_s_();
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return this.field_72157_b.func_71858_a(p_71858_1_, this.field_72158_c);
   }

   @SideOnly(Side.CLIENT)
   public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_) {
      return this.field_72157_b.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
   }

   public boolean func_71935_l() {
      return this.field_72157_b.func_71935_l();
   }

   public boolean func_71913_a(int p_71913_1_, boolean p_71913_2_) {
      return this.field_72157_b.func_71913_a(p_71913_1_, p_71913_2_);
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return this.field_72157_b.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      this.func_71863_a(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_, 0);
      this.field_72157_b.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      this.field_72157_b.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   public void func_71891_b(World p_71891_1_, int p_71891_2_, int p_71891_3_, int p_71891_4_, Entity p_71891_5_) {
      this.field_72157_b.func_71891_b(p_71891_1_, p_71891_2_, p_71891_3_, p_71891_4_, p_71891_5_);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      this.field_72157_b.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      return this.field_72157_b.func_71903_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_, 0, 0.0F, 0.0F, 0.0F);
   }

   public void func_71867_k(World p_71867_1_, int p_71867_2_, int p_71867_3_, int p_71867_4_, Explosion p_71867_5_) {
      this.field_72157_b.func_71867_k(p_71867_1_, p_71867_2_, p_71867_3_, p_71867_4_, p_71867_5_);
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      int var8 = p_71860_1_.func_72805_g(p_71860_2_, p_71860_3_, p_71860_4_) & 4;
      if(var7 == 0) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 2 | var8, 2);
      }

      if(var7 == 1) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 1 | var8, 2);
      }

      if(var7 == 2) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 3 | var8, 2);
      }

      if(var7 == 3) {
         p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, 0 | var8, 2);
      }

   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      return p_85104_5_ != 0 && (p_85104_5_ == 1 || (double)p_85104_7_ <= 0.5D)?p_85104_9_:p_85104_9_ | 4;
   }

   public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_) {
      MovingObjectPosition[] var7 = new MovingObjectPosition[8];
      int var8 = p_71878_1_.func_72805_g(p_71878_2_, p_71878_3_, p_71878_4_);
      int var9 = var8 & 3;
      boolean var10 = (var8 & 4) == 4;
      int[] var11 = field_72159_a[var9 + (var10?4:0)];
      this.field_72156_cr = true;

      int var14;
      int var15;
      int var16;
      for(int var12 = 0; var12 < 8; ++var12) {
         this.field_72160_cs = var12;
         int[] var13 = var11;
         var14 = var11.length;

         for(var15 = 0; var15 < var14; ++var15) {
            var16 = var13[var15];
            if(var16 == var12) {
               ;
            }
         }

         var7[var12] = super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
      }

      int[] var21 = var11;
      int var24 = var11.length;

      for(var14 = 0; var14 < var24; ++var14) {
         var15 = var21[var14];
         var7[var15] = null;
      }

      MovingObjectPosition var23 = null;
      double var22 = 0.0D;
      MovingObjectPosition[] var25 = var7;
      var16 = var7.length;

      for(int var17 = 0; var17 < var16; ++var17) {
         MovingObjectPosition var18 = var25[var17];
         if(var18 != null) {
            double var19 = var18.field_72307_f.func_72436_e(p_71878_6_);
            if(var19 > var22) {
               var23 = var18;
               var22 = var19;
            }
         }
      }

      return var23;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {}

}
