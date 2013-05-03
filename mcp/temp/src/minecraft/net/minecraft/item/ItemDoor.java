package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDoor extends Item {

   private Material field_77870_a;


   public ItemDoor(int p_i3644_1_, Material p_i3644_2_) {
      super(p_i3644_1_);
      this.field_77870_a = p_i3644_2_;
      this.field_77777_bU = 1;
      this.func_77637_a(CreativeTabs.field_78028_d);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ != 1) {
         return false;
      } else {
         ++p_77648_5_;
         Block var11;
         if(this.field_77870_a == Material.field_76245_d) {
            var11 = Block.field_72054_aE;
         } else {
            var11 = Block.field_72045_aL;
         }

         if(p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
            if(!var11.func_71930_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
               return false;
            } else {
               int var12 = MathHelper.func_76128_c((double)((p_77648_2_.field_70177_z + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
               func_77869_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, var12, var11);
               --p_77648_1_.field_77994_a;
               return true;
            }
         } else {
            return false;
         }
      }
   }

   public static void func_77869_a(World p_77869_0_, int p_77869_1_, int p_77869_2_, int p_77869_3_, int p_77869_4_, Block p_77869_5_) {
      byte var6 = 0;
      byte var7 = 0;
      if(p_77869_4_ == 0) {
         var7 = 1;
      }

      if(p_77869_4_ == 1) {
         var6 = -1;
      }

      if(p_77869_4_ == 2) {
         var7 = -1;
      }

      if(p_77869_4_ == 3) {
         var6 = 1;
      }

      int var8 = (p_77869_0_.func_72809_s(p_77869_1_ - var6, p_77869_2_, p_77869_3_ - var7)?1:0) + (p_77869_0_.func_72809_s(p_77869_1_ - var6, p_77869_2_ + 1, p_77869_3_ - var7)?1:0);
      int var9 = (p_77869_0_.func_72809_s(p_77869_1_ + var6, p_77869_2_, p_77869_3_ + var7)?1:0) + (p_77869_0_.func_72809_s(p_77869_1_ + var6, p_77869_2_ + 1, p_77869_3_ + var7)?1:0);
      boolean var10 = p_77869_0_.func_72798_a(p_77869_1_ - var6, p_77869_2_, p_77869_3_ - var7) == p_77869_5_.field_71990_ca || p_77869_0_.func_72798_a(p_77869_1_ - var6, p_77869_2_ + 1, p_77869_3_ - var7) == p_77869_5_.field_71990_ca;
      boolean var11 = p_77869_0_.func_72798_a(p_77869_1_ + var6, p_77869_2_, p_77869_3_ + var7) == p_77869_5_.field_71990_ca || p_77869_0_.func_72798_a(p_77869_1_ + var6, p_77869_2_ + 1, p_77869_3_ + var7) == p_77869_5_.field_71990_ca;
      boolean var12 = false;
      if(var10 && !var11) {
         var12 = true;
      } else if(var9 > var8) {
         var12 = true;
      }

      p_77869_0_.func_72832_d(p_77869_1_, p_77869_2_, p_77869_3_, p_77869_5_.field_71990_ca, p_77869_4_, 2);
      p_77869_0_.func_72832_d(p_77869_1_, p_77869_2_ + 1, p_77869_3_, p_77869_5_.field_71990_ca, 8 | (var12?1:0), 2);
      p_77869_0_.func_72898_h(p_77869_1_, p_77869_2_, p_77869_3_, p_77869_5_.field_71990_ca);
      p_77869_0_.func_72898_h(p_77869_1_, p_77869_2_ + 1, p_77869_3_, p_77869_5_.field_71990_ca);
   }
}
