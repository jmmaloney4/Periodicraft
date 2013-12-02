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
import net.minecraftforge.common.MinecraftForge;
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

	protected static final int LightValue = 0;
	protected static final int LightOpacity = 0;

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

	public static ItemIngot ItemBerylliumIngot = new ItemIngot(ID.id(),
			"Beryllium Ingot", Periodicraft.tabMaterials);
	// dust
	public static ItemDust ItemCarbonDust = new ItemDust(ID.id(),
			"Carbon Dust", Periodicraft.tabMaterials);

	public static ItemDust ItemZincDust = new ItemDust(ID.id(), "Zinc Dust",
			Periodicraft.tabMaterials);

	public static ItemDust ItemMagnesiumDust = new ItemDust(ID.id(),
			"Magnesium Dust", Periodicraft.tabMaterials);

	// ore
	public static BlockOre BlockCopperOre = Periodicraft.CreateOreBlock(
			"Copper Ore", 3.5F, 4.5F, 1, LightValue, LightOpacity);

	public static BlockOre BlockCarbonOre = Periodicraft.CreateOreBlock(
			"Carbon Ore", 5.4F, 4.3F, 2, LightValue, LightOpacity);

	public static BlockOre BlockOsmiumOre = Periodicraft.CreateOreBlock(
			"Osmium Ore", 8.7F, 5.4F, 4, LightValue, LightOpacity);
	
	  public static BlockOre BlockZincOre =
	  Periodicraft.CreateOreBlock("Zinc Ore", 5.5F, 3.2F,
	  3, LightValue, LightOpacity);
	  
	  public static BlockOre BlockPlatinumOre = Periodicraft.CreateOreBlock("Platinum Ore", 7.5F, 5.5F, 3, LightValue, LightOpacity);
	  
	  public static BlockOre BlockTungstenOre = Periodicraft.CreateOreBlock("Tungsten Ore", 4.5F, 4.6F, 3, LightValue, LightOpacity);
	  
	  public static BlockOre BlockTinOre = Periodicraft.CreateOreBlock("Tin Ore", 5.1F, 4.3F, 3, LightValue, LightOpacity);
	  
	  public static BlockOre BlockSilverOre = Periodicraft.CreateOreBlock("Silver Ore", 3.2F, 3.9F, 3, LightValue, LightOpacity);
	  
	  public static BlockOre BlockNeodymiumOre =
	  
	  public static BlockOre BlockNickelOre =
	  
	  public static BlockOre BlockMagnesiumOre =
	  
	  public static BlockOre BlockBoronOre =
	 public static BlockOre BlockBerylliumOre =
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
	@SidedProxy(clientSide = "mods.periodicraft.client.ClientProxy",
			serverSide = "mods.periodicraft.CommonProxy")
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
		BlockBerylliumOre.addSmeltingRecipe(ItemBerylliumIngot, 2.1F);
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

	public static BlockOre CreateOreBlock(String UnlocalizedName,
			float Hardness, float Resistance, int HarvestLevel,
			float LightValue, int LightOpacity, int dimension, EnumBlockRarity rarity,int Drop, int count) {
		BlockOre block = Periodicraft.CreateOreBlock(UnlocalizedName, Hardness,
				Resistance, HarvestLevel, LightValue, LightOpacity, dimension, rarity);
		block.setDropAndCount(Drop, count);
		return block;
	}

	public static BlockOre CreateOreBlock(String UnlocalizedName,
			float Hardness, float Resistance, int HarvestLevel,
			float LightValue, int LightOpacity, int dimension, EnumBlockRarity rarity) {
		BlockOre block = new BlockOre(ID.id());
		block.setUnlocalizedName(UnlocalizedName).setHardness(Hardness)
				.setResistance(Resistance).setCreativeTab(
						Periodicraft.tabBlocks).setLightValue(LightValue)
				.setTextureName("periodicraft:" + UnlocalizedName)
				.setLightOpacity(LightOpacity);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", HarvestLevel);
		LanguageRegistry.addName(block, UnlocalizedName);
		GameRegistry.registerBlock(block, UnlocalizedName);
		block.addToSurfaceGen(rarity);
		block.setDropAndCount(block.blockID, 1);
		return block;
	}

	public static PeriodicraftBlock CreateSimpleBlock(Material par2Material,
			String UnlocalizedName) {

	}
	
	public static ItemIngot CreateItemIngot(String UnlocalizedName, CreativeTabs CreativeTab) {
		ItemIngot ingot = new ItemIngot(ID.id(), UnlocalizedName, CreativeTab);
		ingot.setTextureName("periodicraft:" + UnlocalizedName);
		return ingot;
	}
}
