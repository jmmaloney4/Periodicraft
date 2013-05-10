package mods.Periodicraft.block;

//Periodicraft Class
//Created By Jack Maloney on 3/12/2013
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockBlueStone extends PeriodicraftBlock {

	public BlockBlueStone(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setUnlocalizedName("BlueStone").setHardness(4.5F).setResistance(7.0F).setLightValue(4.5F);
	}
}
