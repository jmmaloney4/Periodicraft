package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVine extends Block {

   public BlockVine(int p_i4019_1_) {
      super(p_i4019_1_, Material.field_76255_k);
      this.func_71907_b(true);
      this.func_71849_a(CreativeTabs.field_78031_c);
   }

   public void func_71919_f() {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int func_71857_b() {
      return 20;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      int var6 = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
      float var7 = 1.0F;
      float var8 = 1.0F;
      float var9 = 1.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      boolean var13 = var6 > 0;
      if((var6 & 2) != 0) {
         var10 = Math.max(var10, 0.0625F);
         var7 = 0.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
         var13 = true;
      }

      if((var6 & 8) != 0) {
         var7 = Math.min(var7, 0.9375F);
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
         var13 = true;
      }

      if((var6 & 4) != 0) {
         var12 = Math.max(var12, 0.0625F);
         var9 = 0.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var13 = true;
      }

      if((var6 & 1) != 0) {
         var9 = Math.min(var9, 0.9375F);
         var12 = 1.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var8 = 0.0F;
         var11 = 1.0F;
         var13 = true;
      }

      if(!var13 && this.func_72151_e(p_71902_1_.func_72798_a(p_71902_2_, p_71902_3_ + 1, p_71902_4_))) {
         var8 = Math.min(var8, 0.9375F);
         var11 = 1.0F;
         var7 = 0.0F;
         var10 = 1.0F;
         var9 = 0.0F;
         var12 = 1.0F;
      }

      this.func_71905_a(var7, var8, var9, var10, var11, var12);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int p_71850_4_, int p_71850_5_) {
      switch(p_71850_5_) {
      case 1:
         return this.func_72151_e(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_ + 1, p_71850_4_));
      case 2:
         return this.func_72151_e(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_, p_71850_4_ + 1));
      case 3:
         return this.func_72151_e(p_71850_1_.func_72798_a(p_71850_2_, p_71850_3_, p_71850_4_ - 1));
      case 4:
         return this.func_72151_e(p_71850_1_.func_72798_a(p_71850_2_ + 1, p_71850_3_, p_71850_4_));
      case 5:
         return this.func_72151_e(p_71850_1_.func_72798_a(p_71850_2_ - 1, p_71850_3_, p_71850_4_));
      default:
         return false;
      }
   }

   private boolean func_72151_e(int p_72151_1_) {
      if(p_72151_1_ == 0) {
         return false;
      } else {
         Block var2 = Block.field_71973_m[p_72151_1_];
         return var2.func_71886_c() && var2.field_72018_cp.func_76230_c();
      }
   }

   private boolean func_72150_l(World p_72150_1_, int p_72150_2_, int p_72150_3_, int p_72150_4_) {
      int var5 = p_72150_1_.func_72805_g(p_72150_2_, p_72150_3_, p_72150_4_);
      int var6 = var5;
      if(var5 > 0) {
         for(int var7 = 0; var7 <= 3; ++var7) {
            int var8 = 1 << var7;
            if((var5 & var8) != 0 && !this.func_72151_e(p_72150_1_.func_72798_a(p_72150_2_ + Direction.field_71583_a[var7], p_72150_3_, p_72150_4_ + Direction.field_71581_b[var7])) && (p_72150_1_.func_72798_a(p_72150_2_, p_72150_3_ + 1, p_72150_4_) != this.field_71990_ca || (p_72150_1_.func_72805_g(p_72150_2_, p_72150_3_ + 1, p_72150_4_) & var8) == 0)) {
               var6 &= ~var8;
            }
         }
      }

      if(var6 == 0 && !this.func_72151_e(p_72150_1_.func_72798_a(p_72150_2_, p_72150_3_ + 1, p_72150_4_))) {
         return false;
      } else {
         if(var6 != var5) {
            p_72150_1_.func_72921_c(p_72150_2_, p_72150_3_, p_72150_4_, var6, 2);
         }

         return true;
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_71933_m() {
      return ColorizerFoliage.func_77468_c();
   }

   @SideOnly(Side.CLIENT)
   public int func_71889_f_(int p_71889_1_) {
      return ColorizerFoliage.func_77468_c();
   }

   @SideOnly(Side.CLIENT)
   public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_) {
      return p_71920_1_.func_72807_a(p_71920_2_, p_71920_4_).func_76726_l();
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K && !this.func_72150_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_)) {
         this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
      }

   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K && p_71847_1_.field_73012_v.nextInt(4) == 0) {
         byte var6 = 4;
         int var7 = 5;
         boolean var8 = false;

         int var9;
         int var10;
         int var11;
         label138:
         for(var9 = p_71847_2_ - var6; var9 <= p_71847_2_ + var6; ++var9) {
            for(var10 = p_71847_4_ - var6; var10 <= p_71847_4_ + var6; ++var10) {
               for(var11 = p_71847_3_ - 1; var11 <= p_71847_3_ + 1; ++var11) {
                  if(p_71847_1_.func_72798_a(var9, var11, var10) == this.field_71990_ca) {
                     --var7;
                     if(var7 <= 0) {
                        var8 = true;
                        break label138;
                     }
                  }
               }
            }
         }

         var9 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
         var10 = p_71847_1_.field_73012_v.nextInt(6);
         var11 = Direction.field_71579_d[var10];
         int var12;
         int var13;
         if(var10 == 1 && p_71847_3_ < 255 && p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_)) {
            if(var8) {
               return;
            }

            var12 = p_71847_1_.field_73012_v.nextInt(16) & var9;
            if(var12 > 0) {
               for(var13 = 0; var13 <= 3; ++var13) {
                  if(!this.func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var13], p_71847_3_ + 1, p_71847_4_ + Direction.field_71581_b[var13]))) {
                     var12 &= ~(1 << var13);
                  }
               }

               if(var12 > 0) {
                  p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_ + 1, p_71847_4_, this.field_71990_ca, var12, 2);
               }
            }
         } else {
            int var14;
            if(var10 >= 2 && var10 <= 5 && (var9 & 1 << var11) == 0) {
               if(var8) {
                  return;
               }

               var12 = p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var11], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11]);
               if(var12 != 0 && Block.field_71973_m[var12] != null) {
                  if(Block.field_71973_m[var12].field_72018_cp.func_76218_k() && Block.field_71973_m[var12].func_71886_c()) {
                     p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var9 | 1 << var11, 2);
                  }
               } else {
                  var13 = var11 + 1 & 3;
                  var14 = var11 + 3 & 3;
                  if((var9 & 1 << var13) != 0 && this.func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var13], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var13]))) {
                     p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[var11], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11], this.field_71990_ca, 1 << var13, 2);
                  } else if((var9 & 1 << var14) != 0 && this.func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var14], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var14]))) {
                     p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[var11], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11], this.field_71990_ca, 1 << var14, 2);
                  } else if((var9 & 1 << var13) != 0 && p_71847_1_.func_72799_c(p_71847_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var13], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var13]) && this.func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var13], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var13]))) {
                     p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var13], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var13], this.field_71990_ca, 1 << (var11 + 2 & 3), 2);
                  } else if((var9 & 1 << var14) != 0 && p_71847_1_.func_72799_c(p_71847_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var14], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var14]) && this.func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var14], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var14]))) {
                     p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[var11] + Direction.field_71583_a[var14], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11] + Direction.field_71581_b[var14], this.field_71990_ca, 1 << (var11 + 2 & 3), 2);
                  } else if(this.func_72151_e(p_71847_1_.func_72798_a(p_71847_2_ + Direction.field_71583_a[var11], p_71847_3_ + 1, p_71847_4_ + Direction.field_71581_b[var11]))) {
                     p_71847_1_.func_72832_d(p_71847_2_ + Direction.field_71583_a[var11], p_71847_3_, p_71847_4_ + Direction.field_71581_b[var11], this.field_71990_ca, 0, 2);
                  }
               }
            } else if(p_71847_3_ > 1) {
               var12 = p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - 1, p_71847_4_);
               if(var12 == 0) {
                  var13 = p_71847_1_.field_73012_v.nextInt(16) & var9;
                  if(var13 > 0) {
                     p_71847_1_.func_72832_d(p_71847_2_, p_71847_3_ - 1, p_71847_4_, this.field_71990_ca, var13, 2);
                  }
               } else if(var12 == this.field_71990_ca) {
                  var13 = p_71847_1_.field_73012_v.nextInt(16) & var9;
                  var14 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_ - 1, p_71847_4_);
                  if(var14 != (var14 | var13)) {
                     p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_ - 1, p_71847_4_, var14 | var13, 2);
                  }
               }
            }
         }
      }

   }

   public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_) {
      byte var10 = 0;
      switch(p_85104_5_) {
      case 2:
         var10 = 1;
         break;
      case 3:
         var10 = 4;
         break;
      case 4:
         var10 = 8;
         break;
      case 5:
         var10 = 2;
      }

      return var10 != 0?var10:p_85104_9_;
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return 0;
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_) {
      if(!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT) {
         p_71893_2_.func_71064_a(StatList.field_75934_C[this.field_71990_ca], 1);
         this.func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71998_bu, 1, 0));
      } else {
         super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
      }

   }
}
