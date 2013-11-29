package mods.Periodicraft.block;

import net.minecraft.block.material.Material;
import mods.Periodicraft.PeriodicraftBlock;

public class BlockPureSteelBlock extends PeriodicraftBlock {

	public BlockPureSteelBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(6.7F).setResistance(9.5F).setUnlocalizedName("PureSteelBlock");
	}

}
