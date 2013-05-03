package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBed extends Item {

   public ItemBed(int p_i3620_1_) {
      super(p_i3620_1_);
      this.func_77637_a(CreativeTabs.field_78031_c);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_3_.field_72995_K) {
         return true;
      } else if(p_77648_7_ != 1) {
         return false;
      } else {
         ++p_77648_5_;
         BlockBed var11 = (BlockBed)Block.field_71959_S;
         int var12 = MathHelper.func_76128_c((double)(p_77648_2_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3;
         byte var13 = 0;
         byte var14 = 0;
         if(var12 == 0) {
            var14 = 1;
         }

         if(var12 == 1) {
            var13 = -1;
         }

         if(var12 == 2) {
            var14 = -1;
         }

         if(var12 == 3) {
            var13 = 1;
         }

         if(p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.func_82247_a(p_77648_4_ + var13, p_77648_5_, p_77648_6_ + var14, p_77648_7_, p_77648_1_)) {
            if(p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_, p_77648_6_) && p_77648_3_.func_72799_c(p_77648_4_ + var13, p_77648_5_, p_77648_6_ + var14) && p_77648_3_.func_72797_t(p_77648_4_, p_77648_5_ - 1, p_77648_6_) && p_77648_3_.func_72797_t(p_77648_4_ + var13, p_77648_5_ - 1, p_77648_6_ + var14)) {
               p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, var11.field_71990_ca, var12, 3);
               if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == var11.field_71990_ca) {
                  p_77648_3_.func_72832_d(p_77648_4_ + var13, p_77648_5_, p_77648_6_ + var14, var11.field_71990_ca, var12 + 8, 3);
               }

               --p_77648_1_.field_77994_a;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }
}
