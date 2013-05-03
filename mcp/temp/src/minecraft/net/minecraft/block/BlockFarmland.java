package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFarmland extends Block {

   @SideOnly(Side.CLIENT)
   private Icon field_94441_a;
   @SideOnly(Side.CLIENT)
   private Icon field_94440_b;


   protected BlockFarmland(int p_i3945_1_) {
      super(p_i3945_1_, Material.field_76248_c);
      this.func_71907_b(true);
      this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.func_71868_h(255);
   }

   public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_) {
      return AxisAlignedBB.func_72332_a().func_72299_a((double)(p_71872_2_ + 0), (double)(p_71872_3_ + 0), (double)(p_71872_4_ + 0), (double)(p_71872_2_ + 1), (double)(p_71872_3_ + 1), (double)(p_71872_4_ + 1));
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      return p_71858_1_ == 1?(p_71858_2_ > 0?this.field_94441_a:this.field_94440_b):Block.field_71979_v.func_71851_a(p_71858_1_);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!this.func_72247_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_) && !p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_ + 1, p_71847_4_)) {
         int var6 = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
         if(var6 > 0) {
            p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, var6 - 1, 2);
         } else if(!this.func_72248_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_)) {
            p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_71979_v.field_71990_ca);
         }
      } else {
         p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, 7, 2);
      }

   }

   public void func_71866_a(World p_71866_1_, int p_71866_2_, int p_71866_3_, int p_71866_4_, Entity p_71866_5_, float p_71866_6_) {
      if(!p_71866_1_.field_72995_K && p_71866_1_.field_73012_v.nextFloat() < p_71866_6_ - 0.5F) {
         if(!(p_71866_5_ instanceof EntityPlayer) && !p_71866_1_.func_82736_K().func_82766_b("mobGriefing")) {
            return;
         }

         p_71866_1_.func_94575_c(p_71866_2_, p_71866_3_, p_71866_4_, Block.field_71979_v.field_71990_ca);
      }

   }

   private boolean func_72248_l(World p_72248_1_, int p_72248_2_, int p_72248_3_, int p_72248_4_) {
      byte var5 = 0;

      for(int var6 = p_72248_2_ - var5; var6 <= p_72248_2_ + var5; ++var6) {
         for(int var7 = p_72248_4_ - var5; var7 <= p_72248_4_ + var5; ++var7) {
            int var8 = p_72248_1_.func_72798_a(var6, p_72248_3_ + 1, var7);
            if(var8 == Block.field_72058_az.field_71990_ca || var8 == Block.field_71999_bt.field_71990_ca || var8 == Block.field_71996_bs.field_71990_ca || var8 == Block.field_82514_ch.field_71990_ca || var8 == Block.field_82513_cg.field_71990_ca) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean func_72247_n(World p_72247_1_, int p_72247_2_, int p_72247_3_, int p_72247_4_) {
      for(int var5 = p_72247_2_ - 4; var5 <= p_72247_2_ + 4; ++var5) {
         for(int var6 = p_72247_3_; var6 <= p_72247_3_ + 1; ++var6) {
            for(int var7 = p_72247_4_ - 4; var7 <= p_72247_4_ + 4; ++var7) {
               if(p_72247_1_.func_72803_f(var5, var6, var7) == Material.field_76244_g) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_) {
      super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
      Material var6 = p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
      if(var6.func_76220_a()) {
         p_71863_1_.func_94575_c(p_71863_2_, p_71863_3_, p_71863_4_, Block.field_71979_v.field_71990_ca);
      }

   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_71979_v.func_71885_a(0, p_71885_2_, p_71885_3_);
   }

   @SideOnly(Side.CLIENT)
   public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_) {
      return Block.field_71979_v.field_71990_ca;
   }

   @SideOnly(Side.CLIENT)
   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94441_a = p_94332_1_.func_94245_a("farmland_wet");
      this.field_94440_b = p_94332_1_.func_94245_a("farmland_dry");
   }
}
