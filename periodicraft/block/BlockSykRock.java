package mods.periodicraft.block;

import net.minecraft.block.material.Material;
import mods.periodicraft.PeriodicraftBlock;

public class BlockSykRock extends PeriodicraftBlock {

	public BlockSykRock(int par1) {
		super(par1, Material.wood);
		this.setHardness(4.5F).setResistance(5.0F).setUnlocalizedName("SkyRock");
	}

}
