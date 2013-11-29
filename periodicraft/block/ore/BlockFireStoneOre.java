package mods.Periodicraft.block.ore;

import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.material.Material;

public class BlockFireStoneOre extends PeriodicraftBlock {

	public BlockFireStoneOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(9.5F).setResistance(10.3F).setUnlocalizedName("FireStoneOre").setLightValue(5.6F);
	}

}
