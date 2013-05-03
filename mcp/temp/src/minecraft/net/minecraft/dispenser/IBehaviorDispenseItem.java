package net.minecraft.dispenser;

import net.minecraft.dispenser.BehaviorDispenseItemProvider;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;

public interface IBehaviorDispenseItem {

   IBehaviorDispenseItem field_82483_a = new BehaviorDispenseItemProvider();


   ItemStack func_82482_a(IBlockSource var1, ItemStack var2);

}
