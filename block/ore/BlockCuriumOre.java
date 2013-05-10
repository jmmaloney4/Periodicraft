package mods.Periodicraft.block.ore;

import net.minecraft.block.material.Material;
import mods.Periodicraft.PeriodicraftBlock;

public class BlockCuriumOre extends PeriodicraftBlock {

	public BlockCuriumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("CuriumOre").setHardness(8.5F).setResistance(5.5F);
	}

}
