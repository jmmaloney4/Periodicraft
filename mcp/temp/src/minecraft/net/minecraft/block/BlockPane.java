package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPane extends Block {

   private final String field_72164_a;
   private final boolean field_72163_b;
   private final String field_94402_c;
   @SideOnly(Side.CLIENT)
   private Icon field_94401_cO;


   protected BlockPane(int p_i9094_1_, String p_i9094_2_, String p_i9094_3_, Material p_i9094_4_, boolean p_i9094_5_) {
      super(p_i9094_1_, p_i9094_4_);
      this.field_72164_a = p_i9094_3_;
      this.field_72163_b = p_i9094_5_;
      this.field_94402_c = p_i9094_2_;
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return !this.field_72163_b?0:super.func_71885_a(p_71885_1_, p_71885_2_, p_71885_3_);
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 18;
   }

   @SideOnly(Side.CLIENT)
   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      int var6 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_);
      return var6 == this.field_71990_ca?false:super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      boolean var8 = this.func_72161_e(p_71871_1_.func_72798_a(p_71871_2_, p_71871_3_, p_71871_4_ - 1));
      boolean var9 = this.func_72161_e(p_71871_1_.func_72798_a(p_71871_2_, p_71871_3_, p_71871_4_ + 1));
      boolean var10 = this.func_72161_e(p_71871_1_.func_72798_a(p_71871_2_ - 1, p_71871_3_, p_71871_4_));
      boolean var11 = this.func_72161_e(p_71871_1_.func_72798_a(p_71871_2_ + 1, p_71871_3_, p_71871_4_));
      if((!var10 || !var11) && (var10 || var11 || var8 || var9)) {
         if(var10 && !var11) {
            this.func_71905_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
         } else if(!var10 && var11) {
            this.func_71905_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
         }
      } else {
         this.func_71905_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

      if((!var8 || !var9) && (var10 || var11 || var8 || var9)) {
         if(var8 && !var9) {
            this.func_71905_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
         } else if(!var8 && var9) {
            this.func_71905_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
         }
      } else {
         this.func_71905_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

   }

   public void func_71919_f() {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      float var7 = 0.4375F;
      float var8 = 0.5625F;
      boolean var9 = this.func_72161_e(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ - 1));
      boolean var10 = this.func_72161_e(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_, p_71902_4_ + 1));
      boolean var11 = this.func_72161_e(p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_));
      boolean var12 = this.func_72161_e(p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_));
      if((!var11 || !var12) && (var11 || var12 || var9 || var10)) {
         if(var11 && !var12) {
            var5 = 0.0F;
         } else if(!var11 && var12) {
            var6 = 1.0F;
         }
      } else {
         var5 = 0.0F;
         var6 = 1.0F;
      }

      if((!var9 || !var10) && (var11 || var12 || var9 || var10)) {
         if(var9 && !var10) {
            var7 = 0.0F;
         } else if(!var9 && var10) {
            var8 = 1.0F;
         }
      } else {
         var7 = 0.0F;
         var8 = 1.0F;
      }

      this.func_71905_a(var5, 0.0F, var7, var6, 1.0F, var8);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_72162_n() {
      return this.field_94401_cO;
   }

   public final boolean func_72161_e(int p_72161_1_) {
      return Block.field_71970_n[p_72161_1_] || p_72161_1_ == this.field_71990_ca || p_72161_1_ == Block.field_71946_M.field_71990_ca;
   }

   protected boolean func_71906_q_() {
      return true;
   }

   protected ItemStack func_71880_c_(int p_71880_1_) {
      return new ItemStack(this.field_71990_ca, 1, p_71880_1_);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_94402_c);
      this.field_94401_cO = p_94332_1_.func_94245_a(this.field_72164_a);
   }
}
