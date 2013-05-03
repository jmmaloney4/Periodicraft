package net.minecraft.dispenser;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

final class DispenserBehaviorMobEgg extends BehaviorDefaultDispenseItem {

   public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
      double var4 = p_82487_1_.func_82615_a() + (double)var3.func_82601_c();
      double var6 = (double)((float)p_82487_1_.func_82622_e() + 0.2F);
      double var8 = p_82487_1_.func_82616_c() + (double)var3.func_82599_e();
      Entity var10 = ItemMonsterPlacer.func_77840_a(p_82487_1_.func_82618_k(), p_82487_2_.func_77960_j(), var4, var6, var8);
      if(var10 instanceof EntityLiving && p_82487_2_.func_82837_s()) {
         ((EntityLiving)var10).func_94058_c(p_82487_2_.func_82833_r());
      }

      p_82487_2_.func_77979_a(1);
      return p_82487_2_;
   }
}
