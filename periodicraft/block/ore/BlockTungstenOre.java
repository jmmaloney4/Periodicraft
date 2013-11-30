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

public class BlockTungstenOre extends PeriodicraftBlock {

	public BlockTungstenOre(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setUnlocalizedName("TungstenOre").setCreativeTab(Periodicraft.tabBlocks).setHardness(2.0F)
		.setResistance(2.5F).setStepSound(Block.soundStoneFootstep);
	}
	
	public int quantityDropped(Random random)
    {
        return 1;
    }
	
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.TungstenOre.blockID;
	}
	
}
