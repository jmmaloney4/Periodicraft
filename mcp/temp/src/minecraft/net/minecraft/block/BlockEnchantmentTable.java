package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends BlockContainer {

   @SideOnly(Side.CLIENT)
   private Icon field_94461_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94460_b;


   protected BlockEnchantmentTable(int p_i3941_1_) {
      super(p_i3941_1_, Material.field_76246_e);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.func_71868_h(0);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public boolean func_71886_c() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      super.func_71862_a(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_, p_71862_5_);

      for(int var6 = p_71862_2_ - 2; var6 <= p_71862_2_ + 2; ++var6) {
         for(int var7 = p_71862_4_ - 2; var7 <= p_71862_4_ + 2; ++var7) {
            if(var6 > p_71862_2_ - 2 && var6 < p_71862_2_ + 2 && var7 == p_71862_4_ - 1) {
               var7 = p_71862_4_ + 2;
            }

            if(p_71862_5_.nextInt(16) == 0) {
               for(int var8 = p_71862_3_; var8 <= p_71862_3_ + 1; ++var8) {
                  if(p_71862_1_.func_72798_a(var6, var8, var7) == Block.field_72093_an.field_71990_ca) {
                     if(!p_71862_1_.func_72799_c((var6 - p_71862_2_) / 2 + p_71862_2_, var8, (var7 - p_71862_4_) / 2 + p_71862_4_)) {
                        break;
                     }

                     p_71862_1_.func_72869_a("enchantmenttable", (double)p_71862_2_ + 0.5D, (double)p_71862_3_ + 2.0D, (double)p_71862_4_ + 0.5D, (double)((float)(var6 - p_71862_2_) + p_71862_5_.nextFloat()) - 0.5D, (double)((float)(var8 - p_71862_3_) - p_71862_5_.nextFloat() - 1.0F), (double)((float)(var7 - p_71862_4_) + p_71862_5_.nextFloat()) - 0.5D);
                  }
               }
            }
         }
      }

   }

   public boolean func_71926_d() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 0?this.field_94460_b:(p_71858_1_ == 1?this.field_94461_a:this.field_94336_cN);
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityEnchantmentTable();
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         TileEntityEnchantmentTable var10 = (TileEntityEnchantmentTable)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
         p_71903_5_.func_71002_c(p_71903_2_, p_71903_3_, p_71903_4_, var10.func_94135_b()?var10.func_94133_a():null);
         return true;
      }
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      super.func_71860_a(p_71860_1_, p_71860_2_, p_71860_3_, p_71860_4_, p_71860_5_, p_71860_6_);
      if(p_71860_6_.func_82837_s()) {
         ((TileEntityEnchantmentTable)p_71860_1_.func_72796_p(p_71860_2_, p_71860_3_, p_71860_4_)).func_94134_a(p_71860_6_.func_82833_r());
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("enchantment_side");
      this.field_94461_a = p_94332_1_.func_94245_a("enchantment_top");
      this.field_94460_b = p_94332_1_.func_94245_a("enchantment_bottom");
   }
}
