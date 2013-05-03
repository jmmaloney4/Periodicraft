package mods.Periodicraft;

//Periodicraft Class
//Created By Jack Maloney on 3/18/2013
//Copyright (C)2013 Jack Maloney

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class PeriodicraftWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ* 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ* 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break; 
		case Periodicraft.MoonID:
		    generateMoon(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case Periodicraft.VenusID:
		    generateVenus(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case Periodicraft.MarsID:
		    generateMars(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 5:
		    generateMercury(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
	}

	private void generateMercury(World world, Random random, int x, int z) {
		
		for(int k = 0; k < 15; k++) {
			
			int ManganeseOreXCoord = x + random.nextInt(16);
			int ManganeseOreYCoord = random.nextInt(10);
			int ManganeseOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.ManganeseOre.blockID, 1, 1)).generate(world, random, ManganeseOreXCoord, ManganeseOreYCoord, ManganeseOreZCoord);
		}
		
	}

	private void generateMars(World world, Random random, int x, int z) {
		for(int k = 0; k < 2; k++) {
			
			int TitaniumOreXCoord = x + random.nextInt(16);
			int TitaniumOreYCoord = random.nextInt(10);
			int TitaniumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.TitaniumOre.blockID, 5, 1)).generate(world, random, TitaniumOreXCoord, TitaniumOreYCoord, TitaniumOreZCoord);
		}
	}

	private void generateVenus(World world, Random random, int x, int z) {
		
	}

	private void generateMoon(World world, Random random, int x, int z) {
		
	}

	private void generateEnd(World world, Random random, int x, int z) {
		
	}

	private void generateSurface(World world, Random random, int x, int z) {
        
		
		BiomeGenBase b = world.getBiomeGenForCoords(x, z);
		if(b.biomeName.equals("Ocean")) {
			
			for(int k = 0; k < 7; k++) {
				
				int VanadiumOreYCoord = random.nextInt(60) - 35;
				int VanadiumOreXCoord = x + random.nextInt(16);
				int VanadiumOreZCoord = z + random.nextInt(16);
				(new WorldGenMinable(Periodicraft.VanadiumOre.blockID, 5, 1)).generate(world, random, VanadiumOreXCoord, VanadiumOreYCoord, VanadiumOreZCoord);
			}
			
		}
		
		
		
		for(int k = 0; k < 24; k++) {
			
			int CopperOreXCoord = x + random.nextInt(16);
			int CopperOreYCoord = random.nextInt(70);
			int CopperOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.CopperOre.blockID, 20, 1)).generate(world, random, CopperOreXCoord, CopperOreYCoord, CopperOreZCoord);
		}
		
		for(int k = 0; k < 16; k++) {
			
			int CarbonOreXCoord = x + random.nextInt(16);
			int CarbonOreYCoord = random.nextInt(60);
			int CarbonOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.CarbonOre.blockID, 14, 1)).generate(world, random, CarbonOreXCoord, CarbonOreYCoord, CarbonOreZCoord);
		}
		
		for(int k = 0; k < 2; k++) {
			
			int TitaniumOreXCoord = x + random.nextInt(16);
			int TitaniumOreYCoord = random.nextInt(10);
			int TitaniumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.TitaniumOre.blockID, 5, 1)).generate(world, random, TitaniumOreXCoord, TitaniumOreYCoord, TitaniumOreZCoord);
		}
		
		for(int k = 0; k < 20; k++) {
			
			int TungstenOreXCoord = x + random.nextInt(16);
			int TungstenOreYCoord = random.nextInt(30);
			int TungstenOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.TungstenOre.blockID, 10, 1)).generate(world, random, TungstenOreXCoord, TungstenOreYCoord, TungstenOreZCoord);
		}
		
		for(int k = 0; k < 10; k++) {
			
			int NeodymiumOreXCoord = x + random.nextInt(16);
			int NeodymiumOreYCoord = random.nextInt(50);
			int NeodymiumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.NeodymiumOre.blockID, 10, 1)).generate(world, random, NeodymiumOreXCoord, NeodymiumOreYCoord, NeodymiumOreZCoord);
		}
		
		for(int k = 0; k < 5; k++) {
			
			int PlatinumOreXCoord = x + random.nextInt(16);
			int PlatinumOreYCoord = random.nextInt(45);
			int PlatinumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.PlatinumOre.blockID, 8, 1)).generate(world, random, PlatinumOreXCoord, PlatinumOreYCoord, PlatinumOreZCoord);
		}
		
		for(int k = 0; k < 10; k++) {
			
			int AluminumOreXCoord = x + random.nextInt(16);
			int AluminumOreYCoord = random.nextInt(45);
			int AluminumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.AluminumOre.blockID, 8, 1)).generate(world, random, AluminumOreXCoord, AluminumOreYCoord, AluminumOreZCoord);
		}
		
		for(int k = 0; k < 7; k++) {
			
			int BerylliumOreXCoord = x + random.nextInt(16);
			int BerylliumOreYCoord = random.nextInt(30);
			int BerylliumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.BerylliumOre.blockID, 8, 1)).generate(world, random, BerylliumOreXCoord, BerylliumOreYCoord, BerylliumOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int LithiumOreXCoord = x + random.nextInt(16);
			int LithiumOreYCoord = random.nextInt(45);
			int LithiumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.LithiumOre.blockID, 8, 1)).generate(world, random, LithiumOreXCoord, LithiumOreYCoord, LithiumOreZCoord);
		}
		
		for(int k = 0; k < 3; k++) {
			
			int PoloniumOreXCoord = x + random.nextInt(16);
			int PoloniumOreYCoord = random.nextInt(10);
			int PoloniumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.PoloniumOre.blockID, 5, 1)).generate(world, random, PoloniumOreXCoord, PoloniumOreYCoord, PoloniumOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int SilverOreXCoord = x + random.nextInt(16);
			int SilverOreYCoord = random.nextInt(45);
			int SilverOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.SilverOre.blockID, 8, 1)).generate(world, random, SilverOreXCoord, SilverOreYCoord, SilverOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int TinOreXCoord = x + random.nextInt(16);
			int TinOreYCoord = random.nextInt(45);
			int TinOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.TinOre.blockID, 8, 1)).generate(world, random, TinOreXCoord, TinOreYCoord, TinOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int NickelOreXCoord = x + random.nextInt(16);
			int NickelOreYCoord = random.nextInt(45);
			int NickelOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.NickelOre.blockID, 4, 1)).generate(world, random, NickelOreXCoord, NickelOreYCoord, NickelOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int MagnesiumOreXCoord = x + random.nextInt(16);
			int MagnesiumOreYCoord = random.nextInt(45);
			int MagnesiumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.MagnesiumOre.blockID, 5, 1)).generate(world, random, MagnesiumOreXCoord, MagnesiumOreYCoord, MagnesiumOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int PhosphorusOreXCoord = x + random.nextInt(16);
			int PhosphorusOreYCoord = random.nextInt(45);
			int PhosphorusOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.PhosphorusOre.blockID, 8, 1)).generate(world, random, PhosphorusOreXCoord, PhosphorusOreYCoord, PhosphorusOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int SodiumOreXCoord = x + random.nextInt(16);
			int SodiumOreYCoord = random.nextInt(45);
			int SodiumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.SodiumOre.blockID, 8, 1)).generate(world, random, SodiumOreXCoord, SodiumOreYCoord, SodiumOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int SulfurOreXCoord = x + random.nextInt(16);
			int SulfurOreYCoord = random.nextInt(45);
			int SulfurOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.SulfurOre.blockID, 8, 1)).generate(world, random, SulfurOreXCoord, SulfurOreYCoord, SulfurOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int ScandiumOreXCoord = x + random.nextInt(16);
			int ScandiumOreYCoord = random.nextInt(45);
			int ScandiumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.ScandiumOre.blockID, 8, 1)).generate(world, random, ScandiumOreXCoord, ScandiumOreYCoord, ScandiumOreZCoord);
		}
		
		for(int k = 0; k < 10; k++) {
			
			int ZincOreXCoord = x + random.nextInt(16);
			int ZincOreYCoord = random.nextInt(45);
			int ZincOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.ZincOre.blockID, 2, 1)).generate(world, random, ZincOreXCoord, ZincOreYCoord, ZincOreZCoord);
		}
		
		for(int k = 0; k < 10; k++) {
			
			int CobaltOreXCoord = x + random.nextInt(16);
			int CobaltOreYCoord = random.nextInt(30);
			int CobaltOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.CobaltOre.blockID, 5, 1)).generate(world, random, CobaltOreXCoord, CobaltOreYCoord, CobaltOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int ChromiumOreXCoord = x + random.nextInt(16);
			int ChromiumOreYCoord = random.nextInt(45);
			int ChromiumOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.ChromiumOre.blockID, 8, 1)).generate(world, random, ChromiumOreXCoord, ChromiumOreYCoord, ChromiumOreZCoord);
		}
		
		for(int k = 0; k < 15; k++) {
			
			int BoronOreXCoord = x + random.nextInt(16);
			int BoronOreYCoord = random.nextInt(45);
			int BoronOreZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.BoronOre.blockID, 8, 1)).generate(world, random, BoronOreXCoord, BoronOreYCoord, BoronOreZCoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {}
	
}
