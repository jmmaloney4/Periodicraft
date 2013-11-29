package mods.Periodicraft.block.ore;

//Periodicraft Class
//Copyright (C) 2013 Jack Maloney

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.PeriodicraftBlock;

public class BlockChromiumOre extends PeriodicraftBlock {

	public BlockChromiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(5.0F).setResistance(2.0F).setUnlocalizedName("ChromiumOre");
	}
}
