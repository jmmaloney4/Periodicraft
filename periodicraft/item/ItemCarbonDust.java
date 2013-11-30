package mods.periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import mods.periodicraft.ID;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemCarbonDust extends PeriodicraftItem {

	public ItemCarbonDust(int par1) {
		super(ID.id());
		this.setUnlocalizedName("CarbonDust");
	}
}
