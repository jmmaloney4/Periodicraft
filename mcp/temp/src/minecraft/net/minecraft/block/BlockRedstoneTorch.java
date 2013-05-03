package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.RedstoneUpdateInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneTorch extends BlockTorch {

   private boolean field_72130_a = false;
   private static Map field_72129_b = new HashMap();


   private boolean func_72127_a(World p_72127_1_, int p_72127_2_, int p_72127_3_, int p_72127_4_, boolean p_72127_5_) {
      if(!field_72129_b.containsKey(p_72127_1_)) {
         field_72129_b.put(p_72127_1_, new ArrayList());
      }

      List var6 = (List)field_72129_b.get(p_72127_1_);
      if(p_72127_5_) {
         var6.add(new RedstoneUpdateInfo(p_72127_2_, p_72127_3_, p_72127_4_, p_72127_1_.func_82737_E()));
      }

      int var7 = 0;

      for(int var8 = 0; var8 < var6.size(); ++var8) {
         RedstoneUpdateInfo var9 = (RedstoneUpdateInfo)var6.get(var8);
         if(var9.field_73664_a == p_72127_2_ && var9.field_73662_b == p_72127_3_ && var9.field_73663_c == p_72127_4_) {
            ++var7;
            if(var7 >= 8) {
               return true;
            }
         }
      }

      return false;
   }

   protected BlockRedstoneTorch(int p_i9074_1_, boolean p_i9074_2_) {
      super(p_i9074_1_);
      this.field_72130_a = p_i9074_2_;
      this.func_71907_b(true);
      this.func_71849_a((CreativeTabs)null);
   }

   public int func_71859_p_(World p_71859_1_) {
      return 2;
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      if(p_71861_1_.func_72805_g(p_71861_2_, p_71861_3_, p_71861_4_) == 0) {
         super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      }

      if(this.field_72130_a) {
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ - 1, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ + 1, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_ - 1, p_71861_3_, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_ + 1, p_71861_3_, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ - 1, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_, p_71861_4_ + 1, this.field_71990_ca);
      }

   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      if(this.field_72130_a) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
      }

   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      if(!this.field_72130_a) {
         return 0;
      } else {
         int var6 = p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_);
         return var6 == 5 && p_71865_5_ == 1?0:(var6 == 3 && p_71865_5_ == 3?0:(var6 == 4 && p_71865_5_ == 2?0:(var6 == 1 && p_71865_5_ == 5?0:(var6 == 2 && p_71865_5_ == 4?0:15))));
      }
   }

   private boolean func_72128_l(World p_72128_1_, int p_72128_2_, int p_72128_3_, int p_72128_4_) {
      int var5 = p_72128_1_.func_72805_g(p_72128_2_, p_72128_3_, p_72128_4_);
      return var5 == 5 && p_72128_1_.func_94574_k(p_72128_2_, p_72128_3_ - 1, p_72128_4_, 0)?true:(var5 == 3 && p_72128_1_.func_94574_k(p_72128_2_, p_72128_3_, p_72128_4_ - 1, 2)?true:(var5 == 4 && p_72128_1_.func_94574_k(p_72128_2_, p_72128_3_, p_72128_4_ + 1, 3)?true:(var5 == 1 && p_72128_1_.func_94574_k(p_72128_2_ - 1, p_72128_3_, p_72128_4_, 4)?true:var5 == 2 && p_72128_1_.func_94574_k(p_72128_2_ + 1, p_72128_3_, p_72128_4_, 5))));
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      boolean var6 = this.func_72128_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
      List var7 = (List)field_72129_b.get(p_71847_1_);

      while(var7 != null && !var7.isEmpty() && p_71847_1_.func_82737_E() - ((RedstoneUpdateInfo)var7.get(0)).field_73661_d > 60L) {
         var7.remove(0);
      }

      if(this.field_72130_a) {
         if(var6) {
            p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72049_aP.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), 3);
            if(this.func_72127_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, true)) {
               p_71847_1_.func_72908_a((double)((float)p_71847_2_ + 0.5F), (double)((float)p_71847_3_ + 0.5F), (double)((float)p_71847_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_71847_1_.field_73012_v.nextFloat() - p_71847_1_.field_73012_v.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 5; ++var8) {
                  double var9 = (double)p_71847_2_ + p_71847_5_.nextDouble() * 0.6D + 0.2D;
                  double var11 = (double)p_71847_3_ + p_71847_5_.nextDouble() * 0.6D + 0.2D;
                  double var13 = (double)p_71847_4_ + p_71847_5_.nextDouble() * 0.6D + 0.2D;
                  p_71847_1_.func_72869_a("smoke", var9, var11, var13, 0.0D, 0.0D, 0.0D);
               }
            }
         }
      } else if(!var6 && !this.func_72127_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, false)) {
         p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72035_aQ.field_71990_ca, p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_), 3);
      }

   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!this.func_94397_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_)) {
         boolean var6 = this.func_72128_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
         if(this.field_72130_a && var6 || !this.field_72130_a && !var6) {
            p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, this.field_71990_ca, this.func_71859_p_(p_71863_1_));
         }

      }
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return p_71855_5_ == 0?this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_):0;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_72035_aQ.field_71990_ca;
   }

   public boolean func_71853_i() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      if(this.field_72130_a) {
         int var6 = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
         double var7 = (double)((float)p_71862_2_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var9 = (double)((float)p_71862_3_ + 0.7F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var11 = (double)((float)p_71862_4_ + 0.5F) + (double)(p_71862_5_.nextFloat() - 0.5F) * 0.2D;
         double var13 = 0.2199999988079071D;
         double var15 = 0.27000001072883606D;
         if(var6 == 1) {
            p_71862_1_.func_72869_a("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 2) {
            p_71862_1_.func_72869_a("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 3) {
            p_71862_1_.func_72869_a("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 4) {
            p_71862_1_.func_72869_a("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
         } else {
            p_71862_1_.func_72869_a("reddust", var7, var9, var11, 0.0D, 0.0D, 0.0D);
         }

      }
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Block.field_72035_aQ.field_71990_ca;
   }

   public boolean func_94334_h(int p_94334_1_) {
      return p_94334_1_ == Block.field_72049_aP.field_71990_ca || p_94334_1_ == Block.field_72035_aQ.field_71990_ca;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      if(this.field_72130_a) {
         this.field_94336_cN = p_94332_1_.func_94245_a("redtorch_lit");
      } else {
         this.field_94336_cN = p_94332_1_.func_94245_a("redtorch");
      }

   }

}
