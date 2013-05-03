package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockStep extends BlockHalfSlab {

   public static final String[] field_72244_a = new String[]{"stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick", "netherBrick", "quartz"};
   @SideOnly(Side.CLIENT)
   private Icon field_94433_b;


   public BlockStep(int p_i4000_1_, boolean p_i4000_2_) {
      super(p_i4000_1_, p_i4000_2_, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      int var3 = p_71858_2_ & 7;
      if(this.field_72242_a && (p_71858_2_ & 8) != 0) {
         p_71858_1_ = 1;
      }

      return var3 == 0?(p_71858_1_ != 1 && p_71858_1_ != 0?this.field_94433_b:this.field_94336_cN):(var3 == 1?Block.field_71957_Q.func_71851_a(p_71858_1_):(var3 == 2?Block.field_71988_x.func_71851_a(p_71858_1_):(var3 == 3?Block.field_71978_w.func_71851_a(p_71858_1_):(var3 == 4?Block.field_72081_al.func_71851_a(p_71858_1_):(var3 == 5?Block.field_72007_bm.func_71858_a(p_71858_1_, 0):(var3 == 6?Block.field_72033_bA.func_71851_a(1):(var3 == 7?Block.field_94339_ct.func_71851_a(p_71858_1_):this.field_94336_cN)))))));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("stoneslab_top");
      this.field_94433_b = p_94332_1_.func_94245_a("stoneslab_side");
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72079_ak.field_71990_ca;
   }

   protected ItemStack func_71880_c_(int p_71880_1_) {
      return new ItemStack(Block.field_72079_ak.field_71990_ca, 2, p_71880_1_ & 7);
   }

   public String func_72240_d(int p_72240_1_) {
      if(p_72240_1_ < 0 || p_72240_1_ >= field_72244_a.length) {
         p_72240_1_ = 0;
      }

      return super.func_71917_a() + "." + field_72244_a[p_72240_1_];
   }

   @SideOnly(Side.CLIENT)
   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      if(p_71879_1_ != Block.field_72085_aj.field_71990_ca) {
         for(int var4 = 0; var4 <= 7; ++var4) {
            if(var4 != 2) {
               p_71879_3_.add(new ItemStack(p_71879_1_, 1, var4));
            }
         }

      }
   }

}
