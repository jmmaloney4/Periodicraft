package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class ItemHangingEntity extends Item {

   private final Class field_82811_a;


   public ItemHangingEntity(int p_i5084_1_, Class p_i5084_2_) {
      super(p_i5084_1_);
      this.field_82811_a = p_i5084_2_;
      this.func_77637_a(CreativeTabs.field_78031_c);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(p_77648_7_ == 0) {
         return false;
      } else if(p_77648_7_ == 1) {
         return false;
      } else {
         int var11 = Direction.field_71579_d[p_77648_7_];
         EntityHanging var12 = this.func_82810_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, var11);
         if(!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) {
            return false;
         } else {
            if(var12 != null && var12.func_70518_d()) {
               if(!p_77648_3_.field_72995_K) {
                  p_77648_3_.func_72838_d(var12);
               }

               --p_77648_1_.field_77994_a;
            }

            return true;
         }
      }
   }

   private EntityHanging func_82810_a(World p_82810_1_, int p_82810_2_, int p_82810_3_, int p_82810_4_, int p_82810_5_) {
      return (EntityHanging)(this.field_82811_a == EntityPainting.class?new EntityPainting(p_82810_1_, p_82810_2_, p_82810_3_, p_82810_4_, p_82810_5_):(this.field_82811_a == EntityItemFrame.class?new EntityItemFrame(p_82810_1_, p_82810_2_, p_82810_3_, p_82810_4_, p_82810_5_):null));
   }
}
