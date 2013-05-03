package net.minecraft.dispenser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

final class DispenserBehaviorFire extends BehaviorDefaultDispenseItem {

   private boolean field_96466_b = true;


   protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
      World var4 = p_82487_1_.func_82618_k();
      int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
      int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
      int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
      if(var4.func_72799_c(var5, var6, var7)) {
         var4.func_94575_c(var5, var6, var7, Block.field_72067_ar.field_71990_ca);
         if(p_82487_2_.func_96631_a(1, var4.field_73012_v)) {
            p_82487_2_.field_77994_a = 0;
         }
      } else if(var4.func_72798_a(var5, var6, var7) == Block.field_72091_am.field_71990_ca) {
         Block.field_72091_am.func_71898_d(var4, var5, var6, var7, 1);
         var4.func_94571_i(var5, var6, var7);
      } else {
         this.field_96466_b = false;
      }

      return p_82487_2_;
   }

   protected void func_82485_a(IBlockSource p_82485_1_) {
      if(this.field_96466_b) {
         p_82485_1_.func_82618_k().func_72926_e(1000, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
      } else {
         p_82485_1_.func_82618_k().func_72926_e(1001, p_82485_1_.func_82623_d(), p_82485_1_.func_82622_e(), p_82485_1_.func_82621_f(), 0);
      }

   }
}
