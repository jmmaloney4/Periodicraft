package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneWire extends Block {

   private boolean field_72175_a = true;
   private Set field_72174_b = new HashSet();
   @SideOnly(Side.CLIENT)
   private Icon field_94413_c;
   @SideOnly(Side.CLIENT)
   private Icon field_94410_cO;
   @SideOnly(Side.CLIENT)
   private Icon field_94411_cP;
   @SideOnly(Side.CLIENT)
   private Icon field_94412_cQ;


   public BlockRedstoneWire(int p_i9085_1_) {
      super(p_i9085_1_, Material.field_76265_p);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return null;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   public int func_71857_b() {
      return 5;
   }

   @SideOnly(Side.CLIENT)
   public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_) {
      return 8388608;
   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) || p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_) == Block.field_72014_bd.field_71990_ca;
   }

   private void func_72168_l(World p_72168_1_, int p_72168_2_, int p_72168_3_, int p_72168_4_) {
      this.func_72171_a(p_72168_1_, p_72168_2_, p_72168_3_, p_72168_4_, p_72168_2_, p_72168_3_, p_72168_4_);
      ArrayList var5 = new ArrayList(this.field_72174_b);
      this.field_72174_b.clear();

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         ChunkPosition var7 = (ChunkPosition)var5.get(var6);
         p_72168_1_.func_72898_h(var7.field_76930_a, var7.field_76928_b, var7.field_76929_c, this.field_71990_ca);
      }

   }

   private void func_72171_a(World p_72171_1_, int p_72171_2_, int p_72171_3_, int p_72171_4_, int p_72171_5_, int p_72171_6_, int p_72171_7_) {
      int var8 = p_72171_1_.func_72805_g(p_72171_2_, p_72171_3_, p_72171_4_);
      byte var9 = 0;
      int var15 = this.func_72170_e(p_72171_1_, p_72171_5_, p_72171_6_, p_72171_7_, var9);
      this.field_72175_a = false;
      int var10 = p_72171_1_.func_94572_D(p_72171_2_, p_72171_3_, p_72171_4_);
      this.field_72175_a = true;
      if(var10 > 0 && var10 > var15 - 1) {
         var15 = var10;
      }

      int var11 = 0;

      for(int var12 = 0; var12 < 4; ++var12) {
         int var13 = p_72171_2_;
         int var14 = p_72171_4_;
         if(var12 == 0) {
            var13 = p_72171_2_ - 1;
         }

         if(var12 == 1) {
            ++var13;
         }

         if(var12 == 2) {
            var14 = p_72171_4_ - 1;
         }

         if(var12 == 3) {
            ++var14;
         }

         if(var13 != p_72171_5_ || var14 != p_72171_7_) {
            var11 = this.func_72170_e(p_72171_1_, var13, p_72171_3_, var14, var11);
         }

         if(p_72171_1_.func_72809_s(var13, p_72171_3_, var14) && !p_72171_1_.func_72809_s(p_72171_2_, p_72171_3_ + 1, p_72171_4_)) {
            if((var13 != p_72171_5_ || var14 != p_72171_7_) && p_72171_3_ >= p_72171_6_) {
               var11 = this.func_72170_e(p_72171_1_, var13, p_72171_3_ + 1, var14, var11);
            }
         } else if(!p_72171_1_.func_72809_s(var13, p_72171_3_, var14) && (var13 != p_72171_5_ || var14 != p_72171_7_) && p_72171_3_ <= p_72171_6_) {
            var11 = this.func_72170_e(p_72171_1_, var13, p_72171_3_ - 1, var14, var11);
         }
      }

      if(var11 > var15) {
         var15 = var11 - 1;
      } else if(var15 > 0) {
         --var15;
      } else {
         var15 = 0;
      }

      if(var10 > var15 - 1) {
         var15 = var10;
      }

      if(var8 != var15) {
         p_72171_1_.func_72921_c(p_72171_2_, p_72171_3_, p_72171_4_, var15, 2);
         this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_, p_72171_4_));
         this.field_72174_b.add(new ChunkPosition(p_72171_2_ - 1, p_72171_3_, p_72171_4_));
         this.field_72174_b.add(new ChunkPosition(p_72171_2_ + 1, p_72171_3_, p_72171_4_));
         this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_ - 1, p_72171_4_));
         this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_ + 1, p_72171_4_));
         this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_, p_72171_4_ - 1));
         this.field_72174_b.add(new ChunkPosition(p_72171_2_, p_72171_3_, p_72171_4_ + 1));
      }

   }

   private void func_72172_n(World p_72172_1_, int p_72172_2_, int p_72172_3_, int p_72172_4_) {
      if(p_72172_1_.func_72798_a(p_72172_2_, p_72172_3_, p_72172_4_) == this.field_71990_ca) {
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_ - 1, p_72172_3_, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_ + 1, p_72172_3_, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_, p_72172_4_ - 1, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_, p_72172_4_ + 1, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_ - 1, p_72172_4_, this.field_71990_ca);
         p_72172_1_.func_72898_h(p_72172_2_, p_72172_3_ + 1, p_72172_4_, this.field_71990_ca);
      }
   }

   public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_) {
      super.func_71861_g(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
      if(!p_71861_1_.field_72995_K) {
         this.func_72168_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ + 1, p_71861_4_, this.field_71990_ca);
         p_71861_1_.func_72898_h(p_71861_2_, p_71861_3_ - 1, p_71861_4_, this.field_71990_ca);
         this.func_72172_n(p_71861_1_, p_71861_2_ - 1, p_71861_3_, p_71861_4_);
         this.func_72172_n(p_71861_1_, p_71861_2_ + 1, p_71861_3_, p_71861_4_);
         this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ - 1);
         this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_ + 1);
         if(p_71861_1_.func_72809_s(p_71861_2_ - 1, p_71861_3_, p_71861_4_)) {
            this.func_72172_n(p_71861_1_, p_71861_2_ - 1, p_71861_3_ + 1, p_71861_4_);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_ - 1, p_71861_3_ - 1, p_71861_4_);
         }

         if(p_71861_1_.func_72809_s(p_71861_2_ + 1, p_71861_3_, p_71861_4_)) {
            this.func_72172_n(p_71861_1_, p_71861_2_ + 1, p_71861_3_ + 1, p_71861_4_);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_ + 1, p_71861_3_ - 1, p_71861_4_);
         }

         if(p_71861_1_.func_72809_s(p_71861_2_, p_71861_3_, p_71861_4_ - 1)) {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ + 1, p_71861_4_ - 1);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ - 1, p_71861_4_ - 1);
         }

         if(p_71861_1_.func_72809_s(p_71861_2_, p_71861_3_, p_71861_4_ + 1)) {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ + 1, p_71861_4_ + 1);
         } else {
            this.func_72172_n(p_71861_1_, p_71861_2_, p_71861_3_ - 1, p_71861_4_ + 1);
         }

      }
   }

   public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_) {
      super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
      if(!p_71852_1_.field_72995_K) {
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ + 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_ - 1, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ + 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_ - 1, p_71852_3_, p_71852_4_, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ + 1, this.field_71990_ca);
         p_71852_1_.func_72898_h(p_71852_2_, p_71852_3_, p_71852_4_ - 1, this.field_71990_ca);
         this.func_72168_l(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_);
         this.func_72172_n(p_71852_1_, p_71852_2_ - 1, p_71852_3_, p_71852_4_);
         this.func_72172_n(p_71852_1_, p_71852_2_ + 1, p_71852_3_, p_71852_4_);
         this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_ - 1);
         this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_ + 1);
         if(p_71852_1_.func_72809_s(p_71852_2_ - 1, p_71852_3_, p_71852_4_)) {
            this.func_72172_n(p_71852_1_, p_71852_2_ - 1, p_71852_3_ + 1, p_71852_4_);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_ - 1, p_71852_3_ - 1, p_71852_4_);
         }

         if(p_71852_1_.func_72809_s(p_71852_2_ + 1, p_71852_3_, p_71852_4_)) {
            this.func_72172_n(p_71852_1_, p_71852_2_ + 1, p_71852_3_ + 1, p_71852_4_);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_ + 1, p_71852_3_ - 1, p_71852_4_);
         }

         if(p_71852_1_.func_72809_s(p_71852_2_, p_71852_3_, p_71852_4_ - 1)) {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ + 1, p_71852_4_ - 1);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ - 1, p_71852_4_ - 1);
         }

         if(p_71852_1_.func_72809_s(p_71852_2_, p_71852_3_, p_71852_4_ + 1)) {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ + 1, p_71852_4_ + 1);
         } else {
            this.func_72172_n(p_71852_1_, p_71852_2_, p_71852_3_ - 1, p_71852_4_ + 1);
         }

      }
   }

   private int func_72170_e(World p_72170_1_, int p_72170_2_, int p_72170_3_, int p_72170_4_, int p_72170_5_) {
      if(p_72170_1_.func_72798_a(p_72170_2_, p_72170_3_, p_72170_4_) != this.field_71990_ca) {
         return p_72170_5_;
      } else {
         int var6 = p_72170_1_.func_72805_g(p_72170_2_, p_72170_3_, p_72170_4_);
         return var6 > p_72170_5_?var6:p_72170_5_;
      }
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      if(!p_71863_1_.field_72995_K) {
         boolean var6 = this.func_71930_b(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
         if(var6) {
            this.func_72168_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
         } else {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, 0, 0);
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         }

         super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Item.field_77767_aC.field_77779_bT;
   }

   public int func_71855_c(IBlockAccess p_71855_1_, int p_71855_2_, int p_71855_3_, int p_71855_4_, int p_71855_5_) {
      return !this.field_72175_a?0:this.func_71865_a(p_71855_1_, p_71855_2_, p_71855_3_, p_71855_4_, p_71855_5_);
   }

   public int func_71865_a(IBlockAccess p_71865_1_, int p_71865_2_, int p_71865_3_, int p_71865_4_, int p_71865_5_) {
      if(!this.field_72175_a) {
         return 0;
      } else {
         int var6 = p_71865_1_.func_72805_g(p_71865_2_, p_71865_3_, p_71865_4_);
         if(var6 == 0) {
            return 0;
         } else if(p_71865_5_ == 1) {
            return var6;
         } else {
            boolean var7 = func_72169_f(p_71865_1_, p_71865_2_ - 1, p_71865_3_, p_71865_4_, 1) || !p_71865_1_.func_72809_s(p_71865_2_ - 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ - 1, p_71865_3_ - 1, p_71865_4_, -1);
            boolean var8 = func_72169_f(p_71865_1_, p_71865_2_ + 1, p_71865_3_, p_71865_4_, 3) || !p_71865_1_.func_72809_s(p_71865_2_ + 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ + 1, p_71865_3_ - 1, p_71865_4_, -1);
            boolean var9 = func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_ - 1, 2) || !p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ - 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ - 1, p_71865_4_ - 1, -1);
            boolean var10 = func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_, p_71865_4_ + 1, 0) || !p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ + 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ - 1, p_71865_4_ + 1, -1);
            if(!p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_ + 1, p_71865_4_)) {
               if(p_71865_1_.func_72809_s(p_71865_2_ - 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ - 1, p_71865_3_ + 1, p_71865_4_, -1)) {
                  var7 = true;
               }

               if(p_71865_1_.func_72809_s(p_71865_2_ + 1, p_71865_3_, p_71865_4_) && func_72169_f(p_71865_1_, p_71865_2_ + 1, p_71865_3_ + 1, p_71865_4_, -1)) {
                  var8 = true;
               }

               if(p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ - 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ + 1, p_71865_4_ - 1, -1)) {
                  var9 = true;
               }

               if(p_71865_1_.func_72809_s(p_71865_2_, p_71865_3_, p_71865_4_ + 1) && func_72169_f(p_71865_1_, p_71865_2_, p_71865_3_ + 1, p_71865_4_ + 1, -1)) {
                  var10 = true;
               }
            }

            return !var9 && !var8 && !var7 && !var10 && p_71865_5_ >= 2 && p_71865_5_ <= 5?var6:(p_71865_5_ == 2 && var9 && !var7 && !var8?var6:(p_71865_5_ == 3 && var10 && !var7 && !var8?var6:(p_71865_5_ == 4 && var7 && !var9 && !var10?var6:(p_71865_5_ == 5 && var8 && !var9 && !var10?var6:0))));
         }
      }
   }

   public boolean func_71853_i() {
      return this.field_72175_a;
   }

   public static boolean func_72173_e(IBlockAccess p_72173_0_, int p_72173_1_, int p_72173_2_, int p_72173_3_, int p_72173_4_) {
      int var5 = p_72173_0_.func_72798_a(p_72173_1_, p_72173_2_, p_72173_3_);
      if(var5 == Block.field_72075_av.field_71990_ca) {
         return true;
      } else if(var5 == 0) {
         return false;
      } else if(!Block.field_72010_bh.func_94487_f(var5)) {
         return Block.field_71973_m[var5].func_71853_i() && p_72173_4_ != -1;
      } else {
         int var6 = p_72173_0_.func_72805_g(p_72173_1_, p_72173_2_, p_72173_3_);
         return p_72173_4_ == (var6 & 3) || p_72173_4_ == Direction.field_71580_e[var6 & 3];
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_) {
      int var6 = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);
      if(var6 > 0) {
         double var7 = (double)p_71862_2_ + 0.5D + ((double)p_71862_5_.nextFloat() - 0.5D) * 0.2D;
         double var9 = (double)((float)p_71862_3_ + 0.0625F);
         double var11 = (double)p_71862_4_ + 0.5D + ((double)p_71862_5_.nextFloat() - 0.5D) * 0.2D;
         float var13 = (float)var6 / 15.0F;
         float var14 = var13 * 0.6F + 0.4F;
         if(var6 == 0) {
            var14 = 0.0F;
         }

         float var15 = var13 * var13 * 0.7F - 0.5F;
         float var16 = var13 * var13 * 0.6F - 0.7F;
         if(var15 < 0.0F) {
            var15 = 0.0F;
         }

         if(var16 < 0.0F) {
            var16 = 0.0F;
         }

         p_71862_1_.func_72869_a("reddust", var7, var9, var11, (double)var14, (double)var15, (double)var16);
      }

   }

   public static boolean func_72169_f(IBlockAccess p_72169_0_, int p_72169_1_, int p_72169_2_, int p_72169_3_, int p_72169_4_) {
      if(func_72173_e(p_72169_0_, p_72169_1_, p_72169_2_, p_72169_3_, p_72169_4_)) {
         return true;
      } else {
         int var5 = p_72169_0_.func_72798_a(p_72169_1_, p_72169_2_, p_72169_3_);
         if(var5 == Block.field_72011_bi.field_71990_ca) {
            int var6 = p_72169_0_.func_72805_g(p_72169_1_, p_72169_2_, p_72169_3_);
            return p_72169_4_ == (var6 & 3);
         } else {
            return false;
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77767_aC.field_77779_bT;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94413_c = p_94332_1_.func_94245_a("redstoneDust_cross");
      this.field_94410_cO = p_94332_1_.func_94245_a("redstoneDust_line");
      this.field_94411_cP = p_94332_1_.func_94245_a("redstoneDust_cross_overlay");
      this.field_94412_cQ = p_94332_1_.func_94245_a("redstoneDust_line_overlay");
      this.field_94336_cN = this.field_94413_c;
   }

   @SideOnly(Side.CLIENT)
   public static Icon func_94409_b(String p_94409_0_) {
      return p_94409_0_ == "redstoneDust_cross"?Block.field_72075_av.field_94413_c:(p_94409_0_ == "redstoneDust_line"?Block.field_72075_av.field_94410_cO:(p_94409_0_ == "redstoneDust_cross_overlay"?Block.field_72075_av.field_94411_cP:(p_94409_0_ == "redstoneDust_line_overlay"?Block.field_72075_av.field_94412_cQ:null)));
   }
}
