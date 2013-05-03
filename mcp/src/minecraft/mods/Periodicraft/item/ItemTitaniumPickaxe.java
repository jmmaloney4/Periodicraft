package mods.Periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftPick;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemTitaniumPickaxe extends PeriodicraftPick {

	public ItemTitaniumPickaxe(int par1, EnumToolMaterial material) {
		super(par1, material);
		this.setCreativeTab(Periodicraft.tabTools).setMaxStackSize(1).setUnlocalizedName("TitaniumPickaxe");
	}
}
