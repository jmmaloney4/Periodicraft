package mods.periodicraft.biome;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenEnd;

public class BiomeSkyBiome extends BiomeGenEnd {

	public BiomeSkyBiome(int par1) {
		super(par1);
		this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
	}
}
