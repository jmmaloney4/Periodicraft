package mods.periodicraft;

import java.util.logging.Level;

import javax.swing.JFrame;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

//Periodicraft Class
//Copyright (C)2013 Jack Maloney


@Mod(modid="Periodicraft", name="Periodicraft", version="Alpha 1.0.4")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Periodicraft {

	//Creative Tabs

	public static CreativeTabs tabTools = new CreativeTabs("tabTools") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);
		}
	};

	public static CreativeTabs tabArmor = new CreativeTabs("tabArmor") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);
		}
	};

	public static CreativeTabs tabBlocks = new CreativeTabs("tabBlocks") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);		}
	};

	public static CreativeTabs tabMaterials = new CreativeTabs("tabMaterials") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);		}
	};

	public static CreativeTabs tabFood = new CreativeTabs("tabFood") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);		}
	};

	public static CreativeTabs tabWeapons = new CreativeTabs("tabWeapons") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);		}
	};

	public static CreativeTabs tabSpace = new CreativeTabs("tabSpace") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);		}
	};

	public static CreativeTabs tabUtility = new CreativeTabs("tabUtility") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.chest, 1, 0);
		}
	};




	//Demensions
	public static final int MoonID = 100;
	public static final int MarsID = 101;
	public static final int VenusID = 102;
	public static final int MercuryID = 103;
	public static final int EuropaID = 104;
	public static final int IoID = 105;
	public static final int TitanID = 106;
	public static final int EnceladusID = 107;
	public static final int TitaniaID = 108;
	public static final int PlutoID = 109;
	public static final int CharonID = 110;


	//Blocks



	//Mobs/Entitys
	int MoonManID = ID.eID();
	int AlienScientistID = ID.eID();  



	// The instance of your mod that Forge uses.
	@Instance("Periodicraft")
	public static Periodicraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="mods.Periodicraft.client.ClientProxy", serverSide="mods.Periodicraft.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
		FMLLog.log(Level.INFO ,"=======================================================Pre-Initalizing Periodicraft=======================================================");
	}

	@Init
	public void load(FMLInitializationEvent event) {

		proxy.registerRenderers();
		FMLLog.log(Level.INFO, "=======================================================Initalizing Periodicraft=======================================================");
		
		JFrame frame = new JFrame("Initalizing Periodicraft");
		
		//CreativeTabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabArmor", "en_US", "Armor");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabTools", "en_US", "Tools");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabElements", "en_US", "Elements");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabFood", "en_US", "Food");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabBlocks", "en_US", "Blocks");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabMaterials", "en_US", "Materials");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabWeapons", "en_US", "Weapons");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSpace", "en_US", "Space Travel");
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
		FMLLog.log(Level.INFO, "=======================================================Starting Periodicraft=======================================================");
	}

	public void Egg(Class <? extends Entity> entity, int ID, int PrimaryColor, int SecondaryColor) {
		EntityList.IDtoClassMapping.put(ID, entity);
		EntityList.entityEggs.put(ID, new EntityEggInfo(ID, PrimaryColor, SecondaryColor));
	}



}
