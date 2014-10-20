package org.periodicraft.periodicraft.world;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class PeriodicraftGenerator implements IWorldGenerator {

	public class BlockGenConfig {
		public int maxY;
		public int timesPerChunk;
		public int blocksPerVein;
		public Block block;
		
		public BlockGenConfig(int my, int tpc, int bpv, Block b) {
			this.maxY = my;
			this.timesPerChunk = tpc;
			this.blocksPerVein = bpv;
			this.block = b;
		}
	}
	
	public ArrayList<BlockGenConfig> surfaceBlocks;
	public ArrayList<BlockGenConfig> netherBlocks;
	public ArrayList<BlockGenConfig> endBlocks;
	
	public void addBlockSurface(Block b, int maxy, int bpv, int times) {
		BlockGenConfig bgc = new BlockGenConfig(maxy, times, bpv, b);
		this.surfaceBlocks.add(bgc);
	}
	public void addBlockNether(Block b, int maxy, int bpv, int times) {
		BlockGenConfig bgc = new BlockGenConfig(maxy, times, bpv, b);
		this.netherBlocks.add(bgc);
	}
	public void addBlockEnd(Block b, int maxy, int bpv, int times) {
		BlockGenConfig bgc = new BlockGenConfig(maxy, times, bpv, b);
		this.endBlocks.add(bgc);
	}
	
	public PeriodicraftGenerator() {
		this.surfaceBlocks = new ArrayList<BlockGenConfig>();
		this.netherBlocks = new ArrayList<BlockGenConfig>();
		this.endBlocks = new ArrayList<BlockGenConfig>();
		
		GameRegistry.registerWorldGenerator(this, 1);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
		for (int k = 0; k < this.endBlocks.size(); k++) {
        	BlockGenConfig b = this.endBlocks.get(k);
        	for (int a = 0; a < b.timesPerChunk; a++) {
        		int x = chunkX + rand.nextInt(16);
        		int y = rand.nextInt(b.maxY);
        		int z = chunkZ + rand.nextInt(16);
        		(new WorldGenMinable(b.block, b.blocksPerVein)).generate(world, rand, x, y, z);
        	}
        }
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < this.surfaceBlocks.size(); k++) {
        	BlockGenConfig b = this.surfaceBlocks.get(k);
        	for (int a = 0; a < b.timesPerChunk; a++) {
        		int x = chunkX + rand.nextInt(16);
        		int y = rand.nextInt(b.maxY);
        		int z = chunkZ + rand.nextInt(16);
        		(new WorldGenMinable(b.block, b.blocksPerVein)).generate(world, rand, x, y, z);
        	}
        }
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
		for (int k = 0; k < this.netherBlocks.size(); k++) {
	        	BlockGenConfig b = this.netherBlocks.get(k);
	        	for (int a = 0; a < b.timesPerChunk; a++) {
	        		int x = chunkX + rand.nextInt(16);
	        		int y = rand.nextInt(b.maxY);
	        		int z = chunkZ + rand.nextInt(16);
	        		(new WorldGenMinable(b.block, b.blocksPerVein)).generate(world, rand, x, y, z);
	        	}
	        }
	}
	
}
