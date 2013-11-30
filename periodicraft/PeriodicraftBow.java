package mods.periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBow;

public class PeriodicraftBow extends ItemBow {

	public PeriodicraftBow(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}

}
