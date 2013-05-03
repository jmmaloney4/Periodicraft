package mods.Periodicraft.block.ore;

import java.util.Random;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.PeriodicraftBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSulfurOre extends PeriodicraftBlock {

	public BlockSulfurOre(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("SulfurOre").setHardness(1.5F).setResistance(1.0F);
	}

	public static Random rand = new Random();
	public static int ran = rand.nextInt(6);
	public int quantityDropped(Random random)
    {
		return ran + 2;
    }
		
	public int idDropped(int par1, Random random, int zero) {
        return Periodicraft.SulfurShard.itemID;
	}
	
}
