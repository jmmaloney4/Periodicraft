package mods.Periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

public class PeriodicraftTool extends ItemTool {

	protected PeriodicraftTool(int par1, int par2,
			EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock) {
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		this.setMaxStackSize(1).setUnlocalizedName("NullTool").setCreativeTab(Periodicraft.tabTools);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}

}
