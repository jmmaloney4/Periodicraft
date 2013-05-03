package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BlockBed extends BlockDirectional {

   public static final int[][] field_72230_a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
   @SideOnly(Side.CLIENT)
   private Icon[] field_94472_b;
   @SideOnly(Side.CLIENT)
   private Icon[] field_94473_c;
   @SideOnly(Side.CLIENT)
   private Icon[] field_94471_cO;


   public BlockBed(int p_i3919_1_) {
      super(p_i3919_1_, Material.field_76253_m);
      this.func_72227_n();
   }

   public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_) {
      if(p_71903_1_.field_72995_K) {
         return true;
      } else {
         int var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
         if(!func_72229_a_(var10)) {
            int var11 = func_72217_d(var10);
            p_71903_2_ += field_72230_a[var11][0];
            p_71903_4_ += field_72230_a[var11][1];
            if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_) != this.field_71990_ca) {
               return true;
            }

            var10 = p_71903_1_.func_72805_g(p_71903_2_, p_71903_3_, p_71903_4_);
         }

         if(p_71903_1_.field_73011_w.func_76567_e() && p_71903_1_.func_72807_a(p_71903_2_, p_71903_4_) != BiomeGenBase.field_76778_j) {
            if(func_72225_b_(var10)) {
               EntityPlayer var20 = null;
               Iterator var12 = p_71903_1_.field_73010_i.iterator();

               while(var12.hasNext()) {
                  EntityPlayer var21 = (EntityPlayer)var12.next();
                  if(var21.func_70608_bn()) {
                     ChunkCoordinates var14 = var21.field_71081_bT;
                     if(var14.field_71574_a == p_71903_2_ && var14.field_71572_b == p_71903_3_ && var14.field_71573_c == p_71903_4_) {
                        var20 = var21;
                     }
                  }
               }

               if(var20 != null) {
                  p_71903_5_.func_71035_c("tile.bed.occupied");
                  return true;
               }

               func_72228_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, false);
            }

            EnumStatus var19 = p_71903_5_.func_71018_a(p_71903_2_, p_71903_3_, p_71903_4_);
            if(var19 == EnumStatus.OK) {
               func_72228_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, true);
               return true;
            } else {
               if(var19 == EnumStatus.NOT_POSSIBLE_NOW) {
                  p_71903_5_.func_71035_c("tile.bed.noSleep");
               } else if(var19 == EnumStatus.NOT_SAFE) {
                  p_71903_5_.func_71035_c("tile.bed.notSafe");
               }

               return true;
            }
         } else {
            double var18 = (double)p_71903_2_ + 0.5D;
            double var13 = (double)p_71903_3_ + 0.5D;
            double var15 = (double)p_71903_4_ + 0.5D;
            p_71903_1_.func_94571_i(p_71903_2_, p_71903_3_, p_71903_4_);
            int var17 = func_72217_d(var10);
            p_71903_2_ += field_72230_a[var17][0];
            p_71903_4_ += field_72230_a[var17][1];
            if(p_71903_1_.func_72798_a(p_71903_2_, p_71903_3_, p_71903_4_) == this.field_71990_ca) {
               p_71903_1_.func_94571_i(p_71903_2_, p_71903_3_, p_71903_4_);
               var18 = (var18 + (double)p_71903_2_ + 0.5D) / 2.0D;
               var13 = (var13 + (double)p_71903_3_ + 0.5D) / 2.0D;
               var15 = (var15 + (double)p_71903_4_ + 0.5D) / 2.0D;
            }

            p_71903_1_.func_72885_a((Entity)null, (double)((float)p_71903_2_ + 0.5F), (double)((float)p_71903_3_ + 0.5F), (double)((float)p_71903_4_ + 0.5F), 5.0F, true, true);
            return true;
         }
      }
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_1_ == 0) {
         return Block.field_71988_x.func_71851_a(p_71858_1_);
      } else {
         int var3 = func_72217_d(p_71858_2_);
         int var4 = Direction.field_71584_h[var3][p_71858_1_];
         int var5 = func_72229_a_(p_71858_2_)?1:0;
         return (var5 != 1 || var4 != 2) && (var5 != 0 || var4 != 3)?(var4 != 5 && var4 != 4?this.field_94471_cO[var5]:this.field_94473_c[var5]):this.field_94472_b[var5];
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94471_cO = new Icon[]{p_94332_1_.func_94245_a("bed_feet_top"), p_94332_1_.func_94245_a("bed_head_top")};
      this.field_94472_b = new Icon[]{p_94332_1_.func_94245_a("bed_feet_end"), p_94332_1_.func_94245_a("bed_head_end")};
      this.field_94473_c = new Icon[]{p_94332_1_.func_94245_a("bed_feet_side"), p_94332_1_.func_94245_a("bed_head_side")};
   }

   public int func_71857_b() {
      return 14;
   }

   public boolean func_71886_c() {
      return false;
   }

   public boolean func_71926_d() {
      return false;
   }

   public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_) {
      this.func_72227_n();
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      int var6 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);
      int var7 = func_72217_d(var6);
      if(func_72229_a_(var6)) {
         if(p_71863_1_.func_72798_a(p_71863_2_ - field_72230_a[var7][0], p_71863_3_, p_71863_4_ - field_72230_a[var7][1]) != this.field_71990_ca) {
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         }
      } else if(p_71863_1_.func_72798_a(p_71863_2_ + field_72230_a[var7][0], p_71863_3_, p_71863_4_ + field_72230_a[var7][1]) != this.field_71990_ca) {
         p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
         if(!p_71863_1_.field_72995_K) {
            this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, var6, 0);
         }
      }

   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return func_72229_a_(p_71885_1_)?0:Item.field_77776_ba.field_77779_bT;
   }

   private void func_72227_n() {
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static boolean func_72229_a_(int p_72229_0_) {
      return (p_72229_0_ & 8) != 0;
   }

   public static boolean func_72225_b_(int p_72225_0_) {
      return (p_72225_0_ & 4) != 0;
   }

   public static void func_72228_a(World p_72228_0_, int p_72228_1_, int p_72228_2_, int p_72228_3_, boolean p_72228_4_) {
      int var5 = p_72228_0_.func_72805_g(p_72228_1_, p_72228_2_, p_72228_3_);
      if(p_72228_4_) {
         var5 |= 4;
      } else {
         var5 &= -5;
      }

      p_72228_0_.func_72921_c(p_72228_1_, p_72228_2_, p_72228_3_, var5, 4);
   }

   public static ChunkCoordinates func_72226_b(World p_72226_0_, int p_72226_1_, int p_72226_2_, int p_72226_3_, int p_72226_4_) {
      int var5 = p_72226_0_.func_72805_g(p_72226_1_, p_72226_2_, p_72226_3_);
      int var6 = BlockDirectional.func_72217_d(var5);

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = p_72226_1_ - field_72230_a[var6][0] * var7 - 1;
         int var9 = p_72226_3_ - field_72230_a[var6][1] * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               if(p_72226_0_.func_72797_t(var12, p_72226_2_ - 1, var13) && p_72226_0_.func_72799_c(var12, p_72226_2_, var13) && p_72226_0_.func_72799_c(var12, p_72226_2_ + 1, var13)) {
                  if(p_72226_4_ <= 0) {
                     return new ChunkCoordinates(var12, p_72226_2_, var13);
                  }

                  --p_72226_4_;
               }
            }
         }
      }

      return null;
   }

   public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_) {
      if(!func_72229_a_(p_71914_5_)) {
         super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, 0);
      }

   }

   public int func_71915_e() {
      return 1;
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Item.field_77776_ba.field_77779_bT;
   }

   public void func_71846_a(World p_71846_1_, int p_71846_2_, int p_71846_3_, int p_71846_4_, int p_71846_5_, EntityPlayer p_71846_6_) {
      if(p_71846_6_.field_71075_bZ.field_75098_d && func_72229_a_(p_71846_5_)) {
         int var7 = func_72217_d(p_71846_5_);
         p_71846_2_ -= field_72230_a[var7][0];
         p_71846_4_ -= field_72230_a[var7][1];
         if(p_71846_1_.func_72798_a(p_71846_2_, p_71846_3_, p_71846_4_) == this.field_71990_ca) {
            p_71846_1_.func_94571_i(p_71846_2_, p_71846_3_, p_71846_4_);
         }
      }

   }

}
