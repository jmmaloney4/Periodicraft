package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemReed extends Item {

   private int field_77830_a;


   public ItemReed(int p_i3691_1_, Block p_i3691_2_) {
      super(p_i3691_1_);
      this.field_77830_a = p_i3691_2_.field_71990_ca;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
      if(var11 == Block.field_72037_aS.field_71990_ca && (p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1) {
         p_77648_7_ = 1;
      } else if(var11 != Block.field_71998_bu.field_71990_ca && var11 != Block.field_71962_X.field_71990_ca && var11 != Block.field_71961_Y.field_71990_ca) {
         if(p_77648_7_ == 0) {
            --p_77648_5_;
         }

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
      }

      if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else {
         if(p_77648_3_.func_72931_a(this.field_77830_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_)) {
            Block var12 = Block.field_71973_m[this.field_77830_a];
            int var13 = var12.func_85104_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);
            if(p_77648_3_.func_72832_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_77830_a, var13, 3)) {
               if(p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_77830_a) {
                  Block.field_71973_m[this.field_77830_a].func_71860_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_, p_77648_1_);
                  Block.field_71973_m[this.field_77830_a].func_85105_g(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, var13);
               }

               p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), var12.field_72020_cn.func_82593_b(), (var12.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, var12.field_72020_cn.func_72678_c() * 0.8F);
               --p_77648_1_.field_77994_a;
            }
         }

         return true;
      }
   }
}
