package mods.Periodicraft.block.ore;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSilverOre extends PeriodicraftBlock {

	public BlockSilverOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(3.5F).setResistance(2.6F).setUnlocalizedName("SilverOre");
	}

	public static int quanityDropped() {
		return 2;
	}
	
	public static int idDropped() {
		return Periodicraft.SilverFragments.itemID;
	}
	
	protected boolean canSilkHarvest()
    {
        return false;
    }	
}
