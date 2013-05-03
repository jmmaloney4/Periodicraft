package mods.Periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class PeriodicraftAxe extends ItemAxe {

	public PeriodicraftAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.maxStackSize = 1;
		this.setUnlocalizedName("NullAxe").setCreativeTab(Periodicraft.tabTools);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}


}
