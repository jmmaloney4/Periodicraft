package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCake extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94383_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94381_b;
   @SideOnly(Side.CLIENT)
   private Icon field_94382_c;


   protected BlockCake(int p_i9044_1_) {
      super(p_i9044_1_, Material.field_76238_C);
      this.func_71907_b(true);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var5 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      this.func_71905_a(var7, 0.0F, var6, 1.0F - var6, var8, 1.0F - var6);
   }

   public void func_71919_f() {
      float var1 = 0.0625F;
      float var2 = 0.5F;
      this.func_71905_a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      int var5 = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      return AxisAlignedBB.func_72332_a().func_72299_a((double)((float)p_71872_2_ + var7), (double)p_71872_3_, (double)((float)p_71872_4_ + var6), (double)((float)(p_71872_2_ + 1) - var6), (double)((float)p_71872_3_ + var8 - var6), (double)((float)(p_71872_4_ + 1) - var6));
   }

   public boolean func_71886_c() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_) {
      int var5 = p_71911_1_.func_72805_g(p_71911_2_, p_71911_3_, p_71911_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      return AxisAlignedBB.func_72332_a().func_72299_a((double)((float)p_71911_2_ + var7), (double)p_71911_3_, (double)((float)p_71911_4_ + var6), (double)((float)(p_71911_2_ + 1) - var6), (double)((float)p_71911_3_ + var8), (double)((float)(p_71911_4_ + 1) - var6));
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?this.field_94383_a:(p_71858_1_ == 0?this.field_94381_b:(p_71858_2_ > 0 && p_71858_1_ == 4?this.field_94382_c:this.field_94336_cN));
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("cake_side");
      this.field_94382_c = p_94332_1_.func_94245_a("cake_inner");
      this.field_94383_a = p_94332_1_.func_94245_a("cake_top");
      this.field_94381_b = p_94332_1_.func_94245_a("cake_bottom");
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      this.func_72259_b(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_);
      return true;
   }

   public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_) {
      this.func_72259_b(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_);
   }

   private void func_72259_b(World p_72259_1_, int p_72259_2_, int p_72259_3_, int p_72259_4_, EntityPlayer p_72259_5_) {
      if(p_72259_5_.func_71043_e(false)) {
         p_72259_5_.func_71024_bL().func_75122_a(2, 0.1F);
         int var6 = p_72259_1_.func_72805_g(p_72259_2_, p_72259_3_, p_72259_4_) + 1;
         if(var6 >= 6) {
            p_72259_1_.func_94571_i(p_72259_2_, p_72259_3_, p_72259_4_);
         } else {
            p_72259_1_.func_72921_c(p_72259_2_, p_72259_3_, p_72259_4_, var6, 2);
         }
      }

   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return !super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_)?false:this.func_71854_d(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!this.func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      return p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_ - 1, p_71854_4_).func_76220_a();
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return 0;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77746_aZ.field_77779_bT;
   }
}
