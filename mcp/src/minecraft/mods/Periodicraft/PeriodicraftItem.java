package mods.Periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

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

}
