package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLadder extends Block {

   protected BlockLadder(int p_i9067_1_) {
      super(p_i9067_1_, Material.field_76265_p);
      this.func_71849_a(CreativeTabs.field_78031_c);
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
      this.func_85107_d(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_));
   }

   public void func_85107_d(int p_85107_1_) {
      float var3 = 0.125F;
      if(p_85107_1_ == 2) {
         this.func_71905_a(0.0F, 0.0F, 1.0F - var3, 1.0F, 1.0F, 1.0F);
      }

      if(p_85107_1_ == 3) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var3);
      }

      if(p_85107_1_ == 4) {
         this.func_71905_a(1.0F - var3, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

      if(p_85107_1_ == 5) {
         this.func_71905_a(0.0F, 0.0F, 0.0F, var3, 1.0F, 1.0F);
      }

   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 8;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72809_s(p_71930_2_ - 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_ + 1, p_71930_3_, p_71930_4_)?true:(p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ - 1)?true:p_71930_1_.func_72809_s(p_71930_2_, p_71930_3_, p_71930_4_ + 1)));
   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      int var10 = p_85104_9_;
      if((p_85104_9_ == 0 || p_85104_5_ == 2) && p_85104_1_.func_72809_s(p_85104_2_, p_85104_3_, p_85104_4_ + 1)) {
         var10 = 2;
      }

      if((var10 == 0 || p_85104_5_ == 3) && p_85104_1_.func_72809_s(p_85104_2_, p_85104_3_, p_85104_4_ - 1)) {
         var10 = 3;
      }

      if((var10 == 0 || p_85104_5_ == 4) && p_85104_1_.func_72809_s(p_85104_2_ + 1, p_85104_3_, p_85104_4_)) {
         var10 = 4;
      }

      if((var10 == 0 || p_85104_5_ == 5) && p_85104_1_.func_72809_s(p_85104_2_ - 1, p_85104_3_, p_85104_4_)) {
         var10 = 5;
      }

      return var10;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
      boolean var7 = false;
      if(var6 == 2 && p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ + 1)) {
         var7 = true;
      }

      if(var6 == 3 && p_71863_1_.func_72809_s(p_71863_2_, p_71863_3_, p_71863_4_ - 1)) {
         var7 = true;
      }

      if(var6 == 4 && p_71863_1_.func_72809_s(p_71863_2_ + 1, p_71863_3_, p_71863_4_)) {
         var7 = true;
      }

      if(var6 == 5 && p_71863_1_.func_72809_s(p_71863_2_ - 1, p_71863_3_, p_71863_4_)) {
         var7 = true;
      }

      if(!var7) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }
}
