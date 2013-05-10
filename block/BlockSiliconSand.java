package mods.Periodicraft.block;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSiliconSand extends PeriodicraftBlock {

	public BlockSiliconSand(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(0.5F).setResistance(0.5F).setUnlocalizedName("SiliconSand");
	}	
}
