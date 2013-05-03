package net.minecraft.item;

import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockRailBase;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class BehaviorDispenseMinecart extends BehaviorDefaultDispenseItem {

   private final BehaviorDefaultDispenseItem field_96465_b = new BehaviorDefaultDispenseItem();


   public ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
      World var4 = p_82487_1_.func_82618_k();
      double var5 = p_82487_1_.func_82615_a() + (double)((float)var3.func_82601_c() * 1.125F);
      double var7 = p_82487_1_.func_82617_b() + (double)((float)var3.func_96559_d() * 1.125F);
      double var9 = p_82487_1_.func_82616_c() + (double)((float)var3.func_82599_e() * 1.125F);
      int var11 = p_82487_1_.func_82623_d() + var3.func_82601_c();
      int var12 = p_82487_1_.func_82622_e() + var3.func_96559_d();
      int var13 = p_82487_1_.func_82621_f() + var3.func_82599_e();
      int var14 = var4.func_72798_a(var11, var12, var13);
      double var15;
      if(BlockRailBase.func_72184_d(var14)) {
         var15 = 0.0D;
      } else {
         if(var14 != 0 || !BlockRailBase.func_72184_d(var4.func_72798_a(var11, var12 - 1, var13))) {
            return this.field_96465_b.func_82482_a(p_82487_1_, p_82487_2_);
         }

         var15 = -1.0D;
      }

      EntityMinecart var17 = EntityMinecart.func_94090_a(var4, var5, var7 + var15, var9, ((ItemMinecart)p_82487_2_.func_77973_b()).field_77841_a);
      var4.func_72838_d(var17);
      p_82487_2_.func_77979_a(1);
      return p_82487_2_;
   }

   protected void func_82485_a(IBlockSource p_82485_1_) {
      p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
   }
}
