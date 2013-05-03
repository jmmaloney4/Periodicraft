package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockReed extends Block {

   protected BlockReed(int p_i9087_1_) {
      super(p_i9087_1_, Material.field_76254_j);
      float var2 = 0.375F;
      this.func_71905_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 1.0F, 0.5F + var2);
      this.func_71907_b(true);
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
            } else {
               p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var7 + 1, 4);
            }
         }
      }

   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      int var5 = p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
      return var5 == this.field_71990_ca?true:(var5 != Block.field_71980_u.field_71990_ca && var5 != Block.field_71979_v.field_71990_ca && var5 != Block.field_71939_E.field_71990_ca?false:(p_71930_1_.func_72803_f(p_71930_2_ - 1, p_71930_3_ - 1, p_71930_4_) == Material.field_76244_g?true:(p_71930_1_.func_72803_f(p_71930_2_ + 1, p_71930_3_ - 1, p_71930_4_) == Material.field_76244_g?true:(p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_ - 1) == Material.field_76244_g?true:p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_ + 1) == Material.field_76244_g))));
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      this.func_72167_k_(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
   }

   protected final void func_72167_k_(World p_72167_1_, int p_72167_2_, int p_72167_3_, int p_72167_4_) {
      if(!this.func_71854_d(p_72167_1_, p_72167_2_, p_72167_3_, p_72167_4_)) {
         this.func_71897_c(p_72167_1_, p_72167_2_, p_72167_3_, p_72167_4_, p_72167_1_.func_72805_g(p_72167_2_, p_72167_3_, p_72167_4_), 0);
         p_72167_1_.func_94571_i(p_72167_2_, p_72167_3_, p_72167_4_);
      }

   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      return this.func_71930_b(p_71854_1_, p_71854_2_, p_71854_3_, p_71854_4_);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77758_aJ.field_77779_bT;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77758_aJ.field_77779_bT;
   }
}
