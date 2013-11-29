package mods.Periodicraft.block.ore;

//Periodicraft Class
//Copyright (C) 2013 Jack Maloney


import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BlockCarbonOre extends PeriodicraftBlock{

	public static int drop;
	
	
	public BlockCarbonOre(int par1, int par2, Material par3Material) {
		super(par1, par3Material);
		this.setUnlocalizedName("CarbonOre").setCreativeTab(Periodicraft.tabBlocks).setHardness(1.0F)
		.setResistance(1.0F).setStepSound(Block.soundStoneFootstep);
	}


	public static Random rand = new Random();
	public static int ran = rand.nextInt(6);
	public int quantityDropped(Random random)
    {
		return ran + 2;
    }
		
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.CarbonDust.itemID;
	}
	
	protected boolean canSilkHarvest()
    {
        return false;
    }
	
}
