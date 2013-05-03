package net.minecraft.dispenser;

import java.util.Random;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorFireball extends BehaviorDefaultDispenseItem {

   public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
      IPosition var4 = BlockDispenser.func_82525_a(p_82487_1_);
      double var5 = var4.func_82615_a() + (double)((float)var3.func_82601_c() * 0.3F);
      double var7 = var4.func_82617_b() + (double)((float)var3.func_82601_c() * 0.3F);
      double var9 = var4.func_82616_c() + (double)((float)var3.func_82599_e() * 0.3F);
      World var11 = p_82487_1_.func_82618_k();
      Random var12 = var11.field_73012_v;
      double var13 = var12.nextGaussian() * 0.05D + (double)var3.func_82601_c();
      double var15 = var12.nextGaussian() * 0.05D + (double)var3.func_96559_d();
      double var17 = var12.nextGaussian() * 0.05D + (double)var3.func_82599_e();
      var11.func_72838_d(new EntitySmallFireball(var11, var5, var7, var9, var13, var15, var17));
      p_82487_2_.func_77979_a(1);
      return p_82487_2_;
   }

   protected void func_82485_a(IBlockSource p_82485_1_) {
      p_82485_1_.func_82618_k().func_72926_e(1009, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
   }
}
