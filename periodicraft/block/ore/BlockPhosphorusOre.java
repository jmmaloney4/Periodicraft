package mods.periodicraft.block.ore;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;

public class BlockPhosphorusOre extends PeriodicraftBlock{

	public BlockPhosphorusOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(2.5F).setResistance(2.5F).setUnlocalizedName("PhosphorusOre");
	}
}
