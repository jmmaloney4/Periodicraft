package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockNetherStalk extends BlockFlower {

   private static final String[] field_94373_a = new String[]{"netherStalk_0", "netherStalk_1", "netherStalk_2"};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94372_b;


   protected BlockNetherStalk(int p_i3974_1_) {
      super(p_i3974_1_);
      this.func_71907_b(true);
      float var2 = 0.5F;
      this.func_71905_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.func_71849_a((CreativeTabs)null);
   }

   protected boolean func_72263_d_(int p_72263_1_) {
      return p_72263_1_ == Block.field_72013_bc.field_71990_ca;
   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      return this.func_72263_d_(p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_));
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
      if(var6 < 3 && p_71847_5_.nextInt(10) == 0) {
         ++var6;
         p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var6, 2);
      }

      super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_2_ >= 3?this.field_94372_b[2]:(p_71858_2_ > 0?this.field_94372_b[1]:this.field_94372_b[0]);
   }

   public int func_71857_b() {
      return 6;
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      if(!p_71914_1_.field_72995_K) {
         int var8 = 1;
         if(p_71914_5_ >= 3) {
            var8 = 2 + p_71914_1_.field_73012_v.nextInt(3);
            if(p_71914_7_ > 0) {
               var8 += p_71914_1_.field_73012_v.nextInt(p_71914_7_ + 1);
            }
         }

         for(int var9 = 0; var9 < var8; ++var9) {
            this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(Item.field_77727_br));
         }

      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return 0;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77727_br.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94372_b = new Icon[field_94373_a.length];

      for(int var2 = 0; var2 < this.field_94372_b.length; ++var2) {
         this.field_94372_b[var2] = p_94332_1_.func_94245_a(field_94373_a[var2]);
      }

   }

}
