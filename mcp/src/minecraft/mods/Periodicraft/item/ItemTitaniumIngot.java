package mods.Periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemTitaniumIngot extends PeriodicraftItem {

	public ItemTitaniumIngot(int par1) {
		super(par1);
		this.setCreativeTab(Periodicraft.tabElements).setUnlocalizedName("TitaniumIngot").setMaxStackSize(64);
	}
}
