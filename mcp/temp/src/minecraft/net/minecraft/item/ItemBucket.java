package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemBucket extends Item {

   private int field_77876_a;


   public ItemBucket(int p_i3625_1_, int p_i3625_2_) {
      super(p_i3625_1_);
      this.field_77777_bU = 1;
      this.field_77876_a = p_i3625_2_;
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      float var4 = 1.0F;
      double var5 = p_77659_3_.field_70169_q + (p_77659_3_.field_70165_t - p_77659_3_.field_70169_q) * (double)var4;
      double var7 = p_77659_3_.field_70167_r + (p_77659_3_.field_70163_u - p_77659_3_.field_70167_r) * (double)var4 + 1.62D - (double)p_77659_3_.field_70129_M;
      double var9 = p_77659_3_.field_70166_s + (p_77659_3_.field_70161_v - p_77659_3_.field_70166_s) * (double)var4;
      boolean var11 = this.field_77876_a == 0;
      MovingObjectPosition var12 = this.func_77621_a(p_77659_2_, p_77659_3_, var11);
      if(var12 == null) {
         return p_77659_1_;
      } else {
         if(var12.field_72313_a == EnumMovingObjectType.TILE) {
            int var13 = var12.field_72311_b;
            int var14 = var12.field_72312_c;
            int var15 = var12.field_72309_d;
            if(!p_77659_2_.func_72962_a(p_77659_3_, var13, var14, var15)) {
               return p_77659_1_;
            }

            if(this.field_77876_a == 0) {
               if(!p_77659_3_.func_82247_a(var13, var14, var15, var12.field_72310_e, p_77659_1_)) {
                  return p_77659_1_;
               }

               if(p_77659_2_.func_72803_f(var13, var14, var15) == Material.field_76244_g && p_77659_2_.func_72805_g(var13, var14, var15) == 0) {
                  p_77659_2_.func_94571_i(var13, var14, var15);
                  if(p_77659_3_.field_71075_bZ.field_75098_d) {
                     return p_77659_1_;
                  }

                  if(--p_77659_1_.field_77994_a <= 0) {
                     return new ItemStack(Item.field_77786_ax);
                  }

                  if(!p_77659_3_.field_71071_by.func_70441_a(new ItemStack(Item.field_77786_ax))) {
                     p_77659_3_.func_71021_b(new ItemStack(Item.field_77786_ax.field_77779_bT, 1, 0));
                  }

                  return p_77659_1_;
               }

               if(p_77659_2_.func_72803_f(var13, var14, var15) == Material.field_76256_h && p_77659_2_.func_72805_g(var13, var14, var15) == 0) {
                  p_77659_2_.func_94571_i(var13, var14, var15);
                  if(p_77659_3_.field_71075_bZ.field_75098_d) {
                     return p_77659_1_;
                  }

                  if(--p_77659_1_.field_77994_a <= 0) {
                     return new ItemStack(Item.field_77775_ay);
                  }

                  if(!p_77659_3_.field_71071_by.func_70441_a(new ItemStack(Item.field_77775_ay))) {
                     p_77659_3_.func_71021_b(new ItemStack(Item.field_77775_ay.field_77779_bT, 1, 0));
                  }

                  return p_77659_1_;
               }
            } else {
               if(this.field_77876_a < 0) {
                  return new ItemStack(Item.field_77788_aw);
               }

               if(var12.field_72310_e == 0) {
                  --var14;
               }

               if(var12.field_72310_e == 1) {
                  ++var14;
               }

               if(var12.field_72310_e == 2) {
                  --var15;
               }

               if(var12.field_72310_e == 3) {
                  ++var15;
               }

               if(var12.field_72310_e == 4) {
                  --var13;
               }

               if(var12.field_72310_e == 5) {
                  ++var13;
               }

               if(!p_77659_3_.func_82247_a(var13, var14, var15, var12.field_72310_e, p_77659_1_)) {
                  return p_77659_1_;
               }

               if(this.func_77875_a(p_77659_2_, var5, var7, var9, var13, var14, var15) && !p_77659_3_.field_71075_bZ.field_75098_d) {
                  return new ItemStack(Item.field_77788_aw);
               }
            }
         } else if(this.field_77876_a == 0 && var12.field_72308_g instanceof EntityCow) {
            return new ItemStack(Item.field_77771_aG);
         }

         return p_77659_1_;
      }
   }

   public boolean func_77875_a(World p_77875_1_, double p_77875_2_, double p_77875_4_, double p_77875_6_, int p_77875_8_, int p_77875_9_, int p_77875_10_) {
      if(this.field_77876_a <= 0) {
         return false;
      } else if(!p_77875_1_.func_72799_c(p_77875_8_, p_77875_9_, p_77875_10_) && p_77875_1_.func_72803_f(p_77875_8_, p_77875_9_, p_77875_10_).func_76220_a()) {
         return false;
      } else {
         if(p_77875_1_.field_73011_w.field_76575_d && this.field_77876_a == Block.field_71942_A.field_71990_ca) {
            p_77875_1_.func_72908_a(p_77875_2_ + 0.5D, p_77875_4_ + 0.5D, p_77875_6_ + 0.5D, "random.fizz", 0.5F, 2.6F + (p_77875_1_.field_73012_v.nextFloat() - p_77875_1_.field_73012_v.nextFloat()) * 0.8F);

            for(int var11 = 0; var11 < 8; ++var11) {
               p_77875_1_.func_72869_a("largesmoke", (double)p_77875_8_ + Math.random(), (double)p_77875_9_ + Math.random(), (double)p_77875_10_ + Math.random(), 0.0D, 0.0D, 0.0D);
            }
         } else {
            p_77875_1_.func_72832_d(p_77875_8_, p_77875_9_, p_77875_10_, this.field_77876_a, 0, 3);
         }

         return true;
      }
   }
}
