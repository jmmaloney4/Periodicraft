package mods.periodicraft;

import java.util.Random;
import java.util.logging.Level;

import mods.periodicraft.World.EnumBlockRarity;
import mods.periodicraft.World.PeriodicraftWorldGenerator;
import mods.periodicraft.block.BlockOre;
import mods.periodicraft.item.ItemDust;
import mods.periodicraft.item.ItemIngot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
import cpw.mods.fml.common.registry.GameRegistry;
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

@Mod(modid = "Periodicraft", name = "Periodicraft", version = "Beta 1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Periodicraft {
	// Ore Generator
	public static PeriodicraftWorldGenerator WGen;

	public static Random random = new Random();

	// ingot
	public static ItemIngot ItemCopperIngot = new ItemIngot(ID.id(),
			"Copper Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemBronzeIngot = new ItemIngot(ID.id(),
			"Bronze Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemOsmiumIngot = new ItemIngot(ID.id(),
			"Osmium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemPlatinumIngot = new ItemIngot(ID.id(),
			"Platinum Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemTungstenIngot = new ItemIngot(ID.id(),
			"Tungsten Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemTinIngot = new ItemIngot(ID.id(), "Tin Ingot",
			Periodicraft.tabMaterials);

	public static ItemIngot ItemSilverIngot = new ItemIngot(ID.id(),
			"Silver Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemNeodymiumIngot = new ItemIngot(ID.id(),
			"Neodymium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemNickelIngot = new ItemIngot(ID.id(),
			"Nickel Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemMagnesiumIngot = new ItemIngot(ID.id(),
			"Magnesium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemBoronIngot = new ItemIngot(ID.id(),
			"Boron Ingot", Periodicraft.tabMaterials);
	// dust
	public static ItemDust ItemCarbonDust = new ItemDust(ID.id(),
			"Carbon Dust", Periodicraft.tabMaterials);

	public static ItemDust ItemZincDust = new ItemDust(ID.id(), "Zinc Dust",
			Periodicraft.tabMaterials);

	public static ItemDust ItemMagnesiumDust = new ItemDust(ID.id(),
			"Magnesium Dust", Periodicraft.tabMaterials);

	// ore
	public static BlockOre BlockCopperOre = new BlockOre(ID.id(),
			Material.rock, "Carbon Ore", Periodicraft.tabBlocks, 4.4F, 3.2F, 2,
			0, EnumBlockRarity.UNCOMMON);

	public static BlockOre BlockCarbonOre = new BlockOre(ID.id(),
			Material.rock, "Copper Ore", Periodicraft.ItemCarbonDust.itemID,
			(random.nextInt(3) + 3), Periodicraft.tabBlocks, 4.4F, 3.2F, 2, 0,
			EnumBlockRarity.SUBTLE);

	public static BlockOre BlockOsmiumOre = new BlockOre(ID.id(),
			Material.rock, "Osmium Ore", Periodicraft.tabBlocks, 9.9F, 6.6F, 3,
			0, EnumBlockRarity.RARE);

	public static BlockOre BlockZincOre = new BlockOre(ID.id(), Material.rock,
			"Zinc Ore", Periodicraft.ItemZincDust.itemID,
			(random.nextInt(3) + 3), Periodicraft.tabBlocks, 5.5F, 3.6F, 2, 0,
			EnumBlockRarity.SUBTLE);

	public static BlockOre BlockPlatinumOre = new BlockOre(ID.id(),
			Material.rock, "Platinum Ore", Periodicraft.tabBlocks, 8.01F, 4.5F,
			4, 0, EnumBlockRarity.RARE);

	public static BlockOre BlockTungstenOre = new BlockOre(ID.id(),
			Material.rock, "Tungsten Ore", Periodicraft.tabBlocks, 7.2F, 4F, 3,
			0, EnumBlockRarity.UNCOMMON);

	public static BlockOre BlockTinOre = new BlockOre(ID.id(), Material.rock,
			"Tin Ore", Periodicraft.tabBlocks, 5.6F, 7F, 2, 0,
			EnumBlockRarity.UNCOMMON);

	public static BlockOre BlockSilverOre = new BlockOre(ID.id(),
			Material.rock, "Silver Ore", Periodicraft.tabBlocks, 4.1F, 9.8F, 3,
			0, EnumBlockRarity.RARE);

	public static BlockOre BlockNeodymiumOre = new BlockOre(ID.id(),
			Material.rock, "Neodymiuum Ore", Periodicraft.tabBlocks, 3.5F,
			4.9F, 2, 0, EnumBlockRarity.COMMON);

	public static BlockOre BlockNickelOre = new BlockOre(ID.id(),
			Material.rock, "Nickel Ore", Periodicraft.tabBlocks, 5.2F, 5.6F, 3,
			0, EnumBlockRarity.RARE);

	public static BlockOre BlockMagnesiumOre = new BlockOre(ID.id(),
			Material.rock, "Magnesium Ore", Periodicraft.tabBlocks, 2.9F, 3.1F,
			2, 0, EnumBlockRarity.UNCOMMON);

	public static BlockOre BlockBoronOre = new BlockOre(ID.id(), Material.rock,
			"Boron Ore", Periodicraft.tabBlocks, 2.5F, 2.9F, 2, 0,
			EnumBlockRarity.RARE);

	// Creative Tabs

	public static CreativeTabs tabBlocks = new CreativeTabs("tabBlocks") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);
		}
	};

	public static CreativeTabs tabMaterials = new CreativeTabs("tabMaterials") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);
		}
	};

	// The instance of your mod that Forge uses.
	@Instance("Periodicraft")
	public static Periodicraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "mods.periodicraft.client.ClientProxy", serverSide = "mods.periodicraft.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
		FMLLog.log(
				Level.INFO,
				"=======================================================Pre-Initalizing Periodicraft=======================================================");

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		proxy.registerRenderers();
		FMLLog.log(
				Level.INFO,
				"=======================================================Initalizing Periodicraft=======================================================");

		// CreativeTabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabArmor",
				"en_US", "Armor");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabTools",
				"en_US", "Tools");
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabElements", "en_US", "Elements");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabFood",
				"en_US", "Food");
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabBlocks", "en_US", "Blocks");
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabMaterials", "en_US", "Materials");
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.tabWeapons", "en_US", "Weapons");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSpace",
				"en_US", "Space Travel");

		WGen = new PeriodicraftWorldGenerator();
		GameRegistry.registerWorldGenerator(WGen);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone),
				Block.sand, Block.gravel, Block.dirt);

		BlockCopperOre.addSmeltingRecipe(ItemCopperIngot, 2.1F);
		BlockPlatinumOre.addSmeltingRecipe(ItemPlatinumIngot, 5.1F);
		BlockTungstenOre.addSmeltingRecipe(ItemTungstenIngot, 2.1F);
		BlockOsmiumOre.addSmeltingRecipe(ItemOsmiumIngot, 6.3F);
		BlockTinOre.addSmeltingRecipe(ItemTinIngot, 2.1F);
		BlockSilverOre.addSmeltingRecipe(ItemSilverIngot, 2.1F);
		BlockNeodymiumOre.addSmeltingRecipe(ItemNeodymiumIngot, 4.1F);
		BlockNickelOre.addSmeltingRecipe(ItemNickelIngot, 2.1F);
		BlockBoronOre.addSmeltingRecipe(ItemBoronIngot, 2.1F);
		GameRegistry.addShapelessRecipe(new ItemStack(
				Periodicraft.ItemMagnesiumIngot),
				Periodicraft.ItemMagnesiumDust, Periodicraft.ItemMagnesiumDust,
				Periodicraft.ItemMagnesiumDust, Periodicraft.ItemMagnesiumDust);
		BlockBoronOre.setCreativeTab(Periodicraft.tabBlocks);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
		FMLLog.log(
				Level.INFO,
				"=======================================================Starting Periodicraft=======================================================");
	}

}
