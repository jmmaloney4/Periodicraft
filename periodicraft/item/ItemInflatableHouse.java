package mods.periodicraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.periodicraft.PeriodicraftItem;

public class ItemInflatableHouse extends PeriodicraftItem {

	public ItemInflatableHouse(int par1) {
		super(par1);
		this.setUnlocalizedName("InflatableHouse");
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
            int i1 = par3World.getBlockId(par4, par5, par6);

            
            par3World.setBlock(par4 + 3, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5, par6 - 3, Block.planks.blockID);
            
            par3World.setBlock(par4 + 3, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 1, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 1, par6 - 3, Block.planks.blockID);
            
            par3World.setBlock(par4 + 3, par5 + 2 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 2, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 2, par6 - 3, Block.planks.blockID);
            
            par3World.setBlock(par4 + 3, par5 + 3 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 3, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 3, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 + 3, Block.planks.blockID);
            
            par3World.setBlock(par4 + 3, par5 + 4 + 1, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 2, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 3, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 3, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 1, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 + 2, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 1, par5 + 4, par6, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 - 1, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 - 2, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 - 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 + 1, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 + 2, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6 + 3, Block.planks.blockID);
            par3World.setBlock(par4 - 2, par5 + 4, par6, Block.planks.blockID);
            
            //Decor
            par3World.setBlock(par4 - 1, par5 + 1, par6 - 2, Block.workbench.blockID);
            par3World.setBlock(par4 - 2, par5 + 1, par6 - 2, Block.furnaceIdle.blockID);
            par3World.setBlock(par4 - 2, par5 + 2, par6 - 2, Block.furnaceIdle.blockID);
            par3World.setBlock(par4 - 2, par5 + 3, par6 - 2, Block.furnaceIdle.blockID);
            par3World.setBlock(par4, par5 + 1, par6 - 2, Block.fence.blockID);
            par3World.setBlock(par4, par5 + 2, par6 - 2, Block.pressurePlateStone.blockID);
            par3World.setBlock(par4 + 1, par5 + 1, par6 - 2, Block.chest.blockID);
            par3World.setBlock(par4 + 2, par5 + 1, par6 - 2, Block.chest.blockID);
            par3World.setBlock(par4, par5 + 1, par6 + 1, Block.torchWood.blockID);
            
            
            
            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        
    }

}
