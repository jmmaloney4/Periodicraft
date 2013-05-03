package mods.Periodicraft.block.ore;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;

public class BlockVanadiumOre extends PeriodicraftBlock {

	public BlockVanadiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(4.5F).setResistance(3.4F).setUnlocalizedName("VanadiumOre");
	}
}
