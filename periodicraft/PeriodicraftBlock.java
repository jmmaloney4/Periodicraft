package mods.Periodicraft;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class PeriodicraftBlock extends Block {

	public PeriodicraftBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setUnlocalizedName("NullBlock").setStepSound(Block.soundStoneFootstep).setHardness(2.0F);
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("Periodicraft:" + this.getUnlocalizedName());   
	}


}
