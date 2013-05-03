package mods.Periodicraft.block.ore;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockAluminumOre extends PeriodicraftBlock {

	public BlockAluminumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks);
		this.setResistance(3.4F).setHardness(4.5F).setUnlocalizedName("AluminumOre");
	}

}
