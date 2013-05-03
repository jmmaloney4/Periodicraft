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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStem extends BlockFlower {

   private final Block field_72267_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94369_b;


   protected BlockStem(int p_i3998_1_, Block p_i3998_2_) {
      super(p_i3998_1_);
      this.field_72267_a = p_i3998_2_;
      this.func_71907_b(true);
      float var3 = 0.125F;
      this.func_71905_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
      this.func_71849_a((CreativeTabs)null);
   }

   protected boolean func_72263_d_(int p_72263_1_) {
      return p_72263_1_ == Block.field_72050_aA.field_71990_ca;
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
      if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9) {
         float var6 = this.func_72266_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
         if(p_71847_5_.nextInt((int)(25.0F / var6) + 1) == 0) {
            int var7 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            if(var7 < 7) {
               ++var7;
               p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var7, 2);
            } else {
               if(p_71847_1_.func_72798_a(p_71847_2_ - 1, p_71847_3_, p_71847_4_) == this.field_72267_a.field_71990_ca) {
                  return;
               }

               if(p_71847_1_.func_72798_a(p_71847_2_ + 1, p_71847_3_, p_71847_4_) == this.field_72267_a.field_71990_ca) {
                  return;
               }

               if(p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_ - 1) == this.field_72267_a.field_71990_ca) {
                  return;
               }

               if(p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_ + 1) == this.field_72267_a.field_71990_ca) {
                  return;
               }

               int var8 = p_71847_5_.nextInt(4);
               int var9 = p_71847_2_;
               int var10 = p_71847_4_;
               if(var8 == 0) {
                  var9 = p_71847_2_ - 1;
               }

               if(var8 == 1) {
                  ++var9;
               }

               if(var8 == 2) {
                  var10 = p_71847_4_ - 1;
               }

               if(var8 == 3) {
                  ++var10;
               }

               int var11 = p_71847_1_.func_72798_a(var9, p_71847_3_ - 1, var10);
               if(p_71847_1_.func_72798_a(var9, p_71847_3_, var10) == 0 && (var11 == Block.field_72050_aA.field_71990_ca || var11 == Block.field_71979_v.field_71990_ca || var11 == Block.field_71980_u.field_71990_ca)) {
                  p_71847_1_.func_94575_c(var9, p_71847_3_, var10, this.field_72267_a.field_71990_ca);
               }
            }
         }
      }

   }

   public void func_72264_l(World p_72264_1_, int p_72264_2_, int p_72264_3_, int p_72264_4_) {
      int var5 = p_72264_1_.func_72805_g(p_72264_2_, p_72264_3_, p_72264_4_) + MathHelper.func_76136_a(p_72264_1_.field_73012_v, 2, 5);
      if(var5 > 7) {
         var5 = 7;
      }

      p_72264_1_.func_72921_c(p_72264_2_, p_72264_3_, p_72264_4_, var5, 2);
   }

   private float func_72266_n(World p_72266_1_, int p_72266_2_, int p_72266_3_, int p_72266_4_) {
      float var5 = 1.0F;
      int var6 = p_72266_1_.func_72798_a(p_72266_2_, p_72266_3_, p_72266_4_ - 1);
      int var7 = p_72266_1_.func_72798_a(p_72266_2_, p_72266_3_, p_72266_4_ + 1);
      int var8 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_);
      int var9 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_);
      int var10 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_ - 1);
      int var11 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_ - 1);
      int var12 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_ + 1);
      int var13 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_ + 1);
      boolean var14 = var8 == this.field_71990_ca || var9 == this.field_71990_ca;
      boolean var15 = var6 == this.field_71990_ca || var7 == this.field_71990_ca;
      boolean var16 = var10 == this.field_71990_ca || var11 == this.field_71990_ca || var12 == this.field_71990_ca || var13 == this.field_71990_ca;

      for(int var17 = p_72266_2_ - 1; var17 <= p_72266_2_ + 1; ++var17) {
         for(int var18 = p_72266_4_ - 1; var18 <= p_72266_4_ + 1; ++var18) {
            int var19 = p_72266_1_.func_72798_a(var17, p_72266_3_ - 1, var18);
            float var20 = 0.0F;
            if(var19 == Block.field_72050_aA.field_71990_ca) {
               var20 = 1.0F;
               if(p_72266_1_.func_72805_g(var17, p_72266_3_ - 1, var18) > 0) {
                  var20 = 3.0F;
               }
            }

            if(var17 != p_72266_2_ || var18 != p_72266_4_) {
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
   public int func_71889_f_(int p_71889_1_) {
      int var2 = p_71889_1_ * 32;
      int var3 = 255 - p_71889_1_ * 8;
      int var4 = p_71889_1_ * 4;
      return var2 << 16 | var3 << 8 | var4;
   }

   @SideOnly(Side.CLIENT)
   public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_) {
      return this.func_71889_f_(p_71920_1_.func_72805_g(p_71920_2_, p_71920_3_, p_71920_4_));
   }

   public void func_71919_f() {
      float var1 = 0.125F;
      this.func_71905_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      this.field_72022_cl = (double)((float)(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) * 2 + 2) / 16.0F);
      float var5 = 0.125F;
      this.func_71905_a(0.5F - var5, 0.0F, 0.5F - var5, 0.5F + var5, (float)this.field_72022_cl, 0.5F + var5);
   }

   public int func_71857_b() {
      return 19;
   }

   @SideOnly(Side.CLIENT)
   public int func_72265_d(IBlockAccess p_72265_1_, int p_72265_2_, int p_72265_3_, int p_72265_4_) {
      int var5 = p_72265_1_.func_72805_g(p_72265_2_, p_72265_3_, p_72265_4_);
      return var5 < 7?-1:(p_72265_1_.func_72798_a(p_72265_2_ - 1, p_72265_3_, p_72265_4_) == this.field_72267_a.field_71990_ca?0:(p_72265_1_.func_72798_a(p_72265_2_ + 1, p_72265_3_, p_72265_4_) == this.field_72267_a.field_71990_ca?1:(p_72265_1_.func_72798_a(p_72265_2_, p_72265_3_, p_72265_4_ - 1) == this.field_72267_a.field_71990_ca?2:(p_72265_1_.func_72798_a(p_72265_2_, p_72265_3_, p_72265_4_ + 1) == this.field_72267_a.field_71990_ca?3:-1))));
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);
      if(!p_71914_1_.field_72995_K) {
         Item var8 = null;
         if(this.field_72267_a == Block.field_72061_ba) {
            var8 = Item.field_77739_bg;
         }

         if(this.field_72267_a == Block.field_71997_br) {
            var8 = Item.field_77740_bh;
         }

         for(int var9 = 0; var9 < 3; ++var9) {
            if(p_71914_1_.field_73012_v.nextInt(15) <= p_71914_5_) {
               this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(var8));
            }
         }

      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return -1;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return this.field_72267_a == Block.field_72061_ba?Item.field_77739_bg.field_77779_bT:(this.field_72267_a == Block.field_71997_br?Item.field_77740_bh.field_77779_bT:0);
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a("stem_straight");
      this.field_94369_b = p_94332_1_.func_94245_a("stem_bent");
   }

   @SideOnly(Side.CLIENT)
   public Icon func_94368_p() {
      return this.field_94369_b;
   }
}
