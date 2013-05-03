package net.minecraft.inventory;

import net.minecraft.item.ItemStack;

public interface ISidedInventory extends IInventory
{
    /**
     * Get the size of the side inventory.
     */
    int[] getSizeInventorySide(int var1);

    boolean func_102007_a(int i, ItemStack itemstack, int j);

    boolean func_102008_b(int i, ItemStack itemstack, int j);
}
