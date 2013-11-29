package mods.Periodicraft.block.ore;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockNickelOre extends PeriodicraftBlock {

	public BlockNickelOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(2.5F).setResistance(3.5F).setUnlocalizedName("NickelOre");
	}	
}
