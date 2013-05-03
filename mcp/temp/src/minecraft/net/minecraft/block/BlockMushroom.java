package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

public class BlockMushroom extends BlockFlower {

   private final String field_94374_a;


   protected BlockMushroom(int p_i9073_1_, String p_i9073_2_) {
      super(p_i9073_1_);
      this.field_94374_a = p_i9073_2_;
      float var3 = 0.2F;
      this.func_71905_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
      this.func_71907_b(true);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(p_71847_5_.nextInt(25) == 0) {
         byte var6 = 4;
         int var7 = 5;

         int var8;
         int var9;
         int var10;
         for(var8 = p_71847_2_ - var6; var8 <= p_71847_2_ + var6; ++var8) {
            for(var9 = p_71847_4_ - var6; var9 <= p_71847_4_ + var6; ++var9) {
               for(var10 = p_71847_3_ - 1; var10 <= p_71847_3_ + 1; ++var10) {
                  if(p_71847_1_.func_72798_a(var8, var10, var9) == this.field_71990_ca) {
                     --var7;
                     if(var7 <= 0) {
                        return;
                     }
                  }
               }
            }
         }

         var8 = p_71847_2_ + p_71847_5_.nextInt(3) - 1;
         var9 = p_71847_3_ + p_71847_5_.nextInt(2) - p_71847_5_.nextInt(2);
         var10 = p_71847_4_ + p_71847_5_.nextInt(3) - 1;

         for(int var11 = 0; var11 < 4; ++var11) {
            if(p_71847_1_.func_72799_c(var8, var9, var10) && this.func_71854_d(p_71847_1_, var8, var9, var10)) {
               p_71847_2_ = var8;
               p_71847_3_ = var9;
               p_71847_4_ = var10;
            }

            var8 = p_71847_2_ + p_71847_5_.nextInt(3) - 1;
            var9 = p_71847_3_ + p_71847_5_.nextInt(2) - p_71847_5_.nextInt(2);
            var10 = p_71847_4_ + p_71847_5_.nextInt(3) - 1;
         }

         if(p_71847_1_.func_72799_c(var8, var9, var10) && this.func_71854_d(p_71847_1_, var8, var9, var10)) {
            p_71847_1_.func_94575_c(var8, var9, var10, this.field_71990_ca);
         }
      }

   }

   public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_) {
      return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && this.func_71854_d(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
   }

   protected boolean func_72263_d_(int p_72263_1_) {
      return Block.field_71970_n[p_72263_1_];
   }

   public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_) {
      if(p_71854_3_ >= 0 && p_71854_3_ < 256) {
         int var5 = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_);
         return var5 == Block.field_71994_by.field_71990_ca || p_71854_1_.func_72883_k(p_71854_2_, p_71854_3_, p_71854_4_) < 13 && this.func_72263_d_(var5);
      } else {
         return false;
      }
   }

   public boolean func_72271_c(World p_72271_1_, int p_72271_2_, int p_72271_3_, int p_72271_4_, Random p_72271_5_) {
      int var6 = p_72271_1_.func_72805_g(p_72271_2_, p_72271_3_, p_72271_4_);
      p_72271_1_.func_94571_i(p_72271_2_, p_72271_3_, p_72271_4_);
      WorldGenBigMushroom var7 = null;
      if(this.field_71990_ca == Block.field_72109_af.field_71990_ca) {
         var7 = new WorldGenBigMushroom(0);
      } else if(this.field_71990_ca == Block.field_72103_ag.field_71990_ca) {
         var7 = new WorldGenBigMushroom(1);
      }

      if(var7 != null && var7.func_76484_a(p_72271_1_, p_72271_5_, p_72271_2_, p_72271_3_, p_72271_4_)) {
         return true;
      } else {
         p_72271_1_.func_72832_d(p_72271_2_, p_72271_3_, p_72271_4_, this.field_71990_ca, var6, 3);
         return false;
      }
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94336_cN = p_94332_1_.func_94245_a(this.field_94374_a);
   }
}
