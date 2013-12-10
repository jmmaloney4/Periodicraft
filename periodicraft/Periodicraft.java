package mods.periodicraft;

import java.util.Random;
import java.util.logging.Level;

import mods.periodicraft.World.EnumBlockRarity;
import mods.periodicraft.World.PeriodicraftWorldGenerator;
import mods.periodicraft.block.BlockOre;
import mods.periodicraft.block.BlockSimple;
import mods.periodicraft.item.ItemDust;
import mods.periodicraft.item.ItemIngot;
import mods.periodicraft.item.PeriodicraftItemArmor;
import mods.periodicraft.item.PeriodicraftItemPickaxe;
import mods.periodicraft.item.PeriodicraftItemTool;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
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
	public static PeriodicraftWorldGenerator WGen = new PeriodicraftWorldGenerator();

	public static Random random = new Random();

	protected static final int LightValue = 0;
	protected static final int LightOpacity = 0;

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

	public static CreativeTabs tabArmor = new CreativeTabs("tabArmor") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);
		}
	};

	public static CreativeTabs tabTools = new CreativeTabs("tabTools") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Item.pickaxeDiamond, 1, 0);
		}
	};

	// ingot
	public static ItemIngot ItemSteelIngot = Periodicraft.CreateItemIngot(
			"Steel Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemCopperIngot = Periodicraft.CreateItemIngot(
			"Copper Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemBronzeIngot = Periodicraft.CreateItemIngot(
			"Bronze Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemOsmiumIngot = Periodicraft.CreateItemIngot(
			"Osmium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemPlatinumIngot = Periodicraft.CreateItemIngot(
			"Platinum Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemTungstenIngot = Periodicraft.CreateItemIngot(
			"Tungsten Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemTinIngot = Periodicraft.CreateItemIngot(
			"Tin Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemSilverIngot = Periodicraft.CreateItemIngot(
			"Silver Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemNeodymiumIngot = Periodicraft.CreateItemIngot(
			"Neodymium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemNickelIngot = Periodicraft.CreateItemIngot(
			"Nickel Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemMagnesiumIngot = Periodicraft.CreateItemIngot(
			"Magnesium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemBoronIngot = Periodicraft.CreateItemIngot(
			"Boron Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemBerylliumIngot = Periodicraft.CreateItemIngot(
			"Beryllium Ingot", Periodicraft.tabMaterials);

	public static ItemIngot ItemLithiumIngot = Periodicraft.CreateItemIngot(
			"Lithium Ingot", Periodicraft.tabMaterials);
	// dust
	public static ItemDust ItemCarbonDust = Periodicraft.CreateItemDust(
			"Carbon Dust", Periodicraft.tabMaterials);

	public static ItemDust ItemZincDust = Periodicraft.CreateItemDust(
			"Zinc Dust", Periodicraft.tabMaterials);

	public static ItemDust ItemMagnesiumDust = Periodicraft.CreateItemDust(
			"Magnesium Dust", Periodicraft.tabMaterials);

	// ore
	public static BlockOre BlockCopperOre = Periodicraft.CreateOreBlock(
			"Copper Ore", 3.5F, 4.5F, 1, LightValue, LightOpacity, 0,
			EnumBlockRarity.RARE);

	public static BlockOre BlockCarbonOre = Periodicraft.CreateOreBlock(
			"Carbon Ore", 5.4F, 4.3F, 2, LightValue, LightOpacity, 0,
			EnumBlockRarity.SUBTLE);

	public static BlockOre BlockOsmiumOre = Periodicraft.CreateOreBlock(

			"Osmium Ore", 8.7F, 5.4F, 4, LightValue, LightOpacity, 0,
			EnumBlockRarity.UNCOMMON);

	public static BlockOre BlockZincOre = Periodicraft.CreateOreBlock(
			"Zinc Ore", 5.5F, 3.2F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.SUBTLE);

	public static BlockOre BlockPlatinumOre = Periodicraft.CreateOreBlock(
			"Platinum Ore", 7.5F, 5.5F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.RARE);

	public static BlockOre BlockTungstenOre = Periodicraft.CreateOreBlock(
			"Tungsten Ore", 4.5F, 4.6F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.RARE);

	public static BlockOre BlockTinOre = Periodicraft.CreateOreBlock("Tin Ore",
			5.1F, 4.3F, 3, LightValue, LightOpacity, 0, EnumBlockRarity.SUBTLE);

	public static BlockOre BlockSilverOre = Periodicraft.CreateOreBlock(
			"Silver Ore", 3.2F, 3.9F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.UNCOMMON);

	public static BlockOre BlockNeodymiumOre = Periodicraft.CreateOreBlock(
			"Neodymium Ore", 4.6F, 4.5F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.COMMON);

	public static BlockOre BlockNickelOre = Periodicraft.CreateOreBlock(
			"Nickel Ore", 3.8F, 4.1F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.SUBTLE);

	public static BlockOre BlockMagnesiumOre = Periodicraft.CreateOreBlock(
			"Magnesium Ore", 2.1F, 3.1F, 2, LightValue, LightOpacity, 0,
			EnumBlockRarity.UNCOMMON, Periodicraft.ItemMagnesiumDust.itemID,
			random.nextInt(3) + 3);

	public static BlockOre BlockBoronOre = Periodicraft.CreateOreBlock(
			"Boron Ore", 5.4F, 6.8F, 3, LightValue, LightOpacity, 0,
			EnumBlockRarity.SUBTLE);

	public static BlockOre BlockBerylliumOre = Periodicraft.CreateOreBlock(
			"Beryllium Ore", 6.4F, 5.3F, 4, LightValue, LightOpacity, 0,
			EnumBlockRarity.RARE);

	public static BlockOre BlockLithiumOre = Periodicraft.CreateOreBlock(
			"LithiumOre", 4.6F, 4.3F, 2, LightValue, LightOpacity, 0,
			EnumBlockRarity.SUBTLE);

	// ARMOR

	public static final EnumArmorMaterial BERRYLLIUM_ARMOR = PeriodicraftItemArmor
			.addArmorType("Berryllium", 38, new int[] { 4, 9, 7, 3 }, 12);

	public static PeriodicraftItemArmor BerrylliumArmorHelmet = Periodicraft
			.CreateArmor("Berryllium Helmet", BERRYLLIUM_ARMOR, 2, 0);

	public static PeriodicraftItemArmor BerrylliumArmorChest = Periodicraft
			.CreateArmor("Berryllium Chestplate", BERRYLLIUM_ARMOR, 2, 1);

	public static PeriodicraftItemArmor BerrylliumArmorLegs = Periodicraft
			.CreateArmor("Berryllium Leggings", BERRYLLIUM_ARMOR, 2, 2);

	public static PeriodicraftItemArmor BerrylliumArmorBoots = Periodicraft
			.CreateArmor("Berryllium Boots", BERRYLLIUM_ARMOR, 2, 3);

	// Tools

	public static final EnumToolMaterial TUNGSTEN = PeriodicraftItemTool
			.addToolType("Tungsten", 1750, 12, 4, 8.5F, 4.0F);

	public static PeriodicraftItemPickaxe TungstenPickaxe = Periodicraft
			.CreatePickaxe("Tungsten Pickaxe", TUNGSTEN);

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

		GameRegistry.registerWorldGenerator(WGen);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone),
				Block.sand, Block.gravel, Block.dirt, Block.dirt);

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
		BlockLithiumOre.addSmeltingRecipe(ItemLithiumIngot, 3.1F);

		GameRegistry.addShapelessRecipe(new ItemStack(
				Periodicraft.ItemMagnesiumIngot),
				Periodicraft.ItemMagnesiumDust, Periodicraft.ItemMagnesiumDust,
				Periodicraft.ItemMagnesiumDust, Periodicraft.ItemMagnesiumDust);

		GameRegistry.addShapelessRecipe(new ItemStack(
				Periodicraft.ItemSteelIngot), Periodicraft.ItemCarbonDust,
				Item.ingotIron);

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
			float LightValue, int LightOpacity, int dimension,
			EnumBlockRarity rarity, int Drop, int count) {
		BlockOre block = Periodicraft.CreateOreBlock(UnlocalizedName, Hardness,
				Resistance, HarvestLevel, LightValue, LightOpacity, dimension,
				rarity);
		block.setDropAndCount(Drop, count);
		return block;
	}

	public static BlockOre CreateOreBlock(String UnlocalizedName,
			float Hardness, float Resistance, int HarvestLevel,
			float LightValue, int LightOpacity, int dimension,
			EnumBlockRarity rarity) {
		BlockOre block = new BlockOre(ID.id());
		block.setUnlocalizedName(UnlocalizedName).setHardness(Hardness)
				.setResistance(Resistance).setCreativeTab(
						Periodicraft.tabBlocks).setLightValue(LightValue)
				.setTextureName("periodicraft:" + UnlocalizedName)
				.setLightOpacity(LightOpacity);
		MinecraftForge.setBlockHarvestLevel(block, "pickaxe", HarvestLevel);
		GameRegistry.registerBlock(block, UnlocalizedName);
		block.addToSurfaceGen(rarity, block);
		block.setDropAndCount(block.blockID, 1);
		return block;
	}

	public static BlockSimple CreateSimpleBlock(Material par2Material,
			CreativeTabs CreativeTab, String UnlocalizedName, float Hardness,
			float Resistance, float LightValue, int LightOpacity) {
		BlockSimple block = new BlockSimple(ID.id(), par2Material);
		block.setUnlocalizedName(UnlocalizedName).setHardness(Hardness)
				.setResistance(Resistance).setCreativeTab(CreativeTab)
				.setLightValue(LightValue).setLightOpacity(LightOpacity)
				.setTextureName("periodicraft:" + UnlocalizedName);
		return block;
	}

	public static ItemIngot CreateItemIngot(String UnlocalizedName,
			CreativeTabs CreativeTab) {
		ItemIngot ingot = new ItemIngot(ID.id(), UnlocalizedName, CreativeTab);
		ingot.setTextureName("periodicraft:" + UnlocalizedName);
		return ingot;
	}

	public static ItemDust CreateItemDust(String UnlocalizedName,
			CreativeTabs CreativeTab) {
		ItemDust dust = new ItemDust(ID.id(), UnlocalizedName, CreativeTab);
		dust.setTextureName("periodicraft:" + UnlocalizedName);
		return dust;
	}

	public static PeriodicraftItemArmor CreateArmor(String UnlocalizedName,
			EnumArmorMaterial Material, int armorType, int RenderIndex) {
		PeriodicraftItemArmor armor = new PeriodicraftItemArmor(ID.id(),
				Material, armorType, RenderIndex);
		armor.setTextureName("periodicraft:" + UnlocalizedName)
				.setUnlocalizedName(UnlocalizedName).setMaxStackSize(1)
				.setCreativeTab(Periodicraft.tabArmor);
		return armor;
	}

	public static PeriodicraftItemPickaxe CreatePickaxe(String UnlocalizedName,
			EnumToolMaterial Material) {
		PeriodicraftItemPickaxe pick = new PeriodicraftItemPickaxe(ID.id(),
				Material);
		pick.setUnlocalizedName(UnlocalizedName).setCreativeTab(tabTools)
				.setTextureName(
						"periodicraft:" + UnlocalizedName);
		return pick;
	}

	public static void name(PeriodicraftBlock block) {
		LanguageRegistry.addName(block, block.UnlocalizedName);
	}

	public static void name(PeriodicraftItem item) {
		LanguageRegistry.addName(item, item.UnlocalizedName);
	}

	public static void name(Object obj, String name) {
		LanguageRegistry.addName(obj, name);
	}
}
