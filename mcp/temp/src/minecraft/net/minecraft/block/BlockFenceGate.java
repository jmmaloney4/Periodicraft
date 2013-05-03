package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceGate extends BlockDirectional {

   public BlockFenceGate(int p_i9054_1_) {
      super(p_i9054_1_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78028_d);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return Block.field_71988_x.func_71851_a(p_71858_1_);
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return !p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_).func_76220_a()?false:super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      int var5 = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_);
      return func_72224_c(var5)?null:(var5 != 2 && var5 != 0?AxisAlignedBB.func_72332_a().func_72299_a((double)((float)p_71872_2_ + 0.375F), (double)p_71872_3_, (double)p_71872_4_, (double)((float)p_71872_2_ + 0.625F), (double)((float)p_71872_3_ + 1.5F), (double)(p_71872_4_ + 1)):AxisAlignedBB.func_72332_a().func_72299_a((double)p_71872_2_, (double)p_71872_3_, (double)((float)p_71872_4_ + 0.375F), (double)(p_71872_2_ + 1), (double)((float)p_71872_3_ + 1.5F), (double)((float)p_71872_4_ + 0.625F)));
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = func_72217_d(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_));
      if(var5 != 2 && var5 != 0) {
         this.func_71905_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      }

   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return func_72224_c(p_71918_1_.func_72805_g(p_71918_2_, p_71918_3_, p_71918_4_));
   }

   public int func_71857_b() {
      return 21;
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = (MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) % 4;
      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 2);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
      if(func_72224_c(var10)) {
         p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var10 & -5, 2);
      } else {
         int var11 = (MathHelper.func_76128_c((double)(p_71903_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) % 4;
         int var12 = func_72217_d(var10);
         if(var12 == (var11 + 2) % 4) {
            var10 = var11;
         }

         p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var10 | 4, 2);
      }

      p_71903_1_.func_72889_a(p_71903_5_, 1003, p_71903_2_, p_71903_3_, p_71903_4_, 0);
      return true;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K) {
         int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
         boolean var7 = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_);
         if(var7 || p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i()) {
            if(var7 && !func_72224_c(var6)) {
               p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, var6 | 4, 2);
               p_71863_1_.func_72889_a((EntityPlayer)null, 1003, p_71863_2_, p_71863_3_, p_71863_4_, 0);
            } else if(!var7 && func_72224_c(var6)) {
               p_71863_1_.func_72921_c(p_71863_2_, p_71863_3_, p_71863_4_, var6 & -5, 2);
               p_71863_1_.func_72889_a((EntityPlayer)null, 1003, p_71863_2_, p_71863_3_, p_71863_4_, 0);
            }
         }

      }
   }

   public static boolean func_72224_c(int p_72224_0_) {
      return (p_72224_0_ & 4) != 0;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {}
}
