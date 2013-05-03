package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSign extends Item {

   public ItemSign(int p_i3685_1_) {
      super(p_i3685_1_);
      this.field_77777_bU = 16;
      this.func_77637_a(CreativeTabs.field_78031_c);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ == 0) {
         return false;
      } else if(!p_77648_3_.func_72803_f(p_77648_4_, p_77648_5_, p_77648_6_).func_76220_a()) {
         return false;
      } else {
         if(p_77648_7_ == 1) {
            ++p_77648_5_;
         }

         if(p_77648_7_ == 2) {
            --p_77648_6_;
         }

         if(p_77648_7_ == 3) {
            ++p_77648_6_;
         }

         if(p_77648_7_ == 4) {
            --p_77648_4_;
         }

         if(p_77648_7_ == 5) {
            ++p_77648_4_;
         }

         if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
         } else if(!Block.field_72053_aD.func_71930_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) {
            return false;
         } else {
            if(p_77648_7_ == 1) {
               int var11 = MathHelper.func_76128_c((double)((p_77648_2_.field_70177_z + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72053_aD.field_71990_ca, var11, 2);
            } else {
               p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72042_aI.field_71990_ca, p_77648_7_, 2);
            }

            --p_77648_1_.field_77994_a;
            TileEntitySign var12 = (TileEntitySign)p_77648_3_.func_72796_p(p_77648_4_, p_77648_5_, p_77648_6_);
            if(var12 != null) {
               p_77648_2_.func_71014_a(var12);
            }

            return true;
         }
      }
   }
}
