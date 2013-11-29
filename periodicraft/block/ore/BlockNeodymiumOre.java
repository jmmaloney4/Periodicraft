package mods.Periodicraft.block.ore;

//Periodicraft Class
//Created By Jack Maloney on 3/12/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockNeodymiumOre extends PeriodicraftBlock {

	public BlockNeodymiumOre(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setUnlocalizedName("NeodymiumOre").setCreativeTab(Periodicraft.tabBlocks).setHardness(2.0F).setResistance(1.0F);
	}

	public int quantityDropped(Random random)
    {
        return 1;
    }
	
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.NeodymiumOre.blockID;
	}
	
}
