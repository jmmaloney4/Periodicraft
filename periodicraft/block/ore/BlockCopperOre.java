package mods.periodicraft.block.ore;

//Periodicraft Class
//Created By Jack Maloney on 3/10/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockCopperOre extends PeriodicraftBlock {

	public BlockCopperOre(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setUnlocalizedName("CopperOre").setStepSound(Block.soundStoneFootstep)
		.setCreativeTab(Periodicraft.tabBlocks).setHardness(1.0F).setResistance(1.0F);
	}	
}