package mods.periodicraft.block.ore;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockBerylliumOre extends PeriodicraftBlock {
	public BlockBerylliumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(5.8F).setLightValue(3.5F).setResistance(8.4F).setUnlocalizedName("BerylliumOre");
		
	}
}
