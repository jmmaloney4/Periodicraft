package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockEndPortalFrame extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94400_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94399_b;


   public BlockEndPortalFrame(int p_i4004_1_) {
      super(p_i4004_1_, Material.field_76246_e);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94400_a:(p_71858_1_ == 0?Block.field_72082_bJ.func_71851_a(p_71858_1_):this.field_94336_cN);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("endframe_side");
      this.field_94400_a = p_94332_1_.func_94245_a("endframe_top");
      this.field_94399_b = p_94332_1_.func_94245_a("endframe_eye");
   }

   @SideOnly(Side.CLIENT)
   public Icon func_94398_p() {
      return this.field_94399_b;
   }

   public boolean func_71926_d() {
      return false;
   }

   public int func_71857_b() {
      return 26;
   }

   public void func_71919_f() {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_) {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      int var8 = p_71871_1_.func_72805_g(p_71871_2_, p_71871_3_, p_71871_4_);
      if(func_72165_e(var8)) {
         this.func_71905_a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
      }

      this.func_71919_f();
   }

   public static boolean func_72165_e(int p_72165_0_) {
      return (p_72165_0_ & 4) != 0;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return 0;
   }

   public void func_71860_a(World p_71860_1_, int p_71860_2_, int p_71860_3_, int p_71860_4_, EntityLiving p_71860_5_, ItemStack p_71860_6_) {
      int var7 = ((MathHelper.func_76128_c((double)(p_71860_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
      p_71860_1_.func_72921_c(p_71860_2_, p_71860_3_, p_71860_4_, var7, 2);
   }
}
