package mods.periodicraft.block.ore;

import net.minecraft.block.material.Material;
import mods.periodicraft.PeriodicraftBlock;

public class BlockUraniumOre extends PeriodicraftBlock {

	public BlockUraniumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("UraniumOre").setHardness(12.7F).setResistance(7.5F);
	}

}
