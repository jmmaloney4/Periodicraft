package mods.periodicraft.block.ore;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSodiumOre extends PeriodicraftBlock {

	public BlockSodiumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(1.0F).setResistance(1.5F).setUnlocalizedName("SodiumOre");
	}

	public static int quanityDropped() {
		return 2;
	}

	public static int idDropped() {
		return Periodicraft.SodiumDust.itemID;
	}

	protected boolean canSilkHarvest()
	{
		return false;
	}
}
