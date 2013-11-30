package mods.periodicraft.block.ore;

import java.util.Random;

import mods.periodicraft.Periodicraft;
import mods.periodicraft.PeriodicraftBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockPoloniumOre extends PeriodicraftBlock {

	public BlockPoloniumOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(Periodicraft.tabBlocks).setHardness(6.7F).setLightValue(8.9F).setUnlocalizedName("PoloniumOre");
	}
	
	public static Random rand = new Random();
	public static int ran = rand.nextInt(1);
	public int quantityDropped(Random random)
    {
		return ran + 2;
    }
		
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.PoloniumShard.itemID;
	}

}
