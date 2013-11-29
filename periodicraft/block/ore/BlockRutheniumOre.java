package mods.Periodicraft.block.ore;

import net.minecraft.block.material.Material;
import mods.Periodicraft.PeriodicraftBlock;

public class BlockRutheniumOre extends PeriodicraftBlock {

	public BlockRutheniumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("RutheniumOre").setHardness(7.5F).setResistance(6.7F);
	}

}
