package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLogic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneRepeater extends BlockRedstoneLogic {

   public static final double[] field_72223_a = new double[]{-0.0625D, 0.0625D, 0.1875D, 0.3125D};
   private static final int[] field_72221_b = new int[]{1, 2, 3, 4};


   protected BlockRedstoneRepeater(int p_i3934_1_, boolean p_i3934_2_) {
      super(p_i3934_1_, p_i3934_2_);
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
      int var11 = (var10 & 12) >> 2;
      var11 = var11 + 1 << 2 & 12;
      p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, var11 | var10 & 3, 3);
      return true;
   }

   protected int func_94481_j_(int p_94481_1_) {
      return field_72221_b[(p_94481_1_ & 12) >> 2] * 2;
   }

   protected BlockRedstoneLogic func_94485_e() {
      return Block.field_72011_bi;
   }

   protected BlockRedstoneLogic func_94484_i() {
      return Block.field_72010_bh;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77742_bb.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77742_bb.field_77779_bT;
   }

   public int func_71857_b() {
      return 15;
   }

   public boolean func_94476_e(IBlockAccess p_94476_1_, int p_94476_2_, int p_94476_3_, int p_94476_4_, int p_94476_5_) {
      return this.func_94482_f(p_94476_1_, p_94476_2_, p_94476_3_, p_94476_4_, p_94476_5_) > 0;
   }

   protected boolean func_94477_d(int p_94477_1_) {
      return func_82524_c(p_94477_1_);
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      if(this.field_72222_c) {
         int var6 = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
         int var7 = func_72217_d(var6);
         double var8 = (double)((float)p_71862_2_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var10 = (double)((float)p_71862_3_ + 0.4F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var12 = (double)((float)p_71862_4_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         if(p_71862_5_.nextInt(2) == 0) {
            switch(var7) {
            case 0:
               var16 = -0.3125D;
               break;
            case 1:
               var14 = 0.3125D;
               break;
            case 2:
               var16 = 0.3125D;
               break;
            case 3:
               var14 = -0.3125D;
            }
         } else {
            int var18 = (var6 & 12) >> 2;
            switch(var7) {
            case 0:
               var16 = field_72223_a[var18];
               break;
            case 1:
               var14 = -field_72223_a[var18];
               break;
            case 2:
               var16 = -field_72223_a[var18];
               break;
            case 3:
               var14 = field_72223_a[var18];
            }
         }

         p_71862_1_.func_72869_a("reddust", var8 + var14, var10, var12 + var16, 0.0D, 0.0D, 0.0D);
      }
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      this.func_94483_i_(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
   }

}
