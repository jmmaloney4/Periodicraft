package mods.Periodicraft;

import net.minecraftforge.common.BiomeDictionary;
import static net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import mods.Periodicraft.biome.BiomeGenPeriodicraft;

public class BiomeIronZone extends BiomeGenPeriodicraft {

	public BiomeIronZone(int par1) {
		super(par1);
		this.topBlock = (byte)Block.beacon.blockID;
        this.fillerBlock = (byte)Block.blockDiamond.blockID;
	}
	public static BiomeGenBase IronZone = new BiomeIronZone(22);
	


}
