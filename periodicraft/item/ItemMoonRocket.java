package mods.periodicraft.item;

import mods.periodicraft.PeriodicraftItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMoonRocket extends PeriodicraftItem {

	public ItemMoonRocket(int par1) {
		super(par1);
		this.setUnlocalizedName("MoonRocket");
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
            int i1 = par3World.getBlockId(x, y, z);
            par3World.setBlock(x, y + 1, z, Block.blockIron.blockID);
            par3World.setBlock(x, y + 2, z + 1, Block.blockIron.blockID);
            par3World.setBlock(x, y + 2, z - 1, Block.blockIron.blockID);
            par3World.setBlock(x, y + 3, z + 2, Block.blockIron.blockID);
            par3World.setBlock(x, y + 3, z - 2, Block.blockIron.blockID);
            par3World.setBlock(x, y + 4, z + 1, Block.blockIron.blockID);
            par3World.setBlock(x, y + 4, z - 1, Block.blockIron.blockID);
            par3World.setBlock(x, y + 5, z, Block.blockIron.blockID);
            par3World.setBlock(x, y + 2, z + 2, Block.blockIron.blockID);
            par3World.setBlock(x, y + 2, z - 2, Block.blockIron.blockID);
            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
    }

}
