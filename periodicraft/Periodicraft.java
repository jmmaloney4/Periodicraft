package mods.periodicraft;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.logging.Level;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import mods.periodicraft.block.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

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

@Mod(modid="Periodicraft", name="Periodicraft", version="2.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Periodicraft {
	
	public static BlockOre BlockCopperOre = new BlockOre(ID.id(), Material.rock, "CopperOre", Periodicraft.tabBlocks, Block.cactus.blockID, 4.4F, 3.2F);
	public static BlockOre BlockCarbonOre = new BlockOre(ID.id(), Material.rock, "CopperOre", Periodicraft.tabBlocks, Block.cake.blockID, 4.4F, 3.2F);

	
	
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

	// The instance of your mod that Forge uses.
	@Instance("Periodicraft")
	public static Periodicraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="mods.periodicraft.client.ClientProxy", serverSide="mods.periodicraft.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
		FMLLog.log(Level.INFO ,"=======================================================Pre-Initalizing Periodicraft=======================================================");
	

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		proxy.registerRenderers();
		FMLLog.log(Level.INFO, "=======================================================Initalizing Periodicraft=======================================================");
				
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

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
		FMLLog.log(Level.INFO, "=======================================================Starting Periodicraft=======================================================");
	}

	public void Egg(Class <? extends Entity> entity, int ID, int PrimaryColor, int SecondaryColor) {
		EntityList.IDtoClassMapping.put(ID, entity);
		EntityList.entityEggs.put(ID, new EntityEggInfo(ID, PrimaryColor, SecondaryColor));
	}



}
