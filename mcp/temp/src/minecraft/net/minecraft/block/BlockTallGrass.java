package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTallGrass extends BlockFlower {

   private static final String[] field_94367_a = new String[]{"deadbush", "tallgrass", "fern"};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94366_b;


   protected BlockTallGrass(int p_i9093_1_) {
      super(p_i9093_1_, Material.field_76255_k);
      float var2 = 0.4F;
      this.func_71905_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.8F, 0.5F + var2);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_2_ >= this.field_94366_b.length) {
         p_71858_2_ = 0;
      }

      return this.field_94366_b[p_71858_2_];
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return p_71885_2_.nextInt(8) == 0?Item.field_77690_S.field_77779_bT:-1;
   }

   public int func_71910_a(int p_71910_1_, Random p_71910_2_) {
      return 1 + p_71910_2_.nextInt(p_71910_1_ * 2 + 1);
   }

   public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_) {
      if(!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT) {
         p_71893_2_.func_71064_a(StatList.field_75934_C[this.field_71990_ca], 1);
         this.func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71962_X, 1, p_71893_6_));
      } else {
         super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
      }

   }

   @SideOnly(Side.CLIENT)
   public int func_71933_m() {
      double var1 = 0.5D;
      double var3 = 1.0D;
      return ColorizerGrass.func_77480_a(var1, var3);
   }

   @SideOnly(Side.CLIENT)
   public int func_71889_f_(int p_71889_1_) {
      return p_71889_1_ == 0?16777215:ColorizerFoliage.func_77468_c();
   }

   @SideOnly(Side.CLIENT)
   public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_) {
      int var5 = p_71920_1_.func_72805_g(p_71920_2_, p_71920_3_, p_71920_4_);
      return var5 == 0?16777215:p_71920_1_.func_72807_a(p_71920_2_, p_71920_4_).func_76737_k();
   }

   public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int p_71873_4_) {
      return p_71873_1_.func_72805_g(p_71873_2_, p_71873_3_, p_71873_4_);
   }

   @SideOnly(Side.CLIENT)
   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      for(int var4 = 1; var4 < 3; ++var4) {
         p_71879_3_.add(new ItemStack(p_71879_1_, 1, var4));
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94366_b = new Icon[field_94367_a.length];

      for(int var2 = 0; var2 < this.field_94366_b.length; ++var2) {
         this.field_94366_b[var2] = p_94332_1_.func_94245_a(field_94367_a[var2]);
      }

   }

}
