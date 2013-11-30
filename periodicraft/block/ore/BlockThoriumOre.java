package mods.periodicraft.block.ore;

import net.minecraft.block.material.Material;
import mods.periodicraft.PeriodicraftBlock;

public class BlockThoriumOre extends PeriodicraftBlock {

	public BlockThoriumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("ThoriumOre").setHardness(9.7F).setResistance(9.9F);
	}

}
