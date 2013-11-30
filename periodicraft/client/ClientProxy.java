package mods.periodicraft.client;

//Periodicraft Class
//Created By Jack Maloney on 3/10/2013
//Copyright (C)2013 Jack Maloney

import mods.periodicraft.*;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{

	@Override
    public void registerRenderers() {
            MinecraftForgeClient.preloadTexture(ITEMS_PNG);
            MinecraftForgeClient.preloadTexture(BLOCK_PNG);
    }
	
}
