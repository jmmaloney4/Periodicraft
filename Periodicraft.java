package com.periodicraft.periodicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Periodicraft.MODID, name = Periodicraft.NAME, version = Periodicraft.VERSION)
@NetworkMod(clientSideRequired = true)
public class Periodicraft {

	public static final String MODID = "com.periodicraft.periodicraft";
	public static final String NAME = "Periodicraft";
	public static final String VERSION = "Beta 1.0.0";
	// The instance of your mod that Forge uses.
	@Instance(value = Periodicraft.MODID)
	public static Periodicraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}