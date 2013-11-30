package mods.periodicraft.block.ore;

//Periodicraft Class
//Copyright (C) 2013 Jack Maloney

import java.util.Random;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockLithiumOre extends PeriodicraftBlock {

	public BlockLithiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(1.0F).setResistance(0.0F).setUnlocalizedName("LithiumOre");
	}
	
	public static Random rand = new Random();
	public static int ran = rand.nextInt(6);
	public int quantityDropped(Random random)
    {
		return ran + 2;
    }

	public static int idDropped() {
		return Periodicraft.LithiumShards.itemID;
	}
	
	protected boolean canSilkHarvest()
    {
        return false;
    }

}
