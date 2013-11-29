package mods.Periodicraft.block.ore;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney

import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockCobaltOre extends PeriodicraftBlock {

	public BlockCobaltOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(6.0F).setUnlocalizedName("CobaltOre").setResistance(2.5F);
	}
}
