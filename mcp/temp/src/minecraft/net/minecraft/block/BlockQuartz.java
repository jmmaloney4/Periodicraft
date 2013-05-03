package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockQuartz extends Block {

   public static final String[] field_94420_a = new String[]{"default", "chiseled", "lines"};
   private static final String[] field_94418_b = new String[]{"quartzblock_side", "quartzblock_chiseled", "quartzblock_lines", null, null};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94419_c;
   @SideOnly(Side.CLIENT)
   private Icon field_94414_cO;
   @SideOnly(Side.CLIENT)
   private Icon field_94415_cP;
   @SideOnly(Side.CLIENT)
   private Icon field_94416_cQ;
   @SideOnly(Side.CLIENT)
   private Icon field_94417_cR;


   public BlockQuartz(int p_i9082_1_) {
      super(p_i9082_1_, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_2_ != 2 && p_71858_2_ != 3 && p_71858_2_ != 4) {
         if(p_71858_1_ != 1 && (p_71858_1_ != 0 || p_71858_2_ != 1)) {
            if(p_71858_1_ == 0) {
               return this.field_94417_cR;
            } else {
               if(p_71858_2_ < 0 || p_71858_2_ >= this.field_94419_c.length) {
                  p_71858_2_ = 0;
               }

               return this.field_94419_c[p_71858_2_];
            }
         } else {
            return p_71858_2_ == 1?this.field_94414_cO:this.field_94416_cQ;
         }
      } else {
         return p_71858_2_ == 2 && (p_71858_1_ == 1 || p_71858_1_ == 0)?this.field_94415_cP:(p_71858_2_ == 3 && (p_71858_1_ == 5 || p_71858_1_ == 4)?this.field_94415_cP:(p_71858_2_ == 4 && (p_71858_1_ == 2 || p_71858_1_ == 3)?this.field_94415_cP:this.field_94419_c[p_71858_2_]));
      }
   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      if(p_85104_9_ == 2) {
         switch(p_85104_5_) {
         case 0:
         case 1:
            p_85104_9_ = 2;
            break;
         case 2:
         case 3:
            p_85104_9_ = 4;
            break;
         case 4:
         case 5:
            p_85104_9_ = 3;
         }
      }

      return p_85104_9_;
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_ != 3 && p_71899_1_ != 4?p_71899_1_:2;
   }

   protected ItemStack func_71880_c_(int p_71880_1_) {
      return p_71880_1_ != 3 && p_71880_1_ != 4?super.func_71880_c_(p_71880_1_):new ItemStack(this.field_71990_ca, 1, 2);
   }

   public int func_71857_b() {
      return 39;
   }

   @SideOnly(Side.CLIENT)
   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94419_c = new Icon[field_94418_b.length];

      for(int var2 = 0; var2 < this.field_94419_c.length; ++var2) {
         if(field_94418_b[var2] == null) {
            this.field_94419_c[var2] = this.field_94419_c[var2 - 1];
         } else {
            this.field_94419_c[var2] = p_94332_1_.func_94245_a(field_94418_b[var2]);
         }
      }

      this.field_94416_cQ = p_94332_1_.func_94245_a("quartzblock_top");
      this.field_94414_cO = p_94332_1_.func_94245_a("quartzblock_chiseled_top");
      this.field_94415_cP = p_94332_1_.func_94245_a("quartzblock_lines_top");
      this.field_94417_cR = p_94332_1_.func_94245_a("quartzblock_bottom");
   }

}
