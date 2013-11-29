package mods.Periodicraft.dimension.moon;

import mods.Periodicraft.Periodicraft;
import mods.Periodicraft.biome.BiomeGenPeriodicraft;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMoon extends WorldProvider {

	@Override
	public String getDimensionName() {
		// TODO Auto-generated method stub
		return "The Moon";
	}
	
	public void RegisterWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenPeriodicraft.MoonPlains, 0.6F, 0.0F);
		this.dimensionId = Periodicraft.MoonID;
	}
	
	public boolean canRespawnHere() {
		return false;
	}

	public IChunkProvider createChunkManager() {
		return new ChunckProviderMoon(worldObj, worldObj.getSeed(), true);
	}
	
	 /**
     * A message to display to the user when they transfer to this dimension.
     *
     * @return The message to be displayed
     */
    public String getWelcomeMessage()
    {
        if(this instanceof WorldProviderMoon) {
        	return "Flying To The Moon";
        }
		return null;
    }

    /**
     * A Message to display to the user when they transfer out of this dismension.
     *
     * @return The message to be displayed
     */
    public String getDepartMessage()
    {
        if(this instanceof WorldProviderMoon) {
        	return "Coming Back To Earth";
        }
        return null;
    }
    
    public boolean canDoLightning(Chunk chunk)
    {
        return false;
    }

    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }
	
    public boolean renderEndSky() {
        return false;
    }

    public boolean renderVoidFog() {

        return true;

    }
	
	public float setSunSize() {

        return 0.0F;

	}

	public float setMoonSize() {
        return 0.0F;
	}

	public String getSunTexture() {

        	return null;

	}

	public String getMoonTexture() {

        return null;

	}

	public boolean renderStars() {

		return true;

	}

	public boolean darkenSkyDuringRain() {

        	return true;

	}
    
	
	}
