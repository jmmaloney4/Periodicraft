package mods.periodicraft.block;

import net.minecraft.block.material.Material;
import mods.periodicraft.PeriodicraftBlock;

public class BlockSteelBlock extends PeriodicraftBlock {

	public BlockSteelBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(6.7F).setResistance(9.5F).setUnlocalizedName("SteelBlock");
	}

}
