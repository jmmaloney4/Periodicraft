package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCocoa extends BlockDirectional {

   public static final String[] field_94470_a = new String[]{"cocoa_0", "cocoa_1", "cocoa_2"};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94469_b;


   public BlockCocoa(int p_i3930_1_) {
      super(p_i3930_1_, Material.field_76254_j);
      this.func_71907_b(true);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return this.field_94469_b[2];
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!this.func_71854_d(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_)) {
         this.func_71897_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), 0);
         p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
      } else if(p_71847_1_.field_73012_v.nextInt(5) == 0) {
         int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
         int var7 = func_72219_c(var6);
         if(var7 < 2) {
            ++var7;
            p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var7 << 2 | func_72217_d(var6), 2);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public Icon func_94468_i_(int p_94468_1_) {
      if(p_94468_1_ < 0 || p_94468_1_ >= this.field_94469_b.length) {
         p_94468_1_ = this.field_94469_b.length - 1;
      }

      return this.field_94469_b[p_94468_1_];
   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      int var5 = func_72217_d(p_71854_1_.func_72805_g(p_71854_2_, p_71854_3_, p_71854_4_));
      p_71854_2_ += Direction.field_71583_a[var5];
      p_71854_4_ += Direction.field_71581_b[var5];
      int var6 = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_, p_71854_4_);
      return var6 == Block.field_71951_J.field_71990_ca && BlockLog.func_72141_e(p_71854_1_.func_72805_g(p_71854_2_, p_71854_3_, p_71854_4_)) == 3;
   }

   public int func_71857_b() {
      return 28;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71926_d() {
      return false;
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      this.func_71902_a(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
      return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
   }

   @SideOnly(Side.CLIENT)
   public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_) {
      this.func_71902_a(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
      return super.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
      int var6 = func_72217_d(var5);
      int var7 = func_72219_c(var5);
      int var8 = 4 + var7 * 2;
      int var9 = 5 + var7 * 2;
      float var10 = (float)var8 / 2.0F;
      switch(var6) {
      case 0:
         this.func_71905_a((8.0F - var10) / 16.0F, (12.0F - (float)var9) / 16.0F, (15.0F - (float)var8) / 16.0F, (8.0F + var10) / 16.0F, 0.75F, 0.9375F);
         break;
      case 1:
         this.func_71905_a(0.0625F, (12.0F - (float)var9) / 16.0F, (8.0F - var10) / 16.0F, (1.0F + (float)var8) / 16.0F, 0.75F, (8.0F + var10) / 16.0F);
         break;
      case 2:
         this.func_71905_a((8.0F - var10) / 16.0F, (12.0F - (float)var9) / 16.0F, 0.0625F, (8.0F + var10) / 16.0F, 0.75F, (1.0F + (float)var8) / 16.0F);
         break;
      case 3:
         this.func_71905_a((15.0F - (float)var8) / 16.0F, (12.0F - (float)var9) / 16.0F, (8.0F - var10) / 16.0F, 0.9375F, 0.75F, (8.0F + var10) / 16.0F);
      }

   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = ((MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) + 0) % 4;
      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 2);
   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      if(p_85104_5_ == 1 || p_85104_5_ == 0) {
         p_85104_5_ = 2;
      }

      return Direction.field_71580_e[Direction.field_71579_d[p_85104_5_]];
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!this.func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public static int func_72219_c(int p_72219_0_) {
      return (p_72219_0_ & 12) >> 2;
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      int var8 = func_72219_c(p_71914_5_);
      byte var9 = 1;
      if(var8 >= 2) {
         var9 = 3;
      }

      for(int var10 = 0; var10 < var9; ++var10) {
         this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(Item.field_77756_aW, 1, 3));
      }

   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77756_aW.field_77779_bT;
   }

   public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int p_71873_4_) {
      return 3;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94469_b = new Icon[field_94470_a.length];

      for(int var2 = 0; var2 < this.field_94469_b.length; ++var2) {
         this.field_94469_b[var2] = p_94332_1_.func_94245_a(field_94470_a[var2]);
      }

   }

}
