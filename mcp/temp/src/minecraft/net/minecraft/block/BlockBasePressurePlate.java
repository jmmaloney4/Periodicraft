package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockBasePressurePlate extends Block {

   private String field_94356_a;


   protected BlockBasePressurePlate(int p_i9036_1_, String p_i9036_2_, Material p_i9036_3_) {
      super(p_i9036_1_, p_i9036_3_);
      this.field_94356_a = p_i9036_2_;
      this.func_71849_a(CreativeTabs.field_78028_d);
      this.func_71907_b(true);
      this.func_94353_c_(this.func_94355_d(15));
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      this.func_94353_c_(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_));
   }

   protected void func_94353_c_(int p_94353_1_) {
      boolean var2 = this.func_94350_c(p_94353_1_) > 0;
      float var3 = 0.0625F;
      if(var2) {
         this.func_71905_a(var3, 0.0F, var3, 1.0F - var3, 0.03125F, 1.0F - var3);
      } else {
         this.func_71905_a(var3, 0.0F, var3, 1.0F - var3, 0.0625F, 1.0F - var3);
      }

   }

   public int func_71859_p_(World p_71859_1_) {
      return 20;
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

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return true;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) || BlockFence.func_72249_c(p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_));
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      boolean var6 = false;
      if(!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_) && !BlockFence.func_72249_c(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ - 1, p_71863_4_))) {
         var6 = true;
      }

      if(var6) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         int var6 = this.func_94350_c(p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_));
         if(var6 > 0) {
            this.func_72193_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, var6);
         }

      }
   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      if(!p_71869_1_.field_72995_K) {
         int var6 = this.func_94350_c(p_71869_1_.func_72805_g(p_71869_2_, p_71869_3_, p_71869_4_));
         if(var6 == 0) {
            this.func_72193_l(p_71869_1_, p_71869_2_, p_71869_3_, p_71869_4_, var6);
         }

      }
   }

   protected void func_72193_l(World p_72193_1_, int p_72193_2_, int p_72193_3_, int p_72193_4_, int p_72193_5_) {
      int var6 = this.func_94351_d(p_72193_1_, p_72193_2_, p_72193_3_, p_72193_4_);
      boolean var7 = p_72193_5_ > 0;
      boolean var8 = var6 > 0;
      if(p_72193_5_ != var6) {
         p_72193_1_.func_72921_c(p_72193_2_, p_72193_3_, p_72193_4_, this.func_94355_d(var6), 2);
         this.func_94354_b_(p_72193_1_, p_72193_2_, p_72193_3_, p_72193_4_);
         p_72193_1_.func_72909_d(p_72193_2_, p_72193_3_, p_72193_4_, p_72193_2_, p_72193_3_, p_72193_4_);
      }

      if(!var8 && var7) {
         p_72193_1_.func_72908_a((double)p_72193_2_ + 0.5D, (double)p_72193_3_ + 0.1D, (double)p_72193_4_ + 0.5D, "random.click", 0.3F, 0.5F);
      } else if(var8 && !var7) {
         p_72193_1_.func_72908_a((double)p_72193_2_ + 0.5D, (double)p_72193_3_ + 0.1D, (double)p_72193_4_ + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(var8) {
         p_72193_1_.func_72836_a(p_72193_2_, p_72193_3_, p_72193_4_, this.field_71990_ca, this.func_71859_p_(p_72193_1_));
      }

   }

   protected AxisAlignedBB func_94352_a(int p_94352_1_, int p_94352_2_, int p_94352_3_) {
      float var4 = 0.125F;
      return AxisAlignedBB.func_72332_a().func_72299_a((double)((float)p_94352_1_ + var4), (double)p_94352_2_, (double)((float)p_94352_3_ + var4), (double)((float)(p_94352_1_ + 1) - var4), (double)p_94352_2_ + 0.25D, (double)((float)(p_94352_3_ + 1) - var4));
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      if(this.func_94350_c(p_71852_6_) > 0) {
         this.func_94354_b_(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
      }

      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
   }

   protected void func_94354_b_(World p_94354_1_, int p_94354_2_, int p_94354_3_, int p_94354_4_) {
      p_94354_1_.func_72898_h(p_94354_2_, p_94354_3_, p_94354_4_, this.field_71990_ca);
      p_94354_1_.func_72898_h(p_94354_2_, p_94354_3_ - 1, p_94354_4_, this.field_71990_ca);
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      return this.func_94350_c(p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_));
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return p_71855_5_ == 1?this.func_94350_c(p_71855_1_.func_72805_g(p_71855_2_, p_71855_3_, p_71855_4_)):0;
   }

   public boolean func_71853_i() {
      return true;
   }

   public void func_71919_f() {
      float var1 = 0.5F;
      float var2 = 0.125F;
      float var3 = 0.5F;
      this.func_71905_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   public int func_71915_e() {
      return 1;
   }

   protected abstract int func_94351_d(World var1, int var2, int var3, int var4);

   protected abstract int func_94350_c(int var1);

   protected abstract int func_94355_d(int var1);

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_94356_a);
   }
}
