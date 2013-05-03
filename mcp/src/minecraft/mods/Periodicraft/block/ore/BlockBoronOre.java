package mods.Periodicraft.block.ore;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockBoronOre extends PeriodicraftBlock {

	public BlockBoronOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setResistance(1.0F).setHardness(1.5F).setUnlocalizedName("BoronOre");
	}
	
	public static Random rand = new Random();
	public static int ran = rand.nextInt(1);
	public int quantityDropped(Random random)
    {
		return ran + 2;
    }
		
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.BoronDust.itemID;
	}

}
