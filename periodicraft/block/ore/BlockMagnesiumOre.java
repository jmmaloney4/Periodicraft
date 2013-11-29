package mods.Periodicraft.block.ore;

//Periodicraft Class
//Created By Jack Maloney on 3/11/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockMagnesiumOre extends PeriodicraftBlock {

	public BlockMagnesiumOre(int par1, Material par3Material) {
		super(par1, par3Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(5.5F).setUnlocalizedName("MagnesiumOre").setResistance(5.5F);
		this.setBurnProperties(this.blockID, 2, 5);
	}

	
	public int quantityDropped(Random random)
    {
        return 3;
    }
	
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.MagnesiumShard.itemID;
	}

	
}
