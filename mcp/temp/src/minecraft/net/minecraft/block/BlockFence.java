package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFence extends Block {

   private final String field_94464_a;


   public BlockFence(int p_i9055_1_, String p_i9055_2_, Material p_i9055_3_) {
      super(p_i9055_1_, p_i9055_3_);
      this.field_94464_a = p_i9055_2_;
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      boolean var8 = this.func_72250_d(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_ - 1);
      boolean var9 = this.func_72250_d(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_ + 1);
      boolean var10 = this.func_72250_d(p_71871_1_, p_71871_2_ - 1, p_71871_3_, p_71871_4_);
      boolean var11 = this.func_72250_d(p_71871_1_, p_71871_2_ + 1, p_71871_3_, p_71871_4_);
      float var12 = 0.375F;
      float var13 = 0.625F;
      float var14 = 0.375F;
      float var15 = 0.625F;
      if(var8) {
         var14 = 0.0F;
      }

      if(var9) {
         var15 = 1.0F;
      }

      if(var8 || var9) {
         this.func_71905_a(var12, 0.0F, var14, var13, 1.5F, var15);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

      var14 = 0.375F;
      var15 = 0.625F;
      if(var10) {
         var12 = 0.0F;
      }

      if(var11) {
         var13 = 1.0F;
      }

      if(var10 || var11 || !var8 && !var9) {
         this.func_71905_a(var12, 0.0F, var14, var13, 1.5F, var15);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

      if(var8) {
         var14 = 0.0F;
      }

      if(var9) {
         var15 = 1.0F;
      }

      this.func_71905_a(var12, 0.0F, var14, var13, 1.0F, var15);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      boolean var5 = this.func_72250_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ - 1);
      boolean var6 = this.func_72250_d(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_ + 1);
      boolean var7 = this.func_72250_d(p_71902_1_, p_71902_2_ - 1, p_71902_3_, p_71902_4_);
      boolean var8 = this.func_72250_d(p_71902_1_, p_71902_2_ + 1, p_71902_3_, p_71902_4_);
      float var9 = 0.375F;
      float var10 = 0.625F;
      float var11 = 0.375F;
      float var12 = 0.625F;
      if(var5) {
         var11 = 0.0F;
      }

      if(var6) {
         var12 = 1.0F;
      }

      if(var7) {
         var9 = 0.0F;
      }

      if(var8) {
         var10 = 1.0F;
      }

      this.func_71905_a(var9, 0.0F, var11, var10, 1.0F, var12);
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_) {
      return false;
   }

   public int func_71857_b() {
      return 11;
   }

   public boolean func_72250_d(IBlockAccess p_72250_1_, int p_72250_2_, int p_72250_3_, int p_72250_4_) {
      int var5 = p_72250_1_.func_72798_a(p_72250_2_, p_72250_3_, p_72250_4_);
      if(var5 != this.field_71990_ca && var5 != Block.field_71993_bv.field_71990_ca) {
         Block var6 = Block.field_71973_m[var5];
         return var6 != null && var6.field_72018_cp.func_76218_k() && var6.func_71886_c()?var6.field_72018_cp != Material.field_76266_z:false;
      } else {
         return true;
      }
   }

   public static boolean func_72249_c(int p_72249_0_) {
      return p_72249_0_ == Block.field_72031_aZ.field_71990_ca || p_72249_0_ == Block.field_72098_bB.field_71990_ca;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_94464_a);
   }
}
