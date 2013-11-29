package mods.Periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/12/2013
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBlueStoneShard extends PeriodicraftItem {

	public ItemBlueStoneShard(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabMaterials).setUnlocalizedName("BlueStoneShard");
	}
}
