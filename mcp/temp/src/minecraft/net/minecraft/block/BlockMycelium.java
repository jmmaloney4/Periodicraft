package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMycelium extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94422_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94421_b;


   protected BlockMycelium(int p_i3973_1_) {
      super(p_i3973_1_, Material.field_76247_b);
      this.func_71907_b(true);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94422_a:(p_71858_1_ == 0?Block.field_71979_v.func_71851_a(p_71858_1_):this.field_94336_cN);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) < 4 && Block.field_71971_o[p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ + 1, p_71847_4_)] > 2) {
            p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_71979_v.field_71990_ca);
         } else if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9) {
            for(int var6 = 0; var6 < 4; ++var6) {
               int var7 = p_71847_2_ + p_71847_5_.nextInt(3) - 1;
               int var8 = p_71847_3_ + p_71847_5_.nextInt(5) - 3;
               int var9 = p_71847_4_ + p_71847_5_.nextInt(3) - 1;
               int var10 = p_71847_1_.func_72798_a(var7, var8 + 1, var9);
               if(p_71847_1_.func_72798_a(var7, var8, var9) == Block.field_71979_v.field_71990_ca && p_71847_1_.func_72957_l(var7, var8 + 1, var9) >= 4 && Block.field_71971_o[var10] <= 2) {
                  p_71847_1_.func_94575_c(var7, var8, var9, this.field_71990_ca);
               }
            }
         }

      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_71979_v.func_71885_a(0, p_71885_2_, p_71885_3_);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71895_b(IBlockAccess p_71895_1_, int p_71895_2_, int p_71895_3_, int p_71895_4_, int p_71895_5_) {
      if(p_71895_5_ == 1) {
         return this.field_94422_a;
      } else if(p_71895_5_ == 0) {
         return Block.field_71979_v.func_71851_a(p_71895_5_);
      } else {
         Material var6 = p_71895_1_.func_72803_f(p_71895_2_, p_71895_3_ + 1, p_71895_4_);
         return var6 != Material.field_76259_v && var6 != Material.field_76258_w?this.field_94336_cN:this.field_94421_b;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("mycel_side");
      this.field_94422_a = p_94332_1_.func_94245_a("mycel_top");
      this.field_94421_b = p_94332_1_.func_94245_a("snow_side");
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      super.func_71862_a(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_, p_71862_5_);
      if(p_71862_5_.nextInt(10) == 0) {
         p_71862_1_.func_72869_a("townaura", (double)((float)p_71862_2_ + p_71862_5_.nextFloat()), (double)((float)p_71862_3_ + 1.1F), (double)((float)p_71862_4_ + p_71862_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
      }

   }
}
