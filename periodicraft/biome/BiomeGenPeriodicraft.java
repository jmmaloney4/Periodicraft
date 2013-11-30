package mods.periodicraft.biome;

import mods.periodicraft.dimension.moon.BiomeMoonPlains;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenEnd;

public class BiomeGenPeriodicraft extends BiomeGenBase {

	public BiomeGenPeriodicraft(int par1) {
		super(par1);
	}
	
	public static BiomeGenBase Woodland = new BiomeWoodland(22);
	public static BiomeGenBase SkyBiome = new BiomeGenEnd(23);
	public static BiomeGenBase MoonPlains = new BiomeMoonPlains(24);
	
	
}
