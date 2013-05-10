package mods.Periodicraft.item.weapon;

//Periodicraft Class
//Created By Jack Maloney on 3/13/2013
//Copyright (C)2013 Jack Maloney


import mods.Periodicraft.EnumPeriodicraftToolMaterial;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftSword;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemTitaniumSword extends PeriodicraftSword {

	public ItemTitaniumSword(int par1, EnumPeriodicraftToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(Periodicraft.tabWeapons).setUnlocalizedName("TitaniumSword");
	}	
}
