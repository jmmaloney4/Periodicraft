package net.minecraft.item;

import java.util.List;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySelectorArmoredMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;

final class BehaviorDispenseArmor extends BehaviorDefaultDispenseItem {

   protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
      int var4 = p_82487_1_.func_82623_d() + var3.func_82601_c();
      int var5 = p_82487_1_.func_82622_e() + var3.func_96559_d();
      int var6 = p_82487_1_.func_82621_f() + var3.func_82599_e();
      AxisAlignedBB var7 = AxisAlignedBB.func_72332_a().func_72299_a((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1));
      List var8 = p_82487_1_.func_82618_k().func_82733_a(EntityLiving.class, var7, new EntitySelectorArmoredMob(p_82487_2_));
      if(var8.size() > 0) {
         EntityLiving var9 = (EntityLiving)var8.get(0);
         int var10 = var9 instanceof EntityPlayer?1:0;
         int var11 = EntityLiving.func_82159_b(p_82487_2_);
         ItemStack var12 = p_82487_2_.func_77946_l();
         var12.field_77994_a = 1;
         var9.func_70062_b(var11 - var10, var12);
         var9.func_96120_a(var11, 2.0F);
         --p_82487_2_.field_77994_a;
         return p_82487_2_;
      } else {
         return super.func_82487_b(p_82487_1_, p_82487_2_);
      }
   }
}
