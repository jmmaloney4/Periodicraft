package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSeedFood extends ItemFood {

   private int field_82808_b;
   private int field_82809_c;


   public ItemSeedFood(int p_i5086_1_, int p_i5086_2_, float p_i5086_3_, int p_i5086_4_, int p_i5086_5_) {
      super(p_i5086_1_, p_i5086_2_, p_i5086_3_, false);
      this.field_82808_b = p_i5086_4_;
      this.field_82809_c = p_i5086_5_;
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ != 1) {
         return false;
      } else if(p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_ + 1, p_77648_6_, p_77648_7_, p_77648_1_)) {
         int var11 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
         if(var11 == this.field_82809_c && p_77648_3_.func_72799_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_)) {
            p_77648_3_.func_94575_c(p_77648_4_, p_77648_5_ + 1, p_77648_6_, this.field_82808_b);
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
