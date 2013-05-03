package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockRedstoneLogic extends BlockDirectional {

   protected final boolean field_72222_c;


   protected BlockRedstoneLogic(int p_i9012_1_, boolean p_i9012_2_) {
      super(p_i9012_1_, Material.field_76265_p);
      this.field_72222_c = p_i9012_2_;
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return !p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_)?false:super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      return !p_71854_1_.func_72797_t(p_71854_2_, p_71854_3_ - 1, p_71854_4_)?false:super.func_71854_d(p_71854_1_, p_71854_2_, p_71854_3_, p_71854_4_);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
      if(!this.func_94476_e(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, var6)) {
         boolean var7 = this.func_94478_d(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, var6);
         if(this.field_72222_c && !var7) {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, this.func_94484_i().field_71990_ca, var6, 2);
         } else if(!this.field_72222_c) {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, this.func_94485_e().field_71990_ca, var6, 2);
            if(!var7) {
               p_71847_1_.func_82740_a(p_71847_2_, p_71847_3_, p_71847_4_, this.func_94485_e().field_71990_ca, this.func_94486_g(var6), -1);
            }
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 0?(this.field_72222_c?Block.field_72035_aQ.func_71851_a(p_71858_1_):Block.field_72049_aP.func_71851_a(p_71858_1_)):(p_71858_1_ == 1?this.field_94336_cN:Block.field_72085_aj.func_71851_a(1));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_72222_c?"repeater_lit":"repeater");
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      return p_71877_5_ != 0 && p_71877_5_ != 1;
   }

   public int func_71857_b() {
      return 36;
   }

   protected boolean func_96470_c(int p_96470_1_) {
      return this.field_72222_c;
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_);
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      int var6 = p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_);
      if(!this.func_96470_c(var6)) {
         return 0;
      } else {
         int var7 = func_72217_d(var6);
         return var7 == 0 && p_71865_5_ == 3?this.func_94480_d(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_, var6):(var7 == 1 && p_71865_5_ == 4?this.func_94480_d(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_, var6):(var7 == 2 && p_71865_5_ == 2?this.func_94480_d(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_, var6):(var7 == 3 && p_71865_5_ == 5?this.func_94480_d(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_, var6):0)));
      }
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!this.func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         p_71863_1_.func_72898_h(p_71863_2_ + 1, p_71863_3_, p_71863_4_, this.field_71990_ca);
         p_71863_1_.func_72898_h(p_71863_2_ - 1, p_71863_3_, p_71863_4_, this.field_71990_ca);
         p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_, p_71863_4_ + 1, this.field_71990_ca);
         p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_, p_71863_4_ - 1, this.field_71990_ca);
         p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_ - 1, p_71863_4_, this.field_71990_ca);
         p_71863_1_.func_72898_h(p_71863_2_, p_71863_3_ + 1, p_71863_4_, this.field_71990_ca);
      } else {
         this.func_94479_f(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      }
   }

   protected void func_94479_f(World p_94479_1_, int p_94479_2_, int p_94479_3_, int p_94479_4_, int p_94479_5_) {
      int var6 = p_94479_1_.func_72805_g(p_94479_2_, p_94479_3_, p_94479_4_);
      if(!this.func_94476_e(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, var6)) {
         boolean var7 = this.func_94478_d(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, var6);
         if((this.field_72222_c && !var7 || !this.field_72222_c && var7) && !p_94479_1_.func_94573_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca)) {
            byte var8 = -1;
            if(this.func_83011_d(p_94479_1_, p_94479_2_, p_94479_3_, p_94479_4_, var6)) {
               var8 = -3;
            } else if(this.field_72222_c) {
               var8 = -2;
            }

            p_94479_1_.func_82740_a(p_94479_2_, p_94479_3_, p_94479_4_, this.field_71990_ca, this.func_94481_j_(var6), var8);
         }
      }

   }

   public boolean func_94476_e(IBlockAccess p_94476_1_, int p_94476_2_, int p_94476_3_, int p_94476_4_, int p_94476_5_) {
      return false;
   }

   protected boolean func_94478_d(World p_94478_1_, int p_94478_2_, int p_94478_3_, int p_94478_4_, int p_94478_5_) {
      return this.func_72220_e(p_94478_1_, p_94478_2_, p_94478_3_, p_94478_4_, p_94478_5_) > 0;
   }

   protected int func_72220_e(World p_72220_1_, int p_72220_2_, int p_72220_3_, int p_72220_4_, int p_72220_5_) {
      int var6 = func_72217_d(p_72220_5_);
      int var7 = p_72220_2_ + Direction.field_71583_a[var6];
      int var8 = p_72220_4_ + Direction.field_71581_b[var6];
      int var9 = p_72220_1_.func_72878_l(var7, p_72220_3_, var8, Direction.field_71582_c[var6]);
      return var9 >= 15?var9:Math.max(var9, p_72220_1_.func_72798_a(var7, p_72220_3_, var8) == Block.field_72075_av.field_71990_ca?p_72220_1_.func_72805_g(var7, p_72220_3_, var8):0);
   }

   protected int func_94482_f(IBlockAccess p_94482_1_, int p_94482_2_, int p_94482_3_, int p_94482_4_, int p_94482_5_) {
      int var6 = func_72217_d(p_94482_5_);
      switch(var6) {
      case 0:
      case 2:
         return Math.max(this.func_94488_g(p_94482_1_, p_94482_2_ - 1, p_94482_3_, p_94482_4_, 4), this.func_94488_g(p_94482_1_, p_94482_2_ + 1, p_94482_3_, p_94482_4_, 5));
      case 1:
      case 3:
         return Math.max(this.func_94488_g(p_94482_1_, p_94482_2_, p_94482_3_, p_94482_4_ + 1, 3), this.func_94488_g(p_94482_1_, p_94482_2_, p_94482_3_, p_94482_4_ - 1, 2));
      default:
         return 0;
      }
   }

   protected int func_94488_g(IBlockAccess p_94488_1_, int p_94488_2_, int p_94488_3_, int p_94488_4_, int p_94488_5_) {
      int var6 = p_94488_1_.func_72798_a(p_94488_2_, p_94488_3_, p_94488_4_);
      return this.func_94477_d(var6)?(var6 == Block.field_72075_av.field_71990_ca?p_94488_1_.func_72805_g(p_94488_2_, p_94488_3_, p_94488_4_):p_94488_1_.func_72879_k(p_94488_2_, p_94488_3_, p_94488_4_, p_94488_5_)):0;
   }

   public boolean func_71853_i() {
      return true;
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = ((MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 3);
      boolean var8 = this.func_94478_d(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, var7);
      if(var8) {
         p_71860_1_.func_72836_a(p_71860_2_, p_71860_3_, p_71860_4_, this.field_71990_ca, 1);
      }

   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      this.func_94483_i_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
   }

   protected void func_94483_i_(World p_94483_1_, int p_94483_2_, int p_94483_3_, int p_94483_4_) {
      int var5 = func_72217_d(p_94483_1_.func_72805_g(p_94483_2_, p_94483_3_, p_94483_4_));
      if(var5 == 1) {
         p_94483_1_.func_72821_m(p_94483_2_ + 1, p_94483_3_, p_94483_4_, this.field_71990_ca);
         p_94483_1_.func_96439_d(p_94483_2_ + 1, p_94483_3_, p_94483_4_, this.field_71990_ca, 4);
      }

      if(var5 == 3) {
         p_94483_1_.func_72821_m(p_94483_2_ - 1, p_94483_3_, p_94483_4_, this.field_71990_ca);
         p_94483_1_.func_96439_d(p_94483_2_ - 1, p_94483_3_, p_94483_4_, this.field_71990_ca, 5);
      }

      if(var5 == 2) {
         p_94483_1_.func_72821_m(p_94483_2_, p_94483_3_, p_94483_4_ + 1, this.field_71990_ca);
         p_94483_1_.func_96439_d(p_94483_2_, p_94483_3_, p_94483_4_ + 1, this.field_71990_ca, 2);
      }

      if(var5 == 0) {
         p_94483_1_.func_72821_m(p_94483_2_, p_94483_3_, p_94483_4_ - 1, this.field_71990_ca);
         p_94483_1_.func_96439_d(p_94483_2_, p_94483_3_, p_94483_4_ - 1, this.field_71990_ca, 3);
      }

   }

   public void func_71898_d(World p_71898_1_, int p_71898_2_, int p_71898_3_, int p_71898_4_, int p_71898_5_) {
      if(this.field_72222_c) {
         p_71898_1_.func_72898_h(p_71898_2_ + 1, p_71898_3_, p_71898_4_, this.field_71990_ca);
         p_71898_1_.func_72898_h(p_71898_2_ - 1, p_71898_3_, p_71898_4_, this.field_71990_ca);
         p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_, p_71898_4_ + 1, this.field_71990_ca);
         p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_, p_71898_4_ - 1, this.field_71990_ca);
         p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_ - 1, p_71898_4_, this.field_71990_ca);
         p_71898_1_.func_72898_h(p_71898_2_, p_71898_3_ + 1, p_71898_4_, this.field_71990_ca);
      }

      super.func_71898_d(p_71898_1_, p_71898_2_, p_71898_3_, p_71898_4_, p_71898_5_);
   }

   public boolean func_71926_d() {
      return false;
   }

   protected boolean func_94477_d(int p_94477_1_) {
      Block var2 = Block.field_71973_m[p_94477_1_];
      return var2 != null && var2.func_71853_i();
   }

   protected int func_94480_d(IBlockAccess p_94480_1_, int p_94480_2_, int p_94480_3_, int p_94480_4_, int p_94480_5_) {
      return 15;
   }

   public static boolean func_82524_c(int p_82524_0_) {
      return Block.field_72010_bh.func_94487_f(p_82524_0_) || Block.field_94346_cn.func_94487_f(p_82524_0_);
   }

   public boolean func_94487_f(int p_94487_1_) {
      return p_94487_1_ == this.func_94485_e().field_71990_ca || p_94487_1_ == this.func_94484_i().field_71990_ca;
   }

   public boolean func_83011_d(World p_83011_1_, int p_83011_2_, int p_83011_3_, int p_83011_4_, int p_83011_5_) {
      int var6 = func_72217_d(p_83011_5_);
      if(func_82524_c(p_83011_1_.func_72798_a(p_83011_2_ - Direction.field_71583_a[var6], p_83011_3_, p_83011_4_ - Direction.field_71581_b[var6]))) {
         int var7 = p_83011_1_.func_72805_g(p_83011_2_ - Direction.field_71583_a[var6], p_83011_3_, p_83011_4_ - Direction.field_71581_b[var6]);
         int var8 = func_72217_d(var7);
         return var8 != var6;
      } else {
         return false;
      }
   }

   protected int func_94486_g(int p_94486_1_) {
      return this.func_94481_j_(p_94486_1_);
   }

   protected abstract int func_94481_j_(int var1);

   protected abstract BlockRedstoneLogic func_94485_e();

   protected abstract BlockRedstoneLogic func_94484_i();

   public boolean func_94334_h(int p_94334_1_) {
      return this.func_94487_f(p_94334_1_);
   }
}
