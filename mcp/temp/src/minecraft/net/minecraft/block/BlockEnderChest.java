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
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEnderChest extends BlockContainer {

   protected BlockEnderChest(int p_i3942_1_) {
      super(p_i3942_1_, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78031_c);
      this.func_71905_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 22;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72089_ap.field_71990_ca;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 8;
   }

   protected boolean func_71906_q_() {
      return true;
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      byte var7 = 0;
      int var8 = MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
      if(var8 == 0) {
         var7 = 2;
      }

      if(var8 == 1) {
         var7 = 5;
      }

      if(var8 == 2) {
         var7 = 3;
      }

      if(var8 == 3) {
         var7 = 4;
      }

      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 2);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      InventoryEnderChest var10 = p_71903_5_.func_71005_bN();
      TileEntityEnderChest var11 = (TileEntityEnderChest)p_71903_1_.func_72796_p(p_71903_2_, p_71903_3_, p_71903_4_);
      if(var10 != null && var11 != null) {
         if(p_71903_1_.func_72809_s(p_71903_2_, p_71903_3_ + 1, p_71903_4_)) {
            return true;
         } else if(p_71903_1_.field_72995_K) {
            return true;
         } else {
            var10.func_70485_a(var11);
            p_71903_5_.func_71007_a(var10);
            return true;
         }
      } else {
         return true;
      }
   }

   public TileEntity func_72274_a(World p_72274_1_) {
      return new TileEntityEnderChest();
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      for(int var6 = 0; var6 < 3; ++var6) {
         double var10000 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
         double var9 = (double)((float)p_71862_3_ + p_71862_5_.nextFloat());
         var10000 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         int var19 = p_71862_5_.nextInt(2) * 2 - 1;
         int var20 = p_71862_5_.nextInt(2) * 2 - 1;
         var13 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.125D;
         var15 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.125D;
         var17 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.125D;
         double var11 = (double)p_71862_4_ + 0.5D + 0.25D * (double)var20;
         var17 = (double)(p_71862_5_.nextFloat() * 1.0F * (float)var20);
         double var7 = (double)p_71862_2_ + 0.5D + 0.25D * (double)var19;
         var13 = (double)(p_71862_5_.nextFloat() * 1.0F * (float)var19);
         p_71862_1_.func_72869_a("portal", var7, var9, var11, var13, var15, var17);
      }

   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("obsidian");
   }
}
