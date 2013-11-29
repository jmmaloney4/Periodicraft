package mods.Periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCopperIngot extends PeriodicraftItem {

	public ItemCopperIngot(int par1) {
		super(par1);
		this.setMaxStackSize(64).setCreativeTab(Periodicraft.tabMaterials)
		.setUnlocalizedName("CopperIngot");
	}
}
