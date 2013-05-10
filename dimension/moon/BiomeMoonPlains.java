package mods.Periodicraft.dimension.moon;

import net.minecraft.block.Block;
import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.biome.BiomeGenPeriodicraft;

public class BiomeMoonPlains extends BiomeGenPeriodicraft {

	public BiomeMoonPlains(int par1) {
		super(par1);
		this.topBlock = (byte)Periodicraft.MoonStone.blockID;
        this.fillerBlock = (byte)Periodicraft.MoonStone.blockID;
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.bigMushroomsPerChunk = 0;
        this.temperature = 0.4F;
        this.setDisableRain();
        this.setBiomeName("Moon Plains");
	}

}
