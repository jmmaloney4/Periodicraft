package mods.periodicraft.block.ore;

//Periodicraft Class
//Copyright (C) 2013 Jack Maloney

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.PeriodicraftBlock;

public class BlockManganeseOre extends PeriodicraftBlock{

	public BlockManganeseOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setResistance(2.7F).setHardness(3.5F).setUnlocalizedName("ManganeseOre");
	}

}
