package mods.Periodicraft.block;

//Periodicraft Class
//Created By Jack Maloney on 3/12/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMoonStone extends PeriodicraftBlock {

	
	public BlockMoonStone(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(0.7F).setUnlocalizedName("MoonStone").setResistance(0F);
	}

	public static Random rand = new Random();
	public static int ran = rand.nextInt(2);
	public int quantityDropped(Random random)
    {
		return ran + 2;
    }
	
	protected boolean canSilkHarvest()
    {
        return false;
    }
	
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.MoonRock.itemID;
	}
	
}
