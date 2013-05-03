package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockLog extends Block {

   public static final String[] field_72142_a = new String[]{"oak", "spruce", "birch", "jungle"};
   public static final String[] field_94389_b = new String[]{"tree_side", "tree_spruce", "tree_birch", "tree_jungle"};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94390_c;
   @SideOnly(Side.CLIENT)
   private Icon field_94388_cO;


   protected BlockLog(int p_i4016_1_) {
      super(p_i4016_1_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71857_b() {
      return 31;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_71951_J.field_71990_ca;
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      byte var7 = 4;
      int var8 = var7 + 1;
      if(p_71852_1_.func_72904_c(p_71852_2_ - var8, p_71852_3_ - var8, p_71852_4_ - var8, p_71852_2_ + var8, p_71852_3_ + var8, p_71852_4_ + var8)) {
         for(int var9 = -var7; var9 <= var7; ++var9) {
            for(int var10 = -var7; var10 <= var7; ++var10) {
               for(int var11 = -var7; var11 <= var7; ++var11) {
                  int var12 = p_71852_1_.func_72798_a(p_71852_2_ + var9, p_71852_3_ + var10, p_71852_4_ + var11);
                  if(var12 == Block.field_71952_K.field_71990_ca) {
                     int var13 = p_71852_1_.func_72805_g(p_71852_2_ + var9, p_71852_3_ + var10, p_71852_4_ + var11);
                     if((var13 & 8) == 0) {
                        p_71852_1_.func_72921_c(p_71852_2_ + var9, p_71852_3_ + var10, p_71852_4_ + var11, var13 | 8, 4);
                     }
                  }
               }
            }
         }
      }

   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      int var10 = p_85104_9_ & 3;
      byte var11 = 0;
      switch(p_85104_5_) {
      case 0:
      case 1:
         var11 = 0;
         break;
      case 2:
      case 3:
         var11 = 8;
         break;
      case 4:
      case 5:
         var11 = 4;
      }

      return var10 | var11;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      int var3 = p_71858_2_ & 12;
      int var4 = p_71858_2_ & 3;
      return var3 == 0 && (p_71858_1_ == 1 || p_71858_1_ == 0)?this.field_94388_cO:(var3 == 4 && (p_71858_1_ == 5 || p_71858_1_ == 4)?this.field_94388_cO:(var3 == 8 && (p_71858_1_ == 2 || p_71858_1_ == 3)?this.field_94388_cO:this.field_94390_c[var4]));
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_ & 3;
   }

   public static int func_72141_e(int p_72141_0_) {
      return p_72141_0_ & 3;
   }

   @SideOnly(Side.CLIENT)
   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 3));
   }

   protected ItemStack func_71880_c_(int p_71880_1_) {
      return new ItemStack(this.field_71990_ca, 1, func_72141_e(p_71880_1_));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94388_cO = p_94332_1_.func_94245_a("tree_top");
      this.field_94390_c = new Icon[field_94389_b.length];

      for(int var2 = 0; var2 < this.field_94390_c.length; ++var2) {
         this.field_94390_c[var2] = p_94332_1_.func_94245_a(field_94389_b[var2]);
      }

   }

}
