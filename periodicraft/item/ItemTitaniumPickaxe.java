package mods.periodicraft.item;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import mods.periodicraft.EnumPeriodicraftToolMaterial;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftPick;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemTitaniumPickaxe extends PeriodicraftPick {

	public ItemTitaniumPickaxe(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabTools).setMaxStackSize(1).setUnlocalizedName("TitaniumPickaxe");
	}
}
