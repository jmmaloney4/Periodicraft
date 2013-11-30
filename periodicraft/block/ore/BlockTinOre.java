package mods.periodicraft.block.ore;

//Periodicraft Class
//Created By Jack Maloney on 3/18/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockTinOre extends PeriodicraftBlock {

	public BlockTinOre(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setHardness(5.0F).setResistance(4.5F).setUnlocalizedName("TinOre").setCreativeTab(Periodicraft.tabBlocks);
	}
}
