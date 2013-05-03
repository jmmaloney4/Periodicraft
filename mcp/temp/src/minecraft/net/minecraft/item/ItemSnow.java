package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSnow extends ItemBlockWithMetadata {

   public ItemSnow(int p_i10058_1_, Block p_i10058_2_) {
      super(p_i10058_1_, p_i10058_2_);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_1_.field_77994_a == 0) {
         return false;
      } else if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
         return false;
      } else {
         int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
         if(var11 == Block.field_72037_aS.field_71990_ca) {
            Block var12 = Block.field_71973_m[this.func_77883_f()];
            int var13 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
            int var14 = var13 & 7;
            if(var14 <= 6 && p_77648_3_.func_72855_b(var12.func_71872_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_)) && p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, var14 + 1 | var13 & -8, 2)) {
               p_77648_3_.func_72908_a((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), var12.field_72020_cn.func_82593_b(), (var12.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, var12.field_72020_cn.func_72678_c() * 0.8F);
               --p_77648_1_.field_77994_a;
               return true;
            }
         }

         return super.func_77648_a(p_77648_1_, p_77648_2_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_);
      }
   }
}
