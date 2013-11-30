package mods.periodicraft.block.ore;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;

public class BlockScandiumOre extends PeriodicraftBlock {

	public BlockScandiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(4.5F).setResistance(3.5F).setUnlocalizedName("ScandiumOre");
	}
}
