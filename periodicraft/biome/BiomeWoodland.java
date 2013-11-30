package mods.periodicraft.biome;

import java.util.Random;

import net.minecraftforge.common.BiomeDictionary;
import static net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import mods.periodicraft.biome.BiomeGenPeriodicraft;

public class BiomeWoodland extends BiomeGenPeriodicraft {

	public BiomeWoodland(int par1) {
		super(par1);
		this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator.treesPerChunk = 7;
        this.theBiomeDecorator.grassPerChunk = 10;
        this.theBiomeDecorator.flowersPerChunk = 3;
        this.theBiomeDecorator.bigMushroomsPerChunk = 2;
        this.temperature = 0.4F;
        
	}


}
