package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorDye extends BehaviorDefaultDispenseItem {

   private boolean field_96461_b = true;


   protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      if(p_82487_2_.func_77960_j() == 15) {
         EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
         World var4 = p_82487_1_.func_82618_k();
         int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
         int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
         int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
         if(ItemDye.func_96604_a(p_82487_2_, var4, var5, var6, var7)) {
            if(!var4.field_72995_K) {
               var4.func_72926_e(2005, var5, var6, var7, 0);
            }
         } else {
            this.field_96461_b = false;
         }

         return p_82487_2_;
      } else {
         return super.func_82487_b(p_82487_1_, p_82487_2_);
      }
   }

   protected void func_82485_a(IBlockSource p_82485_1_) {
      if(this.field_96461_b) {
         p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
      } else {
         p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
      }

   }
}
