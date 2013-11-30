package mods.periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeriodicraftItem extends Item {

	public PeriodicraftItem(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setMaxStackSize(64).setUnlocalizedName("NullItem");
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType)
    {
        if (this instanceof PeriodicraftArmor)
        {
            return ((PeriodicraftArmor)this).armorType == armorType;
        }

        if (armorType == 0)
        {
            return itemID == Block.pumpkin.blockID || itemID == Item.skull.itemID || itemID == Block.glowStone.blockID;
        }

        return false;
    }

}
