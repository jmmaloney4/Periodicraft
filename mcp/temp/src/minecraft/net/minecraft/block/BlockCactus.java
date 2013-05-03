package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCactus extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94380_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94379_b;


   protected BlockCactus(int p_i9043_1_) {
      super(p_i9043_1_, Material.field_76268_x);
      this.func_71907_b(true);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_)) {
         int var6;
         for(var6 = 1; p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - var6, p_71847_4_) == this.field_71990_ca; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            if(var7 == 15) {
               p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_, this.field_71990_ca);
               p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, 0, 4);
               this.func_71863_a(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_, this.field_71990_ca);
            } else {
               p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var7 + 1, 4);
            }
         }
      }

   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      float var5 = 0.0625F;
      return AxisAlignedBB.func_72332_a().func_72299_a((double)((float)p_71872_2_ + var5), (double)p_71872_3_, (double)((float)p_71872_4_ + var5), (double)((float)(p_71872_2_ + 1) - var5), (double)((float)(p_71872_3_ + 1) - var5), (double)((float)(p_71872_4_ + 1) - var5));
   }

   public boolean func_71886_c() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_) {
      float var5 = 0.0625F;
      return AxisAlignedBB.func_72332_a().func_72299_a((double)((float)p_71911_2_ + var5), (double)p_71911_3_, (double)((float)p_71911_4_ + var5), (double)((float)(p_71911_2_ + 1) - var5), (double)(p_71911_3_ + 1), (double)((float)(p_71911_4_ + 1) - var5));
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94380_a:(p_71858_1_ == 0?this.field_94379_b:this.field_94336_cN);
   }

   public boolean func_71926_d() {
      return false;
   }

   public int func_71857_b() {
      return 13;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return !super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_)?false:this.func_71854_d(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!this.func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         p_71863_1_.func_94578_a(p_71863_2_, p_71863_3_, p_71863_4_, true);
      }

   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      if(p_71854_1_.func_72803_f(p_71854_2_ - 1, p_71854_3_, p_71854_4_).func_76220_a()) {
         return false;
      } else if(p_71854_1_.func_72803_f(p_71854_2_ + 1, p_71854_3_, p_71854_4_).func_76220_a()) {
         return false;
      } else if(p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_, p_71854_4_ - 1).func_76220_a()) {
         return false;
      } else if(p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_, p_71854_4_ + 1).func_76220_a()) {
         return false;
      } else {
         int var5 = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_);
         return var5 == Block.field_72038_aV.field_71990_ca || var5 == Block.field_71939_E.field_71990_ca;
      }
   }

   public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_) {
      p_71869_5_.func_70097_a(DamageSource.field_76367_g, 1);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("cactus_side");
      this.field_94380_a = p_94332_1_.func_94245_a("cactus_top");
      this.field_94379_b = p_94332_1_.func_94245_a("cactus_bottom");
   }
}
