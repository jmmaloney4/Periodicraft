package mods.periodicraft.block.ore;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockTitaniumOre extends PeriodicraftBlock {

	public BlockTitaniumOre(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setHardness(7.5F).setCreativeTab(Periodicraft.tabBlocks).setResistance(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TitaniumOre");
	}	
	public int quantityDropped(Random random)
    {
        return 1;
    }
	
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.TitaniumOre.blockID;
	}

}
