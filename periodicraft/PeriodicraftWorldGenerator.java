package mods.periodicraft;

/*
Copyright (C) 2013  Jack Maloney

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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
		}
	}

	private void generateSurface(World world, Random random, int x, int z) {

		for(int k = 0; k < 20; k++) {
			int XCoord = x + random.nextInt(16);
			int YCoord = random.nextInt(80);
			int ZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.BlockCopperOre.blockID, 4, 1)).generate(world, random, XCoord, YCoord, ZCoord);
		}
		
		for(int k = 0; k < 20; k++) {
			int XCoord = x + random.nextInt(16);
			int YCoord = random.nextInt(30);
			int ZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.BlockCarbonOre.blockID, 10, 1)).generate(world, random, XCoord, YCoord, ZCoord);
		}
	}

	private void generateEnd(World world, Random random, int x , int z) {

		/*
		for(int k = 0; k < 20; k++) {
			int XCoord = x + random.nextInt(16);
			int YCoord = random.nextInt(30);
			int ZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.BlockCopperOre.blockID, 10, 1)).generate(world, random, XCoord, YCoord, ZCoord);
		}
		 */
	}
	
	private void generateNether(World world, Random random, int x , int z) {

		/*
		for(int k = 0; k < 20; k++) {
			int XCoord = x + random.nextInt(16);
			int YCoord = random.nextInt(30);
			int ZCoord = z + random.nextInt(16);
			(new WorldGenMinable(Periodicraft.BlockCopperOre.blockID, 10, 1)).generate(world, random, XCoord, YCoord, ZCoord);
		}
		 */
	}
}
