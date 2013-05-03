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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCrops extends BlockFlower {

   @SideOnly(Side.CLIENT)
   private Icon[] field_94363_a;


   protected BlockCrops(int p_i9048_1_) {
      super(p_i9048_1_);
      this.func_71907_b(true);
      float var2 = 0.5F;
      this.func_71905_a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.func_71849_a((CreativeTabs)null);
      this.func_71848_c(0.0F);
      this.func_71884_a(field_71965_g);
      this.func_71896_v();
   }

   protected boolean func_72263_d_(int p_72263_1_) {
      return p_72263_1_ == Block.field_72050_aA.field_71990_ca;
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
      if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9) {
         int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
         if(var6 < 7) {
            float var7 = this.func_72273_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
            if(p_71847_5_.nextInt((int)(25.0F / var7) + 1) == 0) {
               ++var6;
               p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var6, 2);
            }
         }
      }

   }

   public void func_72272_c_(World p_72272_1_, int p_72272_2_, int p_72272_3_, int p_72272_4_) {
      int var5 = p_72272_1_.func_72805_g(p_72272_2_, p_72272_3_, p_72272_4_) + MathHelper.func_76136_a(p_72272_1_.field_73012_v, 2, 5);
      if(var5 > 7) {
         var5 = 7;
      }

      p_72272_1_.func_72921_c(p_72272_2_, p_72272_3_, p_72272_4_, var5, 2);
   }

   private float func_72273_l(World p_72273_1_, int p_72273_2_, int p_72273_3_, int p_72273_4_) {
      float var5 = 1.0F;
      int var6 = p_72273_1_.func_72798_a(p_72273_2_, p_72273_3_, p_72273_4_ - 1);
      int var7 = p_72273_1_.func_72798_a(p_72273_2_, p_72273_3_, p_72273_4_ + 1);
      int var8 = p_72273_1_.func_72798_a(p_72273_2_ - 1, p_72273_3_, p_72273_4_);
      int var9 = p_72273_1_.func_72798_a(p_72273_2_ + 1, p_72273_3_, p_72273_4_);
      int var10 = p_72273_1_.func_72798_a(p_72273_2_ - 1, p_72273_3_, p_72273_4_ - 1);
      int var11 = p_72273_1_.func_72798_a(p_72273_2_ + 1, p_72273_3_, p_72273_4_ - 1);
      int var12 = p_72273_1_.func_72798_a(p_72273_2_ + 1, p_72273_3_, p_72273_4_ + 1);
      int var13 = p_72273_1_.func_72798_a(p_72273_2_ - 1, p_72273_3_, p_72273_4_ + 1);
      boolean var14 = var8 == this.field_71990_ca || var9 == this.field_71990_ca;
      boolean var15 = var6 == this.field_71990_ca || var7 == this.field_71990_ca;
      boolean var16 = var10 == this.field_71990_ca || var11 == this.field_71990_ca || var12 == this.field_71990_ca || var13 == this.field_71990_ca;

      for(int var17 = p_72273_2_ - 1; var17 <= p_72273_2_ + 1; ++var17) {
         for(int var18 = p_72273_4_ - 1; var18 <= p_72273_4_ + 1; ++var18) {
            int var19 = p_72273_1_.func_72798_a(var17, p_72273_3_ - 1, var18);
            float var20 = 0.0F;
            if(var19 == Block.field_72050_aA.field_71990_ca) {
               var20 = 1.0F;
               if(p_72273_1_.func_72805_g(var17, p_72273_3_ - 1, var18) > 0) {
                  var20 = 3.0F;
               }
            }

            if(var17 != p_72273_2_ || var18 != p_72273_4_) {
               var20 /= 4.0F;
            }

            var5 += var20;
         }
      }

      if(var16 || var14 && var15) {
         var5 /= 2.0F;
      }

      return var5;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_2_ < 0 || p_71858_2_ > 7) {
         p_71858_2_ = 7;
      }

      return this.field_94363_a[p_71858_2_];
   }

   public int func_71857_b() {
      return 6;
   }

   protected int func_82532_h() {
      return Item.field_77690_S.field_77779_bT;
   }

   protected int func_82533_j() {
      return Item.field_77685_T.field_77779_bT;
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, 0);
      if(!p_71914_1_.field_72995_K) {
         if(p_71914_5_ >= 7) {
            int var8 = 3 + p_71914_7_;

            for(int var9 = 0; var9 < var8; ++var9) {
               if(p_71914_1_.field_73012_v.nextInt(15) <= p_71914_5_) {
                  this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(this.func_82532_h(), 1, 0));
               }
            }
         }

      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return p_71885_1_ == 7?this.func_82533_j():this.func_82532_h();
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return this.func_82532_h();
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94363_a = new Icon[8];

      for(int var2 = 0; var2 < this.field_94363_a.length; ++var2) {
         this.field_94363_a[var2] = p_94332_1_.func_94245_a("crops_" + var2);
      }

   }
}
