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

public class BlockWoodSlab extends BlockHalfSlab {

   public static final String[] field_72243_a = new String[]{"oak", "spruce", "birch", "jungle"};


   public BlockWoodSlab(int p_i4022_1_, boolean p_i4022_2_) {
      super(p_i4022_1_, p_i4022_2_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return Block.field_71988_x.func_71858_a(p_71858_1_, p_71858_2_ & 7);
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72092_bO.field_71990_ca;
   }

   protected ItemStack func_71880_c_(int p_71880_1_) {
      return new ItemStack(Block.field_72092_bO.field_71990_ca, 2, p_71880_1_ & 7);
   }

   public String func_72240_d(int p_72240_1_) {
      if(p_72240_1_ < 0 || p_72240_1_ >= field_72243_a.length) {
         p_72240_1_ = 0;
      }

      return super.func_71917_a() + "." + field_72243_a[p_72240_1_];
   }

   @SideOnly(Side.CLIENT)
   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      if(p_71879_1_ != Block.field_72090_bN.field_71990_ca) {
         for(int var4 = 0; var4 < 4; ++var4) {
            p_71879_3_.add(new ItemStack(p_71879_1_, 1, var4));
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {}

}
